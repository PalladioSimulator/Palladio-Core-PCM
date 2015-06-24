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
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ActiveResourceUtilisationResultItemProvider extends UtilisationResultItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ActiveResourceUtilisationResultItemProvider(final AdapterFactory adapterFactory) {
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

            this.addNormalisedDemandedTimePropertyDescriptor(object);
            this.addDemandedTimePropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Normalised Demanded Time feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNormalisedDemandedTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ActiveResourceUtilisationResult_normalisedDemandedTime_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ActiveResourceUtilisationResult_normalisedDemandedTime_feature",
                        "_UI_ActiveResourceUtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME,
                true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Demanded Time feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addDemandedTimePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_ActiveResourceUtilisationResult_demandedTime_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_ActiveResourceUtilisationResult_demandedTime_feature",
                        "_UI_ActiveResourceUtilisationResult_type"),
                ResourceenvironmentdecoratorPackage.Literals.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME, true,
                false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((ActiveResourceUtilisationResult) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_ActiveResourceUtilisationResult_type")
                : this.getString("_UI_ActiveResourceUtilisationResult_type") + " " + label;
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

        switch (notification.getFeatureID(ActiveResourceUtilisationResult.class)) {
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
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
