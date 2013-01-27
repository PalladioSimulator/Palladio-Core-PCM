package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.system.System;

/**
 * This wizard has added pages that require the user to select a System and a ResourceEnvironment,
 * when initializing the diagram.
 * 
 * @author Philipp Meier
 * 
 */
public class PcmNewAllocationDiagramFileWizard extends PalladioComponentModelNewDiagramFileWizard {

    /**
     * The diagram root.
     */
    private Allocation myDiagramRoot;

    /**
     * The EditingDomain.
     */
    private TransactionalEditingDomain myEditingDomain;

    /**
     * the resource environment selector page.
     */
    private ResourceEnvironmentSelectorPage myResourceEnvironmentSelectorPage;

    /**
     * a system selector page.
     */
    private SystemSelectorPage mySystemSelectorPage;

    /**
     * The constructor.
     * 
     * @param domainModelURI
     *            The domain model URI
     * @param diagramRoot
     *            the diagram's root.
     * @param editingDomain
     *            The editing domnain
     */
    public PcmNewAllocationDiagramFileWizard(org.eclipse.emf.common.util.URI domainModelURI, EObject diagramRoot,
            TransactionalEditingDomain editingDomain) {
        super(domainModelURI, diagramRoot, editingDomain);

        myEditingDomain = editingDomain;

        myDiagramRoot = null;
        if (diagramRoot instanceof Allocation) {
            myDiagramRoot = (Allocation) diagramRoot;
        }

        ResourceEnvironment resourceEnvironment = null;
        System system = null;
        if (myDiagramRoot != null) {
            resourceEnvironment = myDiagramRoot.getTargetResourceEnvironment_Allocation();
            system = myDiagramRoot.getSystem_Allocation();
        }
        myResourceEnvironmentSelectorPage = new ResourceEnvironmentSelectorPage(resourceEnvironment);
        mySystemSelectorPage = new SystemSelectorPage(system);
    }

    @Override
    public void addPages() {
        super.addPages();

        addPage(myResourceEnvironmentSelectorPage);
        addPage(mySystemSelectorPage);
    }

    @Override
    public boolean performFinish() {
        if (myDiagramRoot == null) {
            return false;
        }

        // TODO retrieve the IFile handle to the allocation model and add to list of modified files
        // for command

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain,
                "Save allocation model.", null) { //$NON-NLS-1$
            protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                myDiagramRoot.setTargetResourceEnvironment_Allocation(myResourceEnvironmentSelectorPage
                        .getSelectedResourceEnvironment());
                myDiagramRoot.setSystem_Allocation(mySystemSelectorPage.getSelectedSystem());
                try {
                    Map<String, String> options = new HashMap<String, String>();
                    options.put(XMIResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
                    myDiagramRoot.eResource().save(options);
                } catch (IOException e) {
                    PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
                            "Save operation failed for: " + myDiagramRoot.eResource().getURI().path(), e); //$NON-NLS-1$
                }
                return CommandResult.newOKCommandResult();
            }
        };

        try {
            OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
        } catch (ExecutionException e) {
            PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(
                    "Unable to save allocation model.", e); //$NON-NLS-1$
        }

        return super.performFinish();
    }

}
