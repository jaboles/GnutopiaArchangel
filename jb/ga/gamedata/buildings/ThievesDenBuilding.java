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

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (double)thisBuildingCount / (double)totalLandCount;
		return (efficiency*fraction*4*100)+"% lower thievery losses, "+(efficiency*fraction*3*100)+"% increased thievery effectiveness.";
	}
}
