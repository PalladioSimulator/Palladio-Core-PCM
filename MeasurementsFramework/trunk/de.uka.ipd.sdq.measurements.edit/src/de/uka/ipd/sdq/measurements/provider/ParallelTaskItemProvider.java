/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.provider;


import de.uka.ipd.sdq.measurements.MeasurementsFactory;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.ParallelTask;

import de.uka.ipd.sdq.measurements.scheduler.schedulerFactory;

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
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.measurements.ParallelTask} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ParallelTaskItemProvider
	extends AbstractTaskItemProvider
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
	public ParallelTaskItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS);
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
	 * This returns ParallelTask.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ParallelTask"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ParallelTask)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ParallelTask_type") :
			getString("_UI_ParallelTask_type") + " " + label;
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

		switch (notification.getFeatureID(ParallelTask.class)) {
			case MeasurementsPackage.PARALLEL_TASK__TASKS:
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
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 MeasurementsFactory.eINSTANCE.createSequenceTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 MeasurementsFactory.eINSTANCE.createParallelTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 MeasurementsFactory.eINSTANCE.createLoopTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 MeasurementsFactory.eINSTANCE.createSequenceTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 MeasurementsFactory.eINSTANCE.createParallelTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 MeasurementsFactory.eINSTANCE.createLoopTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 schedulerFactory.eINSTANCE.createResourceStrategyMeasurementTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 schedulerFactory.eINSTANCE.createParallelProcessTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 schedulerFactory.eINSTANCE.createResourceStrategyMeasurementTask()));

		newChildDescriptors.add
			(createChildParameter
				(MeasurementsPackage.Literals.PARALLEL_TASK__TASKS,
				 schedulerFactory.eINSTANCE.createParallelProcessTask()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MeasurementsEditPlugin.INSTANCE;
	}

}
