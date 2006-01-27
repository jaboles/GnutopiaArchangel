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
	public void setEfficiency(double d) {efficiency = d;}
	public double getEfficiency() {return efficiency;}
	
	
	public String toReport() {
		Iterator it = Buildings.iterator();
		ArrayList nonzeroBuildingsList = new ArrayList();
		while (it.hasNext()) {
			Building b = (Building)it.next();
			if (getBuildingCount(b)>0 || getUnderConstructionCount(b)>0) {
				nonzeroBuildingsList.add(b);
			}
		}
		
		
		StringBuffer report = new StringBuffer();
		report.append("Buildings Report of xxxxxx\n");
		report.append("[Gnutopia Archangel "+Archangel.VERSION+"]\n");
		report.append("\n");
		// Listing of numbers/percentages of complete/constructing buildings.
		for (int i = 0; i < nonzeroBuildingsList.size(); i++) {
			Building b = (Building)nonzeroBuildingsList.get(i);
			report.append((i+1)+". "+b.pluralName+": "+getBuildingCount(b)+" ("+(100.0*getBuildingCount(b)/(totalBuiltAcres+totalInProgressAcres))+"%)");
			if (getUnderConstructionCount(b)>0) {
				report.append(" + "+getUnderConstructionCount(b)+" in progress (+"+(100.0*getUnderConstructionCount(b)/(totalBuiltAcres+totalInProgressAcres))+"%)");
			}
			report.append("\n");
		}
		report.append("\n");
		// effects summary (complete)
		report.append("** Effects Summary (Available Buildings Only) **\n");
		for (int i = 0; i < nonzeroBuildingsList.size(); i++) {
			Building b = (Building)nonzeroBuildingsList.get(i);
			if (getBuildingCount(b) > 0) {
				report.append((i+1)+". "+b.getEffectString(getBuildingCount(b), totalBuiltAcres+totalInProgressAcres, efficiency)+"\n");
			}
		}
		report.append("\n");
		report.append("Total Land: "+(totalBuiltAcres+totalInProgressAcres)+" Acres ("+(100.0*totalBuiltAcres/(totalBuiltAcres+totalInProgressAcres))+"% built)\n");
		if (totalInProgressAcres>0) report.append("In Progress: "+totalInProgressAcres+" Acres ("+(100.0*totalInProgressAcres/(totalBuiltAcres+totalInProgressAcres))+"%)\n");
		report.append("\n");
		return report.toString();
	}
}
