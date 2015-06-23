/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class LinkingResourceResultsItemProvider extends ActiveResourceUtilisationResultItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public LinkingResourceResultsItemProvider(final AdapterFactory adapterFactory) {
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

            this.addLinkingResource_LinkingResourceResultsPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Linking Resource Linking Resource Results feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addLinkingResource_LinkingResourceResultsPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_LinkingResourceResults_linkingResource_LinkingResourceResults_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_LinkingResourceResults_linkingResource_LinkingResourceResults_feature",
                        "_UI_LinkingResourceResults_type"),
                ResourceenvironmentdecoratorPackage.Literals.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS,
                true, false, true, null, null, null));
    }

    /**
     * This returns LinkingResourceResults.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/LinkingResourceResults"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((LinkingResourceResults) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_LinkingResourceResults_type")
                : this.getString("_UI_LinkingResourceResults_type") + " " + label;
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
