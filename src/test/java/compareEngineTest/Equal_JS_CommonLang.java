package compareEngineTest;

import com.google.gson.Gson;
import compareEngine.HandlerCommonsLang;
import compareEngine.HandlerJson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Equal_JS_CommonLang {

	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerCommonsLang commonsLang = new HandlerCommonsLang();
	private String symbol = "ETH/BTC";
	private int id = 1;

	@Test
	public void testGet2_fields() throws Exception {
		String JsonResult = json.get2_fields(id, symbol);
		String CommonLangResult = commonsLang.get2_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet3_fields() throws Exception {
		String JsonResult = json.get3_fields(id, symbol);
		String CommonLangResult = commonsLang.get3_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet4_fields() throws Exception {
		String JsonResult = json.get4_fields(id, symbol);
		String CommonLangResult = commonsLang.get4_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet5_fields() throws Exception {
		String JsonResult = json.get5_fields(id, symbol);
		String CommonLangResult = commonsLang.get5_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet2_fields_JObj_2_fields() throws Exception {
		String JsonResult = json.get2_fields_JObj_2_fields(id, symbol);
		String CommonLangResult = commonsLang.get2_fields_JObj_2_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet2_fields_JObj_3_fields() throws Exception {
		String JsonResult = json.get2_fields_JObj_3_fields(id, symbol);
		String CommonLangResult = commonsLang.get2_fields_JObj_3_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet3_fields_JObj_2_fields() throws Exception {
		String JsonResult = json.get3_fields_JObj_2_fields(id, symbol);
		String CommonLangResult = commonsLang.get3_fields_JObj_2_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}

	@Test
	public void testGet3_fields_JObj_3_fields() throws Exception {
		String JsonResult = json.get3_fields_JObj_3_fields(id, symbol);
		String CommonLangResult = commonsLang.get3_fields_JObj_3_fields(id, symbol);

		assertEquals(JsonResult, CommonLangResult);
	}
}
