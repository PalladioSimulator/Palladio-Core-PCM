/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction.impl;

import de.uka.ipd.sdq.probfunction.*;

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
public class probfunctionFactoryImpl extends EFactoryImpl implements probfunctionFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright by SDQ U Karlsruhe (TH) 2006";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static probfunctionFactory init() {
		try {
			probfunctionFactory theprobfunctionFactory = (probfunctionFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ProbFunction/1.0"); 
			if (theprobfunctionFactory != null) {
				return theprobfunctionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new probfunctionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probfunctionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case probfunctionPackage.BOXED_PDF: return createBoxedPDF();
			case probfunctionPackage.PROBABILITY_DENSITY_FUNCTION: return createProbabilityDensityFunction();
			case probfunctionPackage.UNIT: return createUnit();
			case probfunctionPackage.CONTINUOUS_SAMPLE: return createContinuousSample();
			case probfunctionPackage.PROBABILITY_MASS_FUNCTION: return createProbabilityMassFunction();
			case probfunctionPackage.SAMPLE: return createSample();
			case probfunctionPackage.SAMPLE_PDF: return createSamplePDF();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoxedPDF createBoxedPDF() {
		BoxedPDFImpl boxedPDF = new BoxedPDFImpl();
		return boxedPDF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityDensityFunction createProbabilityDensityFunction() {
		ProbabilityDensityFunctionImpl probabilityDensityFunction = new ProbabilityDensityFunctionImpl();
		return probabilityDensityFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinuousSample createContinuousSample() {
		ContinuousSampleImpl continuousSample = new ContinuousSampleImpl();
		return continuousSample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityMassFunction createProbabilityMassFunction() {
		ProbabilityMassFunctionImpl probabilityMassFunction = new ProbabilityMassFunctionImpl();
		return probabilityMassFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sample createSample() {
		SampleImpl sample = new SampleImpl();
		return sample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SamplePDF createSamplePDF() {
		SamplePDFImpl samplePDF = new SamplePDFImpl();
		return samplePDF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probfunctionPackage getprobfunctionPackage() {
		return (probfunctionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static probfunctionPackage getPackage() {
		return probfunctionPackage.eINSTANCE;
	}

} //probfunctionFactoryImpl
