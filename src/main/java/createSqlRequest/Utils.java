package createSqlRequest;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
	private Utils(){}

	public static String getResponse(String uri) throws IOException {
		HttpGet req = new HttpGet(uri);
		req.setHeader("User-Agent", "DEFAULT_USER_AGENT");
		try (CloseableHttpClient client = HttpClients.createDefault();
			 CloseableHttpResponse response = client.execute(req)) {
			InputStream inputStream = response.getEntity().getContent();
			return IOUtils.toString(inputStream);
		}
	}
}
