package arslab.sustain.co2.model;

public class Dimention {
	private long width;
	private long length;
	private long height;
	
	
	public void set(long w, long l) {
		setWidth(w);
		setLength(l);
	}
	
	public void set(String w, String l) {
		set(Long.parseLong(w.trim()), Long.parseLong(l.trim()));
	}
	
	public long getWidth() {
		return width;
	}
	public void setWidth(long width) {
		this.width = width;
	}
	
	public void setWidth(String width) {
		setWidth(Long.parseLong(width.trim()));
	}
	
	public void setLength(String length) {
		setLength(Long.parseLong(length.trim()));
	}
	
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(DEVModel.DIMENSTION);
		buffer.append(" : ");
		buffer.append("(");
		buffer.append(getWidth());
		buffer.append(",");
		buffer.append(getLength());
		buffer.append(")");
		return buffer.toString();
	}
}
