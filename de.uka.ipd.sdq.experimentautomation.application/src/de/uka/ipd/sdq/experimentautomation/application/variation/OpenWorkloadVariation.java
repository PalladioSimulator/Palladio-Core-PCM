package de.uka.ipd.sdq.experimentautomation.application.variation;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

public class OpenWorkloadVariation implements IVariationStrategy {

	private OpenWorkload workload;

	public void setVariedObject(EObject o) {
		if (!UsageScenario.class.isInstance(o)) {
			throw new RuntimeException("Expected a UsageScenario, but encountered a " + o.getClass().getName());
		}
		UsageScenario s = (UsageScenario) o;

		if (!OpenWorkload.class.isInstance(s.getWorkload_UsageScenario())) {
			throw new RuntimeException("Expected a UsageScenario containing an OpenWorkload, but encountered a " + s.getWorkload_UsageScenario().getClass().getName());
		}
		this.workload = (OpenWorkload) s.getWorkload_UsageScenario();
	}

	@Override
	public String vary(long value) {
		// int intValue;
		// if (value > Integer.MAX_VALUE) {
		// logger.warn("Warning: Converted long to int, but the value was larger than MAXINT.");
		// intValue = Integer.MAX_VALUE;
		// } else {
		// intValue = new Long(value).intValue();
		// }
		PCMRandomVariable var = CoreFactory.eINSTANCE.createPCMRandomVariable();
		// var.setOpenWorkload_PCMRandomVariable(workload);
		var.setSpecification(new Long(value).toString());
		workload.setInterArrivalTime_OpenWorkload(var);

		return "Open workload interarrival time = " + value + ": " + workload.eClass().getName() + " of " + PCMEntityHelper.toString(workload.getUsageScenario_Workload());
	}

}
