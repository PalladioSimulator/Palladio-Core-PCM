/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.system;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Snowball
 *
 */
public class ArcFigure extends Figure {

	/**
	 * 
	 */
	public ArcFigure() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#paintClientArea(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		Rectangle rect = new Rectangle();
		rect = graphics.getClip(rect);
		graphics.drawArc(rect.x, rect.y+1, rect.width, rect.height-2, 90, 180);
	}

}
