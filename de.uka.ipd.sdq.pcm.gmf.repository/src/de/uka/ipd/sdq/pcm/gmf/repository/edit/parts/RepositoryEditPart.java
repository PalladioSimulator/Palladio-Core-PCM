/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.PalladioComponentModelCreateShortcutDecorationsCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.RepositoryCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.RepositoryItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class RepositoryEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    public final static String MODEL_ID = "PCM Repository Model"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final int VISUAL_ID = 1000;

    /**
     * @generated
     */
    public RepositoryEditPart(View view) {
        super(view);
    }

    /**
     * @generated not
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RepositoryItemSemanticEditPolicy());
        // Make diagram unsynched
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new RepositoryCanonicalEditPolicy());
        // Install an edit policy which also create links to the new created view
        // according to the semantic model
        // installEditPolicy(EditPolicyRoles.CREATION_ROLE,
        // new RepositoryCreationEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, // Fix a bug in GMF. Workaround
                new DiagramDragDropEditPolicy() {

                    @Override
                    protected Command createViewsAndArrangeCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
                        ArrayList newDesc = new ArrayList();
                        for (CreateViewRequest.ViewDescriptor d : (List<CreateViewRequest.ViewDescriptor>) viewDescriptors) {
                            newDesc.add(new CreateViewRequest.ViewDescriptor(d.getElementAdapter(), d.getViewKind(),
                                    null, d.getPreferencesHint()));
                        }
                        return super.createViewsAndArrangeCommand(dropRequest, newDesc);
                    }

                });
    }

    /**
     * @generated
     */
    /*package-local*/static class NodeLabelDragPolicy extends NonResizableEditPolicy {

        /**
         * @generated
         */
        @SuppressWarnings("rawtypes")
        protected List createSelectionHandles() {
            MoveHandle h = new MoveHandle((GraphicalEditPart) getHost());
            h.setBorder(null);
            return Collections.singletonList(h);
        }

        /**
         * @generated
         */
        public Command getCommand(Request request) {
            return null;
        }

        /**
         * @generated
         */
        public boolean understandsRequest(Request request) {
            return false;
        }
    }

    /**
     * @generated
     */
    /*package-local*/static class LinkLabelDragPolicy extends NonResizableLabelEditPolicy {

        /**
         * @generated
         */
        @SuppressWarnings("rawtypes")
        protected List createSelectionHandles() {
            MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
            mh.setBorder(null);
            return Collections.singletonList(mh);
        }
    }
}
