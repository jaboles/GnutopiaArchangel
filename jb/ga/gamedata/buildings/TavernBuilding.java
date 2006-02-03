//
//  TavernBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class TavernBuilding extends Building {
	public TavernBuilding() {
		pluralName = "Taverns";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		// --FLAG--
		return nf1dp.format(efficiency*fraction*4*100)+"% lower draft and mercenary costs.";
	}
}
