/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.pcm.resultdecorator.provider.ResultdecoratorEditPlugin;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ServiceResultItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ServiceResultItemProvider(final AdapterFactory adapterFactory) {
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

            this.addMeanResponseTimePropertyDescriptor(object);
            this.addThroughputPropertyDescriptor(object);
            this.addServiceEffectSpecification_ServiceResultPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
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
                this.getString("_UI_ServiceResult_meanResponseTime_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_ServiceResult_meanResponseTime_feature",
                        "_UI_ServiceResult_type"),
                RepositorydecoratorPackage.Literals.SERVICE_RESULT__MEAN_RESPONSE_TIME, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Throughput feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addThroughputPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ServiceResult_throughput_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_ServiceResult_throughput_feature",
                        "_UI_ServiceResult_type"),
                RepositorydecoratorPackage.Literals.SERVICE_RESULT__THROUGHPUT, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Service Effect Specification Service Result feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addServiceEffectSpecification_ServiceResultPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ServiceResult_serviceEffectSpecification_ServiceResult_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ServiceResult_serviceEffectSpecification_ServiceResult_feature", "_UI_ServiceResult_type"),
                RepositorydecoratorPackage.Literals.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT, true,
                false, true, null, null, null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final ServiceResult serviceResult = (ServiceResult) object;
        return this.getString("_UI_ServiceResult_type") + " " + serviceResult.getMeanResponseTime();
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

        switch (notification.getFeatureID(ServiceResult.class)) {
        case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
        case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
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
