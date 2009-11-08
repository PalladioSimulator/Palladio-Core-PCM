package de.uka.ipd.sdq.measurements.ui;


import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MainPreferencePage extends PreferencePage
implements IWorkbenchPreferencePage {

	@Override
	protected Control createContents(Composite parent) {
		Composite comp = new Composite(parent, SWT.FILL);
		//return new GridLayout(SWT.FILL);
		return comp;
	}

	@Override
	public void init(IWorkbench workbench) {
	}

}
