//
//  WatchtowerBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class WatchtowerBuilding extends Building {
	public WatchtowerBuilding() {
		pluralName = "Watchtowers";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return (efficiency*fraction*2.5*100)+"% chance of catching thieves, "+(efficiency*fraction*4*100)+"% chance of identifying them.";
	}
}
