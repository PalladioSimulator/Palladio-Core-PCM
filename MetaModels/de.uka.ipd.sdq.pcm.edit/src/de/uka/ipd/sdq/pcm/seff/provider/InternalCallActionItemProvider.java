/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.provider;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformanceFactory;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.seff.InternalCallAction}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class InternalCallActionItemProvider extends CallActionItemProvider implements IEditingDomainItemProvider,
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
    public InternalCallActionItemProvider(AdapterFactory adapterFactory) {
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

            addIdPropertyDescriptor(object);
            addEntityNamePropertyDescriptor(object);
            addPredecessor_AbstractActionPropertyDescriptor(object);
            addSuccessor_AbstractActionPropertyDescriptor(object);
            addCalledResourceDemandingInternalBehaviourPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Id feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Identifier_id_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Identifier_id_feature", "_UI_Identifier_type"),
                IdentifierPackage.Literals.IDENTIFIER__ID, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Entity Name feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addEntityNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_NamedElement_entityName_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_entityName_feature",
                        "_UI_NamedElement_type"), EntityPackage.Literals.NAMED_ELEMENT__ENTITY_NAME, true, false,
                false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Predecessor Abstract Action feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPredecessor_AbstractActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(),
                        getString("_UI_AbstractAction_predecessor_AbstractAction_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_AbstractAction_predecessor_AbstractAction_feature", "_UI_AbstractAction_type"),
                        SeffPackage.Literals.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, true, false, true, null,
                        null, null));
    }

    /**
     * This adds a property descriptor for the Successor Abstract Action feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSuccessor_AbstractActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_AbstractAction_successor_AbstractAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractAction_successor_AbstractAction_feature",
                        "_UI_AbstractAction_type"), SeffPackage.Literals.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION,
                true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Called Resource Demanding Internal Behaviour feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCalledResourceDemandingInternalBehaviourPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_InternalCallAction_calledResourceDemandingInternalBehaviour_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_InternalCallAction_calledResourceDemandingInternalBehaviour_feature",
                        "_UI_InternalCallAction_type"),
                SeffPackage.Literals.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR, true, false,
                true, null, null, null));
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
            childrenFeatures.add(SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION);
            childrenFeatures
                    .add(SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION);
            childrenFeatures.add(SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION);
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
     * This returns InternalCallAction.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/InternalCallAction"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((InternalCallAction) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_InternalCallAction_type")
                : getString("_UI_InternalCallAction_type") + " " + label;
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

        switch (notification.getFeatureID(InternalCallAction.class)) {
        case SeffPackage.INTERNAL_CALL_ACTION__ID:
        case SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
        case SeffPackage.INTERNAL_CALL_ACTION__INFRASTRUCTURE_CALL_ACTION:
        case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_CALL_ACTION:
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
                SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION,
                SeffPerformanceFactory.eINSTANCE.createParametricResourceDemand()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__INFRASTRUCTURE_CALL_ACTION,
                SeffPerformanceFactory.eINSTANCE.createInfrastructureCall()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION,
                SeffPerformanceFactory.eINSTANCE.createResourceCall()));
    }

}
