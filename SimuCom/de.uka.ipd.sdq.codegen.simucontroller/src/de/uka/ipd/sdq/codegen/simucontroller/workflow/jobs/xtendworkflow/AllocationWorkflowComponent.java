package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.xtendworkflow;

import java.util.Map;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import com.google.inject.Injector;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.codegen.simucom.guice.SimuComModule;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.AllocationXpt;

public class AllocationWorkflowComponent implements IWorkflowComponent {

    private AllocationXpt allocationXpt;
    private Map<String, Object> systemTransformationSlots;

    public AllocationWorkflowComponent(Map<String, Object> systemTransformationSlots, String basePath) {
        this.systemTransformationSlots = systemTransformationSlots;
        Injector guiceInjector = SimuComModule.getInjector(basePath);
        allocationXpt = guiceInjector.getInstance(AllocationXpt.class);
    }

    @Override
    public void preInvoke() {
    }

    @Override
    public void postInvoke() {
    }

    @Override
    public void invoke(IWorkflowContext ctx) {
        allocationXpt.allocationTM((Allocation) systemTransformationSlots.get("allocation"));
    }

}
