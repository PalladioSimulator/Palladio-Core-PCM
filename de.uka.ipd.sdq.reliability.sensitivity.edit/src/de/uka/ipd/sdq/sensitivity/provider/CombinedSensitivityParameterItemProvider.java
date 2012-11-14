/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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

import de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityFactory;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CombinedSensitivityParameterItemProvider
	extends SensitivityParameterItemProvider
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
	public CombinedSensitivityParameterItemProvider(AdapterFactory adapterFactory) {
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

			addIsCombinatoryPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Combinatory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsCombinatoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CombinedSensitivityParameter_isCombinatory_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CombinedSensitivityParameter_isCombinatory_feature", "_UI_CombinedSensitivityParameter_type"),
				 SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__IS_COMBINATORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER);
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
	 * This returns CombinedSensitivityParameter.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CombinedSensitivityParameter"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public String getText(Object object) {
		return ((CombinedSensitivityParameter)object).getEntityName()
			+ " [ID: " + ((CombinedSensitivityParameter)object).getId() + "]"
			+ " <" + getString("_UI_CombinedSensitivityParameter_type") + ">";
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

		switch (notification.getFeatureID(CombinedSensitivityParameter.class)) {
			case SensitivityPackage.COMBINED_SENSITIVITY_PARAMETER__IS_COMBINATORY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SensitivityPackage.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER:
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
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createCombinedSensitivityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createComponentReliabilityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createInternalActionReliabilityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createProbabilisticBranchParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createHardwareMTTFParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createHardwareMTTRParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createResourceMTTFParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createResourceMTTRParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createNetworkReliabilityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createCommunicationLinkReliabilityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createSoftwareReliabilityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createVariableUsageParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createUsageBranchParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SensitivityPackage.Literals.COMBINED_SENSITIVITY_PARAMETER__CHILD_PARAMETERS_COMBINED_SENSITIVITY_PARAMETER,
				 SensitivityFactory.eINSTANCE.createSoftwareFailureTypesParameter()));
	}

}
