package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

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

import de.uka.ipd.sdq.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.repository.Parameter;
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
				getExpectedType(rv),rv);
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

}
