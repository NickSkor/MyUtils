package createSqlRequest;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Binance binance = new Binance();
		binance.createRequests();
		Bitmart bitmart = new Bitmart();
		bitmart.createRequests();
		HitBTC hitBTC = new HitBTC();
		hitBTC.createRequests();
	}
}
