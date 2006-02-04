//
//  BarracksBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.races.Race;
import jb.ga.gamedata.personalities.Personality;

public class BarracksBuilding extends Building {
	public BarracksBuilding() {
		pluralName = "Barracks";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency, Race race, Personality personality) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return "-"+nf2dp.format(efficiency*fraction*1.5*100)+"% attack time, +"+nf2dp.format(efficiency*fraction*1*100)+"% offense bonus";
	}
}
