/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.reliability;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

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
 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityFactory
 * @model kind="package"
 * @generated
 */
public interface ReliabilityPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "reliability";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/QoSAnnotations/Reliability/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReliabilityPackage eINSTANCE = de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.ReliabilityPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.SpecifiedFailureProbabilityImpl <em>Specified Failure Probability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.SpecifiedFailureProbabilityImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.ReliabilityPackageImpl#getSpecifiedFailureProbability()
	 * @generated
	 */
	int SPECIFIED_FAILURE_PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Signature Specified Qo SAnnation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_FAILURE_PROBABILITY__SIGNATURE_SPECIFIED_QO_SANNATION = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SIGNATURE_SPECIFIED_QO_SANNATION;

	/**
	 * The feature id for the '<em><b>Role Specified Qo SAnnotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_FAILURE_PROBABILITY__ROLE_SPECIFIED_QO_SANNOTATION = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__ROLE_SPECIFIED_QO_SANNOTATION;

	/**
	 * The feature id for the '<em><b>Specification Specified Execution Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_FAILURE_PROBABILITY__SPECIFICATION_SPECIFIED_EXECUTION_TIME = QosannotationsPackage.SPECIFIED_QO_SANNOTATION__SPECIFICATION_SPECIFIED_EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_FAILURE_PROBABILITY__FAILURE_PROBABILITY = QosannotationsPackage.SPECIFIED_QO_SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specified Failure Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_FAILURE_PROBABILITY_FEATURE_COUNT = QosannotationsPackage.SPECIFIED_QO_SANNOTATION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedFailureProbability <em>Specified Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specified Failure Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedFailureProbability
	 * @generated
	 */
	EClass getSpecifiedFailureProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedFailureProbability#getFailureProbability <em>Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.SpecifiedFailureProbability#getFailureProbability()
	 * @see #getSpecifiedFailureProbability()
	 * @generated
	 */
	EAttribute getSpecifiedFailureProbability_FailureProbability();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReliabilityFactory getReliabilityFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.SpecifiedFailureProbabilityImpl <em>Specified Failure Probability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.SpecifiedFailureProbabilityImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.ReliabilityPackageImpl#getSpecifiedFailureProbability()
		 * @generated
		 */
		EClass SPECIFIED_FAILURE_PROBABILITY = eINSTANCE.getSpecifiedFailureProbability();
		/**
		 * The meta object literal for the '<em><b>Failure Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIED_FAILURE_PROBABILITY__FAILURE_PROBABILITY = eINSTANCE.getSpecifiedFailureProbability_FailureProbability();

	}

} //ReliabilityPackage
