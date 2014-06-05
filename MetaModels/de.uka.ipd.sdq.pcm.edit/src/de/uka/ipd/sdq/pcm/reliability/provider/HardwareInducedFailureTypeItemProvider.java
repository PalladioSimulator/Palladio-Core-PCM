/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.provider;

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

import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class HardwareInducedFailureTypeItemProvider extends FailureTypeItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public HardwareInducedFailureTypeItemProvider(AdapterFactory adapterFactory) {
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

            addProcessingResourceType__HardwareInducedFailureTypePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Processing Resource Type Hardware Induced Failure
     * Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProcessingResourceType__HardwareInducedFailureTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_HardwareInducedFailureType_processingResourceType__HardwareInducedFailureType_feature"),
                        getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_HardwareInducedFailureType_processingResourceType__HardwareInducedFailureType_feature",
                                "_UI_HardwareInducedFailureType_type"),
                        ReliabilityPackage.Literals.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE,
                        true, false, true, null, null, null));
    }

    /**
     * This returns HardwareInducedFailureType.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/HardwareInducedFailureType"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> FB: Adapted method
     * to produce a more informative label for display in non-PCM editors. In PCM editors, display
     * is not controlled by this method but through a more general mechanism (I'n not sure where
     * it's actually controlled, maybe the
     * de.uka.ipd.sdq.pcmbench.tabs.PropertyLabelProvider.getText() method?) <!-- end-user-doc -->
     * 
     * @generated not
     */
    @Override
    public String getText(Object object) {
        return ((HardwareInducedFailureType) object).getEntityName() + " [ID: "
                + ((HardwareInducedFailureType) object).getId() + "]" + " <"
                + getString("_UI_HardwareInducedFailureType_type") + ">";
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
