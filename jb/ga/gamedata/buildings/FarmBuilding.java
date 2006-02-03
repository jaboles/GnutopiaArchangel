//
//  FarmBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class FarmBuilding extends Building {
	public FarmBuilding() {
		pluralName = "Farms";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "Produce "+nf0dp.format(efficiency*thisBuildingCount*70)+" bushels (xxx with FL)";
	}
}
