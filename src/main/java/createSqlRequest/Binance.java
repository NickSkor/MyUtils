package createSqlRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Binance implements IRespone {
	private static int connectorId = 9;
	private static Map<String, Integer> mapAssets = new HashMap<>();
	private static String fileAssets = "binance_assets.sql";
	private static String fileSymbols = "binance_symbols.sql";

	@Override
	public void createRequests() throws IOException {
		createRequests(APIConstants.BINANCE_INFO);
	}

	@Override
	public Map<String, Integer> createMapSymbols(String url) {
		return null;
	}

	@Override
	public Map<String, Integer> createMapAssets(String url) {
		return null;
	}

	@Override
	public void createRequests(String url) throws IOException {
		FileWriter assetsFile = new FileWriter(fileAssets);
		FileWriter symbolsFile = new FileWriter(fileSymbols);
		String response = Utils.getResponse(url);

		JSONObject jsonObject = new org.json.JSONObject(response);
		JSONArray jsonArray = jsonObject.getJSONArray("symbols");
		int z = connectorId * 1000 + 1;
		int zSymbols = connectorId * 1000 + 1;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			String sym1 = jsonObj.getString("baseAsset");
			String sym2 = jsonObj.getString("quoteAsset");
			if (!mapAssets.containsKey(sym1)) {
				mapAssets.put(sym1, z);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
						.append(z + "," + connectorId + ",")
						.append("\'t\',\'" + sym1 + "\'," + 8 + "," + 8 + "," + 4 + ");\n");
				assetsFile.write(stringBuilder.toString());
				z++;
			}

			if (!mapAssets.containsKey(sym2)) {
				mapAssets.put(sym2, z);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("INSERT INTO \"public\".assets  VALUES (")
						.append(z + "," + connectorId + ",")
						.append("\'t\',\'" + sym2 + "\'," + 8 + "," + 8 + "," + 4 + ");\n");

				assetsFile.write(stringBuilder.toString());
				z++;
			}
			StringBuilder stringBuilderSymbols = new StringBuilder();
			stringBuilderSymbols.append("INSERT INTO \"public\".symbols  VALUES (")
					.append(zSymbols + "," + connectorId + ",")
					.append("\'t\',\'" + sym1 + "/" + sym2 + "\'," + 4 + "," + 8 + "," + 8 + "," + mapAssets.get(sym1) + "," + mapAssets.get(sym2) + ");\n");
			symbolsFile.write(stringBuilderSymbols.toString());
			zSymbols++;
		}

		assetsFile.close();
		symbolsFile.close();
	}
}
