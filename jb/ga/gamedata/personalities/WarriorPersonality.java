//
//  WarriorPersonality.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.personalities;

public class WarriorPersonality extends Personality {
	public WarriorPersonality() {
		name = "Warrior";
		// 50% cheaper mercenaries
		// 1 mercenary per 4 loyal troops
		// elite: armies with elites gain more (100% elite army = +15% gains)
	}
}
