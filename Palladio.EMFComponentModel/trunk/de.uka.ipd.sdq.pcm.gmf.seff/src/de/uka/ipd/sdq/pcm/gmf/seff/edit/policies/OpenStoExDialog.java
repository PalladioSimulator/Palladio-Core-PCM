package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dialogs.selection.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;

public class OpenStoExDialog extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		IGraphicalEditPart host = (IGraphicalEditPart) getHost();
		RandomVariable rv = (RandomVariable) ((View)host.getModel()).getElement();
		StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				getContext(rv));
		dialog.setInitialExpression(rv);
		dialog.open();
		if (dialog.getResult() != null) {
			SetRequest setRequest = new SetRequest(
					rv, 
					StoexPackage.eINSTANCE.getRandomVariable_Specification(), 
					new PCMStoExPrettyPrintVisitor().prettyPrint(dialog.getResult()));
			SetValueCommand cmd = new SetValueCommand(setRequest);
			return new ICommandProxy(cmd);
		}
		return null;
	}

	private Parameter[] getContext(EObject rv) {
		Parameter[] parameters = new Parameter[]{};

		if (rv instanceof ParametricResourceDemand) {
			ParametricResourceDemand prd = (ParametricResourceDemand) rv;
			AbstractResourceDemandingAction a = prd.getAction_ParametricResourceDemand();
			EObject container = a;
			while (!((container = container.eContainer()) instanceof ResourceDemandingSEFF))
				container = container.eContainer();
			ResourceDemandingSEFF seff = (ResourceDemandingSEFF) container;
			if (seff.getDescribedService__SEFF() != null && seff.getDescribedService__SEFF().getParameters__Signature() != null)
				parameters = (Parameter[]) seff.getDescribedService__SEFF().getParameters__Signature().toArray();
		}
		return parameters;
	}

}
