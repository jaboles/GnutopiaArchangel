//
//  HomeBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class HomeBuilding extends Building {
	public HomeBuilding() {
		pluralName = "Homes";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "House "+(thisBuildingCount*5)+" extra people.";
	}
}
