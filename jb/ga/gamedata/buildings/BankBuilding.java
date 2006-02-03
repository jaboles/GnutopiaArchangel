//
//  BankBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class BankBuilding extends Building {
	public BankBuilding() {
		pluralName = "Banks";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return nf0dp.format(efficiency*thisBuildingCount)+"gc, +"+nf2dp.format(efficiency*fraction*100)+"% income";
	}
}
