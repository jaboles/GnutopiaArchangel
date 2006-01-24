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
import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends SwixmlWindow {
	public MainWindow(UI ui) {
		super(ui);
		this.renderer = new EnhancedSwingEngine(ui);
		try {
			window = (JFrame)renderer.render("jb/ga/ui/xml/mainwindow.xml");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		if (this instanceof ActionListener) renderer.setActionListener(window, (ActionListener)this);
		
		pack();
	}
}
