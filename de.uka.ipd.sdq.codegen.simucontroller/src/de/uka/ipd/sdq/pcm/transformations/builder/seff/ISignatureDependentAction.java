package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;

public interface ISignatureDependentAction {

	void setCurrentSignature(OperationSignature sig);

}