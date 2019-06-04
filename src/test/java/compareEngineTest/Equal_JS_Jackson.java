package compareEngineTest;

import com.google.gson.Gson;
import compareEngine.HandlerJackson;
import compareEngine.HandlerJson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Equal_JS_Jackson {
	private HandlerJson json = new HandlerJson(new Gson());
	private HandlerJackson jackson = new HandlerJackson();
	private String symbol = "ETH/BTC";
	private int id = 1;

	@Test
	public void testGet2_fields() throws Exception{
		String JsonResult=json.get2_fields(id,symbol);
		String JsonIter=jackson.get2_fields(id,symbol);

		assertEquals(JsonResult, JsonIter);
	}

	@Test
	public void testGet10_fields() throws Exception{
		String JsonResult=json.get10_fields(id,symbol);
		String JsonIter=jackson.get10_fields(id,symbol);

		assertEquals(JsonResult, JsonIter);
	}
}
