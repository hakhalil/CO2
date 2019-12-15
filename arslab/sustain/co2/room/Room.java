package arslab.sustain.co2.room;

import java.util.ArrayList;

public class Room implements Area {

	double height = 0;
	ArrayList<AccessPoint> windows;
	AccessPoint door;
	ArrayList<Sensor> co2Sensors;
	ArrayList<Vent> vents;
	
	final static public double MINSIDE = 2;
	final static public double MAXSIDE = 12;
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public ArrayList<AccessPoint> getWindows() {
		return windows;
	}
	public void setWindows(ArrayList<AccessPoint> windows) {
		this.windows = windows;
	}
	public AccessPoint getDoor() {
		return door;
	}
	public void setDoor(AccessPoint door) {
		this.door = door;
	}
	public ArrayList<Sensor> getCo2Sensors() {
		return co2Sensors;
	}
	public void setCo2Sensors(ArrayList<Sensor> co2Sensors) {
		this.co2Sensors = co2Sensors;
	}
	public ArrayList<Vent> getVents() {
		return vents;
	}
	public void setVents(ArrayList<Vent> vents) {
		this.vents = vents;
	}
}
