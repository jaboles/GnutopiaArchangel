//
//  WatchtowerBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class WatchtowerBuilding extends Building {
	public WatchtowerBuilding() {
		pluralName = "Watchtowers";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return "Thieves: "+nf2dp.format(efficiency*fraction*2.5*100)+"% catch, "+nf2dp.format(efficiency*fraction*4*100)+"% identify";
	}
}
