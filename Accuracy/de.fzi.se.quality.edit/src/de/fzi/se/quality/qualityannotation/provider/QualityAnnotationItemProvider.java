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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.se.quality.provider.QualityEditPlugin;
import de.fzi.se.quality.provider.QualityStatementItemProvider;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

/**
 * This is the item provider adapter for a
 * {@link de.fzi.se.quality.qualityannotation.QualityAnnotation} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class QualityAnnotationItemProvider extends QualityStatementItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public QualityAnnotationItemProvider(final AdapterFactory adapterFactory) {
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

            this.addIsValidPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Is Valid feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addIsValidPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_QualityAnnotation_isValid_feature"), this.getString(
                        "_UI_PropertyDescriptor_description", "_UI_QualityAnnotation_isValid_feature",
                        "_UI_QualityAnnotation_type"), QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__IS_VALID,
                true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
            this.childrenFeatures.add(QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION);
            this.childrenFeatures.add(QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS);
            this.childrenFeatures
                    .add(QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS);
            this.childrenFeatures.add(QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS);
            this.childrenFeatures
            .add(QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS);
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
     * This returns QualityAnnotation.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/QualityAnnotation"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((QualityAnnotation) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_QualityAnnotation_type") : this
                .getString("_UI_QualityAnnotation_type") + " " + label;
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

        switch (notification.getFeatureID(QualityAnnotation.class)) {
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
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
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION,
                QualityAnnotationFactory.eINSTANCE.createPCMServiceSpecification()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMRECategory()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREInterface()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMRERole()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMRESignature()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREResourceInterface()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREResourceSignature()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREResource()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREResourceRole()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMRECIBehavior()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureInterface()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureRole()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureSignature()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS,
                QualityAnnotationFactory.eINSTANCE.createInternalStateInfluenceAnalysisAggregation()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS,
                QualityAnnotationFactory.eINSTANCE.createPCMPEAllDecisions()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS,
                QualityAnnotationFactory.eINSTANCE.createPCMPEDecision()));

        newChildDescriptors.add(this.createChildParameter(
                QualityAnnotationPackage.Literals.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS,
                QualityAnnotationFactory.eINSTANCE.createPCMParameterPartition()));
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
