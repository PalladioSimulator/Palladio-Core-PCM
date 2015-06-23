/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class AllocationServiceResultItemProvider extends ServiceResultItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public AllocationServiceResultItemProvider(final AdapterFactory adapterFactory) {
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

            this.addAllocationContext_AllocationServiceResultPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Allocation Context Allocation Service Result feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addAllocationContext_AllocationServiceResultPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_AllocationServiceResult_allocationContext_AllocationServiceResult_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_AllocationServiceResult_allocationContext_AllocationServiceResult_feature",
                        "_UI_AllocationServiceResult_type"),
                RepositorydecoratorPackage.Literals.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT,
                true, false, true, null, null, null));
    }

    /**
     * This returns AllocationServiceResult.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/AllocationServiceResult"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final AllocationServiceResult allocationServiceResult = (AllocationServiceResult) object;
        return this.getString("_UI_AllocationServiceResult_type") + " " + allocationServiceResult.getMeanResponseTime();
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

}
