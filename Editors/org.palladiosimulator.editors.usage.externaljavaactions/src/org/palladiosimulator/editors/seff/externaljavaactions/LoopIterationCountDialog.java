package org.palladiosimulator.editors.seff.externaljavaactions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.editors.ui.dialog.OpenStoExDialog;
import org.palladiosimulator.pcm.usagemodel.Loop;

import de.uka.ipd.sdq.stoex.RandomVariable;

public class LoopIterationCountDialog extends OpenStoExDialog {

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	@Override
	public RandomVariable getRandomVariable(EObject element) {
		Loop l = (Loop) element;
		return l.getLoopIteration_Loop();
	}

}
