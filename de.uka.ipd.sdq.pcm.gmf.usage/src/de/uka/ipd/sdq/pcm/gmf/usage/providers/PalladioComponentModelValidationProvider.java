/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class PalladioComponentModelValidationProvider.
 *
 * @generated
 */
public class PalladioComponentModelValidationProvider {

    /** The constraints active. @generated */
    private static boolean constraintsActive = false;

    /**
     * Should constraints be private.
     *
     * @return true, if successful
     * @generated
     */
    public static boolean shouldConstraintsBePrivate() {
        return false;
    }

    /**
     * Run with constraints.
     *
     * @param editingDomain the editing domain
     * @param operation the operation
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
                PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError("Validation failed", e); //$NON-NLS-1$
            }
        } else {
            task.run();
        }
    }

    /**
     * Checks if is in default editor context.
     *
     * @param object the object
     * @return true, if is in default editor context
     * @generated
     */
    static boolean isInDefaultEditorContext(Object object) {
        if (shouldConstraintsBePrivate() && !constraintsActive) {
            return false;
        }
        if (object instanceof View) {
            return constraintsActive
                    && UsageScenarioEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry
                            .getModelID((View) object));
        }
        return true;
    }

} // PalladioComponentModelValidationProvider
