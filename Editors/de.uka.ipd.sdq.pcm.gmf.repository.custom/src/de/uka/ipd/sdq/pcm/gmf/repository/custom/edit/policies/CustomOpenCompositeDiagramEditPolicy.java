/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.policies;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.OpenCompositeDiagramEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelDiagramEditorUtil;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import org.palladiosimulator.pcm.repository.CompositeComponent;

/**
 * A custom openCompositeDiagram EditPolicy.
 */
public class CustomOpenCompositeDiagramEditPolicy extends OpenCompositeDiagramEditPolicy {

    /**
     * gets the OpenCommand.
     * 
     * @param request
     *            a Request
     * @return a Command
     */
    protected Command getOpenCommand(Request request) {
        EditPart targetEditPart = getTargetEditPart(request);
        if (!(targetEditPart.getModel() instanceof View)) {
            return null;
        }
        View view = (View) targetEditPart.getModel();
        Style link = view.getStyle(NotationPackage.eINSTANCE.getHintedDiagramLinkStyle());
        if (!(link instanceof HintedDiagramLinkStyle)) {
            return null;
        }
        return new ICommandProxy(new OpenDiagramCommand((HintedDiagramLinkStyle) link));
    }

    // I left the @generated tags in, so it is clear what part(s) of the class has been modified.
    // Somewhat dirty but the lesser evil imho.
    /**
     * @generated
     */
    private static class OpenDiagramCommand extends AbstractTransactionalCommand {

        /**
         * @generated
         */
        private final HintedDiagramLinkStyle diagramFacet;

        /**
         * @generated
         */
        OpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {
            // editing domain is taken for original diagram,
            // if we open diagram from another file, we should use another editing domain
            super(TransactionUtil.getEditingDomain(linkStyle), Messages.CommandName_OpenDiagram, null);
            diagramFacet = linkStyle;
        }

        // FIXME canExecute if !(readOnly && getDiagramToOpen == null), i.e. open works on ro
        // diagrams only when there's associated diagram already

        /**
         * @generated not
         * 
         * @param monitor
         *            An IProgressMonitor
         * @param info
         *            An IAdaptable
         * 
         * @throws ExecutionException
         *             an Exception
         * 
         * @return a CommandResult
         */
        protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                throws ExecutionException {

            try {
                Diagram diagram = getDiagramToOpen();
                if (diagram == null) {
                    diagram = intializeNewDiagram();
                }
                URI uri = EcoreUtil.getURI(diagram);
                String editorName = uri.lastSegment()
                        + "#" + ((CompositeComponent) diagram.getElement()).getEntityName(); //$NON-NLS-1$
                IEditorInput editorInput = new URIEditorInput(uri, editorName);
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                page.openEditor(editorInput, getEditorID());
                return CommandResult.newOKCommandResult();
            } catch (Exception ex) {
                throw new ExecutionException("Can't open diagram", ex);
            }
        }

        /**
         * @generated
         */
        protected Diagram getDiagramToOpen() {
            return diagramFacet.getDiagramLink();
        }

        /**
         * @generated not
         * 
         * @throws ExecutionException
         *             An Exception
         * 
         * @return a new diagram
         */
        protected Diagram intializeNewDiagram() throws ExecutionException {
            Diagram d = ViewService.createDiagram(getDiagramDomainElement(), getDiagramKind(), getPreferencesHint());
            if (d == null) {
                throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind");
            }
            diagramFacet.setDiagramLink(d);
            assert diagramFacet.eResource() != null;
            diagramFacet.eResource().getContents().add(d);
            EObject container = diagramFacet.eContainer();
            while (container instanceof View) {
                ((View) container).persist();
                container = container.eContainer();
            }
            try {
                new WorkspaceModifyOperation() {
                    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
                            InterruptedException {
                        try {
                            for (Iterator<Resource> it = diagramFacet.eResource().getResourceSet().getResources()
                                    .iterator(); it.hasNext();) {
                                Resource nextResource = it.next();
                                if (nextResource.isLoaded() && !getEditingDomain().isReadOnly(nextResource)) {
                                    nextResource.save(PalladioComponentModelDiagramEditorUtil.getSaveOptions());
                                }
                            }
                        } catch (IOException ex) {
                            throw new InvocationTargetException(ex, "Save operation failed");
                        }
                    }
                }.run(null);
            } catch (InvocationTargetException e) {
                throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
            } catch (InterruptedException e) {
                throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
            }
            return d;
        }

        /**
         * @generated
         */
        protected EObject getDiagramDomainElement() {
            // use same element as associated with EP
            return ((View) diagramFacet.eContainer()).getElement();
        }

        /**
         * @generated
         */
        protected PreferencesHint getPreferencesHint() {
            // XXX prefhint from target diagram's editor?
            return PalladioComponentModelRepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
        }

        /**
         * @generated
         */
        protected String getDiagramKind() {
            return "CompositeModel";
        }

        /**
         * @generated
         */
        protected String getEditorID() {
            return "de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelDiagramEditorID";
        }
    }

}
