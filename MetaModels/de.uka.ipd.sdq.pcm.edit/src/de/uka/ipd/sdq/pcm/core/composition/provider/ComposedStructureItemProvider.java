/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProvider;
import de.uka.ipd.sdq.pcm.core.provider.PalladioComponentModelEditPlugin;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComposedStructureItemProvider
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
	public ComposedStructureItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ComposedStructure)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_ComposedStructure_type") :
			getString("_UI_ComposedStructure_type") + " " + label;
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

		switch (notification.getFeatureID(ComposedStructure.class)) {
			case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
			case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
			case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
			case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
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
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createAssemblyContext()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createResourceRequiredDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createEventChannel()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createEventChannelSourceConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createEventChannelSinkConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createProvidedDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createRequiredDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createAssemblyConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createAssemblyEventConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createSourceDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createSinkDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createAssemblyInfrastructureConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createProvidedInfrastructureDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createRequiredInfrastructureDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createRequiredResourceDelegationConnector()));
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
