package compareEngine;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.JsonWriter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class HandlerDslJson implements IBase {


	public static void main(String[] args) throws IOException {
		System.out.println("dfaswf");
		HandlerDslJson dslJson = new HandlerDslJson();
		System.out.println(dslJson.get2_fields(1, "fsd"));
	}

	public String get2_fields(int id, String symbol) throws IOException {
		DslJson<Object> json = new DslJson<Object>();
		JsonWriter writer = json.newWriter();
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		map.put("field_1", id);
		map.put("field_2", symbol);
		json.serialize(writer, map);
		return writer.toString();
	}


	public String get3_fields(int id, String symbol) {
		return null;
	}

	public String get4_fields(int id, String symbol) {
		return null;
	}

	public String get5_fields(int id, String symbol) {
		return null;
	}

	public String get2_fields_JObj_2_fields(int id, String symbol) {
		return null;
	}

	public String get2_fields_JObj_3_fields(int id, String symbol) {
		return null;
	}

	public String get3_fields_JObj_2_fields(int id, String symbol) {
		return null;
	}

	public String get3_fields_JObj_3_fields(int id, String symbol) {
		return null;
	}

	public String get10_fields(int id, String symbol) throws IOException {
		DslJson<Object> json = new DslJson<Object>();
		JsonWriter writer = json.newWriter();
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		map.put("field_1", id);
		map.put("field_2", symbol);
		map.put("field_3","value_3");
		map.put("field_4","value_4");
		map.put("field_5","value_5");
		map.put("field_6","value_6");
		map.put("field_7","value_7");
		map.put("field_8","value_8");
		map.put("field_9","value_9");
		map.put("field_10","value_10");
		json.serialize(writer, map);
		return writer.toString();

	}
}
