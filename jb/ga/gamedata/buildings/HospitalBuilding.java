//
//  HospitalBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class HospitalBuilding extends Building {
	public HospitalBuilding() {
		pluralName = "Hospitals";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (double)thisBuildingCount / (double)totalLandCount;
		return (efficiency*fraction*2*100)+"% chance of curing plague, "+(efficiency*fraction*4*100)+"% lower military losses.";
	}
}
