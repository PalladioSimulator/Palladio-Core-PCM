package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.pcm.dialogs.selection.PalladioSelectEObjectDialog;

import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * The Class ParameterCollectionIteratorActionEditHelperAdvice allows the selection of a parameter
 * in a dialog.
 * 
 * @author roman
 */
public class ParameterCollectionIteratorActionEditHelperAdvice extends AbstractEditHelperAdvice implements
        IEditHelperAdvice {

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
        EObject parameter = null;
        OperationSignature signature = null;
        ResourceDemandingSEFF seff = null;

        seff = this.getSEFF(request.getElementToConfigure());
        signature = (OperationSignature) seff.getDescribedService__SEFF();

        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(ResourceDemandingSEFF.class);
        filterList.add(OperationSignature.class);
        filterList.add(Parameter.class);
        filterList.add(DataType.class);
        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        additionalReferences.add(RepositoryPackage.eINSTANCE.getParameter_DataType__Parameter());
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
                signature.getInterface__OperationSignature());
        dialog.setViewerContentProvider(new CollectionIteratorContentProvider());
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        /**
         * set a LabelProvider for dialog TreeViewer
         */
        dialog.setViewerLabelProvider(new AdapterFactoryLabelProvider(new CollectionIteratorItemProviderAdapterFactory(
                new PalladioItemProviderAdapterFactory(adapterFactory))));
        dialog.setProvidedService(Parameter.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof Parameter)) {
            return new CanceledCommand();
        }
        parameter = dialog.getResult();

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getCollectionIteratorAction_Parameter_CollectionIteratorAction(), parameter));
        return cmd;
    }

    /**
     * Gets the seff.
     * 
     * @param a
     *            the container
     * @return the seff
     */
    private ResourceDemandingSEFF getSEFF(final EObject a) {
        EObject container = a;
        while (!(container instanceof ResourceDemandingSEFF)) {
            container = container.eContainer();
        }
        if (!(container instanceof ResourceDemandingSEFF)) {
            return null;
        }
        final ResourceDemandingSEFF seff = (ResourceDemandingSEFF) container;
        return seff;
    }

}
