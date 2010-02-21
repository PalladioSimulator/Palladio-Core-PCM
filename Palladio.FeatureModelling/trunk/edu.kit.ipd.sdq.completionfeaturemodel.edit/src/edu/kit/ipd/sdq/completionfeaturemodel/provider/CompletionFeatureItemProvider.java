/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel.provider;


import QVTRelation.QVTRelationFactory;

import copyException.CopyExceptionFactory;

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

import de.uka.ipd.sdq.featuremodel.provider.FeatureItemProvider;

import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelFactory;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage;

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
 * This is the item provider adapter for a {@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompletionFeatureItemProvider
	extends FeatureItemProvider
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
	public CompletionFeatureItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_CompletionFeature_FeatureState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompletionFeature_FeatureState_feature", "_UI_CompletionFeature_type"),
				 completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__FEATURE_STATE,
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
			childrenFeatures.add(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__COPY_EXCEPTION);
			childrenFeatures.add(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__DISAMBIGUATION_RULE);
			childrenFeatures.add(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT);
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
	 * This returns CompletionFeature.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CompletionFeature"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CompletionFeature)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CompletionFeature_type") :
			getString("_UI_CompletionFeature_type") + " " + label;
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

		switch (notification.getFeatureID(CompletionFeature.class)) {
			case completionfeaturemodelPackage.COMPLETION_FEATURE__FEATURE_STATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION:
			case completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE:
			case completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT:
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
				(featuremodelPackage.Literals.FEATURE__CHILDRELATION,
				 completionfeaturemodelFactory.eINSTANCE.createCompletionSimple()));

		newChildDescriptors.add
			(createChildParameter
				(featuremodelPackage.Literals.FEATURE__CHILDRELATION,
				 completionfeaturemodelFactory.eINSTANCE.createCompletionFeatureGroup()));

		newChildDescriptors.add
			(createChildParameter
				(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createDeletionException()));

		newChildDescriptors.add
			(createChildParameter
				(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createReplacementException()));

		newChildDescriptors.add
			(createChildParameter
				(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__COPY_EXCEPTION,
				 CopyExceptionFactory.eINSTANCE.createReferenceException()));

		newChildDescriptors.add
			(createChildParameter
				(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__DISAMBIGUATION_RULE,
				 completionfeaturemodelFactory.eINSTANCE.createDisambiguationRule()));

		newChildDescriptors.add
			(createChildParameter
				(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT,
				 QVTRelationFactory.eINSTANCE.createRelation()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CompletionfeaturemodelEditPlugin.INSTANCE;
	}

}
