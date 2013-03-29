/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEditPart;

public class CustomEventChannelEditPart extends EventChannelEditPart {
    public CustomEventChannelEditPart(View view) {
		super(view);
	}

	/**
     * Adapted to fit to the diamond shape of the channel.
     * 
     * @return the node figure
     * @generated not
     */
    protected NodeFigure createNodePlate() {
        // original code
        // DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 20);
        // return result;
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(80, 40) {
            public PointList getPolygonPoints() {
                PointList points = new PointList(5);
                Rectangle anchRect = getHandleBounds();
                points.addPoint(anchRect.x, anchRect.y + anchRect.height / 2);
                points.addPoint(anchRect.x + anchRect.width / 2, anchRect.y);
                points.addPoint(anchRect.x + anchRect.width, anchRect.y + anchRect.height / 2);
                points.addPoint(anchRect.x + anchRect.width / 2, anchRect.y + anchRect.height);
                points.addPoint(anchRect.x, anchRect.y + anchRect.height / 2); // starting Point
                return points;
            }
        };
        return result;

    }

}
