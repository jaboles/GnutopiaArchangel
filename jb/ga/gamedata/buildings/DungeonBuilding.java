//
//  DungeonBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class DungeonBuilding extends Building {
	public DungeonBuilding() {
		pluralName = "Dungeons";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "House "+(efficiency*thisBuildingCount*30)+" prisoners.";
	}
}
