/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package QVTTemplate.provider;


import EMOF.provider.ElementItemProvider;
import EMOF.provider.QvtmodelsEditPlugin;

import EssentialOCL.EssentialOCLFactory;

import QVTRelation.QVTRelationFactory;

import QVTTemplate.PropertyTemplateItem;
import QVTTemplate.QVTTemplateFactory;
import QVTTemplate.QVTTemplatePackage;

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
 * This is the item provider adapter for a {@link QVTTemplate.PropertyTemplateItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyTemplateItemItemProvider
	extends ElementItemProvider
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
	public PropertyTemplateItemItemProvider(AdapterFactory adapterFactory) {
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

			addIsOppositePropertyDescriptor(object);
			addReferredPropertyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Opposite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsOppositePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyTemplateItem_isOpposite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyTemplateItem_isOpposite_feature", "_UI_PropertyTemplateItem_type"),
				 QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referred Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferredPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PropertyTemplateItem_referredProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PropertyTemplateItem_referredProperty_feature", "_UI_PropertyTemplateItem_type"),
				 QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE);
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
	 * This returns PropertyTemplateItem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PropertyTemplateItem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Boolean labelValue = ((PropertyTemplateItem)object).getIsOpposite();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_PropertyTemplateItem_type") :
			getString("_UI_PropertyTemplateItem_type") + " " + label;
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

		switch (notification.getFeatureID(PropertyTemplateItem.class)) {
			case QVTTemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTTemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
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
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 QVTTemplateFactory.eINSTANCE.createObjectTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createNavigationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createUnlimitedNaturalExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 EssentialOCLFactory.eINSTANCE.createVariableExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 QVTRelationFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE,
				 QVTRelationFactory.eINSTANCE.createRelationCallExp()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QvtmodelsEditPlugin.INSTANCE;
	}

}
