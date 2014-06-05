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
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityFactory;

/**
 * This is the item provider adapter for a
 * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ResourceDemandingBehaviourItemProvider extends IdentifierItemProvider implements
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
    public ResourceDemandingBehaviourItemProvider(AdapterFactory adapterFactory) {
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
            childrenFeatures.add(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR);
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
     * This returns ResourceDemandingBehaviour.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ResourceDemandingBehaviour"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((ResourceDemandingBehaviour) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_ResourceDemandingBehaviour_type")
                : getString("_UI_ResourceDemandingBehaviour_type") + " " + label;
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

        switch (notification.getFeatureID(ResourceDemandingBehaviour.class)) {
        case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
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
