/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A factory for creating ComposedProvidingRequiringEntityView objects.
 *
 * @generated
 */
public class ComposedProvidingRequiringEntityViewFactory extends DiagramViewFactory {

    /**
     * Creates a new ComposedProvidingRequiringEntityView object.
     *
     * @param view the view
     * @return the list
     * @generated
     */
    protected List createStyles(View view) {
        List styles = new ArrayList();
        styles.add(NotationFactory.eINSTANCE.createPageStyle());
        styles.add(NotationFactory.eINSTANCE.createGuideStyle());
        styles.add(NotationFactory.eINSTANCE.createDescriptionStyle());
        return styles;
    }

    /**
     * Decorate view.
     *
     * @param view the view
     * @param semanticAdapter the semantic adapter
     * @param diagramKind the diagram kind
     * @generated
     */
    protected void decorateView(View view, IAdaptable semanticAdapter, String diagramKind) {
        super.decorateView(view, semanticAdapter, diagramKind);
    }

    /**
     * Gets the measurement unit.
     *
     * @return the measurement unit
     * @generated
     */
    protected MeasurementUnit getMeasurementUnit() {
        return MeasurementUnit.PIXEL_LITERAL;
    }

}
