package de.uka.ipd.sdq.pcm.gmf.composite.custom;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Represents the UML style --( ) border figure which rotates depending on the side the figure is
 * located in relation to it's parent.
 * 
 * @author Philipp Meier
 */
public class BallFigure extends AbstractBorderFigure {

    /**
     * Instantiates a new ball figure.
     * 
     * @param logicalSize
     *            the logical size
     * @param posType
     *            position type of the figure
     */
    public BallFigure(final int logicalSize, final POSITION_TYPE posType) {
        super(logicalSize, posType);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.composite.AbstractBorderFigure#paintFigure(org.eclipse.draw2d.Graphics
     * )
     */
    @Override
    protected void paintFigure(final Graphics graphics) {
        super.paintFigure(graphics);

        if (this.getBorderItemLocator() == null) {
            System.out.println("border item locator null in BallFigure.paintFigure");
        }

        // determine the side the border item is located relative to it's parent
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = new Rectangle();
        graphics.getClip(rect);

        // shrink rect so the last pixel of the circle is not clipped by the bounding box
        rect.shrink(1, 1);

        // depending on the side draw a line from the center of the side of the bounding box
        // touching the parent
        // to the center of the bounding box and then draw a circle in the remaining half of the
        // bounding box
        switch (side) {
        case PositionConstants.EAST:
            graphics.drawLine(rect.getLeft().x, rect.getCenter().y, rect.getCenter().x, rect.getCenter().y);
            graphics.drawArc(rect.getCenter().x, rect.getTop().y + rect.height / 4, rect.height / 2, rect.height / 2,
                    0, 360);
            break;
        case PositionConstants.WEST:
            graphics.drawLine(rect.getRight().x, rect.getCenter().y, rect.getCenter().x, rect.getCenter().y);
            graphics.drawArc(rect.getLeft().x, rect.getTop().y + rect.height / 4, rect.height / 2, rect.height / 2, 0,
                    360);
            break;
        case PositionConstants.NORTH:
            graphics.drawLine(rect.getCenter().x, rect.getBottom().y, rect.getCenter().x, rect.getCenter().y);
            graphics.drawArc(rect.getCenter().x - rect.width / 4, rect.getTop().y, rect.height / 2, rect.height / 2, 0,
                    360);
            break;
        case PositionConstants.SOUTH:
            graphics.drawLine(rect.getCenter().x, rect.getTop().y, rect.getCenter().x, rect.getCenter().y);
            graphics.drawArc(rect.getCenter().x - rect.width / 4, rect.getCenter().y, rect.height / 2, rect.height / 2,
                    0, 360);
            break;
        }
    }

    /**
     * Gets the ball bounds.
     * 
     * @return the rectangle surrounding the ( ) part of the figure relative to the position of the
     *         figure
     */
    private Rectangle getBallBounds() {
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = this.getBounds();
        Rectangle result = null;

        switch (side) {
        case PositionConstants.EAST:
            result = new Rectangle(rect.getCenter().x, rect.getTop().y + rect.height / 4, rect.height / 2,
                    rect.height / 2);
            break;
        case PositionConstants.WEST:
            result = new Rectangle(rect.getLeft().x, rect.getTop().y + rect.height / 4, rect.height / 2,
                    rect.height / 2);
            break;
        case PositionConstants.NORTH:
            result = new Rectangle(rect.getCenter().x - rect.width / 4, rect.getTop().y, rect.height / 2,
                    rect.height / 2);
            break;
        case PositionConstants.SOUTH:
            result = new Rectangle(rect.getCenter().x - rect.width / 4, rect.getCenter().y, rect.height / 2,
                    rect.height / 2);
            break;
        }
        return result;
    }

    /**
     * places the anchor point around the ( ) part of the figure which is closest to the reference
     * point.
     */
    private class BallAnchor extends AbstractConnectionAnchor {

        /**
         * Instantiates a new ball anchor.
         * 
         * @param owner
         *            the owner
         */
        public BallAnchor(final IFigure owner) {
            super(owner);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
         */
        @Override
        public Point getLocation(final Point reference) {
            final Point p = this.getAnchorPoint(reference);
            return p;
        }

        /**
         * Gets the anchor point.
         * 
         * @param reference
         *            the reference
         * @return the anchor point
         */
        private Point getAnchorPoint(final Point reference) {
            final Rectangle r = Rectangle.SINGLETON;
            r.setBounds(BallFigure.this.getBallBounds());
            r.translate(-1, -1);
            r.resize(1, 1);
            this.getOwner().translateToAbsolute(r);

            final Point ref = r.getCenter().negate().translate(reference);

            if (ref.x == 0) {
                return new Point(reference.x, (ref.y > 0) ? r.bottom() : r.y);
            }
            if (ref.y == 0) {
                return new Point((ref.x > 0) ? r.right() : r.x, reference.y);
            }

            final float dx = (ref.x > 0) ? 0.5f : -0.5f;
            final float dy = (ref.y > 0) ? 0.5f : -0.5f;

            // ref.x, ref.y, r.width, r.height != 0 => safe to proceed

            float k = (float) (ref.y * r.width) / (ref.x * r.height);
            k = k * k;

            return r.getCenter().translate((int) (r.width * dx / Math.sqrt(1 + k)),
                    (int) (r.height * dy / Math.sqrt(1 + 1 / k)));
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.AbstractBorderFigure#createAnchorInternal()
     */
    @Override
    protected ConnectionAnchor createAnchorInternal() {
        return new BallAnchor(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.AbstractBorderFigure#createAnchorExternal()
     */
    @Override
    protected ConnectionAnchor createAnchorExternal() {
        return new StemAnchor(this);
    }
}