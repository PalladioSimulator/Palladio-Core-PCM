/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.pcm.completions.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.pcm.completions.CompletionsPackage;

import org.palladiosimulator.pcm.seff.seff_performance.provider.ParametricResourceDemandItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class NetworkDemandParametricResourceDemandItemProvider extends ParametricResourceDemandItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public NetworkDemandParametricResourceDemandItemProvider(final AdapterFactory adapterFactory) {
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

            this.addRequiredCommunicationLinkResource_ParametricResourceDemandPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Required Communication Link Resource Parametric
     * Resource Demand feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addRequiredCommunicationLinkResource_ParametricResourceDemandPropertyDescriptor(
            final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString(
                        "_UI_NetworkDemandParametricResourceDemand_requiredCommunicationLinkResource_ParametricResourceDemand_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_NetworkDemandParametricResourceDemand_requiredCommunicationLinkResource_ParametricResourceDemand_feature",
                        "_UI_NetworkDemandParametricResourceDemand_type"),
                CompletionsPackage.Literals.NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND,
                true, false, true, null, null, null));
    }

    /**
     * This returns NetworkDemandParametricResourceDemand.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object,
                this.getResourceLocator().getImage("full/obj16/NetworkDemandParametricResourceDemand"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        return this.getString("_UI_NetworkDemandParametricResourceDemand_type");
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
        return CompletionsEditPlugin.INSTANCE;
    }

}
