/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyContextItemSemanticEditPolicy;

/**
 * The Class CustomAssemblyContextItemSemanticEditPolicy.
 */
public class CustomAssemblyContextItemSemanticEditPolicy extends AssemblyContextItemSemanticEditPolicy {
    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated not
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        // View view = (View) getHost().getModel();
        // CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(),
        // null);
        // cmd.setTransactionNestingEnabled(false);
        //		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        // if (annotation == null) {
        // // there are indirectly referenced children, need extra commands: true
        // addDestroyChildNodesCommand(cmd);
        // addDestroyShortcutsCommand(cmd, view);
        // // delete host element
        // cmd.add(new DestroyElementCommand(req));
        // } else {
        // cmd.add(new DeleteCommand(getEditingDomain(), view));
        // }
        // return getGEFWrapper(cmd.reduce());
        CompoundCommand cc = new CompoundCommand();
        Collection allEdges = new ArrayList();
        View view = (View) getHost().getModel();
        for (Object p : getHost().getChildren()) {
            if (p instanceof BorderedBorderItemEditPart) {
                BorderedBorderItemEditPart borderItem = (BorderedBorderItemEditPart) p;
                if (borderItem.getModel() != null && borderItem.getModel() instanceof View) {
                    allEdges.addAll(((View) borderItem.getModel()).getSourceEdges());
                    allEdges.addAll(((View) borderItem.getModel()).getTargetEdges());
                }
            }
        }
        for (Iterator it = allEdges.iterator(); it.hasNext();) {
            Edge nextEdge = (Edge) it.next();
            EditPart nextEditPart = (EditPart) getHost().getViewer().getEditPartRegistry().get(nextEdge);
            EditCommandRequestWrapper editCommandRequest = new EditCommandRequestWrapper(new DestroyElementRequest(
                    ((AssemblyContextEditPart) getHost()).getEditingDomain(), req.isConfirmationRequired()),
                    Collections.EMPTY_MAP);
            cc.add(nextEditPart.getCommand(editCommandRequest));
        }
        cc.add(getGEFWrapper(new DestroyElementCommand(req)));
        return cc;
    }
}
