package compareEngine;

public class HandlerConcat implements IBase {
	
	public String get2_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\"}");
	}

	
	public String get3_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"field_3\":\"value_3\"}");
	}

	
	public String get4_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"field_3\":\"value_3\",\"field_4\":\"value_4\"}");
	}

	
	public String get5_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"field_3\":\"value_3\",\"field_4\":\"value_4\",\"field_5\":\"value_5\"}");
	}

	
	public String get2_fields_JObj_2_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\"}}");
	}

	
	public String get2_fields_JObj_3_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\",\"JO_field_3\":\"JO_value_3\"}}");
	}

	
	public String get3_fields_JObj_2_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"field_3\":\"value_3\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\"}}");
	}

	
	public String get3_fields_JObj_3_fields(int id, String symbol) {
		String s="";
		return s.concat("{\"field_1\":").concat(String.valueOf(id)).concat(",\"field_2\":\"").concat(symbol).concat("\",\"field_3\":\"value_3\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\",\"JO_field_3\":\"JO_value_3\"}}");
	}
}
