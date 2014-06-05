/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.provider;

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

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProvider;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.allocation.AllocationContext}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AllocationContextItemProvider extends EntityItemProvider implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
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
    public AllocationContextItemProvider(AdapterFactory adapterFactory) {
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

            addResourceContainer_AllocationContextPropertyDescriptor(object);
            addAssemblyContext_AllocationContextPropertyDescriptor(object);
            addEventChannel__AllocationContextPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Resource Container Allocation Context feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addResourceContainer_AllocationContextPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AllocationContext_resourceContainer_AllocationContext_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_AllocationContext_resourceContainer_AllocationContext_feature",
                        "_UI_AllocationContext_type"),
                AllocationPackage.Literals.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT, true, false,
                true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Assembly Context Allocation Context feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAssemblyContext_AllocationContextPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_AllocationContext_assemblyContext_AllocationContext_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_AllocationContext_assemblyContext_AllocationContext_feature",
                                "_UI_AllocationContext_type"),
                        AllocationPackage.Literals.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, true,
                        false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Event Channel Allocation Context feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addEventChannel__AllocationContextPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AllocationContext_eventChannel__AllocationContext_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_AllocationContext_eventChannel__AllocationContext_feature", "_UI_AllocationContext_type"),
                AllocationPackage.Literals.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT, true, false, true,
                null, null, null));
    }

    /**
     * This returns AllocationContext.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/AllocationContext"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((AllocationContext) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_AllocationContext_type")
                : getString("_UI_AllocationContext_type") + " " + label;
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
