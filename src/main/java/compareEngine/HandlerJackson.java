package compareEngine;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class HandlerJackson implements IBase{
	public static void main(String[] args) throws IOException {
		HandlerJackson jackson = new HandlerJackson();
		System.out.println(jackson.get2_fields(1,"abc"));
	}

	public String get2_fields(int id, String symbol) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JsonFactory jfactory = new JsonFactory();
		JsonGenerator jGenerator = jfactory	.createGenerator(stream, JsonEncoding.UTF8);
		jGenerator.writeStartObject();
		jGenerator.writeNumberField("field_1",id);
		jGenerator.writeStringField("field_2",symbol);
		jGenerator.close();

		return new String(stream.toByteArray(), "UTF-8");
	}

	public String get10_fields(int id, String symbol) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JsonFactory jfactory = new JsonFactory();
		JsonGenerator jGenerator = jfactory	.createGenerator(stream, JsonEncoding.UTF8);
		jGenerator.writeStartObject();
		jGenerator.writeNumberField("field_1",id);
		jGenerator.writeStringField("field_2",symbol);
		jGenerator.writeStringField("field_3","value_3");
		jGenerator.writeStringField("field_4","value_4");
		jGenerator.writeStringField("field_5","value_5");
		jGenerator.writeStringField("field_6","value_6");
		jGenerator.writeStringField("field_7","value_7");
		jGenerator.writeStringField("field_8","value_8");
		jGenerator.writeStringField("field_9","value_9");
		jGenerator.writeStringField("field_10","value_10");
		jGenerator.close();

		return new String(stream.toByteArray(), "UTF-8");
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
}
