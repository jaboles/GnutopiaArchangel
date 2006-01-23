//
//  Archangel.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga;
import jb.ga.ui.*;

public class Archangel {
	MainWindow mainWindow;

	public Archangel() {
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Gnutopia Archangel");
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("apple.awt.brushMetalLook", "true");
		
		mainWindow = new MainWindow(this);
		
		mainWindow.show();
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
