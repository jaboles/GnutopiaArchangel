//
//  DungeonBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.Constants;
import jb.ga.gamedata.races.Race;
import jb.ga.gamedata.personalities.Personality;

public class DungeonBuilding extends Building {
	public DungeonBuilding() {
		pluralName = "Dungeons";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency, Race race, Personality personality) {
		return nf0dp.format(thisBuildingCount*30)+" prisoners ("+nf0dp.format(thisBuildingCount*30*race.prisonerOff)+" offense, "+nf0dp.format(thisBuildingCount*30*Constants.prisonerIncome)+"gc)";
	}
}
