package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.usagemodel.LoopIterations;
import de.uka.ipd.sdq.stoex.StoexPackage;

public class LoopIterationsEditHelper extends AbstractEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		LoopIterations it = (LoopIterations) req.getElementToConfigure();
		SetRequest r = new SetRequest(it, StoexPackage.eINSTANCE.getRandomVariable_Specification(), "0");
		return new SetValueCommand(r);
	}

}
