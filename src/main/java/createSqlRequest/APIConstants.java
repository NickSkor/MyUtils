package createSqlRequest;

public interface APIConstants {

	//1  - GEMINI
	String GEMINI_INFO = "https://api.sandbox.gemini.com/v1/symbols";
	String GEMINI_SNAP_SHOT = "https://api.gemini.com/v1/book/REPLACE_SYMBOL";

	//2  - BITFINEX
	String BITFINEX_INFO = "https://api.bitfinex.com/v1/symbols_details";
	String BITFINEX_SNAP_SHOT = "https://api.bitfinex.com/v1/book/REPLACE_SYMBOL";

	//3  - HITBTC
	String HITBTC_INFO = "https://api.hitbtc.com/api/2/public/symbol";
	String HITBTC_SNAP_SHOT = "https://api.hitbtc.com/api/2/public/orderbook/REPLACE_SYMBOL";

	//6  - CEX
	String CEX_INFO = "https://cex.io/api/currency_limits";
	String CEX_SNAP_SHOT = "https://cex.io/api/order_book/REPLACE_SYMBOL1/REPLACE_SYMBOL2";
	String CEX_SNAP_SHOT_NEW = "https://cex.io/api/order_book/REPLACE_SYMBOL";

	//7  - BITTREX
	String BITTREX_INFO = "https://bittrex.com/api/v1.1/public/getmarkets";
	String BITTREX_SNAP_SHOT ="https://bittrex.com/api/v1.1/public/getorderbook?market=REPLACE_SYMBOL&type=both";

	//8  - HUOBI
	//String HUOBI_ASSETS  = "https://api.huobi.com/v1/common/currencys"; (Huobi US (HBUS) )
	//String HUOBI_SYMBOLS = "https://api.huobi.com/v1/common/symbols";    Huobi US (HBUS)
	//String HUOBI_SNAP_SHOT = "https://api.huobi.com/market/depth?symbol=REPLACE_SYMBOL&type=step1";  (Huobi US (HBUS))
	String HUOBI_ASSETS  = "https://api.huobi.pro/v1/common/currencys";
	String HUOBI_SYMBOLS = "https://api.huobi.pro/v1/common/symbols";
	String HUOBI_SNAP_SHOT = "https://api.huobi.pro/market/depth?symbol=REPLACE_SYMBOL&type=step1";

	//9  - BINANCE
	String BINANCE_INFO = "https://api.binance.com/api/v1/exchangeInfo";
	String BINANCE_SNAP_SHOT = "https://www.binance.com/api/v1/depth?symbol=REPLACE_SYMBOL&limit=100";

	//10 - BITMART
	String BITMART_ASSETS = "https://openapi.bitmart.com/v2/currencies";
	String BITMART_SYMBOLS_LIST = "https://openapi.bitmart.com/v2/symbols";
	String BITMART_SYMBOLS_DETAIL = "https://openapi.bitmart.com/v2/symbols_details";
	String BITMART_INFO = "https://openapi.bitmart.com/tickers/market_cap"; // old info
	String BITMART_SNAP_SHOT = "https://openapi.bitmart.com/v2/symbols/REPLACE_SYMBOL/orders?precision=";

	//11 - COINBASE
	String GDAX_INFO = "https://api.gdax.com/products";
	String COINBASE_INFO = "https://api.pro.coinbase.com/products";
	String COINBASE_SNAP_SHOT = "https://api.pro.coinbase.com/products/REPLACE_SYMBOL/book?level=2";

	//12 - OKEX
	String OKEX_INFO_FUTURES = "https://www.okex.com/api/futures/v3/instruments/ticker";
	String OKEX_INFO = "https://www.okex.com/api/spot/v3/instruments";
	String OKEX_SNAP_SHOT = "https://www.okex.com/api/v1/depth.do?symbol=REPLACE_SYMBOL";

	//13 - GATE
	String GATE_PAIRS = "https://data.gateio.io/api2/1/pairs";
	String GATE_INFO = "https://data.gateio.io/api2/1/marketinfo";
	String GATE_SNAP_SHOT = "https://data.gateio.io/api2/1/orderBook/REPLACE_SYMBOL";

	//14 - BITFLYER
	String BITFLYER_INFO = "https://lightning.bitflyer.com/v1/getmarkets"; // json-files  need  VPN

	//15 - ITBITs
	//String ITBIT_INFO = ""; // 6 symbols
	String ITBIT_SNAP_SHOT = "https://api.itbit.com/v1/markets/REPLACE_SYMBOL/order_book";

	//16 - BITMEX
	String BITMEX_INFO = "https://www.bitmex.com/api/v1/instrument?count=500&reverse=false";
	String BITMEX_INFO_ACTIVE ="https://www.bitmex.com/api/v1/instrument/active";
	String BITMEX_SNAP_SHOT = "https://www.bitmex.com/api/v1/orderBook/L2?symbol=REPLACE_SYMBOL&depth=100";

	//17 - BITSTAMP
	String BITSTAMP_INFO = "https://www.bitstamp.net/api/v2/trading-pairs-info";  // --Only info
	String BITSTAMP_SNAP_SHOT = "https://www.bitstamp.net/api/v2/order_book/REPLACE_SYMBOL/";

	//18 - KRAKEN
	String KRAKEN_ASSETS    = "https://api.kraken.com/0/public/Assets";
	String KRAKEN_SYMBOLS   = "https://api.kraken.com/0/public/AssetPairs";
	String KRAKEN_SNAP_SHOT = "https://api.kraken.com/0/public/Depth?pair=REPLACE_SYMBOL&count=100";

	//19 - COINFLOOR
	String COINFLOOR_API = "https://github.com/coinfloor/API/blob/master/SCALE.md";
	String COINFLOOR_SNAP_SHOT = "https://webapi.coinfloor.co.uk/bist/REPLACE_SYMBOL/order_book/";

	//20 - COINSUPER
	// API info =

	//21 - LGO

	//22 - BLOCKTRADE
	String BLOCKTRADE_ASSETS = "https://trade.blocktrade.com/api/v1/trading_assets";
	String BLOCKTRADE_PAIRS = "https://trade.blocktrade.com/api/v1/trading_pairs";
	String BLOCKTRADE_SNAP_SHOT = "https://trade.blocktrade.com/api/v1/order_book/REPLACE_ID";

	//23 - BEQUANT
	String BEQUANT_ASSETS = "https://api.bequant.io/api/2/public/currency";
	String BEQUANT_PAIRS = "https://api.bequant.io/api/2/public/symbol";
	String BEQUANT_SNAP_SHOT = "https://api.bequant.io/api/2/public/orderbook/REPLACE_SYMBOL";


	//24 - EXMO
	String EXMO_ASSETS = "https://api.exmo.com/v1/currency/";
	String EXMO_PAIRS = "https://api.exmo.com/v1/pair_settings/";
	String EXMO_SNAP_SHOT = "https://api.exmo.com/v1/order_book/?pair=REPLACE_SYMBOL&limit=1000";


	//50 - YOBIT

	String YOBIT_PAIRS = "https://yobit.net/api/3/info";
	String YOBIT_SNAP_SHOT = "https://yobit.net/api/3/depth/REPLACE_SYMBOL";

}
