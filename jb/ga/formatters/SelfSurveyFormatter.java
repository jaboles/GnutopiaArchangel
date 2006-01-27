//
//  SelfSurveyFormatter.java
//  Archangel
//
//  Created by Jonathan Boles on 27/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.formatters;
import jb.ga.data.Survey;
import jb.ga.gamedata.Buildings;
import jb.ga.gamedata.buildings.*;
import java.util.*;
import java.util.regex.*;

public class SelfSurveyFormatter {
	private static SelfSurveyFormatter instance;
	private Pattern browserFormat;
	
	private SelfSurveyFormatter() {
		StringBuffer browserFormatString = new StringBuffer("(?s)Kingdom Growth(?:\\s*)Internal Affairs(?:\\s*)");
		browserFormatString.append("(.*?), I am in charge of the development of infrastructure(?:.*?)");
		browserFormatString.append("our buildings are functioning at ([\\d\\.]*)% efficiency\\.(?:.*?)");
		Iterator it = Buildings.iterator();
		for (int i = 0; i < Buildings.size(); i++) {
			browserFormatString.append(((Building)it.next()).pluralName+"\\r?\\n");
		}
		for (int i = 0; i < Buildings.size(); i++) {
			browserFormatString.append("([\\d,]+)\\r?\\n");
		}
		for (int i = 0; i < Buildings.size(); i++) {
			browserFormatString.append("(?:[\\d\\.]*%)\\r?\\n");
		}
		for (int i = 0; i < Buildings.size()*24; i++) {
			browserFormatString.append("([\\d,]*|\\-)\\r?\\n");
		}
		System.out.println(browserFormatString.toString());
		browserFormat = Pattern.compile(browserFormatString.toString());
	}
	
	public static SelfSurveyFormatter getInstance() {
		if (instance == null) instance = new SelfSurveyFormatter();
		return instance;
	}
	
	public Survey read(String data) {
		Matcher m = browserFormat.matcher(data);
		System.out.println("Seeing if we have a survey");
		if (m.find()) {
			System.out.println("got one");
			return read(data, m);
		}
		return null;
	}
	
	private Survey read(String data, Matcher m) {
		Survey s = new Survey();
		
		s.setRulerName(m.group(1));
		s.setEfficiency(Double.parseDouble(m.group(2)) / 100.0);
		
		int i = 3;
		Iterator it = Buildings.iterator();
		for (; it.hasNext(); i++) {
			try {
				s.setBuildingCount((Building)it.next(), Integer.parseInt(m.group(i).replaceAll(",","")));
			} catch (NumberFormatException ignored) {}
		}
		for (int j = 1; j <= 24; j++) {
			it = Buildings.iterator();
			for (; it.hasNext(); i++) {
				Building b = (Building)it.next();
				try {
					if (!m.group(i).equals("-"))
						s.setUnderConstructionCount(b, s.getUnderConstructionCount(b) + Integer.parseInt(m.group(i).replaceAll(",","")));
				} catch (NumberFormatException ignored) {}
			}
		}
		s.recalculate();
		return s;
	}
}
