/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI;

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
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIFactory
 * @model kind="package"
 * @generated
 */
public interface UIPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "UI";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///EDP2/Presentation/UI.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EDP2.Presentation.UI";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UIPackage eINSTANCE = de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl <em>Presentation Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationConfiguration()
	 * @generated
	 */
	int PRESENTATION_CONFIGURATION = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl <em>Presentation Controller</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationController()
	 * @generated
	 */
	int PRESENTATION_CONTROLLER = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl <em>Presentation Property Pane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationPropertyPane()
	 * @generated
	 */
	int PRESENTATION_PROPERTY_PANE = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl <em>Presentation Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationInput()
	 * @generated
	 */
	int PRESENTATION_INPUT = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl <em>Presentation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationType()
	 * @generated
	 */
	int PRESENTATION_TYPE = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodeImpl <em>Storage Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getStorageNode()
	 * @generated
	 */
	int STORAGE_NODE = 11;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalFileStorageImpl <em>Local File Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalFileStorageImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getLocalFileStorage()
	 * @generated
	 */
	int LOCAL_FILE_STORAGE = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalMemoryStorageImpl <em>Local Memory Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalMemoryStorageImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getLocalMemoryStorage()
	 * @generated
	 */
	int LOCAL_MEMORY_STORAGE = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.RemoteStorageImpl <em>Remote Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.RemoteStorageImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getRemoteStorage()
	 * @generated
	 */
	int REMOTE_STORAGE = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.SensorFrameworkVersion1StorageImpl <em>Sensor Framework Version1 Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.SensorFrameworkVersion1StorageImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getSensorFrameworkVersion1Storage()
	 * @generated
	 */
	int SENSOR_FRAMEWORK_VERSION1_STORAGE = 9;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodesImpl <em>Storage Nodes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodesImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getStorageNodes()
	 * @generated
	 */
	int STORAGE_NODES = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl <em>Presentation View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationView()
	 * @generated
	 */
	int PRESENTATION_VIEW = 0;

	/**
	 * The number of structural features of the '<em>Presentation View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_VIEW_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Presentation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Presentation Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__VIEW = 1;

	/**
	 * The feature id for the '<em><b>Property Pane</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__PROPERTY_PANE = 2;

	/**
	 * The feature id for the '<em><b>Data Reader</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__DATA_READER = 3;

	/**
	 * The number of structural features of the '<em>Presentation Controller</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER_FEATURE_COUNT = 4;

	/**
	 * The number of structural features of the '<em>Presentation Property Pane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PROPERTY_PANE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Data Source Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Presentation Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_INPUT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_NODE__EXPERIMENT_GROUP = 0;

	/**
	 * The number of structural features of the '<em>Storage Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_NODE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_STORAGE__EXPERIMENT_GROUP = STORAGE_NODE__EXPERIMENT_GROUP;

	/**
	 * The feature id for the '<em><b>File System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH = STORAGE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local File Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_STORAGE_FEATURE_COUNT = STORAGE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MEMORY_STORAGE__EXPERIMENT_GROUP = STORAGE_NODE__EXPERIMENT_GROUP;

	/**
	 * The number of structural features of the '<em>Local Memory Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_MEMORY_STORAGE_FEATURE_COUNT = STORAGE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_STORAGE__EXPERIMENT_GROUP = STORAGE_NODE__EXPERIMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_STORAGE__URL = STORAGE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remote Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_STORAGE_FEATURE_COUNT = STORAGE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Experiment Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_VERSION1_STORAGE__EXPERIMENT_GROUP = STORAGE_NODE__EXPERIMENT_GROUP;

	/**
	 * The feature id for the '<em><b>File System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH = STORAGE_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import Settings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS = STORAGE_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sensor Framework Version1 Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FRAMEWORK_VERSION1_STORAGE_FEATURE_COUNT = STORAGE_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Storagen Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_NODES__STORAGEN_NODE = 0;

	/**
	 * The number of structural features of the '<em>Storage Nodes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_NODES_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration <em>Presentation Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Configuration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration
	 * @generated
	 */
	EClass getPresentationConfiguration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController <em>Presentation Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Controller</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController
	 * @generated
	 */
	EClass getPresentationController();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getConfiguration()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getView()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_View();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getPropertyPane <em>Property Pane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Pane</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getPropertyPane()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_PropertyPane();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getDataReader <em>Data Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Reader</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getDataReader()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_DataReader();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane <em>Presentation Property Pane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Property Pane</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane
	 * @generated
	 */
	EClass getPresentationPropertyPane();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput <em>Presentation Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Input</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput
	 * @generated
	 */
	EClass getPresentationInput();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput#getDataSourceDescription <em>Data Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Source Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput#getDataSourceDescription()
	 * @see #getPresentationInput()
	 * @generated
	 */
	EReference getPresentationInput_DataSourceDescription();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType <em>Presentation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType
	 * @generated
	 */
	EClass getPresentationType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode <em>Storage Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Node</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode
	 * @generated
	 */
	EClass getStorageNode();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode#getExperimentGroup <em>Experiment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Experiment Group</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode#getExperimentGroup()
	 * @see #getStorageNode()
	 * @generated
	 */
	EReference getStorageNode_ExperimentGroup();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage <em>Local File Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local File Storage</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage
	 * @generated
	 */
	EClass getLocalFileStorage();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage#getFileSystemPath <em>File System Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File System Path</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage#getFileSystemPath()
	 * @see #getLocalFileStorage()
	 * @generated
	 */
	EAttribute getLocalFileStorage_FileSystemPath();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalMemoryStorage <em>Local Memory Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Memory Storage</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalMemoryStorage
	 * @generated
	 */
	EClass getLocalMemoryStorage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage <em>Remote Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Storage</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage
	 * @generated
	 */
	EClass getRemoteStorage();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage#getUrl()
	 * @see #getRemoteStorage()
	 * @generated
	 */
	EAttribute getRemoteStorage_Url();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage <em>Sensor Framework Version1 Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Framework Version1 Storage</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage
	 * @generated
	 */
	EClass getSensorFrameworkVersion1Storage();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getFileSystemPath <em>File System Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File System Path</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getFileSystemPath()
	 * @see #getSensorFrameworkVersion1Storage()
	 * @generated
	 */
	EAttribute getSensorFrameworkVersion1Storage_FileSystemPath();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getImportSettings <em>Import Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Settings</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage#getImportSettings()
	 * @see #getSensorFrameworkVersion1Storage()
	 * @generated
	 */
	EAttribute getSensorFrameworkVersion1Storage_ImportSettings();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes <em>Storage Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Nodes</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes
	 * @generated
	 */
	EClass getStorageNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes#getStoragenNode <em>Storagen Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Storagen Node</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes#getStoragenNode()
	 * @see #getStorageNodes()
	 * @generated
	 */
	EReference getStorageNodes_StoragenNode();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView <em>Presentation View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView
	 * @generated
	 */
	EClass getPresentationView();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UIFactory getUIFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl <em>Presentation Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationConfiguration()
		 * @generated
		 */
		EClass PRESENTATION_CONFIGURATION = eINSTANCE.getPresentationConfiguration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl <em>Presentation Controller</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationController()
		 * @generated
		 */
		EClass PRESENTATION_CONTROLLER = eINSTANCE.getPresentationController();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__CONFIGURATION = eINSTANCE.getPresentationController_Configuration();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__VIEW = eINSTANCE.getPresentationController_View();

		/**
		 * The meta object literal for the '<em><b>Property Pane</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__PROPERTY_PANE = eINSTANCE.getPresentationController_PropertyPane();

		/**
		 * The meta object literal for the '<em><b>Data Reader</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__DATA_READER = eINSTANCE.getPresentationController_DataReader();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl <em>Presentation Property Pane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationPropertyPane()
		 * @generated
		 */
		EClass PRESENTATION_PROPERTY_PANE = eINSTANCE.getPresentationPropertyPane();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl <em>Presentation Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationInput()
		 * @generated
		 */
		EClass PRESENTATION_INPUT = eINSTANCE.getPresentationInput();

		/**
		 * The meta object literal for the '<em><b>Data Source Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION = eINSTANCE.getPresentationInput_DataSourceDescription();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl <em>Presentation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationType()
		 * @generated
		 */
		EClass PRESENTATION_TYPE = eINSTANCE.getPresentationType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodeImpl <em>Storage Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getStorageNode()
		 * @generated
		 */
		EClass STORAGE_NODE = eINSTANCE.getStorageNode();

		/**
		 * The meta object literal for the '<em><b>Experiment Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_NODE__EXPERIMENT_GROUP = eINSTANCE.getStorageNode_ExperimentGroup();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalFileStorageImpl <em>Local File Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalFileStorageImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getLocalFileStorage()
		 * @generated
		 */
		EClass LOCAL_FILE_STORAGE = eINSTANCE.getLocalFileStorage();

		/**
		 * The meta object literal for the '<em><b>File System Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH = eINSTANCE.getLocalFileStorage_FileSystemPath();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalMemoryStorageImpl <em>Local Memory Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalMemoryStorageImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getLocalMemoryStorage()
		 * @generated
		 */
		EClass LOCAL_MEMORY_STORAGE = eINSTANCE.getLocalMemoryStorage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.RemoteStorageImpl <em>Remote Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.RemoteStorageImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getRemoteStorage()
		 * @generated
		 */
		EClass REMOTE_STORAGE = eINSTANCE.getRemoteStorage();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_STORAGE__URL = eINSTANCE.getRemoteStorage_Url();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.SensorFrameworkVersion1StorageImpl <em>Sensor Framework Version1 Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.SensorFrameworkVersion1StorageImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getSensorFrameworkVersion1Storage()
		 * @generated
		 */
		EClass SENSOR_FRAMEWORK_VERSION1_STORAGE = eINSTANCE.getSensorFrameworkVersion1Storage();

		/**
		 * The meta object literal for the '<em><b>File System Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH = eINSTANCE.getSensorFrameworkVersion1Storage_FileSystemPath();

		/**
		 * The meta object literal for the '<em><b>Import Settings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS = eINSTANCE.getSensorFrameworkVersion1Storage_ImportSettings();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodesImpl <em>Storage Nodes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.StorageNodesImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getStorageNodes()
		 * @generated
		 */
		EClass STORAGE_NODES = eINSTANCE.getStorageNodes();

		/**
		 * The meta object literal for the '<em><b>Storagen Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_NODES__STORAGEN_NODE = eINSTANCE.getStorageNodes_StoragenNode();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl <em>Presentation View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationView()
		 * @generated
		 */
		EClass PRESENTATION_VIEW = eINSTANCE.getPresentationView();

	}

} //UIPackage
