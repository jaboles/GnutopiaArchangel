//
//  Personalities.java
//  Archangel
//
//  Created by Jonathan Boles on 4/02/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.gamedata;
import jb.ga.gamedata.personalities.*;
import java.util.*;

public class Personalities {
	public static Personality DEFAULT;
	private static List list;
	
	public static void init() {
		list = new LinkedList();
		DEFAULT = new Personality();
		list.add(new MerchantPersonality());
		list.add(new ShepherdPersonality());
		list.add(new SagePersonality());
		list.add(new RoguePersonality());
		list.add(new MysticPersonality());
		list.add(new WarHeroPersonality());
		list.add(new WarriorPersonality());
		list.add(new GeneralPersonality());
		list.add(new FreakPersonality());
	}
	
	public static Iterator iterator() {
		return list.iterator();
	}
	
	public static int size() {
		return list.size();
	}
}
