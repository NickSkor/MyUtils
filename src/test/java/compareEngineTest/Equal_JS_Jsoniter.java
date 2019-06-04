package compareEngineTest;

import com.google.gson.Gson;
import compareEngine.HandlerJson;
import compareEngine.HandlerJsoniter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Equal_JS_Jsoniter {
	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerJsoniter jsoniter = new HandlerJsoniter();
	private String symbol = "ETH/BTC";
	private int id = 1;

	@Test
	public void testGet2_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String JsonIter=jsoniter.get2_fields(id,symbol);

		assertEquals(JsonResult, JsonIter);
	}

	@Test
	public void testGet10_fields() throws Exception{
		String JsonResult=json.get10_fields(id,symbol);
		String JsonIter=jsoniter.get10_fields(id,symbol);

		assertEquals(JsonResult, JsonIter);
	}
}
