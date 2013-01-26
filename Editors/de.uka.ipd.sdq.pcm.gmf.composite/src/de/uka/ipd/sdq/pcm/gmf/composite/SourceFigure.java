package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Represents the event source -|> border figure which rotates depending on the side the figure is
 * located in relation to it's parent.
 * 
 * @author Benjamin Klatt
 */
public class SourceFigure extends AbstractBorderFigure {

    /**
     * Instantiates a new source figure.
     * 
     * @param logicalSize
     *            the logical size
     * @param posType
     *            position type of the figure
     */
    public SourceFigure(final int logicalSize, final POSITION_TYPE posType) {
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
            System.out.println("border item locator null in SocketFigure.paintFigure");
        }

        // determine the side the border item is located relative to it's parent
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = new Rectangle();
        graphics.getClip(rect);

        // depending on the side draw:
        // - a line from the center of the side of the bounding box touching the parent
        // to the center of the bounding box. Result: "-"
        // - a line between the centers of the orthogonal borders of the bounding box. Result: "-|"
        // - a line from the center of the left orthogonal border to the center
        // of the border not connected with the parent. Result: "-|\"
        // - a line from the center of the left orthogonal border to the center
        // of the border not connected with the parent. Result: "-|>"
        switch (side) {
        case PositionConstants.EAST:
            graphics.drawLine(rect.getLeft().x, rect.getCenter().y, rect.getCenter().x, rect.getCenter().y);
            graphics.drawLine(rect.getCenter().x, rect.getTop().y + rect.height / 4, rect.getCenter().x,
                    rect.getBottom().y - rect.height / 4);
            graphics.drawLine(rect.getCenter().x, rect.getTop().y + rect.height / 4,
                    rect.getRight().x - rect.width / 4, rect.getCenter().y);
            graphics.drawLine(rect.getCenter().x, rect.getBottom().y - rect.height / 4, rect.getRight().x - rect.width
                    / 4, rect.getCenter().y);
            break;
        case PositionConstants.WEST:
            graphics.drawLine(rect.getRight().x, rect.getCenter().y, rect.getCenter().x, rect.getCenter().y);
            graphics.drawLine(rect.getCenter().x, rect.getTop().y + rect.height / 4, rect.getCenter().x,
                    rect.getBottom().y - rect.height / 4);
            graphics.drawLine(rect.getCenter().x, rect.getTop().y + rect.height / 4, rect.getLeft().x + rect.width / 4,
                    rect.getCenter().y);
            graphics.drawLine(rect.getCenter().x, rect.getBottom().y - rect.height / 4, rect.getLeft().x + rect.width
                    / 4, rect.getCenter().y);
            break;
        case PositionConstants.NORTH:
            graphics.drawLine(rect.getCenter().x, rect.getBottom().y, rect.getCenter().x, rect.getCenter().y);

            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y,
                    rect.getRight().x - rect.width / 4, rect.getCenter().y);

            graphics.drawLine(rect.getRight().x - rect.width / 4, rect.getCenter().y, rect.getCenter().x,
                    rect.getTop().y + rect.height / 4);

            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y, rect.getCenter().x,
                    rect.getTop().y + rect.height / 4);

            break;
        case PositionConstants.SOUTH:
            graphics.drawLine(rect.getCenter().x, rect.getTop().y, rect.getCenter().x, rect.getCenter().y);

            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y,
                    rect.getRight().x - rect.width / 4, rect.getCenter().y);

            graphics.drawLine(rect.getLeft().x + rect.width / 4, rect.getCenter().y, rect.getCenter().x,
                    rect.getBottom().y - rect.height / 4);

            graphics.drawLine(rect.getRight().x - rect.width / 4, rect.getCenter().y, rect.getCenter().x,
                    rect.getBottom().y - rect.height / 4);
            break;
        }
    }

    /**
     * Get the point representing the pike of the source figure.
     * 
     * @return The point representing the location of the pike
     */
    private Point getSourceCenter() {
        final int side = (this.getBorderItemLocator() == null ? PositionConstants.WEST : this.getBorderItemLocator()
                .getCurrentSideOfParent());

        final Rectangle rect = this.getBounds();
        Point result = null;

        switch (side) {
        case PositionConstants.EAST:
            result = new Point(rect.getRight().x - rect.width / 4, rect.getCenter().y);
            break;
        case PositionConstants.WEST:
            result = new Point(rect.getLeft().x + rect.width / 4, rect.getCenter().y);
            break;
        case PositionConstants.NORTH:
            result = new Point(rect.getCenter().x, rect.getTop().y + rect.height / 4);
            break;
        case PositionConstants.SOUTH:
            result = new Point(rect.getCenter().x, rect.getBottom().y - rect.height / 4);
            break;
        }
        return result;
    }

    /**
     * places the anchor point at the center of the ( part of the figure.
     */
    private class SourceAnchor extends AbstractConnectionAnchor {

        /**
         * Instantiates a new source anchor.
         * 
         * @param owner
         *            the owner
         */
        public SourceAnchor(final IFigure owner) {
            super(owner);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
         */
        @Override
        public Point getLocation(final Point reference) {
            final Point p = SourceFigure.this.getSourceCenter();
            this.getOwner().translateToAbsolute(p);
            return p;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.composite.AbstractBorderFigure#createAnchorInternal()
     */
    @Override
    protected ConnectionAnchor createAnchorInternal() {
        return new SourceAnchor(this);
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