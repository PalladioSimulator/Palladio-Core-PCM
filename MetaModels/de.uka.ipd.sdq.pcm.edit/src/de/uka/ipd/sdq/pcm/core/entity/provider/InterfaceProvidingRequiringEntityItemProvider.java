/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.pcm.core.entity.EntityFactory;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class InterfaceProvidingRequiringEntityItemProvider extends InterfaceProvidingEntityItemProvider implements
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
    public InterfaceProvidingRequiringEntityItemProvider(AdapterFactory adapterFactory) {
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

        }
        return itemPropertyDescriptors;
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
                    .add(EntityPackage.Literals.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY);
            childrenFeatures
                    .add(EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY);
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
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((InterfaceProvidingRequiringEntity) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_InterfaceProvidingRequiringEntity_type")
                : getString("_UI_InterfaceProvidingRequiringEntity_type") + " " + label;
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

        switch (notification.getFeatureID(InterfaceProvidingRequiringEntity.class)) {
        case EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
        case EntityPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
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

        newChildDescriptors
                .add(createChildParameter(
                        EntityPackage.Literals.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                        EntityFactory.eINSTANCE.createResourceRequiredRole()));

        newChildDescriptors.add(createChildParameter(
                EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                RepositoryFactory.eINSTANCE.createInfrastructureRequiredRole()));

        newChildDescriptors.add(createChildParameter(
                EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                RepositoryFactory.eINSTANCE.createOperationRequiredRole()));

        newChildDescriptors.add(createChildParameter(
                EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                RepositoryFactory.eINSTANCE.createSourceRole()));
    }

}
