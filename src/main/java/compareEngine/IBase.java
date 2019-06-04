package compareEngine;

import java.io.IOException;

interface IBase {

	 String get2_fields(int id, String symbol) throws IOException;
	 String get3_fields(int id, String symbol);
	 String get4_fields(int id, String symbol);
	 String get5_fields(int id, String symbol);
	 String get2_fields_JObj_2_fields(int id, String symbol);
	 String get2_fields_JObj_3_fields(int id, String symbol);
	 String get3_fields_JObj_2_fields(int id, String symbol);
	 String get3_fields_JObj_3_fields(int id, String symbol);
}
