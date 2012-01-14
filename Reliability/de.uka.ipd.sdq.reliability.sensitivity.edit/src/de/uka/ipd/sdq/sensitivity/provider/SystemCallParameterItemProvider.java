/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SystemCallParameter;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.sensitivity.SystemCallParameter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemCallParameterItemProvider
	extends SingleSensitivityParameterItemProvider
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
	public SystemCallParameterItemProvider(AdapterFactory adapterFactory) {
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

			addInputParameterNamePropertyDescriptor(object);
			addEntryLevelSystemCall__SystemCallParameterPropertyDescriptor(object);
			addVariableCharacterisationType__SystemCallParameterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Input Parameter Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputParameterNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemCallParameter_inputParameterName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemCallParameter_inputParameterName_feature", "_UI_SystemCallParameter_type"),
				 SensitivityPackage.Literals.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entry Level System Call System Call Parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntryLevelSystemCall__SystemCallParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemCallParameter_entryLevelSystemCall__SystemCallParameter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemCallParameter_entryLevelSystemCall__SystemCallParameter_feature", "_UI_SystemCallParameter_type"),
				 SensitivityPackage.Literals.SYSTEM_CALL_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_SYSTEM_CALL_PARAMETER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Variable Characterisation Type System Call Parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVariableCharacterisationType__SystemCallParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SystemCallParameter_variableCharacterisationType__SystemCallParameter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SystemCallParameter_variableCharacterisationType__SystemCallParameter_feature", "_UI_SystemCallParameter_type"),
				 SensitivityPackage.Literals.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns SystemCallParameter.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SystemCallParameter"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public String getText(Object object) {
		String systemCallName = "UNSPECIFIED";
		try {
			systemCallName = ((SystemCallParameter)object).
				getEntryLevelSystemCall__SystemCallParameter().
				getEntityName();
		} catch(Exception e) {}
		String inputCharacterisation = ((SystemCallParameter)object).
			getInputParameterName() + "." + ((SystemCallParameter)object).
			getVariableCharacterisationType__SystemCallParameter().toString();
		return ((SystemCallParameter)object).getEntityName()
			+ " (" + systemCallName + "/" + inputCharacterisation + ")"
			+ " [ID: " + ((SystemCallParameter)object).getId() + "]"
			+ " <" + getString("_UI_SystemCallParameter_type") + ">";
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

		switch (notification.getFeatureID(SystemCallParameter.class)) {
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__INPUT_PARAMETER_NAME:
			case SensitivityPackage.SYSTEM_CALL_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_SYSTEM_CALL_PARAMETER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
