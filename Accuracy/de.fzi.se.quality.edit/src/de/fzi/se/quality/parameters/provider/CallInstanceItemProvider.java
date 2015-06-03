/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ParametersFactory;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.parameters.pcm.PCMFactory;
import de.fzi.se.quality.provider.QualityEditPlugin;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

/**
 * This is the item provider adapter for a {@link de.fzi.se.quality.parameters.CallInstance} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class CallInstanceItemProvider extends IdentifierItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public CallInstanceItemProvider(final AdapterFactory adapterFactory) {
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

            this.addNumberOfCallsPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Number Of Calls feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addNumberOfCallsPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_CallInstance_numberOfCalls_feature"), this.getString(
                        "_UI_PropertyDescriptor_description", "_UI_CallInstance_numberOfCalls_feature",
                        "_UI_CallInstance_type"), ParametersPackage.Literals.CALL_INSTANCE__NUMBER_OF_CALLS, true,
                false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE);
            this.childrenFeatures.add(ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES);
            this.childrenFeatures.add(ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns CallInstance.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/CallInstance"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((CallInstance) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_CallInstance_type") : this
                .getString("_UI_CallInstance_type") + " " + label;
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

        switch (notification.getFeatureID(CallInstance.class)) {
        case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add(this.createChildParameter(
                ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE,
                PCMFactory.eINSTANCE.createPCMInfrastructureOperationReference()));

        newChildDescriptors.add(this.createChildParameter(
                ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE,
                PCMFactory.eINSTANCE.createPCMBusinessOperationReference()));

        newChildDescriptors.add(this.createChildParameter(
                ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES,
                ParametersFactory.eINSTANCE.createParameterInstance()));

        newChildDescriptors.add(this.createChildParameter(
                ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES,
                ParametersFactory.eINSTANCE.createParameterInstance()));
    }

    /**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getCreateChildText(final Object owner, final Object feature, final Object child,
            final Collection<?> selection) {
        final Object childFeature = feature;
        final Object childObject = child;

        final boolean qualify = childFeature == ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES
                || childFeature == ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES;

        if (qualify) {
            return this.getString(
                    "_UI_CreateChild_text2",
                    new Object[] { this.getTypeText(childObject), this.getFeatureText(childFeature),
                            this.getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return QualityEditPlugin.INSTANCE;
    }

}
