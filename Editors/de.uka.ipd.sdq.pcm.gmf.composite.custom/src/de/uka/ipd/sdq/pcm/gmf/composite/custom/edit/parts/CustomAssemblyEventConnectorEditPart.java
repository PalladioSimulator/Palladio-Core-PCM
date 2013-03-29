/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyEventConnectorEditPart;

public class CustomAssemblyEventConnectorEditPart extends AssemblyEventConnectorEditPart {
    public CustomAssemblyEventConnectorEditPart(View view) {
		super(view);
	}

	/**
     * This method changes the color of the connector if a FilterCondition!=true is specified.
     * 
     * @return the figure
     * @generated not
     */
    @Override
    public IFigure getFigure() {
        IFigure figure = super.getFigure();
        Color c = null;
        if (resolveSemanticElement() instanceof AssemblyEventConnector) {
            AssemblyEventConnector con = (AssemblyEventConnector) resolveSemanticElement();
            if ((con.getFilterCondition__AssemblyEventConnector() != null)
                    && !(con.getFilterCondition__AssemblyEventConnector().getSpecification().equalsIgnoreCase("TRUE"))) {
                c = new Color(null, 170, 60, 0);

            } else {
                c = new Color(null, 192, 192, 192);
            }
            figure.setForegroundColor(c);
        }

        return figure;
    }

    /**
     * SemanticListener to update the color if the filter condition is changed.
     * 
     * @generated not
     */
    @Override
    protected void addSemanticListeners() {
        super.addSemanticListeners();

    }

    /**
     * SemanticListener to update the color if the filter condition is changed.
     * 
     * @generated not
     */
    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel"); //$NON-NLS-1$
    }

}
