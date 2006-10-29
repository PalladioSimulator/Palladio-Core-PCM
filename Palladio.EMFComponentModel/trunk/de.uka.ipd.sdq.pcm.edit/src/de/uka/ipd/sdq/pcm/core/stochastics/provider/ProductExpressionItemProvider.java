/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics.provider;


import de.uka.ipd.sdq.pcm.assembly.provider.PcmEditPlugin;

import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductExpressionItemProvider
	extends ProductItemProvider
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
	public ProductExpressionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOperationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Operation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ProductExpression_operation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ProductExpression_operation_feature", "_UI_ProductExpression_type"),
				 StochasticsPackage.Literals.PRODUCT_EXPRESSION__OPERATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT);
			childrenFeatures.add(StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ProductExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProductExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		ProductOperations labelValue = ((ProductExpression)object).getOperation();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_ProductExpression_type") :
			getString("_UI_ProductExpression_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ProductExpression.class)) {
			case StochasticsPackage.PRODUCT_EXPRESSION__OPERATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StochasticsPackage.PRODUCT_EXPRESSION__LEFT:
			case StochasticsPackage.PRODUCT_EXPRESSION__RIGHT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT,
				 StochasticsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT,
				 StochasticsFactory.eINSTANCE.createParantesis()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT,
				 StochasticsFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT,
				 StochasticsFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT,
				 StochasticsFactory.eINSTANCE.createProductExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT,
				 StochasticsFactory.eINSTANCE.createProbabilityFunctionLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT,
				 StochasticsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT,
				 StochasticsFactory.eINSTANCE.createParantesis()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT,
				 StochasticsFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT,
				 StochasticsFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT,
				 StochasticsFactory.eINSTANCE.createProbabilityFunctionLiteral()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == StochasticsPackage.Literals.PRODUCT_EXPRESSION__LEFT ||
			childFeature == StochasticsPackage.Literals.PRODUCT_EXPRESSION__RIGHT;

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
	public ResourceLocator getResourceLocator() {
		return PcmEditPlugin.INSTANCE;
	}

}
