package createSqlRequest;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bitmart implements IRespone {
	private static int connectorId = 10;
	private static Map<String, Integer> mapAssets = new HashMap<>();
	private static Map<String, Integer> mapSymbols = new HashMap<>();
	private static String fileAssets = "bitmart_assets.sql";
	private static String fileSymbols = "bitmart_symbols.sql";

	@Override
	public void createRequests() throws IOException {
		mapAssets = createMapAssets(APIConstants.BITMART_SYMBOLS_DETAIL);
		createRequests(APIConstants.BITMART_SYMBOLS_DETAIL);
	}

	@Override
	public Map<String, Integer> createMapSymbols(String url) {
		return null;
	}

	@Override
	public Map<String, Integer> createMapAssets(String url) throws IOException {
		Map<String, Integer> map = new HashMap<>();
		int z = connectorId * 1000 + 1;
		FileWriter assetsFile = new FileWriter(fileAssets);
		String response = Utils.getResponse(url);
		JSONArray jsonArray = new JSONArray(response);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String symbolBase = jsonObj.getString("base_currency");
			String symbolQuote = jsonObj.getString("quote_currency");

			if (!map.containsKey(symbolBase)) {

				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
						.append(z + "," + connectorId + ",")
						.append("\'t\',\'" + symbolBase.toUpperCase() + "\'," + 8 + "," + 8 + "," + 4 + ");\n");
				assetsFile.write(stringBuilder.toString());
				map.put(symbolBase, z);
				z++;
			}

			if (!map.containsKey(symbolQuote)) {

				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
						.append(z + "," + connectorId + ",")
						.append("\'t\',\'" + symbolQuote.toUpperCase() + "\'," + 8 + "," + 8 + "," + 4 + ");\n");
				assetsFile.write(stringBuilder.toString());
				map.put(symbolQuote, z);
				z++;
			}
		}
		assetsFile.close();
		return map;
	}

	@Override
	public void createRequests(String url) throws IOException {

		FileWriter symbolsFile = new FileWriter(fileSymbols);
		int z = connectorId * 1000 + 1;

		String response = Utils.getResponse(url);
		JSONArray jsonArray = new JSONArray(response);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);

			String symbol = jsonObj.getString("id").replace("_", "/");
			String symbolBase = jsonObj.getString("base_currency");
			String symbolQuote = jsonObj.getString("quote_currency");
			Integer priceFactor = jsonObj.getInt("price_max_precision");
			String size = jsonObj.getString("quote_increment");
			BigDecimal sizeB = new BigDecimal(size);
			Integer sizeFactor = sizeB.scale();

			StringBuilder stringBuilderSymbols = new StringBuilder();
			stringBuilderSymbols.append("INSERT INTO \"public\".symbols  VALUES (")
					.append(z + "," + connectorId + ",")
					.append("\'t\',\'" + symbol + "\'," + 4 + "," + priceFactor + "," + sizeFactor + "," +
							mapAssets.get(symbolBase) + "," + mapAssets.get(symbolQuote) + ");\n");
			symbolsFile.write(stringBuilderSymbols.toString());
			z++;
		}
		symbolsFile.close();
	}
}