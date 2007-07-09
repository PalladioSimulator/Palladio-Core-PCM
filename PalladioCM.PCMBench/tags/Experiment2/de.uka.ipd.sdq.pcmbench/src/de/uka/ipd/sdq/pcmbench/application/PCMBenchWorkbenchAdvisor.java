package de.uka.ipd.sdq.pcmbench.application;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class PCMBenchWorkbenchAdvisor extends WorkbenchAdvisorHack {

	private static final String PCMBENCH_PERSPECTIVE_ID = "de.uka.ipd.sdq.PCMBench.perspective";
	//private static final String PCMBENCH_PERSPECTIVE_ID = "de.uka.ipd.sdq.pcmbench.componentdeveloper_perspective";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new PCMBenchApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    public void initialize(IWorkbenchConfigurer configurer) {
        super.initialize(configurer);
        configurer.setSaveAndRestore(true);
    }

	public String getInitialWindowPerspectiveId() {
		return PCMBENCH_PERSPECTIVE_ID;
	}
}