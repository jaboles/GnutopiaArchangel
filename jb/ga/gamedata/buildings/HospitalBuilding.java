//
//  HospitalBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class HospitalBuilding extends Building {
	public HospitalBuilding() {
		pluralName = "Hospitals";
	}

	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		// --FLAG--
		return nf2dp.format(efficiency*fraction*2*100)+"% cure plague, -"+nf2dp.format(efficiency*fraction*4*100)+"% combat losses";
	}
}
