/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceNetworkSwitchCompartmentEditPart;

// TODO: Auto-generated Javadoc
/**
 * An edit part.
 */
public class CustomLinkingResourceNetworkSwitchCompartmentEditPart extends
        LinkingResourceNetworkSwitchCompartmentEditPart {

    /**
     * Instantiates a new custom linking resource network switch compartment edit part.
     * 
     * @param view
     *            a View
     */
    public CustomLinkingResourceNetworkSwitchCompartmentEditPart(View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceNetworkSwitchCompartmentEditPart
     * #createFigure()
     */
    @Override
    public IFigure createFigure() {
        ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
        result.setTitleVisibility(false);
        result.setBorder(null); // custom code: remove border
        return result;
    }

}
