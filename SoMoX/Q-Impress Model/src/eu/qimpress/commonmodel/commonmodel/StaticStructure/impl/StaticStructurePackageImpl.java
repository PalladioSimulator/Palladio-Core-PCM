/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage;

import eu.qimpress.commonmodel.commonmodel.Allocation.impl.AllocationPackageImpl;

import eu.qimpress.commonmodel.commonmodel.Behavior.BehaviorPackage;

import eu.qimpress.commonmodel.commonmodel.Behavior.impl.BehaviorPackageImpl;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.ResourceEnvironmentPackage;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.ResourceEnvironmentPackageImpl;

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
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructureFactory;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Type;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.XSDPrimitiveDataTypes;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.util.StaticStructureValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StaticStructurePackageImpl extends EPackageImpl implements StaticStructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subcomponentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceArchitectureModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subcomponentEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass innerElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfacePortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass firstClassEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum xsdPrimitiveDataTypesEEnum = null;

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
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StaticStructurePackageImpl() {
		super(eNS_URI, StaticStructureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StaticStructurePackage init() {
		if (isInited) return (StaticStructurePackage)EPackage.Registry.INSTANCE.getEPackage(StaticStructurePackage.eNS_URI);

		// Obtain or create and register package
		StaticStructurePackageImpl theStaticStructurePackage = (StaticStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StaticStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StaticStructurePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ResourceEnvironmentPackageImpl theResourceEnvironmentPackage = (ResourceEnvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceEnvironmentPackage.eNS_URI) instanceof ResourceEnvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceEnvironmentPackage.eNS_URI) : ResourceEnvironmentPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);

		// Create package meta-data objects
		theStaticStructurePackage.createPackageContents();
		theResourceEnvironmentPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theBehaviorPackage.createPackageContents();

		// Initialize created meta-data
		theStaticStructurePackage.initializePackageContents();
		theResourceEnvironmentPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theStaticStructurePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return StaticStructureValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theStaticStructurePackage.freeze();

		return theStaticStructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeStructure() {
		return compositeStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeStructure_Subcomponents() {
		return (EReference)compositeStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeStructure_Connector() {
		return (EReference)compositeStructureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Required() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Provided() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Behaviour() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedEntity() {
		return namedEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedEntity_Name() {
		return (EAttribute)namedEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_Id() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Input() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Output() {
		return (EReference)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_ThrowsExceptions() {
		return (EReference)operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Parameters() {
		return (EReference)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Type() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getException() {
		return exceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getException_ExceptionMessage() {
		return (EAttribute)exceptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubcomponentInstance() {
		return subcomponentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponentInstance_RealizedBy() {
		return (EReference)subcomponentInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnector() {
		return connectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnector_IsDelegation() {
		return (EAttribute)connectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnector_Endpoints() {
		return (EReference)connectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPoint() {
		return endPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceArchitectureModel() {
		return serviceArchitectureModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceArchitectureModel_DeclaredInterfaces() {
		return (EReference)serviceArchitectureModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceArchitectureModel_Service() {
		return (EReference)serviceArchitectureModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Signatures() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Inheritance() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubcomponentEndpoint() {
		return subcomponentEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponentEndpoint_Subcomponent() {
		return (EReference)subcomponentEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubcomponentEndpoint_Port() {
		return (EReference)subcomponentEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepository() {
		return repositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepository_Entities() {
		return (EReference)repositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentEndpoint() {
		return componentEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentEndpoint_Port() {
		return (EReference)componentEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveDataType() {
		return primitiveDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveDataType_Type() {
		return (EAttribute)primitiveDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexDataType() {
		return complexDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexDataType_Elements() {
		return (EReference)complexDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInnerElement() {
		return innerElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInnerElement_Type() {
		return (EReference)innerElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeComponent() {
		return compositeComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveComponent() {
		return primitiveComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventPort() {
		return eventPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventPort_IsSource() {
		return (EAttribute)eventPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventPort_Message() {
		return (EReference)eventPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfacePort() {
		return interfacePortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfacePort_Type() {
		return (EReference)interfacePortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionDataType() {
		return collectionDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionDataType_Innertype() {
		return (EReference)collectionDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFirstClassEntity() {
		return firstClassEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getXSDPrimitiveDataTypes() {
		return xsdPrimitiveDataTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticStructureFactory getStaticStructureFactory() {
		return (StaticStructureFactory)getEFactoryInstance();
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
		compositeStructureEClass = createEClass(COMPOSITE_STRUCTURE);
		createEReference(compositeStructureEClass, COMPOSITE_STRUCTURE__SUBCOMPONENTS);
		createEReference(compositeStructureEClass, COMPOSITE_STRUCTURE__CONNECTOR);

		componentTypeEClass = createEClass(COMPONENT_TYPE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__REQUIRED);
		createEReference(componentTypeEClass, COMPONENT_TYPE__PROVIDED);
		createEReference(componentTypeEClass, COMPONENT_TYPE__BEHAVIOUR);

		namedEntityEClass = createEClass(NAMED_ENTITY);
		createEAttribute(namedEntityEClass, NAMED_ENTITY__NAME);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__ID);

		portEClass = createEClass(PORT);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__INPUT);
		createEReference(operationEClass, OPERATION__OUTPUT);
		createEReference(operationEClass, OPERATION__THROWS_EXCEPTIONS);

		messageEClass = createEClass(MESSAGE);
		createEReference(messageEClass, MESSAGE__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__TYPE);

		typeEClass = createEClass(TYPE);

		exceptionEClass = createEClass(EXCEPTION);
		createEAttribute(exceptionEClass, EXCEPTION__EXCEPTION_MESSAGE);

		subcomponentInstanceEClass = createEClass(SUBCOMPONENT_INSTANCE);
		createEReference(subcomponentInstanceEClass, SUBCOMPONENT_INSTANCE__REALIZED_BY);

		connectorEClass = createEClass(CONNECTOR);
		createEAttribute(connectorEClass, CONNECTOR__IS_DELEGATION);
		createEReference(connectorEClass, CONNECTOR__ENDPOINTS);

		endPointEClass = createEClass(END_POINT);

		serviceArchitectureModelEClass = createEClass(SERVICE_ARCHITECTURE_MODEL);
		createEReference(serviceArchitectureModelEClass, SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES);
		createEReference(serviceArchitectureModelEClass, SERVICE_ARCHITECTURE_MODEL__SERVICE);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__SIGNATURES);
		createEReference(interfaceEClass, INTERFACE__INHERITANCE);

		subcomponentEndpointEClass = createEClass(SUBCOMPONENT_ENDPOINT);
		createEReference(subcomponentEndpointEClass, SUBCOMPONENT_ENDPOINT__SUBCOMPONENT);
		createEReference(subcomponentEndpointEClass, SUBCOMPONENT_ENDPOINT__PORT);

		repositoryEClass = createEClass(REPOSITORY);
		createEReference(repositoryEClass, REPOSITORY__ENTITIES);

		componentEndpointEClass = createEClass(COMPONENT_ENDPOINT);
		createEReference(componentEndpointEClass, COMPONENT_ENDPOINT__PORT);

		primitiveDataTypeEClass = createEClass(PRIMITIVE_DATA_TYPE);
		createEAttribute(primitiveDataTypeEClass, PRIMITIVE_DATA_TYPE__TYPE);

		complexDataTypeEClass = createEClass(COMPLEX_DATA_TYPE);
		createEReference(complexDataTypeEClass, COMPLEX_DATA_TYPE__ELEMENTS);

		innerElementEClass = createEClass(INNER_ELEMENT);
		createEReference(innerElementEClass, INNER_ELEMENT__TYPE);

		compositeComponentEClass = createEClass(COMPOSITE_COMPONENT);

		primitiveComponentEClass = createEClass(PRIMITIVE_COMPONENT);

		eventPortEClass = createEClass(EVENT_PORT);
		createEAttribute(eventPortEClass, EVENT_PORT__IS_SOURCE);
		createEReference(eventPortEClass, EVENT_PORT__MESSAGE);

		interfacePortEClass = createEClass(INTERFACE_PORT);
		createEReference(interfacePortEClass, INTERFACE_PORT__TYPE);

		collectionDataTypeEClass = createEClass(COLLECTION_DATA_TYPE);
		createEReference(collectionDataTypeEClass, COLLECTION_DATA_TYPE__INNERTYPE);

		firstClassEntityEClass = createEClass(FIRST_CLASS_ENTITY);

		// Create enums
		xsdPrimitiveDataTypesEEnum = createEEnum(XSD_PRIMITIVE_DATA_TYPES);
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
		BehaviorPackage theBehaviorPackage = (BehaviorPackage)EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeStructureEClass.getESuperTypes().add(this.getComponentType());
		componentTypeEClass.getESuperTypes().add(this.getNamedEntity());
		componentTypeEClass.getESuperTypes().add(this.getFirstClassEntity());
		namedEntityEClass.getESuperTypes().add(this.getEntity());
		portEClass.getESuperTypes().add(this.getNamedEntity());
		operationEClass.getESuperTypes().add(this.getNamedEntity());
		messageEClass.getESuperTypes().add(this.getNamedEntity());
		typeEClass.getESuperTypes().add(this.getNamedEntity());
		typeEClass.getESuperTypes().add(this.getFirstClassEntity());
		exceptionEClass.getESuperTypes().add(this.getNamedEntity());
		subcomponentInstanceEClass.getESuperTypes().add(this.getEntity());
		connectorEClass.getESuperTypes().add(this.getEntity());
		endPointEClass.getESuperTypes().add(this.getEntity());
		serviceArchitectureModelEClass.getESuperTypes().add(this.getCompositeStructure());
		interfaceEClass.getESuperTypes().add(this.getNamedEntity());
		interfaceEClass.getESuperTypes().add(this.getFirstClassEntity());
		subcomponentEndpointEClass.getESuperTypes().add(this.getEndPoint());
		repositoryEClass.getESuperTypes().add(this.getNamedEntity());
		componentEndpointEClass.getESuperTypes().add(this.getEndPoint());
		primitiveDataTypeEClass.getESuperTypes().add(this.getType());
		complexDataTypeEClass.getESuperTypes().add(this.getType());
		innerElementEClass.getESuperTypes().add(this.getNamedEntity());
		compositeComponentEClass.getESuperTypes().add(this.getCompositeStructure());
		primitiveComponentEClass.getESuperTypes().add(this.getComponentType());
		eventPortEClass.getESuperTypes().add(this.getPort());
		interfacePortEClass.getESuperTypes().add(this.getPort());
		collectionDataTypeEClass.getESuperTypes().add(this.getType());

		// Initialize classes and features; add operations and parameters
		initEClass(compositeStructureEClass, CompositeStructure.class, "CompositeStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeStructure_Subcomponents(), this.getSubcomponentInstance(), null, "subcomponents", null, 0, -1, CompositeStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeStructure_Connector(), this.getConnector(), null, "connector", null, 0, -1, CompositeStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(compositeStructureEClass, ecorePackage.getEBoolean(), "InnerComponentsOfCompositeComponentsCanNotBeServicesAgain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(componentTypeEClass, ComponentType.class, "ComponentType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentType_Required(), this.getPort(), null, "required", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentType_Provided(), this.getPort(), null, "provided", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentType_Behaviour(), theBehaviorPackage.getBehavior(), null, "behaviour", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(namedEntityEClass, NamedEntity.class, "NamedEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedEntity_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Id(), ecorePackage.getEString(), "id", null, 1, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Input(), this.getMessage(), null, "input", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperation_Output(), this.getMessage(), null, "output", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperation_ThrowsExceptions(), this.getException(), null, "throwsExceptions", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessage_Parameters(), this.getParameter(), null, "parameters", null, 1, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Type(), this.getType(), null, "type", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exceptionEClass, eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception.class, "Exception", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getException_ExceptionMessage(), ecorePackage.getEString(), "ExceptionMessage", null, 1, 1, eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subcomponentInstanceEClass, SubcomponentInstance.class, "SubcomponentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubcomponentInstance_RealizedBy(), this.getComponentType(), null, "realizedBy", null, 1, 1, SubcomponentInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(connectorEClass, Connector.class, "Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnector_IsDelegation(), ecorePackage.getEBoolean(), "isDelegation", null, 1, 1, Connector.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getConnector_Endpoints(), this.getEndPoint(), null, "endpoints", null, 0, -1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serviceArchitectureModelEClass, ServiceArchitectureModel.class, "ServiceArchitectureModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceArchitectureModel_DeclaredInterfaces(), this.getInterface(), null, "declaredInterfaces", null, 0, -1, ServiceArchitectureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceArchitectureModel_Service(), theAllocationPackage.getService(), null, "service", null, 1, -1, ServiceArchitectureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(serviceArchitectureModelEClass, ecorePackage.getEBoolean(), "OnlyServicesOnTopLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_Signatures(), this.getOperation(), null, "signatures", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterface_Inheritance(), this.getInterface(), null, "inheritance", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subcomponentEndpointEClass, SubcomponentEndpoint.class, "SubcomponentEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubcomponentEndpoint_Subcomponent(), this.getSubcomponentInstance(), null, "subcomponent", null, 1, 1, SubcomponentEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSubcomponentEndpoint_Port(), this.getPort(), null, "port", null, 1, 1, SubcomponentEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(repositoryEClass, Repository.class, "Repository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepository_Entities(), this.getFirstClassEntity(), null, "entities", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentEndpointEClass, ComponentEndpoint.class, "ComponentEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentEndpoint_Port(), this.getPort(), null, "port", null, 1, 1, ComponentEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveDataTypeEClass, PrimitiveDataType.class, "PrimitiveDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveDataType_Type(), this.getXSDPrimitiveDataTypes(), "type", null, 0, 1, PrimitiveDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(complexDataTypeEClass, ComplexDataType.class, "ComplexDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexDataType_Elements(), this.getInnerElement(), null, "elements", null, 0, -1, ComplexDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(innerElementEClass, InnerElement.class, "InnerElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInnerElement_Type(), this.getType(), null, "type", null, 1, 1, InnerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compositeComponentEClass, CompositeComponent.class, "CompositeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveComponentEClass, PrimitiveComponent.class, "PrimitiveComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventPortEClass, EventPort.class, "EventPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventPort_IsSource(), ecorePackage.getEBoolean(), "isSource", null, 1, 1, EventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEventPort_Message(), this.getMessage(), null, "message", null, 1, 1, EventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interfacePortEClass, InterfacePort.class, "InterfacePort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfacePort_Type(), this.getInterface(), null, "type", null, 1, 1, InterfacePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionDataTypeEClass, CollectionDataType.class, "CollectionDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionDataType_Innertype(), this.getType(), null, "innertype", null, 1, 1, CollectionDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(firstClassEntityEClass, FirstClassEntity.class, "FirstClassEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.class, "XSDPrimitiveDataTypes");
		addEEnumLiteral(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.STRING);
		addEEnumLiteral(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.INT);
		addEEnumLiteral(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.FLOAT);
		addEEnumLiteral(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.DATE);
		addEEnumLiteral(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.TIME);
		addEEnumLiteral(xsdPrimitiveDataTypesEEnum, XSDPrimitiveDataTypes.BOOLEAN);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";															
		addAnnotation
		  (getEntity_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "namespace", "xmi"
		   });																																																				
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
		  (operationEClass, 
		   source, 
		   new String[] {
			 "variationPoint", null
		   });																																																	
	}

} //StaticStructurePackageImpl
