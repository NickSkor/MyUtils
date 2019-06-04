package createSqlRequest;

import java.io.IOException;
import java.util.Map;

public interface IRespone {
	public Map<String, Integer> createMapSymbols(String url);
	public Map<String, Integer> createMapAssets(String url) throws IOException;
	public void createRequests(String url) throws IOException;
	public void createRequests() throws IOException;
}
