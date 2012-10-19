/**
 */
package probfunction;

import de.uka.ipd.sdq.units.UnitsPackage;

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
 * @see probfunction.ProbfunctionFactory
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
	String eNS_URI = "http:///probfunction.ecore";

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
	ProbfunctionPackage eINSTANCE = probfunction.impl.ProbfunctionPackageImpl.init();

	/**
	 * The meta object id for the '{@link probfunction.impl.ProbabilityFunctionImpl <em>Probability Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ProbabilityFunctionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getProbabilityFunction()
	 * @generated
	 */
	int PROBABILITY_FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION__UNIT = UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION__UNIT_SPECIFICATION = UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Probability Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FUNCTION_FEATURE_COUNT = UnitsPackage.UNIT_CARRYING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link probfunction.impl.ProbabilityDensityFunctionImpl <em>Probability Density Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ProbabilityDensityFunctionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getProbabilityDensityFunction()
	 * @generated
	 */
	int PROBABILITY_DENSITY_FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_DENSITY_FUNCTION__UNIT = PROBABILITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_DENSITY_FUNCTION__UNIT_SPECIFICATION = PROBABILITY_FUNCTION__UNIT_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Probability Density Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT = PROBABILITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link probfunction.impl.BoxedPDFImpl <em>Boxed PDF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.BoxedPDFImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getBoxedPDF()
	 * @generated
	 */
	int BOXED_PDF = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXED_PDF__UNIT = PROBABILITY_DENSITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXED_PDF__UNIT_SPECIFICATION = PROBABILITY_DENSITY_FUNCTION__UNIT_SPECIFICATION;

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
	 * The meta object id for the '{@link probfunction.impl.ContinuousSampleImpl <em>Continuous Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ContinuousSampleImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getContinuousSample()
	 * @generated
	 */
	int CONTINUOUS_SAMPLE = 2;

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
	 * The meta object id for the '{@link probfunction.impl.ProbabilityMassFunctionImpl <em>Probability Mass Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ProbabilityMassFunctionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getProbabilityMassFunction()
	 * @generated
	 */
	int PROBABILITY_MASS_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_MASS_FUNCTION__UNIT = PROBABILITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_MASS_FUNCTION__UNIT_SPECIFICATION = PROBABILITY_FUNCTION__UNIT_SPECIFICATION;

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
	 * The meta object id for the '{@link probfunction.impl.SampleImpl <em>Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.SampleImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getSample()
	 * @generated
	 */
	int SAMPLE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
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
	 * The meta object id for the '{@link probfunction.impl.SamplePDFImpl <em>Sample PDF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.SamplePDFImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getSamplePDF()
	 * @generated
	 */
	int SAMPLE_PDF = 5;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF__UNIT = PROBABILITY_DENSITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF__UNIT_SPECIFICATION = PROBABILITY_DENSITY_FUNCTION__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_PDF__DISTANCE = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
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
	 * The meta object id for the '{@link probfunction.impl.ComplexImpl <em>Complex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ComplexImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getComplex()
	 * @generated
	 */
	int COMPLEX = 6;

	/**
	 * The feature id for the '<em><b>Real</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__REAL = 0;

	/**
	 * The feature id for the '<em><b>Imaginary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__IMAGINARY = 1;

	/**
	 * The number of structural features of the '<em>Complex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link probfunction.impl.ContinuousPDFImpl <em>Continuous PDF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ContinuousPDFImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getContinuousPDF()
	 * @generated
	 */
	int CONTINUOUS_PDF = 7;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PDF__UNIT = PROBABILITY_DENSITY_FUNCTION__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PDF__UNIT_SPECIFICATION = PROBABILITY_DENSITY_FUNCTION__UNIT_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Continuous PDF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PDF_FEATURE_COUNT = PROBABILITY_DENSITY_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link probfunction.impl.ExponentialDistributionImpl <em>Exponential Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.ExponentialDistributionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getExponentialDistribution()
	 * @generated
	 */
	int EXPONENTIAL_DISTRIBUTION = 8;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_DISTRIBUTION__UNIT = CONTINUOUS_PDF__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_DISTRIBUTION__UNIT_SPECIFICATION = CONTINUOUS_PDF__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_DISTRIBUTION__RATE = CONTINUOUS_PDF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exponential Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPONENTIAL_DISTRIBUTION_FEATURE_COUNT = CONTINUOUS_PDF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link probfunction.impl.NormalDistributionImpl <em>Normal Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.NormalDistributionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getNormalDistribution()
	 * @generated
	 */
	int NORMAL_DISTRIBUTION = 9;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_DISTRIBUTION__UNIT = CONTINUOUS_PDF__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_DISTRIBUTION__UNIT_SPECIFICATION = CONTINUOUS_PDF__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Mu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_DISTRIBUTION__MU = CONTINUOUS_PDF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sigma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_DISTRIBUTION__SIGMA = CONTINUOUS_PDF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Normal Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_DISTRIBUTION_FEATURE_COUNT = CONTINUOUS_PDF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link probfunction.impl.LognormalDistributionImpl <em>Lognormal Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.LognormalDistributionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getLognormalDistribution()
	 * @generated
	 */
	int LOGNORMAL_DISTRIBUTION = 10;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGNORMAL_DISTRIBUTION__UNIT = CONTINUOUS_PDF__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGNORMAL_DISTRIBUTION__UNIT_SPECIFICATION = CONTINUOUS_PDF__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Mu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGNORMAL_DISTRIBUTION__MU = CONTINUOUS_PDF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sigma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGNORMAL_DISTRIBUTION__SIGMA = CONTINUOUS_PDF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lognormal Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGNORMAL_DISTRIBUTION_FEATURE_COUNT = CONTINUOUS_PDF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link probfunction.impl.GammaDistributionImpl <em>Gamma Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see probfunction.impl.GammaDistributionImpl
	 * @see probfunction.impl.ProbfunctionPackageImpl#getGammaDistribution()
	 * @generated
	 */
	int GAMMA_DISTRIBUTION = 11;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_DISTRIBUTION__UNIT = CONTINUOUS_PDF__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_DISTRIBUTION__UNIT_SPECIFICATION = CONTINUOUS_PDF__UNIT_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_DISTRIBUTION__ALPHA = CONTINUOUS_PDF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Theta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_DISTRIBUTION__THETA = CONTINUOUS_PDF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gamma Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAMMA_DISTRIBUTION_FEATURE_COUNT = CONTINUOUS_PDF_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link probfunction.BoxedPDF <em>Boxed PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boxed PDF</em>'.
	 * @see probfunction.BoxedPDF
	 * @generated
	 */
	EClass getBoxedPDF();

	/**
	 * Returns the meta object for the containment reference list '{@link probfunction.BoxedPDF#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Samples</em>'.
	 * @see probfunction.BoxedPDF#getSamples()
	 * @see #getBoxedPDF()
	 * @generated
	 */
	EReference getBoxedPDF_Samples();

	/**
	 * Returns the meta object for class '{@link probfunction.ProbabilityDensityFunction <em>Probability Density Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Density Function</em>'.
	 * @see probfunction.ProbabilityDensityFunction
	 * @generated
	 */
	EClass getProbabilityDensityFunction();

	/**
	 * Returns the meta object for class '{@link probfunction.ContinuousSample <em>Continuous Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous Sample</em>'.
	 * @see probfunction.ContinuousSample
	 * @generated
	 */
	EClass getContinuousSample();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.ContinuousSample#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see probfunction.ContinuousSample#getValue()
	 * @see #getContinuousSample()
	 * @generated
	 */
	EAttribute getContinuousSample_Value();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.ContinuousSample#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see probfunction.ContinuousSample#getProbability()
	 * @see #getContinuousSample()
	 * @generated
	 */
	EAttribute getContinuousSample_Probability();

	/**
	 * Returns the meta object for class '{@link probfunction.ProbabilityMassFunction <em>Probability Mass Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Mass Function</em>'.
	 * @see probfunction.ProbabilityMassFunction
	 * @generated
	 */
	EClass getProbabilityMassFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link probfunction.ProbabilityMassFunction#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Samples</em>'.
	 * @see probfunction.ProbabilityMassFunction#getSamples()
	 * @see #getProbabilityMassFunction()
	 * @generated
	 */
	EReference getProbabilityMassFunction_Samples();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.ProbabilityMassFunction#isOrderedDomain <em>Ordered Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordered Domain</em>'.
	 * @see probfunction.ProbabilityMassFunction#isOrderedDomain()
	 * @see #getProbabilityMassFunction()
	 * @generated
	 */
	EAttribute getProbabilityMassFunction_OrderedDomain();

	/**
	 * Returns the meta object for class '{@link probfunction.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample</em>'.
	 * @see probfunction.Sample
	 * @generated
	 */
	EClass getSample();

	/**
	 * Returns the meta object for the reference '{@link probfunction.Sample#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see probfunction.Sample#getValue()
	 * @see #getSample()
	 * @generated
	 */
	EReference getSample_Value();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.Sample#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see probfunction.Sample#getProbability()
	 * @see #getSample()
	 * @generated
	 */
	EAttribute getSample_Probability();

	/**
	 * Returns the meta object for class '{@link probfunction.SamplePDF <em>Sample PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample PDF</em>'.
	 * @see probfunction.SamplePDF
	 * @generated
	 */
	EClass getSamplePDF();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.SamplePDF#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see probfunction.SamplePDF#getDistance()
	 * @see #getSamplePDF()
	 * @generated
	 */
	EAttribute getSamplePDF_Distance();

	/**
	 * Returns the meta object for the containment reference list '{@link probfunction.SamplePDF#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see probfunction.SamplePDF#getValues()
	 * @see #getSamplePDF()
	 * @generated
	 */
	EReference getSamplePDF_Values();

	/**
	 * Returns the meta object for class '{@link probfunction.Complex <em>Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex</em>'.
	 * @see probfunction.Complex
	 * @generated
	 */
	EClass getComplex();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.Complex#getReal <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real</em>'.
	 * @see probfunction.Complex#getReal()
	 * @see #getComplex()
	 * @generated
	 */
	EAttribute getComplex_Real();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.Complex#getImaginary <em>Imaginary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imaginary</em>'.
	 * @see probfunction.Complex#getImaginary()
	 * @see #getComplex()
	 * @generated
	 */
	EAttribute getComplex_Imaginary();

	/**
	 * Returns the meta object for class '{@link probfunction.ContinuousPDF <em>Continuous PDF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous PDF</em>'.
	 * @see probfunction.ContinuousPDF
	 * @generated
	 */
	EClass getContinuousPDF();

	/**
	 * Returns the meta object for class '{@link probfunction.ExponentialDistribution <em>Exponential Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exponential Distribution</em>'.
	 * @see probfunction.ExponentialDistribution
	 * @generated
	 */
	EClass getExponentialDistribution();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.ExponentialDistribution#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see probfunction.ExponentialDistribution#getRate()
	 * @see #getExponentialDistribution()
	 * @generated
	 */
	EAttribute getExponentialDistribution_Rate();

	/**
	 * Returns the meta object for class '{@link probfunction.NormalDistribution <em>Normal Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Distribution</em>'.
	 * @see probfunction.NormalDistribution
	 * @generated
	 */
	EClass getNormalDistribution();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.NormalDistribution#getMu <em>Mu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mu</em>'.
	 * @see probfunction.NormalDistribution#getMu()
	 * @see #getNormalDistribution()
	 * @generated
	 */
	EAttribute getNormalDistribution_Mu();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.NormalDistribution#getSigma <em>Sigma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sigma</em>'.
	 * @see probfunction.NormalDistribution#getSigma()
	 * @see #getNormalDistribution()
	 * @generated
	 */
	EAttribute getNormalDistribution_Sigma();

	/**
	 * Returns the meta object for class '{@link probfunction.LognormalDistribution <em>Lognormal Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lognormal Distribution</em>'.
	 * @see probfunction.LognormalDistribution
	 * @generated
	 */
	EClass getLognormalDistribution();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.LognormalDistribution#getMu <em>Mu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mu</em>'.
	 * @see probfunction.LognormalDistribution#getMu()
	 * @see #getLognormalDistribution()
	 * @generated
	 */
	EAttribute getLognormalDistribution_Mu();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.LognormalDistribution#getSigma <em>Sigma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sigma</em>'.
	 * @see probfunction.LognormalDistribution#getSigma()
	 * @see #getLognormalDistribution()
	 * @generated
	 */
	EAttribute getLognormalDistribution_Sigma();

	/**
	 * Returns the meta object for class '{@link probfunction.GammaDistribution <em>Gamma Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gamma Distribution</em>'.
	 * @see probfunction.GammaDistribution
	 * @generated
	 */
	EClass getGammaDistribution();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.GammaDistribution#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha</em>'.
	 * @see probfunction.GammaDistribution#getAlpha()
	 * @see #getGammaDistribution()
	 * @generated
	 */
	EAttribute getGammaDistribution_Alpha();

	/**
	 * Returns the meta object for the attribute '{@link probfunction.GammaDistribution#getTheta <em>Theta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theta</em>'.
	 * @see probfunction.GammaDistribution#getTheta()
	 * @see #getGammaDistribution()
	 * @generated
	 */
	EAttribute getGammaDistribution_Theta();

	/**
	 * Returns the meta object for class '{@link probfunction.ProbabilityFunction <em>Probability Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probability Function</em>'.
	 * @see probfunction.ProbabilityFunction
	 * @generated
	 */
	EClass getProbabilityFunction();

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
		 * The meta object literal for the '{@link probfunction.impl.BoxedPDFImpl <em>Boxed PDF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.BoxedPDFImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getBoxedPDF()
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
		 * The meta object literal for the '{@link probfunction.impl.ProbabilityDensityFunctionImpl <em>Probability Density Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ProbabilityDensityFunctionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getProbabilityDensityFunction()
		 * @generated
		 */
		EClass PROBABILITY_DENSITY_FUNCTION = eINSTANCE.getProbabilityDensityFunction();

		/**
		 * The meta object literal for the '{@link probfunction.impl.ContinuousSampleImpl <em>Continuous Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ContinuousSampleImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getContinuousSample()
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
		 * The meta object literal for the '{@link probfunction.impl.ProbabilityMassFunctionImpl <em>Probability Mass Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ProbabilityMassFunctionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getProbabilityMassFunction()
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
		 * The meta object literal for the '{@link probfunction.impl.SampleImpl <em>Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.SampleImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getSample()
		 * @generated
		 */
		EClass SAMPLE = eINSTANCE.getSample();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLE__VALUE = eINSTANCE.getSample_Value();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE__PROBABILITY = eINSTANCE.getSample_Probability();

		/**
		 * The meta object literal for the '{@link probfunction.impl.SamplePDFImpl <em>Sample PDF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.SamplePDFImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getSamplePDF()
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
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLE_PDF__VALUES = eINSTANCE.getSamplePDF_Values();

		/**
		 * The meta object literal for the '{@link probfunction.impl.ComplexImpl <em>Complex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ComplexImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getComplex()
		 * @generated
		 */
		EClass COMPLEX = eINSTANCE.getComplex();

		/**
		 * The meta object literal for the '<em><b>Real</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX__REAL = eINSTANCE.getComplex_Real();

		/**
		 * The meta object literal for the '<em><b>Imaginary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX__IMAGINARY = eINSTANCE.getComplex_Imaginary();

		/**
		 * The meta object literal for the '{@link probfunction.impl.ContinuousPDFImpl <em>Continuous PDF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ContinuousPDFImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getContinuousPDF()
		 * @generated
		 */
		EClass CONTINUOUS_PDF = eINSTANCE.getContinuousPDF();

		/**
		 * The meta object literal for the '{@link probfunction.impl.ExponentialDistributionImpl <em>Exponential Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ExponentialDistributionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getExponentialDistribution()
		 * @generated
		 */
		EClass EXPONENTIAL_DISTRIBUTION = eINSTANCE.getExponentialDistribution();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPONENTIAL_DISTRIBUTION__RATE = eINSTANCE.getExponentialDistribution_Rate();

		/**
		 * The meta object literal for the '{@link probfunction.impl.NormalDistributionImpl <em>Normal Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.NormalDistributionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getNormalDistribution()
		 * @generated
		 */
		EClass NORMAL_DISTRIBUTION = eINSTANCE.getNormalDistribution();

		/**
		 * The meta object literal for the '<em><b>Mu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NORMAL_DISTRIBUTION__MU = eINSTANCE.getNormalDistribution_Mu();

		/**
		 * The meta object literal for the '<em><b>Sigma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NORMAL_DISTRIBUTION__SIGMA = eINSTANCE.getNormalDistribution_Sigma();

		/**
		 * The meta object literal for the '{@link probfunction.impl.LognormalDistributionImpl <em>Lognormal Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.LognormalDistributionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getLognormalDistribution()
		 * @generated
		 */
		EClass LOGNORMAL_DISTRIBUTION = eINSTANCE.getLognormalDistribution();

		/**
		 * The meta object literal for the '<em><b>Mu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGNORMAL_DISTRIBUTION__MU = eINSTANCE.getLognormalDistribution_Mu();

		/**
		 * The meta object literal for the '<em><b>Sigma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGNORMAL_DISTRIBUTION__SIGMA = eINSTANCE.getLognormalDistribution_Sigma();

		/**
		 * The meta object literal for the '{@link probfunction.impl.GammaDistributionImpl <em>Gamma Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.GammaDistributionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getGammaDistribution()
		 * @generated
		 */
		EClass GAMMA_DISTRIBUTION = eINSTANCE.getGammaDistribution();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAMMA_DISTRIBUTION__ALPHA = eINSTANCE.getGammaDistribution_Alpha();

		/**
		 * The meta object literal for the '<em><b>Theta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAMMA_DISTRIBUTION__THETA = eINSTANCE.getGammaDistribution_Theta();

		/**
		 * The meta object literal for the '{@link probfunction.impl.ProbabilityFunctionImpl <em>Probability Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see probfunction.impl.ProbabilityFunctionImpl
		 * @see probfunction.impl.ProbfunctionPackageImpl#getProbabilityFunction()
		 * @generated
		 */
		EClass PROBABILITY_FUNCTION = eINSTANCE.getProbabilityFunction();

	}

} //ProbfunctionPackage
