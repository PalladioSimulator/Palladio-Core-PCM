/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.util;

import de.fzi.se.quality.QualityStatement;

import de.fzi.se.validation.testbased.*;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.testbased.TestbasedPackage
 * @generated
 */
public class TestbasedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestbasedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbasedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TestbasedPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestbasedSwitch<Adapter> modelSwitch =
		new TestbasedSwitch<Adapter>() {
			@Override
			public Adapter caseTBValidationQuality(TBValidationQuality object) {
				return createTBValidationQualityAdapter();
			}
			@Override
			public Adapter caseTestcaseExecutionStopStrategy(TestcaseExecutionStopStrategy object) {
				return createTestcaseExecutionStopStrategyAdapter();
			}
			@Override
			public Adapter caseTestcaseGenerationStrategy(TestcaseGenerationStrategy object) {
				return createTestcaseGenerationStrategyAdapter();
			}
			@Override
			public Adapter caseInternalStateInfluenceAnalysisStrategy(InternalStateInfluenceAnalysisStrategy object) {
				return createInternalStateInfluenceAnalysisStrategyAdapter();
			}
			@Override
			public Adapter caseEquidistantPartitionsRandom(EquidistantPartitionsRandom object) {
				return createEquidistantPartitionsRandomAdapter();
			}
			@Override
			public Adapter caseNumberTestcases(NumberTestcases object) {
				return createNumberTestcasesAdapter();
			}
			@Override
			public Adapter caseNumberGenerationRuns(NumberGenerationRuns object) {
				return createNumberGenerationRunsAdapter();
			}
			@Override
			public Adapter caseNoISIA(NoISIA object) {
				return createNoISIAAdapter();
			}
			@Override
			public Adapter caseReuseInstanceISIA(ReuseInstanceISIA object) {
				return createReuseInstanceISIAAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseQualityStatement(QualityStatement object) {
				return createQualityStatementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.TBValidationQuality <em>TB Validation Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.TBValidationQuality
	 * @generated
	 */
	public Adapter createTBValidationQualityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy <em>Testcase Execution Stop Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy
	 * @generated
	 */
	public Adapter createTestcaseExecutionStopStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.TestcaseGenerationStrategy <em>Testcase Generation Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.TestcaseGenerationStrategy
	 * @generated
	 */
	public Adapter createTestcaseGenerationStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy
	 * @generated
	 */
	public Adapter createInternalStateInfluenceAnalysisStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.EquidistantPartitionsRandom <em>Equidistant Partitions Random</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.EquidistantPartitionsRandom
	 * @generated
	 */
	public Adapter createEquidistantPartitionsRandomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.NumberTestcases <em>Number Testcases</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.NumberTestcases
	 * @generated
	 */
	public Adapter createNumberTestcasesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.NumberGenerationRuns <em>Number Generation Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.NumberGenerationRuns
	 * @generated
	 */
	public Adapter createNumberGenerationRunsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.NoISIA <em>No ISIA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.NoISIA
	 * @generated
	 */
	public Adapter createNoISIAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.validation.testbased.ReuseInstanceISIA <em>Reuse Instance ISIA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.validation.testbased.ReuseInstanceISIA
	 * @generated
	 */
	public Adapter createReuseInstanceISIAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.quality.QualityStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.quality.QualityStatement
	 * @generated
	 */
	public Adapter createQualityStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TestbasedAdapterFactory
