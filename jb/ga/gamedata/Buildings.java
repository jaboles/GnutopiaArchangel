//
//  Buildings.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata;
import jb.ga.gamedata.buildings.*;
import java.util.*;

public class Buildings {
	private static List list;
	
	public static void init() {
		list = new LinkedList();
		list.add(new HomeBuilding());
		list.add(new FarmBuilding());
		list.add(new MillBuilding());
		list.add(new BankBuilding());
		list.add(new TrainingGroundBuilding());
		list.add(new ArmouryBuilding());
		list.add(new BarracksBuilding());
		list.add(new FortBuilding());
		list.add(new GuildBuilding());
		list.add(new ThievesDenBuilding());
		list.add(new WatchtowerBuilding());
		list.add(new SchoolBuilding());
		list.add(new LibraryBuilding());
		list.add(new HospitalBuilding());
		list.add(new TavernBuilding());
		list.add(new StablesBuilding());
		list.add(new DungeonBuilding());
	}
	
	public static Iterator iterator() {
		return list.iterator();
	}
	
	public static int size() {
		return list.size();
	}
}
