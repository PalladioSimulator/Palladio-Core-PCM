package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

/**
 * Baseclass for both --( and --() type UML style border figures
 * 
 * @author Philipp Meier
 */
abstract public class AbstractBorderFigure extends DefaultSizeNodeFigure {

	/**
	 * position type of the figure. internal or external.
	 * internal means the figure is connected towards the outside
	 * external means the figure is connected towards the inside
	 */
	public static enum POSITION_TYPE {
		/** conntected towards the outside */
		POS_INTERNAL ,
		
		/** connected towards the inside */
		POS_EXTERNAL 
	}
	
	private POSITION_TYPE myPosType;
	
	/**
	 * reference to the anchor to be used.
	 */
	private ConnectionAnchor myAnchor = null;
	
	/**
	 * @param size width and hight of the figure in logical units (LP)
	 */
	public AbstractBorderFigure(int logicalSize, POSITION_TYPE posType) {
		super(logicalSize, logicalSize);
		myPosType = posType;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		// 
		super.paintFigure(graphics);
		//Next line needed for better display of Ports on Mac OS
		graphics.setLineWidthFloat(new Float(1.01));
	}



	/**
	 * Helper function to get the parent's border item locator
	 * 
	 * @return the parent's border item locator
	 */
	protected IBorderItemLocator getBorderItemLocator() {
		IFigure parentFigure = this.getParent().getParent();
		if (parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(
				this.getParent());
			if (constraint instanceof IBorderItemLocator) {
				return (IBorderItemLocator) constraint;
			}
		}
		return null;
	}
	
	/**
	 * factory method for the anchor to be used when figure is
	 * in an internal position
	 * 
	 * @return a reference to the new anchor. must not be null
	 */
	abstract protected ConnectionAnchor createAnchorInternal();
	
	/**
	 * factory method for the anchor to be used when figure is
	 * in an external position
	 * 
	 * @return a reference to the new anchor. must not be null
	 */
	abstract protected ConnectionAnchor createAnchorExternal();
	
	public ConnectionAnchor getConnectionAnchor(String terminal) {
		if (myAnchor == null) {
			if (myPosType == POSITION_TYPE.POS_INTERNAL) {
				myAnchor = createAnchorInternal();
			}
			
			if (myPosType == POSITION_TYPE.POS_EXTERNAL) {
				myAnchor = createAnchorExternal();
			}
		}
		assert(myAnchor != null);
		
		return myAnchor;
	}		
	
	/**
	 * @return the end position of the -- part of the figure
	 * relative to the position of the figure
	 */
	private Point getStemPosition() {
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = getBounds();
		Point result = null;
		
		switch(side){
		case PositionConstants.EAST:
			result = new Point(rect.getLeft().x, rect.getCenter().y);
			break;
		case PositionConstants.WEST:
			result = new Point(rect.getRight().x, rect.getCenter().y);
			break;
		case PositionConstants.NORTH:
			result = new Point(rect.getCenter().x, rect.getBottom().y);
			break;
		case PositionConstants.SOUTH:
			result = new Point(rect.getCenter().x, rect.getTop().y);
			break;
		}
		return result;
	}	
	
	/**
	 * places the anchor point at the -- part of the figure. 
	 * this class is to be used by subclasses
	 */
	protected class StemAnchor extends AbstractConnectionAnchor {

		public StemAnchor(IFigure owner) {
			super(owner);
		}
		
		public Point getLocation(Point reference) {
			Point p = getStemPosition();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

}
