//
//  Pasteboard.java
//  Archangel
//
//  Created by Jonathan Boles on 24/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.util;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.PrintStream;
import javax.swing.event.ChangeListener;

public class Pasteboard implements ClipboardOwner {
	private static Pasteboard pbInstance;
	private static PasteboardWatcher watcher;
	private static PasteboardHistory history;
	
	private Pasteboard() {
		history = new PasteboardHistory();
		history.add(get());
		watcher = new PasteboardWatcher(this);
		watcher.start();
		watcher.addChangeListener(history);
	}
	
	public static Pasteboard getInstance() {
		if (pbInstance == null) pbInstance = new Pasteboard();
		return pbInstance;
	}
	
	public void addChangeListener(ChangeListener l) {
		watcher.addChangeListener(l);
	}
	
	public void put(String text) {
		watcher.setEnabled(false);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), this);
		watcher.setEnabled(true);
	}
	
	public PasteboardWatcher getWatcher() {
		return watcher;
	}
	
	public PasteboardHistory getHistory() {
		return history;
	}
	
	public String get() {
		String s = "";
		try {
			s = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getContents(this).getTransferData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
		}
		return s;
	}
	
	public void lostOwnership(Clipboard cb, Transferable tr) {
		System.out.println("Lost clipboard ownership?!?");
	}
}
