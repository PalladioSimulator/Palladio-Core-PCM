/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra;

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
 * @see de.uka.ipd.sdq.capra.CapraFactory
 * @model kind="package"
 * @generated
 */
public interface CapraPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "capra";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "capra";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CapraPackage eINSTANCE = de.uka.ipd.sdq.capra.impl.CapraPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.impl.ReplicatedProcessImpl <em>Replicated Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.impl.ReplicatedProcessImpl
	 * @see de.uka.ipd.sdq.capra.impl.CapraPackageImpl#getReplicatedProcess()
	 * @generated
	 */
	int REPLICATED_PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLICATED_PROCESS__NUM_REPLICAS = 0;

	/**
	 * The feature id for the '<em><b>Processvariable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLICATED_PROCESS__PROCESSVARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Replicated Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLICATED_PROCESS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.impl.CapraModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.impl.CapraModelImpl
	 * @see de.uka.ipd.sdq.capra.impl.CapraPackageImpl#getCapraModel()
	 * @generated
	 */
	int CAPRA_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRA_MODEL__PROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRA_MODEL__RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRA_MODEL__IDENTIFIERS = 2;

	/**
	 * The feature id for the '<em><b>Sensors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRA_MODEL__SENSORS = 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRA_MODEL_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.ReplicatedProcess <em>Replicated Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replicated Process</em>'.
	 * @see de.uka.ipd.sdq.capra.ReplicatedProcess
	 * @generated
	 */
	EClass getReplicatedProcess();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.ReplicatedProcess#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.capra.ReplicatedProcess#getNumReplicas()
	 * @see #getReplicatedProcess()
	 * @generated
	 */
	EAttribute getReplicatedProcess_NumReplicas();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.ReplicatedProcess#getProcessvariable <em>Processvariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Processvariable</em>'.
	 * @see de.uka.ipd.sdq.capra.ReplicatedProcess#getProcessvariable()
	 * @see #getReplicatedProcess()
	 * @generated
	 */
	EReference getReplicatedProcess_Processvariable();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.CapraModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see de.uka.ipd.sdq.capra.CapraModel
	 * @generated
	 */
	EClass getCapraModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.CapraModel#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see de.uka.ipd.sdq.capra.CapraModel#getProcesses()
	 * @see #getCapraModel()
	 * @generated
	 */
	EReference getCapraModel_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.CapraModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.uka.ipd.sdq.capra.CapraModel#getResources()
	 * @see #getCapraModel()
	 * @generated
	 */
	EReference getCapraModel_Resources();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.CapraModel#getIdentifiers <em>Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifiers</em>'.
	 * @see de.uka.ipd.sdq.capra.CapraModel#getIdentifiers()
	 * @see #getCapraModel()
	 * @generated
	 */
	EReference getCapraModel_Identifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.CapraModel#getSensors <em>Sensors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sensors</em>'.
	 * @see de.uka.ipd.sdq.capra.CapraModel#getSensors()
	 * @see #getCapraModel()
	 * @generated
	 */
	EReference getCapraModel_Sensors();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CapraFactory getCapraFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.impl.ReplicatedProcessImpl <em>Replicated Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.impl.ReplicatedProcessImpl
		 * @see de.uka.ipd.sdq.capra.impl.CapraPackageImpl#getReplicatedProcess()
		 * @generated
		 */
		EClass REPLICATED_PROCESS = eINSTANCE.getReplicatedProcess();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLICATED_PROCESS__NUM_REPLICAS = eINSTANCE.getReplicatedProcess_NumReplicas();

		/**
		 * The meta object literal for the '<em><b>Processvariable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLICATED_PROCESS__PROCESSVARIABLE = eINSTANCE.getReplicatedProcess_Processvariable();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.impl.CapraModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.impl.CapraModelImpl
		 * @see de.uka.ipd.sdq.capra.impl.CapraPackageImpl#getCapraModel()
		 * @generated
		 */
		EClass CAPRA_MODEL = eINSTANCE.getCapraModel();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPRA_MODEL__PROCESSES = eINSTANCE.getCapraModel_Processes();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPRA_MODEL__RESOURCES = eINSTANCE.getCapraModel_Resources();

		/**
		 * The meta object literal for the '<em><b>Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPRA_MODEL__IDENTIFIERS = eINSTANCE.getCapraModel_Identifiers();

		/**
		 * The meta object literal for the '<em><b>Sensors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPRA_MODEL__SENSORS = eINSTANCE.getCapraModel_Sensors();

	}

} //CapraPackage
