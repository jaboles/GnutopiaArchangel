//
//  FaeryRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class FaeryRace extends Race {
	public FaeryRace() {
		name = "Faery";
		offSpecPluralName = "Magicians";
		defSpecPluralName = "Druids";
		elitePluralName = "Beastmasters";
		
		eliteOff = 3;
		eliteDef = 6;
		
		// Bonuses
		// +50% magic effectiveness
		// +1 stealth recovery/hour
		// 15% enemy spells fail
		
		// Penalties
		// -10% thievery effectiveness
	}
}
