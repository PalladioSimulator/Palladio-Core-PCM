/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;

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
 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimucomFactory
 * @model kind="package"
 * @generated
 */
public interface SimucomPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simucom";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ExperimentAutomation/Experiments/SimuCom/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ExperimentAutomation.Experiments.SimuCom";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimucomPackage eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimucomPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimuComConfigurationImpl <em>Simu Com Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimuComConfigurationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimucomPackageImpl#getSimuComConfiguration()
	 * @generated
	 */
	int SIMU_COM_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__NAME = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Persistence Framework</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__PERSISTENCE_FRAMEWORK = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK;

	/**
	 * The feature id for the '<em><b>Stop Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__STOP_CONDITIONS = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Random Number Generator Seed</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED;

	/**
	 * The feature id for the '<em><b>Simulate Linking Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__SIMULATE_LINKING_RESOURCES = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES;

	/**
	 * The feature id for the '<em><b>Simulate Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__SIMULATE_FAILURES = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES;

	/**
	 * The feature id for the '<em><b>Probe Spec Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION__PROBE_SPEC_CONFIGURATION = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION;

	/**
	 * The number of structural features of the '<em>Simu Com Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMU_COM_CONFIGURATION_FEATURE_COUNT = AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComConfiguration <em>Simu Com Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simu Com Configuration</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComConfiguration
	 * @generated
	 */
	EClass getSimuComConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimucomFactory getSimucomFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimuComConfigurationImpl <em>Simu Com Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimuComConfigurationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimucomPackageImpl#getSimuComConfiguration()
		 * @generated
		 */
		EClass SIMU_COM_CONFIGURATION = eINSTANCE.getSimuComConfiguration();

	}

} //SimucomPackage
