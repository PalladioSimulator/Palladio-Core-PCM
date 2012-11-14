/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerResourceContainerCompartmentEditPart;

/**
 * An edit part.
 */
public class CustomResourceContainerResourceContainerCompartmentEditPart extends
        ResourceContainerResourceContainerCompartmentEditPart {

    /**
     * 
     * @param view
     *            a View
     */
    public CustomResourceContainerResourceContainerCompartmentEditPart(View view) {
        super(view);
    }

    @Override
    public IFigure createFigure() {
        ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
        result.setTitleVisibility(false);
        result.setBorder(null); // custom code
        return result;
    }

}
