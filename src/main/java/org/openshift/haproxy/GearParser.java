package org.openshift.haproxy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class GearParser {
	ArrayList<Gear> gears = new ArrayList<Gear>(50);

	public GearParser(String urlToParse) {
		try {
			String line = null;
			InputStream in = new URL(urlToParse).openConnection()
					.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int i = 0;
			while ((line = br.readLine()) != null) {
				System.out.println("Line: " + line);
				if (i != 0) {
					String[] splitLines = line.split(",");
					Gear currentGear = new Gear(splitLines[1], splitLines[0],
							new Integer(splitLines[9]), new Integer(
									splitLines[7]));
					gears.add(currentGear);
					System.out.println("Added new gear to arraylist");
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Gear> getGears() {
		return gears;
	}
}
