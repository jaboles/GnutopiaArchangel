//
//  JLongIntegerSpinner.java
//  Caduceus
//
//  Copyright 2005 ICP Firefly Caduceus Development Team (Z. Benitez, J. Boles, L. Constantinescu, M. Lunney).
//	All rights reserved.
//
package jb.ga.util;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class JLongIntegerSpinner extends JSpinner {
	public JLongIntegerSpinner() {
		super(new SpinnerNumberModel());
	}

	public long getLongValue() {
		return ((Long)getValue()).longValue();
	}
}
