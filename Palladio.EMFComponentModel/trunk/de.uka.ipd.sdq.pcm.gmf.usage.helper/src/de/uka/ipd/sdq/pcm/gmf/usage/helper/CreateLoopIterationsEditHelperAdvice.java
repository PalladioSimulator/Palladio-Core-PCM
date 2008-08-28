package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

public class CreateLoopIterationsEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
		// TODO: Better solve this by using a CompositeCommand...
		PCMRandomVariable pcmRdVar = CoreFactory.eINSTANCE.createPCMRandomVariable();
		pcmRdVar.setSpecification("1");
			
		SetRequest setRequest = new SetRequest(request.getElementToConfigure(), 
				UsagemodelPackage.eINSTANCE.getLoop_LoopIteration_Loop(),
				pcmRdVar);
		
		SetValueCommand cmd = new SetValueCommand(setRequest);

		return cmd;
	}
}
