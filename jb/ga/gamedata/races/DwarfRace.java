//
//  DwarfRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class DwarfRace extends Race {
	public DwarfRace() {
		name = "Dwarf";
		offSpecPluralName = "Warriors";
		defSpecPluralName = "Axemen";
		elitePluralName = "Beserkers";
		
		eliteOff = 5;
		eliteDef = 5;
		
		// Bonuses
		buildingEfficiencyMultiplier += 0.25;
		// -50% construction time
		incomeMultiplier += 0.2;
		
		// Penalties
		// -20% magic effectiveness
		// +25% food consumption
	}
}
