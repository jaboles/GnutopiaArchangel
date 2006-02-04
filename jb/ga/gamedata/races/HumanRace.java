//
//  HumanRace.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class HumanRace extends Race {
	public HumanRace() {
		name = "Human";
		offSpecPluralName = "Swordsmen";
		defSpecPluralName = "Archers";
		elitePluralName = "Knights";
		
		eliteOff = 4;
		eliteDef = 6;
		
		// Bonuses
		maxScienceMultiplier += 0.25;
		offSpecOff += 1;
		explorationCostMultiplier -= 0.2;
		
		// Penalties
		militaryWageMultiplier += 0.3;
		// -1 mana recovery/hour
		// -1 stealth recovery/hour
	}
}
