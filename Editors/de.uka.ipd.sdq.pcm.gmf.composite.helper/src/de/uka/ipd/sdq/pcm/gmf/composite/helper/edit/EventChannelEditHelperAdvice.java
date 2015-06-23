/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
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
import org.palladiosimulator.pcm.dialogs.selection.PalladioSelectEObjectDialog;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * The Class EventChannelEditHelperAdvice.
 */
public class EventChannelEditHelperAdvice extends AbstractEditHelperAdvice {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     * getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
        EventGroup resource = null;

        ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(EventGroup.class);

        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, request
                .getElementToConfigure().eResource().getResourceSet());
        dialog.setProvidedService(EventGroup.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }

        if (!(dialog.getResult() instanceof Interface)) {
            return new CanceledCommand();
        }
        resource = (EventGroup) dialog.getResult();

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                CompositionPackage.eINSTANCE.getEventChannel_EventGroup__EventChannel(), resource));

        String name = resource.getEntityName();

        ICommand cmd2 = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), name));

        CompositeCommand cc = new CompositeCommand("Configure Event Channel");
        cc.add(cmd);
        cc.add(cmd2);

        return cc;

    }

}
