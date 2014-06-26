package de.uka.ipd.sdq.experimentautomation.application.variation;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

public class ClosedWorkloadVariation implements IVariationStrategy {

    private static final Logger logger = Logger.getLogger(ClosedWorkloadVariation.class);

    private ClosedWorkload workload;

    public void setVariedObject(EObject o) {
        if (!UsageScenario.class.isInstance(o)) {
            throw new RuntimeException("Expected a UsageScenario, but encountered a " + o.getClass().getName());
        }
        UsageScenario s = (UsageScenario)o;
        
        if(!ClosedWorkload.class.isInstance(s.getWorkload_UsageScenario())) {
            throw new RuntimeException("Expected a UsageScenario containing a ClosedWorkload, but encountered a " + s.getWorkload_UsageScenario().getClass().getName());
        }
        this.workload = (ClosedWorkload) s.getWorkload_UsageScenario();
    }

    @Override
    public String vary(long value) {
        int intValue;
        if (value > Integer.MAX_VALUE) {
            logger.warn("Warning: Converted long to int, but the value was larger than MAXINT.");
            intValue = Integer.MAX_VALUE;
		} else {
			intValue = new Long(value).intValue();
		}
        workload.setPopulation(intValue);

        return "Closed workload population = " + value + ": " + workload.eClass().getName() + " of "
                + PCMEntityHelper.toString(workload.getUsageScenario_Workload());
    }

}
