package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

public class ForkActionHelperAdvice extends AbstractEditHelperAdvice implements
		IEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		IElementType elementType = ElementTypeRegistry.getInstance().
		getType("de.uka.ipd.sdq.pcm.gmf.seff.SynchronisationPoint_9001");
		CreateElementRequest req=new CreateElementRequest(request.getElementToConfigure(),elementType,SeffPackage.eINSTANCE.getForkAction_SynchronisingBehaviours_ForkAction());
		CreateElementCommand cmd=new CreateElementCommand(req);
		return cmd;
	}
	
	

}
