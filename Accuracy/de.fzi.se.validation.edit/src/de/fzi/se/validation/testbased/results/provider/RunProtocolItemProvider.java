/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.provider;


import de.fzi.se.validation.testbased.provider.ValidationEditPlugin;

import de.fzi.se.validation.testbased.results.ResultsFactory;
import de.fzi.se.validation.testbased.results.ResultsPackage;
import de.fzi.se.validation.testbased.results.RunProtocol;

import de.fzi.se.validation.testbased.trace.TraceFactory;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

import edu.kit.ipd.sdq.bycounter.output.OutputFactory;

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
 * This is the item provider adapter for a {@link de.fzi.se.validation.testbased.results.RunProtocol} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RunProtocolItemProvider
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
	public RunProtocolItemProvider(AdapterFactory adapterFactory) {
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

			addCreationTimePropertyDescriptor(object);
			addRandomSeedPropertyDescriptor(object);
			addValidationSuccessfulPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Creation Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RunProtocol_creationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RunProtocol_creationTime_feature", "_UI_RunProtocol_type"),
				 ResultsPackage.Literals.RUN_PROTOCOL__CREATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Random Seed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRandomSeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RunProtocol_randomSeed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RunProtocol_randomSeed_feature", "_UI_RunProtocol_type"),
				 ResultsPackage.Literals.RUN_PROTOCOL__RANDOM_SEED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Validation Successful feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidationSuccessfulPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RunProtocol_validationSuccessful_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RunProtocol_validationSuccessful_feature", "_UI_RunProtocol_type"),
				 ResultsPackage.Literals.RUN_PROTOCOL__VALIDATION_SUCCESSFUL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(ResultsPackage.Literals.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES);
			childrenFeatures.add(ResultsPackage.Literals.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS);
			childrenFeatures.add(ResultsPackage.Literals.RUN_PROTOCOL__INVALID_TRACES);
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
	 * This returns RunProtocol.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RunProtocol"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RunProtocol)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_RunProtocol_type") :
			getString("_UI_RunProtocol_type") + " " + label;
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

		switch (notification.getFeatureID(RunProtocol.class)) {
			case ResultsPackage.RUN_PROTOCOL__CREATION_TIME:
			case ResultsPackage.RUN_PROTOCOL__RANDOM_SEED:
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_SUCCESSFUL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
			case ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS:
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
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
				(ResultsPackage.Literals.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES,
				 ResultsFactory.eINSTANCE.createParameterVFN()));

		newChildDescriptors.add
			(createChildParameter
				(ResultsPackage.Literals.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES,
				 ResultsFactory.eINSTANCE.createInfrastructureCallVFN()));

		newChildDescriptors.add
			(createChildParameter
				(ResultsPackage.Literals.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES,
				 ResultsFactory.eINSTANCE.createExternalCallVFN()));

		newChildDescriptors.add
			(createChildParameter
				(ResultsPackage.Literals.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES,
				 ResultsFactory.eINSTANCE.createExecutionTraceVFN()));

		newChildDescriptors.add
			(createChildParameter
				(ResultsPackage.Literals.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS,
				 OutputFactory.eINSTANCE.createMeasurementRun()));

		newChildDescriptors.add
			(createChildParameter
				(ResultsPackage.Literals.RUN_PROTOCOL__INVALID_TRACES,
				 TraceFactory.eINSTANCE.createExecutionTrace()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ValidationEditPlugin.INSTANCE;
	}

}
