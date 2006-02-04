//
//  GeneralPersonality.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.personalities;

public class GeneralPersonality extends Personality {
	public GeneralPersonality() {
		name = "General";
		// access to enhanced conquest at all times
		// 50% higher effectiveness on intel ops/spells
		// elite: elites die at the rate of 50% of other troops
	}
}
