package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.repository.Signature;

public interface ISignatureDependentAction {

	void setCurrentSignature(Signature sig);

}