/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.provider;


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

import QVTRelation.QVTRelationFactory;
import copyException.CopyExceptionFactory;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.featuremodelFactory;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.featuremodel.Feature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider
	extends NamedElementItemProvider
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
	public FeatureItemProvider(AdapterFactory adapterFactory) {
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

			addFeatureStatePropertyDescriptor(object);
			addTransformationFragmentPropertyDescriptor(object);
			addCopyExceptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Feature State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_FeatureState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_FeatureState_feature", "_UI_Feature_type"),
				 featuremodelPackage.Literals.FEATURE__FEATURE_STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transformation Fragment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransformationFragmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_transformationFragment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_transformationFragment_feature", "_UI_Feature_type"),
				 featuremodelPackage.Literals.FEATURE__TRANSFORMATION_FRAGMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Copy Exception feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopyExceptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_copyException_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_copyException_feature", "_UI_Feature_type"),
				 featuremodelPackage.Literals.FEATURE__COPY_EXCEPTION,
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
			childrenFeatures.add(featuremodelPackage.Literals.FEATURE__ATTRIBUTES);
			childrenFeatures.add(featuremodelPackage.Literals.FEATURE__CHILDRELATION);
			childrenFeatures.add(featuremodelPackage.Literals.FEATURE__DISAMBIGUATION);
			childrenFeatures.add(featuremodelPackage.Literals.FEATURE__TRANSFORMATION_FRAGMENT);
			childrenFeatures.add(featuremodelPackage.Literals.FEATURE__COPY_EXCEPTION);
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
	 * This returns Feature.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Feature"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Feature)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Feature_type") :
			getString("_UI_Feature_type") + " " + label;
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

		switch (notification.getFeatureID(Feature.class)) {
			case featuremodelPackage.FEATURE__FEATURE_STATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case featuremodelPackage.FEATURE__ATTRIBUTES:
			case featuremodelPackage.FEATURE__CHILDRELATION:
			case featuremodelPackage.FEATURE__DISAMBIGUATION:
			case featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT:
			case featuremodelPackage.FEATURE__COPY_EXCEPTION:
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
				(featuremodelPackage.Literals.FEATURE__ATTRIBUTES,
				 featuremodelFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__CHILDRELATION,
				 featuremodelFactory.eINSTANCE.createSimple()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__CHILDRELATION,
				 featuremodelFactory.eINSTANCE.createFeatureGroup()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__DISAMBIGUATION,
				 featuremodelFactory.eINSTANCE.createDisambiguationRule()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__TRANSFORMATION_FRAGMENT,
				 QVTRelationFactory.eINSTANCE.createRelation()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createException()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createDeletion()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createReplacement()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createReference()));
	}

}
