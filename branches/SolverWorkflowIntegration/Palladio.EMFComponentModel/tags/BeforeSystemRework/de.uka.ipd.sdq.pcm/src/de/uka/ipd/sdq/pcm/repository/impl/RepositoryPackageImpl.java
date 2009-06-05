/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl;
import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;
import de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ChildComponentContext;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeAssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryPackageImpl extends EPackageImpl implements RepositoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signatureEClass = null;

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
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredRoleEClass = null;

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
	private EClass requiredDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childComponentContextEClass = null;

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
	private EClass providedRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providedDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeComponentTypeEClass = null;

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
	private EClass compositeAssemblyConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providesComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterModifierEEnum = null;

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
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RepositoryPackageImpl() {
		super(eNS_URI, RepositoryFactory.eINSTANCE);
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
	public static RepositoryPackage init() {
		if (isInited) return (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

		// Obtain or create and register package
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new RepositoryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AssemblyPackageImpl theAssemblyPackage = (AssemblyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) instanceof AssemblyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) : AssemblyPackage.eINSTANCE);
		StochasticsPackageImpl theStochasticsPackage = (StochasticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) instanceof StochasticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) : StochasticsPackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) : ParameterPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);

		// Create package meta-data objects
		theRepositoryPackage.createPackageContents();
		theAssemblyPackage.createPackageContents();
		theStochasticsPackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theParameterPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theSystemPackage.createPackageContents();

		// Initialize created meta-data
		theRepositoryPackage.initializePackageContents();
		theAssemblyPackage.initializePackageContents();
		theStochasticsPackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theParameterPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theRepositoryPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return RepositoryValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theRepositoryPackage.freeze();

		return theRepositoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignature() {
		return signatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignature_ServiceName() {
		return (EAttribute)signatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSignature_Parameters__Signature() {
		return (EReference)signatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSignature_Returntype__Signature() {
		return (EReference)signatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSignature_Exceptions__Signature() {
		return (EReference)signatureEClass.getEStructuralFeatures().get(3);
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
	public EReference getParameter_Datatype__Parameter() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_ParameterName() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Modifier__Parameter() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_ParentDataType__DataType() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Type() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionType() {
		return exceptionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionType_ExceptionName() {
		return (EAttribute)exceptionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionType_ExceptionMessage() {
		return (EAttribute)exceptionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredRole() {
		return requiredRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredRole_RequiredInterface__RequiredRole() {
		return (EReference)requiredRoleEClass.getEStructuralFeatures().get(0);
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
	public EReference getInterface_ParentInterface__Interface() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_AnchestorInterfaces() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Protocols__Interface() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Signatures__Interface() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredDelegationConnector() {
		return requiredDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiredDelegationConnector_ChildComponentContext_RequiredDelegationConnector() {
		return (EReference)requiredDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelegationConnector() {
		return delegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildComponentContext() {
		return childComponentContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildComponentContext_EncapsulatedComponent_ChildComponentContext() {
		return (EReference)childComponentContextEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getRepository_RepositoryDescription() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_RepositoryName() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepository_Components__Repository() {
		return (EReference)repositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepository_Interfaces__Repository() {
		return (EReference)repositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidedRole() {
		return providedRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedRole_ProvidedInterface__ProvidedRole() {
		return (EReference)providedRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedRole_ProvidingComponent__ProvidedRole() {
		return (EReference)providedRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidedDelegationConnector() {
		return providedDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidedDelegationConnector_ChildComponentContext_ProvidedDelegationConnector() {
		return (EReference)providedDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationComponentType() {
		return implementationComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationComponentType_ParentCompleteComponentTypes() {
		return (EReference)implementationComponentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteComponentType() {
		return completeComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteComponentType_ParentProvidesComponentTypes() {
		return (EReference)completeComponentTypeEClass.getEStructuralFeatures().get(0);
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
	public EReference getCompositeComponent_ProvidedDelegationConnectors__CompositeComponent() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeComponent_RequiredDelegationConnectors__CompositeComponent() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeComponent_ImplementationComponentType() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeComponent_ChildComponentContexts_CompositeComponent() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeComponent_CompositeAssemblyConnectors_CompositeComponent() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeAssemblyConnector() {
		return compositeAssemblyConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeAssemblyConnector_RequiringChildComponentContext_CompositeAssemblyConnector() {
		return (EReference)compositeAssemblyConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeAssemblyConnector_ProvidingChildComponentContext_CompositeAssemblyConnector() {
		return (EReference)compositeAssemblyConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeAssemblyConnector_ProvidedRole_CompositeAssemblyConnector() {
		return (EReference)compositeAssemblyConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeAssemblyConnector_RequiredRole_CompositeAssemblyConnector() {
		return (EReference)compositeAssemblyConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicComponent() {
		return basicComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicComponent_ImplementationComponentType() {
		return (EReference)basicComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicComponent_ServiceEffectSpecifications__BasicComponent() {
		return (EReference)basicComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidesComponentType() {
		return providesComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesComponentType_ProvidedRoles__ProvidesComponentType() {
		return (EReference)providesComponentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesComponentType_RequiredRoles_ProvidesComponentType() {
		return (EReference)providesComponentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterModifier() {
		return parameterModifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryFactory getRepositoryFactory() {
		return (RepositoryFactory)getEFactoryInstance();
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
		signatureEClass = createEClass(SIGNATURE);
		createEAttribute(signatureEClass, SIGNATURE__SERVICE_NAME);
		createEReference(signatureEClass, SIGNATURE__PARAMETERS_SIGNATURE);
		createEReference(signatureEClass, SIGNATURE__RETURNTYPE_SIGNATURE);
		createEReference(signatureEClass, SIGNATURE__EXCEPTIONS_SIGNATURE);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__DATATYPE_PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__PARAMETER_NAME);
		createEAttribute(parameterEClass, PARAMETER__MODIFIER_PARAMETER);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEReference(dataTypeEClass, DATA_TYPE__PARENT_DATA_TYPE_DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__TYPE);

		exceptionTypeEClass = createEClass(EXCEPTION_TYPE);
		createEAttribute(exceptionTypeEClass, EXCEPTION_TYPE__EXCEPTION_NAME);
		createEAttribute(exceptionTypeEClass, EXCEPTION_TYPE__EXCEPTION_MESSAGE);

		roleEClass = createEClass(ROLE);

		requiredRoleEClass = createEClass(REQUIRED_ROLE);
		createEReference(requiredRoleEClass, REQUIRED_ROLE__REQUIRED_INTERFACE_REQUIRED_ROLE);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__PARENT_INTERFACE_INTERFACE);
		createEReference(interfaceEClass, INTERFACE__ANCHESTOR_INTERFACES);
		createEReference(interfaceEClass, INTERFACE__PROTOCOLS_INTERFACE);
		createEReference(interfaceEClass, INTERFACE__SIGNATURES_INTERFACE);

		requiredDelegationConnectorEClass = createEClass(REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__INNER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__OUTER_REQUIRED_ROLE_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(requiredDelegationConnectorEClass, REQUIRED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_REQUIRED_DELEGATION_CONNECTOR);

		delegationConnectorEClass = createEClass(DELEGATION_CONNECTOR);

		childComponentContextEClass = createEClass(CHILD_COMPONENT_CONTEXT);
		createEReference(childComponentContextEClass, CHILD_COMPONENT_CONTEXT__ENCAPSULATED_COMPONENT_CHILD_COMPONENT_CONTEXT);

		repositoryEClass = createEClass(REPOSITORY);
		createEAttribute(repositoryEClass, REPOSITORY__REPOSITORY_DESCRIPTION);
		createEAttribute(repositoryEClass, REPOSITORY__REPOSITORY_NAME);
		createEReference(repositoryEClass, REPOSITORY__COMPONENTS_REPOSITORY);
		createEReference(repositoryEClass, REPOSITORY__INTERFACES_REPOSITORY);

		providedRoleEClass = createEClass(PROVIDED_ROLE);
		createEReference(providedRoleEClass, PROVIDED_ROLE__PROVIDED_INTERFACE_PROVIDED_ROLE);
		createEReference(providedRoleEClass, PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE);

		providedDelegationConnectorEClass = createEClass(PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__INNER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__OUTER_PROVIDED_ROLE_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(providedDelegationConnectorEClass, PROVIDED_DELEGATION_CONNECTOR__CHILD_COMPONENT_CONTEXT_PROVIDED_DELEGATION_CONNECTOR);

		implementationComponentTypeEClass = createEClass(IMPLEMENTATION_COMPONENT_TYPE);
		createEReference(implementationComponentTypeEClass, IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES);

		completeComponentTypeEClass = createEClass(COMPLETE_COMPONENT_TYPE);
		createEReference(completeComponentTypeEClass, COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES);

		compositeComponentEClass = createEClass(COMPOSITE_COMPONENT);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__PROVIDED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__REQUIRED_DELEGATION_CONNECTORS_COMPOSITE_COMPONENT);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__CHILD_COMPONENT_CONTEXTS_COMPOSITE_COMPONENT);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSITE_COMPONENT);

		compositeAssemblyConnectorEClass = createEClass(COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(compositeAssemblyConnectorEClass, COMPOSITE_ASSEMBLY_CONNECTOR__REQUIRING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(compositeAssemblyConnectorEClass, COMPOSITE_ASSEMBLY_CONNECTOR__PROVIDING_CHILD_COMPONENT_CONTEXT_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(compositeAssemblyConnectorEClass, COMPOSITE_ASSEMBLY_CONNECTOR__PROVIDED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR);
		createEReference(compositeAssemblyConnectorEClass, COMPOSITE_ASSEMBLY_CONNECTOR__REQUIRED_ROLE_COMPOSITE_ASSEMBLY_CONNECTOR);

		basicComponentEClass = createEClass(BASIC_COMPONENT);
		createEReference(basicComponentEClass, BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE);
		createEReference(basicComponentEClass, BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT);

		providesComponentTypeEClass = createEClass(PROVIDES_COMPONENT_TYPE);
		createEReference(providesComponentTypeEClass, PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE);
		createEReference(providesComponentTypeEClass, PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE);

		// Create enums
		parameterModifierEEnum = createEEnum(PARAMETER_MODIFIER);
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
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		ProtocolPackage theProtocolPackage = (ProtocolPackage)EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI);
		ConnectorsPackage theConnectorsPackage = (ConnectorsPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Add supertypes to classes
		roleEClass.getESuperTypes().add(theEntityPackage.getEntity());
		requiredRoleEClass.getESuperTypes().add(this.getRole());
		interfaceEClass.getESuperTypes().add(theEntityPackage.getEntity());
		requiredDelegationConnectorEClass.getESuperTypes().add(this.getDelegationConnector());
		delegationConnectorEClass.getESuperTypes().add(theConnectorsPackage.getConnector());
		childComponentContextEClass.getESuperTypes().add(theEntityPackage.getEntity());
		providedRoleEClass.getESuperTypes().add(this.getRole());
		providedDelegationConnectorEClass.getESuperTypes().add(this.getDelegationConnector());
		implementationComponentTypeEClass.getESuperTypes().add(this.getCompleteComponentType());
		completeComponentTypeEClass.getESuperTypes().add(this.getProvidesComponentType());
		compositeComponentEClass.getESuperTypes().add(this.getImplementationComponentType());
		compositeAssemblyConnectorEClass.getESuperTypes().add(theConnectorsPackage.getConnector());
		compositeAssemblyConnectorEClass.getESuperTypes().add(theEntityPackage.getEntity());
		basicComponentEClass.getESuperTypes().add(this.getImplementationComponentType());
		providesComponentTypeEClass.getESuperTypes().add(theEntityPackage.getEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(signatureEClass, Signature.class, "Signature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignature_ServiceName(), ecorePackage.getEString(), "serviceName", null, 1, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSignature_Parameters__Signature(), this.getParameter(), null, "parameters__Signature", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSignature_Returntype__Signature(), this.getDataType(), null, "returntype__Signature", null, 1, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSignature_Exceptions__Signature(), this.getExceptionType(), null, "exceptions__Signature", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(signatureEClass, ecorePackage.getEBoolean(), "ParameterNamesHaveToBeUniqueForASignature", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Datatype__Parameter(), this.getDataType(), null, "datatype__Parameter", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getParameter_ParameterName(), ecorePackage.getEString(), "parameterName", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getParameter_Modifier__Parameter(), this.getParameterModifier(), "modifier__Parameter", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataType_ParentDataType__DataType(), this.getDataType(), null, "parentDataType__DataType", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataType_Type(), ecorePackage.getEString(), "type", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(exceptionTypeEClass, ExceptionType.class, "ExceptionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExceptionType_ExceptionName(), ecorePackage.getEString(), "exceptionName", null, 1, 1, ExceptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExceptionType_ExceptionMessage(), ecorePackage.getEString(), "exceptionMessage", null, 1, 1, ExceptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(requiredRoleEClass, RequiredRole.class, "RequiredRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequiredRole_RequiredInterface__RequiredRole(), this.getInterface(), null, "requiredInterface__RequiredRole", null, 1, 1, RequiredRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_ParentInterface__Interface(), this.getInterface(), null, "parentInterface__Interface", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterface_AnchestorInterfaces(), this.getInterface(), null, "anchestorInterfaces", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterface_Protocols__Interface(), theProtocolPackage.getProtocol(), null, "protocols__Interface", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterface_Signatures__Interface(), this.getSignature(), null, "signatures__Interface", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(interfaceEClass, ecorePackage.getEBoolean(), "noProtocolTypeIDUsedTwice", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(interfaceEClass, ecorePackage.getEBoolean(), "SignaturesHaveToBeUniqueForAnInterface", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(requiredDelegationConnectorEClass, RequiredDelegationConnector.class, "RequiredDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector(), this.getRequiredRole(), null, "innerRequiredRole_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector(), this.getRequiredRole(), null, "outerRequiredRole_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRequiredDelegationConnector_ChildComponentContext_RequiredDelegationConnector(), this.getChildComponentContext(), null, "childComponentContext_RequiredDelegationConnector", null, 1, 1, RequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "innerAndOuterRoleNeedToHaveDifferentContextIDs", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(requiredDelegationConnectorEClass, ecorePackage.getEBoolean(), "InnerContainingComponentEqualOuterRequiringComponent", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(delegationConnectorEClass, DelegationConnector.class, "DelegationConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(childComponentContextEClass, ChildComponentContext.class, "ChildComponentContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChildComponentContext_EncapsulatedComponent_ChildComponentContext(), this.getProvidesComponentType(), null, "encapsulatedComponent_ChildComponentContext", null, 1, 1, ChildComponentContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(repositoryEClass, Repository.class, "Repository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepository_RepositoryDescription(), ecorePackage.getEString(), "repositoryDescription", null, 1, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepository_RepositoryName(), ecorePackage.getEString(), "repositoryName", "New Component Model", 1, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRepository_Components__Repository(), this.getProvidesComponentType(), null, "components__Repository", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRepository_Interfaces__Repository(), this.getInterface(), null, "interfaces__Repository", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(repositoryEClass, ecorePackage.getEBoolean(), "GrantFirstClassEntityTypeCompositeComponent", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(repositoryEClass, ecorePackage.getEBoolean(), "GrantFirstClassEntityTypeProvidesComponentType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(repositoryEClass, ecorePackage.getEBoolean(), "GrantFirstClassEntityTypeCompleteComponentType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(repositoryEClass, ecorePackage.getEBoolean(), "GrantFirstClassEntityTypeImplementationComponentType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(repositoryEClass, ecorePackage.getEBoolean(), "GrantFirstClassEntityTypeBasicComponent", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(providedRoleEClass, ProvidedRole.class, "ProvidedRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidedRole_ProvidedInterface__ProvidedRole(), this.getInterface(), null, "providedInterface__ProvidedRole", null, 1, 1, ProvidedRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedRole_ProvidingComponent__ProvidedRole(), this.getProvidesComponentType(), this.getProvidesComponentType_ProvidedRoles__ProvidesComponentType(), "providingComponent__ProvidedRole", null, 1, 1, ProvidedRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(providedDelegationConnectorEClass, ProvidedDelegationConnector.class, "ProvidedDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidedDelegationConnector_InnerProvidedRole_ProvidedDelegationConnector(), this.getProvidedRole(), null, "innerProvidedRole_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_OuterProvidedRole_ProvidedDelegationConnector(), this.getProvidedRole(), null, "outerProvidedRole_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidedDelegationConnector_ChildComponentContext_ProvidedDelegationConnector(), this.getChildComponentContext(), null, "childComponentContext_ProvidedDelegationConnector", null, 1, 1, ProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(providedDelegationConnectorEClass, ecorePackage.getEBoolean(), "innerAndOuterRoleNeedToHaveDifferentContextIDs", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(providedDelegationConnectorEClass, ecorePackage.getEBoolean(), "InnerContainingComponentEqualOuterProvidingComponent", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(implementationComponentTypeEClass, ImplementationComponentType.class, "ImplementationComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementationComponentType_ParentCompleteComponentTypes(), this.getCompleteComponentType(), null, "parentCompleteComponentTypes", null, 0, -1, ImplementationComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(implementationComponentTypeEClass, ecorePackage.getEBoolean(), "RequiredInterfacesHaveToConformToCompleteType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(implementationComponentTypeEClass, ecorePackage.getEBoolean(), "providedInterfacesHaveToConformToCompleteType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(completeComponentTypeEClass, CompleteComponentType.class, "CompleteComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteComponentType_ParentProvidesComponentTypes(), this.getProvidesComponentType(), null, "parentProvidesComponentTypes", null, 0, -1, CompleteComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(completeComponentTypeEClass, ecorePackage.getEBoolean(), "AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(completeComponentTypeEClass, ecorePackage.getEBoolean(), "providedInterfacesHaveToConformToProvidedType2", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(compositeComponentEClass, CompositeComponent.class, "CompositeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeComponent_ProvidedDelegationConnectors__CompositeComponent(), this.getProvidedDelegationConnector(), null, "providedDelegationConnectors__CompositeComponent", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeComponent_RequiredDelegationConnectors__CompositeComponent(), this.getRequiredDelegationConnector(), null, "requiredDelegationConnectors__CompositeComponent", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeComponent_ImplementationComponentType(), this.getImplementationComponentType(), null, "implementationComponentType", null, 0, 1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeComponent_ChildComponentContexts_CompositeComponent(), this.getChildComponentContext(), null, "childComponentContexts_CompositeComponent", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeComponent_CompositeAssemblyConnectors_CompositeComponent(), this.getCompositeAssemblyConnector(), null, "compositeAssemblyConnectors_CompositeComponent", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(compositeComponentEClass, ecorePackage.getEBoolean(), "ProvideSameInterfaces", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(compositeComponentEClass, ecorePackage.getEBoolean(), "RequireSameInterfaces", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(compositeAssemblyConnectorEClass, CompositeAssemblyConnector.class, "CompositeAssemblyConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeAssemblyConnector_RequiringChildComponentContext_CompositeAssemblyConnector(), this.getChildComponentContext(), null, "requiringChildComponentContext_CompositeAssemblyConnector", null, 1, 1, CompositeAssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeAssemblyConnector_ProvidingChildComponentContext_CompositeAssemblyConnector(), this.getChildComponentContext(), null, "providingChildComponentContext_CompositeAssemblyConnector", null, 1, 1, CompositeAssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeAssemblyConnector_ProvidedRole_CompositeAssemblyConnector(), this.getProvidedRole(), null, "providedRole_CompositeAssemblyConnector", null, 1, 1, CompositeAssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeAssemblyConnector_RequiredRole_CompositeAssemblyConnector(), this.getRequiredRole(), null, "requiredRole_CompositeAssemblyConnector", null, 1, 1, CompositeAssemblyConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(basicComponentEClass, BasicComponent.class, "BasicComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicComponent_ImplementationComponentType(), this.getImplementationComponentType(), null, "implementationComponentType", null, 0, 1, BasicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBasicComponent_ServiceEffectSpecifications__BasicComponent(), theSeffPackage.getServiceEffectSpecification(), null, "serviceEffectSpecifications__BasicComponent", null, 0, -1, BasicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(basicComponentEClass, ecorePackage.getEBoolean(), "noSeffTypeUsedTwice", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(basicComponentEClass, ecorePackage.getEBoolean(), "ProvideSameInterfaces", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		op = addEOperation(basicComponentEClass, ecorePackage.getEBoolean(), "RequireSameInterfaces", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		initEClass(providesComponentTypeEClass, ProvidesComponentType.class, "ProvidesComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidesComponentType_ProvidedRoles__ProvidesComponentType(), this.getProvidedRole(), this.getProvidedRole_ProvidingComponent__ProvidedRole(), "providedRoles__ProvidesComponentType", null, 0, -1, ProvidesComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProvidesComponentType_RequiredRoles_ProvidesComponentType(), this.getRequiredRole(), null, "requiredRoles_ProvidesComponentType", null, 0, -1, ProvidesComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(providesComponentTypeEClass, ecorePackage.getEBoolean(), "AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType", 0, 1);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1);

		// Initialize enums and add enum literals
		initEEnum(parameterModifierEEnum, ParameterModifier.class, "ParameterModifier");
		addEEnumLiteral(parameterModifierEEnum, ParameterModifier.NONE_LITERAL);
		addEEnumLiteral(parameterModifierEEnum, ParameterModifier.IN_LITERAL);
		addEEnumLiteral(parameterModifierEEnum, ParameterModifier.OUT_LITERAL);
		addEEnumLiteral(parameterModifierEEnum, ParameterModifier.INOUT_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //RepositoryPackageImpl
