/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.provider;

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

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.RequiredResourceDelegationConnector;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.core.composition.RequiredResourceDelegationConnector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class RequiredResourceDelegationConnectorItemProvider extends DelegationConnectorItemProvider implements
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
    public RequiredResourceDelegationConnectorItemProvider(AdapterFactory adapterFactory) {
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

            addAssemblyContext__RequiredResourceDelegationConnectorPropertyDescriptor(object);
            addInnerRequiredRole__RequiredResourceDelegationConnectorPropertyDescriptor(object);
            addOuterRequiredRole__RequiredResourceDelegationConnectorPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Assembly Context Required Resource Delegation
     * Connector feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAssemblyContext__RequiredResourceDelegationConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_RequiredResourceDelegationConnector_assemblyContext__RequiredResourceDelegationConnector_feature"),
                        getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_RequiredResourceDelegationConnector_assemblyContext__RequiredResourceDelegationConnector_feature",
                                "_UI_RequiredResourceDelegationConnector_type"),
                        CompositionPackage.Literals.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                        true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Inner Required Role Required Resource Delegation
     * Connector feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addInnerRequiredRole__RequiredResourceDelegationConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_RequiredResourceDelegationConnector_innerRequiredRole__RequiredResourceDelegationConnector_feature"),
                        getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_RequiredResourceDelegationConnector_innerRequiredRole__RequiredResourceDelegationConnector_feature",
                                "_UI_RequiredResourceDelegationConnector_type"),
                        CompositionPackage.Literals.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                        true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Outer Required Role Required Resource Delegation
     * Connector feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addOuterRequiredRole__RequiredResourceDelegationConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_RequiredResourceDelegationConnector_outerRequiredRole__RequiredResourceDelegationConnector_feature"),
                        getString(
                                "_UI_PropertyDescriptor_description",
                                "_UI_RequiredResourceDelegationConnector_outerRequiredRole__RequiredResourceDelegationConnector_feature",
                                "_UI_RequiredResourceDelegationConnector_type"),
                        CompositionPackage.Literals.REQUIRED_RESOURCE_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_RESOURCE_DELEGATION_CONNECTOR,
                        true, false, true, null, null, null));
    }

    /**
     * This returns RequiredResourceDelegationConnector.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/RequiredResourceDelegationConnector"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((RequiredResourceDelegationConnector) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_RequiredResourceDelegationConnector_type")
                : getString("_UI_RequiredResourceDelegationConnector_type") + " " + label;
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
