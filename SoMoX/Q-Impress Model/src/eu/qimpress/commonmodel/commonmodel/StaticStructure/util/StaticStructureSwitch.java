/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.util;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Message;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Port;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Type;

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
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage
 * @generated
 */
public class StaticStructureSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StaticStructurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticStructureSwitch() {
		if (modelPackage == null) {
			modelPackage = StaticStructurePackage.eINSTANCE;
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
			case StaticStructurePackage.COMPOSITE_STRUCTURE: {
				CompositeStructure compositeStructure = (CompositeStructure)theEObject;
				T result = caseCompositeStructure(compositeStructure);
				if (result == null) result = caseComponentType(compositeStructure);
				if (result == null) result = caseNamedEntity(compositeStructure);
				if (result == null) result = caseFirstClassEntity(compositeStructure);
				if (result == null) result = caseEntity(compositeStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				T result = caseComponentType(componentType);
				if (result == null) result = caseNamedEntity(componentType);
				if (result == null) result = caseFirstClassEntity(componentType);
				if (result == null) result = caseEntity(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.NAMED_ENTITY: {
				NamedEntity namedEntity = (NamedEntity)theEObject;
				T result = caseNamedEntity(namedEntity);
				if (result == null) result = caseEntity(namedEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.ENTITY: {
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseNamedEntity(port);
				if (result == null) result = caseEntity(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseNamedEntity(operation);
				if (result == null) result = caseEntity(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.MESSAGE: {
				Message message = (Message)theEObject;
				T result = caseMessage(message);
				if (result == null) result = caseNamedEntity(message);
				if (result == null) result = caseEntity(message);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseNamedEntity(type);
				if (result == null) result = caseFirstClassEntity(type);
				if (result == null) result = caseEntity(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.EXCEPTION: {
				eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception exception = (eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception)theEObject;
				T result = caseException(exception);
				if (result == null) result = caseNamedEntity(exception);
				if (result == null) result = caseEntity(exception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.SUBCOMPONENT_INSTANCE: {
				SubcomponentInstance subcomponentInstance = (SubcomponentInstance)theEObject;
				T result = caseSubcomponentInstance(subcomponentInstance);
				if (result == null) result = caseEntity(subcomponentInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseEntity(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.END_POINT: {
				EndPoint endPoint = (EndPoint)theEObject;
				T result = caseEndPoint(endPoint);
				if (result == null) result = caseEntity(endPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL: {
				ServiceArchitectureModel serviceArchitectureModel = (ServiceArchitectureModel)theEObject;
				T result = caseServiceArchitectureModel(serviceArchitectureModel);
				if (result == null) result = caseCompositeStructure(serviceArchitectureModel);
				if (result == null) result = caseComponentType(serviceArchitectureModel);
				if (result == null) result = caseNamedEntity(serviceArchitectureModel);
				if (result == null) result = caseFirstClassEntity(serviceArchitectureModel);
				if (result == null) result = caseEntity(serviceArchitectureModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				T result = caseInterface(interface_);
				if (result == null) result = caseNamedEntity(interface_);
				if (result == null) result = caseFirstClassEntity(interface_);
				if (result == null) result = caseEntity(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT: {
				SubcomponentEndpoint subcomponentEndpoint = (SubcomponentEndpoint)theEObject;
				T result = caseSubcomponentEndpoint(subcomponentEndpoint);
				if (result == null) result = caseEndPoint(subcomponentEndpoint);
				if (result == null) result = caseEntity(subcomponentEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.REPOSITORY: {
				Repository repository = (Repository)theEObject;
				T result = caseRepository(repository);
				if (result == null) result = caseNamedEntity(repository);
				if (result == null) result = caseEntity(repository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.COMPONENT_ENDPOINT: {
				ComponentEndpoint componentEndpoint = (ComponentEndpoint)theEObject;
				T result = caseComponentEndpoint(componentEndpoint);
				if (result == null) result = caseEndPoint(componentEndpoint);
				if (result == null) result = caseEntity(componentEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.PRIMITIVE_DATA_TYPE: {
				PrimitiveDataType primitiveDataType = (PrimitiveDataType)theEObject;
				T result = casePrimitiveDataType(primitiveDataType);
				if (result == null) result = caseType(primitiveDataType);
				if (result == null) result = caseNamedEntity(primitiveDataType);
				if (result == null) result = caseFirstClassEntity(primitiveDataType);
				if (result == null) result = caseEntity(primitiveDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.COMPLEX_DATA_TYPE: {
				ComplexDataType complexDataType = (ComplexDataType)theEObject;
				T result = caseComplexDataType(complexDataType);
				if (result == null) result = caseType(complexDataType);
				if (result == null) result = caseNamedEntity(complexDataType);
				if (result == null) result = caseFirstClassEntity(complexDataType);
				if (result == null) result = caseEntity(complexDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.INNER_ELEMENT: {
				InnerElement innerElement = (InnerElement)theEObject;
				T result = caseInnerElement(innerElement);
				if (result == null) result = caseNamedEntity(innerElement);
				if (result == null) result = caseEntity(innerElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.COMPOSITE_COMPONENT: {
				CompositeComponent compositeComponent = (CompositeComponent)theEObject;
				T result = caseCompositeComponent(compositeComponent);
				if (result == null) result = caseCompositeStructure(compositeComponent);
				if (result == null) result = caseComponentType(compositeComponent);
				if (result == null) result = caseNamedEntity(compositeComponent);
				if (result == null) result = caseFirstClassEntity(compositeComponent);
				if (result == null) result = caseEntity(compositeComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.PRIMITIVE_COMPONENT: {
				PrimitiveComponent primitiveComponent = (PrimitiveComponent)theEObject;
				T result = casePrimitiveComponent(primitiveComponent);
				if (result == null) result = caseComponentType(primitiveComponent);
				if (result == null) result = caseNamedEntity(primitiveComponent);
				if (result == null) result = caseFirstClassEntity(primitiveComponent);
				if (result == null) result = caseEntity(primitiveComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.EVENT_PORT: {
				EventPort eventPort = (EventPort)theEObject;
				T result = caseEventPort(eventPort);
				if (result == null) result = casePort(eventPort);
				if (result == null) result = caseNamedEntity(eventPort);
				if (result == null) result = caseEntity(eventPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.INTERFACE_PORT: {
				InterfacePort interfacePort = (InterfacePort)theEObject;
				T result = caseInterfacePort(interfacePort);
				if (result == null) result = casePort(interfacePort);
				if (result == null) result = caseNamedEntity(interfacePort);
				if (result == null) result = caseEntity(interfacePort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.COLLECTION_DATA_TYPE: {
				CollectionDataType collectionDataType = (CollectionDataType)theEObject;
				T result = caseCollectionDataType(collectionDataType);
				if (result == null) result = caseType(collectionDataType);
				if (result == null) result = caseNamedEntity(collectionDataType);
				if (result == null) result = caseFirstClassEntity(collectionDataType);
				if (result == null) result = caseEntity(collectionDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StaticStructurePackage.FIRST_CLASS_ENTITY: {
				FirstClassEntity firstClassEntity = (FirstClassEntity)theEObject;
				T result = caseFirstClassEntity(firstClassEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeStructure(CompositeStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentType(ComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedEntity(NamedEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessage(Message object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseException(eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subcomponent Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subcomponent Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubcomponentInstance(SubcomponentInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndPoint(EndPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Architecture Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Architecture Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceArchitectureModel(ServiceArchitectureModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subcomponent Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subcomponent Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubcomponentEndpoint(SubcomponentEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepository(Repository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentEndpoint(ComponentEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveDataType(PrimitiveDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexDataType(ComplexDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inner Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inner Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInnerElement(InnerElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeComponent(CompositeComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveComponent(PrimitiveComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventPort(EventPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfacePort(InterfacePort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionDataType(CollectionDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>First Class Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>First Class Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFirstClassEntity(FirstClassEntity object) {
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

} //StaticStructureSwitch
