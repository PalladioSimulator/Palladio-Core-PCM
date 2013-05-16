/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.helper.edit;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * The Class AssemblyContextEditHelperAdvice.
 * 
 * @generated not
 */
public class AssemblyContextEditHelperAdvice extends AbstractEditHelperAdvice {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getConfigureCommand(org
     * .eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getBeforeConfigureCommand(ConfigureRequest req) {
        RepositoryComponent resource = null;

        ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        // filterList.add(ProvidesComponentType.class); // <- what is/was it for?
        filterList.add(RepositoryComponent.class);

        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, req.getElementToConfigure()
                .eResource().getResourceSet());
        dialog.setProvidedService(RepositoryComponent.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof RepositoryComponent)) {
            return new CanceledCommand();
        }
        resource = (RepositoryComponent) dialog.getResult();

        ICommand cmd = new SetValueCommand(new SetRequest(req.getElementToConfigure(),
                CompositionPackage.eINSTANCE.getAssemblyContext_EncapsulatedComponent__AssemblyContext(), resource));

        String allocationName = "Assembly_" + resource.getEntityName();
        allocationName += " <" + resource.getEntityName() + ">";

        ICommand cmd2 = new SetValueCommand(new SetRequest(req.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), allocationName));

        // TODO: Set width of assembly context to fit name label
        // ICommand cmd3 = new SetBoundsCommand(req.getEditingDomain(), "Set Dimension", new
        // EObjectAdapter((ViewImpl) editPart.getModel()), new Dimension(150, 150));

        CompositeCommand cc = new CompositeCommand("Configure Assembly Context");
        cc.add(cmd);
        cc.add(cmd2);
        // cc.add(cmd3);

        return cc;
    }

}