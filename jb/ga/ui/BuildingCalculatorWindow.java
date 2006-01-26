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
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class BuildingCalculatorWindow extends SwixmlWindow {
	public JPanel nameColumn;
	public JPanel builtNumberColumn;
	public JPanel builtPercentageColumn;
	public JPanel inProgressNumberColumn;
	public JPanel goalPercentageColumn;
	
	public JFormattedTextField builtNumberTotal;
	public JFormattedTextField inProgressNumberTotal;
	
	public Map nameMap;
	public Map builtNumberMap;
	public Map builtPercentageMap;
	public Map inProgressNumberMap;
	public Map goalPercentageMap;
	
	public BuildingCalculatorWindow(UI ui) {
		super(ui);
		this.renderer = new EnhancedSwingEngine(this);
		try {
			window = (JFrame)renderer.render("jb/ga/ui/xml/buildingcalculatorwindow.xml");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
		nameMap = new HashMap();
		builtNumberMap = new HashMap();
		builtPercentageMap = new HashMap();
		inProgressNumberMap = new HashMap();
		goalPercentageMap = new HashMap();
		
		construct();
		pack();
	}
	
	
	public void construct() {
		nameColumn.removeAll();
		builtNumberColumn.removeAll();
		builtPercentageColumn.removeAll();
		inProgressNumberColumn.removeAll();
		goalPercentageColumn.removeAll();

		nameColumn.setLayout(new GridLayout(Buildings.size(), 1));
		builtNumberColumn.setLayout(new GridLayout(Buildings.size(), 1));
		builtPercentageColumn.setLayout(new GridLayout(Buildings.size(), 1));
		inProgressNumberColumn.setLayout(new GridLayout(Buildings.size(), 1));
		goalPercentageColumn.setLayout(new GridLayout(Buildings.size(), 1));
		
		Iterator it = Buildings.iterator();
		while (it.hasNext()) {
			Building b = (Building)it.next();
			
			JLabel name = new JLabel(b.pluralName);
			JSpinner builtNumber = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			JFormattedTextField builtPercentage = new JFormattedTextField(new DecimalFormat("###.#"));
			JSpinner inProgressNumber = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			JSpinner goalPercentage = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 0.1));

			//name.setMinimumSize(new Dimension((int)name.getSize().getWidth(), (int)((JSpinner.NumberEditor)builtNumber.getEditor()).getTextField().getSize().getHeight()));
			((JSpinner.NumberEditor)builtNumber.getEditor()).getTextField().setColumns(5);
			builtPercentage.setEditable(false);
			builtPercentage.setEnabled(false);
			builtPercentage.setColumns(3);
			((JSpinner.NumberEditor)inProgressNumber.getEditor()).getTextField().setColumns(5);
			((JSpinner.NumberEditor)goalPercentage.getEditor()).getTextField().setColumns(3);
			
			nameColumn.add(name);
			builtNumberColumn.add(builtNumber);
			builtPercentageColumn.add(builtPercentage);
			inProgressNumberColumn.add(inProgressNumber);
			goalPercentageColumn.add(goalPercentage);
			
			nameMap.put(b, name);
			builtNumberMap.put(b, builtNumber);
			builtPercentageMap.put(b, builtPercentage);
			inProgressNumberMap.put(b, inProgressNumber);
			goalPercentageMap.put(b, goalPercentage);
			
			builtNumber.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					recalculateFromBuiltNumber((JSpinner)e.getSource());
				}
			});
			
			inProgressNumber.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					recalculateFromInProgressNumber((JSpinner)e.getSource());
				}
			});
		}
	}
	
	public void recalculateFromBuiltNumber(JSpinner source) {
		int totalBuildings = 0;
		Iterator it;
		
		it = Buildings.iterator();
		while (it.hasNext()) {
			totalBuildings += ((Integer)((JSpinner)builtNumberMap.get(it.next())).getValue()).intValue();
		}
		builtNumberTotal.setValue(new Integer(totalBuildings));
		
		if (totalBuildings > 0) {
			it = Buildings.iterator();
			while (it.hasNext()) {
				Building b = (Building)it.next();
				int numBuildingsOfThisType = ((Integer)((JSpinner)builtNumberMap.get(b)).getValue()).intValue();
				((JFormattedTextField)builtPercentageMap.get(b)).setValue(new Double(100.0 * numBuildingsOfThisType / totalBuildings));
			}
		}
	}
	
	public void recalculateFromInProgressNumber(JSpinner source) {
		int totalBuildings = 0;
		Iterator it;
		
		it = Buildings.iterator();
		while (it.hasNext()) {
			totalBuildings += ((Integer)((JSpinner)inProgressNumberMap.get(it.next())).getValue()).intValue();
		}
		inProgressNumberTotal.setValue(new Integer(totalBuildings));
	}
}
