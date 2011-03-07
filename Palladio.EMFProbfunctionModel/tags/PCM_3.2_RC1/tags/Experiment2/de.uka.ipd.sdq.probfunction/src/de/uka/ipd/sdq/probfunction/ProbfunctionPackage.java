/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionFactory
 * @model kind="package"
 * @generated
 */
public interface ProbfunctionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "probfunction";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ProbFunction/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "probfunction";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProbfunctionPackage eINSTANCE = de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.ProbabilityFunctionImpl <em>Probability Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbabilityFunctionImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getProbabilityFunction()
	 * @generated
	 */
	int PROBABILITY_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION__UNIT = 0;

	/**
	 * The number of structural features of the '<em>Probability Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.ProbabilityDensityFunctionImpl <em>Probability Density Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbabilityDensityFunctionImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getProbabilityDensityFunction()
	 * @generated
	 */
	int PROBABILITY_DENSITY_FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_DENSITY_FUNCTION__UNIT = PROBABILITY_FUNCTION__UNIT;

	/**
	 * The number of structural features of the '<em>Probability Density Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT = PROBABILITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.BoxedPDFImpl <em>Boxed PDF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.BoxedPDFImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getBoxedPDF()
	 * @generated
	 */
	int BOXED_PDF = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXED_PDF__UNIT = PROBABILITY_DENSITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXED_PDF__SAMPLES = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boxed PDF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXED_PDF_FEATURE_COUNT = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.UnitImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 3;

	/**
	 * The feature id for the '<em><b>Unit Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__UNIT_NAME = 0;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.ContinuousSampleImpl <em>Continuous Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.ContinuousSampleImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getContinuousSample()
	 * @generated
	 */
	int CONTINUOUS_SAMPLE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_SAMPLE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_SAMPLE__PROBABILITY = 1;

	/**
	 * The number of structural features of the '<em>Continuous Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_SAMPLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.ProbabilityMassFunctionImpl <em>Probability Mass Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbabilityMassFunctionImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getProbabilityMassFunction()
	 * @generated
	 */
	int PROBABILITY_MASS_FUNCTION = 5;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_MASS_FUNCTION__UNIT = PROBABILITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_MASS_FUNCTION__SAMPLES = PROBABILITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordered Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_MASS_FUNCTION__ORDERED_DOMAIN = PROBABILITY_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Probability Mass Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_MASS_FUNCTION_FEATURE_COUNT = PROBABILITY_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.SampleImpl <em>Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.SampleImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getSample()
	 * @generated
	 */
	int SAMPLE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE__PROBABILITY = 1;

	/**
	 * The number of structural features of the '<em>Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.probfunction.impl.SamplePDFImpl <em>Sample PDF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.probfunction.impl.SamplePDFImpl
	 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getSamplePDF()
	 * @generated
	 */
	int SAMPLE_PDF = 7;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF__UNIT = PROBABILITY_DENSITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF__DISTANCE = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF__VALUES = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sample PDF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF_FEATURE_COUNT = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.BoxedPDF <em>Boxed PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boxed PDF</em>'.
	 * @see de.uka.ipd.sdq.probfunction.BoxedPDF
	 * @generated
	 */
	EClass getBoxedPDF();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.probfunction.BoxedPDF#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Samples</em>'.
	 * @see de.uka.ipd.sdq.probfunction.BoxedPDF#getSamples()
	 * @see #getBoxedPDF()
	 * @generated
	 */
	EReference getBoxedPDF_Samples();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction <em>Probability Density Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Density Function</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction
	 * @generated
	 */
	EClass getProbabilityDensityFunction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.ProbabilityFunction <em>Probability Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Function</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ProbabilityFunction
	 * @generated
	 */
	EClass getProbabilityFunction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.probfunction.ProbabilityFunction#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ProbabilityFunction#getUnit()
	 * @see #getProbabilityFunction()
	 * @generated
	 */
	EReference getProbabilityFunction_Unit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.probfunction.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.Unit#getUnitName <em>Unit Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Name</em>'.
	 * @see de.uka.ipd.sdq.probfunction.Unit#getUnitName()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_UnitName();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.ContinuousSample <em>Continuous Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous Sample</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ContinuousSample
	 * @generated
	 */
	EClass getContinuousSample();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.ContinuousSample#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ContinuousSample#getValue()
	 * @see #getContinuousSample()
	 * @generated
	 */
	EAttribute getContinuousSample_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.ContinuousSample#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ContinuousSample#getProbability()
	 * @see #getContinuousSample()
	 * @generated
	 */
	EAttribute getContinuousSample_Probability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.ProbabilityMassFunction <em>Probability Mass Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Mass Function</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ProbabilityMassFunction
	 * @generated
	 */
	EClass getProbabilityMassFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Samples</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#getSamples()
	 * @see #getProbabilityMassFunction()
	 * @generated
	 */
	EReference getProbabilityMassFunction_Samples();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#isOrderedDomain <em>Ordered Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered Domain</em>'.
	 * @see de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#isOrderedDomain()
	 * @see #getProbabilityMassFunction()
	 * @generated
	 */
	EAttribute getProbabilityMassFunction_OrderedDomain();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample</em>'.
	 * @see de.uka.ipd.sdq.probfunction.Sample
	 * @generated
	 */
	EClass getSample();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.Sample#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.probfunction.Sample#getValue()
	 * @see #getSample()
	 * @generated
	 */
	EAttribute getSample_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.Sample#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.probfunction.Sample#getProbability()
	 * @see #getSample()
	 * @generated
	 */
	EAttribute getSample_Probability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.probfunction.SamplePDF <em>Sample PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample PDF</em>'.
	 * @see de.uka.ipd.sdq.probfunction.SamplePDF
	 * @generated
	 */
	EClass getSamplePDF();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.probfunction.SamplePDF#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see de.uka.ipd.sdq.probfunction.SamplePDF#getDistance()
	 * @see #getSamplePDF()
	 * @generated
	 */
	EAttribute getSamplePDF_Distance();

	/**
	 * Returns the meta object for the attribute list '{@link de.uka.ipd.sdq.probfunction.SamplePDF#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see de.uka.ipd.sdq.probfunction.SamplePDF#getValues()
	 * @see #getSamplePDF()
	 * @generated
	 */
	EAttribute getSamplePDF_Values();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProbfunctionFactory getProbfunctionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.BoxedPDFImpl <em>Boxed PDF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.BoxedPDFImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getBoxedPDF()
		 * @generated
		 */
		EClass BOXED_PDF = eINSTANCE.getBoxedPDF();

		/**
		 * The meta object literal for the '<em><b>Samples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOXED_PDF__SAMPLES = eINSTANCE.getBoxedPDF_Samples();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.ProbabilityDensityFunctionImpl <em>Probability Density Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbabilityDensityFunctionImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getProbabilityDensityFunction()
		 * @generated
		 */
		EClass PROBABILITY_DENSITY_FUNCTION = eINSTANCE.getProbabilityDensityFunction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.ProbabilityFunctionImpl <em>Probability Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbabilityFunctionImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getProbabilityFunction()
		 * @generated
		 */
		EClass PROBABILITY_FUNCTION = eINSTANCE.getProbabilityFunction();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBABILITY_FUNCTION__UNIT = eINSTANCE.getProbabilityFunction_Unit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.UnitImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__UNIT_NAME = eINSTANCE.getUnit_UnitName();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.ContinuousSampleImpl <em>Continuous Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.ContinuousSampleImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getContinuousSample()
		 * @generated
		 */
		EClass CONTINUOUS_SAMPLE = eINSTANCE.getContinuousSample();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINUOUS_SAMPLE__VALUE = eINSTANCE.getContinuousSample_Value();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINUOUS_SAMPLE__PROBABILITY = eINSTANCE.getContinuousSample_Probability();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.ProbabilityMassFunctionImpl <em>Probability Mass Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbabilityMassFunctionImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getProbabilityMassFunction()
		 * @generated
		 */
		EClass PROBABILITY_MASS_FUNCTION = eINSTANCE.getProbabilityMassFunction();

		/**
		 * The meta object literal for the '<em><b>Samples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBABILITY_MASS_FUNCTION__SAMPLES = eINSTANCE.getProbabilityMassFunction_Samples();

		/**
		 * The meta object literal for the '<em><b>Ordered Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBABILITY_MASS_FUNCTION__ORDERED_DOMAIN = eINSTANCE.getProbabilityMassFunction_OrderedDomain();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.SampleImpl <em>Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.SampleImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getSample()
		 * @generated
		 */
		EClass SAMPLE = eINSTANCE.getSample();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE__VALUE = eINSTANCE.getSample_Value();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE__PROBABILITY = eINSTANCE.getSample_Probability();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.probfunction.impl.SamplePDFImpl <em>Sample PDF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.probfunction.impl.SamplePDFImpl
		 * @see de.uka.ipd.sdq.probfunction.impl.ProbfunctionPackageImpl#getSamplePDF()
		 * @generated
		 */
		EClass SAMPLE_PDF = eINSTANCE.getSamplePDF();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE_PDF__DISTANCE = eINSTANCE.getSamplePDF_Distance();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE_PDF__VALUES = eINSTANCE.getSamplePDF_Values();

	}

} //ProbfunctionPackage
