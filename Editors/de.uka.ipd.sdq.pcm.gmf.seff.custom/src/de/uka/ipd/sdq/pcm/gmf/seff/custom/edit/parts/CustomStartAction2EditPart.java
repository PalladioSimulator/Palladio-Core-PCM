/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;

/**
 * The customized start action2 edit part class.
 */
public class CustomStartAction2EditPart extends StartAction2EditPart {

    /**
     * Instantiates a new customized start action2 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomStartAction2EditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart#createNodePlate()
     */
    /**
     * Creates the node plate.
     * 
     * @return the node figure
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart#createNodePlate()
     */
    @Override
    protected NodeFigure createNodePlate() {
        final DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(this.getMapMode().DPtoLP(20), this.getMapMode()
                .DPtoLP(20)) {

            @Override
            protected ConnectionAnchor createDefaultAnchor() {
                return new EllipseAnchor(this);
            }

        };
        return result;
    }

}
