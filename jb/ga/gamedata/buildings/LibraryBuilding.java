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

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return (efficiency*thisBuildingCount*3)+" free science points per day.";
	}
}
