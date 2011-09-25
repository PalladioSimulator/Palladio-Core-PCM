package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.cip.runtime.runconfig.tabs.CipCompletionTab;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.WorkflowHooks;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtendableTabGroup;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

/**
 * The class defines tabs for the SimuBench Launch configuration menu.
 * 
 * @author Roman Andrej
 */
public class SimuTabGroup extends ExtendableTabGroup {
    
    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID = "workflow.extension.simucom";

    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
        tabs.add(new FileNamesInputTab());// Default tab
        tabs.add(new SimuComConfigurationTab());
        tabs.add(new SimuConfigurationTab());
        for (String workflowExtensionPointId : WorkflowHooks.getAllWorkflowHookIDs()) {
            tabs.addAll(createExtensionTabs(dialog, mode, workflowExtensionPointId));
        }
        tabs.add(new FeatureOptionsTab());
        tabs.add(new CipCompletionTab());
        setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
    }
}
