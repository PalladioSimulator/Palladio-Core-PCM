package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.eventsim.EventSimToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.simcomp.SimCompToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom.SimuComToolAdapter;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventsimPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimcompPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimucomPackage;

public class AnalysisToolFactory {

    public static IToolAdapter createToolAdapater(ToolConfiguration configuration) {
        assert configuration != null : "The configuration may not be null";
        if (SimucomPackage.eINSTANCE.getSimuComConfiguration().isInstance(configuration)) {
            return new SimuComToolAdapter();
        } else if (EventsimPackage.eINSTANCE.getEventSimConfiguration().isInstance(configuration)) {
            return new EventSimToolAdapter();
        } else if (SimcompPackage.eINSTANCE.getSimCompConfiguration().isInstance(configuration)) {
        	return new SimCompToolAdapter();
        }
        throw new RuntimeException("Unknown tool configuration type: " + configuration.eClass().getName());
    }

}
