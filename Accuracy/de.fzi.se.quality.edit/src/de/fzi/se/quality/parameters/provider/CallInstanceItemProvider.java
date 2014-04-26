/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.provider;


import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ParametersFactory;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.parameters.pcm.PCMFactory;

import de.fzi.se.quality.provider.QualityEditPlugin;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.fzi.se.quality.parameters.CallInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CallInstanceItemProvider
	extends IdentifierItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CallInstanceItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

	/**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addNumberOfCallsPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

	/**
     * This adds a property descriptor for the Number Of Calls feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addNumberOfCallsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CallInstance_numberOfCalls_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CallInstance_numberOfCalls_feature", "_UI_CallInstance_type"),
                 ParametersPackage.Literals.CALL_INSTANCE__NUMBER_OF_CALLS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE);
            childrenFeatures.add(ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES);
            childrenFeatures.add(ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES);
        }
        return childrenFeatures;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

	/**
     * This returns CallInstance.gif.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CallInstance"));
    }

	/**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String getText(Object object) {
        String label = ((CallInstance)object).getId();
        return label == null || label.length() == 0 ?
            getString("_UI_CallInstance_type") :
            getString("_UI_CallInstance_type") + " " + label;
    }

	/**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(CallInstance.class)) {
            case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

	/**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE,
                 PCMFactory.eINSTANCE.createPCMInfrastructureOperationReference()));

        newChildDescriptors.add
            (createChildParameter
                (ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE,
                 PCMFactory.eINSTANCE.createPCMBusinessOperationReference()));

        newChildDescriptors.add
            (createChildParameter
                (ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES,
                 ParametersFactory.eINSTANCE.createParameterInstance()));

        newChildDescriptors.add
            (createChildParameter
                (ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES,
                 ParametersFactory.eINSTANCE.createParameterInstance()));
    }

	/**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify =
            childFeature == ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES ||
            childFeature == ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES;

        if (qualify) {
            return getString
                ("_UI_CreateChild_text2",
                 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

	/**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public ResourceLocator getResourceLocator() {
        return QualityEditPlugin.INSTANCE;
    }

}
