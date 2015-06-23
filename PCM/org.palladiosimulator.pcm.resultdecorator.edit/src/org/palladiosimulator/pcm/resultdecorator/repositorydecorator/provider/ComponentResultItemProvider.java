/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.provider;

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
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

import org.palladiosimulator.pcm.core.entity.provider.NamedElementItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ComponentResultItemProvider extends NamedElementItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ComponentResultItemProvider(final AdapterFactory adapterFactory) {
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

            this.addNormalisedResourceDemandPropertyDescriptor(object);
            this.addNormalisedResponseTimePropertyDescriptor(object);
            this.addAverageResourceDemandPropertyDescriptor(object);
            this.addMeanResponseTimePropertyDescriptor(object);
            this.addAverageNumberOfSentMessagesPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Normalised Resource Demand feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNormalisedResourceDemandPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ComponentResult_normalisedResourceDemand_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ComponentResult_normalisedResourceDemand_feature", "_UI_ComponentResult_type"),
                RepositorydecoratorPackage.Literals.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Normalised Response Time feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNormalisedResponseTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ComponentResult_normalisedResponseTime_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ComponentResult_normalisedResponseTime_feature", "_UI_ComponentResult_type"),
                RepositorydecoratorPackage.Literals.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Average Resource Demand feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAverageResourceDemandPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ComponentResult_averageResourceDemand_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ComponentResult_averageResourceDemand_feature", "_UI_ComponentResult_type"),
                RepositorydecoratorPackage.Literals.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Mean Response Time feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMeanResponseTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ComponentResult_meanResponseTime_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_ComponentResult_meanResponseTime_feature",
                        "_UI_ComponentResult_type"),
                RepositorydecoratorPackage.Literals.COMPONENT_RESULT__MEAN_RESPONSE_TIME, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Average Number Of Sent Messages feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAverageNumberOfSentMessagesPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ComponentResult_averageNumberOfSentMessages_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ComponentResult_averageNumberOfSentMessages_feature", "_UI_ComponentResult_type"),
                RepositorydecoratorPackage.Literals.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES, true, false,
                false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((ComponentResult) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_ComponentResult_type")
                : this.getString("_UI_ComponentResult_type") + " " + label;
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

        switch (notification.getFeatureID(ComponentResult.class)) {
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
        case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
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
