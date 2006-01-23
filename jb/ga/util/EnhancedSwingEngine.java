//
//  EnhancedSwingEngine.java
//  Caduceus
//
//  Copyright 2005 ICP Firefly Caduceus Development Team (Z. Benitez, J. Boles, L. Constantinescu, M. Lunney).
//	All rights reserved.
//
package jb.ga.util;
import org.swixml.SwingEngine;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

public class EnhancedSwingEngine extends SwingEngine {
	Map components;
	
	public EnhancedSwingEngine(Object o) {
		super(o);
		
		try {
			this.getTaglib().registerTag("longintegerspinner", JLongIntegerSpinner.class);
			this.getTaglib().registerTag("enhancedframe", EnhancedJFrame.class);
		} catch (Exception e) {
			System.err.println("Couldn't register a new tag.");
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	public Component find(String s) {
		if (components != null) {
			return (Component)components.get(s);
		} else {
			return super.find(s);
		}
	}
	
	public Map getComponentMap() {
		if (components == null) components = new HashMap();
		return components;
	}
}
