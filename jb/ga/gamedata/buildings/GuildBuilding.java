//
//  GuildBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.races.Race;
import jb.ga.gamedata.personalities.Personality;

public class GuildBuilding extends Building {
	public GuildBuilding() {
		pluralName = "Guilds";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency, Race race, Personality personality) {
		return "Training about "+nf2dp.format(efficiency*thisBuildingCount*0.02)+" wizards per hour.";
	}
}
