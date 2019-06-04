package compareEngineTest;

import com.google.gson.Gson;
import compareEngine.HandlerJson;
import compareEngine.HandlerStringBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Equal_JS_SB {

	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerStringBuilder stringBuilder = new HandlerStringBuilder();
	private String symbol = "ETH/BTC";
	private int id = 1;

	@Test
	public void testGet2_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String SBResult=stringBuilder.get2_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet3_fields() throws Exception{
		String JsonResult=json.get3_fields(id,symbol);
		String SBResult=stringBuilder.get3_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet4_fields() throws Exception{
		String JsonResult=json.get4_fields(id,symbol);
		String SBResult=stringBuilder.get4_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet5_fields() throws Exception{
		String JsonResult=json.get5_fields(id,symbol);
		String SBResult=stringBuilder.get5_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet2_fields_JObj_2_fields() throws Exception{
		String JsonResult=json.get2_fields_JObj_2_fields(id,symbol);
		String SBResult=stringBuilder.get2_fields_JObj_2_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet2_fields_JObj_3_fields() throws Exception{
		String JsonResult=json.get2_fields_JObj_3_fields(id,symbol);
		String SBResult=stringBuilder.get2_fields_JObj_3_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet3_fields_JObj_2_fields() throws Exception{
		String JsonResult=json.get3_fields_JObj_2_fields(id,symbol);
		String SBResult=stringBuilder.get3_fields_JObj_2_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet3_fields_JObj_3_fields() throws Exception{
		String JsonResult=json.get3_fields_JObj_3_fields(id,symbol);
		String SBResult=stringBuilder.get3_fields_JObj_3_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet10_fields() throws Exception{
		String JsonResult=json.get10_fields(id,symbol);
		String SBResult=stringBuilder.get10_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}
}
