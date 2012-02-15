/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.spt;

import de.fzi.se.validation.effort.estimation.EstimationPackage;

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
 * <!-- begin-model-doc -->
 * <p>
 *     Validation effort estimation model for structured path testing (SPT).
 * </p>
 * <!-- end-model-doc -->
 * @see de.fzi.se.validation.effort.estimation.spt.SPTFactory
 * @model kind="package"
 * @generated
 */
public interface SPTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "spt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.fzi.de/ValidationEffortEstimation/SPT/0.5";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SPTPackage eINSTANCE = de.fzi.se.validation.effort.estimation.spt.impl.SPTPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.effort.estimation.spt.impl.SPTEffortEstimationResultImpl <em>Effort Estimation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.effort.estimation.spt.impl.SPTEffortEstimationResultImpl
	 * @see de.fzi.se.validation.effort.estimation.spt.impl.SPTPackageImpl#getSPTEffortEstimationResult()
	 * @generated
	 */
	int SPT_EFFORT_ESTIMATION_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Number Testcases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES = EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES;

	/**
	 * The feature id for the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT__TARGET_ID = EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_ID;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT__ALPHA = EstimationPackage.EFFORT_ESTIMATION_RESULT__ALPHA;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT__TARGET_URI = EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_URI;

	/**
	 * The feature id for the '<em><b>Resource Demanding Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR = EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT__N = EstimationPackage.EFFORT_ESTIMATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Effort Estimation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPT_EFFORT_ESTIMATION_RESULT_FEATURE_COUNT = EstimationPackage.EFFORT_ESTIMATION_RESULT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult <em>Effort Estimation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effort Estimation Result</em>'.
	 * @see de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult
	 * @generated
	 */
	EClass getSPTEffortEstimationResult();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult#getN <em>N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N</em>'.
	 * @see de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult#getN()
	 * @see #getSPTEffortEstimationResult()
	 * @generated
	 */
	EAttribute getSPTEffortEstimationResult_N();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SPTFactory getSPTFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.validation.effort.estimation.spt.impl.SPTEffortEstimationResultImpl <em>Effort Estimation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.effort.estimation.spt.impl.SPTEffortEstimationResultImpl
		 * @see de.fzi.se.validation.effort.estimation.spt.impl.SPTPackageImpl#getSPTEffortEstimationResult()
		 * @generated
		 */
		EClass SPT_EFFORT_ESTIMATION_RESULT = eINSTANCE.getSPTEffortEstimationResult();

		/**
		 * The meta object literal for the '<em><b>N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPT_EFFORT_ESTIMATION_RESULT__N = eINSTANCE.getSPTEffortEstimationResult_N();

	}

} //SPTPackage
