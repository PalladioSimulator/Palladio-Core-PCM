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
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.dialogs.selection.PalladioSelectEObjectDialog;
import org.palladiosimulator.editors.dialogs.stoex.StochasticExpressionEditDialog;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.InfrastructureInterface;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * Advice for the EditHelper of InfrastructureCall. Displays the dialogs for selection of
 * infrastructure required role and signature.
 * 
 * @author groenda
 */
public class InfrastructureCallEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

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
        InfrastructureRequiredRole requiredRole = null;

        // define the filter list
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(InfrastructureRequiredRole.class);
        filterList.add(InfrastructureInterface.class);
        filterList.add(InfrastructureSignature.class);

        // define the additional references
        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        additionalReferences.add(RepositoryPackage.eINSTANCE
                .getInfrastructureRequiredRole_RequiredInterface__InfrastructureRequiredRole());

        // create the call target dialog
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, eObject);
        dialog.setProvidedService(InfrastructureSignature.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof InfrastructureSignature)) {
            return new CanceledCommand();
        }
        // set the signature for InfrastructureCall
        final InfrastructureSignature signature = (InfrastructureSignature) dialog.getResult();
        // set the required role for InfrastructureCall
        if (dialog.getViewerRootElement() instanceof InfrastructureRequiredRole) {
            requiredRole = (InfrastructureRequiredRole) dialog.getRootOfResult();
        }

        // create the number of calls dialog
        final StochasticExpressionEditDialog dialogNoC = new StochasticExpressionEditDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), TypeEnum.INT, request.getElementToConfigure());
        dialogNoC.open();
        if (dialogNoC.getReturnCode() == Window.CANCEL) {
            return new CanceledCommand();
        }
        final String numberOfCalls = dialogNoC.getResultText();

        // create and execute the ExternalCallActionConfigureCommand command
        return new InfrastructureCallConfigureCommand(request, signature, requiredRole, numberOfCalls);
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
