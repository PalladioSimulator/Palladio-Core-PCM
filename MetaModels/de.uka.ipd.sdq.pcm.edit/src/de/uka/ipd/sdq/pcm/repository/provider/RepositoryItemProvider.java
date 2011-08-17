/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.provider;


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

import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProvider;
import de.uka.ipd.sdq.pcm.core.provider.PalladioComponentModelEditPlugin;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityFactory;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemFactory;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.repository.Repository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryItemProvider
	extends EntityItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryItemProvider(AdapterFactory adapterFactory) {
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

			addRepositoryDescriptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Repository Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_repositoryDescription_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_repositoryDescription_feature", "_UI_Repository_type"),
				 RepositoryPackage.Literals.REPOSITORY__REPOSITORY_DESCRIPTION,
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
			childrenFeatures.add(RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY);
			childrenFeatures.add(RepositoryPackage.Literals.REPOSITORY__INTERFACES_REPOSITORY);
			childrenFeatures.add(RepositoryPackage.Literals.REPOSITORY__FAILURE_TYPES_REPOSITORY);
			childrenFeatures.add(RepositoryPackage.Literals.REPOSITORY__DATA_TYPES_REPOSITORY);
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
	 * This returns Repository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Repository"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Repository)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_Repository_type") :
			getString("_UI_Repository_type") + " " + label;
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

		switch (notification.getFeatureID(Repository.class)) {
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
			case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
			case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
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
				(RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createBasicComponent()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createCompleteComponentType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createProvidesComponentType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createCompositeComponent()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__COMPONENTS_REPOSITORY,
				 SubsystemFactory.eINSTANCE.createSubSystem()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__INTERFACES_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createEventGroup()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__INTERFACES_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createInfrastructureInterface()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__INTERFACES_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createOperationInterface()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__FAILURE_TYPES_REPOSITORY,
				 ReliabilityFactory.eINSTANCE.createHardwareInducedFailureType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__FAILURE_TYPES_REPOSITORY,
				 ReliabilityFactory.eINSTANCE.createSoftwareInducedFailureType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__FAILURE_TYPES_REPOSITORY,
				 ReliabilityFactory.eINSTANCE.createNetworkInducedFailureType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__FAILURE_TYPES_REPOSITORY,
				 ReliabilityFactory.eINSTANCE.createResourceTimeoutFailureType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__DATA_TYPES_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createPrimitiveDataType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__DATA_TYPES_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createCollectionDataType()));

		newChildDescriptors.add
			(createChildParameter
				(RepositoryPackage.Literals.REPOSITORY__DATA_TYPES_REPOSITORY,
				 RepositoryFactory.eINSTANCE.createCompositeDataType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PalladioComponentModelEditPlugin.INSTANCE;
	}

}
