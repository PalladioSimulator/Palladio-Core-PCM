package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.WorkflowHooks;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtendableTabGroup;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

/**
 * The class defines tabs for the SimuBench Launch configuration menu.
 * 
 * @author Roman Andrej
 */
public class SimuTabGroup extends ExtendableTabGroup {
    
    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
        ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
		tabs.add(new FileNamesInputTab());// Default tab
        tabs.add(new SimuComConfigurationTab());
        tabs.add(new SimuConfigurationTab());
        for (String workflowExtensionPointId : WorkflowHooks.getAllWorkflowHookIDs()) {
            tabs.addAll(createExtensionTabs(dialog, mode, workflowExtensionPointId));
        }
        tabs.add(new FeatureOptionsTab());
        //tabs.add(new CipCompletionTab());
		tabs.add(commonTab);
        setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
    }
}
