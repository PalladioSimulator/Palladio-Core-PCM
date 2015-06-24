/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class PassiveResourceResultItemProvider extends UtilisationResultItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public PassiveResourceResultItemProvider(final AdapterFactory adapterFactory) {
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

            this.addPassiveResource_PassiveResourceResultPropertyDescriptor(object);
            this.addAssemblyContext_PassiveResourceResultPropertyDescriptor(object);
            this.addAverageHoldingTimePropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Passive Resource Passive Resource Result feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPassiveResource_PassiveResourceResultPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_PassiveResourceResult_passiveResource_PassiveResourceResult_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_PassiveResourceResult_passiveResource_PassiveResourceResult_feature",
                        "_UI_PassiveResourceResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT,
                true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Assembly Context Passive Resource Result feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAssemblyContext_PassiveResourceResultPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_PassiveResourceResult_assemblyContext_PassiveResourceResult_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_PassiveResourceResult_assemblyContext_PassiveResourceResult_feature",
                        "_UI_PassiveResourceResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT,
                true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Average Holding Time feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAverageHoldingTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_PassiveResourceResult_averageHoldingTime_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_PassiveResourceResult_averageHoldingTime_feature", "_UI_PassiveResourceResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME, true, false,
                false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This returns PassiveResourceResult.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/PassiveResourceResult"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((PassiveResourceResult) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_PassiveResourceResult_type")
                : this.getString("_UI_PassiveResourceResult_type") + " " + label;
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

        switch (notification.getFeatureID(PassiveResourceResult.class)) {
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
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

}
