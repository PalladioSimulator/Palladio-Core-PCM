/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class InterfaceProvidingRequiringEntityResultsItemProvider extends ComponentResultItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public InterfaceProvidingRequiringEntityResultsItemProvider(final AdapterFactory adapterFactory) {
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

            this.addInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResultPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Interface Providing Requiring Entity Interface
     * Providing Requiring Entity Result feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResultPropertyDescriptor(
            final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString(
                        "_UI_InterfaceProvidingRequiringEntityResults_interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_InterfaceProvidingRequiringEntityResults_interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult_feature",
                        "_UI_InterfaceProvidingRequiringEntityResults_type"),
                RepositorydecoratorPackage.Literals.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT,
                true, false, true, null, null, null));
    }

    /**
     * This returns InterfaceProvidingRequiringEntityResults.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object,
                this.getResourceLocator().getImage("full/obj16/InterfaceProvidingRequiringEntityResults"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((InterfaceProvidingRequiringEntityResults) object).getEntityName();
        return label == null || label.length() == 0
                ? this.getString("_UI_InterfaceProvidingRequiringEntityResults_type")
                : this.getString("_UI_InterfaceProvidingRequiringEntityResults_type") + " " + label;
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
