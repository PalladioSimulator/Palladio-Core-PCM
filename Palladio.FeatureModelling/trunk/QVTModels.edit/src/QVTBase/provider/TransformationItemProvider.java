/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package QVTBase.provider;


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

import EMOF.EMOFFactory;
import EMOF.EMOFPackage;
import EMOF.provider.ClassItemProvider;
import EMOF.provider.ModelEditPlugin;
import EssentialOCL.EssentialOCLFactory;
import QVTBase.QVTBaseFactory;
import QVTBase.QVTBasePackage;
import QVTBase.Transformation;
import QVTRelation.QVTRelationFactory;

/**
 * This is the item provider adapter for a {@link QVTBase.Transformation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformationItemProvider
	extends ClassItemProvider
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
	public TransformationItemProvider(AdapterFactory adapterFactory) {
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

			addUriPropertyDescriptor(object);
			addExtendsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Package_uri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Package_uri_feature", "_UI_Package_type"),
				 EMOFPackage.Literals.PACKAGE__URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extends feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transformation_extends_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transformation_extends_feature", "_UI_Transformation_type"),
				 QVTBasePackage.Literals.TRANSFORMATION__EXTENDS,
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
			childrenFeatures.add(EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE);
			childrenFeatures.add(EMOFPackage.Literals.PACKAGE__OWNED_TYPE);
			childrenFeatures.add(QVTBasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER);
			childrenFeatures.add(QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG);
			childrenFeatures.add(QVTBasePackage.Literals.TRANSFORMATION__RULE);
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
	 * This returns Transformation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Transformation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Transformation)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Transformation_type") :
			getString("_UI_Transformation_type") + " " + label;
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

		switch (notification.getFeatureID(Transformation.class)) {
			case QVTBasePackage.TRANSFORMATION__URI:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE:
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
			case QVTBasePackage.TRANSFORMATION__RULE:
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
				(EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE,
				 QVTBaseFactory.eINSTANCE.createTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE,
				 EMOFFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE,
				 QVTRelationFactory.eINSTANCE.createRelationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 QVTBaseFactory.eINSTANCE.createTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EMOFFactory.eINSTANCE.createClass()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EMOFFactory.eINSTANCE.createDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EMOFFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EMOFFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 EssentialOCLFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add
			(createChildParameter
				(EMOFPackage.Literals.PACKAGE__OWNED_TYPE,
				 QVTRelationFactory.eINSTANCE.createRelationalTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(QVTBasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER,
				 QVTBaseFactory.eINSTANCE.createTypedModel()));

		newChildDescriptors.add
			(createChildParameter
				(QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG,
				 EMOFFactory.eINSTANCE.createTag()));

		newChildDescriptors.add
			(createChildParameter
				(QVTBasePackage.Literals.TRANSFORMATION__RULE,
				 QVTRelationFactory.eINSTANCE.createRelation()));
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
			childFeature == EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE ||
			childFeature == EMOFPackage.Literals.PACKAGE__OWNED_TYPE;

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
		return ModelEditPlugin.INSTANCE;
	}

}
