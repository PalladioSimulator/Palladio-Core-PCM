package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.xtendworkflow;

import java.util.Map;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import com.google.inject.Injector;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.codegen.simucom.guice.SimuComModule;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.UsageXpt;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

public class UsageModelWorkflowComponent implements IWorkflowComponent {

    private Map<String, Object> systemTransformationSlots;
    private UsageXpt usageXpt;
    
    public UsageModelWorkflowComponent(Map<String, Object> systemTransformationSlots, String basePath) {
        this.systemTransformationSlots = systemTransformationSlots;
        Injector guiceInjector = SimuComModule.getInjector(basePath);
        usageXpt = guiceInjector.getInstance(UsageXpt.class);
    }
    
    @Override
    public void preInvoke() {
    }

    @Override
    public void postInvoke() {
    }

    @Override
    public void invoke(IWorkflowContext ctx) {
        usageXpt.usageModel((UsageModel) systemTransformationSlots.get("usage"),
                (Allocation) systemTransformationSlots.get("allocation"));
    }

}
