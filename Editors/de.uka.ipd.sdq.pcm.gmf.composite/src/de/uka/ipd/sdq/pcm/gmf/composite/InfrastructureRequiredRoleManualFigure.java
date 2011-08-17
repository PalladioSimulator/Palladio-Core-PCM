package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Represents the border figure --[ for provided infrastructure roles. The figure is rotated depending on it's relative location with respect to it's parent.
 * 
 * @author groenda
 */
public class InfrastructureRequiredRoleManualFigure extends AbstractBorderFigure {
	
	/**
	 * @param size width and height of the figure in logical units (LP)
	 * @param posType position type of the figure
	 */
	public InfrastructureRequiredRoleManualFigure(int logicalSize, POSITION_TYPE posType) {
		super(logicalSize, posType);
	}	
	
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		
		if (getBorderItemLocator() == null) {
			throw new IllegalStateException("border item locator null in InfrastructureProvidedRoleFigure.paintFigure");
		}
		
		// determine the side the border item is located relative to it's parent
		int side = (getBorderItemLocator() == null ? PositionConstants.EAST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = new Rectangle();
		graphics.getClip(rect);
		
		// shrink rect so the last pixel of the circle is not clipped by the bounding box
		rect.shrink(1, 1);
		
		/* Figure:
		 *   +-
		 * --|
		 *   +-
		 */
		switch(side){
		case PositionConstants.EAST:
			// stem
			graphics.drawLine(rect.getLeft().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			// |
			graphics.drawLine(rect.getCenter().x, rect.getTop().y+rect.height*1/8, rect.getCenter().x, rect.getTop().y+rect.height*7/8);
			// upper
			graphics.drawLine(rect.getCenter().x, rect.getTop().y+rect.height*1/8, rect.getCenter().x+rect.width*3/8, rect.getTop().y+rect.height*1/8);
			// lower
			graphics.drawLine(rect.getCenter().x, rect.getTop().y+rect.height*7/8, rect.getCenter().x+rect.width*3/8, rect.getTop().y+rect.height*7/8);
			break;
		case PositionConstants.WEST:
			graphics.drawLine(rect.getRight().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			// |
			graphics.drawLine(rect.getCenter().x, rect.getTop().y+rect.height*1/8, rect.getCenter().x, rect.getTop().y+rect.height*7/8);
			// upper
			graphics.drawLine(rect.getCenter().x, rect.getTop().y+rect.height*1/8, rect.getCenter().x-rect.width*3/8, rect.getTop().y+rect.height*1/8);
			// lower
			graphics.drawLine(rect.getCenter().x, rect.getTop().y+rect.height*7/8, rect.getCenter().x-rect.width*3/8, rect.getTop().y+rect.height*7/8);
			break;
		case PositionConstants.NORTH:
			graphics.drawLine(rect.getCenter().x,rect.getBottom().y,rect.getCenter().x,rect.getCenter().y);
			// |
			graphics.drawLine(rect.getLeft().x+rect.width*1/8, rect.getCenter().y, rect.getRight().x-rect.width*1/8, rect.getCenter().y);
			// upper
			graphics.drawLine(rect.getLeft().x+rect.width*1/8, rect.getCenter().y, rect.getLeft().x+rect.width*1/8, rect.getCenter().y-rect.height*3/8);
			// lower
			graphics.drawLine(rect.getRight().x-rect.width*1/8, rect.getCenter().y, rect.getRight().x-rect.width*1/8, rect.getCenter().y-rect.height*3/8);
			break;
		case PositionConstants.SOUTH:
			graphics.drawLine(rect.getCenter().x,rect.getTop().y,rect.getCenter().x,rect.getCenter().y);
			// |
			graphics.drawLine(rect.getLeft().x+rect.width*1/8, rect.getCenter().y, rect.getRight().x-rect.width*1/8, rect.getCenter().y);
			// upper
			graphics.drawLine(rect.getLeft().x+rect.width*1/8, rect.getCenter().y, rect.getLeft().x+rect.width*1/8, rect.getCenter().y+rect.height*3/8);
			// lower
			graphics.drawLine(rect.getRight().x-rect.width*1/8, rect.getCenter().y, rect.getRight().x-rect.width*1/8, rect.getCenter().y+rect.height*3/8);
			break;
		}
	}
	
	/**
	 * @return the rectangle surrounding the [ part of the figure
	 * relative to the position of the figure
	 */
	private Rectangle getTargetConnectionFigureBounds() {
		int side = (getBorderItemLocator() == null ? PositionConstants.EAST : getBorderItemLocator().getCurrentSideOfParent());
	
		Rectangle rect = getBounds();
		Rectangle result = null;
		
		switch(side){
		case PositionConstants.EAST:
			result = new Rectangle(rect.getCenter().x, rect.getTop().y+rect.height*1/8, rect.width*3/8, rect.height*6/8);
			break;
		case PositionConstants.WEST:
			result = new Rectangle(rect.getLeft().x+rect.width*1/8, rect.getTop().y+rect.height*1/8, rect.width*3/8, rect.height*6/8);
			break;
		case PositionConstants.NORTH:
			result = new Rectangle(rect.getCenter().x-rect.width*3/8, rect.getTop().y+rect.height*1/8, rect.width*6/8, rect.height*3/8);
			break;
		case PositionConstants.SOUTH:
			result = new Rectangle(rect.getCenter().x-rect.width*3/8, rect.getCenter().y, rect.height*6/8, rect.height*3/8);
			break;
		}
		return result;
	}
	
	/**Anchor providing a connection point to the rectangular connection part of {@link InfrastructureRequiredRoleManualFigure}.
	 * @author groenda
	 *
	 */
	private class RectangleAnchor extends ChopboxAnchor {
		public RectangleAnchor(IFigure owner) {
			super(owner);
		}
		
		@Override
		protected Rectangle getBox() {
			return getTargetConnectionFigureBounds();
		}
	}
	
	protected ConnectionAnchor createAnchorInternal() {
		return new RectangleAnchor(this);
	}
	
	protected ConnectionAnchor createAnchorExternal() {
		return new StemAnchor(this);
	}
}