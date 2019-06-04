package compareEngine;

import java.text.MessageFormat;

public class HandlerMessageFormat implements IBase {

	
	public String get2_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\"{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get3_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"field_3\":\"value_3\"{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get4_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"field_3\":\"value_3\",\"field_4\":\"value_4\"{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get5_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"field_3\":\"value_3\",\"field_4\":\"value_4\",\"field_5\":\"value_5\"{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get2_fields_JObj_2_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"JsonObj\":{2}\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\"{3}{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get2_fields_JObj_3_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"JsonObj\":{2}\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\",\"JO_field_3\":\"JO_value_3\"{3}{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get3_fields_JObj_2_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"field_3\":\"value_3\",\"JsonObj\":{2}\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\"{3}{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}

	
	public String get3_fields_JObj_3_fields(int id, String symbol) {
		MessageFormat pattern = new MessageFormat("{2}\"field_1\":{0},\"field_2\":\"{1}\",\"field_3\":\"value_3\",\"JsonObj\":{2}\"JO_field_1\":\"JO_value_1\",\"JO_field_2\":\"JO_value_2\",\"JO_field_3\":\"JO_value_3\"{3}{3}");
		Object[] arguments = {id, symbol, new String("{"), new String("}")};
		return pattern.format(arguments);
	}
}
