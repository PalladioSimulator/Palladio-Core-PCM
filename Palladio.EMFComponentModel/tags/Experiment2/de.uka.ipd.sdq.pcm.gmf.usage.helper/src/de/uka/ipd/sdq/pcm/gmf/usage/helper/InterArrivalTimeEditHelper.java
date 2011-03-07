package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.usagemodel.InterArrivalTime;
import de.uka.ipd.sdq.stoex.StoexPackage;

public class InterArrivalTimeEditHelper extends AbstractEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		InterArrivalTime t = (InterArrivalTime) req.getElementToConfigure();
		SetRequest r = new SetRequest(t, StoexPackage.eINSTANCE.getRandomVariable_Specification(), "0");
		return new SetValueCommand(r);
	}
}
