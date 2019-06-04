package compareEngine;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class General {
	private static String fileReport = "report.html";
	private static String fileReport2 = "report_4fields_2.html";
	private final Logger logger = LoggerFactory.getLogger(General.class);
	private HandlerMessageFormat messageFormat = new HandlerMessageFormat();
	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerStringBuilder stringBuilder = new HandlerStringBuilder();
	private HandlerVelocity velocity = new HandlerVelocity();
	private HandlerCommonsLang commonsLang = new HandlerCommonsLang();
	private HandlerConcat concat = new HandlerConcat();
	private HandlerDslJson dslJson = new HandlerDslJson();
	private HandlerJsoniter jsonIter = new HandlerJsoniter();
	private HandlerJackson jackson = new HandlerJackson();

	private List<String> list = new ArrayList<String>();
	private List<InfoToFile> listInfo = new ArrayList<InfoToFile>();
	private List<InfoToFile_3Fields> listInfo_3Fields = new ArrayList<InfoToFile_3Fields>();
	private List<InfoToFile_4Fields> listInfo_4Fields = new ArrayList<InfoToFile_4Fields>();

	private int countItems;

	public void setCountItems(int countItems) {
		this.countItems = countItems;
	}


	public General(int countItems) {
		this.countItems = countItems;
	}

	private void createList() {
		for (int i = 0; i < countItems; i++)
			list.add("test_" + i);
	}

	public void beginReport() {
		logger.info(" ============================ Report Result =============================");
		logger.info("| Count of items= {}, (iterations in the loop), working milliseconds    |", countItems);
		logger.info(" ========================================================================");
		logger.info("|StringBuilder | Json | MessageFormat|  Velocity |  CommonsLang  | Concat|");
		logger.info(" ========================================================================");
		get2_fields();
		get3_fields();
		get4_fields();
		get5_fields();
		get2_fields_JObj_2_fields();
		get2_fields_JObj_3_fields();
		get3_fields_JObj_2_fields();
		get3_fields_JObj_3_fields();
		logger.info("=========================================================================");
		logger.info("\n");
	}

	public void beginReportSB_Json() {

		logger.info(" =====================================================================================================");
		logger.info("|                                      | System.currentTimeMillis() |        System.nanoTime()        |");
		logger.info("|  Count of items to subscribes        |       milliseconds         |           nanoseconds           |");
		logger.info("|          (10 fields)                 |==============================================================");
		logger.info("|                                      | StringBuilder |     Json   |   StringBuilder |       Json    |");
		logger.info(" =====================================================================================================");
		get10_fieldsSB(50);
		get10_fieldsSB(100);
		get10_fieldsSB(200);
		get10_fieldsSB(500);
		get10_fieldsSB(1500);
		get10_fieldsSB(2000);
		get10_fieldsSB(8000);
		get10_fieldsSB(10000);
		get10_fieldsSB(20000);
		get10_fieldsSB(50000);
		get10_fieldsSB(100000);
		get10_fieldsSB(200000);
		get10_fieldsSB(500000);
		get10_fieldsSB(1000000);
		logger.info(" =====================================================================================================");
		logger.info("\n");
	}


	public void beginReportSB_3Fields() throws IOException {
		get10_fieldsSB_DslJson_JsonInner(50);
		get10_fieldsSB_DslJson_JsonInner(100);
		get10_fieldsSB_DslJson_JsonInner(200);
		get10_fieldsSB_DslJson_JsonInner(500);
		get10_fieldsSB_DslJson_JsonInner(1500);
		/*get10_fieldsSB_DslJson_JsonInner(2000);
		get10_fieldsSB_DslJson_JsonInner(8000);
		get10_fieldsSB_DslJson_JsonInner(10000);
		get10_fieldsSB_DslJson_JsonInner(20000);
		get10_fieldsSB_DslJson_JsonInner(50000);
		get10_fieldsSB_DslJson_JsonInner(100000);*/
		/*get10_fieldsSB_DslJson_JsonInner(200000);
		get10_fieldsSB_DslJson_JsonInner(500000);
		get10_fieldsSB_DslJson_JsonInner(1000000);*/

	}

	public void beginReport4Engine() throws IOException {
		get_10_fields_Engine4(50);
		get_10_fields_Engine4(100);
		get_10_fields_Engine4(200);
		get_10_fields_Engine4(500);
		get_10_fields_Engine4(1500);
		get_10_fields_Engine4(2000);
		get_10_fields_Engine4(8000);
		get_10_fields_Engine4(10000);
		get_10_fields_Engine4(20000);
		get_10_fields_Engine4(50000);
		get_10_fields_Engine4(100000);
		/*get_10_fields_Engine4(200000);
		get_10_fields_Engine4(500000);
		get_10_fields_Engine4(1000000);*/

	}


	public void beginReportSB_Json_writeTofile() throws IOException {
		beginReportSB_Json();
		FileWriter fileReport = new FileWriter(General.fileReport);
		fileReport.write("<body> \n<table border=\"1\">\n");

		fileReport.write("<tr>\n");
		fileReport.write("<td  rowspan=\"2\"> Count of items to subscribes (10 fields) </td>\n");
		fileReport.write("<th  colspan=\"2\"> System.currentTimeMillis(), milliseconds </th>\n");
		fileReport.write("<th  colspan=\"2\"> System.nanoTime(), nanoseconds </th>\n");
		fileReport.write("</tr>\n");
		fileReport.write("<th>StringBuilder</th><th>Json</th><th>StringBuilder</th><th>Json</th>\n");


		for (InfoToFile info : listInfo) {
			fileReport.write("<tr>\n");
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td > Count of items = %,9d</td>\n", info.getCount()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillSB()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillJS()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,11d</td>\n", info.getNanoSB()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,14d</td>\n", info.getNanoJS()));
			fileReport.write("</tr>\n");
		}

		fileReport.write("</table><body>\n ");
		fileReport.close();

	}

	public void beginReportSB_2Compare_writeTofile() throws IOException {

		beginReportSB_3Fields();
		FileWriter fileReport = new FileWriter(General.fileReport2);
		fileReport.write("<body> \n<table border=\"1\">\n");

		fileReport.write("<tr>\n");
		fileReport.write("<td  rowspan=\"2\" align=\"center\"> <b>Count of items to subscribes (10 fields) </b></td>\n");
		fileReport.write("<th  colspan=\"3\"> System.currentTimeMillis(), milliseconds </th>\n");
		fileReport.write("<th  colspan=\"3\"> System.nanoTime(), nanoseconds </th>\n");
		fileReport.write("</tr>\n");
		fileReport.write("<th>Jackson</th><th>DslJson</th><th>JsonIner</th><th>Jackson</th><th>DslJson</th><th>JsonIner</th>\n");


		for (InfoToFile_3Fields info : listInfo_3Fields) {
			fileReport.write("<tr>\n");
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td > Count of items = %,9d</td>\n", info.getCount()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillSB()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillDslJson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillInerJson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,11d</td>\n", info.getNanoSB()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,11d</td>\n", info.getNanoDslJson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,11d</td>\n", info.getNanoInerJson()));

			fileReport.write("</tr>\n");
		}

		fileReport.write("</table><body>\n ");
		fileReport.close();

	}

	public void beginReport4Engine_writeTofile() throws IOException {

		beginReport4Engine();
		FileWriter fileReport = new FileWriter(General.fileReport2);
		fileReport.write("<body> \n<table border=\"1\">\n");

		fileReport.write("<tr>\n");
		fileReport.write("<th  rowspan=\"2\"> Count of items to subscribes (10 fields) </th>\n");
		fileReport.write("<th  colspan=\"4\"> System.currentTimeMillis(), milliseconds </th>\n");
		fileReport.write("<th  colspan=\"4\"> System.nanoTime(), nanoseconds </th>\n");
		fileReport.write("</tr>\n");
		fileReport.write("<th>StringBuilder</th><th>Jackson</th><th>DslJson</th><th>JsonIner</th><th>StringBuilder</th><th>Jackson</th><th>DslJson</th><th>JsonIner</th>\n");


		for (InfoToFile_4Fields info : listInfo_4Fields) {
			fileReport.write("<tr>\n");
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td > Count of items = %,9d</td>\n", info.getCount()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillSB()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillJackson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillDslJson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"center\">%,7d</td>\n", info.getMillInerJson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,15d</td>\n", info.getNanoSB()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,15d</td>\n", info.getNanoJackson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,15d</td>\n", info.getNanoDslJson()));
			fileReport.write(String.format(Locale.CANADA_FRENCH, "\t<td align=\"right\">%,15d</td>\n", info.getNanoInerJson()));

			fileReport.write("</tr>\n");
		}

		fileReport.write("</table><body>\n ");
		fileReport.close();

	}


	public void get10_fieldsSB(int countItems) {
		setCountItems(countItems);
		createList();
		long longBeginSB = System.currentTimeMillis();
		long nanoBeginSB = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get2_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		long nanoEndSB = System.nanoTime();

		long longSB = longEndSB - longBeginSB;
		long nanoSB = nanoEndSB - nanoBeginSB;

		// Json
		long longBeginJS = System.currentTimeMillis();
		long nanoBeginJS = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			json.get2_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		long nanoEndJS = System.nanoTime();

		long longJS = longEndJS - longBeginJS;
		long nanoJS = nanoEndJS - nanoBeginJS;
		listInfo.add(new InfoToFile(countItems, longSB, longJS, nanoSB, nanoJS));
		String text = String.format(Locale.CANADA_FRENCH, "| Count of items =  %,10d         |     %,7d   | %,7d    |     %,11d | %,13d |", countItems, longSB, longJS, nanoSB, nanoJS);
		logger.info(text);
	}

	public void get_10_fields_Engine4(int countItems) throws IOException {
		setCountItems(countItems);
		createList();

		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		long nanoBeginSB = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get10_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		long nanoEndSB = System.nanoTime();

		long longSB = longEndSB - longBeginSB;
		long nanoSB = nanoEndSB - nanoBeginSB;

		// Jackson
		long longBeginJack = System.currentTimeMillis();
		long nanoBeginJack = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			jackson.get10_fields(i, list.get(i));
		}
		long longEndJack = System.currentTimeMillis();
		long nanoEndJack = System.nanoTime();

		long longJack = longEndJack - longBeginJack;
		long nanoJack = nanoEndJack - nanoBeginJack;

		// DslJson
		long longBeginDslJson = System.currentTimeMillis();
		long nanoBeginDslJson = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			dslJson.get10_fields(i, list.get(i));
		}
		long longEndDslJson = System.currentTimeMillis();
		long nanoEndDslJson = System.nanoTime();

		long longDslJson = longEndDslJson - longBeginDslJson;
		long nanoDslJson = nanoEndDslJson - nanoBeginDslJson;

		//JsonInner
		long longBeginJsonIner = System.currentTimeMillis();
		long nanoBeginJsonIner = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			jsonIter.get10_fields(i, list.get(i));
		}
		long longEndJsonIner = System.currentTimeMillis();
		long nanoEndJsonIner = System.nanoTime();

		long longJsonIner = longEndJsonIner - longBeginJsonIner;
		long nanoJsonIner = nanoEndJsonIner - nanoBeginJsonIner;

		listInfo_4Fields.add(new InfoToFile_4Fields(countItems, longSB,longJack, longDslJson, longJsonIner, nanoSB, nanoJack,nanoDslJson, nanoJsonIner));
	}

	public void get10_fieldsSB_DslJson_JsonInner(int countItems) throws IOException {
		setCountItems(countItems);
		createList();
		long longBeginSB = System.currentTimeMillis();
		long nanoBeginSB = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			jackson.get10_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		long nanoEndSB = System.nanoTime();

		long longSB = longEndSB - longBeginSB;
		long nanoSB = nanoEndSB - nanoBeginSB;

		// DslJson
		long longBeginDslJson = System.currentTimeMillis();
		long nanoBeginDslJson = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			dslJson.get10_fields(i, list.get(i));
		}
		long longEndDslJson = System.currentTimeMillis();
		long nanoEndDslJson = System.nanoTime();

		long longDslJson = longEndDslJson - longBeginDslJson;
		long nanoDslJson = nanoEndDslJson - nanoBeginDslJson;

		//JsonInner
		long longBeginJsonIner = System.currentTimeMillis();
		long nanoBeginJsonIner = System.nanoTime();
		for (int i = 0; i < list.size(); i++) {
			jsonIter.get10_fields(i, list.get(i));
		}
		long longEndJsonIner = System.currentTimeMillis();
		long nanoEndJsonIner = System.nanoTime();

		long longJsonIner = longEndJsonIner - longBeginJsonIner;
		long nanoJsonIner = nanoEndJsonIner - nanoBeginJsonIner;

		listInfo_3Fields.add(new InfoToFile_3Fields(countItems, longSB, longDslJson, longJsonIner, nanoSB, nanoDslJson, nanoJsonIner));
	}


	public void get2_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get2_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get2_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get2_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get2_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get2_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get2_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;
		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get3_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get3_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get3_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get3_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get3_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get3_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get3_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get4_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get4_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get4_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get4_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get4_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get4_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get4_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get5_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get5_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get5_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get5_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get5_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get5_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get5_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get2_fields_JObj_2_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get2_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get2_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get2_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get2_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get2_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get2_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get2_fields_JObj_3_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get2_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get2_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get2_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get2_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get2_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get2_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get3_fields_JObj_2_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get3_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get3_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get3_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get3_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get3_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get3_fields_JObj_2_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}

	public void get3_fields_JObj_3_fields() {
		createList();
		// StringBuilder
		long longBeginSB = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			stringBuilder.get3_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndSB = System.currentTimeMillis();
		;
		long longSB = longEndSB - longBeginSB;
		// Json
		long longBeginJS = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			json.get3_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndJS = System.currentTimeMillis();
		;
		long longJS = longEndJS - longBeginJS;
		// MessageFormat
		long longBeginMF = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			messageFormat.get3_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndMF = System.currentTimeMillis();
		;
		long longMF = longEndMF - longBeginMF;
		// Velocity
		long longBeginVelocity = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			velocity.get3_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndVelocity = System.currentTimeMillis();
		;
		long longVelocity = longEndVelocity - longBeginVelocity;
		//CommonsLang
		long longBeginCommon = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			commonsLang.get3_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndCommon = System.currentTimeMillis();
		;
		long longCommon = longEndCommon - longBeginCommon;
		//Concat
		long longBeginConcat = System.currentTimeMillis();
		;
		for (int i = 0; i < list.size(); i++) {
			concat.get3_fields_JObj_3_fields(i, list.get(i));
		}
		long longEndConcat = System.currentTimeMillis();
		;
		long longConcat = longEndConcat - longBeginConcat;

		String text = String.format("|    %5d     |%5d |   %5d      |   %5d   |     %5d     | %5d |", longSB, longJS, longMF, longVelocity, longCommon, longConcat);
		logger.info(text);
	}
}
