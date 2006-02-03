//
//  ThievesDenBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class ThievesDenBuilding extends Building {
	public ThievesDenBuilding() {
		pluralName = "Thieves' Dens";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return "-"+nf2dp.format(efficiency*fraction*4*100)+"% losses, +"+nf2dp.format(efficiency*fraction*3*100)+"% effectiveness";
	}
}
