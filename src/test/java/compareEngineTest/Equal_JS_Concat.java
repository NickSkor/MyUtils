package compareEngineTest;

import com.google.gson.Gson;
import compareEngine.HandlerConcat;
import compareEngine.HandlerJson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Equal_JS_Concat {

	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerConcat concat = new HandlerConcat();
	private String symbol = "ETH/BTC";
	private int id = 1;

	@Test
	public void testGet2_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String ConcatResult=concat.get2_fields(id,symbol);

		assertEquals(JsonResult, ConcatResult);
	}

	@Test
	public void testGet3_fields() throws Exception{
		String JsonResult=json.get3_fields(id,symbol);
		String SBResult=concat.get3_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet4_fields() throws Exception{
		String JsonResult=json.get4_fields(id,symbol);
		String SBResult=concat.get4_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet5_fields() throws Exception{
		String JsonResult=json.get5_fields(id,symbol);
		String SBResult=concat.get5_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet2_fields_JObj_2_fields() throws Exception{
		String JsonResult=json.get2_fields_JObj_2_fields(id,symbol);
		String SBResult=concat.get2_fields_JObj_2_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet2_fields_JObj_3_fields() throws Exception{
		String JsonResult=json.get2_fields_JObj_3_fields(id,symbol);
		String SBResult=concat.get2_fields_JObj_3_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet3_fields_JObj_2_fields() throws Exception{
		String JsonResult=json.get3_fields_JObj_2_fields(id,symbol);
		String SBResult=concat.get3_fields_JObj_2_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}

	@Test
	public void testGet3_fields_JObj_3_fields() throws Exception{
		String JsonResult=json.get3_fields_JObj_3_fields(id,symbol);
		String SBResult=concat.get3_fields_JObj_3_fields(id,symbol);

		assertEquals(JsonResult, SBResult);
	}
}
