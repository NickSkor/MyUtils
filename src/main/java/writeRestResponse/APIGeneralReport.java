package writeRestResponse;

public interface APIGeneralReport {
	//1  - GEMINI -
	String GEMINI_SYMBOLS = "https://api.sandbox.gemini.com/v1/symbols";

	//2  - BITFINEX
	String BITFINEX_SYMBOLS = "https://api.bitfinex.com/v1/symbols_details";

	//3  - HITBTC
	String HITBTC_ASSETS =  "https://api.hitbtc.com/api/2/public/currency";
	String HITBTC_SYMBOLS = "https://api.hitbtc.com/api/2/public/symbol";

	//6  - CEX
	String CEX_SYMBOLS = "https://cex.io/api/currency_limits";

	//7  - BITTREX
	String BITTREX_ASSETS = "https://api.bittrex.com/api/v1.1/public/getcurrencies";
	String BITTREX_SYMBOLS = "https://bittrex.com/api/v1.1/public/getmarkets";

	//8  - HUOBI
	String HUOBI_ASSETS  = "https://api.huobi.pro/v1/common/currencys";
	String HUOBI_SYMBOLS = "https://api.huobi.pro/v1/common/symbols";

	//9  - BINANCE
	String BINANCE_SYMBOLS = "https://api.binance.com/api/v1/exchangeInfo";

	//10 - BITMART
	String BITMART_ASSETS  = "https://openapi.bitmart.com/v2/currencies";
	String BITMART_SYMBOLS = "https://openapi.bitmart.com/v2/symbols";
	String BITMART_SYMBOLS_DETAIL = "https://openapi.bitmart.com/tickers/market_cap";

	//11 - COINBASE
	String COINBASE_ASSETS =  "https://api.pro.coinbase.com/currencies";
	String COINBASE_SYMBOLS = "https://api.pro.coinbase.com/products";

	//12 - OKEX
	String OKEX_SYMBOLS = "https://www.okex.com/api/spot/v3/instruments";
	String OKEX_FUTURES = "https://www.okex.com/api/futures/v3/instruments/ticker";

	//13 - GATE
	String GATE_SYMBOLS = "https://data.gateio.io/api2/1/pairs";
	String GATE_SYMBOLS_DETAIL = "https://data.gateio.io/api2/1/marketinfo";

	//14 - BITFLYER (-)
	String BITFLYER_INFO = "https://lightning.bitflyer.com/v1/getmarkets"; // json-files  need  VPN

	//15 - ITBITs
	//String ITBIT_INFO = ""; // 6 symbols

	//16 - BITMEX
	String BITMEX_SYMBOLS = "https://www.bitmex.com/api/bitcoincharts";
	String BITMEX_SYMBOLS_DETAIL ="https://www.bitmex.com/api/v1/instrument/active";

	//17 - BITSTAMP
	String BITSTAMP_SYMBOLS = "https://www.bitstamp.net/api/v2/trading-pairs-info";

	//18 - KRAKEN
	String KRAKEN_ASSETS    = "https://api.kraken.com/0/public/Assets";
	String KRAKEN_SYMBOLS   = "https://api.kraken.com/0/public/AssetPairs";

	//19 - COINFLOOR
	//20 - COINSUPER
	//21 - LGO

	//22 - BLOCKTRADE
	String BLOCKTRADE_ASSETS = "https://trade.blocktrade.com/api/v1/trading_assets";
	String BLOCKTRADE_SYMBOLS = "https://trade.blocktrade.com/api/v1/trading_pairs";

	//23 - BEQUANT
	String BEQUANT_ASSETS = "https://api.bequant.io/api/2/public/currency";
	String BEQUANT_SYMBOLS = "https://api.bequant.io/api/2/public/symbol";

	//24 - EXMO
	String EXMO_ASSETS = "https://api.exmo.com/v1/currency/";
	String EXMO_SYMBOLS = "https://api.exmo.com/v1/pair_settings/";

	//50 - YOBIT
	String YOBIT_SYMBOLS = "https://yobit.net/api/3/info";
}
