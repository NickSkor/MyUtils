package compareEngine;

public class InfoToFile_4Fields {
	private int count;
	private long millSB;
	private long millJackson;
	private long millDslJson;
	private long millInerJson;
	private long nanoSB;
	private long nanoJackson;
	private long nanoDslJson;
	private long nanoInerJson;


	public InfoToFile_4Fields(int count, long millSB, long millJackson, long millDslJson, long millInerJson, long nanoSB, long nanoJackson, long nanoDslJson, long nanoInerJson) {
		this.count = count;
		this.millSB = millSB;
		this.millJackson = millJackson;
		this.millDslJson = millDslJson;
		this.millInerJson = millInerJson;
		this.nanoSB = nanoSB;
		this.nanoJackson = nanoJackson;
		this.nanoDslJson = nanoDslJson;
		this.nanoInerJson = nanoInerJson;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getMillSB() {
		return millSB;
	}

	public void setMillSB(long millSB) {
		this.millSB = millSB;
	}

	public long getMillJackson() {
		return millJackson;
	}

	public void setMillJackson(long millJackson) {
		this.millJackson = millJackson;
	}

	public long getMillDslJson() {
		return millDslJson;
	}

	public void setMillDslJson(long millDslJson) {
		this.millDslJson = millDslJson;
	}

	public long getMillInerJson() {
		return millInerJson;
	}

	public void setMillInerJson(long millInerJson) {
		this.millInerJson = millInerJson;
	}

	public long getNanoSB() {
		return nanoSB;
	}

	public void setNanoSB(long nanoSB) {
		this.nanoSB = nanoSB;
	}

	public long getNanoJackson() {
		return nanoJackson;
	}

	public void setNanoJackson(long nanoJackson) {
		this.nanoJackson = nanoJackson;
	}

	public long getNanoDslJson() {
		return nanoDslJson;
	}

	public void setNanoDslJson(long nanoDslJson) {
		this.nanoDslJson = nanoDslJson;
	}

	public long getNanoInerJson() {
		return nanoInerJson;
	}

	public void setNanoInerJson(long nanoInerJson) {
		this.nanoInerJson = nanoInerJson;
	}
}
