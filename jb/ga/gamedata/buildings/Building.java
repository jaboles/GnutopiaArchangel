//
//  Building.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.buildings;
import jb.ga.gamedata.races.Race;
import jb.ga.gamedata.personalities.Personality;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Building {
	protected static NumberFormat nf2dp = new DecimalFormat("#,###.##");
	protected static NumberFormat nf1dp = new DecimalFormat("#,###.#");
	protected static NumberFormat nf0dp = new DecimalFormat("#,###");

	public String pluralName;
	public String patternName;

	public Building() {
		pluralName = null;
	}
	
	public String getUAReportEffectString(int thisBuildingCount, int totalLandCount, double efficiency, Race race, Personality personality) {
		return null;
	}
}
