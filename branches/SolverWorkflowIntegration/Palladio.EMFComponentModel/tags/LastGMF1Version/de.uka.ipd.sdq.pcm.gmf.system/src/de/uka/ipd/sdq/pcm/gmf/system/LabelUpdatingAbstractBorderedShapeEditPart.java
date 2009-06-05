package de.uka.ipd.sdq.pcm.gmf.system;

import java.util.List;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

public abstract class LabelUpdatingAbstractBorderedShapeEditPart extends
		AbstractBorderedShapeEditPart {

	public LabelUpdatingAbstractBorderedShapeEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 */
	public void refreshChildLabels() {
		for (AbstractEditPart editPart : (List<AbstractEditPart>)getChildren())
		{
			if (editPart instanceof IBorderItemEditPart)
			{
				for (GraphicalEditPart childEditPart : (List<GraphicalEditPart>)editPart.getChildren())
				{
					if (childEditPart instanceof LabelEditPart)
						((LabelEditPart)childEditPart).refreshBounds();
				}
			}
		}	
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	@Override
	protected NodeFigure createMainFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 */
	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		getBorderedFigure().getBorderItemContainer().getLayoutManager().layout(getBorderedFigure().getBorderItemContainer());
		refreshChildLabels();
	}	
	
    public DragTracker getDragTracker(Request request) {
        return new DragEditPartsTrackerEx(this){

			/* (non-Javadoc)
			 * @see org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx#executeCurrentCommand()
			 */
			@Override
			protected void executeCurrentCommand() {
				super.executeCurrentCommand();
				refreshChildLabels();
			}
        	
        };
    }	
}
