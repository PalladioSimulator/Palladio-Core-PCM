/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * The Class RecoveryActionBehaviourAlternativeBehaviourCompartmentCanonicalEditPolicy.
 *
 * @generated
 */
public class RecoveryActionBehaviourAlternativeBehaviourCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

    /** The my features to synchronize. @generated */
    Set myFeaturesToSynchronize;

    /**
     * Gets the semantic children list.
     *
     * @return the semantic children list
     * @generated
     */
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        List result = new LinkedList();
        for (Iterator it = PalladioComponentModelDiagramUpdater
                .getRecoveryActionBehaviourAlternativeBehaviourCompartment_7055SemanticChildren(viewObject).iterator(); it
                .hasNext();) {
            result.add(((PalladioComponentModelNodeDescriptor) it.next()).getModelElement());
        }
        return result;
    }

    /**
     * Checks if is orphaned.
     *
     * @param semanticChildren the semantic children
     * @param view the view
     * @return true, if is orphaned
     * @generated
     */
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case StartAction2EditPart.VISUAL_ID:
        case StopAction2EditPart.VISUAL_ID:
        case LoopAction2EditPart.VISUAL_ID:
        case InternalAction2EditPart.VISUAL_ID:
        case BranchAction2EditPart.VISUAL_ID:
        case ExternalCallAction2EditPart.VISUAL_ID:
        case EmitEventAction2EditPart.VISUAL_ID:
        case CollectionIteratorAction2EditPart.VISUAL_ID:
        case AcquireAction2EditPart.VISUAL_ID:
        case ReleaseAction2EditPart.VISUAL_ID:
        case ForkAction2EditPart.VISUAL_ID:
        case SetVariableAction2EditPart.VISUAL_ID:
        case RecoveryAction2EditPart.VISUAL_ID:
            if (!semanticChildren.contains(view.getElement())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the default factory hint.
     *
     * @return the default factory hint
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

    /**
     * Gets the features to synchronize.
     *
     * @return the features to synchronize
     * @generated
     */
    protected Set getFeaturesToSynchronize() {
        if (myFeaturesToSynchronize == null) {
            myFeaturesToSynchronize = new HashSet();
            myFeaturesToSynchronize.add(SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour());
        }
        return myFeaturesToSynchronize;
    }

}