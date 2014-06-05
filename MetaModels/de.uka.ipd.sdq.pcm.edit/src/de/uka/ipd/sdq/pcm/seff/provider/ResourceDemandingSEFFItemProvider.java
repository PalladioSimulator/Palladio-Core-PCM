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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityFactory;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ResourceDemandingSEFFItemProvider extends IdentifierItemProvider implements IEditingDomainItemProvider,
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
    public ResourceDemandingSEFFItemProvider(AdapterFactory adapterFactory) {
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

            addSeffTypeIDPropertyDescriptor(object);
            addDescribedService__SEFFPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Seff Type ID feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addSeffTypeIDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_ServiceEffectSpecification_seffTypeID_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_ServiceEffectSpecification_seffTypeID_feature",
                        "_UI_ServiceEffectSpecification_type"),
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Described Service SEFF feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDescribedService__SEFFPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_ServiceEffectSpecification_describedService__SEFF_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_ServiceEffectSpecification_describedService__SEFF_feature",
                        "_UI_ServiceEffectSpecification_type"),
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF, true, false, true, null,
                null, null));
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
            childrenFeatures.add(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR);
            childrenFeatures.add(SeffPackage.Literals.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS);
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
     * This returns ResourceDemandingSEFF.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ResourceDemandingSEFF"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((ResourceDemandingSEFF) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_ResourceDemandingSEFF_type")
                : getString("_UI_ResourceDemandingSEFF_type") + " " + label;
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

        switch (notification.getFeatureID(ResourceDemandingSEFF.class)) {
        case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
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
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createStopAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createBranchAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createStartAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createReleaseAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createLoopAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createForkAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createExternalCallAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createAcquireAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createCollectionIteratorAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createSetVariableAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createInternalCallAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createEmitEventAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffFactory.eINSTANCE.createInternalAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR,
                SeffReliabilityFactory.eINSTANCE.createRecoveryAction()));

        newChildDescriptors.add(createChildParameter(
                SeffPackage.Literals.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS,
                SeffFactory.eINSTANCE.createResourceDemandingInternalBehaviour()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ((IChildCreationExtender) adapterFactory).getResourceLocator();
    }

}
