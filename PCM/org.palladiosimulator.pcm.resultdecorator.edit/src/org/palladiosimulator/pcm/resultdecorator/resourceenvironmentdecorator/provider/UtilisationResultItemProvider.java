/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.pcm.resultdecorator.provider.ResultdecoratorEditPlugin;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import org.palladiosimulator.pcm.core.entity.provider.NamedElementItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class UtilisationResultItemProvider extends NamedElementItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public UtilisationResultItemProvider(final AdapterFactory adapterFactory) {
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

            this.addNormalisedResourceUtilisationPropertyDescriptor(object);
            this.addNormalisedWaitTimePropertyDescriptor(object);
            this.addResourceUtilisationPropertyDescriptor(object);
            this.addAverageWaitTimePropertyDescriptor(object);
            this.addAverageQueueLengthPropertyDescriptor(object);
            this.addMaxQueueLengthPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Normalised Resource Utilisation feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNormalisedResourceUtilisationPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_UtilisationResult_normalisedResourceUtilisation_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_UtilisationResult_normalisedResourceUtilisation_feature", "_UI_UtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION, true,
                false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Normalised Wait Time feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNormalisedWaitTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_UtilisationResult_normalisedWaitTime_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_normalisedWaitTime_feature",
                        "_UI_UtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__NORMALISED_WAIT_TIME, true, false,
                false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Resource Utilisation feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addResourceUtilisationPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_UtilisationResult_resourceUtilisation_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_UtilisationResult_resourceUtilisation_feature", "_UI_UtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__RESOURCE_UTILISATION, true, false,
                false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Average Wait Time feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAverageWaitTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_UtilisationResult_averageWaitTime_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_averageWaitTime_feature",
                        "_UI_UtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__AVERAGE_WAIT_TIME, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Average Queue Length feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAverageQueueLengthPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_UtilisationResult_averageQueueLength_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_averageQueueLength_feature",
                        "_UI_UtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH, true, false,
                false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Max Queue Length feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMaxQueueLengthPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_UtilisationResult_maxQueueLength_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_UtilisationResult_maxQueueLength_feature",
                        "_UI_UtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT__MAX_QUEUE_LENGTH, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((UtilisationResult) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_UtilisationResult_type")
                : this.getString("_UI_UtilisationResult_type") + " " + label;
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

        switch (notification.getFeatureID(UtilisationResult.class)) {
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ResultdecoratorEditPlugin.INSTANCE;
    }

}
