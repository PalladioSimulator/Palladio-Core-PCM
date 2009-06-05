package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenStoExDialog extends OpenEditPolicy {

	protected RandomVariable getRandomVariable(EObject parent) {
		// Default Implementation. Override as necessary
		return (RandomVariable)parent;
	}
	
	@Override
	protected Command getOpenCommand(Request request) {
		IGraphicalEditPart host = (IGraphicalEditPart) getHost();
		RandomVariable rv = getRandomVariable(((View)host.getModel()).getElement());
		StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				getExpectedType(rv));
		dialog.setInitialExpression(rv);
		dialog.open();
		if (dialog.getReturnCode() == Dialog.OK) {
			SetRequest setRequest = new SetRequest(
					rv, 
					StoexPackage.eINSTANCE.getRandomVariable_Specification(), 
					new PCMStoExPrettyPrintVisitor().prettyPrint(dialog.getResult()));
			SetValueCommand cmd = new SetValueCommand(setRequest);
			return new ICommandProxy(cmd);
		}
		return null;
	}

	protected TypeEnum getExpectedType(RandomVariable rv) {
		TypeEnum expectedType = TypeEnum.ANY; 
		if (rv instanceof VariableCharacterisation){
			expectedType = StochasticExpressionEditDialog.getTypeFromVariableCharacterisation((VariableCharacterisation) rv);
		}
		return expectedType;
	}
	
	private Parameter[] getContext(EObject rv) {
		Parameter[] parameters = new Parameter[]{};

		ResourceDemandingSEFF seff = getSEFF(
				rv);

		// Hauck 2008.11.19: Test first if Seff has a Signature. It could also be a ResourceService!
		// TODO: return demand parameter if Seff has a ResourceService
		if (seff != null && seff.getDescribedService__SEFF() != null) {
			if (seff.getDescribedService__SEFF() instanceof Signature) {
				Signature sig = (Signature)seff.getDescribedService__SEFF();
				if (sig.getParameters__Signature() != null) {
					parameters = (Parameter[]) sig.getParameters__Signature().toArray();
				}
			}
		}

		return parameters;
	}

	private ResourceDemandingSEFF getSEFF(EObject a) {
		EObject container = a;
		while (!(container instanceof ResourceDemandingSEFF))
			container = container.eContainer();
		if (!(container instanceof ResourceDemandingSEFF)) 
			return null;
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF) container;
		return seff;
	}

}
