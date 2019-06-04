package compareEngineTest;

import com.google.gson.Gson;
import compareEngine.HandlerJson;
import compareEngine.HandlerVelocity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Equal_JS_Velocity {

	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerVelocity velocity = new HandlerVelocity();
	private String symbol = "ETH/BTC";
	private int id = 1;

	@Test
	public void testGet2_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String VelocityResult=velocity.get2_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet3_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String VelocityResult=velocity.get2_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet4_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String VelocityResult=velocity.get2_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet5_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String VelocityResult=velocity.get2_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet2_fields_JObj_2_fields() throws Exception{
		String JsonResult=json.get2_fields_JObj_2_fields(id,symbol);
		String VelocityResult=velocity.get2_fields_JObj_2_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet2_fields_JObj_3_fields() throws Exception{
		String JsonResult=json.get2_fields_JObj_3_fields(id,symbol);
		String VelocityResult=velocity.get2_fields_JObj_3_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet3_fields_JObj_2_fields() throws Exception{
		String JsonResult=json.get3_fields_JObj_2_fields(id,symbol);
		String VelocityResult=velocity.get3_fields_JObj_2_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}

	@Test
	public void testGet3_fields_JObj_3_fields() throws Exception{
		String JsonResult=json.get3_fields_JObj_3_fields(id,symbol);
		String VelocityResult=velocity.get3_fields_JObj_3_fields(id,symbol);

		assertEquals(JsonResult, VelocityResult);
	}
}
