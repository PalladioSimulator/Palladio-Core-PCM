/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.provider;


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
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.se.quality.provider.QualityStatementItemProvider;
import de.fzi.se.validation.testbased.TBValidationQuality;
import de.fzi.se.validation.testbased.TestbasedFactory;
import de.fzi.se.validation.testbased.TestbasedPackage;

/**
 * This is the item provider adapter for a {@link de.fzi.se.validation.testbased.TBValidationQuality} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TBValidationQualityItemProvider
	extends QualityStatementItemProvider
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
	public TBValidationQualityItemProvider(AdapterFactory adapterFactory) {
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

			addQualityAnnotationsPropertyDescriptor(object);
			addInternalStateInfluenceAnalysisAggregationResultsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Quality Annotations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQualityAnnotationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TBValidationQuality_qualityAnnotations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TBValidationQuality_qualityAnnotations_feature", "_UI_TBValidationQuality_type"),
				 TestbasedPackage.Literals.TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Internal State Influence Analysis Aggregation Results feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInternalStateInfluenceAnalysisAggregationResultsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TBValidationQuality_internalStateInfluenceAnalysisAggregationResults_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TBValidationQuality_internalStateInfluenceAnalysisAggregationResults_feature", "_UI_TBValidationQuality_type"),
				 TestbasedPackage.Literals.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__STOP_STRATEGY);
			childrenFeatures.add(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__GENERATION_STRATEGY);
			childrenFeatures.add(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY);
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
	 * This returns TBValidationQuality.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TBValidationQuality"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TBValidationQuality)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_TBValidationQuality_type") :
			getString("_UI_TBValidationQuality_type") + " " + label;
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

		switch (notification.getFeatureID(TBValidationQuality.class)) {
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
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
				(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__STOP_STRATEGY,
				 TestbasedFactory.eINSTANCE.createNumberTestcases()));

		newChildDescriptors.add
			(createChildParameter
				(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__STOP_STRATEGY,
				 TestbasedFactory.eINSTANCE.createNumberGenerationRuns()));

		newChildDescriptors.add
			(createChildParameter
				(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__GENERATION_STRATEGY,
				 TestbasedFactory.eINSTANCE.createEquidistantPartitionsRandom()));

		newChildDescriptors.add
			(createChildParameter
				(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY,
				 TestbasedFactory.eINSTANCE.createNoISIA()));

		newChildDescriptors.add
			(createChildParameter
				(TestbasedPackage.Literals.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY,
				 TestbasedFactory.eINSTANCE.createReuseInstanceISIA()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ValidationEditPlugin.INSTANCE;
	}

}
