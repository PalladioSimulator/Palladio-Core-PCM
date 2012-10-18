/**
 * 
 */
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.datatype.DataTypeContainer;
import de.uka.ipd.sdq.pcm.dialogs.datatype.InnerDeclarationContainer;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.dialogs.variablenames.SetOutputVariableNameDialog;
import de.uka.ipd.sdq.pcm.dialogs.variableusage.VariableUsageInputParameterContentProvider;
import de.uka.ipd.sdq.pcm.dialogs.variableusage.VariableUsageItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.dialogs.variableusage.VariableUsageOutputParameterContentProvider;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * The Class VariableUsageEditHelperAdvice.
 */
public class VariableUsageEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     * getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    /**
     * Gets the after configure command.
     *
     * @param request the request
     * @return the after configure command
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
        if (request.getElementToConfigure().eContainer() instanceof ExternalCallAction
                || request.getElementToConfigure().eContainer() instanceof EmitEventAction
                || request.getElementToConfigure().eContainer() instanceof InfrastructureCall) {
            // FIXME: To check the correct IDs
            if (request.getTypeToConfigure() == PalladioComponentModelElementTypes.VariableUsage_3042) {
                // VariableUsage for input variables (ExternalCallAction)
                return this.caseExternalCallActionInputParameter(request);
            } else if (request.getTypeToConfigure() == PalladioComponentModelElementTypes.VariableUsage_3049) {
                // VariableUsage for output variables (ExternalCallAction)
                return this.caseExternalCallActionOutputParameter(request);
            } else if (request.getTypeToConfigure() == PalladioComponentModelElementTypes.VariableUsage_3047) {
                // VariableUsage for input variables (EmitEventActionAction)
                return this.caseEmitEventActionInputParameter(request);
            } else if (request.getTypeToConfigure() == PalladioComponentModelElementTypes.VariableUsage_3054) {
                // VariableUsage for (input) parameters (InfrastructureCall)
                return this.caseInfrastructureCallParameter(request);
            } else {
                return null;
            }
        } else if (request.getElementToConfigure().eContainer() instanceof SetVariableAction) {
            return this.caseSetVariableAction(request);
        } else {
            return new CanceledCommand();
        }
    }

    // FIXME: Unusual usage of method names.
    // Method names should express the function of the method, not the circumstances under which
    // they are called.
    /**
     * Case external call action output parameter.
     * 
     * @param request
     *            the request
     * @return the i command
     */
    private ICommand caseExternalCallActionOutputParameter(final ConfigureRequest request) {

        final SetOutputVariableNameDialog dialog = new SetOutputVariableNameDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell());
        dialog.open();

        final String enteredName = dialog.getResult();
        if (enteredName == null) {
            return new CanceledCommand();
        }

        final AbstractNamedReference namedReference = dialog.getOutputVariableReference();

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableUsage_NamedReference__VariableUsage(), namedReference));
        return cmd;
    }

    /**
     * Case set variable action.
     * 
     * @param request
     *            the request
     * @return the i command
     */
    private ICommand caseSetVariableAction(final ConfigureRequest request) {
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(Signature.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, this.getMyService(request
                .getElementToConfigure()));
        /**
         * set a ContentProvider for dialog TreeViewer
         */
        dialog.setViewerContentProvider(new VariableUsageOutputParameterContentProvider());
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        /**
         * set a LabelProvider for dialog TreeViewer
         */
        dialog.setViewerLabelProvider(new AdapterFactoryLabelProvider(new VariableUsageItemProviderAdapterFactory(
                new PalladioItemProviderAdapterFactory(adapterFactory))));
        dialog.open();

        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof DataTypeContainer)
                && !(dialog.getResult() instanceof InnerDeclarationContainer)
                && !(dialog.getResult() instanceof Parameter)) {
            return new CanceledCommand();
        }

        final EObject resource = dialog.getResult();

        final AbstractNamedReference namedReference = this.setNamedReference(resource, null, true);

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableUsage_NamedReference__VariableUsage(), namedReference));
        return cmd;
    }

    /**
     * Gets the service.
     * 
     * @param elementToConfigure
     *            the element to configure
     * @return the service
     */
    private Signature getMyService(final EObject elementToConfigure) {
        EObject current = elementToConfigure;
        while (current != null && !(current instanceof ResourceDemandingSEFF)) {
            current = current.eContainer();
        }
        return ((ResourceDemandingSEFF) current).getDescribedService__SEFF();
    }

    /**
     * Case external call action input parameter.
     * 
     * @param request
     *            the request
     * @return the i command
     */
    private ICommand caseExternalCallActionInputParameter(final ConfigureRequest request) {
        EObject resource = null;
        final ExternalCallAction call = this.getCall(request.getElementToConfigure());

        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(Signature.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
                call.getCalledService_ExternalService());
        /**
         * set a ContentProvider for dialog TreeViewer
         */
        dialog.setViewerContentProvider(new VariableUsageInputParameterContentProvider());
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        /**
         * set a LabelProvider for dialog TreeViewer
         */
        dialog.setViewerLabelProvider(new AdapterFactoryLabelProvider(new VariableUsageItemProviderAdapterFactory(
                new PalladioItemProviderAdapterFactory(adapterFactory))));
        dialog.open();

        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof DataTypeContainer)
                && !(dialog.getResult() instanceof InnerDeclarationContainer)
                && !(dialog.getResult() instanceof Parameter)) {
            return new CanceledCommand();
        }

        resource = dialog.getResult();

        final AbstractNamedReference namedReference = this.setNamedReference(resource, null, true);

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableUsage_NamedReference__VariableUsage(), namedReference));
        return cmd;
    }

    /**
     * Handle command about an input variable usage for an EmitEventAction.
     * 
     * @param request
     *            The configuration request
     * @return The ICommand for further processing
     */
    private ICommand caseEmitEventActionInputParameter(final ConfigureRequest request) {
        EObject resource = null;
        final EmitEventAction action = this.getEmitEventAction(request.getElementToConfigure());
        final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        if (action.getEventType__EmitEventAction().getParameter__EventType() == null) {

            final MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
            messageBox.setText("Notice");
            messageBox.setMessage("The Type of the event is not set. You must define the data"
                    + "type of the event in the repository first.");
            messageBox.open();

            return new CanceledCommand();

        }

        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(Signature.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(shell, filterList,
                additionalReferences, action.getEventType__EmitEventAction());
        /**
         * set a ContentProvider for dialog TreeViewer
         */
        dialog.setViewerContentProvider(new VariableUsageInputParameterContentProvider());
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        /**
         * set a LabelProvider for dialog TreeViewer
         */
        dialog.setViewerLabelProvider(new AdapterFactoryLabelProvider(new VariableUsageItemProviderAdapterFactory(
                new PalladioItemProviderAdapterFactory(adapterFactory))));
        dialog.open();

        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof DataTypeContainer)
                && !(dialog.getResult() instanceof InnerDeclarationContainer)
                && !(dialog.getResult() instanceof Parameter)) {
            return new CanceledCommand();
        }

        resource = dialog.getResult();

        final AbstractNamedReference namedReference = this.setNamedReference(resource, null, true);

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableUsage_NamedReference__VariableUsage(), namedReference));
        return cmd;
    }

    /**
     * Handle command about an variable usage for an InfrastructureCall.
     * 
     * @param request
     *            The configuration request
     * @return The ICommand for further processing
     */
    private ICommand caseInfrastructureCallParameter(final ConfigureRequest request) {
        EObject resource = null;
        final InfrastructureCall call = (InfrastructureCall) request.getElementToConfigure().eContainer();

        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(InfrastructureInterface.class);
        filterList.add(InfrastructureSignature.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
                call.getSignature__InfrastructureCall());
        /**
         * set a ContentProvider for dialog TreeViewer
         */
        dialog.setViewerContentProvider(new VariableUsageInputParameterContentProvider());
        final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        /**
         * set a LabelProvider for dialog TreeViewer
         */
        dialog.setViewerLabelProvider(new AdapterFactoryLabelProvider(new VariableUsageItemProviderAdapterFactory(
                new PalladioItemProviderAdapterFactory(adapterFactory))));
        dialog.open();

        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof DataTypeContainer)
                && !(dialog.getResult() instanceof InnerDeclarationContainer)
                && !(dialog.getResult() instanceof Parameter)) {
            return new CanceledCommand();
        }

        resource = dialog.getResult();

        final AbstractNamedReference namedReference = this.setNamedReference(resource, null, true);

        final ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableUsage_NamedReference__VariableUsage(), namedReference));
        return cmd;
    }

    /**
     * Sets the named reference.
     * 
     * @param object
     *            the object
     * @param namedReference
     *            the named reference
     * @param last
     *            the last
     * @return - String: specification of VariableCharacterisation
     */
    private AbstractNamedReference setNamedReference(final EObject object, final AbstractNamedReference namedReference,
            final boolean last) {
        /**
         * Parameter
         */
        if (object instanceof Parameter) {
            final Parameter parameter = (Parameter) object;
            final AbstractNamedReference parameterReference = this.referenceFactory(parameter.getParameterName(), last);
            if (!last) {
                ((NamespaceReference) parameterReference).setInnerReference_NamespaceReference(namedReference);
            }
            return parameterReference;
        }

        /**
         * TreeType container for CollectionDataType
         * 
         * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeType
         */
        if (object instanceof DataTypeContainer) {
            final DataTypeContainer treeType = (DataTypeContainer) object;
            if (treeType.getParent() != null) {
                final AbstractNamedReference treetypeReference = this.referenceFactory("INNER", last);
                if (!last) {
                    ((NamespaceReference) treetypeReference).setInnerReference_NamespaceReference(namedReference);
                }
                return this.setNamedReference((EObject) treeType.getParent(), treetypeReference, false);
            }
        }

        /**
         * TreeDeclaration container for InnerDeclaration
         * 
         * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeDeclaration
         */
        if (object instanceof InnerDeclarationContainer) {
            final InnerDeclarationContainer treeDeclaration = (InnerDeclarationContainer) object;
            final InnerDeclaration declaration = (InnerDeclaration) treeDeclaration.getObject();

            final AbstractNamedReference declarationReference = this
                    .referenceFactory(declaration.getEntityName(), last);
            if (!last) {
                ((NamespaceReference) declarationReference).setInnerReference_NamespaceReference(namedReference);
            }
            return this.setNamedReference((EObject) treeDeclaration.getParent(), declarationReference, false);
        }

        return namedReference;
    }

    /**
     * Get the ExternalCallAction out of a request object. The request object is recursively scanned
     * for the action while it might have been wrapped.
     * 
     * @param object
     *            The ECore object to scan
     * @return The ExternalCallAction or null if no ExternalCallAction has been contained
     */
    private ExternalCallAction getCall(final EObject object) {
        EObject container = object;
        while (!(container instanceof ExternalCallAction)) {
            container = container.eContainer();
        }
        if (!(container instanceof ExternalCallAction)) {
            return null;
        }
        return (ExternalCallAction) container;
    }

    /**
     * Get the EmitEventAction out of a request object. The request object is recursively scanned
     * for the action while it might have been wrapped.
     * 
     * @param object
     *            The ECore object to scan
     * @return The EmitEventAction or null if no EmitEventAction has been contained
     */
    private EmitEventAction getEmitEventAction(final EObject object) {
        EObject container = object;
        while (!(container instanceof EmitEventAction)) {
            container = container.eContainer();
        }
        if (!(container instanceof EmitEventAction)) {
            return null;
        }
        return (EmitEventAction) container;
    }

    /**
     * Get the InternalAction out of a request object. The request object is recursively scanned for
     * the action while it might have been wrapped.
     * 
     * @param object
     *            The ECore object to scan.
     * @return The InternalAction or null if no InternalAction has been contained.
     */
    private InternalAction getInternalAction(final EObject object) {
        EObject container = object;
        while (!(container instanceof InternalAction)) {
            container = container.eContainer();
        }
        if (!(container instanceof InternalAction)) {
            return null;
        }
        return (InternalAction) container;
    }

    /**
     * Create the AbstractNamedReference and set a string parameter.
     * 
     * @param string
     *            the string
     * @param shouldGenerateVariableReference
     *            the should generate variable reference
     * @return the abstract named reference
     */
    private AbstractNamedReference referenceFactory(final String string, final boolean shouldGenerateVariableReference) {
        AbstractNamedReference parameterReference = null;
        if (shouldGenerateVariableReference) {
            parameterReference = StoexFactory.eINSTANCE.createVariableReference();
        } else {
            parameterReference = StoexFactory.eINSTANCE.createNamespaceReference();
        }
        parameterReference.setReferenceName(string);
        return parameterReference;
    }
}
