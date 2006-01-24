//
//  PasteboardHistory.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.util;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PasteboardHistory extends LinkedList implements ChangeListener {
	private int index;
	
	public PasteboardHistory() {
		index = 0;
	}
	
	public void stateChanged(ChangeEvent e) {
		add(((Pasteboard)e.getSource()).get());
		index = size() - 1;
	}
	
	// Iterator delegates
	public boolean hasNext() {
		return (index < size()-1);
	}
	
	public boolean hasPrevious() {
		return (index > 0);
	}
	
	public String next() {
		if (hasNext()) {
			index++;
			return (String)get(index);
		} else {
			return null;
		}
	}
	
	public String previous() {
		if (hasPrevious()) {
			index--;
			return (String)get(index);
		} else {
			return null;
		}
	}
}
