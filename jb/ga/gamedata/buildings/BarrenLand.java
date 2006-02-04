//
//  BarrenLand.java
//  Archangel
//
//  Created by Jonathan Boles on 26/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.races.Race;
import jb.ga.gamedata.personalities.Personality;

public class BarrenLand extends Building {
	public BarrenLand() {
		pluralName = "Barren Lands";
	}	
	
	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency, Race race, Personality personality) {
		return "";
	}
}
