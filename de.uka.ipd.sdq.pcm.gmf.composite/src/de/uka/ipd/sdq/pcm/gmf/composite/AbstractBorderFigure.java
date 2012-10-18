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
     * position type of the figure. internal or external. internal means the figure is connected
     * towards the outside external means the figure is connected towards the inside
     */
    public static enum POSITION_TYPE {
        /** conntected towards the outside */
        POS_INTERNAL,

        /** connected towards the inside */
        POS_EXTERNAL
    }

    private final POSITION_TYPE myPosType;

    /**
     * reference to the anchor to be used.
     */
    private ConnectionAnchor myAnchor = null;

    /**
     * @param size
     *            width and hight of the figure in logical units (LP)
     */
    public AbstractBorderFigure(final int logicalSize, final POSITION_TYPE posType) {
        super(logicalSize, logicalSize);
        this.myPosType = posType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    @Override
    protected void paintFigure(final Graphics graphics) {
        //
        super.paintFigure(graphics);
        // Next line needed for better display of Ports on Mac OS
        graphics.setLineWidthFloat(new Float(1.01));
    }

    /**
     * Helper function to get the parent's border item locator
     * 
     * @return the parent's border item locator
     */
    protected IBorderItemLocator getBorderItemLocator() {
        final IFigure parentFigure = this.getParent().getParent();
        if (parentFigure != null && parentFigure.getLayoutManager() != null) {
            final Object constraint = parentFigure.getLayoutManager().getConstraint(this.getParent());
            if (constraint instanceof IBorderItemLocator) {
                return (IBorderItemLocator) constraint;
            }
        }
        return null;
    }

    /**
     * factory method for the anchor to be used when figure is in an internal position
     * 
     * @return a reference to the new anchor. must not be null
     */
    abstract protected ConnectionAnchor createAnchorInternal();

    /**
     * factory method for the anchor to be used when figure is in an external position
     * 
     * @return a reference to the new anchor. must not be null
     */
    abstract protected ConnectionAnchor createAnchorExternal();

    @Override
    public ConnectionAnchor getConnectionAnchor(final String terminal) {
        if (this.myAnchor == null) {
            if (this.myPosType == POSITION_TYPE.POS_INTERNAL) {
                this.myAnchor = this.createAnchorInternal();
            }

            if (this.myPosType == POSITION_TYPE.POS_EXTERNAL) {
                this.myAnchor = this.createAnchorExternal();
            }
        }
        assert (this.myAnchor != null);

        return this.myAnchor;
    }

    /**
     * @return the end position of the -- part of the figure relative to the position of the figure
     */
    private Point getStemPosition() {
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = this.getBounds();
        Point result = null;

        switch (side) {
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
     * places the anchor point at the -- part of the figure. this class is to be used by subclasses
     */
    protected class StemAnchor extends AbstractConnectionAnchor {

        public StemAnchor(final IFigure owner) {
            super(owner);
        }

        @Override
        public Point getLocation(final Point reference) {
            final Point p = AbstractBorderFigure.this.getStemPosition();
            this.getOwner().translateToAbsolute(p);
            return p;
        }
    }

}
