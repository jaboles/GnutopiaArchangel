//
//  ClipboardChangeListener.java
//  Archangel
//
//  Created by Jonathan Boles on 27/01/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
package jb.ga.ui;
import jb.ga.util.*;
import jb.ga.data.*;
import jb.ga.formatters.*;
import javax.swing.event.*;
import java.awt.event.*;

public class ClipboardChangeListener implements ChangeListener {
	private UI ui;
	
	
	public ClipboardChangeListener(UI ui) {
		this.ui = ui;
	}

	public void stateChanged(ChangeEvent e) {
		String report;
		
		// Try for a survey
		Survey s = SelfSurveyFormatter.getInstance().read(Pasteboard.getInstance().get());
		if (s != null) {
			report = s.toReport();
			Pasteboard.getInstance().put(report);
			ui.getClipboardWindow().display(report);
			ui.getBuildingCalculatorWindow().loadSurvey(s);
			return;
		}
	}
}
