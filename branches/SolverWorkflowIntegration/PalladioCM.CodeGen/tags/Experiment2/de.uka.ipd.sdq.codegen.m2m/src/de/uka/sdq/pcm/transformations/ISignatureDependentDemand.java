package de.uka.sdq.pcm.transformations;

import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

public interface ISignatureDependentDemand {
	String getDemand(Signature signature);
	ProcessingResourceType getType();
}
