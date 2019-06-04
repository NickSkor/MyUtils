package compareEngine;

import org.apache.commons.lang.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class HandlerCommonsLang implements IBase {
	private Map valueMap = new HashMap();

	public String get2_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\"}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get3_fields(int id, String symbol) {
		String result;
		//Map valueMap = new HashMap();
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);
		valueMap.put("field_3", "value_3");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"field_3\":\"${field_3}\"}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get4_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);
		valueMap.put("field_3", "value_3");
		valueMap.put("field_4", "value_4");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"field_3\":\"${field_3}\",\"field_4\":\"${field_4}\"}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get5_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);
		valueMap.put("field_3", "value_3");
		valueMap.put("field_4", "value_4");
		valueMap.put("field_5", "value_5");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"field_3\":\"${field_3}\",\"field_4\":\"${field_4}\",\"field_5\":\"${field_5}\"}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get2_fields_JObj_2_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);

		valueMap.put("JsonObject_1", "JO_value_1");
		valueMap.put("JsonObject_2", "JO_value_2");
		valueMap.put("JsonObject_3", "JO_value_3");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"JsonObj\":{\"JO_field_1\":\"${JsonObject_1}\",\"JO_field_2\":\"${JsonObject_2}\"}}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get2_fields_JObj_3_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);

		valueMap.put("JsonObject_1", "JO_value_1");
		valueMap.put("JsonObject_2", "JO_value_2");
		valueMap.put("JsonObject_3", "JO_value_3");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"JsonObj\":{\"JO_field_1\":\"${JsonObject_1}\",\"JO_field_2\":\"${JsonObject_2}\",\"JO_field_3\":\"${JsonObject_3}\"}}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get3_fields_JObj_2_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);
		valueMap.put("field_3", "value_3");
		valueMap.put("JsonObject_1", "JO_value_1");
		valueMap.put("JsonObject_2", "JO_value_2");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"field_3\":\"${field_3}\",\"JsonObj\":{\"JO_field_1\":\"${JsonObject_1}\",\"JO_field_2\":\"${JsonObject_2}\"}}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}

	
	public String get3_fields_JObj_3_fields(int id, String symbol) {
		String result;
		valueMap.clear();
		valueMap.put("field_1", id);
		valueMap.put("field_2", symbol);
		valueMap.put("field_3", "value_3");
		valueMap.put("JsonObject_1", "JO_value_1");
		valueMap.put("JsonObject_2", "JO_value_2");
		valueMap.put("JsonObject_3", "JO_value_3");
		String templateString = "{\"field_1\":${field_1},\"field_2\":\"${field_2}\",\"field_3\":\"${field_3}\",\"JsonObj\":{\"JO_field_1\":\"${JsonObject_1}\",\"JO_field_2\":\"${JsonObject_2}\",\"JO_field_3\":\"${JsonObject_3}\"}}";
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		result=sub.replace(templateString);
		return result;
	}
}
