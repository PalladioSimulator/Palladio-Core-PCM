/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.provider;


import LqnCore.LqnCoreFactory;
import LqnCore.LqnCorePackage;
import LqnCore.OutputDistributionType;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link LqnCore.OutputDistributionType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OutputDistributionTypeItemProvider
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
	public OutputDistributionTypeItemProvider(AdapterFactory adapterFactory) {
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

			addBinSizePropertyDescriptor(object);
			addKurtosisPropertyDescriptor(object);
			addMaxPropertyDescriptor(object);
			addMeanPropertyDescriptor(object);
			addMidPointPropertyDescriptor(object);
			addMinPropertyDescriptor(object);
			addNumberBinsPropertyDescriptor(object);
			addSkewPropertyDescriptor(object);
			addStdDevPropertyDescriptor(object);
			addXSamplesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Bin Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBinSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_binSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_binSize_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__BIN_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Kurtosis feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKurtosisPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_kurtosis_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_kurtosis_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__KURTOSIS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_max_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__MAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMeanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_mean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_mean_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__MEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mid Point feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMidPointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_midPoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_midPoint_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__MID_POINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_min_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__MIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Number Bins feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberBinsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_numberBins_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_numberBins_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__NUMBER_BINS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Skew feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSkewPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_skew_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_skew_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__SKEW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Std Dev feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStdDevPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_stdDev_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_stdDev_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__STD_DEV,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the XSamples feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXSamplesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OutputDistributionType_xSamples_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OutputDistributionType_xSamples_feature", "_UI_OutputDistributionType_type"),
				 LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__XSAMPLES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__UNDERFLOW_BIN);
			childrenFeatures.add(LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__HISTOGRAM_BIN);
			childrenFeatures.add(LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__OVERFLOW_BIN);
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
	 * This returns OutputDistributionType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OutputDistributionType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Object labelValue = ((OutputDistributionType)object).getBinSize();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_OutputDistributionType_type") :
			getString("_UI_OutputDistributionType_type") + " " + label;
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

		switch (notification.getFeatureID(OutputDistributionType.class)) {
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__BIN_SIZE:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__KURTOSIS:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__MAX:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__MEAN:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__MID_POINT:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__MIN:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__NUMBER_BINS:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__SKEW:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__STD_DEV:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__XSAMPLES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__UNDERFLOW_BIN:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__HISTOGRAM_BIN:
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE__OVERFLOW_BIN:
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
				(LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__UNDERFLOW_BIN,
				 LqnCoreFactory.eINSTANCE.createHistogramBinType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__HISTOGRAM_BIN,
				 LqnCoreFactory.eINSTANCE.createHistogramBinType()));

		newChildDescriptors.add
			(createChildParameter
				(LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__OVERFLOW_BIN,
				 LqnCoreFactory.eINSTANCE.createHistogramBinType()));
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
			childFeature == LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__UNDERFLOW_BIN ||
			childFeature == LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__HISTOGRAM_BIN ||
			childFeature == LqnCorePackage.Literals.OUTPUT_DISTRIBUTION_TYPE__OVERFLOW_BIN;

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
