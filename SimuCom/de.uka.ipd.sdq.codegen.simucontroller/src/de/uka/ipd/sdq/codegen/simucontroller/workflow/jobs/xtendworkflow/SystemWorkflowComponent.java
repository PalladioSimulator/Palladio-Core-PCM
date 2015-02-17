package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.xtendworkflow;

import java.util.Map;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import com.google.inject.Injector;

import de.uka.ipd.sdq.pcm.codegen.simucom.guice.SimuComModule;
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.SystemXpt;
import de.uka.ipd.sdq.pcm.system.System;

public class SystemWorkflowComponent implements IWorkflowComponent {

    private SystemXpt systemXpt;
    private Map<String, Object> systemTransformationSlots;

    public SystemWorkflowComponent(Map<String, Object> systemTransformationSlots, String basePath) {
        this.systemTransformationSlots = systemTransformationSlots;
        Injector guiceInjector = SimuComModule.getInjector(basePath);
        systemXpt = guiceInjector.getInstance(SystemXpt.class);
    }

    @Override
    public void preInvoke() {
    }

    @Override
    public void postInvoke() {
    }

    @Override
    public void invoke(IWorkflowContext ctx) {
        systemXpt.root((System) systemTransformationSlots.get("system"));
    }

}
