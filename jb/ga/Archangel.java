//
//  Archangel.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga;
import jb.ga.ui.*;
import jb.ga.gamedata.*;

public class Archangel {
	public static String VERSION = "0.2\337";
	
	UI ui;
	
	public Archangel() {
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Gnutopia Archangel");
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.brushMetalLook", "false");
		
		Buildings.init();
		
		ui = new UI(this);
	}
	
	public static void crashed(Throwable e) {
		System.err.println(e);
		e.printStackTrace(System.err);
		System.exit(1);
	}
	
	public static void main(String[] args) {
		new Archangel();
	}
}
