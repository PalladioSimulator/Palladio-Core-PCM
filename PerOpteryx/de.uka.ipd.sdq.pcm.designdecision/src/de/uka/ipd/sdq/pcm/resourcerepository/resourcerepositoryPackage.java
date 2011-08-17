/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcerepository;

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
 * @see de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface resourcerepositoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resourcerepository";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/DesignDecision/ResourceRepository/2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resourcerepository";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	resourcerepositoryPackage eINSTANCE = de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionRepositoryImpl <em>Resource Description Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl#getResourceDescriptionRepository()
	 * @generated
	 */
	int RESOURCE_DESCRIPTION_REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Available Processing Resources Resource Repository</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTION_REPOSITORY__AVAILABLE_PROCESSING_RESOURCES_RESOURCE_REPOSITORY = 0;

	/**
	 * The number of structural features of the '<em>Resource Description Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTION_REPOSITORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionImpl <em>Resource Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionImpl
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl#getResourceDescription()
	 * @generated
	 */
	int RESOURCE_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Fixed Processing Resource Cost Resource Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTION__FIXED_PROCESSING_RESOURCE_COST_RESOURCE_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Processing Resource Specification Resource Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTION__PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Resource Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescriptionRepository <em>Resource Description Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Description Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescriptionRepository
	 * @generated
	 */
	EClass getResourceDescriptionRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescriptionRepository#getAvailableProcessingResources_ResourceRepository <em>Available Processing Resources Resource Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Processing Resources Resource Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescriptionRepository#getAvailableProcessingResources_ResourceRepository()
	 * @see #getResourceDescriptionRepository()
	 * @generated
	 */
	EReference getResourceDescriptionRepository_AvailableProcessingResources_ResourceRepository();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription <em>Resource Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Description</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription
	 * @generated
	 */
	EClass getResourceDescription();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getFixedProcessingResourceCost_ResourceDescription <em>Fixed Processing Resource Cost Resource Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fixed Processing Resource Cost Resource Description</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getFixedProcessingResourceCost_ResourceDescription()
	 * @see #getResourceDescription()
	 * @generated
	 */
	EReference getResourceDescription_FixedProcessingResourceCost_ResourceDescription();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getProcessingResourceSpecification_ResourceDescription <em>Processing Resource Specification Resource Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Processing Resource Specification Resource Description</em>'.
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getProcessingResourceSpecification_ResourceDescription()
	 * @see #getResourceDescription()
	 * @generated
	 */
	EReference getResourceDescription_ProcessingResourceSpecification_ResourceDescription();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	resourcerepositoryFactory getresourcerepositoryFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionRepositoryImpl <em>Resource Description Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl#getResourceDescriptionRepository()
		 * @generated
		 */
		EClass RESOURCE_DESCRIPTION_REPOSITORY = eINSTANCE.getResourceDescriptionRepository();

		/**
		 * The meta object literal for the '<em><b>Available Processing Resources Resource Repository</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTION_REPOSITORY__AVAILABLE_PROCESSING_RESOURCES_RESOURCE_REPOSITORY = eINSTANCE.getResourceDescriptionRepository_AvailableProcessingResources_ResourceRepository();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionImpl <em>Resource Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.ResourceDescriptionImpl
		 * @see de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl#getResourceDescription()
		 * @generated
		 */
		EClass RESOURCE_DESCRIPTION = eINSTANCE.getResourceDescription();

		/**
		 * The meta object literal for the '<em><b>Fixed Processing Resource Cost Resource Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTION__FIXED_PROCESSING_RESOURCE_COST_RESOURCE_DESCRIPTION = eINSTANCE.getResourceDescription_FixedProcessingResourceCost_ResourceDescription();

		/**
		 * The meta object literal for the '<em><b>Processing Resource Specification Resource Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTION__PROCESSING_RESOURCE_SPECIFICATION_RESOURCE_DESCRIPTION = eINSTANCE.getResourceDescription_ProcessingResourceSpecification_ResourceDescription();

	}

} //resourcerepositoryPackage
