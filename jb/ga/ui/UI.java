//
//  UI.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.ui;
import jb.ga.*;
import jb.ga.util.Pasteboard;
import javax.swing.*;
import java.awt.event.*;

public class UI {
	private Archangel controller;
	private ClipboardChangeListener clipboardListener;

	private MainWindow mainWindow;
	private ClipboardWindow clipboardWindow;
	private BuildingCalculatorWindow buildingCalculatorWindow;

	public UI(Archangel controller) {
		this.controller = controller;
		clipboardListener = new ClipboardChangeListener(this);
		Pasteboard.getInstance().addChangeListener(clipboardListener);
		
		mainWindow = new MainWindow(this);
		clipboardWindow = new ClipboardWindow(this);
		buildingCalculatorWindow = new BuildingCalculatorWindow(this);
		
		mainWindow.setCustomCloseAction(quitAction);

		mainWindow.show();
	}
	
	public ClipboardWindow getClipboardWindow() {
		return clipboardWindow;
	}
	
	public BuildingCalculatorWindow getBuildingCalculatorWindow() {
		return buildingCalculatorWindow;
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
	
	public Action buildingCalculatorAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			buildingCalculatorWindow.show();
		}
	};
}
