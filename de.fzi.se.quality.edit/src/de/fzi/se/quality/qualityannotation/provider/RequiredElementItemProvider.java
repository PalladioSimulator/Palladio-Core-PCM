/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.se.quality.provider.QualityEditPlugin;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

/**
 * This is the item provider adapter for a {@link de.fzi.se.quality.qualityannotation.RequiredElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequiredElementItemProvider
	extends IdentifierItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RequiredElementItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

	/**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

        }
        return itemPropertyDescriptors;
    }

	/**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES);
            childrenFeatures.add(QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PRECISION);
        }
        return childrenFeatures;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

	/**
     * This returns RequiredElement.gif.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/RequiredElement"));
    }

	/**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String getText(Object object) {
        String label = ((RequiredElement)object).getId();
        return label == null || label.length() == 0 ?
            getString("_UI_RequiredElement_type") :
            getString("_UI_RequiredElement_type") + " " + label;
    }

	/**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(RequiredElement.class)) {
            case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

	/**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMRECategory()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREInterface()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMRERole()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMRESignature()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREResourceInterface()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREResourceSignature()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREResource()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREResourceRole()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMRECIBehavior()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureInterface()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureRole()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES,
                 QualityAnnotationFactory.eINSTANCE.createPCMREInfrastructureSignature()));

        newChildDescriptors.add
            (createChildParameter
                (QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PRECISION,
                 QualityAnnotationFactory.eINSTANCE.createREPrecision()));
    }

	/**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public ResourceLocator getResourceLocator() {
        return QualityEditPlugin.INSTANCE;
    }

}
