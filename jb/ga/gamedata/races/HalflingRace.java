//
//  HalflingRace.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class HalflingRace extends Race {
	public HalflingRace() {
		name = "Human";
		offSpecPluralName = "Spearmen";
		defSpecPluralName = "Archers";
		elitePluralName = "Half-Giants";
		
		eliteOff = 5;
		eliteDef = 4;
		
		// Bonuses
		// -50% thief losses
		// +50% thievery effectiveness
		constructionCostMultiplier -= 0.75;
		
		// Penalties
		attackGainsMultiplier -= 0.1;
	}
}
