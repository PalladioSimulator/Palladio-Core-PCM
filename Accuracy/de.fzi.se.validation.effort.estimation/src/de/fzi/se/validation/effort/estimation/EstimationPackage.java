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
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT__TARGET_ID = 1;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT__ALPHA = 2;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT__TARGET_URI = 3;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR = 4;

	/**
	 * The number of structural features of the '<em>Effort Estimation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_ESTIMATION_RESULT_FEATURE_COUNT = 5;


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
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetId <em>Target Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Id</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetId()
	 * @see #getEffortEstimationResult()
	 * @generated
	 */
	EAttribute getEffortEstimationResult_TargetId();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult#getAlpha()
	 * @see #getEffortEstimationResult()
	 * @generated
	 */
	EAttribute getEffortEstimationResult_Alpha();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetUri <em>Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Uri</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetUri()
	 * @see #getEffortEstimationResult()
	 * @generated
	 */
	EAttribute getEffortEstimationResult_TargetUri();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Demanding Behaviour</em>'.
	 * @see de.fzi.se.validation.effort.estimation.EffortEstimationResult#getResourceDemandingBehaviour()
	 * @see #getEffortEstimationResult()
	 * @generated
	 */
	EReference getEffortEstimationResult_ResourceDemandingBehaviour();

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
		 * The meta object literal for the '<em><b>Target Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT_ESTIMATION_RESULT__TARGET_ID = eINSTANCE.getEffortEstimationResult_TargetId();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT_ESTIMATION_RESULT__ALPHA = eINSTANCE.getEffortEstimationResult_Alpha();

		/**
		 * The meta object literal for the '<em><b>Target Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT_ESTIMATION_RESULT__TARGET_URI = eINSTANCE.getEffortEstimationResult_TargetUri();

		/**
		 * The meta object literal for the '<em><b>Resource Demanding Behaviour</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR = eINSTANCE.getEffortEstimationResult_ResourceDemandingBehaviour();

	}

} //EstimationPackage
