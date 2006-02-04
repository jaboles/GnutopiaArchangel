//
//  AvianRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class AvianRace extends Race {
	public AvianRace() {
		name = "Avian";
		offSpecPluralName = "Harpies";
		defSpecPluralName = "Griffins";
		elitePluralName = "Drakes";
		
		eliteOff = 6;
		eliteDef = 4;
		
		// Bonuses
		defSpecDef += 1;
		// +75% birth rate
		attackTimeMultiplier -= 0.25;
		// immune to fog
		
		// Penalties
		// +20% military losses in combat
		// -10% building efficiency
	}
}
