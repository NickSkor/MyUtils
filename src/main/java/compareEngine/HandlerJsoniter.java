package compareEngine;


import com.jsoniter.JsonIterator;
import com.jsoniter.annotation.JsonProperty;
import com.jsoniter.any.Any;
import com.jsoniter.output.JsonStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class HandlerJsoniter implements IBase {
	@JsonProperty(required = true)
	public int field1;
	@JsonProperty(required = true)
	public int field2;
	@JsonProperty(required = true)
	public int field3;


	public static void main(String[] args) throws IOException {
		System.out.println("asdcas");
		Any obj = JsonIterator.deserialize("[1,2,3]");
		System.out.println(obj.get(2));
		int[] array = JsonIterator.deserialize("[1,2,3]", int[].class);
		System.out.println(array[2]);
		System.out.println("=============");


		Any iter2 = JsonIterator.deserialize("{'field1':101,'field2':101,'field3':101}".getBytes());
		System.out.println(iter2.toString());
		HandlerJsoniter jsoniter = new HandlerJsoniter();
		System.out.println(jsoniter.get2_fields(1,"asdeq555"));

	}

	public String get2_fields(int id, String symbol) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("field_1",id);
		map.put("field_2",symbol);
		return JsonStream.serialize(map);
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



	public String get10_fields(int id, String symbol) {
		Map<String,Object> map = new LinkedHashMap<String, Object>();
		map.put("field_1",id);
		map.put("field_2",symbol);
		map.put("field_3","value_3");
		map.put("field_4","value_4");
		map.put("field_5","value_5");
		map.put("field_6","value_6");
		map.put("field_7","value_7");
		map.put("field_8","value_8");
		map.put("field_9","value_9");
		map.put("field_10","value_10");
		return JsonStream.serialize(map);
	}

}
