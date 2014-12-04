/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.policies.CustomRepositoryCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.RepositoryItemSemanticEditPolicy;

/**
 * A custom repository EditPart.
 */
public class CustomRepositoryEditPart extends RepositoryEditPart {

    /**
     * The constructor.
     * 
     * @param view
     *            a View
     */
    public CustomRepositoryEditPart(View view) {
        super(view);
    }

    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RepositoryItemSemanticEditPolicy());
        // Make diagram unsynched
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CustomRepositoryCanonicalEditPolicy());
        // Install an edit policy which also create links to the new created view
        // according to the semantic model
        // installEditPolicy(EditPolicyRoles.CREATION_ROLE,
        // new RepositoryCreationEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, // Fix a bug in GMF. Workaround
                new DiagramDragDropEditPolicy() {

                    @Override
                    protected Command createViewsAndArrangeCommand(DropObjectsRequest dropRequest, List viewDescriptors) { // non
                                                                                                                           // generic
                                                                                                                           // list!
                                                                                                                           // problem
                                                                                                                           // in
                                                                                                                           // generated
                                                                                                                           // code.
                        ArrayList<CreateViewRequest.ViewDescriptor> newDesc = new ArrayList<CreateViewRequest.ViewDescriptor>();
                        for (CreateViewRequest.ViewDescriptor d : (List<CreateViewRequest.ViewDescriptor>) viewDescriptors) {
                            newDesc.add(new CreateViewRequest.ViewDescriptor(d.getElementAdapter(), d.getViewKind(),
                                    null, d.getPreferencesHint()));
                        }
                        return super.createViewsAndArrangeCommand(dropRequest, newDesc);
                    }

                });
    }
}
