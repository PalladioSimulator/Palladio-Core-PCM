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

import de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ResourceMTTRParameterItemProvider extends SingleSensitivityParameterItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public ResourceMTTRParameterItemProvider(AdapterFactory adapterFactory) {
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

            addResourceContainer__ResourceMTTRParameterPropertyDescriptor(object);
            addProcessingResourceType__ResourceMTTRParameterPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Resource Container Resource MTTR Parameter feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addResourceContainer__ResourceMTTRParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_ResourceMTTRParameter_resourceContainer__ResourceMTTRParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_ResourceMTTRParameter_resourceContainer__ResourceMTTRParameter_feature",
                        "_UI_ResourceMTTRParameter_type"),
                SensitivityPackage.Literals.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER, true,
                false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Processing Resource Type Resource MTTR Parameter
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProcessingResourceType__ResourceMTTRParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_ResourceMTTRParameter_processingResourceType__ResourceMTTRParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_ResourceMTTRParameter_processingResourceType__ResourceMTTRParameter_feature",
                        "_UI_ResourceMTTRParameter_type"),
                SensitivityPackage.Literals.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER,
                true, false, true, null, null, null));
    }

    /**
     * This returns ResourceMTTRParameter.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ResourceMTTRParameter"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated not
     */
    @Override
    public String getText(Object object) {
        String resourceContainerName = "UNSPECIFIED";
        try {
            resourceContainerName = ((ResourceMTTRParameter) object).getResourceContainer__ResourceMTTRParameter()
                    .getEntityName();
        } catch (Exception e) {
        }
        String resourceTypeName = "UNSPECIFIED";
        try {
            resourceTypeName = ((ResourceMTTRParameter) object).getProcessingResourceType__ResourceMTTRParameter()
                    .getEntityName();
        } catch (Exception e) {
        }
        return ((ResourceMTTRParameter) object).getEntityName() + " (" + resourceContainerName + "/" + resourceTypeName
                + ")" + " [ID: " + ((ResourceMTTRParameter) object).getId() + "]" + " <"
                + getString("_UI_ResourceMTTRParameter_type") + ">";
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
