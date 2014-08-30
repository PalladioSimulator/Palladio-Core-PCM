/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DoubleOffsetSequenceItemProvider extends DoubleParameterVariationItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public DoubleOffsetSequenceItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addOffsetValuesPropertyDescriptor(object);
            addDoubleOffsetType__DoubleOffsetSequencePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Offset Values feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addOffsetValuesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_DoubleOffsetSequence_offsetValues_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DoubleOffsetSequence_offsetValues_feature",
                        "_UI_DoubleOffsetSequence_type"),
                SensitivityPackage.Literals.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Double Offset Type Double Offset Sequence feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDoubleOffsetType__DoubleOffsetSequencePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_DoubleOffsetSequence_doubleOffsetType__DoubleOffsetSequence_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_DoubleOffsetSequence_doubleOffsetType__DoubleOffsetSequence_feature",
                        "_UI_DoubleOffsetSequence_type"),
                SensitivityPackage.Literals.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE, true,
                false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns DoubleOffsetSequence.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DoubleOffsetSequence"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated not
     */
    @Override
    public String getText(Object object) {
        String doubleSequence = "UNSPECIFIED";
        String offsetType = "";
        try {
            org.eclipse.emf.common.util.EList<Double> values = ((DoubleOffsetSequence) object).getOffsetValues();
            switch (((DoubleOffsetSequence) object).getDoubleOffsetType__DoubleOffsetSequence()) {
            case ADD:
                offsetType = "x + ";
                break;
            case SUBTRACT:
                offsetType = "x - ";
                break;
            case MULTIPLY:
                offsetType = "x * ";
                break;
            case DIVIDE:
                offsetType = "x / ";
                break;
            }
            doubleSequence = offsetType + values.get(0).toString() + " ... " + offsetType
                    + values.get(values.size() - 1).toString();
        } catch (Exception e) {
        }
        return doubleSequence + " <" + getString("_UI_DoubleOffsetSequence_type") + ">";
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(DoubleOffsetSequence.class)) {
        case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__OFFSET_VALUES:
        case SensitivityPackage.DOUBLE_OFFSET_SEQUENCE__DOUBLE_OFFSET_TYPE_DOUBLE_OFFSET_SEQUENCE:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
