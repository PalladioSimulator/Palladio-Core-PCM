/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.provider;


import LqnCore.LqnCoreFactory;
import LqnCore.LqnCorePackage;
import LqnCore.PrecedenceType;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link LqnCore.PrecedenceType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PrecedenceTypeItemProvider
	extends ItemProviderAdapter
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
	public PrecedenceTypeItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE);
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE_OR);
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE_AND);
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST);
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_OR);
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_AND);
			childrenFeatures.add(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_LOOP);
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
	 * This returns PrecedenceType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PrecedenceType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_PrecedenceType_type");
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

		switch (notification.getFeatureID(PrecedenceType.class)) {
			case LqnCorePackage.PRECEDENCE_TYPE__PRE:
			case LqnCorePackage.PRECEDENCE_TYPE__PRE_OR:
			case LqnCorePackage.PRECEDENCE_TYPE__PRE_AND:
			case LqnCorePackage.PRECEDENCE_TYPE__POST:
			case LqnCorePackage.PRECEDENCE_TYPE__POST_OR:
			case LqnCorePackage.PRECEDENCE_TYPE__POST_AND:
			case LqnCorePackage.PRECEDENCE_TYPE__POST_LOOP:
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
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE,
				 LqnCoreFactory.eINSTANCE.createSingleActivityListType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE_OR,
				 LqnCoreFactory.eINSTANCE.createActivityListType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE_AND,
				 LqnCoreFactory.eINSTANCE.createAndJoinListType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST,
				 LqnCoreFactory.eINSTANCE.createSingleActivityListType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_OR,
				 LqnCoreFactory.eINSTANCE.createOrListType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_AND,
				 LqnCoreFactory.eINSTANCE.createActivityListType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_LOOP,
				 LqnCoreFactory.eINSTANCE.createActivityLoopListType()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE ||
			childFeature == LqnCorePackage.Literals.PRECEDENCE_TYPE__POST ||
			childFeature == LqnCorePackage.Literals.PRECEDENCE_TYPE__PRE_OR ||
			childFeature == LqnCorePackage.Literals.PRECEDENCE_TYPE__POST_AND;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return LqnEditPlugin.INSTANCE;
	}

}
