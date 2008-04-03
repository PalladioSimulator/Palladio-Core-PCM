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
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl <em>Experiment Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl
	 * @see de.uka.ipd.sdq.capra.impl.CapraPackageImpl#getExperimentSeries()
	 * @generated
	 */
	int EXPERIMENT_SERIES = 0;

	/**
	 * The feature id for the '<em><b>Experiment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES__EXPERIMENT = 0;

	/**
	 * The feature id for the '<em><b>System Configuration File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE = 1;

	/**
	 * The feature id for the '<em><b>Scheduler Library File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE = 2;

	/**
	 * The feature id for the '<em><b>Output Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES__OUTPUT_DIRECTORY = 3;

	/**
	 * The feature id for the '<em><b>Summary File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES__SUMMARY_FILE = 4;

	/**
	 * The feature id for the '<em><b>Capra File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES__CAPRA_FILE = 5;

	/**
	 * The number of structural features of the '<em>Experiment Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPERIMENT_SERIES_FEATURE_COUNT = 6;

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.ExperimentSeries <em>Experiment Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Experiment Series</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries
	 * @generated
	 */
	EClass getExperimentSeries();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getExperiment <em>Experiment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Experiment</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries#getExperiment()
	 * @see #getExperimentSeries()
	 * @generated
	 */
	EReference getExperimentSeries_Experiment();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSystemConfigurationFile <em>System Configuration File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Configuration File</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries#getSystemConfigurationFile()
	 * @see #getExperimentSeries()
	 * @generated
	 */
	EAttribute getExperimentSeries_SystemConfigurationFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSchedulerLibraryFile <em>Scheduler Library File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduler Library File</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries#getSchedulerLibraryFile()
	 * @see #getExperimentSeries()
	 * @generated
	 */
	EAttribute getExperimentSeries_SchedulerLibraryFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getOutputDirectory <em>Output Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Directory</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries#getOutputDirectory()
	 * @see #getExperimentSeries()
	 * @generated
	 */
	EAttribute getExperimentSeries_OutputDirectory();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSummaryFile <em>Summary File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Summary File</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries#getSummaryFile()
	 * @see #getExperimentSeries()
	 * @generated
	 */
	EAttribute getExperimentSeries_SummaryFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getCapraFile <em>Capra File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capra File</em>'.
	 * @see de.uka.ipd.sdq.capra.ExperimentSeries#getCapraFile()
	 * @see #getExperimentSeries()
	 * @generated
	 */
	EAttribute getExperimentSeries_CapraFile();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl <em>Experiment Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl
		 * @see de.uka.ipd.sdq.capra.impl.CapraPackageImpl#getExperimentSeries()
		 * @generated
		 */
		EClass EXPERIMENT_SERIES = eINSTANCE.getExperimentSeries();

		/**
		 * The meta object literal for the '<em><b>Experiment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPERIMENT_SERIES__EXPERIMENT = eINSTANCE.getExperimentSeries_Experiment();

		/**
		 * The meta object literal for the '<em><b>System Configuration File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE = eINSTANCE.getExperimentSeries_SystemConfigurationFile();

		/**
		 * The meta object literal for the '<em><b>Scheduler Library File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE = eINSTANCE.getExperimentSeries_SchedulerLibraryFile();

		/**
		 * The meta object literal for the '<em><b>Output Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_SERIES__OUTPUT_DIRECTORY = eINSTANCE.getExperimentSeries_OutputDirectory();

		/**
		 * The meta object literal for the '<em><b>Summary File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_SERIES__SUMMARY_FILE = eINSTANCE.getExperimentSeries_SummaryFile();

		/**
		 * The meta object literal for the '<em><b>Capra File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPERIMENT_SERIES__CAPRA_FILE = eINSTANCE.getExperimentSeries_CapraFile();

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
