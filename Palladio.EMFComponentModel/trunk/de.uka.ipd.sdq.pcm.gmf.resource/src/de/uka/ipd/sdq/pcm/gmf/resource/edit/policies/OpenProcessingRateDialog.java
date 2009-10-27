package de.uka.ipd.sdq.pcm.gmf.resource.edit.policies;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenProcessingRateDialog extends OpenStoExDialog {

	
	@Override
	protected RandomVariable getRandomVariable(EObject parent) {
		ProcessingResourceSpecification resourceSpecification = (ProcessingResourceSpecification) parent;
		RandomVariable rv = resourceSpecification.getProcessingRate_ProcessingResourceSpecification();
		return rv;
	}

	@Override
	protected TypeEnum getExpectedType(RandomVariable rv) {
		return TypeEnum.DOUBLE;
	}
	
}
