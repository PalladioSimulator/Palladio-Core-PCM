package de.uka.ipd.sdq.dsexplore.helper;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;

public class DegreeOfFreedomHelper {

	public static String getDegreeDescription(DegreeOfFreedomInstance decision) {
		String suffix = "";
		if (decision instanceof ProcessingResourceDegree){
			suffix = ":"+((ProcessingResourceDegree)decision).getProcessingresourcetype().getEntityName();
		}
		
		String primaryChangeableName = decision.getPrimaryChanged().toString();
		if (decision.getPrimaryChanged() instanceof Entity){
			primaryChangeableName = ((Entity)decision.getPrimaryChanged()).getEntityName();
		}
		
		return decision.getClass().getSimpleName() + ":" + primaryChangeableName + suffix;
	}

}
