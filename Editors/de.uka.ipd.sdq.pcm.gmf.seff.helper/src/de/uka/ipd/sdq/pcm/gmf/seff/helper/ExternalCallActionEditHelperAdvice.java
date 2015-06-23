/**
 *
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * The Class ExternalCallActionEditHelperAdvice constructs a command to configure newly created
 * external call action.
 *
 * @author Roman Andrej
 */
public class ExternalCallActionEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     * getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    /**
     * Gets the after configure command.
     *
     * @param request
     *            the request
     * @return the after configure command
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
        final EObject eObject = this.searchBasicComponent(request.getElementToConfigure());
        OperationRequiredRole requiredRole = null;

        // define the filter list
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(OperationRequiredRole.class);
        filterList.add(OperationInterface.class);
        filterList.add(OperationSignature.class);

        // define the additional references
        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        additionalReferences.add(RepositoryPackage.eINSTANCE
                .getOperationRequiredRole_RequiredInterface__OperationRequiredRole());

        additionalReferences.add(RepositoryPackage.eINSTANCE.getInterface_ParentInterfaces__Interface());

        // create the dialog
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, eObject);
        dialog.setProvidedService(OperationSignature.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof OperationSignature)) {
            return new CanceledCommand();
        }

        // set the signature for ExternalCallAction
        final OperationSignature signature = (OperationSignature) dialog.getResult();

        // set the required role for ExternalCallAction
        if (dialog.getRootOfResult() instanceof OperationRequiredRole) {
            requiredRole = (OperationRequiredRole) dialog.getRootOfResult();
        }

        // create and execute the ExternalCallActionConfigureCommand command
        return new ExternalCallActionConfigureCommand(request, signature, requiredRole);
    }

    /**
     * Search basic component.
     *
     * @param elementToConfigure
     *            the element to configure
     * @return the e object
     */
    private EObject searchBasicComponent(final EObject elementToConfigure) {
        EObject o = elementToConfigure;
        while (!(o instanceof BasicComponent)) {
            o = o.eContainer();
        }
        return o;
    }
}
