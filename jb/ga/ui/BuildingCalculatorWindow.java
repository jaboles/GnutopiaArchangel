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
import jb.ga.data.*;
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
	public JPanel effectColumn;
	
	public JFormattedTextField builtNumberTotal;
	public JFormattedTextField inProgressNumberTotal;
	
	public Map nameMap;
	public Map builtNumberMap;
	public Map builtPercentageMap;
	public Map inProgressNumberMap;
	public Map goalPercentageMap;
	public Map effectMap;
	
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
		effectMap = new HashMap();
		
		construct();
		pack();
	}
	
	
	public void construct() {
		nameColumn.removeAll();
		builtNumberColumn.removeAll();
		builtPercentageColumn.removeAll();
		inProgressNumberColumn.removeAll();
		goalPercentageColumn.removeAll();
		effectColumn.removeAll();

		nameColumn.setLayout(new GridLayout(Buildings.size(), 1));
		builtNumberColumn.setLayout(new GridLayout(Buildings.size(), 1));
		builtPercentageColumn.setLayout(new GridLayout(Buildings.size(), 1));
		inProgressNumberColumn.setLayout(new GridLayout(Buildings.size(), 1));
		goalPercentageColumn.setLayout(new GridLayout(Buildings.size(), 1));
		effectColumn.setLayout(new GridLayout(Buildings.size(), 1));
		
		Iterator it = Buildings.iterator();
		while (it.hasNext()) {
			Building b = (Building)it.next();
			
			JLabel name = new JLabel(b.pluralName);
			JSpinner builtNumber = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			JFormattedTextField builtPercentage = new JFormattedTextField(new DecimalFormat("###.#"));
			JSpinner inProgressNumber = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
			JSpinner goalPercentage = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 0.1));
			JLabel effect = new JLabel(b.getUAReportEffectString(0, 0, 1.0));

			//name.setMinimumSize(new Dimension((int)name.getSize().getWidth(), (int)((JSpinner.NumberEditor)builtNumber.getEditor()).getTextField().getSize().getHeight()));
			((JSpinner.NumberEditor)builtNumber.getEditor()).getTextField().setColumns(5);
			builtPercentage.setEditable(false);
			builtPercentage.setColumns(3);
			((JSpinner.NumberEditor)inProgressNumber.getEditor()).getTextField().setColumns(5);
			((JSpinner.NumberEditor)goalPercentage.getEditor()).getTextField().setColumns(3);
			
			nameColumn.add(name);
			builtNumberColumn.add(builtNumber);
			builtPercentageColumn.add(builtPercentage);
			inProgressNumberColumn.add(inProgressNumber);
			goalPercentageColumn.add(goalPercentage);
			effectColumn.add(effect);
			
			nameMap.put(b, name);
			builtNumberMap.put(b, builtNumber);
			builtPercentageMap.put(b, builtPercentage);
			inProgressNumberMap.put(b, inProgressNumber);
			goalPercentageMap.put(b, goalPercentage);
			effectMap.put(b, effect);
			
			builtNumber.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					recalculateBuiltNumber((JSpinner)e.getSource());
					recalculateInProgressNumber((JSpinner)e.getSource());
					recalculateEffects();
				}
			});
			
			inProgressNumber.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					recalculateInProgressNumber((JSpinner)e.getSource());
					recalculateEffects();
				}
			});
		}
	}
	
	private void recalculateBuiltNumber(JSpinner source) {
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
	
	private void recalculateInProgressNumber(JSpinner source) {
		int totalBuildings = 0;
		Iterator it;
		
		it = Buildings.iterator();
		while (it.hasNext()) {
			totalBuildings += ((Integer)((JSpinner)inProgressNumberMap.get(it.next())).getValue()).intValue();
		}
		inProgressNumberTotal.setValue(new Integer(totalBuildings));
	}
	
	private void recalculateEffects() {
		Iterator it;
		Building b;
		
		it = Buildings.iterator();
		while (it.hasNext()) {
			b = (Building)it.next();
			int buildingCount = ((Integer)((JSpinner)builtNumberMap.get(b)).getValue()).intValue();
			int inProgressCount = ((Integer)((JSpinner)inProgressNumberMap.get(b)).getValue()).intValue();
			int totalLand = ((Integer)builtNumberTotal.getValue()).intValue() + ((Integer)inProgressNumberTotal.getValue()).intValue();
			
			((JLabel)effectMap.get(b)).setText(b.getUAReportEffectString(buildingCount, totalLand, 1.0));
		}
	}
	
	public void loadSurvey(Survey s) {
		Iterator it = Buildings.iterator();
		while(it.hasNext()) {
			Building b = (Building)it.next();
			((JSpinner)builtNumberMap.get(b)).setValue(new Integer(s.getBuildingCount(b)));
			((JSpinner)inProgressNumberMap.get(b)).setValue(new Integer(s.getUnderConstructionCount(b)));
		}
		recalculateBuiltNumber(null);
		recalculateInProgressNumber(null);
		recalculateEffects();
	}
}
