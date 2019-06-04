package compareEngine;

public class InfoToFile_3Fields {
	private int count;
	private long millSB;
	private long millDslJson;
	private long millInerJson;
	private long nanoSB;
	private long nanoDslJson;
	private long nanoInerJson;


	public InfoToFile_3Fields(int count, long millSB, long millDslJson, long millInerJson, long nanoSB, long nanoDslJson, long nanoInerJson) {
		this.count = count;
		this.millSB = millSB;
		this.millDslJson = millDslJson;
		this.millInerJson = millInerJson;
		this.nanoSB = nanoSB;
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
