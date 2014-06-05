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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AssemblyEventConnectorItemProvider extends ConnectorItemProvider implements IEditingDomainItemProvider,
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
    public AssemblyEventConnectorItemProvider(AdapterFactory adapterFactory) {
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

            addSinkRole__AssemblyEventConnectorPropertyDescriptor(object);
            addSourceRole__AssemblyEventConnectorPropertyDescriptor(object);
            addSinkAssemblyContext__AssemblyEventConnectorPropertyDescriptor(object);
            addSourceAssemblyContext__AssemblyEventConnectorPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Sink Role Assembly Event Connector feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSinkRole__AssemblyEventConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AssemblyEventConnector_sinkRole__AssemblyEventConnector_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_AssemblyEventConnector_sinkRole__AssemblyEventConnector_feature",
                        "_UI_AssemblyEventConnector_type"),
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR, true, false,
                true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Source Role Assembly Event Connector feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSourceRole__AssemblyEventConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AssemblyEventConnector_sourceRole__AssemblyEventConnector_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_AssemblyEventConnector_sourceRole__AssemblyEventConnector_feature",
                        "_UI_AssemblyEventConnector_type"),
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR, true,
                false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Sink Assembly Context Assembly Event Connector
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSinkAssemblyContext__AssemblyEventConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AssemblyEventConnector_sinkAssemblyContext__AssemblyEventConnector_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_AssemblyEventConnector_sinkAssemblyContext__AssemblyEventConnector_feature",
                        "_UI_AssemblyEventConnector_type"),
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Source Assembly Context Assembly Event Connector
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSourceAssemblyContext__AssemblyEventConnectorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AssemblyEventConnector_sourceAssemblyContext__AssemblyEventConnector_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_AssemblyEventConnector_sourceAssemblyContext__AssemblyEventConnector_feature",
                        "_UI_AssemblyEventConnector_type"),
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                true, false, true, null, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures
                    .add(CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns AssemblyEventConnector.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/AssemblyEventConnector"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((AssemblyEventConnector) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_AssemblyEventConnector_type")
                : getString("_UI_AssemblyEventConnector_type") + " " + label;
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

        switch (notification.getFeatureID(AssemblyEventConnector.class)) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add(createChildParameter(
                CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                CoreFactory.eINSTANCE.createPCMRandomVariable()));
    }

}
