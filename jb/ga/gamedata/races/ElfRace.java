//
//  ElfRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class ElfRace extends Race {
	public ElfRace() {
		name = "Elf";
		offSpecPluralName = "Rangers";
		defSpecPluralName = "Archers";
		elitePluralName = "Elf Lords";
		
		eliteOff = 6;
		eliteDef = 2;
		
		// Bonuses
		// access to all spells
		// +2 mana recovery/hour
		militaryWageMultiplier -= 0.5;
		
		// Penalties
		maxPopulationMultiplier -= 0.05;
		explorationCostMultiplier += 0.35;
	}
}
