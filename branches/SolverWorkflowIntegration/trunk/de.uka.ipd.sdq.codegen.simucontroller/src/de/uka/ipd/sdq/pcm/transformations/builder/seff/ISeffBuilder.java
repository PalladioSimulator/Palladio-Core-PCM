package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.List;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.transformations.builder.IBuilder;

public interface ISeffBuilder extends IBuilder {

	List<ResourceDemandingSEFF> getSeffs();

}