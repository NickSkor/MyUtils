package compareEngine;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		General general = new General(5500); //Count items to subscribes
		//general.beginReportSB_Json_writeTofile();
		general.beginReport4Engine_writeTofile();
		//general.beginReportSB_Json();
		//general.beginReport();
	}
}
