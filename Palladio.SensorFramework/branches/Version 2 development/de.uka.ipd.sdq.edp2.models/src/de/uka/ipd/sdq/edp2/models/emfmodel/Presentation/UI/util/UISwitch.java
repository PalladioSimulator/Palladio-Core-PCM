/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.util;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage
 * @generated
 */
public class UISwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UIPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UISwitch() {
		if (modelPackage == null) {
			modelPackage = UIPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UIPackage.PRESENTATION_VIEW: {
				PresentationView presentationView = (PresentationView)theEObject;
				T result = casePresentationView(presentationView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.PRESENTATION_TYPE: {
				PresentationType presentationType = (PresentationType)theEObject;
				T result = casePresentationType(presentationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.PRESENTATION_CONFIGURATION: {
				PresentationConfiguration presentationConfiguration = (PresentationConfiguration)theEObject;
				T result = casePresentationConfiguration(presentationConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.PRESENTATION_CONTROLLER: {
				PresentationController presentationController = (PresentationController)theEObject;
				T result = casePresentationController(presentationController);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.PRESENTATION_PROPERTY_PANE: {
				PresentationPropertyPane presentationPropertyPane = (PresentationPropertyPane)theEObject;
				T result = casePresentationPropertyPane(presentationPropertyPane);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.PRESENTATION_INPUT: {
				PresentationInput presentationInput = (PresentationInput)theEObject;
				T result = casePresentationInput(presentationInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.LOCAL_FILE_STORAGE: {
				LocalFileStorage localFileStorage = (LocalFileStorage)theEObject;
				T result = caseLocalFileStorage(localFileStorage);
				if (result == null) result = caseStorageNode(localFileStorage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.LOCAL_MEMORY_STORAGE: {
				LocalMemoryStorage localMemoryStorage = (LocalMemoryStorage)theEObject;
				T result = caseLocalMemoryStorage(localMemoryStorage);
				if (result == null) result = caseStorageNode(localMemoryStorage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.REMOTE_STORAGE: {
				RemoteStorage remoteStorage = (RemoteStorage)theEObject;
				T result = caseRemoteStorage(remoteStorage);
				if (result == null) result = caseStorageNode(remoteStorage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.SENSOR_FRAMEWORK_VERSION1_STORAGE: {
				SensorFrameworkVersion1Storage sensorFrameworkVersion1Storage = (SensorFrameworkVersion1Storage)theEObject;
				T result = caseSensorFrameworkVersion1Storage(sensorFrameworkVersion1Storage);
				if (result == null) result = caseStorageNode(sensorFrameworkVersion1Storage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.STORAGE_NODES: {
				StorageNodes storageNodes = (StorageNodes)theEObject;
				T result = caseStorageNodes(storageNodes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UIPackage.STORAGE_NODE: {
				StorageNode storageNode = (StorageNode)theEObject;
				T result = caseStorageNode(storageNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationConfiguration(PresentationConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Controller</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Controller</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationController(PresentationController object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Property Pane</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Property Pane</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationPropertyPane(PresentationPropertyPane object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationInput(PresentationInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationType(PresentationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storage Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storage Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStorageNode(StorageNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local File Storage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local File Storage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalFileStorage(LocalFileStorage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Memory Storage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Memory Storage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalMemoryStorage(LocalMemoryStorage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote Storage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote Storage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoteStorage(RemoteStorage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Framework Version1 Storage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Framework Version1 Storage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorFrameworkVersion1Storage(SensorFrameworkVersion1Storage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storage Nodes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storage Nodes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStorageNodes(StorageNodes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePresentationView(PresentationView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //UISwitch
