/**
 */
package de.uka.ipd.sdq.experimentautomation.variation.impl;

import de.uka.ipd.sdq.experimentautomation.variation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariationFactoryImpl extends EFactoryImpl implements VariationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariationFactory init() {
		try {
			VariationFactory theVariationFactory = (VariationFactory)EPackage.Registry.INSTANCE.getEFactory(VariationPackage.eNS_URI);
			if (theVariationFactory != null) {
				return theVariationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VariationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VariationPackage.VALUE_VARIATION: return createValueVariation();
			case VariationPackage.STRUCTURAL_VARIATION: return createStructuralVariation();
			case VariationPackage.VARIATION_REPOSITORY: return createVariationRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueVariation createValueVariation() {
		ValueVariationImpl valueVariation = new ValueVariationImpl();
		return valueVariation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralVariation createStructuralVariation() {
		StructuralVariationImpl structuralVariation = new StructuralVariationImpl();
		return structuralVariation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationRepository createVariationRepository() {
		VariationRepositoryImpl variationRepository = new VariationRepositoryImpl();
		return variationRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPackage getVariationPackage() {
		return (VariationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VariationPackage getPackage() {
		return VariationPackage.eINSTANCE;
	}

} //VariationFactoryImpl
