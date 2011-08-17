/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.impl;

import de.fzi.se.validation.testbased.*;

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
public class TestbasedFactoryImpl extends EFactoryImpl implements TestbasedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestbasedFactory init() {
		try {
			TestbasedFactory theTestbasedFactory = (TestbasedFactory)EPackage.Registry.INSTANCE.getEFactory("http://fzi.de/PalladioComponentModel/Validation/TestBased/0.2"); 
			if (theTestbasedFactory != null) {
				return theTestbasedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestbasedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbasedFactoryImpl() {
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
			case TestbasedPackage.TB_VALIDATION_QUALITY: return createTBValidationQuality();
			case TestbasedPackage.EQUIDISTANT_PARTITIONS_RANDOM: return createEquidistantPartitionsRandom();
			case TestbasedPackage.NUMBER_TESTCASES: return createNumberTestcases();
			case TestbasedPackage.NUMBER_GENERATION_RUNS: return createNumberGenerationRuns();
			case TestbasedPackage.NO_ISIA: return createNoISIA();
			case TestbasedPackage.REUSE_INSTANCE_ISIA: return createReuseInstanceISIA();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBValidationQuality createTBValidationQuality() {
		TBValidationQualityImpl tbValidationQuality = new TBValidationQualityImpl();
		return tbValidationQuality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquidistantPartitionsRandom createEquidistantPartitionsRandom() {
		EquidistantPartitionsRandomImpl equidistantPartitionsRandom = new EquidistantPartitionsRandomImpl();
		return equidistantPartitionsRandom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberTestcases createNumberTestcases() {
		NumberTestcasesImpl numberTestcases = new NumberTestcasesImpl();
		return numberTestcases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberGenerationRuns createNumberGenerationRuns() {
		NumberGenerationRunsImpl numberGenerationRuns = new NumberGenerationRunsImpl();
		return numberGenerationRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoISIA createNoISIA() {
		NoISIAImpl noISIA = new NoISIAImpl();
		return noISIA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReuseInstanceISIA createReuseInstanceISIA() {
		ReuseInstanceISIAImpl reuseInstanceISIA = new ReuseInstanceISIAImpl();
		return reuseInstanceISIA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbasedPackage getTestbasedPackage() {
		return (TestbasedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestbasedPackage getPackage() {
		return TestbasedPackage.eINSTANCE;
	}

} //TestbasedFactoryImpl
