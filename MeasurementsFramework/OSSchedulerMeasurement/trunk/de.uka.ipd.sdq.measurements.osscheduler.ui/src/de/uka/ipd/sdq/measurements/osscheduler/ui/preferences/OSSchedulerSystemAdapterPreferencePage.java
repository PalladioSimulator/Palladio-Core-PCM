package de.uka.ipd.sdq.measurements.osscheduler.ui.preferences;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.Constants;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.OSSchedulerSystemAdapterPlugin;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.rmi.RmiServer;

public class OSSchedulerSystemAdapterPreferencePage extends PreferencePage
implements IWorkbenchPreferencePage {
	private Text textRmiIp;
	private Composite comp;
	public OSSchedulerSystemAdapterPreferencePage() {
	}
	
	private String portString = "";
	private String ipString = "";
	private Button detectIpButton = null;
	private Label labelRmiIp;
	private Label labelRmiPort; 
	private Text textRmiPort;

	@Override
	protected Control createContents(Composite parent) {
		comp = new Composite(parent, SWT.FILL);
		comp.setLayout(new GridLayout(3, false));
		
		labelRmiIp = new Label(comp, SWT.NONE);
		labelRmiIp.setText("System Adapter RMI IP");
		
		textRmiIp = new Text(comp, SWT.BORDER | SWT.LEFT );
		textRmiIp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRmiIp.setText(ipString);
		
		detectIpButton = new Button (comp, SWT.NONE);
		detectIpButton.setText("Detect IP...");
		detectIpButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		detectIpButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				detectIpButton.setEnabled(false);
				String oldIp = textRmiIp.getText();
				textRmiIp.setText("Detecting...");
				String newIp = RmiServer.detectIp();
				if (newIp!=null) {
					textRmiIp.setText(newIp);
				} else {
					textRmiIp.setText(oldIp);
				}
				detectIpButton.setEnabled(true);
			}
			
		});
		
		labelRmiPort = new Label(comp, SWT.NONE);
		labelRmiPort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelRmiPort.setText("System Adapter RMI Port");
		
		textRmiPort = new Text(comp, SWT.BORDER);
		textRmiPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		textRmiPort.setText(portString);
		return comp;
	}

	@Override
	public void init(IWorkbench workbench) {
		ipString = OSSchedulerSystemAdapterPlugin.getDefault().getPreference(Constants.PreferenceKeySystemAdapterIp);
		portString = OSSchedulerSystemAdapterPlugin.getDefault().getPreference(Constants.PreferenceKeySystemAdapterPort);
		setDescription("Properties of the System Adapter");
	}
	
	@Override
	protected void performApply() {
		IEclipsePreferences preferences = new InstanceScope().getNode(OSSchedulerSystemAdapterPlugin.PLUGIN_ID);
		preferences.put(Constants.PreferenceKeySystemAdapterIp, textRmiIp.getText());
		preferences.put(Constants.PreferenceKeySystemAdapterPort, textRmiPort.getText());
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			
		}
		super.performApply();
	}
	
	@Override
	protected void performDefaults() {
		IEclipsePreferences preferences = new DefaultScope().getNode(OSSchedulerSystemAdapterPlugin.PLUGIN_ID);
		textRmiIp.setText(preferences.get(Constants.PreferenceKeySystemAdapterIp, null));
		textRmiPort.setText(preferences.get(Constants.PreferenceKeySystemAdapterPort, null));
		super.performDefaults();
	}


}
