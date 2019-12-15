package arslab.sustain.co2.model;

public class Point extends Dimention {

	public void setXCoord( long xCoord) {
		setWidth(xCoord);
	}
	
	public void setYCoord( long yCoord) {
		setLength(yCoord);
	}
	
	public long getXCoord() {
		return getWidth();
	}
	
	public long getYCoord() {
		return getLength();
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("(");
		buffer.append(getWidth());
		buffer.append(",");
		buffer.append(getLength());
		buffer.append(")");
		return buffer.toString();
	}
}
