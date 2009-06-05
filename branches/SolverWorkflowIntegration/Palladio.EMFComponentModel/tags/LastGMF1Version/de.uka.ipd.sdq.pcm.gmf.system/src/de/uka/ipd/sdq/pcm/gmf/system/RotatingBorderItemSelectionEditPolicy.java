/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.system;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Snowball
 *
 */
public class RotatingBorderItemSelectionEditPolicy extends
		BorderItemSelectionEditPolicy {

	/**
	 * 
	 */
	public RotatingBorderItemSelectionEditPolicy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the command contribution to a change bounds request.
	 * 
	 * @param request
	 *            the change bounds requesgt
	 * @return the command contribution to the request
	 */
	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		IBorderItemEditPart borderItemEP = (IBorderItemEditPart) getHost();
		IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();
		
		if (borderItemLocator != null) {
			PrecisionRectangle rect = new PrecisionRectangle(
				getInitialFeedbackBounds().getCopy());
			getHostFigure().translateToAbsolute(rect);
			rect.translate(request.getMoveDelta());
			rect.resize(request.getSizeDelta());

			getHostFigure().translateToRelative(rect);
			Rectangle realLocation = borderItemLocator.getValidLocation(rect
				.getCopy(), borderItemEP.getFigure());

			Point parentOrigin = ((IGraphicalEditPart) borderItemEP.getParent())
				.getFigure().getBounds().getTopLeft();
			Dimension d = realLocation.getTopLeft().getDifference(parentOrigin);
			Point location = new Point(d.width, d.height);
			Rectangle rec = new Rectangle(location,realLocation.getSize());

			ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(),
				DiagramUIMessages.Commands_MoveElement, new EObjectAdapter(
					(View) getHost().getModel()), rec);
			return new ICommandProxy(moveCommand);
		}
		return null;
	}
}
