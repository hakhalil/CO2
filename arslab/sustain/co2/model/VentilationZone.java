package arslab.sustain.co2.model;

public class VentilationZone {
	Point fromPoint = new Point();
	Point toPoint = new Point();
	
	public VentilationZone(long fromX, long fromY, long toX, long toY) {
		fromPoint.setWidth(fromX);
		fromPoint.setLength(fromY);
		toPoint.setWidth(toX);
		toPoint.setLength(toY);
	}
	
	public VentilationZone(String fromX, String fromY, String toX, String toY) {
		fromPoint.setWidth(fromX);
		fromPoint.setLength(fromY);
		toPoint.setWidth(toX);
		toPoint.setLength(toY);
	}
	
	public  Point getFromPoint() {
		return fromPoint;
	}
	public void setFromPoint(Point fromPoint) {
		this.fromPoint = fromPoint;
	}
	public Point getToPoint() {
		return toPoint;
	}
	public void setToPoint(Point toPoint) {
		this.toPoint = toPoint;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(DEVModel.ZONE);
		buffer.append(" : Ventilated ");
		buffer.append("{ ");
		buffer.append(fromPoint.toString());
		buffer.append("..");
		buffer.append(toPoint.toString());
		buffer.append(" }");
		return buffer.toString();
	}
}
