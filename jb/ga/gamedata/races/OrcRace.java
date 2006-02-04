//
//  OrcRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class OrcRace extends Race {
	public OrcRace() {
		name = "Orc";
		offSpecPluralName = "Goblins";
		defSpecPluralName = "Trolls";
		elitePluralName = "Ogres";
		
		eliteOff = 7;
		eliteDef = 3;
		
		// Bonuses
		attackGainsMultiplier += 0.25;
		// +25% draft costs
		prisonerOff += 1;
		
		// Penalties
		// 20% of spells fail
		// 15% of thief ops fail
	}
}
