//
//  DungeonBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.Constants;

public class DungeonBuilding extends Building {
	public DungeonBuilding() {
		pluralName = "Dungeons";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return nf0dp.format(thisBuildingCount*30)+" prisoners ("+nf0dp.format(thisBuildingCount*30*Constants.prisonerOff)+" offense, "+nf0dp.format(thisBuildingCount*30*Constants.prisonerIncome)+"gc)";
	}
}
