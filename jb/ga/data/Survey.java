//
//  Survey.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.data;
import java.util.*;
import jb.ga.Archangel;
import jb.ga.gamedata.buildings.Building;
import jb.ga.gamedata.Buildings;

public class Survey {
	private Map buildings;
	private Map underConstruction;
	private int totalBuiltAcres;
	private int totalInProgressAcres;
	private String rulerName;
	private double efficiency;
	
	public Survey() {
		buildings = new HashMap();
		underConstruction = new HashMap();
	}
	
	public void setBuildingCount(Building b, int count) {
		buildings.put(b, new Integer(count));
	}
	
	public int getBuildingCount(Building b) {
		if (buildings.get(b) == null)
			return 0;
		else
			return ((Integer)buildings.get(b)).intValue();
	}
	
	public void setUnderConstructionCount(Building b, int count) {
		underConstruction.put(b, new Integer(count));
	}
	
	public int getUnderConstructionCount(Building b) {
		if (underConstruction.get(b) == null)
			return 0;
		else
			return ((Integer)underConstruction.get(b)).intValue();
	}
	
	public void recalculate() {
		totalInProgressAcres = 0;
		totalBuiltAcres = 0;
		Iterator it = Buildings.iterator();
		while (it.hasNext()) {
			Building b = (Building)it.next();
			totalBuiltAcres += getBuildingCount(b);
			totalInProgressAcres += getUnderConstructionCount(b);
		}
	}
	
	public void setRulerName(String s) {rulerName = s;}
	public String getRulerName() {return rulerName;}
	
	
	public String toReport() {
		StringBuffer report = new StringBuffer();
		report.append("Buildings Report of xxxxxx\n");
		report.append("[Gnutopia Archangel "+Archangel.VERSION+"]\n");
		report.append("\n");
		report.append("Total Land: "+(totalBuiltAcres+totalInProgressAcres)+" Acres ("+(100.0*totalBuiltAcres/(totalBuiltAcres+totalInProgressAcres))+"% built)\n");
		report.append("In Progress: "+totalInProgressAcres+" Acres ("+(100.0*totalInProgressAcres/(totalBuiltAcres+totalInProgressAcres))+"%)\n");
		report.append("\n");
		return report.toString();
	}
}
