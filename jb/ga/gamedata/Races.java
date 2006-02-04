//
//  Races.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata;
import jb.ga.gamedata.races.*;
import java.util.*;

public class Races {
	public static Race DEFAULT;
	private static List list;
	
	public static void init() {
		list = new LinkedList();
		DEFAULT = new Race();
		list.add(new HumanRace());
		list.add(new ElfRace());
		list.add(new DwarfRace());
		list.add(new OrcRace());
		list.add(new FaeryRace());
		list.add(new HalflingRace());
		list.add(new AvianRace());
		list.add(new UndeadRace());
	}
	
	public static Iterator iterator() {
		return list.iterator();
	}
	
	public static int size() {
		return list.size();
	}
}
