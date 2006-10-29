/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

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
 * @see de.uka.ipd.sdq.pcm.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "system";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/System/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.system";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemPackage eINSTANCE = de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredRoleImpl <em>Required Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemRequiredRoleImpl
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemRequiredRole()
	 * @generated
	 */
	int SYSTEM_REQUIRED_ROLE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>System System Required Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Delegation Connector System Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE__REQUIRED_DELEGATION_CONNECTOR_SYSTEM_REQUIRED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface System Required Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE__INTERFACE_SYSTEM_REQUIRED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specified Time Consumption System Required Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Required Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_ROLE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemImpl
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>System Provided Role System</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assembly System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ASSEMBLY_SYSTEM = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connector System</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required Delegation Connector System</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allocation System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ALLOCATION_SYSTEM = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>System Required Role System</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl <em>Provided Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemProvidedDelegationConnector()
	 * @generated
	 */
	int SYSTEM_PROVIDED_DELEGATION_CONNECTOR = 2;

	/**
	 * The feature id for the '<em><b>System Provided Role System Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Assembly Context System Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Component Provided Role System Provided Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR = 2;

	/**
	 * The number of structural features of the '<em>Provided Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_DELEGATION_CONNECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl <em>Required Delegation Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemRequiredDelegationConnector()
	 * @generated
	 */
	int SYSTEM_REQUIRED_DELEGATION_CONNECTOR = 3;

	/**
	 * The feature id for the '<em><b>System Required Role System Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Assembly Context System Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Required Role System Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR = 2;

	/**
	 * The number of structural features of the '<em>Required Delegation Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_REQUIRED_DELEGATION_CONNECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.system.impl.SpecifiedTimeConsumptionImpl <em>Specified Time Consumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.system.impl.SpecifiedTimeConsumptionImpl
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSpecifiedTimeConsumption()
	 * @generated
	 */
	int SPECIFIED_TIME_CONSUMPTION = 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION__SPECIFICATION = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Specification Random Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION__SPECIFICATION_RANDOM_VARIABLE = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE;

	/**
	 * The feature id for the '<em><b>Signature Specified Time Consumption</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specified Time Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIED_TIME_CONSUMPTION_FEATURE_COUNT = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl <em>Provided Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl
	 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemProvidedRole()
	 * @generated
	 */
	int SYSTEM_PROVIDED_ROLE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_ROLE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_ROLE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>System System Provided Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connector System Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface System Provided Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Provided Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_PROVIDED_ROLE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole <em>Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole
	 * @generated
	 */
	EClass getSystemRequiredRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSystem_SystemRequiredRole <em>System System Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>System System Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSystem_SystemRequiredRole()
	 * @see #getSystemRequiredRole()
	 * @generated
	 */
	EReference getSystemRequiredRole_System_SystemRequiredRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getRequiredDelegationConnector_SystemRequiredRole <em>Required Delegation Connector System Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Delegation Connector System Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getRequiredDelegationConnector_SystemRequiredRole()
	 * @see #getSystemRequiredRole()
	 * @generated
	 */
	EReference getSystemRequiredRole_RequiredDelegationConnector_SystemRequiredRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getInterface_SystemRequiredRole <em>Interface System Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface System Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getInterface_SystemRequiredRole()
	 * @see #getSystemRequiredRole()
	 * @generated
	 */
	EReference getSystemRequiredRole_Interface_SystemRequiredRole();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSpecifiedTimeConsumption_SystemRequiredRole <em>Specified Time Consumption System Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specified Time Consumption System Required Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSpecifiedTimeConsumption_SystemRequiredRole()
	 * @see #getSystemRequiredRole()
	 * @generated
	 */
	EReference getSystemRequiredRole_SpecifiedTimeConsumption_SystemRequiredRole();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.system.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.system.System#getSystemProvidedRole_System <em>System Provided Role System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Provided Role System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System#getSystemProvidedRole_System()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_SystemProvidedRole_System();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.System#getAssembly_System <em>Assembly System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System#getAssembly_System()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Assembly_System();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.system.System#getProvidedDelegationConnector_System <em>Provided Delegation Connector System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Delegation Connector System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System#getProvidedDelegationConnector_System()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_ProvidedDelegationConnector_System();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.system.System#getRequiredDelegationConnector_System <em>Required Delegation Connector System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Delegation Connector System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System#getRequiredDelegationConnector_System()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_RequiredDelegationConnector_System();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.System#getAllocation_System <em>Allocation System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocation System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System#getAllocation_System()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Allocation_System();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.system.System#getSystemRequiredRole_System <em>System Required Role System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Required Role System</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.System#getSystemRequiredRole_System()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_SystemRequiredRole_System();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector <em>Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector
	 * @generated
	 */
	EClass getSystemProvidedDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getSystemProvidedRole_SystemProvidedDelegationConnector <em>System Provided Role System Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Provided Role System Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getSystemProvidedRole_SystemProvidedDelegationConnector()
	 * @see #getSystemProvidedDelegationConnector()
	 * @generated
	 */
	EReference getSystemProvidedDelegationConnector_SystemProvidedRole_SystemProvidedDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getAssemblyContext_SystemProvidedDelegationConnector <em>Assembly Context System Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context System Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getAssemblyContext_SystemProvidedDelegationConnector()
	 * @see #getSystemProvidedDelegationConnector()
	 * @generated
	 */
	EReference getSystemProvidedDelegationConnector_AssemblyContext_SystemProvidedDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getComponentProvidedRole_SystemProvidedDelegationConnector <em>Component Provided Role System Provided Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Provided Role System Provided Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector#getComponentProvidedRole_SystemProvidedDelegationConnector()
	 * @see #getSystemProvidedDelegationConnector()
	 * @generated
	 */
	EReference getSystemProvidedDelegationConnector_ComponentProvidedRole_SystemProvidedDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector <em>Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector
	 * @generated
	 */
	EClass getSystemRequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getSystemRequiredRole_SystemRequiredDelegationConnector <em>System Required Role System Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Required Role System Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getSystemRequiredRole_SystemRequiredDelegationConnector()
	 * @see #getSystemRequiredDelegationConnector()
	 * @generated
	 */
	EReference getSystemRequiredDelegationConnector_SystemRequiredRole_SystemRequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getAssemblyContext_SystemRequiredDelegationConnector <em>Assembly Context System Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context System Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getAssemblyContext_SystemRequiredDelegationConnector()
	 * @see #getSystemRequiredDelegationConnector()
	 * @generated
	 */
	EReference getSystemRequiredDelegationConnector_AssemblyContext_SystemRequiredDelegationConnector();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getRequiredRole_SystemRequiredDelegationConnector <em>Required Role System Required Delegation Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Role System Required Delegation Connector</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector#getRequiredRole_SystemRequiredDelegationConnector()
	 * @see #getSystemRequiredDelegationConnector()
	 * @generated
	 */
	EReference getSystemRequiredDelegationConnector_RequiredRole_SystemRequiredDelegationConnector();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption <em>Specified Time Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specified Time Consumption</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption
	 * @generated
	 */
	EClass getSpecifiedTimeConsumption();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption#getSignature_SpecifiedTimeConsumption <em>Signature Specified Time Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature Specified Time Consumption</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption#getSignature_SpecifiedTimeConsumption()
	 * @see #getSpecifiedTimeConsumption()
	 * @generated
	 */
	EReference getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole <em>Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedRole
	 * @generated
	 */
	EClass getSystemProvidedRole();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getSystem_SystemProvidedRole <em>System System Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>System System Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getSystem_SystemProvidedRole()
	 * @see #getSystemProvidedRole()
	 * @generated
	 */
	EReference getSystemProvidedRole_System_SystemProvidedRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getProvidedDelegationConnector_SystemProvidedRole <em>Provided Delegation Connector System Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Delegation Connector System Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getProvidedDelegationConnector_SystemProvidedRole()
	 * @see #getSystemProvidedRole()
	 * @generated
	 */
	EReference getSystemProvidedRole_ProvidedDelegationConnector_SystemProvidedRole();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getInterface_SystemProvidedRole <em>Interface System Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interface System Provided Role</em>'.
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getInterface_SystemProvidedRole()
	 * @see #getSystemProvidedRole()
	 * @generated
	 */
	EReference getSystemProvidedRole_Interface_SystemProvidedRole();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemFactory getSystemFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredRoleImpl <em>Required Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemRequiredRoleImpl
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemRequiredRole()
		 * @generated
		 */
		EClass SYSTEM_REQUIRED_ROLE = eINSTANCE.getSystemRequiredRole();

		/**
		 * The meta object literal for the '<em><b>System System Required Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE = eINSTANCE.getSystemRequiredRole_System_SystemRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Required Delegation Connector System Required Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_ROLE__REQUIRED_DELEGATION_CONNECTOR_SYSTEM_REQUIRED_ROLE = eINSTANCE.getSystemRequiredRole_RequiredDelegationConnector_SystemRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Interface System Required Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_ROLE__INTERFACE_SYSTEM_REQUIRED_ROLE = eINSTANCE.getSystemRequiredRole_Interface_SystemRequiredRole();

		/**
		 * The meta object literal for the '<em><b>Specified Time Consumption System Required Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE = eINSTANCE.getSystemRequiredRole_SpecifiedTimeConsumption_SystemRequiredRole();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemImpl
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>System Provided Role System</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM = eINSTANCE.getSystem_SystemProvidedRole_System();

		/**
		 * The meta object literal for the '<em><b>Assembly System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ASSEMBLY_SYSTEM = eINSTANCE.getSystem_Assembly_System();

		/**
		 * The meta object literal for the '<em><b>Provided Delegation Connector System</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM = eINSTANCE.getSystem_ProvidedDelegationConnector_System();

		/**
		 * The meta object literal for the '<em><b>Required Delegation Connector System</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM = eINSTANCE.getSystem_RequiredDelegationConnector_System();

		/**
		 * The meta object literal for the '<em><b>Allocation System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ALLOCATION_SYSTEM = eINSTANCE.getSystem_Allocation_System();

		/**
		 * The meta object literal for the '<em><b>System Required Role System</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM = eINSTANCE.getSystem_SystemRequiredRole_System();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl <em>Provided Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemProvidedDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemProvidedDelegationConnector()
		 * @generated
		 */
		EClass SYSTEM_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getSystemProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>System Provided Role System Provided Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getSystemProvidedDelegationConnector_SystemProvidedRole_SystemProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Assembly Context System Provided Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getSystemProvidedDelegationConnector_AssemblyContext_SystemProvidedDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Component Provided Role System Provided Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR = eINSTANCE.getSystemProvidedDelegationConnector_ComponentProvidedRole_SystemProvidedDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl <em>Required Delegation Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemRequiredDelegationConnectorImpl
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemRequiredDelegationConnector()
		 * @generated
		 */
		EClass SYSTEM_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getSystemRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>System Required Role System Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getSystemRequiredDelegationConnector_SystemRequiredRole_SystemRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Assembly Context System Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getSystemRequiredDelegationConnector_AssemblyContext_SystemRequiredDelegationConnector();

		/**
		 * The meta object literal for the '<em><b>Required Role System Required Delegation Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR = eINSTANCE.getSystemRequiredDelegationConnector_RequiredRole_SystemRequiredDelegationConnector();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.system.impl.SpecifiedTimeConsumptionImpl <em>Specified Time Consumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.system.impl.SpecifiedTimeConsumptionImpl
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSpecifiedTimeConsumption()
		 * @generated
		 */
		EClass SPECIFIED_TIME_CONSUMPTION = eINSTANCE.getSpecifiedTimeConsumption();

		/**
		 * The meta object literal for the '<em><b>Signature Specified Time Consumption</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION = eINSTANCE.getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl <em>Provided Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemProvidedRoleImpl
		 * @see de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl#getSystemProvidedRole()
		 * @generated
		 */
		EClass SYSTEM_PROVIDED_ROLE = eINSTANCE.getSystemProvidedRole();

		/**
		 * The meta object literal for the '<em><b>System System Provided Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE = eINSTANCE.getSystemProvidedRole_System_SystemProvidedRole();

		/**
		 * The meta object literal for the '<em><b>Provided Delegation Connector System Provided Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE = eINSTANCE.getSystemProvidedRole_ProvidedDelegationConnector_SystemProvidedRole();

		/**
		 * The meta object literal for the '<em><b>Interface System Provided Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE = eINSTANCE.getSystemProvidedRole_Interface_SystemProvidedRole();

	}

} //SystemPackage
