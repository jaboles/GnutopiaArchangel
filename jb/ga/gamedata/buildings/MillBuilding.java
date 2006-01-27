//
//  MillBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class MillBuilding extends Building {
	public MillBuilding() {
		pluralName = "Mills";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (double)thisBuildingCount / (double)totalLandCount;
		return "Decrease building costs by "+(efficiency*fraction*4*100)+"%, exploration gc by "+(efficiency*fraction*3*100)+"%.";
	}
}
