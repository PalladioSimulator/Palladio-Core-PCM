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
 * Represents the UML style --( border figure
 * which rotates depending on the side the figure
 * is located in relation to it's parent. *
 */
public class SocketFigure extends DefaultSizeNodeFigure {
	
	BallAnchor myAnchor;

	/**
	 * @param size width and hight of the figure in logical units (LP)
	 */
	public SocketFigure(int logicalSize) {
		super(logicalSize, logicalSize);
		myAnchor = new BallAnchor(this);
	}
	
	/**
	 * Helper function to get the parent's border item locator
	 * 
	 * @return the parent's border item locator
	 */
	private IBorderItemLocator getBorderItemLocator() {
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
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = new Rectangle();
		graphics.getClip(rect);
	
		switch(side){
		case PositionConstants.EAST:
			graphics.drawLine(rect.getLeft().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x, rect.getTop().y+rect.height/4, rect.height/2, rect.height/2, 90, 180);
			break;
		case PositionConstants.WEST:
			graphics.drawLine(rect.getRight().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getLeft().x, rect.getTop().y+rect.height/4, rect.height/2, rect.height/2, -90, 180);
			break;
		case PositionConstants.NORTH:
			graphics.drawLine(rect.getCenter().x,rect.getBottom().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x-rect.width/4, rect.getTop().y, rect.height/2, rect.height/2, 180, 180);
			break;
		case PositionConstants.SOUTH:
			graphics.drawLine(rect.getCenter().x,rect.getTop().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x-rect.width/4, rect.getCenter().y, rect.height/2, rect.height/2, 0, 180);
			break;
		}
	}
	
	/**
	 * @return the center between the ( part of the figure
	 * relative to the position of the figure
	 */
	private Point getArcCenter() {
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = getBounds();
		Point result = null;
		
		switch(side){
		case PositionConstants.EAST:
			result = new Point(rect.getCenter().x+rect.height/4, rect.getCenter().y);
			break;
		case PositionConstants.WEST:
			result = new Point(rect.getLeft().x+rect.height/4, rect.getCenter().y);
			break;
		case PositionConstants.NORTH:
			result = new Point(rect.getCenter().x, rect.getTop().y+rect.height/4);
			break;
		case PositionConstants.SOUTH:
			result = new Point(rect.getCenter().x, rect.getCenter().y+rect.height/4);
			break;
		}
		return result;
	}
	
	@Override
	public ConnectionAnchor getConnectionAnchor(String terminal) {
		return myAnchor;
	}			
	
	/**
	 * locates the anchor point at the center of the ( part of the figure
	 */
	private class BallAnchor extends AbstractConnectionAnchor {

		public BallAnchor(IFigure owner) {
			super(owner);
		}
		
		@Override
		public Point getLocation(Point reference) {
			Point p = getArcCenter();
			getOwner().translateToAbsolute(p);
			return p;
		}
	};
}