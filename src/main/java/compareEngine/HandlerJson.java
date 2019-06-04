package compareEngine;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class HandlerJson implements IBase {
	private Gson gson;

	public HandlerJson(Gson gson) {
		this.gson = gson;
	}

	
	public String get2_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		return gson.toJson(result);

	}

	
	public String get3_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		result.addProperty("field_3", "value_3");
		return gson.toJson(result);
	}

	
	public String get4_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		result.addProperty("field_3", "value_3");
		result.addProperty("field_4", "value_4");
		return gson.toJson(result);
	}

	
	public String get5_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		result.addProperty("field_3", "value_3");
		result.addProperty("field_4", "value_4");
		result.addProperty("field_5", "value_5");
		return gson.toJson(result);
	}

	
	public String get2_fields_JObj_2_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);

		JsonObject JOobj = new JsonObject();
		JOobj.addProperty("JO_field_1", "JO_value_1");
		JOobj.addProperty("JO_field_2", "JO_value_2");
		result.add("JsonObj", JOobj);

		return gson.toJson(result);
	}

	
	public String get2_fields_JObj_3_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);

		JsonObject JOobj = new JsonObject();
		JOobj.addProperty("JO_field_1", "JO_value_1");
		JOobj.addProperty("JO_field_2", "JO_value_2");
		JOobj.addProperty("JO_field_3", "JO_value_3");
		result.add("JsonObj", JOobj);

		return gson.toJson(result);
	}

	
	public String get3_fields_JObj_2_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		result.addProperty("field_3", "value_3");

		JsonObject JOobj = new JsonObject();
		JOobj.addProperty("JO_field_1", "JO_value_1");
		JOobj.addProperty("JO_field_2", "JO_value_2");
		result.add("JsonObj", JOobj);

		return gson.toJson(result);
	}

	
	public String get3_fields_JObj_3_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		result.addProperty("field_3", "value_3");

		JsonObject JOobj = new JsonObject();
		JOobj.addProperty("JO_field_1", "JO_value_1");
		JOobj.addProperty("JO_field_2", "JO_value_2");
		JOobj.addProperty("JO_field_3", "JO_value_3");
		result.add("JsonObj", JOobj);

		return gson.toJson(result);
	}

	public String get10_fields(int id, String symbol) {
		JsonObject result = new JsonObject();
		result.addProperty("field_1", id);
		result.addProperty("field_2", symbol);
		result.addProperty("field_3", "value_3");
		result.addProperty("field_4", "value_4");
		result.addProperty("field_5", "value_5");
		result.addProperty("field_6", "value_6");
		result.addProperty("field_7", "value_7");
		result.addProperty("field_8", "value_8");
		result.addProperty("field_9", "value_9");
		result.addProperty("field_10", "value_10");
		return gson.toJson(result);
	}
}
