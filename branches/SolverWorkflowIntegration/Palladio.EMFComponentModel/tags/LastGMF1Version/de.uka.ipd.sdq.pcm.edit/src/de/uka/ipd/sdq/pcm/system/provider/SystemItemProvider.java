/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.provider;


import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.pcm.core.composition.provider.ComposedStructureItemProvider;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProvider;
import de.uka.ipd.sdq.pcm.core.entity.provider.PcmEditPlugin;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsFactory;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.system.System} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemItemProvider
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
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemItemProvider(AdapterFactory adapterFactory) {
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
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
			childrenFeatures.add(CompositionPackage.Literals.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE);
			childrenFeatures.add(EntityPackage.Literals.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY);
			childrenFeatures.add(EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY);
			childrenFeatures.add(SystemPackage.Literals.SYSTEM__QOS_ANNOTATIONS_SYSTEM);
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
	 * This returns System.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/System"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((de.uka.ipd.sdq.pcm.system.System)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_System_type") :
			getString("_UI_System_type") + " " + label;
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

		switch (notification.getFeatureID(de.uka.ipd.sdq.pcm.system.System.class)) {
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
			case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
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
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createAssemblyContext()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createProvidedDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createRequiredDelegationConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionPackage.Literals.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE,
				 CompositionFactory.eINSTANCE.createAssemblyConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EntityPackage.Literals.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY,
				 RepositoryFactory.eINSTANCE.createProvidedRole()));

		newChildDescriptors.add
			(createChildParameter
				(EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
				 RepositoryFactory.eINSTANCE.createRequiredRole()));

		newChildDescriptors.add
			(createChildParameter
				(SystemPackage.Literals.SYSTEM__QOS_ANNOTATIONS_SYSTEM,
				 QosannotationsFactory.eINSTANCE.createQoSAnnotations()));
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
