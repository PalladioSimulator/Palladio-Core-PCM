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
import de.uka.ipd.sdq.sensitivity.VariableUsageParameter;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.sensitivity.VariableUsageParameter}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class VariableUsageParameterItemProvider extends SingleSensitivityParameterItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public VariableUsageParameterItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addVariableNamePropertyDescriptor(object);
            addEntryLevelSystemCall__VariableUsageParameterPropertyDescriptor(object);
            addVariableCharacterisationType__VariableUsageParameterPropertyDescriptor(object);
            addVariableUsageType__VariableUsageParameterPropertyDescriptor(object);
            addBasicComponent__VariableUsageParameterPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Variable Name feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addVariableNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_VariableUsageParameter_VariableName_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VariableUsageParameter_VariableName_feature",
                        "_UI_VariableUsageParameter_type"),
                SensitivityPackage.Literals.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Entry Level System Call Variable Usage Parameter
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addEntryLevelSystemCall__VariableUsageParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_VariableUsageParameter_entryLevelSystemCall__VariableUsageParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_VariableUsageParameter_entryLevelSystemCall__VariableUsageParameter_feature",
                        "_UI_VariableUsageParameter_type"),
                SensitivityPackage.Literals.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER,
                true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Variable Characterisation Type Variable Usage
     * Parameter feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addVariableCharacterisationType__VariableUsageParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_VariableUsageParameter_variableCharacterisationType__VariableUsageParameter_feature"),
                        getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_VariableUsageParameter_variableCharacterisationType__VariableUsageParameter_feature",
                                "_UI_VariableUsageParameter_type"),
                        SensitivityPackage.Literals.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER,
                        true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Variable Usage Type Variable Usage Parameter feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addVariableUsageType__VariableUsageParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_VariableUsageParameter_variableUsageType__VariableUsageParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_VariableUsageParameter_variableUsageType__VariableUsageParameter_feature",
                        "_UI_VariableUsageParameter_type"),
                SensitivityPackage.Literals.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER,
                true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Basic Component Variable Usage Parameter feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBasicComponent__VariableUsageParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_VariableUsageParameter_basicComponent__VariableUsageParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_VariableUsageParameter_basicComponent__VariableUsageParameter_feature",
                        "_UI_VariableUsageParameter_type"),
                SensitivityPackage.Literals.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER, true,
                false, true, null, null, null));
    }

    /**
     * This returns VariableUsageParameter.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/VariableUsageParameter"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated not
     */
    @Override
    public String getText(Object object) {
        String paramName = "UNSPECIFIED";
        try {
            switch (((VariableUsageParameter) object).getVariableUsageType__VariableUsageParameter()) {
            case SYSTEM_CALL_INPUT:
                paramName = ((VariableUsageParameter) object).getEntryLevelSystemCall__VariableUsageParameter()
                        .getEntityName();
                break;
            case COMPONENT_CONFIGURATION:
                paramName = ((VariableUsageParameter) object).getBasicComponent__VariableUsageParameter()
                        .getEntityName();
                break;
            }
        } catch (Exception e) {
        }
        String inputCharacterisation = ((VariableUsageParameter) object).getVariableName()
                + "."
                + ((VariableUsageParameter) object).getVariableCharacterisationType__VariableUsageParameter()
                        .toString();
        return ((VariableUsageParameter) object).getEntityName() + " (" + paramName + "/" + inputCharacterisation + ")"
                + " [ID: " + ((VariableUsageParameter) object).getId() + "]" + " <"
                + getString("_UI_VariableUsageParameter_type") + ">";
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(VariableUsageParameter.class)) {
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME:
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER:
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
