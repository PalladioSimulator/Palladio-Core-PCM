/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;

/**
 * This is the item provider adapter for a
 * {@link de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class PCMComponentParameterReferenceItemProvider extends PCMParameterReferenceItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public PCMComponentParameterReferenceItemProvider(final AdapterFactory adapterFactory) {
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

            this.addImplementationComponentTypePropertyDescriptor(object);
            this.addVariableUsagePropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Implementation Component Type feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addImplementationComponentTypePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_PCMComponentParameterReference_implementationComponentType_feature"), this
                .getString("_UI_PropertyDescriptor_description",
                        "_UI_PCMComponentParameterReference_implementationComponentType_feature",
                        "_UI_PCMComponentParameterReference_type"),
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE, true, false,
                true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Variable Usage feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addVariableUsagePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_PCMComponentParameterReference_variableUsage_feature"), this.getString(
                        "_UI_PropertyDescriptor_description",
                        "_UI_PCMComponentParameterReference_variableUsage_feature",
                        "_UI_PCMComponentParameterReference_type"),
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, true, false, true, null, null,
                null));
    }

    /**
     * This returns PCMComponentParameterReference.gif. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator()
                .getImage("full/obj16/PCMComponentParameterReference"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((PCMComponentParameterReference) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_PCMComponentParameterReference_type") : this
                .getString("_UI_PCMComponentParameterReference_type") + " " + label;
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
