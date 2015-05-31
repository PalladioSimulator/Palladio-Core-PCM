/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProvider;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformanceFactory;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityFactory;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class QoSAnnotationsItemProvider extends EntityItemProvider {
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
    public QoSAnnotationsItemProvider(final AdapterFactory adapterFactory) {
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
            this.childrenFeatures
            .add(QosannotationsPackage.Literals.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS);
            this.childrenFeatures
            .add(QosannotationsPackage.Literals.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS);
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
     * This returns QoSAnnotations.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/QoSAnnotations"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((QoSAnnotations) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_QoSAnnotations_type") : this
                .getString("_UI_QoSAnnotations_type") + " " + label;
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

        switch (notification.getFeatureID(QoSAnnotations.class)) {
        case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
        case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
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
                QosannotationsPackage.Literals.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS,
                QosPerformanceFactory.eINSTANCE.createSystemSpecifiedExecutionTime()));

        newChildDescriptors.add(this.createChildParameter(
                QosannotationsPackage.Literals.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS,
                QosPerformanceFactory.eINSTANCE.createComponentSpecifiedExecutionTime()));

        newChildDescriptors.add(this.createChildParameter(
                QosannotationsPackage.Literals.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS,
                QosReliabilityFactory.eINSTANCE.createSpecifiedReliabilityAnnotation()));
    }

}
