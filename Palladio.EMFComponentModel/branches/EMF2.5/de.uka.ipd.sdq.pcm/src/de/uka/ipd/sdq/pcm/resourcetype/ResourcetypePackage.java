/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcetypePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resourcetype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/ResourceType/4.0";

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
	ResourcetypePackage eINSTANCE = de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__UNIT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__UNIT_SPECIFICATION = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl <em>Resource Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRepository()
	 * @generated
	 */
	int RESOURCE_REPOSITORY = 1;

	/**
	 * The feature id for the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY = 0;

	/**
	 * The number of structural features of the '<em>Resource Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REPOSITORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl <em>Processing Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getProcessingResourceType()
	 * @generated
	 */
	int PROCESSING_RESOURCE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__ID = RESOURCE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__ENTITY_NAME = RESOURCE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__UNIT = RESOURCE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE__UNIT_SPECIFICATION = RESOURCE_TYPE__UNIT_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Processing Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_TYPE_FEATURE_COUNT = RESOURCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl <em>Communication Link Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl
	 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getCommunicationLinkResourceType()
	 * @generated
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__ID = PROCESSING_RESOURCE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__ENTITY_NAME = PROCESSING_RESOURCE_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__UNIT = PROCESSING_RESOURCE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE__UNIT_SPECIFICATION = PROCESSING_RESOURCE_TYPE__UNIT_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Communication Link Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_LINK_RESOURCE_TYPE_FEATURE_COUNT = PROCESSING_RESOURCE_TYPE_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository <em>Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository
	 * @generated
	 */
	EClass getResourceRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Resource Types Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository()
	 * @see #getResourceRepository()
	 * @generated
	 */
	EReference getResourceRepository_AvailableResourceTypes_ResourceRepository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType <em>Communication Link Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Link Resource Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType
	 * @generated
	 */
	EClass getCommunicationLinkResourceType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType <em>Processing Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType
	 * @generated
	 */
	EClass getProcessingResourceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourcetypeFactory getResourcetypeFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl <em>Resource Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getResourceRepository()
		 * @generated
		 */
		EClass RESOURCE_REPOSITORY = eINSTANCE.getResourceRepository();

		/**
		 * The meta object literal for the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY = eINSTANCE.getResourceRepository_AvailableResourceTypes_ResourceRepository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl <em>Communication Link Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.CommunicationLinkResourceTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getCommunicationLinkResourceType()
		 * @generated
		 */
		EClass COMMUNICATION_LINK_RESOURCE_TYPE = eINSTANCE.getCommunicationLinkResourceType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl <em>Processing Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ProcessingResourceTypeImpl
		 * @see de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl#getProcessingResourceType()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE_TYPE = eINSTANCE.getProcessingResourceType();

	}

} //ResourcetypePackage
