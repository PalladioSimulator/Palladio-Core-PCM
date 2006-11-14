package de.uka.ipd.sdq.pcm.gmf.system;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;

public class BallOrSocketFigure extends Figure {

	public static final int BALL_TYPE = 0;
	public static final int SOCKET_TYPE = 1;
	private int type;
	
	/**
	 * 
	 */
	public BallOrSocketFigure(int type) {
		this.type = type;
	}
	
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#paintClientArea(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		int angle = 0;
		switch (type)
		{
		case BALL_TYPE:
			angle = 360;
			break;
		case SOCKET_TYPE:
			angle = 180;
			break;
		}
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		Rectangle rect = new Rectangle();
		rect.translate(1, 1).shrink(1, 1);
		rect = graphics.getClip(rect);
		switch(side){
		case PositionConstants.EAST:
			graphics.drawLine(0,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x, rect.y+1, rect.width / 2, rect.height-2, 90, angle);
			break;
		case PositionConstants.WEST:
			graphics.drawLine(rect.getCenter().x,rect.getCenter().y,rect.getRight().x,rect.getCenter().y);
			graphics.drawArc(rect.x, rect.y, rect.width / 2, rect.height-2, -90, angle);
			break;
		case PositionConstants.NORTH:
			graphics.drawLine(rect.getCenter().x,rect.getCenter().y,rect.getCenter().x,rect.getBottom().y);
			graphics.drawArc(rect.x, rect.y, rect.width - 2, rect.height / 2, 180, angle);
			break;
		case PositionConstants.SOUTH:
			graphics.drawLine(rect.getCenter().x,rect.y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.x, rect.getCenter().y, rect.width - 2, rect.height / 2, 0, angle);
			break;
		}
	}

	public Rectangle getBallBounds() {
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		Rectangle rect = new Rectangle();
		rect.translate(1, 1).shrink(1, 1);
		rect = this.getBounds();
		Rectangle result = null;
		switch(side){
		case PositionConstants.EAST:
			result = new Rectangle(rect.getCenter().x, rect.y+1, rect.width / 2, rect.height-2);
			break;
		case PositionConstants.WEST:
			result = new Rectangle(rect.x, rect.y, rect.width / 2, rect.height-2);
			break;
		case PositionConstants.NORTH:
			result = new Rectangle(rect.x, rect.y, rect.width - 2, rect.height / 2);
			break;
		case PositionConstants.SOUTH:
			result = new Rectangle(rect.x, rect.getCenter().y, rect.width - 2, rect.height / 2);
			break;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle)
	 */
	@Override
	public void setBounds(Rectangle rect) {
		// TODO Auto-generated method stub
		super.setBounds(rect);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#validate()
	 */
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	


}