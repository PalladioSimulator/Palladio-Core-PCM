/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.CollectionDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeComponent;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.InterfacePort;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Message;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Parameter;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveComponent;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.PrimitiveDataType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructureFactory;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Type;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class StaticStructureFactoryImpl extends EFactoryImpl implements StaticStructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StaticStructureFactory init() {
		try {
			StaticStructureFactory theStaticStructureFactory = (StaticStructureFactory)EPackage.Registry.INSTANCE.getEFactory("http:///CoreModel/StaticStructure.ecore"); 
			if (theStaticStructureFactory != null) {
				return theStaticStructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StaticStructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticStructureFactoryImpl() {
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
			case StaticStructurePackage.OPERATION: return createOperation();
			case StaticStructurePackage.MESSAGE: return createMessage();
			case StaticStructurePackage.PARAMETER: return createParameter();
			case StaticStructurePackage.TYPE: return createType();
			case StaticStructurePackage.EXCEPTION: return createException();
			case StaticStructurePackage.SUBCOMPONENT_INSTANCE: return createSubcomponentInstance();
			case StaticStructurePackage.CONNECTOR: return createConnector();
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL: return createServiceArchitectureModel();
			case StaticStructurePackage.INTERFACE: return createInterface();
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT: return createSubcomponentEndpoint();
			case StaticStructurePackage.REPOSITORY: return createRepository();
			case StaticStructurePackage.COMPONENT_ENDPOINT: return createComponentEndpoint();
			case StaticStructurePackage.PRIMITIVE_DATA_TYPE: return createPrimitiveDataType();
			case StaticStructurePackage.COMPLEX_DATA_TYPE: return createComplexDataType();
			case StaticStructurePackage.INNER_ELEMENT: return createInnerElement();
			case StaticStructurePackage.COMPOSITE_COMPONENT: return createCompositeComponent();
			case StaticStructurePackage.PRIMITIVE_COMPONENT: return createPrimitiveComponent();
			case StaticStructurePackage.EVENT_PORT: return createEventPort();
			case StaticStructurePackage.INTERFACE_PORT: return createInterfacePort();
			case StaticStructurePackage.COLLECTION_DATA_TYPE: return createCollectionDataType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StaticStructurePackage.XSD_PRIMITIVE_DATA_TYPES:
				return createXSDPrimitiveDataTypesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StaticStructurePackage.XSD_PRIMITIVE_DATA_TYPES:
				return convertXSDPrimitiveDataTypesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception createException() {
		ExceptionImpl exception = new ExceptionImpl();
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentInstance createSubcomponentInstance() {
		SubcomponentInstanceImpl subcomponentInstance = new SubcomponentInstanceImpl();
		return subcomponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceArchitectureModel createServiceArchitectureModel() {
		ServiceArchitectureModelImpl serviceArchitectureModel = new ServiceArchitectureModelImpl();
		return serviceArchitectureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface createInterface() {
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentEndpoint createSubcomponentEndpoint() {
		SubcomponentEndpointImpl subcomponentEndpoint = new SubcomponentEndpointImpl();
		return subcomponentEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository createRepository() {
		RepositoryImpl repository = new RepositoryImpl();
		return repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentEndpoint createComponentEndpoint() {
		ComponentEndpointImpl componentEndpoint = new ComponentEndpointImpl();
		return componentEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveDataType createPrimitiveDataType() {
		PrimitiveDataTypeImpl primitiveDataType = new PrimitiveDataTypeImpl();
		return primitiveDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexDataType createComplexDataType() {
		ComplexDataTypeImpl complexDataType = new ComplexDataTypeImpl();
		return complexDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InnerElement createInnerElement() {
		InnerElementImpl innerElement = new InnerElementImpl();
		return innerElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeComponent createCompositeComponent() {
		CompositeComponentImpl compositeComponent = new CompositeComponentImpl();
		return compositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveComponent createPrimitiveComponent() {
		PrimitiveComponentImpl primitiveComponent = new PrimitiveComponentImpl();
		return primitiveComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventPort createEventPort() {
		EventPortImpl eventPort = new EventPortImpl();
		return eventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfacePort createInterfacePort() {
		InterfacePortImpl interfacePort = new InterfacePortImpl();
		return interfacePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionDataType createCollectionDataType() {
		CollectionDataTypeImpl collectionDataType = new CollectionDataTypeImpl();
		return collectionDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSDPrimitiveDataTypes createXSDPrimitiveDataTypesFromString(EDataType eDataType, String initialValue) {
		XSDPrimitiveDataTypes result = XSDPrimitiveDataTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertXSDPrimitiveDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticStructurePackage getStaticStructurePackage() {
		return (StaticStructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StaticStructurePackage getPackage() {
		return StaticStructurePackage.eINSTANCE;
	}

} //StaticStructureFactoryImpl
