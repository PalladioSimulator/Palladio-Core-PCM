package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Represents the event source -|< border figure which rotates depending on the side the figure is
 * located in relation to it's parent.
 * 
 * @author Benjamin Klatt
 */
public class SinkFigure extends AbstractBorderFigure {

    /**
     * Instantiates a new sink figure.
     *
     * @param logicalSize the logical size
     * @param posType position type of the figure
     */
    public SinkFigure(final int logicalSize, final POSITION_TYPE posType) {
        super(logicalSize, posType);
    }

    /* (non-Javadoc)
     * @see de.uka.ipd.sdq.pcm.gmf.composite.AbstractBorderFigure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    @Override
    protected void paintFigure(final Graphics graphics) {
        super.paintFigure(graphics);

        if (this.getBorderItemLocator() == null) {
            System.out.println("border item locator null in SocketFigure.paintFigure");
        }

        // determine the side the border item is located relative to it's parent
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = new Rectangle();
        graphics.getClip(rect);

        // depending on the side, draw
        // - a line from the center of the side of the bounding box touching the parent
        // to the center of the bounding box. Result: "-"
        // - a line between the centers of the orthogonal borders of the bounding box. Result: "-|"
        // - a line for the top border of the sink
        // - a line for the lower border of the sink
        // - a line from the center to the right upper corner
        // - a line from the center to the right lower corner
        switch (side) {
        case PositionConstants.EAST:
            // Sink Connector
            graphics.drawLine(rect.getLeft().x, rect.getCenter().y, rect.getCenter().x - rect.width / 4,
                    rect.getCenter().y);

            // Sink Base
            graphics.drawLine(rect.getCenter().x - rect.width / 4, rect.getTop().y + rect.height / 4,
                    rect.getCenter().x - rect.width / 4, rect.getBottom().y - rect.height / 4);

            // upper border
            graphics.drawLine(rect.getCenter().x - rect.width / 4, rect.getTop().y + rect.height / 4, rect.getRight().x
                    - rect.width / 4, rect.getTop().y + rect.height / 4);

            // lower border
            graphics.drawLine(rect.getCenter().x - rect.width / 4, rect.getBottom().y - rect.height / 4,
                    rect.getRight().x - rect.width / 4, rect.getBottom().y - rect.height / 4);

            // upper dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getRight().x - rect.width / 4,
                    rect.getTop().y + rect.height / 4);

            // lower dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getRight().x - rect.width / 4,
                    rect.getBottom().y - rect.height / 4);
            break;
        case PositionConstants.WEST:
            // Sink Connector
            graphics.drawLine(rect.getRight().x, rect.getCenter().y, rect.getCenter().x + rect.width / 4,
                    rect.getCenter().y);

            // Sink Base
            graphics.drawLine(rect.getCenter().x + rect.width / 4, rect.getTop().y + rect.height / 4,
                    rect.getCenter().x + rect.width / 4, rect.getBottom().y - rect.height / 4);

            // upper border
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getTop().y + rect.height / 4, rect.getCenter().x
                    + rect.width / 4, rect.getTop().y + rect.height / 4);

            // lower border
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getBottom().y - rect.height / 4,
                    rect.getCenter().x + rect.width / 4, rect.getBottom().y - rect.height / 4);

            // upper dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getLeft().x + rect.width / 4,
                    rect.getTop().y + rect.height / 4);

            // lower dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getLeft().x + rect.width / 4,
                    rect.getBottom().y - rect.height / 4);
            break;
        case PositionConstants.NORTH:
            // Sink Connector
            graphics.drawLine(rect.getCenter().x, rect.getBottom().y, rect.getCenter().x, rect.getCenter().y
                    + rect.height / 4);

            // Sink Base
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y + rect.height / 4,
                    rect.getRight().x - rect.width / 4, rect.getCenter().y + rect.height / 4);

            // left border
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y + rect.height / 4, rect.getLeft().x
                    + rect.width / 4, rect.getTop().y + rect.height / 4);

            // right border
            graphics.drawLine(rect.getRight().x - rect.width / 4, rect.getCenter().y + rect.height / 4,
                    rect.getRight().x - rect.width / 4, rect.getTop().y + rect.height / 4);

            // left dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getLeft().x + rect.width / 4,
                    rect.getTop().y + rect.height / 4);

            // right dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getRight().x - rect.width / 4,
                    rect.getTop().y + rect.height / 4);

            break;
        case PositionConstants.SOUTH:
            // Sink Connector
            graphics.drawLine(rect.getCenter().x, rect.getTop().y, rect.getCenter().x, rect.getCenter().y - rect.height
                    / 4);

            // Sink Base
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y - rect.height / 4,
                    rect.getRight().x - rect.width / 4, rect.getCenter().y - rect.height / 4);

            // left border
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y + rect.height / 4, rect.getLeft().x
                    + rect.width / 4, rect.getTop().y + rect.height / 4);

            // right border
            graphics.drawLine(rect.getRight().x - rect.width / 4, rect.getCenter().y + rect.height / 4,
                    rect.getRight().x - rect.width / 4, rect.getTop().y + rect.height / 4);

            // left dash
            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getBottom().y - rect.height / 4,
                    rect.getCenter().x, rect.getCenter().y);

            // right dash
            graphics.drawLine(rect.getCenter().x, rect.getCenter().y, rect.getRight().x - rect.width / 4,
                    rect.getBottom().y - rect.height / 4);
            break;
        }
    }

    /**
     * Gets the sink center.
     *
     * @return the center between the ( part of the figure relative to the position of the figure
     */
    private Point getSinkCenter() {
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = this.getBounds();
        Point result = null;

        switch (side) {
        case PositionConstants.EAST:
            result = new Point(rect.getCenter().x, rect.getCenter().y);
            break;
        case PositionConstants.WEST:
            result = new Point(rect.getCenter().x, rect.getCenter().y);
            break;
        case PositionConstants.NORTH:
            result = new Point(rect.getCenter().x, rect.getCenter().y);
            break;
        case PositionConstants.SOUTH:
            result = new Point(rect.getCenter().x, rect.getCenter().y);
            break;
        }
        return result;
    }

    /**
     * places the anchor point at the center of the ( part of the figure.
     */
    private class SinkAnchor extends AbstractConnectionAnchor {

        /**
         * Instantiates a new sink anchor.
         *
         * @param owner the owner
         */
        public SinkAnchor(final IFigure owner) {
            super(owner);
        }

        /* (non-Javadoc)
         * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
         */
        @Override
        public Point getLocation(final Point reference) {
            final Point p = SinkFigure.this.getSinkCenter();
            this.getOwner().translateToAbsolute(p);
            return p;
        }
    }

    /**
     * Get the anchor for connectors linked to this figure. The anchor internal represents the
     * anchor if this sink belongs to an internal assembly context.
     * 
     * @return The connection anchor with the appropriate position
     */
    @Override
    protected ConnectionAnchor createAnchorInternal() {
        return new SinkAnchor(this);
    }

    /**
     * Get the anchor for connectors linked to this figure. The anchor external represents the
     * anchor if this sink belongs to an external system sink.
     * 
     * @return The connection anchor with the appropriate position
     */
    @Override
    protected ConnectionAnchor createAnchorExternal() {
        return new StemAnchor(this);
    }
}