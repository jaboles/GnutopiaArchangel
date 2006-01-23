//
//  EnhancedJFrame.java
//  Caduceus
//
//  Copyright 2005 ICP Firefly Caduceus Development Team (Z. Benitez, J. Boles, L. Constantinescu, M. Lunney).
//	All rights reserved.
//
package jb.ga.util;
import org.swixml.SwingEngine;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class EnhancedJFrame extends JFrame implements MenuListener {
	public JMenu windowMenu;
	private int initialMenuItemCount;
	private static LinkedList windowList = new LinkedList();
	private boolean windowCloseable = true;
	private Action customCloseAction = null;
	
	public EnhancedJFrame() {
		super();
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent ignored) {
				windowList.add(EnhancedJFrame.this);
			}
			public void windowClosed(WindowEvent ignored) {
				windowList.remove(EnhancedJFrame.this);
			}
			public void windowClosing(WindowEvent ignored) {
				closeAction.actionPerformed(new ActionEvent(EnhancedJFrame.this, ActionEvent.ACTION_PERFORMED, "System Menu"));
			}
		});
		// Do nothing on close, let our windowClosing event handler delegate the close event
		// to either our own closeAction or the supplied custom one, so that *it* can
		// decide whether to actually close the window or not.
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void setWindowCloseable(boolean b) {
		windowCloseable = b;
	}
	
	public void setCustomCloseAction(Action a) {
		customCloseAction = a;
	}
	
	public void show() {
		if (windowMenu == null) {
			SwingEngine renderer = new EnhancedSwingEngine(this);
			try {
				windowMenu = (JMenu)renderer.render("jb/ga/ui/xml/enhancedframewindowmenu.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!windowCloseable) windowMenu.remove(1);
			windowMenu.addMenuListener(this);
			initialMenuItemCount = windowMenu.getItemCount();
			getJMenuBar().add(windowMenu);
		}
		super.show();
	}
	
	private void refreshMenu() {
		// Clear the window list in the menu
		while (windowMenu.getItemCount() > initialMenuItemCount)
			windowMenu.remove(initialMenuItemCount);
		// Add the window titles in the window list to the menu
		Iterator it = windowList.iterator();
		while (it.hasNext()) {
			Frame f = (Frame)it.next();
			JRadioButtonMenuItem m = new JRadioButtonMenuItem(selectWindowAction);
			// Mark the radio button as selected if its window is focused.
			m.setSelected(f.isFocused());
			windowMenu.add(m).setText(f.getTitle());
		}
	}
	
	public Action minimiseAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			getParentFrame((JMenuItem)e.getSource()).setState(Frame.ICONIFIED);
		}
	};

	public Action closeAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			if (customCloseAction != null) {
				customCloseAction.actionPerformed(e);
			} else if (e.getSource() instanceof JMenuItem) {
				getParentFrame((JMenuItem)e.getSource()).dispose();
			} else {
				dispose();
			}
		}
	};
	
	/** Brings the next window in the window list into focus, wrapping if already at the end
		of the list. */
	public Action nextWindowAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int index = windowList.indexOf(EnhancedJFrame.this);
			if (index >= 0) {
				if (index == windowList.size()-1) index = 0;
				else index++;
				focusWindow((Frame)windowList.get(index));
			}
		}
	};
	
	/** Brings the previous window in the window list into focus, wrapping if already at the start
		of the list. */
	public Action previousWindowAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int index = windowList.indexOf(EnhancedJFrame.this);
			if (index >= 0) {
				if (index == 0) index = windowList.size()-1;
				else index--;
				focusWindow((Frame)windowList.get(index));
			}
		}
	};
	
	public Action selectWindowAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int windowListIndex = indexOfMenuItem(windowMenu, (JMenuItem)e.getSource()) - initialMenuItemCount;
			focusWindow((Frame)windowList.get(windowListIndex));
		}
	};
	
	private Frame getParentFrame(JMenuItem m) {
		JPopupMenu menuParent = (JPopupMenu)m.getParent();
		JMenuBar menuBar = (JMenuBar)menuParent.getInvoker().getParent();
		Container c = menuBar;
		while (!(c instanceof Frame)) c = c.getParent();
		return (Frame)c;
	}
	
	private int indexOfMenuItem(JMenu menu, JMenuItem menuItem) {
		for (int i = 0; i < menu.getItemCount(); i++) {
			if (menu.getItem(i) == menuItem) return i;
		}
		return -1;
	}
	
	private void focusWindow(Frame f) {
		if (f.getState() == Frame.ICONIFIED) f.setState(Frame.NORMAL);
		f.toFront();
	}
	
	// MenuListener implementation
	public void menuCanceled(MenuEvent e) {
	}
	
	public void menuDeselected(MenuEvent e) {
	}
	
	public void menuSelected(MenuEvent e) {
		refreshMenu();
	}
}
