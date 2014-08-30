/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelValidationProvider {

    /**
     * @generated
     */
    private static boolean constraintsActive = false;

    /**
     * @generated
     */
    public static boolean shouldConstraintsBePrivate() {
        return false;
    }

    /**
     * @generated
     */
    public static void runWithConstraints(TransactionalEditingDomain editingDomain, Runnable operation) {
        final Runnable op = operation;
        Runnable task = new Runnable() {
            public void run() {
                try {
                    constraintsActive = true;
                    op.run();
                } finally {
                    constraintsActive = false;
                }
            }
        };
        if (editingDomain != null) {
            try {
                editingDomain.runExclusive(task);
            } catch (Exception e) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError("Validation failed", e); //$NON-NLS-1$
            }
        } else {
            task.run();
        }
    }

    /**
     * @generated
     */
    static boolean isInDefaultEditorContext(Object object) {
        if (shouldConstraintsBePrivate() && !constraintsActive) {
            return false;
        }
        if (object instanceof View) {
            return constraintsActive
                    && ResourceDemandingSEFFEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                            .getModelID((View) object));
        }
        return true;
    }

} // PalladioComponentModelValidationProvider
