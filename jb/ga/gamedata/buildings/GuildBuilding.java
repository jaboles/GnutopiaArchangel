//
//  GuildBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class GuildBuilding extends Building {
	public GuildBuilding() {
		pluralName = "Guilds";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		return "Training about "+nf2dp.format(efficiency*thisBuildingCount*0.02)+" wizards per hour.";
	}
}
