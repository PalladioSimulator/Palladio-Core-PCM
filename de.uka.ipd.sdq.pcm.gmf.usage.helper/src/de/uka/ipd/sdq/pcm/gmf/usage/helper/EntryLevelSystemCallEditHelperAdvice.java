/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.system.System;

/**
 * The Class EntryLevelSystemCallEditHelperAdvice.
 *
 * @author roman, Christian Busch
 * @generated NOT
 */
public class EntryLevelSystemCallEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

   
    
    /**
     * This command opens two selection dialogs for choosing the system operation provided role and
     * interface.
     *
     * @param request the request
     * @return the after configure command
     */
    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {

        OperationSignature signature = null;
        OperationProvidedRole providedRole = null;
        ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(System.class);
        filterList.add(OperationProvidedRole.class);

        /* first dialog for selection of the operation provided role */
        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        additionalReferences.add(RepositoryPackage.eINSTANCE
                .getOperationProvidedRole_ProvidedInterface__OperationProvidedRole());
        additionalReferences.add(RepositoryPackage.eINSTANCE
                .getInterface_ParentInterfaces__Interface());

        
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, request.getEditingDomain()
                .getResourceSet());
        dialog.setProvidedService(OperationProvidedRole.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof OperationProvidedRole)) {
            return new CanceledCommand();
        }

        providedRole = (OperationProvidedRole) dialog.getResult();

        /* second dialog for selection of the signature of the interface */
        filterList.clear();
        filterList.add(OperationProvidedRole.class);
        filterList.add(OperationInterface.class);
        filterList.add(OperationSignature.class);

        dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                filterList, additionalReferences, providedRole);
        dialog.setProvidedService(OperationSignature.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof OperationSignature)) {
            return new CanceledCommand();
        }
        signature = (OperationSignature) dialog.getResult();

        return new EntryLevelSystemCallConfigureCommand(request, signature, providedRole);
    }
}
