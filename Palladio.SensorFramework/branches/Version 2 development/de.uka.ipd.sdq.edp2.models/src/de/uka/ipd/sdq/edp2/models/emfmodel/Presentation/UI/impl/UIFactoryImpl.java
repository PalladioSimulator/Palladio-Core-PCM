/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIFactoryImpl extends EFactoryImpl implements UIFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UIFactory init() {
		try {
			UIFactory theUIFactory = (UIFactory)EPackage.Registry.INSTANCE.getEFactory("http:///EDP2/Presentation/UI.ecore"); 
			if (theUIFactory != null) {
				return theUIFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UIFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UIPackage.PRESENTATION_CONFIGURATION: return createPresentationConfiguration();
			case UIPackage.PRESENTATION_PROPERTY_PANE: return createPresentationPropertyPane();
			case UIPackage.PRESENTATION_INPUT: return createPresentationInput();
			case UIPackage.LOCAL_FILE_STORAGE: return createLocalFileStorage();
			case UIPackage.LOCAL_MEMORY_STORAGE: return createLocalMemoryStorage();
			case UIPackage.REMOTE_STORAGE: return createRemoteStorage();
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE: return createSensorFrameworkVersion1Storage();
			case UIPackage.STORAGE_NODES: return createStorageNodes();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationConfiguration createPresentationConfiguration() {
		PresentationConfigurationImpl presentationConfiguration = new PresentationConfigurationImpl();
		return presentationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationPropertyPane createPresentationPropertyPane() {
		PresentationPropertyPaneImpl presentationPropertyPane = new PresentationPropertyPaneImpl();
		return presentationPropertyPane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationInput createPresentationInput() {
		PresentationInputImpl presentationInput = new PresentationInputImpl();
		return presentationInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalFileStorage createLocalFileStorage() {
		LocalFileStorageImpl localFileStorage = new LocalFileStorageImpl();
		return localFileStorage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalMemoryStorage createLocalMemoryStorage() {
		LocalMemoryStorageImpl localMemoryStorage = new LocalMemoryStorageImpl();
		return localMemoryStorage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoteStorage createRemoteStorage() {
		RemoteStorageImpl remoteStorage = new RemoteStorageImpl();
		return remoteStorage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFrameworkVersion1Storage createSensorFrameworkVersion1Storage() {
		SensorFrameworkVersion1StorageImpl sensorFrameworkVersion1Storage = new SensorFrameworkVersion1StorageImpl();
		return sensorFrameworkVersion1Storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageNodes createStorageNodes() {
		StorageNodesImpl storageNodes = new StorageNodesImpl();
		return storageNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIPackage getUIPackage() {
		return (UIPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UIPackage getPackage() {
		return UIPackage.eINSTANCE;
	}

} //UIFactoryImpl
