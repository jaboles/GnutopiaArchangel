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
import java.text.*;
import java.util.regex.*;

public class SelfSurveyFormatter {
	private static SelfSurveyFormatter instance;
	private Pattern browserFormat;
	private Pattern browserSubFormat;
	
	private SelfSurveyFormatter() {
		StringBuffer browserFormatString = new StringBuffer("(?s)Kingdom Growth(?:\\s*)Internal Affairs(?:\\s*)");
		browserFormatString.append("(.*?), I am in charge of the development of infrastructure(?:.*?)");
		browserFormatString.append("our buildings are functioning at ([\\d\\.]*)% efficiency\\.(?:.*?)");
		StringBuffer browserSubFormatString = new StringBuffer("(?s)");
		for (int i = 0; i < Buildings.size(); i++) {
			browserSubFormatString.append("(?:\\s*)([\\d,]+|\\-)");
		}
		Iterator it = Buildings.iterator();
		for (int i = 0; i < Buildings.size(); i++) {
			browserFormatString.append("(?:\\s*)"+((Building)it.next()).pluralName);
		}
		for (int i = 0; i < Buildings.size(); i++) {
			browserFormatString.append("(?:\\s*)([\\d,]+)");
		}
		for (int i = 0; i < Buildings.size(); i++) {
			browserFormatString.append("(?:\\s*)(?:[\\d\\.]*%)");
		}
		browserFormatString.append("(?:\\s*)([\\d,\\s\\-]+)Behead");
		
		browserFormat = Pattern.compile(browserFormatString.toString());
		browserSubFormat = Pattern.compile(browserSubFormatString.toString());
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
			
			for (int i = 1; i <= m.groupCount(); i++) {
				System.out.println(i+": "+m.group(i));
			}
			
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
		
		Matcher m2 = browserSubFormat.matcher(m.group(i));
		while (m2.find()) {
			it = Buildings.iterator();
			for (int j = 0; it.hasNext(); j++) {
				Building b = (Building)it.next();
				try {
					if (!m2.group(j).equals("-"))
						s.setUnderConstructionCount(b, s.getUnderConstructionCount(b) + Integer.parseInt(m2.group(j).replaceAll(",","")));
				} catch (NumberFormatException ignored) {}
			}
		}
		s.recalculate();
		return s;
	}
}
