package de.uka.ipd.sdq.pcm.gmf.system;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.PcmExtNodeLabelEditPart;

public class XYLayoutLabel extends PcmExtNodeLabelEditPart {

	public XYLayoutLabel(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	public void refreshBounds() {
		IFigure refFigure = ((GraphicalEditPart) getParent()).getFigure();
		int dx = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int dy = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		Point offset = new Point(dx, dy);
		getFigure().getParent().setConstraint(getFigure(),relocate(offset,getFigure()));
	}

	public Rectangle relocate(Point offset, IFigure target) {
		Point location = getReferencePoint().getTranslated(
				offset);
		location.translate(-target.getBounds().width / 2, 0);
		Rectangle result = new Rectangle();
		result.setLocation(location);
		result.setSize(new Dimension(
			target.getPreferredSize().width, target
					.getPreferredSize().height));
		return result;
	}	
}
