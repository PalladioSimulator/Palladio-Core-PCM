/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.provider;


import de.uka.ipd.sdq.capra.core.CoreFactory;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.ProbabilisticPrefix;

import de.uka.ipd.sdq.capra.extension.ExtensionFactory;

import de.uka.ipd.sdq.capra.measurement.MeasurementFactory;

import de.uka.ipd.sdq.capra.provider.CapraEditPlugin;

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
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProbabilisticPrefixItemProvider
	extends OperatorItemProvider
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
	public ProbabilisticPrefixItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION);
			childrenFeatures.add(CorePackage.Literals.PROBABILISTIC_PREFIX__TARGET_OPTIONS);
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
	 * This returns ProbabilisticPrefix.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProbabilisticPrefix"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ProbabilisticPrefix_type");
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

		switch (notification.getFeatureID(ProbabilisticPrefix.class)) {
			case CorePackage.PROBABILISTIC_PREFIX__ACTION:
			case CorePackage.PROBABILISTIC_PREFIX__TARGET_OPTIONS:
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
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 CoreFactory.eINSTANCE.createDemandAction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 CoreFactory.eINSTANCE.createInputEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 CoreFactory.eINSTANCE.createOutputEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 CoreFactory.eINSTANCE.createCommunicationEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 MeasurementFactory.eINSTANCE.createTimeProbe()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 MeasurementFactory.eINSTANCE.createVisitProbe()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 ExtensionFactory.eINSTANCE.createAcquireAction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__ACTION,
				 ExtensionFactory.eINSTANCE.createReleaseAction()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.PROBABILISTIC_PREFIX__TARGET_OPTIONS,
				 CoreFactory.eINSTANCE.createInternalSelector()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CapraEditPlugin.INSTANCE;
	}

}
