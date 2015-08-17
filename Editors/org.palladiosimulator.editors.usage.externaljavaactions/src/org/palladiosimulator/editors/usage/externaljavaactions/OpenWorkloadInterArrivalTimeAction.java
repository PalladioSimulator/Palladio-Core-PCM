package org.palladiosimulator.editors.usage.externaljavaactions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DNodeListElement;
import org.palladiosimulator.editors.ui.dialog.OpenStoExDialog;
import org.palladiosimulator.pcm.usagemodel.OpenWorkload;

import de.uka.ipd.sdq.stoex.RandomVariable;

public class OpenWorkloadInterArrivalTimeAction extends OpenStoExDialog {

	public OpenWorkloadInterArrivalTimeAction() {

	}

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	@Override
	public RandomVariable getRandomVariable(DNodeListElement element) {
		OpenWorkload ow = (OpenWorkload) element.getTarget();
		return ow.getInterArrivalTime_OpenWorkload();
	}

}
