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

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		// --FLAG--
		return "Decrease building costs by "+nf1dp.format(efficiency*fraction*4*100)+"%, exploration gc by "+nf1dp.format(efficiency*fraction*3*100)+"%.";
	}
}
