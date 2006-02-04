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
	public int prisonerOff;
	
	public double maxScienceMultiplier;
	public double explorationCostMultiplier;
	public double militaryWageMultiplier;
	public double maxPopulationMultiplier;
	public double buildingEfficiencyMultiplier;
	public double incomeMultiplier;
	public double attackGainsMultiplier;
	public double constructionCostMultiplier;
	public double attackTimeMultiplier;
	
	public Race() {
		name = "Unknown";
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
		prisonerOff = 3;
		
		maxScienceMultiplier = 1.0;
		explorationCostMultiplier = 1.0;
		militaryWageMultiplier = 1.0;
		maxPopulationMultiplier = 1.0;
		buildingEfficiencyMultiplier = 1.0;
		incomeMultiplier = 1.0;
		attackGainsMultiplier = 1.0;
		constructionCostMultiplier = 1.0;
		attackTimeMultiplier = 1.0;
	}

	public String toString() {
		return name;
	}
}
