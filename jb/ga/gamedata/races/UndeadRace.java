//
//  UndeadRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class UndeadRace extends Race {
	public UndeadRace() {
		name = "Undead";
		offSpecPluralName = "Skeletons";
		defSpecPluralName = "Zombies";
		elitePluralName = "Ghouls";
		
		eliteOff = 6;
		eliteDef = 2;
		
		// Bonuses
		maxPopulationMultiplier += 0.15;
		// no food needed
		// spreads plague
		
		// Penalties
		maxScienceMultiplier -= 0.5;
		// -40% thievery effectiveness
	}
}
