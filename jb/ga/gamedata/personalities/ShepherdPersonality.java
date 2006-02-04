//
//  ShepherdPersonality.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.personalities;

public class ShepherdPersonality extends Personality {
	public ShepherdPersonality() {
		name = "Shepherd";
		// 30% faster military trianing, construction, exploring and scientific research
		// all lands generate 4 bushels/acre/day
		// elite: every 3 at home generate a bushel daily
	}
}
