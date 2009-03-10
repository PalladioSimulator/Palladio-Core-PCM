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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage
 * @generated
 */
public class StaticStructureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StaticStructurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticStructureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StaticStructurePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticStructureSwitch<Adapter> modelSwitch =
		new StaticStructureSwitch<Adapter>() {
			@Override
			public Adapter caseCompositeStructure(CompositeStructure object) {
				return createCompositeStructureAdapter();
			}
			@Override
			public Adapter caseComponentType(ComponentType object) {
				return createComponentTypeAdapter();
			}
			@Override
			public Adapter caseNamedEntity(NamedEntity object) {
				return createNamedEntityAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object) {
				return createEntityAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseMessage(Message object) {
				return createMessageAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseException(eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception object) {
				return createExceptionAdapter();
			}
			@Override
			public Adapter caseSubcomponentInstance(SubcomponentInstance object) {
				return createSubcomponentInstanceAdapter();
			}
			@Override
			public Adapter caseConnector(Connector object) {
				return createConnectorAdapter();
			}
			@Override
			public Adapter caseEndPoint(EndPoint object) {
				return createEndPointAdapter();
			}
			@Override
			public Adapter caseServiceArchitectureModel(ServiceArchitectureModel object) {
				return createServiceArchitectureModelAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object) {
				return createInterfaceAdapter();
			}
			@Override
			public Adapter caseSubcomponentEndpoint(SubcomponentEndpoint object) {
				return createSubcomponentEndpointAdapter();
			}
			@Override
			public Adapter caseRepository(Repository object) {
				return createRepositoryAdapter();
			}
			@Override
			public Adapter caseComponentEndpoint(ComponentEndpoint object) {
				return createComponentEndpointAdapter();
			}
			@Override
			public Adapter casePrimitiveDataType(PrimitiveDataType object) {
				return createPrimitiveDataTypeAdapter();
			}
			@Override
			public Adapter caseComplexDataType(ComplexDataType object) {
				return createComplexDataTypeAdapter();
			}
			@Override
			public Adapter caseInnerElement(InnerElement object) {
				return createInnerElementAdapter();
			}
			@Override
			public Adapter caseCompositeComponent(CompositeComponent object) {
				return createCompositeComponentAdapter();
			}
			@Override
			public Adapter casePrimitiveComponent(PrimitiveComponent object) {
				return createPrimitiveComponentAdapter();
			}
			@Override
			public Adapter caseEventPort(EventPort object) {
				return createEventPortAdapter();
			}
			@Override
			public Adapter caseInterfacePort(InterfacePort object) {
				return createInterfacePortAdapter();
			}
			@Override
			public Adapter caseCollectionDataType(CollectionDataType object) {
				return createCollectionDataTypeAdapter();
			}
			@Override
			public Adapter caseFirstClassEntity(FirstClassEntity object) {
				return createFirstClassEntityAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure <em>Composite Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure
	 * @generated
	 */
	public Adapter createCompositeStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType
	 * @generated
	 */
	public Adapter createComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity <em>Named Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.NamedEntity
	 * @generated
	 */
	public Adapter createNamedEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Message
	 * @generated
	 */
	public Adapter createMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception
	 * @generated
	 */
	public Adapter createExceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance <em>Subcomponent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance
	 * @generated
	 */
	public Adapter createSubcomponentInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector
	 * @generated
	 */
	public Adapter createConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint
	 * @generated
	 */
	public Adapter createEndPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel <em>Service Architecture Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel
	 * @generated
	 */
	public Adapter createServiceArchitectureModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint <em>Subcomponent Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint
	 * @generated
	 */
	public Adapter createSubcomponentEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository
	 * @generated
	 */
	public Adapter createRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint <em>Component Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint
	 * @generated
	 */
	public Adapter createComponentEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType <em>Primitive Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType
	 * @generated
	 */
	public Adapter createPrimitiveDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType <em>Complex Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType
	 * @generated
	 */
	public Adapter createComplexDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement <em>Inner Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement
	 * @generated
	 */
	public Adapter createInnerElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent
	 * @generated
	 */
	public Adapter createCompositeComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent <em>Primitive Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent
	 * @generated
	 */
	public Adapter createPrimitiveComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort
	 * @generated
	 */
	public Adapter createEventPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort <em>Interface Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort
	 * @generated
	 */
	public Adapter createInterfacePortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType <em>Collection Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType
	 * @generated
	 */
	public Adapter createCollectionDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity <em>First Class Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity
	 * @generated
	 */
	public Adapter createFirstClassEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StaticStructureAdapterFactory
