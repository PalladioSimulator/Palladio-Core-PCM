/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

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
                PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().logError("Validation failed", e); //$NON-NLS-1$
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
                    && RepositoryEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                            .getModelID((View) object));
        }
        return true;
    }

} // PalladioComponentModelValidationProvider
