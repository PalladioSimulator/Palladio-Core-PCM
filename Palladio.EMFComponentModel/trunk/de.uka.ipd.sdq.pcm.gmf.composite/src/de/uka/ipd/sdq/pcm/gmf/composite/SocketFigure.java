package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Represents the UML style --( border figure
 * which rotates depending on the side the figure
 * is located in relation to it's parent.
 * 
 * @author Philipp Meier
 */
public class SocketFigure extends AbstractBorderFigure {
	
	/**
	 * @param size width and hight of the figure in logical units (LP)
	 * @param posType position type of the figure
	 */
	public SocketFigure(int logicalSize, POSITION_TYPE posType) {
		super(logicalSize, posType);
	}
		
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		
		if (getBorderItemLocator() == null) {
			System.out.println("border item locator null in SocketFigure.paintFigure");
		}
		
		// determine the side the border item is located relative to it's parent
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = new Rectangle();
		graphics.getClip(rect);
	
		// depending on the side draw a line from the center of the side of the bounding box touching the parent
		// to the center of the bounding box and then draw a half circle in the remaining half of the bounding box
		// so that the open side points away from the parent
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
	
	/**
	 * places the anchor point at the center of the ( part of the figure
	 */
	private class SocketAnchor extends AbstractConnectionAnchor {

		public SocketAnchor(IFigure owner) {
			super(owner);
		}
		
		public Point getLocation(Point reference) {
			Point p = getArcCenter();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	protected ConnectionAnchor createAnchorInternal() {
		return new SocketAnchor(this);
	}
	
	protected ConnectionAnchor createAnchorExternal() {
		return new StemAnchor(this);
	}
}