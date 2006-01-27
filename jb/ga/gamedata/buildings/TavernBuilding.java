//
//  TavernBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class TavernBuilding extends Building {
	public TavernBuilding() {
		pluralName = "Taverns";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return (efficiency*fraction*4*100)+"% lower draft and mercenary costs.";
	}
}
