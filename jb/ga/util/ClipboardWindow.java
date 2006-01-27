//
//  ClipboardWindow.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.ui;
import jb.ga.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ClipboardWindow extends SwixmlWindow {
	protected Pasteboard pb;
	public JButton previousButton;
	public JButton historyButton;
	public JButton nextButton;
	public JTextArea textArea;
	
	public ClipboardWindow(UI ui) {
		super(ui);
		this.renderer = new EnhancedSwingEngine(this);
		try {
			window = (JFrame)renderer.render("jb/ga/ui/xml/clipboardwindow.xml");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		if (this instanceof ActionListener) renderer.setActionListener(window, (ActionListener)this);
		pack();
		
		pb = Pasteboard.getInstance();
		pb.addChangeListener(clipboardChangeListener);		
		textArea.setText(pb.get());
	}
	
	private void updateButtonStatus() {
		previousButton.setEnabled(pb.getHistory().hasPrevious());
		nextButton.setEnabled(pb.getHistory().hasNext());
	}
	
	public void display(String s) {
		textArea.setText(s);
	}
	
	
	protected ChangeListener clipboardChangeListener = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			textArea.setText(pb.get());
			updateButtonStatus();
		}
	};
	
	public Action nextAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			String text = pb.getHistory().next();
			textArea.setText(text);
			Pasteboard.getInstance().put(text);
			updateButtonStatus();
		}
	};
	
	public Action historyAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			updateButtonStatus();
		}
	};

	public Action previousAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			String text = pb.getHistory().previous();
			textArea.setText(text);
			Pasteboard.getInstance().put(text);
			updateButtonStatus();
		}
	};
	
	public Action wordWrapAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			boolean ww = ((JCheckBox)e.getSource()).isSelected();
			textArea.setLineWrap(ww);
			textArea.setWrapStyleWord(ww);
		}
	};

	public Action editAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			boolean editable = ((JCheckBox)e.getSource()).isSelected();
			
			textArea.setEditable(editable);
			pb.getWatcher().setEnabled(!editable);
			if (!editable) {
				pb.put(textArea.getText());
				pb.getHistory().add(textArea.getText());
				updateButtonStatus();
			}
		}
	};

	public Action isolateExportLinesAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
		}
	};

	public Action stripLocationsAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			pb.getWatcher().setEnabled(false);
			String rlt = textArea.getText().replaceAll("\\(\\d*?:\\d*?\\)", "(##:##)");
			pb.put(rlt);
			textArea.setText(rlt);
			pb.getWatcher().setEnabled(true);
		}
	};
}
