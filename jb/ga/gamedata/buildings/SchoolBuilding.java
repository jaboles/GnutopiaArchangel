//
//  SchoolBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class SchoolBuilding extends Building {
	public SchoolBuilding() {
		pluralName = "Schools";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (double)thisBuildingCount / (double)totalLandCount;
		return (efficiency*fraction*3*100)+"% lower science costs.";
	}
}
