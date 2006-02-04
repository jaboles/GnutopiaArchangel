//
//  StablesBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.races.Race;
import jb.ga.gamedata.personalities.Personality;

public class StablesBuilding extends Building {
	public StablesBuilding() {
		pluralName = "Stables";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency, Race race, Personality personality) {
		return "Produce "+nf0dp.format(efficiency*thisBuildingCount)+" horses/hour, hold "+nf0dp.format(efficiency*thisBuildingCount*75)+" horses";
	}
}
