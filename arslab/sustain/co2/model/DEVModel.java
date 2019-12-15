package arslab.sustain.co2.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DEVModel {

	public String _fileName = "";

	// TAG
	public static final String ZONE = "%zone";
	public static final String DIMENSTION = "dim";
	public static final String WIDTH = "width";
	public static final String LENGTH = "length";

	private Dimention roomDim = new Dimention();
	private ArrayList<VentilationZone> zones = new ArrayList<VentilationZone>();

	private ArrayList<StringBuffer> fileData = new ArrayList<StringBuffer>();

	private boolean isDimInserted = false;

	public void readModel(String fileName) {

		Scanner scnr = null;
		try {
			// creating File instance to reference text file in Java
			File file = new File(fileName);

			// Creating Scanner instance to read File in Java
			scnr = new Scanner(file);
			// Reading each line of log file

			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] tags = line.split(" ");
				if (tags.length > 0) {
					String tag = tags[0];
					switch (tag) {
					case DIMENSTION:
						storeDim(line);
						break;
					case WIDTH:
						storeWidth(line);
						break;
					case LENGTH:
						storeLength(line);
						break;
					case ZONE:
						storeZone(line);
						break;
					default:
						fileData.add(new StringBuffer(line));
					}
				}
				else 
					fileData.add(new StringBuffer(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scnr != null)
				scnr.close();
		}
	}

	private void storeDim(String line) {
		isDimInserted = true;
		String[] dims = line.replaceAll("[^0-9 ,]+", "").split(",");

		if(dims.length > 2)
			roomDim.setHeight(dims[2]);
		
		roomDim.set(dims[0], dims[1]);
		fileData.add(new StringBuffer(DIMENSTION));
	}

	private void storeWidth(String line) {
		String[] tags = line.split(":");
		roomDim.setWidth(tags[1]);

		if (!isDimInserted) {
			isDimInserted = true;
			fileData.add(new StringBuffer(DIMENSTION));
		}
	}

	private void storeLength(String line) {
		String[] tags = line.split(":");
		roomDim.setLength(tags[1]);

		if (!isDimInserted) {
			isDimInserted = true;
			fileData.add(new StringBuffer(DIMENSTION));
		}
	}

	private void storeZone(String line) {
		int index = line.indexOf("..");
		if(index != -1 ) {
			line = line.replace("..", ",");
			String[] dims = line.replaceAll("[^0-9 ,]+", "").split(",");
			if(dims.length == 4) {
				VentilationZone zone = new VentilationZone(dims[0], dims[1], dims[2], dims[3]);
				if(zones.isEmpty())
					fileData.add(new StringBuffer(ZONE));
				zones.add(zone);
			}
		}
	}

	public void writeModel(String fileName) {
		StringBuffer buffer = new StringBuffer();
		BufferedWriter writer = null;

		try {

			for (int i = 0; i < fileData.size(); i++) {
				StringBuffer currentLine = fileData.get(i);
				switch (currentLine.toString()) {
				case DIMENSTION:
					buffer.append(roomDim.toString());
					buffer.append("\r\n");
					break;
				case ZONE:
					for(int j=0; j<zones.size(); j++) {
						buffer.append(zones.get(j).toString());
						buffer.append("\r\n");
					}
					break;
				default:
					buffer.append(currentLine);
					buffer.append("\r\n");
					break;
				}
				
			}

			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(buffer.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		DEVModel ma = new DEVModel();
		String fileName = "C:\\Users\\xxxx\\Downloads\\makefiles\\CO2Model";
		ma.readModel(fileName+".ma");
		if(ma.getZones().size()>0) {
			VentilationZone zone =  ma.getZones().get(1);
			Point p = zone.getFromPoint();
			p.set(p.getWidth()+7, p.getLength()+7);
		}
		
		Dimention rm = ma.getRoomDim();
		rm.setWidth(rm.getWidth()+7);
		
		ma.writeModel(fileName+"_EDITED.MA");
	}

	public Dimention getRoomDim() {
		return roomDim;
	}

	public void setRoomDim(Dimention roomDim) {
		this.roomDim = roomDim;
	}

	public ArrayList<VentilationZone> getZones() {
		return zones;
	}

	public void setZones(int index, VentilationZone zone) {
		if(zones.size()>index)
			zones.set(index, zone);
	}
}
