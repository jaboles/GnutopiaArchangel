//
//  TowerBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class TowerBuilding extends Building {
	public TowerBuilding() {
		pluralName = "Towers";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "Produce "+(efficiency*thisBuildingCount*10)+" runes daily.";
	}
}
