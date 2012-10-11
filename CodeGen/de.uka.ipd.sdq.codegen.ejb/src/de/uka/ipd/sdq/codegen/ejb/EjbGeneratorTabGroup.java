package de.uka.ipd.sdq.codegen.ejb;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ProtocomFileNamesInputTab;

/**
 * The class defines tabs for the SimuBench Launch configuration menu.
 * 
 * @author Roman Andrej
 */
public class EjbGeneratorTabGroup extends AbstractLaunchConfigurationTabGroup {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new ProtocomFileNamesInputTab(),
				new CodeGenerationConfigurationTab(),
				commonTab
		};
		setTabs(tabs);
	}
}
