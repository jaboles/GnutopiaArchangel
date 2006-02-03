//
//  Race.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata.races;

public class Race {
	public String name = null;
	
	public String soldierPluralName;
	public int soldierOff;
	public int soldierDef;
	
	public String offSpecPluralName;
	public int offSpecOff;
	public int offSpecDef;
	
	public String defSpecPluralName;
	public int defSpecOff;
	public int defSpecDef;
	
	public String elitePluralName;
	public int eliteOff;
	public int eliteDef;
	
	public int warHorseOff;
	public int mercenaryOff;
	
	public Race() {
		name = null;
		soldierPluralName = "Soldiers";
		soldierOff = 1;
		soldierDef = 1;
		offSpecPluralName = "Offence Specialists";
		offSpecOff = 5;
		offSpecDef = 0;
		defSpecPluralName = "Defence Specialists";
		defSpecOff = 0;
		defSpecDef = 5;
		elitePluralName = "Elites";
		eliteOff = 0;
		eliteDef = 0;
		warHorseOff = 1;
		mercenaryOff = 3;
	}
}
