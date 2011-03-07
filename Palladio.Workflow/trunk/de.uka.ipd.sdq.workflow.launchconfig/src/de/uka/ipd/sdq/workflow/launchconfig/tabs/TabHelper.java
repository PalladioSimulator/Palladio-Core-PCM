package de.uka.ipd.sdq.workflow.launchconfig.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTabGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

/**
 * Provides methods helpful when working with {@link ILaunchConfiguration} and related classes.
 * 
 * @author pmerkle
 * 
 */
public class TabHelper {

	/**
	 * Given an {@link ILaunchConfigurationTabGroup}, this method constructs an
	 * {@link CTabFolder} containing the same tabs as the passed
	 * ILaunchConfigurationTabGroup.
	 * <p>
	 * Note that the resulting tab folder does not support launch-specific 
	 * methods like {@link ILaunchConfigurationTabGroup#performApply(ILaunchConfigurationWorkingCopy)}.
	 * If the tab folder is intended to work in an launch configuration environment 
	 * (e.g. in a nested tab setting), use delegates to the corresponding methods 
	 * of the tabs provided by the passed tabGroup.   
	 * 
	 * @param tabGroup the tab group from which the CTabFolder will be created
	 * @param dialog see {@link ILaunchConfigurationTabGroup#createTabs(ILaunchConfigurationDialog, String)
	 * @param mode see {@link ILaunchConfigurationTabGroup#createTabs(ILaunchConfigurationDialog, String)
	 * @param parent see {@link Composite#Composite(Composite, int)}
	 * @param style see {@link Composite#Composite(Composite, int)}
	 * @return
	 */
	public static CTabFolder createTabFolder(
			ILaunchConfigurationTabGroup tabGroup,
			ILaunchConfigurationDialog dialog, String mode, Composite parent,
			int style) {
		tabGroup.createTabs(dialog, mode);
		ILaunchConfigurationTab[] tabs = tabGroup.getTabs();
		
		CTabFolder tabFolder = new CTabFolder(parent, style);
		for(int i = 0; i<tabGroup.getTabs().length; i++) {
			ILaunchConfigurationTab tab = tabs[i];
			tab.setLaunchConfigurationDialog(dialog);
			tab.createControl(tabFolder);
			
			CTabItem tabItem = new CTabItem(tabFolder, SWT.NULL);
			tabItem.setText(tab.getName());
			tabItem.setControl(tab.getControl());
		}
		tabFolder.setSelection(0);
		
		return tabFolder;
	}
	
}
