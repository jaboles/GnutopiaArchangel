//
//  BarracksBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class BarracksBuilding extends Building {
	public BarracksBuilding() {
		pluralName = "Barracks";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return (efficiency*fraction*1.5*100)+"% lower attack time, "+(efficiency*fraction*1*100)+"% increased military offence efficiency.";
	}
}
