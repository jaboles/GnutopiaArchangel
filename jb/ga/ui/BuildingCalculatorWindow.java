//
//  BuildingCalculatorWindow.java
//  Archangel
//
//  Created by Jonathan Boles on 25/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.ui;
import jb.ga.util.*;
import jb.ga.gamedata.*;
import jb.ga.gamedata.buildings.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BuildingCalculatorWindow extends SwixmlWindow {
	public JPanel nameColumn;
	public JPanel builtNumberColumn;
	public JPanel builtPercentageColumn;
	
	public BuildingCalculatorWindow(UI ui) {
		super(ui);
		this.renderer = new EnhancedSwingEngine(this);
		try {
			window = (JFrame)renderer.render("jb/ga/ui/xml/buildingcalculatorwindow.xml");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
		construct();
		pack();
	}
	
	
	public void construct() {
		nameColumn.removeAll();
		builtNumberColumn.removeAll();
		builtPercentageColumn.removeAll();

		nameColumn.setLayout(new GridLayout(Buildings.size(), 1));
		builtNumberColumn.setLayout(new GridLayout(Buildings.size(), 1));
		builtPercentageColumn.setLayout(new GridLayout(Buildings.size(), 1));
		
		Iterator it = Buildings.iterator();
		while (it.hasNext()) {
			Building b = (Building)it.next();
			
			JSpinner builtNumber = new JLongIntegerSpinner();
			JSpinner builtPercentage = new JLongIntegerSpinner();
			System.out.println(builtNumber.getEditor().toString());
			((JSpinner.NumberEditor)builtNumber.getEditor()).getTextField().setColumns(6);
			((JSpinner.NumberEditor)builtPercentage.getEditor()).getTextField().setColumns(4);
			
			nameColumn.add(new JLabel(b.pluralName));
			builtNumberColumn.add(builtNumber);
			builtPercentageColumn.add(builtPercentage);
		}
	}
}
