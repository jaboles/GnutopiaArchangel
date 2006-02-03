//
//  LibraryBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class LibraryBuilding extends Building {
	public LibraryBuilding() {
		pluralName = "Libraries";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return nf2dp.format(efficiency*thisBuildingCount*3)+" science points per hour";
	}
}
