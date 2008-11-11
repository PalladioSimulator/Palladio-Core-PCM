/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

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
 * <!-- begin-model-doc -->
 * This  set of abstract meta-classes gives a conceptual view on interfaces, entities and their relationships: Two roles can be identified a software entity can take relative to an interface. Any entity can claim to implement the functionality specified in an interface as well as to request that functionality. 
 * 
 * Base of the inheritance hierarchy are Identifier and NamedElement, both of which Entity and all inheriting classes are derived from. 
 * 
 * The relationship of Entities and Interfaces is described with the three meta classes InterfaceProvidingEntity, InterfaceRequiringEntity, and InterfaceProvidingRequiringEntity. The abstract meta-class InterfaceProvidingEntity is inherited by all entities which can potentially offer interface implementations. Similarly, the meta-class InterfaceRequiringEntity is inherited by all entities which are allowed to request functionality offer by entities providing this functionality. InterfaceProvidingRequiringEntity inherits from both of them and thus combines their properties. 
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityFactory
 * @model kind="package"
 * @generated
 */
public interface EntityPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "entity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Core/Entity/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EntityPackage eINSTANCE = de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ENTITY_NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ENTITY_NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingEntityImpl <em>Interface Providing Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingEntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getInterfaceProvidingEntity()
	 * @generated
	 */
	int INTERFACE_PROVIDING_ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_ENTITY__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_ENTITY__ENTITY_NAME = ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Providing Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingRequiringEntityImpl <em>Interface Providing Requiring Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingRequiringEntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getInterfaceProvidingRequiringEntity()
	 * @generated
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceRequiringEntityImpl <em>Interface Requiring Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceRequiringEntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getInterfaceRequiringEntity()
	 * @generated
	 */
	int INTERFACE_REQUIRING_ENTITY = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY__ID = INTERFACE_PROVIDING_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME = INTERFACE_PROVIDING_ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = INTERFACE_PROVIDING_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = INTERFACE_PROVIDING_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface Providing Requiring Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT = INTERFACE_PROVIDING_ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REQUIRING_ENTITY__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REQUIRING_ENTITY__ENTITY_NAME = ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface Requiring Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_REQUIRING_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceRequiringEntityImpl <em>Resource Interface Requiring Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceRequiringEntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getResourceInterfaceRequiringEntity()
	 * @generated
	 */
	int RESOURCE_INTERFACE_REQUIRING_ENTITY = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_REQUIRING_ENTITY__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_REQUIRING_ENTITY__ENTITY_NAME = ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Interface Requiring Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_REQUIRING_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl <em>Composed Providing Requiring Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getComposedProvidingRequiringEntity()
	 * @generated
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__ID = CompositionPackage.COMPOSED_STRUCTURE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__ENTITY_NAME = CompositionPackage.COMPOSED_STRUCTURE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Assembly Contexts Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE = CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Assembly Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE = CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Resource Required Delegation Connectors Composed Structure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE = CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;

	/**
	 * The feature id for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = CompositionPackage.COMPOSED_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = CompositionPackage.COMPOSED_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = CompositionPackage.COMPOSED_STRUCTURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composed Providing Requiring Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_PROVIDING_REQUIRING_ENTITY_FEATURE_COUNT = CompositionPackage.COMPOSED_STRUCTURE_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceProvidingEntityImpl <em>Resource Interface Providing Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceProvidingEntityImpl
	 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getResourceInterfaceProvidingEntity()
	 * @generated
	 */
	int RESOURCE_INTERFACE_PROVIDING_ENTITY = 7;

	/**
	 * The feature id for the '<em><b>Resource Provided Roles Resource Interface Providing Entity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY = 0;

	/**
	 * The number of structural features of the '<em>Resource Interface Providing Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INTERFACE_PROVIDING_ENTITY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.core.entity.NamedElement#getEntityName <em>Entity Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entity Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.NamedElement#getEntityName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_EntityName();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity <em>Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Providing Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
	 * @generated
	 */
	EClass getInterfaceProvidingEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity <em>Provided Roles Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Roles Interface Providing Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity#getProvidedRoles_InterfaceProvidingEntity()
	 * @see #getInterfaceProvidingEntity()
	 * @generated
	 */
	EReference getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity <em>Interface Providing Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Providing Requiring Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity
	 * @generated
	 */
	EClass getInterfaceProvidingRequiringEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity <em>Interface Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Requiring Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity
	 * @generated
	 */
	EClass getInterfaceRequiringEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity#getRequiredRoles_InterfaceRequiringEntity <em>Required Roles Interface Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Roles Interface Requiring Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity#getRequiredRoles_InterfaceRequiringEntity()
	 * @see #getInterfaceRequiringEntity()
	 * @generated
	 */
	EReference getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity <em>Resource Interface Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Interface Requiring Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity
	 * @generated
	 */
	EClass getResourceInterfaceRequiringEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity#getResourceRequiredRoles_ResourceInterfaceRequiringEntity <em>Resource Required Roles Resource Interface Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Required Roles Resource Interface Requiring Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity#getResourceRequiredRoles_ResourceInterfaceRequiringEntity()
	 * @see #getResourceInterfaceRequiringEntity()
	 * @generated
	 */
	EReference getResourceInterfaceRequiringEntity_ResourceRequiredRoles_ResourceInterfaceRequiringEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity <em>Composed Providing Requiring Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Providing Requiring Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
	 * @generated
	 */
	EClass getComposedProvidingRequiringEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity <em>Resource Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Interface Providing Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity
	 * @generated
	 */
	EClass getResourceInterfaceProvidingEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity#getResourceProvidedRoles_ResourceInterfaceProvidingEntity <em>Resource Provided Roles Resource Interface Providing Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Provided Roles Resource Interface Providing Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity#getResourceProvidedRoles_ResourceInterfaceProvidingEntity()
	 * @see #getResourceInterfaceProvidingEntity()
	 * @generated
	 */
	EReference getResourceInterfaceProvidingEntity_ResourceProvidedRoles_ResourceInterfaceProvidingEntity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EntityFactory getEntityFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Entity Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__ENTITY_NAME = eINSTANCE.getNamedElement_EntityName();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingEntityImpl <em>Interface Providing Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingEntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getInterfaceProvidingEntity()
		 * @generated
		 */
		EClass INTERFACE_PROVIDING_ENTITY = eINSTANCE.getInterfaceProvidingEntity();

		/**
		 * The meta object literal for the '<em><b>Provided Roles Interface Providing Entity</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY = eINSTANCE.getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingRequiringEntityImpl <em>Interface Providing Requiring Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingRequiringEntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getInterfaceProvidingRequiringEntity()
		 * @generated
		 */
		EClass INTERFACE_PROVIDING_REQUIRING_ENTITY = eINSTANCE.getInterfaceProvidingRequiringEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceRequiringEntityImpl <em>Interface Requiring Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceRequiringEntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getInterfaceRequiringEntity()
		 * @generated
		 */
		EClass INTERFACE_REQUIRING_ENTITY = eINSTANCE.getInterfaceRequiringEntity();

		/**
		 * The meta object literal for the '<em><b>Required Roles Interface Requiring Entity</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY = eINSTANCE.getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceRequiringEntityImpl <em>Resource Interface Requiring Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceRequiringEntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getResourceInterfaceRequiringEntity()
		 * @generated
		 */
		EClass RESOURCE_INTERFACE_REQUIRING_ENTITY = eINSTANCE.getResourceInterfaceRequiringEntity();

		/**
		 * The meta object literal for the '<em><b>Resource Required Roles Resource Interface Requiring Entity</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY = eINSTANCE.getResourceInterfaceRequiringEntity_ResourceRequiredRoles_ResourceInterfaceRequiringEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl <em>Composed Providing Requiring Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getComposedProvidingRequiringEntity()
		 * @generated
		 */
		EClass COMPOSED_PROVIDING_REQUIRING_ENTITY = eINSTANCE.getComposedProvidingRequiringEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceProvidingEntityImpl <em>Resource Interface Providing Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.ResourceInterfaceProvidingEntityImpl
		 * @see de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl#getResourceInterfaceProvidingEntity()
		 * @generated
		 */
		EClass RESOURCE_INTERFACE_PROVIDING_ENTITY = eINSTANCE.getResourceInterfaceProvidingEntity();

		/**
		 * The meta object literal for the '<em><b>Resource Provided Roles Resource Interface Providing Entity</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY = eINSTANCE.getResourceInterfaceProvidingEntity_ResourceProvidedRoles_ResourceInterfaceProvidingEntity();

	}

} //EntityPackage
