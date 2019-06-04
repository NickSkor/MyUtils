package createSqlRequest;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HitBTC implements IRespone {
	private static int connectorId = 3;
	private static List<String> listSymbols = new ArrayList<>();
	private static Map<String, Integer> mapAssets = new HashMap<>();
	private static Map<String, HitBTCElement> mapSuperSymbols = new HashMap<>();
	private static String fileAssets = "HitBTC_assets.sql";
	private static String fileSymbols = "HitBTC_symbols.sql";


	@Override
	public Map<String, Integer> createMapSymbols(String url) {
		return null;
	}

	@Override
	public Map<String, Integer> createMapAssets(String url) throws IOException {

		FileWriter assetsFile = new FileWriter(fileAssets);
		Map<String, Integer> map = new HashMap<>();
		String response = Utils.getResponse(url);
		JSONArray jsonArray = new JSONArray(response);
		int z = connectorId * 1000 + 1;
		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String symbol = jsonObj.getString("id");
			String sym1 = jsonObj.getString("baseCurrency");
			String sym2 = jsonObj.getString("quoteCurrency");

			HitBTCElement hitElement = new HitBTCElement(sym1, sym2);
			if (symbol.equals(sym1 + sym2)) {
				mapSuperSymbols.put(symbol, hitElement);
			} else if (symbol.equals(sym1 + "USDT")) {
				hitElement = new HitBTCElement(sym1, "USDT");
				mapSuperSymbols.put(symbol, hitElement);
			} else if (symbol.equals("USDT" + sym2)) {
				hitElement = new HitBTCElement("USDT", sym2);
				mapSuperSymbols.put(symbol, hitElement);
			} else if (symbol.equals("BCCF" + sym2)) {
				hitElement = new HitBTCElement("BCCF", sym2);
				mapSuperSymbols.put(symbol, hitElement);
			} else if (symbol.equals(sym1 + "BCCF")) {
				hitElement = new HitBTCElement(sym1, "BCCF");
				mapSuperSymbols.put(symbol, hitElement);
			} else {
				System.out.println(symbol);
			}

			listSymbols.add(sym1 + "/" + sym2);
			if (!map.containsKey(sym1)) {
				map.put(sym1, z);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
						.append(z + "," + connectorId + ",")
						.append("\'t\',\'" + sym1 + "\'," + 8 + "," + 8 + "," + 4 + ");\n");

				assetsFile.write(stringBuilder.toString());
				z++;
			}

			if (!map.containsKey(sym2)) {
				map.put(sym2, z);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
						.append(z + "," + connectorId + ",")
						.append("\'t\',\'" + sym2 + "\'," + 8 + "," + 8 + "," + 4 + ");\n");

				assetsFile.write(stringBuilder.toString());
				z++;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
				.append(z + "," + connectorId + ",")
				.append("\'t\',\'" + "BCCF" + "\'," + 8 + "," + 8 + "," + 4 + ");\n");
		assetsFile.write(stringBuilder.toString());
		map.put("BCCF", z);
		z++;

		stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
				.append(z + "," + connectorId + ",")
				.append("\'t\',\'" + "USDT" + "\'," + 8 + "," + 8 + "," + 4 + ");\n");
		assetsFile.write(stringBuilder.toString());
		map.put("USDT", z);
		z++;

		assetsFile.close();
		return map;
	}

	@Override
	public void createRequests(String url) throws IOException {

	}

	@Override
	public void createRequests() throws IOException {
		mapAssets = createMapAssets(APIConstants.HITBTC_INFO);
		scriptSymbols();
	}

	private static void scriptSymbols() throws IOException {
		FileWriter symbolsFile = new FileWriter(fileSymbols);
		int zSymbols = connectorId * 1000 + 1;

		for (String symbol : mapSuperSymbols.keySet()) {
			String response = Utils.getResponse(APIConstants.HITBTC_SNAP_SHOT.
					replace("REPLACE_SYMBOL", symbol.replace("/", "")));
			JSONObject jsonArray = new JSONObject(response);
			JSONArray jsonArrayAsk = null;
			if (jsonArray.has("ask"))
				jsonArrayAsk = jsonArray.getJSONArray("ask");

			JSONArray jsonArrayBids = null;
			if (jsonArray.has("bid"))
				jsonArrayBids = jsonArray.getJSONArray("bid");

			int maxPrice = 0;
			int maxSize = 0;

			if (jsonArrayAsk != null) {
				for (int i = 0; i < jsonArrayAsk.length(); i++) {
					JSONObject jsonAskObj = jsonArrayAsk.getJSONObject(i);

					String price = jsonAskObj.getString("price");
					BigDecimal priceBig = new BigDecimal(price);
					if (priceBig.scale() > maxPrice)
						maxPrice = priceBig.scale();

					String size = jsonAskObj.getString("size");
					BigDecimal sizeBig = new BigDecimal(size);
					if (sizeBig.scale() > maxSize)
						maxSize = sizeBig.scale();
				}
			}

			if (jsonArrayBids != null) {
				for (int i = 0; i < jsonArrayBids.length(); i++) {
					JSONObject jsonBidObj = jsonArrayBids.getJSONObject(i);

					String price = jsonBidObj.getString("price");
					BigDecimal priceBig = new BigDecimal(price);
					if (priceBig.scale() > maxPrice)
						maxPrice = priceBig.scale();

					String size = jsonBidObj.getString("size");
					BigDecimal sizeBig = new BigDecimal(size);
					if (sizeBig.scale() > maxSize)
						maxSize = sizeBig.scale();
				}
			}

			HitBTCElement element = mapSuperSymbols.get(symbol);
			String sym0 = element.getAsBase();
			String sym1 = element.getAsQuote();
			String symbol1 = sym0 + "/" + sym1;
			StringBuilder stringBuilderSymbols = new StringBuilder();
			stringBuilderSymbols.append("INSERT INTO \"public\".symbols  VALUES (")
					.append(zSymbols + "," + connectorId + ",")
					.append("\'t\',\'" + symbol1 + "\'," + 4 + "," + maxPrice + "," + maxSize + "," + mapAssets.get(sym0) + "," + mapAssets.get(sym1) + ");\n");
			symbolsFile.write(stringBuilderSymbols.toString());
			zSymbols++;
		}
		symbolsFile.close();
	}

	public static class HitBTCElement {
		public String asBase;
		public String asQuote;

		public HitBTCElement(String asBase, String asQuote) {
			this.asBase = asBase;
			this.asQuote = asQuote;
		}

		public String getAsBase() {
			return asBase;
		}

		public void setAsBase(String asBase) {
			this.asBase = asBase;
		}

		public String getAsQuote() {
			return asQuote;
		}

		public void setAsQuote(String asQuote) {
			this.asQuote = asQuote;
		}
	}
}
