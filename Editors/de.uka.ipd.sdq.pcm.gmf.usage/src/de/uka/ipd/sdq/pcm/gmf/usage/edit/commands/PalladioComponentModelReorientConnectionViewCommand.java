/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * The Class PalladioComponentModelReorientConnectionViewCommand.
 *
 * @generated
 */
public class PalladioComponentModelReorientConnectionViewCommand extends AbstractTransactionalCommand {

    /** The edge adaptor. @generated */
    private IAdaptable edgeAdaptor;

    /**
     * Instantiates a new palladio component model reorient connection view command.
     *
     * @param editingDomain the editing domain
     * @param label the label
     * @generated
     */
    public PalladioComponentModelReorientConnectionViewCommand(TransactionalEditingDomain editingDomain, String label) {
        super(editingDomain, label, null);
    }

    /**
     * Gets the affected files.
     *
     * @return the affected files
     * @generated
     */
    public List getAffectedFiles() {
        View view = (View) edgeAdaptor.getAdapter(View.class);
        if (view != null) {
            return getWorkspaceFiles(view);
        }
        return super.getAffectedFiles();
    }

    /**
     * Gets the edge adaptor.
     *
     * @return the edge adaptor
     * @generated
     */
    public IAdaptable getEdgeAdaptor() {
        return edgeAdaptor;
    }

    /**
     * Sets the edge adaptor.
     *
     * @param edgeAdaptor the new edge adaptor
     * @generated
     */
    public void setEdgeAdaptor(IAdaptable edgeAdaptor) {
        this.edgeAdaptor = edgeAdaptor;
    }

    /**
     * Do execute with result.
     *
     * @param progressMonitor the progress monitor
     * @param info the info
     * @return the command result
     * @generated
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) {
        assert null != edgeAdaptor : "Null child in PalladioComponentModelReorientConnectionViewCommand"; //$NON-NLS-1$
        Edge edge = (Edge) getEdgeAdaptor().getAdapter(Edge.class);
        assert null != edge : "Null edge in PalladioComponentModelReorientConnectionViewCommand"; //$NON-NLS-1$
        View tempView = edge.getSource();
        edge.setSource(edge.getTarget());
        edge.setTarget(tempView);
        return CommandResult.newOKCommandResult();
    }
}
