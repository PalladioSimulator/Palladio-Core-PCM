/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalMemoryStorage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.impl.PresentationPackageImpl;

import de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIPackageImpl extends EPackageImpl implements UIPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationControllerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationPropertyPaneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storageNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localFileStorageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localMemoryStorageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteStorageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorFrameworkVersion1StorageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storageNodesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationViewEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UIPackageImpl() {
		super(eNS_URI, UIFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UIPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UIPackage init() {
		if (isInited) return (UIPackage)EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI);

		// Obtain or create and register package
		UIPackageImpl theUIPackage = (UIPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UIPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UIPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EmfmodelPackageImpl theEmfmodelPackage = (EmfmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EmfmodelPackage.eNS_URI) instanceof EmfmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EmfmodelPackage.eNS_URI) : EmfmodelPackage.eINSTANCE);
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI) instanceof PresentationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI) : PresentationPackage.eINSTANCE);

		// Create package meta-data objects
		theUIPackage.createPackageContents();
		theEmfmodelPackage.createPackageContents();
		thePresentationPackage.createPackageContents();

		// Initialize created meta-data
		theUIPackage.initializePackageContents();
		theEmfmodelPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUIPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UIPackage.eNS_URI, theUIPackage);
		return theUIPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationConfiguration() {
		return presentationConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationController() {
		return presentationControllerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_Configuration() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_View() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_PropertyPane() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_DataReader() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationPropertyPane() {
		return presentationPropertyPaneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationInput() {
		return presentationInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationInput_DataSourceDescription() {
		return (EReference)presentationInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationType() {
		return presentationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStorageNode() {
		return storageNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStorageNode_ExperimentGroup() {
		return (EReference)storageNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalFileStorage() {
		return localFileStorageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalFileStorage_FileSystemPath() {
		return (EAttribute)localFileStorageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalMemoryStorage() {
		return localMemoryStorageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteStorage() {
		return remoteStorageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemoteStorage_Url() {
		return (EAttribute)remoteStorageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorFrameworkVersion1Storage() {
		return sensorFrameworkVersion1StorageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensorFrameworkVersion1Storage_FileSystemPath() {
		return (EAttribute)sensorFrameworkVersion1StorageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensorFrameworkVersion1Storage_ImportSettings() {
		return (EAttribute)sensorFrameworkVersion1StorageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStorageNodes() {
		return storageNodesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStorageNodes_StoragenNode() {
		return (EReference)storageNodesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationView() {
		return presentationViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIFactory getUIFactory() {
		return (UIFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		presentationViewEClass = createEClass(PRESENTATION_VIEW);

		presentationTypeEClass = createEClass(PRESENTATION_TYPE);

		presentationConfigurationEClass = createEClass(PRESENTATION_CONFIGURATION);

		presentationControllerEClass = createEClass(PRESENTATION_CONTROLLER);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__CONFIGURATION);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__VIEW);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__PROPERTY_PANE);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__DATA_READER);

		presentationPropertyPaneEClass = createEClass(PRESENTATION_PROPERTY_PANE);

		presentationInputEClass = createEClass(PRESENTATION_INPUT);
		createEReference(presentationInputEClass, PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION);

		localFileStorageEClass = createEClass(LOCAL_FILE_STORAGE);
		createEAttribute(localFileStorageEClass, LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH);

		localMemoryStorageEClass = createEClass(LOCAL_MEMORY_STORAGE);

		remoteStorageEClass = createEClass(REMOTE_STORAGE);
		createEAttribute(remoteStorageEClass, REMOTE_STORAGE__URL);

		sensorFrameworkVersion1StorageEClass = createEClass(SENSOR_FRAMEWORK_VERSION1_STORAGE);
		createEAttribute(sensorFrameworkVersion1StorageEClass, SENSOR_FRAMEWORK_VERSION1_STORAGE__FILE_SYSTEM_PATH);
		createEAttribute(sensorFrameworkVersion1StorageEClass, SENSOR_FRAMEWORK_VERSION1_STORAGE__IMPORT_SETTINGS);

		storageNodesEClass = createEClass(STORAGE_NODES);
		createEReference(storageNodesEClass, STORAGE_NODES__STORAGEN_NODE);

		storageNodeEClass = createEClass(STORAGE_NODE);
		createEReference(storageNodeEClass, STORAGE_NODE__EXPERIMENT_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PresentationPackage thePresentationPackage = (PresentationPackage)EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		EmfmodelPackage theEmfmodelPackage = (EmfmodelPackage)EPackage.Registry.INSTANCE.getEPackage(EmfmodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		localFileStorageEClass.getESuperTypes().add(this.getStorageNode());
		localMemoryStorageEClass.getESuperTypes().add(this.getStorageNode());
		remoteStorageEClass.getESuperTypes().add(this.getStorageNode());
		sensorFrameworkVersion1StorageEClass.getESuperTypes().add(this.getStorageNode());

		// Initialize classes and features; add operations and parameters
		initEClass(presentationViewEClass, PresentationView.class, "PresentationView", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationTypeEClass, PresentationType.class, "PresentationType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationConfigurationEClass, PresentationConfiguration.class, "PresentationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationControllerEClass, PresentationController.class, "PresentationController", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentationController_Configuration(), this.getPresentationConfiguration(), null, "configuration", null, 1, 1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPresentationController_View(), this.getPresentationView(), null, "view", null, 1, 1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPresentationController_PropertyPane(), this.getPresentationPropertyPane(), null, "propertyPane", null, 0, -1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPresentationController_DataReader(), thePresentationPackage.getDataReader(), null, "dataReader", null, 0, -1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(presentationPropertyPaneEClass, PresentationPropertyPane.class, "PresentationPropertyPane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationInputEClass, PresentationInput.class, "PresentationInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentationInput_DataSourceDescription(), thePresentationPackage.getDataSource(), null, "dataSourceDescription", null, 0, -1, PresentationInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(localFileStorageEClass, LocalFileStorage.class, "LocalFileStorage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalFileStorage_FileSystemPath(), ecorePackage.getEString(), "fileSystemPath", null, 1, 1, LocalFileStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(localMemoryStorageEClass, LocalMemoryStorage.class, "LocalMemoryStorage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(remoteStorageEClass, RemoteStorage.class, "RemoteStorage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRemoteStorage_Url(), ecorePackage.getEString(), "url", null, 1, 1, RemoteStorage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorFrameworkVersion1StorageEClass, SensorFrameworkVersion1Storage.class, "SensorFrameworkVersion1Storage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensorFrameworkVersion1Storage_FileSystemPath(), ecorePackage.getEString(), "fileSystemPath", null, 1, 1, SensorFrameworkVersion1Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSensorFrameworkVersion1Storage_ImportSettings(), ecorePackage.getEString(), "importSettings", null, 1, 1, SensorFrameworkVersion1Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(storageNodesEClass, StorageNodes.class, "StorageNodes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStorageNodes_StoragenNode(), this.getStorageNode(), null, "storagenNode", null, 0, -1, StorageNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(storageNodeEClass, StorageNode.class, "StorageNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStorageNode_ExperimentGroup(), theEmfmodelPackage.getExperimentGroup(), theEmfmodelPackage.getExperimentGroup_StorageNode(), "experimentGroup", null, 0, -1, StorageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";			
		addAnnotation
		  (presentationConfigurationEClass, 
		   source, 
		   new String[] {
			 "persistable", null
		   });
	}

} //UIPackageImpl
