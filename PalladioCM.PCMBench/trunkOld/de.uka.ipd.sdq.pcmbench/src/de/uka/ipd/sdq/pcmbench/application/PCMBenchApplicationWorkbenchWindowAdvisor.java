package de.uka.ipd.sdq.pcmbench.application;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class PCMBenchApplicationWorkbenchWindowAdvisor extends
		WorkbenchWindowAdvisor {

	public PCMBenchApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new PCMBenchApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(700, 550));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(true);
        configurer.setShowPerspectiveBar(true);
        configurer.setTitle("Palladio Component Model Modelling Bench");
    }

}
