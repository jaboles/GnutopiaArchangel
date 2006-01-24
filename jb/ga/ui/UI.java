//
//  UI.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.ui;
import jb.ga.*;
import javax.swing.*;
import java.awt.event.*;

public class UI {
	private Archangel controller;
	private MainWindow mainWindow;
	private ClipboardWindow clipboardWindow;
	
	public UI(Archangel controller) {
		this.controller = controller;
		
		mainWindow = new MainWindow(this);
		clipboardWindow = new ClipboardWindow(this);
		
		mainWindow.setCustomCloseAction(quitAction);

		mainWindow.show();
	}
	
	public Action quitAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("quit");
			System.exit(0);
		}
	};
	
	public Action aboutAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("about");
		}
	};

	public Action clipboardViewerAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			clipboardWindow.show();
		}
	};
}
