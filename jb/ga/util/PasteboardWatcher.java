// Decompiled by DJ v3.8.8.85 Copyright 2005 Atanas Neshkov  Date: 5/05/2005 2:43:59 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PasteboardWatcher.java

package jb.ga.util;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package archangel:
//            Pasteboard, Archangel

public class PasteboardWatcher extends Thread
{
    private Pasteboard pasteboard;
    private String olddata;
    private String newdata;
    private List listeners;
    private boolean enabled;
	
    public PasteboardWatcher(Pasteboard pasteboard) {
        enabled = true;
        this.pasteboard = pasteboard;
		listeners = new LinkedList();
        newdata = pasteboard.get();
        olddata = pasteboard.get();
    }

    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

	public void setEnabled(boolean b) {
        newdata = pasteboard.get();
        olddata = newdata;
		enabled = b;
	}

    public void run() {
        try {
            while(true) {
                Thread.sleep(400L);
                if(enabled) {
                    newdata = pasteboard.get();
                    if(!newdata.equals(olddata)) {
						ChangeEvent e = new ChangeEvent(pasteboard);
						Iterator it = listeners.iterator();
						while(it.hasNext()) {
							((ChangeListener)it.next()).stateChanged(e);
						}
                        olddata = newdata;
                    }
                } else {
                    newdata = pasteboard.get();
                    olddata = newdata;
                }
            }
        }
        catch(InterruptedException e) { }
        catch(Exception e) {
            System.err.println(e);
			e.printStackTrace(System.err);
        }
    }
}