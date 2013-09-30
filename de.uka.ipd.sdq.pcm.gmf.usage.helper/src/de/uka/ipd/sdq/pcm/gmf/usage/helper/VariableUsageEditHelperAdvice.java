/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

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

import de.uka.ipd.sdq.pcm.dialogs.datatype.DataTypeContainer;
import de.uka.ipd.sdq.pcm.dialogs.datatype.InnerDeclarationContainer;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.dialogs.variableusage.VariableUsageInputParameterContentProvider;
import de.uka.ipd.sdq.pcm.dialogs.variableusage.VariableUsageItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * The Class VariableUsageEditHelperAdvice.
 * 
 * @author admin
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
     * @param request
     *            the request
     * @return the after configure command
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        EObject resource = null;
        EntryLevelSystemCall systemCall = getCall(request.getElementToConfigure());

        ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(Signature.class);

        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
                systemCall.getOperationSignature__EntryLevelSystemCall());
        /**
         * set a ContentProvider for dialog TreeViewer
         */
        dialog.setViewerContentProvider(new VariableUsageInputParameterContentProvider());
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
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

        AbstractNamedReference namedReference = setNamedReference(resource, null, true);

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
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
    private AbstractNamedReference setNamedReference(EObject object, AbstractNamedReference namedReference, boolean last) {
        /**
         * Parameter
         */
        if (object instanceof Parameter) {
            Parameter parameter = (Parameter) object;
            AbstractNamedReference parameterReference = referenceFactory(parameter.getParameterName(), last);
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
            DataTypeContainer treeType = (DataTypeContainer) object;
            if (treeType.getParent() != null) {
                AbstractNamedReference treetypeReference = referenceFactory("INNER", last);
                if (!last) {
                    ((NamespaceReference) treetypeReference).setInnerReference_NamespaceReference(namedReference);
                }
                return setNamedReference((EObject) treeType.getParent(), treetypeReference, false);
            }
        }

        /**
         * TreeDeclaration container for InnerDeclaration
         * 
         * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeDeclaration
         */
        if (object instanceof InnerDeclarationContainer) {
            InnerDeclarationContainer treeDeclaration = (InnerDeclarationContainer) object;
            InnerDeclaration declaration = (InnerDeclaration) treeDeclaration.getObject();

            AbstractNamedReference declarationReference = referenceFactory(declaration.getEntityName(), last);
            if (!last) {
                ((NamespaceReference) declarationReference).setInnerReference_NamespaceReference(namedReference);
            }
            return setNamedReference((EObject) treeDeclaration.getParent(), declarationReference, false);
        }

        return namedReference;
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
    private AbstractNamedReference referenceFactory(String string, boolean shouldGenerateVariableReference) {
        AbstractNamedReference parameterReference = null;
        if (shouldGenerateVariableReference) {
            parameterReference = StoexFactory.eINSTANCE.createVariableReference();
        } else {
            parameterReference = StoexFactory.eINSTANCE.createNamespaceReference();
        }
        parameterReference.setReferenceName(string);
        return parameterReference;
    }

    /**
     * Gets the call.
     * 
     * @param a
     *            the a
     * @return the call
     */
    private EntryLevelSystemCall getCall(EObject a) {
        EObject container = a;
        while (!(container instanceof EntryLevelSystemCall)) {
            container = container.eContainer();
        }
        if (!(container instanceof EntryLevelSystemCall)) {
            return null;
        }
        return (EntryLevelSystemCall) container;
    }
}
