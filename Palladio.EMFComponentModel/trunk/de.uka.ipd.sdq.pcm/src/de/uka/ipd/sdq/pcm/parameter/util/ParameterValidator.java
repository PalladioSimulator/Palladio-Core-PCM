/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.util;

import de.uka.ipd.sdq.pcm.parameter.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage
 * @generated
 */
public class ParameterValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ParameterValidator INSTANCE = new ParameterValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.parameter";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Collection Parameter Usagehastolinka Collection Data Type' of 'Collection Parameter Usage'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_PARAMETER_USAGE__COLLECTION_PARAMETER_USAGEHASTOLINKA_COLLECTION_DATA_TYPE = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackage getEPackage() {
	  return ParameterPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case ParameterPackage.PARAMETER_CHARACTERISATION:
				return validateParameterCharacterisation((ParameterCharacterisation)value, diagnostics, context);
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE:
				return validateCompositeParameterUsage((CompositeParameterUsage)value, diagnostics, context);
			case ParameterPackage.COLLECTION_PARAMETER_USAGE:
				return validateCollectionParameterUsage((CollectionParameterUsage)value, diagnostics, context);
			case ParameterPackage.COLLECTION_PARAMETER_CHARACTERISATION:
				return validateCollectionParameterCharacterisation((CollectionParameterCharacterisation)value, diagnostics, context);
			case ParameterPackage.PRIMITIVE_PARAMETER_USAGE:
				return validatePrimitiveParameterUsage((PrimitiveParameterUsage)value, diagnostics, context);
			case ParameterPackage.PARAMETER_USAGE:
				return validateParameterUsage((ParameterUsage)value, diagnostics, context);
			case ParameterPackage.PARAMETER_CHARACTERISATION_TYPE:
				return validateParameterCharacterisationType((ParameterCharacterisationType)value, diagnostics, context);
			case ParameterPackage.COLLECTION_PARAMETER_CHARACTERISATION_TYPE:
				return validateCollectionParameterCharacterisationType((CollectionParameterCharacterisationType)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterCharacterisation(ParameterCharacterisation parameterCharacterisation, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(parameterCharacterisation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeParameterUsage(CompositeParameterUsage compositeParameterUsage, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(compositeParameterUsage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionParameterUsage(CollectionParameterUsage collectionParameterUsage, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(collectionParameterUsage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionParameterUsage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionParameterUsage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionParameterUsage, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionParameterUsage_CollectionParameterUsagehastolinkaCollectionDataType(collectionParameterUsage, diagnostics, context);
		return result;
	}

	/**
	 * Validates the CollectionParameterUsagehastolinkaCollectionDataType constraint of '<em>Collection Parameter Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionParameterUsage_CollectionParameterUsagehastolinkaCollectionDataType(CollectionParameterUsage collectionParameterUsage, DiagnosticChain diagnostics, Map context) {
		return collectionParameterUsage.CollectionParameterUsagehastolinkaCollectionDataType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionParameterCharacterisation(CollectionParameterCharacterisation collectionParameterCharacterisation, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(collectionParameterCharacterisation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveParameterUsage(PrimitiveParameterUsage primitiveParameterUsage, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(primitiveParameterUsage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterUsage(ParameterUsage parameterUsage, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(parameterUsage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterCharacterisationType(ParameterCharacterisationType parameterCharacterisationType, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionParameterCharacterisationType(CollectionParameterCharacterisationType collectionParameterCharacterisationType, DiagnosticChain diagnostics, Map context) {
		return true;
	}

} //ParameterValidator
