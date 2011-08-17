package de.uka.ipd.sdq.dsexplore.helper;

import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;

public class DegreeOfFreedomHelper {

	public static String getDegreeDescription(DegreeOfFreedom decision) {
		return decision.getClass().getSimpleName() + ":" + decision.getPrimaryChanged().getEntityName();
	}

}
