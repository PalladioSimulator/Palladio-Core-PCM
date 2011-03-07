package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Represents the event source -|> border figure
 * which rotates depending on the side the figure
 * is located in relation to it's parent.
 * 
 * @author Benjamin Klatt
 */
public class SourceFigure extends AbstractBorderFigure {
	
	/**
	 * @param size width and height of the figure in logical units (LP)
	 * @param posType position type of the figure
	 */
	public SourceFigure(int logicalSize, POSITION_TYPE posType) {
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
	
		// depending on the side draw:
		// - a line from the center of the side of the bounding box touching the parent
		// 		to the center of the bounding box. Result: "-"
		// - a line between the centers of the orthogonal borders of the bounding box. Result: "-|"
		// - a line from the center of the left orthogonal border to the center 
		//		of the border not connected with the parent. Result: "-|\"
		// - a line from the center of the left orthogonal border to the center 
		//		of the border not connected with the parent. Result: "-|>"
		switch(side){
		case PositionConstants.EAST:
			graphics.drawLine(rect.getLeft().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawLine(rect.getCenter().x,rect.getTop().y+rect.height/4,rect.getCenter().x,rect.getBottom().y-rect.height/4);
			graphics.drawLine(rect.getCenter().x,rect.getTop().y+rect.height/4,rect.getRight().x-rect.width/4,rect.getCenter().y);
			graphics.drawLine(rect.getCenter().x,rect.getBottom().y-rect.height/4,rect.getRight().x-rect.width/4,rect.getCenter().y);
			break;
		case PositionConstants.WEST:
			graphics.drawLine(rect.getRight().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawLine(rect.getCenter().x,rect.getTop().y+rect.height/4,rect.getCenter().x,rect.getBottom().y-rect.height/4);
			graphics.drawLine(rect.getCenter().x,rect.getTop().y+rect.height/4,rect.getLeft().x+rect.width/4,rect.getCenter().y);
			graphics.drawLine(rect.getCenter().x,rect.getBottom().y-rect.height/4,rect.getLeft().x+rect.width/4,rect.getCenter().y);
			break;
		case PositionConstants.NORTH:
			graphics.drawLine(	rect.getCenter().x,
								rect.getBottom().y,
								rect.getCenter().x,
								rect.getCenter().y);
			
			graphics.drawLine(	rect.getLeft().x+rect.width/4, 
								rect.getCenter().y, 
								rect.getRight().x-rect.width/4, 
								rect.getCenter().y);
			
			graphics.drawLine(	rect.getRight().x-rect.width/4, 
								rect.getCenter().y,
								rect.getCenter().x,
								rect.getTop().y+rect.height/4);
			
			graphics.drawLine(	rect.getLeft().x+rect.width/4, 
								rect.getCenter().y,
								rect.getCenter().x,
								rect.getTop().y+rect.height/4);

			break;
		case PositionConstants.SOUTH:
			graphics.drawLine(	rect.getCenter().x,
								rect.getTop().y,
								rect.getCenter().x,
								rect.getCenter().y);

			graphics.drawLine(	rect.getLeft().x+rect.width/4, 
								rect.getCenter().y, 
								rect.getRight().x-rect.width/4, 
								rect.getCenter().y);
			
			graphics.drawLine(	rect.getLeft().x+rect.width/4, 
								rect.getCenter().y,
								rect.getCenter().x,
								rect.getBottom().y-rect.height/4);
			
			graphics.drawLine(	rect.getRight().x-rect.width/4, 
								rect.getCenter().y,
								rect.getCenter().x,
								rect.getBottom().y-rect.height/4);
			break;
		}
	}
	
	/**
	 * Get the point representing the pike of the source figure.
	 * 
	 * @return The point representing the location of the pike 
	 */
	private Point getSourceCenter() {
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = getBounds();
		Point result = null;
		
		switch(side){
		case PositionConstants.EAST:
			result = new Point(rect.getRight().x-rect.width/4, rect.getCenter().y);
			break;
		case PositionConstants.WEST:
			result = new Point(rect.getLeft().x+rect.width/4, rect.getCenter().y);
			break;
		case PositionConstants.NORTH:
			result = new Point(rect.getCenter().x, rect.getTop().y+rect.height/4);
			break;
		case PositionConstants.SOUTH:
			result = new Point(rect.getCenter().x, rect.getBottom().y-rect.height/4);
			break;
		}
		return result;
	}	
	
	/**
	 * places the anchor point at the center of the ( part of the figure
	 */
	private class SourceAnchor extends AbstractConnectionAnchor {

		public SourceAnchor(IFigure owner) {
			super(owner);
		}
		
		public Point getLocation(Point reference) {
			Point p = getSourceCenter();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	protected ConnectionAnchor createAnchorInternal() {
		return new SourceAnchor(this);
	}
	
	protected ConnectionAnchor createAnchorExternal() {
		return new StemAnchor(this);
	}
}