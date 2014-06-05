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
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SinkDelegationConnectorItemProvider extends
        de.uka.ipd.sdq.pcm.core.composition.provider.DelegationConnectorItemProvider implements
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
    public SinkDelegationConnectorItemProvider(AdapterFactory adapterFactory) {
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

            addAssemblyContext__SinkDelegationConnectorPropertyDescriptor(object);
            addInnerSinkRole__SinkRolePropertyDescriptor(object);
            addOuterSinkRole__SinkRolePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Assembly Context Sink Delegation Connector feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAssemblyContext__SinkDelegationConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SinkDelegationConnector_assemblyContext__SinkDelegationConnector_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_SinkDelegationConnector_assemblyContext__SinkDelegationConnector_feature",
                        "_UI_SinkDelegationConnector_type"),
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR,
                true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Inner Sink Role Sink Role feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addInnerSinkRole__SinkRolePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SinkDelegationConnector_innerSinkRole__SinkRole_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_SinkDelegationConnector_innerSinkRole__SinkRole_feature",
                        "_UI_SinkDelegationConnector_type"),
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_ROLE, true, false, true,
                null, null, null));
    }

    /**
     * This adds a property descriptor for the Outer Sink Role Sink Role feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addOuterSinkRole__SinkRolePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_SinkDelegationConnector_outerSinkRole__SinkRole_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_SinkDelegationConnector_outerSinkRole__SinkRole_feature",
                        "_UI_SinkDelegationConnector_type"),
                CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_ROLE, true, false, true,
                null, null, null));
    }

    /**
     * This returns SinkDelegationConnector.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/SinkDelegationConnector"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((SinkDelegationConnector) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_SinkDelegationConnector_type")
                : getString("_UI_SinkDelegationConnector_type") + " " + label;
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
