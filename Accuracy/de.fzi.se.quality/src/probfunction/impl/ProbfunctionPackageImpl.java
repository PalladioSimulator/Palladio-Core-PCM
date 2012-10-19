/**
 */
package probfunction.impl;

import de.fzi.se.quality.QualityPackage;

import de.fzi.se.quality.impl.QualityPackageImpl;

import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.parameters.impl.ParametersPackageImpl;

import de.fzi.se.quality.parameters.pcm.PCMPackage;

import de.fzi.se.quality.parameters.pcm.impl.PCMPackageImpl;

import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.impl.QualityAnnotationPackageImpl;

import de.uka.ipd.sdq.pcm.PcmPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import probfunction.BoxedPDF;
import probfunction.Complex;
import probfunction.ContinuousPDF;
import probfunction.ContinuousSample;
import probfunction.ExponentialDistribution;
import probfunction.GammaDistribution;
import probfunction.LognormalDistribution;
import probfunction.NormalDistribution;
import probfunction.ProbabilityDensityFunction;
import probfunction.ProbabilityFunction;
import probfunction.ProbabilityMassFunction;
import probfunction.ProbfunctionFactory;
import probfunction.ProbfunctionPackage;
import probfunction.Sample;
import probfunction.SamplePDF;

import types.TypesPackage;

import types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProbfunctionPackageImpl extends EPackageImpl implements ProbfunctionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boxedPDFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probabilityDensityFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousSampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probabilityMassFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass samplePDFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousPDFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exponentialDistributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normalDistributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lognormalDistributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gammaDistributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probabilityFunctionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see probfunction.ProbfunctionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProbfunctionPackageImpl() {
		super(eNS_URI, ProbfunctionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ProbfunctionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProbfunctionPackage init() {
		if (isInited) return (ProbfunctionPackage)EPackage.Registry.INSTANCE.getEPackage(ProbfunctionPackage.eNS_URI);

		// Obtain or create and register package
		ProbfunctionPackageImpl theProbfunctionPackage = (ProbfunctionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProbfunctionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProbfunctionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QualityPackageImpl theQualityPackage = (QualityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) instanceof QualityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityPackage.eNS_URI) : QualityPackage.eINSTANCE);
		QualityAnnotationPackageImpl theQualityAnnotationPackage = (QualityAnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) instanceof QualityAnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QualityAnnotationPackage.eNS_URI) : QualityAnnotationPackage.eINSTANCE);
		ParametersPackageImpl theParametersPackage = (ParametersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) instanceof ParametersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI) : ParametersPackage.eINSTANCE);
		PCMPackageImpl thePCMPackage = (PCMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) instanceof PCMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMPackage.eNS_URI) : PCMPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theProbfunctionPackage.createPackageContents();
		theQualityPackage.createPackageContents();
		theQualityAnnotationPackage.createPackageContents();
		theParametersPackage.createPackageContents();
		thePCMPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theProbfunctionPackage.initializePackageContents();
		theQualityPackage.initializePackageContents();
		theQualityAnnotationPackage.initializePackageContents();
		theParametersPackage.initializePackageContents();
		thePCMPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProbfunctionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProbfunctionPackage.eNS_URI, theProbfunctionPackage);
		return theProbfunctionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoxedPDF() {
		return boxedPDFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoxedPDF_Samples() {
		return (EReference)boxedPDFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbabilityDensityFunction() {
		return probabilityDensityFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousSample() {
		return continuousSampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinuousSample_Value() {
		return (EAttribute)continuousSampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinuousSample_Probability() {
		return (EAttribute)continuousSampleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbabilityMassFunction() {
		return probabilityMassFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbabilityMassFunction_Samples() {
		return (EReference)probabilityMassFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProbabilityMassFunction_OrderedDomain() {
		return (EAttribute)probabilityMassFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSample() {
		return sampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSample_Value() {
		return (EReference)sampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSample_Probability() {
		return (EAttribute)sampleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSamplePDF() {
		return samplePDFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSamplePDF_Distance() {
		return (EAttribute)samplePDFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSamplePDF_Values() {
		return (EReference)samplePDFEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplex() {
		return complexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComplex_Real() {
		return (EAttribute)complexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComplex_Imaginary() {
		return (EAttribute)complexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousPDF() {
		return continuousPDFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExponentialDistribution() {
		return exponentialDistributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExponentialDistribution_Rate() {
		return (EAttribute)exponentialDistributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormalDistribution() {
		return normalDistributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormalDistribution_Mu() {
		return (EAttribute)normalDistributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormalDistribution_Sigma() {
		return (EAttribute)normalDistributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLognormalDistribution() {
		return lognormalDistributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLognormalDistribution_Mu() {
		return (EAttribute)lognormalDistributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLognormalDistribution_Sigma() {
		return (EAttribute)lognormalDistributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGammaDistribution() {
		return gammaDistributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGammaDistribution_Alpha() {
		return (EAttribute)gammaDistributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGammaDistribution_Theta() {
		return (EAttribute)gammaDistributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbabilityFunction() {
		return probabilityFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbfunctionFactory getProbfunctionFactory() {
		return (ProbfunctionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		boxedPDFEClass = createEClass(BOXED_PDF);
		createEReference(boxedPDFEClass, BOXED_PDF__SAMPLES);

		probabilityDensityFunctionEClass = createEClass(PROBABILITY_DENSITY_FUNCTION);

		continuousSampleEClass = createEClass(CONTINUOUS_SAMPLE);
		createEAttribute(continuousSampleEClass, CONTINUOUS_SAMPLE__VALUE);
		createEAttribute(continuousSampleEClass, CONTINUOUS_SAMPLE__PROBABILITY);

		probabilityMassFunctionEClass = createEClass(PROBABILITY_MASS_FUNCTION);
		createEReference(probabilityMassFunctionEClass, PROBABILITY_MASS_FUNCTION__SAMPLES);
		createEAttribute(probabilityMassFunctionEClass, PROBABILITY_MASS_FUNCTION__ORDERED_DOMAIN);

		sampleEClass = createEClass(SAMPLE);
		createEReference(sampleEClass, SAMPLE__VALUE);
		createEAttribute(sampleEClass, SAMPLE__PROBABILITY);

		samplePDFEClass = createEClass(SAMPLE_PDF);
		createEAttribute(samplePDFEClass, SAMPLE_PDF__DISTANCE);
		createEReference(samplePDFEClass, SAMPLE_PDF__VALUES);

		complexEClass = createEClass(COMPLEX);
		createEAttribute(complexEClass, COMPLEX__REAL);
		createEAttribute(complexEClass, COMPLEX__IMAGINARY);

		continuousPDFEClass = createEClass(CONTINUOUS_PDF);

		exponentialDistributionEClass = createEClass(EXPONENTIAL_DISTRIBUTION);
		createEAttribute(exponentialDistributionEClass, EXPONENTIAL_DISTRIBUTION__RATE);

		normalDistributionEClass = createEClass(NORMAL_DISTRIBUTION);
		createEAttribute(normalDistributionEClass, NORMAL_DISTRIBUTION__MU);
		createEAttribute(normalDistributionEClass, NORMAL_DISTRIBUTION__SIGMA);

		lognormalDistributionEClass = createEClass(LOGNORMAL_DISTRIBUTION);
		createEAttribute(lognormalDistributionEClass, LOGNORMAL_DISTRIBUTION__MU);
		createEAttribute(lognormalDistributionEClass, LOGNORMAL_DISTRIBUTION__SIGMA);

		gammaDistributionEClass = createEClass(GAMMA_DISTRIBUTION);
		createEAttribute(gammaDistributionEClass, GAMMA_DISTRIBUTION__ALPHA);
		createEAttribute(gammaDistributionEClass, GAMMA_DISTRIBUTION__THETA);

		probabilityFunctionEClass = createEClass(PROBABILITY_FUNCTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UnitsPackage theUnitsPackage = (UnitsPackage)EPackage.Registry.INSTANCE.getEPackage(UnitsPackage.eNS_URI);

		// Create type parameters
		ETypeParameter sampleEClass_T = addETypeParameter(sampleEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		boxedPDFEClass.getESuperTypes().add(this.getProbabilityDensityFunction());
		probabilityDensityFunctionEClass.getESuperTypes().add(this.getProbabilityFunction());
		probabilityMassFunctionEClass.getESuperTypes().add(this.getProbabilityFunction());
		samplePDFEClass.getESuperTypes().add(this.getProbabilityDensityFunction());
		continuousPDFEClass.getESuperTypes().add(this.getProbabilityDensityFunction());
		exponentialDistributionEClass.getESuperTypes().add(this.getContinuousPDF());
		normalDistributionEClass.getESuperTypes().add(this.getContinuousPDF());
		lognormalDistributionEClass.getESuperTypes().add(this.getContinuousPDF());
		gammaDistributionEClass.getESuperTypes().add(this.getContinuousPDF());
		probabilityFunctionEClass.getESuperTypes().add(theUnitsPackage.getUnitCarryingElement());

		// Initialize classes and features; add operations and parameters
		initEClass(boxedPDFEClass, BoxedPDF.class, "BoxedPDF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoxedPDF_Samples(), this.getContinuousSample(), null, "samples", null, 0, -1, BoxedPDF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probabilityDensityFunctionEClass, ProbabilityDensityFunction.class, "ProbabilityDensityFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continuousSampleEClass, ContinuousSample.class, "ContinuousSample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinuousSample_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, ContinuousSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContinuousSample_Probability(), ecorePackage.getEDouble(), "probability", null, 0, 1, ContinuousSample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probabilityMassFunctionEClass, ProbabilityMassFunction.class, "ProbabilityMassFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProbabilityMassFunction_Samples(), this.getSample(), null, "samples", null, 0, -1, ProbabilityMassFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProbabilityMassFunction_OrderedDomain(), ecorePackage.getEBoolean(), "orderedDomain", null, 1, 1, ProbabilityMassFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sampleEClass, Sample.class, "Sample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(sampleEClass_T);
		initEReference(getSample_Value(), g1, null, "value", null, 1, 1, Sample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSample_Probability(), ecorePackage.getEDouble(), "probability", null, 0, 1, Sample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(samplePDFEClass, SamplePDF.class, "SamplePDF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSamplePDF_Distance(), ecorePackage.getEDouble(), "distance", null, 0, 1, SamplePDF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSamplePDF_Values(), this.getComplex(), null, "values", null, 0, -1, SamplePDF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(complexEClass, Complex.class, "Complex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComplex_Real(), ecorePackage.getEDouble(), "real", null, 1, 1, Complex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComplex_Imaginary(), ecorePackage.getEDouble(), "imaginary", null, 1, 1, Complex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(continuousPDFEClass, ContinuousPDF.class, "ContinuousPDF", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exponentialDistributionEClass, ExponentialDistribution.class, "ExponentialDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExponentialDistribution_Rate(), ecorePackage.getEDouble(), "rate", null, 1, 1, ExponentialDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(normalDistributionEClass, NormalDistribution.class, "NormalDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNormalDistribution_Mu(), ecorePackage.getEDouble(), "mu", null, 1, 1, NormalDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNormalDistribution_Sigma(), ecorePackage.getEDouble(), "sigma", null, 1, 1, NormalDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(lognormalDistributionEClass, LognormalDistribution.class, "LognormalDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLognormalDistribution_Mu(), ecorePackage.getEDouble(), "mu", null, 1, 1, LognormalDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLognormalDistribution_Sigma(), ecorePackage.getEDouble(), "sigma", null, 1, 1, LognormalDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(gammaDistributionEClass, GammaDistribution.class, "GammaDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGammaDistribution_Alpha(), ecorePackage.getEDouble(), "alpha", null, 1, 1, GammaDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGammaDistribution_Theta(), ecorePackage.getEDouble(), "theta", null, 1, 1, GammaDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probabilityFunctionEClass, ProbabilityFunction.class, "ProbabilityFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ProbfunctionPackageImpl
