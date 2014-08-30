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

import de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ComponentReliabilityParameterItemProvider extends SingleSensitivityParameterItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public ComponentReliabilityParameterItemProvider(AdapterFactory adapterFactory) {
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

            addBasicComponent__ComponentReliabilityParameterPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Basic Component Component Reliability Parameter
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBasicComponent__ComponentReliabilityParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_ComponentReliabilityParameter_basicComponent__ComponentReliabilityParameter_feature"),
                        getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_ComponentReliabilityParameter_basicComponent__ComponentReliabilityParameter_feature",
                                "_UI_ComponentReliabilityParameter_type"),
                        SensitivityPackage.Literals.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER,
                        true, false, true, null, null, null));
    }

    /**
     * This returns ComponentReliabilityParameter.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ComponentReliabilityParameter"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated not
     */
    @Override
    public String getText(Object object) {
        String componentName = "UNSPECIFIED";
        try {
            componentName = ((ComponentReliabilityParameter) object).getBasicComponent__ComponentReliabilityParameter()
                    .getEntityName();
        } catch (Exception e) {
        }
        return ((ComponentReliabilityParameter) object).getEntityName() + " (" + componentName + ")" + " [ID: "
                + ((ComponentReliabilityParameter) object).getId() + "]" + " <"
                + getString("_UI_ComponentReliabilityParameter_type") + ">";
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
