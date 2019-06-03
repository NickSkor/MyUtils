package writeRestResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ResponeInfo {
	private String directoryName = "ResponseFromExchanges_";

	public void createReportInfo() throws Exception {
		String dataReport = new SimpleDateFormat("dd-MM-yyyy_HH:mm").format(new Date());
		Path rootDirectory = Paths.get(directoryName + dataReport);
		Files.createDirectories(rootDirectory);

		funcResponse(APIGeneralReport.GEMINI_SYMBOLS, "Gemini_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITFINEX_SYMBOLS, "Bitfinex_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.HITBTC_ASSETS, "HitBTC_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.HITBTC_SYMBOLS, "HitBTC_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.CEX_SYMBOLS, "CEXio_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITTREX_ASSETS, "Bittrex_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITTREX_SYMBOLS, "Bittrex_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.HUOBI_ASSETS, "Huobi_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.HUOBI_SYMBOLS, "Huobi_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BINANCE_SYMBOLS, "Binance_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITMART_ASSETS, "Bitmart_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITMART_SYMBOLS, "Bitmart_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITMART_SYMBOLS_DETAIL, "Bitmart_SymbolsDetail", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.COINBASE_ASSETS, "Coinbase_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.COINBASE_SYMBOLS, "Coinbase_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.OKEX_SYMBOLS, "OKEx_Symbols", rootDirectory, dataReport);
		//funcResponse(APIGeneralReport.OKEX_FUTURES, "OKEx_Futures", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.GATE_SYMBOLS, "Gate_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.GATE_SYMBOLS_DETAIL, "Gate_SymbolsDetail", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITMEX_SYMBOLS, "Bitmex_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITMEX_SYMBOLS_DETAIL, "Bitmex_SymbolsDetail", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BITSTAMP_SYMBOLS, "BitStamp_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.KRAKEN_ASSETS, "Kraken_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.KRAKEN_SYMBOLS, "Kraken_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BLOCKTRADE_ASSETS, "BlockTrade_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BLOCKTRADE_SYMBOLS, "BlockTrade_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BEQUANT_ASSETS, "Bequant_Assets", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.BEQUANT_SYMBOLS, "Bequant_Symbols", rootDirectory, dataReport);
		funcResponse(APIGeneralReport.YOBIT_SYMBOLS, "Yobit_Symbols", rootDirectory, dataReport);

		ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("zipArchive_"+dataReport));

		addToArchive(zout,rootDirectory);

		zout.close();
	}



	public void funcResponse(String url, String nameFile, Path derictory, String dataStr) throws IOException {
		Path path = Files.createFile(Paths.get(derictory.toAbsolutePath().toString() + "/" + nameFile + "_" + dataStr + ".txt"));
		String response = getUrl(url);
		FileWriter fileWriter = new FileWriter(path.toFile());
		fileWriter.write(response);
		fileWriter.close();
	}

	private static String getUrl(String uri) throws IOException {
		HttpGet req = new HttpGet(uri);
		req.setHeader("User-Agent", "DEFAULT_USER_AGENT");
		try (CloseableHttpClient client = HttpClients.createDefault();
			 CloseableHttpResponse response = client.execute(req)) {
			InputStream inputStream = response.getEntity().getContent();
			return IOUtils.toString(inputStream);
		}
	}

	public void addToArchive(ZipOutputStream zipOutputStream, Path derictory) throws Exception {
		if (Files.isDirectory(derictory)) {
			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(derictory)) {
				for (Path file : directoryStream) {
					try (InputStream inputStream = Files.newInputStream(file)) {
						ZipEntry entry = new ZipEntry(file.getFileName().toString());

						zipOutputStream.putNextEntry(entry);
						copyData(inputStream, zipOutputStream);
						zipOutputStream.closeEntry();
					}
				}
			}
		}
	}

	private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
		Path fullPath = filePath.resolve(fileName);
		try (InputStream inputStream = Files.newInputStream(fullPath)) {
			ZipEntry entry = new ZipEntry(fileName.toString());

			zipOutputStream.putNextEntry(entry);

			copyData(inputStream, zipOutputStream);

			zipOutputStream.closeEntry();
		}
	}

	private void copyData(InputStream in, OutputStream out) throws Exception {
		byte[] buffer = new byte[8 * 1024];
		int len;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
	}

}
