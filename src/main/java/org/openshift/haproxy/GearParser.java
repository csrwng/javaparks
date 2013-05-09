package org.openshift.haproxy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class GearParser {
	public GearParser(String urlToParse) {
		try {
			ArrayList<Gear> gears = new ArrayList<Gear>(20);
			String line = null;
			InputStream in = new URL(urlToParse).openConnection().getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while ((line = br.readLine()) != null) {
				String[] splitLines = line.split(",");
				Gear currentGear = new Gear(splitLines[1], splitLines[0], new Integer(splitLines[9]), new Integer(splitLines[7]));
				gears.add(currentGear);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
}