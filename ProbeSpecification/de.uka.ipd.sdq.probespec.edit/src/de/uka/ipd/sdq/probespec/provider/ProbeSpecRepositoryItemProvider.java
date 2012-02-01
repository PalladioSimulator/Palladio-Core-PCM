/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.provider;


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

import de.uka.ipd.sdq.probespec.BinaryCalculator;
import de.uka.ipd.sdq.probespec.Calculator;
import de.uka.ipd.sdq.probespec.ProbeSpecRepository;
import de.uka.ipd.sdq.probespec.UnaryCalculator;
import de.uka.ipd.sdq.probespec.probespecFactory;
import de.uka.ipd.sdq.probespec.probespecPackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.probespec.ProbeSpecRepository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProbeSpecRepositoryItemProvider
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
	public ProbeSpecRepositoryItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR);
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
	 * This returns ProbeSpecRepository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ProbeSpecRepository"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public String getText(Object object) {
		//return getString("_UI_ProbeSpecRepository_type");
		ProbeSpecRepository probeSpecRepository = (ProbeSpecRepository)object;
		String label = "Sensor Repository";
		if ((probeSpecRepository.getCalculator() == null) || (probeSpecRepository.getCalculator().size() == 0)) {
			label = label + " (no sensors specified)";
		} else {
			if (probeSpecRepository.getCalculator().size() == 1) {
				label = label + " (1 sensor specified";
			} else {
				label = label + " (" + probeSpecRepository.getCalculator().size() + " sensors specified";
			}
			int numberOfInvalidSensors = getNumberOfInvalidCalculators(probeSpecRepository);
			if (numberOfInvalidSensors > 0) {
				label = label + ", " + numberOfInvalidSensors + " invalid";
			}
			label = label + ")";
		}
		return label;
	}
	
	private int getNumberOfInvalidCalculators(ProbeSpecRepository probeSpecRepository) {
		int result = 0;
		if ((probeSpecRepository.getCalculator() == null) || (probeSpecRepository.getCalculator().size() == 0)) {
			return result;
		}
		for (int i=0; i<probeSpecRepository.getCalculator().size(); i++) {
			if (probeSpecRepository.getCalculator().get(i) instanceof BinaryCalculator) {
				if (!isValid((BinaryCalculator)probeSpecRepository.getCalculator().get(i))) {
					result++;
				}
			} else if (probeSpecRepository.getCalculator().get(i) instanceof UnaryCalculator) {
				if (!isValid((UnaryCalculator)probeSpecRepository.getCalculator().get(i))) {
					result++;
				}
			} else {
				if (!isValid(probeSpecRepository.getCalculator().get(i))) {
					result++;
				}
			}
		}
		return result;
	}
	
	private boolean isValid(BinaryCalculator calculator) {
		if ((calculator.getProbeSet() == null) || (calculator.getProbeSet().size() == 0)) { 
			return false;
		}
		for (int i=0; i<calculator.getProbeSet().size(); i++) {
			if (calculator.getProbeSet().get(i).getAnnotatedElement() == null) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isValid(UnaryCalculator calculator) {
		if ((calculator.getProbeSet() == null) || (calculator.getProbeSet().getAnnotatedElement() == null)) {
			return false;
		}
		return true;
	}
	
	private boolean isValid(Calculator calculator) {
		return false;
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

		switch (notification.getFeatureID(ProbeSpecRepository.class)) {
			case probespecPackage.PROBE_SPEC_REPOSITORY__CALCULATOR:
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
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createPassiveResourceCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createStoExCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createSEFFParameterCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createResponseTimeCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createWaitingTimeCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createHDDStateCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createCPUStateCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createCPUDemandCalculator()));

		newChildDescriptors.add
			(createChildParameter
				(probespecPackage.Literals.PROBE_SPEC_REPOSITORY__CALCULATOR,
				 probespecFactory.eINSTANCE.createHDDDemandCalculator()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ProbeSpecificationEditPlugin.INSTANCE;
	}

}
