package de.uka.ipd.sdq.simucom.rerunSimulation.runconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComConfigurationTab;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.WorkflowHooks;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtendableTabGroup;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

public class RerunSimulationTabGroup extends ExtendableTabGroup {

    public RerunSimulationTabGroup() {
    }
    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
        ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
        tabs.add(new GeneratedProjectChooseSimulationTab());
        tabs.add(new SimuComConfigurationTab(ConstantsContainer.SIMUBENCH_SIMULATION_NAME));
        for (String workflowExtensionPointId : WorkflowHooks.getAllWorkflowHookIDs()) {
            tabs.addAll(createExtensionTabs(dialog, mode, workflowExtensionPointId));
        }
        tabs.add(commonTab);
        setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
    }

}
