/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.system;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Snowball
 *
 */
public abstract class AbstractRotatingBorderItemEditPart extends
		AbstractBorderItemEditPart {

	private int defaultWidth;

	private int defaultHeight;

	protected ConnectionAnchor defaultAnchor;
	
	/**
	 * @generated
	 */
	protected IFigure contentPane;
	
	/**
	 * @param view
	 */
	public AbstractRotatingBorderItemEditPart(View view, int defaultWidth, int defaultHeight) {
		super(view);
		this.defaultHeight = defaultHeight;
		this.defaultWidth = defaultWidth;
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new RotatingBorderItemSelectionEditPolicy());
	}
	
	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(defaultWidth), getMapMode().DPtoLP(defaultHeight)) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createDefaultAnchor()
			 */
			@Override
			protected ConnectionAnchor createDefaultAnchor() {
				if (defaultAnchor == null)
					return super.createDefaultAnchor();
				else
					return defaultAnchor;
			}
			
			public ConnectionAnchor getConnectionAnchor(String terminal) {
				return createDefaultAnchor();
			}

			/* (non-Javadoc)
			 * @see org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle)
			 */
			@Override
			public void setBounds(Rectangle rect) {
				// TODO Auto-generated method stub
				super.setBounds(rect);
			}
			
			
			
		};
		// FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	protected abstract IFigure createNodeShape();
	
	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		defaultAnchor = new AbstractConnectionAnchor(figure) {

			public Point getLocation(Point reference) {
				Point p = getAnchorPoint(reference);
				return p;
			}

		};
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	protected int getDefaultWidth() {
		return defaultWidth;
	}

	protected int getDefaultHeight() {
		return defaultHeight;
	}

	protected Point getAnchorPoint(Point reference) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getContentPane().getBounds());
		getContentPane().translateToAbsolute(r);
		Point p = null;
		
		switch(getBorderItemLocator().getCurrentSideOfParent())
		{
		case PositionConstants.WEST:
			p = new Point(r.width, r.height/2);
			break;
		case PositionConstants.NORTH:
			p = new Point(r.width/2, r.height);
			break;
		case PositionConstants.EAST:
			p = new Point(0, r.height/2);
			break;
		case PositionConstants.SOUTH:
			p = new Point(r.width/2, 0);
			break;
		}
		return r.getTopLeft().translate(p);
	}	
}
