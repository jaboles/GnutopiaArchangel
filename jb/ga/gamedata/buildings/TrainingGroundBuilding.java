//
//  TrainingGroundBuilding.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;

public class TrainingGroundBuilding extends Building {
	public TrainingGroundBuilding() {
		pluralName = "Training Grounds";
	}

	public String getEffectString(int thisBuildingCount, int totalLandCount, double efficiency) {
		double fraction = (totalLandCount==0? 0 : (double)thisBuildingCount / (double)totalLandCount);
		return "Daily wages decreased by "+(efficiency*fraction*3*100)+"%.";
	}
}
