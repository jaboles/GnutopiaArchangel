//
//  SwixmlWindow.java
//  Caduceus
//
//  Copyright 2005 ICP Firefly Caduceus Development Team (Z. Benitez, J. Boles, L. Constantinescu, M. Lunney).
//	All rights reserved.
//
package jb.ga.util;
import jb.ga.Archangel;
import org.swixml.SwingEngine;
import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwixmlWindow {
	protected Archangel controller;
	protected SwingEngine renderer;
	protected JFrame window;
	
	public SwixmlWindow(Archangel controller) {
		this.controller = controller;
	}
	
	public SwixmlWindow(Archangel controller, String xmlResource) {
		this.controller = controller;
		this.renderer = new EnhancedSwingEngine(this);
		try {
			window = (JFrame)renderer.render(xmlResource);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		if (this instanceof ActionListener) renderer.setActionListener(window, (ActionListener)this);
	}
	
	/** Delegate method to pack the WorkflowWindow's underlying window. */
	public void pack() {
		window.pack();
	}
	
	/** Delegate method to show the WorkflowWindow's underlying window. */
	public void show() {
		window.show();
	}
	
	/** Delegate method to dispose the WorkflowWindow's underlying window. */
	public void dispose() {
		window.dispose();
	}
	
	/** Delegate method to see if the WorkflowWindow's underlying window is still visible. */
	public boolean isVisible() {
		return window.isVisible();
	}
	
	/** Delegate method to move the WorkflowWindow's underlying window to the front. */
	public void toFront() {
		window.toFront();
	}
}
