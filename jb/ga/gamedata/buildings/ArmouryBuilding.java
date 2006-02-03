//
//  ArmouryBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class ArmouryBuilding extends Building {
	public ArmouryBuilding() {
		pluralName = "Armouries";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		// --FLAG--
		return "-"+nf2dp.format(efficiency*fraction*3*100)+"% training costs";
	}
}
