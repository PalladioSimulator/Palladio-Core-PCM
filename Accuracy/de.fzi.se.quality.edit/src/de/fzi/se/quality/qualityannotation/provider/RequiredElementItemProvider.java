/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.se.quality.provider.QualityEditPlugin;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

/**
 * This is the item provider adapter for a
 * {@link de.fzi.se.quality.qualityannotation.RequiredElement} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class RequiredElementItemProvider extends IdentifierItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public RequiredElementItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

        }
        return this.itemPropertyDescriptors;
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
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES);
            this.childrenFeatures.add(QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PRECISION);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns RequiredElement.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/RequiredElement"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((RequiredElement) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_RequiredElement_type") : this
                .getString("_UI_RequiredElement_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(RequiredElement.class)) {
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMRECategory()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREInterface()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMRERole()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMRESignature()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREResourceInterface()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREResourceSignature()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREResource()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREResourceRole()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMRECIBehavior()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureInterface()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureRole()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureSignature()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PRECISION,
                QualityAnnotationFactory.eINSTANCE.createREPrecision()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return QualityEditPlugin.INSTANCE;
    }

}
