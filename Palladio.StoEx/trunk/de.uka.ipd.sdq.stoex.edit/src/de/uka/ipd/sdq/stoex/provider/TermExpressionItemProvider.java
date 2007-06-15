/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex.provider;


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

import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.stoex.TermExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TermExpressionItemProvider
	extends TermItemProvider
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
	public TermExpressionItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_TermExpression_operation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TermExpression_operation_feature", "_UI_TermExpression_type"),
				 StoexPackage.Literals.TERM_EXPRESSION__OPERATION,
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
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StoexPackage.Literals.TERM_EXPRESSION__LEFT);
			childrenFeatures.add(StoexPackage.Literals.TERM_EXPRESSION__RIGHT);
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
	 * This returns TermExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TermExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		TermOperations labelValue = ((TermExpression)object).getOperation();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_TermExpression_type") :
			getString("_UI_TermExpression_type") + " " + label;
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

		switch (notification.getFeatureID(TermExpression.class)) {
			case StoexPackage.TERM_EXPRESSION__OPERATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case StoexPackage.TERM_EXPRESSION__LEFT:
			case StoexPackage.TERM_EXPRESSION__RIGHT:
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
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createTermExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createProductExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createProbabilityFunctionLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createParenthesis()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createBoolLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createPowerExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createNegativeExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__LEFT,
				 StoexFactory.eINSTANCE.createFunctionLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createProductExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createProbabilityFunctionLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createParenthesis()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createBoolLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createPowerExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createNegativeExpression()));

		newChildDescriptors.add
			(createChildParameter
				(StoexPackage.Literals.TERM_EXPRESSION__RIGHT,
				 StoexFactory.eINSTANCE.createFunctionLiteral()));
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
			childFeature == StoexPackage.Literals.TERM_EXPRESSION__LEFT ||
			childFeature == StoexPackage.Literals.TERM_EXPRESSION__RIGHT;

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
		return StoexEditPlugin.INSTANCE;
	}

}
