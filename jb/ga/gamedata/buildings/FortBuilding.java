//
//  FortBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class FortBuilding extends Building {
	public FortBuilding() {
		pluralName = "Forts";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (double)thisBuildingCount / (double)totalLandCount;
		return (efficiency*fraction*1.5*100)+"% lower losses, "+(efficiency*fraction*0.5*100)+"% increased military defence efficiency.";
	}
}
