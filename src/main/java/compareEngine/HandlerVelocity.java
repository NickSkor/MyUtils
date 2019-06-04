package compareEngine;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;

public class HandlerVelocity implements IBase {
	VelocityContext velocity = new VelocityContext();


	
	public String get2_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\"}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get3_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("field_3", "value_3");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"field_3\":\"$field_3\"}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get4_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("field_3", "value_3");
		velocity.put("field_4", "value_4");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"field_3\":\"$field_3\",\"field_4\":\"$field_4\"}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get5_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("field_3", "value_3");
		velocity.put("field_4", "value_4");
		velocity.put("field_5", "value_5");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"field_3\":\"$field_3\",\"field_4\":\"$field_4\",\"field_5\":\"$field_5\"}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get2_fields_JObj_2_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("JO_field_1", "JO_value_1");
		velocity.put("JO_field_2", "JO_value_2");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"JsonObj\":{\"JO_field_1\":\"$JO_field_1\",\"JO_field_2\":\"$JO_field_2\"}}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get2_fields_JObj_3_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("JO_field_1", "JO_value_1");
		velocity.put("JO_field_2", "JO_value_2");
		velocity.put("JO_field_3", "JO_value_3");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"JsonObj\":{\"JO_field_1\":\"$JO_field_1\",\"JO_field_2\":\"$JO_field_2\",\"JO_field_3\":\"$JO_field_3\"}}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get3_fields_JObj_2_fields(int id, String symbol) {
		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("field_3", "value_3");
		velocity.put("JO_field_1", "JO_value_1");
		velocity.put("JO_field_2", "JO_value_2");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"field_3\":\"$field_3\",\"JsonObj\":{\"JO_field_1\":\"$JO_field_1\",\"JO_field_2\":\"$JO_field_2\"}}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}

	
	public String get3_fields_JObj_3_fields(int id, String symbol) {

		velocity.put("field_1", id);
		velocity.put("field_2", symbol);
		velocity.put("field_3", "value_3");
		velocity.put("JO_field_1", "JO_value_1");
		velocity.put("JO_field_2", "JO_value_2");
		velocity.put("JO_field_3", "JO_value_3");

		StringWriter w = new StringWriter();
		String  template= "{\"field_1\":$field_1,\"field_2\":\"$field_2\",\"field_3\":\"$field_3\",\"JsonObj\":{\"JO_field_1\":\"$JO_field_1\",\"JO_field_2\":\"$JO_field_2\",\"JO_field_3\":\"$JO_field_3\"}}";
		Velocity.evaluate(velocity, w, "templateName", template);
		return w.toString();
	}
}
