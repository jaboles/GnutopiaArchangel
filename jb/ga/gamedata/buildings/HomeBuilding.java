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

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "+"+(thisBuildingCount*5)+" maximum population";
	}
}
