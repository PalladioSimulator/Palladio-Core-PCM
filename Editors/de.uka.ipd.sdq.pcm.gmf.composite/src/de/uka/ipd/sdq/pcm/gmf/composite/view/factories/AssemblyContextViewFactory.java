/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * A factory for creating AssemblyContextView objects.
 *
 * @generated
 */
public class AssemblyContextViewFactory extends AbstractShapeViewFactory {

    /**
     * Creates a new AssemblyContextView object.
     *
     * @param view the view
     * @return the list
     * @generated
     */
    protected List createStyles(View view) {
        List styles = new ArrayList();
        styles.add(NotationFactory.eINSTANCE.createFontStyle());
        styles.add(NotationFactory.eINSTANCE.createDescriptionStyle());
        styles.add(NotationFactory.eINSTANCE.createFillStyle());
        styles.add(NotationFactory.eINSTANCE.createLineStyle());
        return styles;
    }

    /**
     * Decorate view.
     *
     * @param containerView the container view
     * @param view the view
     * @param semanticAdapter the semantic adapter
     * @param semanticHint the semantic hint
     * @param index the index
     * @param persisted the persisted
     * @generated
     */
    protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
            int index, boolean persisted) {
        if (semanticHint == null) {
            semanticHint = PalladioComponentModelVisualIDRegistry.getType(AssemblyContextEditPart.VISUAL_ID);
            view.setType(semanticHint);
        }
        super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
        if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                .getModelID(containerView))) {
            EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
            shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
            shortcutAnnotation.getDetails().put("modelID", ComposedProvidingRequiringEntityEditPart.MODEL_ID); //$NON-NLS-1$
            view.getEAnnotations().add(shortcutAnnotation);
        }
        getViewService().createNode(semanticAdapter, view,
                PalladioComponentModelVisualIDRegistry.getType(AssemblyContextEntityNameEditPart.VISUAL_ID),
                ViewUtil.APPEND, true, getPreferencesHint());
    }

}
