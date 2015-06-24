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
import org.palladiosimulator.editors.dialogs.selection.PalladioSelectEObjectDialog;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * Edit helper for the EmitEventAction. Features are: - Open EventType selection dialog when
 * EmitEventAction is created
 * 
 * @author Benjamin Klatt
 * 
 */
public class EmitEventActionEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /**
     * When an EmitEventAction is created: - Open the dialog to select an EventType this action is
     * able to emit - Get the selected EventType and store it in the action.
     * 
     * @param request
     *            the request
     * @return the after configure command
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
        final EObject eObject = this.searchBasicComponent(request.getElementToConfigure());
        SourceRole sourceRole = null;

        // define the filter list
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(SourceRole.class);
        filterList.add(EventGroup.class);
        filterList.add(EventType.class);

        // define the additional references
        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        additionalReferences.add(RepositoryPackage.eINSTANCE.getSourceRole_EventGroup__SourceRole());

        // create the dialog
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, eObject);
        dialog.setProvidedService(EventType.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof EventType)) {
            return new CanceledCommand();
        }

        // set the EventType for EmitEventAction
        final EventType eventType = (EventType) dialog.getResult();

        // set the required role for EmitEventAction
        if (dialog.getViewerRootElement() instanceof SourceRole) {
            sourceRole = (SourceRole) dialog.getRootOfResult();
        }

        // create and execute the EmitEventActionConfigureCommand command
        return new EmitEventActionConfigureCommand(request, eventType, sourceRole);
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
