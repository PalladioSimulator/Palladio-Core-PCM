/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.fzi.se.validation.effort.estimation.EstimationFactory
 * @model kind="package"
 * @generated
 */
public interface EstimationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "estimation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.fzi.de/ValidationEffortEstimation/0.5";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "estimation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EstimationPackage eINSTANCE = de.fzi.se.validation.effort.estimation.impl.EstimationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl <em>Effort Estimation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl
	 * @see de.fzi.se.validation.effort.estimation.impl.EstimationPackageImpl#getEffortEstimationResult()
	 * @generated
	 */
	int EFFORT_ESTIMATION_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Number Testcases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES = 0;

	/**
	 * The feature id for the '<em><b>Intermediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT__INTERMEDIATE = 1;

	/**
	 * The number of structural features of the '<em>Effort Estimation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult <em>Effort Estimation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effort Estimation Result</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult
	 * @generated
	 */
	EClass getEffortEstimationResult();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getNumberTestcases <em>Number Testcases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Testcases</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult#getNumberTestcases()
	 * @see #getEffortEstimationResult()
	 * @generated
	 */
	EAttribute getEffortEstimationResult_NumberTestcases();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getIntermediate <em>Intermediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intermediate</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult#getIntermediate()
	 * @see #getEffortEstimationResult()
	 * @generated
	 */
	EAttribute getEffortEstimationResult_Intermediate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EstimationFactory getEstimationFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl <em>Effort Estimation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl
		 * @see de.fzi.se.validation.effort.estimation.impl.EstimationPackageImpl#getEffortEstimationResult()
		 * @generated
		 */
		EClass EFFORT_ESTIMATION_RESULT = eINSTANCE.getEffortEstimationResult();

		/**
		 * The meta object literal for the '<em><b>Number Testcases</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES = eINSTANCE.getEffortEstimationResult_NumberTestcases();

		/**
		 * The meta object literal for the '<em><b>Intermediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT_ESTIMATION_RESULT__INTERMEDIATE = eINSTANCE.getEffortEstimationResult_Intermediate();

	}

} //EstimationPackage
