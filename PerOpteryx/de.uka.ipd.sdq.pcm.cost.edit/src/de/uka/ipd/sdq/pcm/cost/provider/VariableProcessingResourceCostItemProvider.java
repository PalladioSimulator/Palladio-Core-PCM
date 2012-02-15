/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.provider;


import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costFactory;
import de.uka.ipd.sdq.pcm.cost.costPackage;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableProcessingResourceCostItemProvider
	extends VariableCostItemProvider
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
	public VariableProcessingResourceCostItemProvider(AdapterFactory adapterFactory) {
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

			addProcessingresourcespecificationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION);
			childrenFeatures.add(costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION);
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
	 * This adds a property descriptor for the Processingresourcespecification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessingresourcespecificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProcessingResourceCost_processingresourcespecification_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProcessingResourceCost_processingresourcespecification_feature", "_UI_ProcessingResourceCost_type"),
				 costPackage.Literals.PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns VariableProcessingResourceCost.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VariableProcessingResourceCost"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		VariableProcessingResourceCost variableProcessingResourceCost = (VariableProcessingResourceCost)object;
		return getString("_UI_VariableProcessingResourceCost_type") + " " + variableProcessingResourceCost.getInitialCost();
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

		switch (notification.getFeatureID(VariableProcessingResourceCost.class)) {
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION:
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION:
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
				(costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION,
				 costFactory.eINSTANCE.createScalarFunction()));

		newChildDescriptors.add
			(createChildParameter
				(costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION,
				 costFactory.eINSTANCE.createScalarFunction()));
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
			childFeature == costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION ||
			childFeature == costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
