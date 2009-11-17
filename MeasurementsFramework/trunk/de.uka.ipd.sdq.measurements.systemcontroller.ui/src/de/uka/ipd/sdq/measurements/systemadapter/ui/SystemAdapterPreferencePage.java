package de.uka.ipd.sdq.measurements.systemadapter.ui;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

public class SystemAdapterPreferencePage extends PreferencePage
implements IWorkbenchPreferencePage {
	private Text textRmiIp;
	private Composite comp;
	public SystemAdapterPreferencePage() {
	}
	
	private String portString = null;
	private String ipString = null;
	private Label labelRmiIp;
	private Label labelRmiPort; 
	private Text textRmiPort;

	@Override
	protected Control createContents(Composite parent) {
		comp = new Composite(parent, SWT.FILL);
		comp.setLayout(new GridLayout(2, false));
		
		labelRmiIp = new Label(comp, SWT.NONE);
		labelRmiIp.setText("System Adapter RMI IP");
		
		textRmiIp = new Text(comp, SWT.BORDER | SWT.LEFT );
		textRmiIp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRmiIp.setText(ipString);
		
		labelRmiPort = new Label(comp, SWT.NONE);
		labelRmiPort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelRmiPort.setText("System Adapter RMI Port");
		
		textRmiPort = new Text(comp, SWT.BORDER);
		textRmiPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRmiPort.setText(portString);
		return comp;
	}

	@Override
	public void init(IWorkbench workbench) {
		IEclipsePreferences preferences = new InstanceScope().getNode(de.uka.ipd.sdq.measurements.systemadapter.Activator.PLUGIN_ID);
		IEclipsePreferences defaultPreferences = new DefaultScope().getNode(de.uka.ipd.sdq.measurements.systemadapter.Activator.PLUGIN_ID);
		ipString = preferences.get("rmiIp", defaultPreferences.get("rmiIp", ""));
		portString = preferences.get("rmiPort", defaultPreferences.get("rmiPort", ""));
		setDescription("Properties of the System Adapter");
	}
	
	@Override
	protected void performApply() {
		IEclipsePreferences preferences = new InstanceScope().getNode(de.uka.ipd.sdq.measurements.systemadapter.Activator.PLUGIN_ID);
		preferences.put("rmiIp", textRmiIp.getText());
		preferences.put("rmiPort", textRmiPort.getText());
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			
		}
		super.performApply();
	}
	
	@Override
	protected void performDefaults() {
		IEclipsePreferences preferences = new DefaultScope().getNode(de.uka.ipd.sdq.measurements.systemadapter.Activator.PLUGIN_ID);
		textRmiIp.setText(preferences.get("rmiIp", null));
		textRmiPort.setText(preferences.get("rmiPort", null));
		super.performDefaults();
	}


}
