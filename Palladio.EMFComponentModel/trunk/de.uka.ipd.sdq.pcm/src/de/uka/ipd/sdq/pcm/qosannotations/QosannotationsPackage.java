/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

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
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsFactory
 * @model kind="package"
 * @generated
 */
public interface QosannotationsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qosannotations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/QoSAnnotations/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.qosannotations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QosannotationsPackage eINSTANCE = de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedTimeConsumptionImpl <em>Specified Time Consumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedTimeConsumptionImpl
	 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSpecifiedTimeConsumption()
	 * @generated
	 */
	int SPECIFIED_TIME_CONSUMPTION = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION__SPECIFICATION = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Specification Random Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION__SPECIFICATION_RANDOM_VARIABLE = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE;

	/**
	 * The feature id for the '<em><b>Signature Specified Time Consumption</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specified Time Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION_FEATURE_COUNT = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedTimeConsumption <em>Specified Time Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specified Time Consumption</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedTimeConsumption
	 * @generated
	 */
	EClass getSpecifiedTimeConsumption();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedTimeConsumption#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature Specified Time Consumption</em>'.
	 * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedTimeConsumption#getSignature_SpecifiedTimeConsumption()
	 * @see #getSpecifiedTimeConsumption()
	 * @generated
	 */
	EReference getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QosannotationsFactory getQosannotationsFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedTimeConsumptionImpl <em>Specified Time Consumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedTimeConsumptionImpl
		 * @see de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl#getSpecifiedTimeConsumption()
		 * @generated
		 */
		EClass SPECIFIED_TIME_CONSUMPTION = eINSTANCE.getSpecifiedTimeConsumption();

		/**
		 * The meta object literal for the '<em><b>Signature Specified Time Consumption</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = eINSTANCE.getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption();

	}

} //QosannotationsPackage
