/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.provider;


import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkFactory;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.provider.SourceCodeDecoratorEditPlugin;

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

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PCMLinkRepositoryItemProvider
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
	public PCMLinkRepositoryItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__COMPONENTFILELINK);
			childrenFeatures.add(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__SEFFMETHODLINK);
			childrenFeatures.add(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK);
			childrenFeatures.add(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS);
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
	 * This returns PCMLinkRepository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PCMLinkRepository"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PCMLinkRepository)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_PCMLinkRepository_type") :
			getString("_UI_PCMLinkRepository_type") + " " + label;
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

		switch (notification.getFeatureID(PCMLinkRepository.class)) {
			case PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK:
			case PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK:
			case PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK:
			case PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS:
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
				(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__COMPONENTFILELINK,
				 PCMLinkFactory.eINSTANCE.createComponentFileLink()));

		newChildDescriptors.add
			(createChildParameter
				(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__SEFFMETHODLINK,
				 PCMLinkFactory.eINSTANCE.createSEFFMethodLink()));

		newChildDescriptors.add
			(createChildParameter
				(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK,
				 PCMLinkFactory.eINSTANCE.createActionControlFlowLink()));

		newChildDescriptors.add
			(createChildParameter
				(PCMLinkPackage.Literals.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS,
				 LoggerlinkFactory.eINSTANCE.createLoggingPositionId()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SourceCodeDecoratorEditPlugin.INSTANCE;
	}

}
