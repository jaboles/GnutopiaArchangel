//
//  MainWindow.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.ui;
import jb.ga.Archangel;
import jb.ga.util.*;

public class MainWindow extends SwixmlWindow {
	public MainWindow(Archangel controller) {
		super(controller, "jb/ga/ui/xml/mainwindow.xml");
	}
}
