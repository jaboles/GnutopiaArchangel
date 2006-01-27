//
//  StablesBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class StablesBuilding extends Building {
	public StablesBuilding() {
		pluralName = "Stables";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "Produce "+(efficiency*thisBuildingCount)+" per day, house "+(efficiency*thisBuildingCount*75)+" horses.";
	}
}
