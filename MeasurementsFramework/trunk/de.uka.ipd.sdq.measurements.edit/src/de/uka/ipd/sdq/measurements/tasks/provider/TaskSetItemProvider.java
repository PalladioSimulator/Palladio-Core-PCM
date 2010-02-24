/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.tasks.provider;


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

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;
import de.uka.ipd.sdq.measurements.MeasurementsFactory;
import de.uka.ipd.sdq.measurements.provider.MeasurementsEditPlugin;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerFactory;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;
import de.uka.ipd.sdq.measurements.tasks.TasksFactory;
import de.uka.ipd.sdq.measurements.tasks.TasksPackage;
import de.uka.ipd.sdq.probespec.probespecFactory;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.measurements.tasks.TaskSet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskSetItemProvider
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
	public TaskSetItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskSet_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskSet_name_feature", "_UI_TaskSet_type"),
				 TasksPackage.Literals.TASK_SET__NAME,
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
			childrenFeatures.add(TasksPackage.Literals.TASK_SET__ROOT_TASK);
			childrenFeatures.add(TasksPackage.Literals.TASK_SET__PROBE_SPEC_REPOSITORY);
			childrenFeatures.add(TasksPackage.Literals.TASK_SET__MACHINE_REFERENCES);
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
	 * This returns TaskSet.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TaskSet"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TaskSet)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TaskSet_type") :
			getString("_UI_TaskSet_type") + " " + label;
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

		switch (notification.getFeatureID(TaskSet.class)) {
			case TasksPackage.TASK_SET__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TasksPackage.TASK_SET__ROOT_TASK:
			case TasksPackage.TASK_SET__PROBE_SPEC_REPOSITORY:
			case TasksPackage.TASK_SET__MACHINE_REFERENCES:
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
				(TasksPackage.Literals.TASK_SET__ROOT_TASK,
				 TasksFactory.eINSTANCE.createLoopTask()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__ROOT_TASK,
				 TasksFactory.eINSTANCE.createParallelTask()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__ROOT_TASK,
				 TasksFactory.eINSTANCE.createSequenceTask()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__ROOT_TASK,
				 SchedulerFactory.eINSTANCE.createResourceStrategyMeasurementTask()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__ROOT_TASK,
				 SchedulerFactory.eINSTANCE.createParallelProcessTask()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__ROOT_TASK,
				 SchedulerFactory.eINSTANCE.createResourceStrategyMeasurementAfterIoTask()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__PROBE_SPEC_REPOSITORY,
				 probespecFactory.eINSTANCE.createProbeSpecRepository()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__MACHINE_REFERENCES,
				 MeasurementsFactory.eINSTANCE.createVirtualMachineReference()));

		newChildDescriptors.add
			(createChildParameter
				(TasksPackage.Literals.TASK_SET__MACHINE_REFERENCES,
				 MeasurementsFactory.eINSTANCE.createPlainMachineReference()));
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