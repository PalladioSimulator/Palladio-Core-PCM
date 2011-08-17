/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.provider;


import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.provider.SourceCodeDecoratorEditPlugin;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository;

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

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RawResourceDemandsRepositoryItemProvider
	extends IdentifierItemProvider
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
	public RawResourceDemandsRepositoryItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS);
			childrenFeatures.add(RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS);
			childrenFeatures.add(RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS);
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
	 * This returns RawResourceDemandsRepository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RawResourceDemandsRepository"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RawResourceDemandsRepository)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_RawResourceDemandsRepository_type") :
			getString("_UI_RawResourceDemandsRepository_type") + " " + label;
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

		switch (notification.getFeatureID(RawResourceDemandsRepository.class)) {
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS:
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS:
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS:
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
				(RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS,
				 RawResourceDemandCountsFactory.eINSTANCE.createBytecodeMonitoringRun()));

		newChildDescriptors.add
			(createChildParameter
				(RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS,
				 RawResourceDemandCountsFactory.eINSTANCE.createRawResourceDemandsLink()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SourceCodeDecoratorEditPlugin.INSTANCE;
	}

}
