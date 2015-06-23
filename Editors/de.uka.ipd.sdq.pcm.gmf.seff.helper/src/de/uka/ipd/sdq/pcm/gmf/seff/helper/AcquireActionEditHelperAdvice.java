/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.pcm.dialogs.selection.PalladioSelectEObjectDialog;

import com.sun.corba.se.spi.activation.Repository;

import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.seff.SeffPackage;

/**
 * The Class AcquireActionEditHelperAdvice.
 * 
 */
public class AcquireActionEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /**
     * Implements the selection and assignment of a chosen passive resource.
     * 
     * @param request
     *            the request
     * 
     * @return the new set value command for assigning the resource.
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     *      getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
        EObject resource = null;
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(BasicComponent.class);
        filterList.add(PassiveResource.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
                this.searchBasicComponent(request.getElementToConfigure()));
        dialog.setProvidedService(PassiveResource.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof PassiveResource)) {
            return new CanceledCommand();
        }
        resource = dialog.getResult();

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getAcquireAction_Passiveresource_AcquireAction(), resource));
        return cmd;
    }

    /**
     * Searches the basic component of the element to configure.
     * 
     * @param elementToConfigure
     *            the element to configure
     * @return the basic component
     */
    private EObject searchBasicComponent(final EObject elementToConfigure) {
        EObject o = elementToConfigure;
        while (!(o instanceof BasicComponent)) {
            o = o.eContainer();
        }
        return o;
    }

}
