package compareEngine;

public class HandlerStringBuilder implements IBase {
	
	public String get2_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\"}").toString();
	}

	
	public String get3_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"field_3\":\"value_3\"}").toString();
	}

	
	public String get4_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"field_3\":\"value_3\",\"field_4\":\"value_4\"}").toString();
	}

	
	public String get5_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
								.append(",\"field_2\":\"").append(symbol)
								.append("\",\"field_3\":\"value_3\",\"field_4\":\"value_4\",\"field_5\":\"value_5\"}").toString();
	}

	
	public String get2_fields_JObj_2_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\"}}").toString();
	}

	
	public String get2_fields_JObj_3_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\",\"JO_field_3\":\"JO_value_3\"}}").toString();
	}

	
	public String get3_fields_JObj_2_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"field_3\":\"value_3")
				.append("\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\"}}").toString();
	}

	
	public String get3_fields_JObj_3_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"field_3\":\"value_3")
				.append("\",\"JsonObj\":{\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\",\"JO_field_3\":\"JO_value_3\"}}").toString();
	}

	public String get10_fields(int id, String symbol) {
		return new StringBuilder("{\"field_1\":").append(id)
				.append(",\"field_2\":\"").append(symbol)
				.append("\",\"field_3\":\"value_3\",\"field_4\":\"value_4\",\"field_5\":\"value_5\"")
				.append(",\"field_6\":\"value_6\",\"field_7\":\"value_7\",\"field_8\":\"value_8\"")
				.append(",\"field_9\":\"value_9\",\"field_10\":\"value_10\"}").toString();
	}

}
