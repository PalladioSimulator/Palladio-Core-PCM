/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.provider;


import LqnCore.LqnCoreFactory;
import LqnCore.LqnCorePackage;
import LqnCore.LqnModelType;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link LqnCore.LqnModelType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LqnModelTypeItemProvider
	extends ItemProviderAdapter
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
	public LqnModelTypeItemProvider(AdapterFactory adapterFactory) {
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

			addDescriptionPropertyDescriptor(object);
			addLqncoreSchemaVersionPropertyDescriptor(object);
			addLqnSchemaVersionPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addXmlDebugPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LqnModelType_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LqnModelType_description_feature", "_UI_LqnModelType_type"),
				 LqnCorePackage.Literals.LQN_MODEL_TYPE__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lqncore Schema Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLqncoreSchemaVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LqnModelType_lqncoreSchemaVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LqnModelType_lqncoreSchemaVersion_feature", "_UI_LqnModelType_type"),
				 LqnCorePackage.Literals.LQN_MODEL_TYPE__LQNCORE_SCHEMA_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lqn Schema Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLqnSchemaVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LqnModelType_lqnSchemaVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LqnModelType_lqnSchemaVersion_feature", "_UI_LqnModelType_type"),
				 LqnCorePackage.Literals.LQN_MODEL_TYPE__LQN_SCHEMA_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_LqnModelType_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LqnModelType_name_feature", "_UI_LqnModelType_type"),
				 LqnCorePackage.Literals.LQN_MODEL_TYPE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Xml Debug feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXmlDebugPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LqnModelType_xmlDebug_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LqnModelType_xmlDebug_feature", "_UI_LqnModelType_type"),
				 LqnCorePackage.Literals.LQN_MODEL_TYPE__XML_DEBUG,
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
			childrenFeatures.add(LqnCorePackage.Literals.LQN_MODEL_TYPE__RUN_CONTROL);
			childrenFeatures.add(LqnCorePackage.Literals.LQN_MODEL_TYPE__PLOT_CONTROL);
			childrenFeatures.add(LqnCorePackage.Literals.LQN_MODEL_TYPE__SOLVER_PARAMS);
			childrenFeatures.add(LqnCorePackage.Literals.LQN_MODEL_TYPE__PROCESSOR);
			childrenFeatures.add(LqnCorePackage.Literals.LQN_MODEL_TYPE__SLOT);
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
	 * This returns LqnModelType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LqnModelType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LqnModelType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LqnModelType_type") :
			getString("_UI_LqnModelType_type") + " " + label;
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

		switch (notification.getFeatureID(LqnModelType.class)) {
			case LqnCorePackage.LQN_MODEL_TYPE__DESCRIPTION:
			case LqnCorePackage.LQN_MODEL_TYPE__LQNCORE_SCHEMA_VERSION:
			case LqnCorePackage.LQN_MODEL_TYPE__LQN_SCHEMA_VERSION:
			case LqnCorePackage.LQN_MODEL_TYPE__NAME:
			case LqnCorePackage.LQN_MODEL_TYPE__XML_DEBUG:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LqnCorePackage.LQN_MODEL_TYPE__RUN_CONTROL:
			case LqnCorePackage.LQN_MODEL_TYPE__PLOT_CONTROL:
			case LqnCorePackage.LQN_MODEL_TYPE__SOLVER_PARAMS:
			case LqnCorePackage.LQN_MODEL_TYPE__PROCESSOR:
			case LqnCorePackage.LQN_MODEL_TYPE__SLOT:
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
				(LqnCorePackage.Literals.LQN_MODEL_TYPE__RUN_CONTROL,
				 LqnCoreFactory.eINSTANCE.createRunControlType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.LQN_MODEL_TYPE__PLOT_CONTROL,
				 LqnCoreFactory.eINSTANCE.createPlotControlType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.LQN_MODEL_TYPE__SOLVER_PARAMS,
				 LqnCoreFactory.eINSTANCE.createSolverParamsType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.LQN_MODEL_TYPE__PROCESSOR,
				 LqnCoreFactory.eINSTANCE.createProcessorType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.LQN_MODEL_TYPE__SLOT,
				 LqnCoreFactory.eINSTANCE.createSlotType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return LqnEditPlugin.INSTANCE;
	}

}
