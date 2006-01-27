//
//  BankBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class BankBuilding extends Building {
	public BankBuilding() {
		pluralName = "Banks";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return (efficiency*thisBuildingCount)+"gc a day, "+(efficiency*fraction*100)+"% increased income.";
	}
}
