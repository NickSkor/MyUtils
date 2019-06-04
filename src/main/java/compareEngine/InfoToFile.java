package compareEngine;

public class InfoToFile {
	private int count;
	private long millSB;
	private long millJS;
	private long nanoSB;
	private long nanoJS;

	public InfoToFile(int count, long millSB, long millJS, long nanoSB, long nanoJS) {
		this.count = count;
		this.millSB = millSB;
		this.millJS = millJS;
		this.nanoSB = nanoSB;
		this.nanoJS = nanoJS;
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

	public long getMillJS() {
		return millJS;
	}

	public void setMillJS(long millJS) {
		this.millJS = millJS;
	}

	public long getNanoSB() {
		return nanoSB;
	}

	public void setNanoSB(long nanoSB) {
		this.nanoSB = nanoSB;
	}

	public long getNanoJS() {
		return nanoJS;
	}

	public void setNanoJS(long nanoJS) {
		this.nanoJS = nanoJS;
	}
}
