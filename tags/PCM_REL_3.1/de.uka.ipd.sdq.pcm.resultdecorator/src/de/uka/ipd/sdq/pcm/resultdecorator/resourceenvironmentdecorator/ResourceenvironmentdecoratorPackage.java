/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface ResourceenvironmentdecoratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resourceenvironmentdecorator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ResultDecorator/ResourceEnvironment/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resourceenvironmentdecorator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceenvironmentdecoratorPackage eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl <em>Utilisation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getUtilisationResult()
	 * @generated
	 */
	int UTILISATION_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATION_RESULT__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATION_RESULT__NORMALISED_DEMANDED_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATION_RESULT__NORMALISED_WAIT_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Utilisation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILISATION_RESULT_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl <em>Linking Resource Results</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getLinkingResourceResults()
	 * @generated
	 */
	int LINKING_RESOURCE_RESULTS = 0;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_RESULTS__ENTITY_NAME = UTILISATION_RESULT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_RESULTS__NORMALISED_RESOURCE_UTILISATION = UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

	/**
	 * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_RESULTS__NORMALISED_DEMANDED_TIME = UTILISATION_RESULT__NORMALISED_DEMANDED_TIME;

	/**
	 * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_RESULTS__NORMALISED_WAIT_TIME = UTILISATION_RESULT__NORMALISED_WAIT_TIME;

	/**
	 * The feature id for the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_RESULTS__LINKINGRESOURCE = UTILISATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linking Resource Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_RESULTS_FEATURE_COUNT = UTILISATION_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl <em>Resource Container Results</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getResourceContainerResults()
	 * @generated
	 */
	int RESOURCE_CONTAINER_RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_RESULTS__ENTITY_NAME = UTILISATION_RESULT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_RESULTS__NORMALISED_RESOURCE_UTILISATION = UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

	/**
	 * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_RESULTS__NORMALISED_DEMANDED_TIME = UTILISATION_RESULT__NORMALISED_DEMANDED_TIME;

	/**
	 * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_RESULTS__NORMALISED_WAIT_TIME = UTILISATION_RESULT__NORMALISED_WAIT_TIME;

	/**
	 * The feature id for the '<em><b>Resourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_RESULTS__RESOURCECONTAINER = UTILISATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Container Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_RESULTS_FEATURE_COUNT = UTILISATION_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl <em>Processing Resource Specification Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getProcessingResourceSpecificationResult()
	 * @generated
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT__ENTITY_NAME = UTILISATION_RESULT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT__NORMALISED_RESOURCE_UTILISATION = UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

	/**
	 * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT__NORMALISED_DEMANDED_TIME = UTILISATION_RESULT__NORMALISED_DEMANDED_TIME;

	/**
	 * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT__NORMALISED_WAIT_TIME = UTILISATION_RESULT__NORMALISED_WAIT_TIME;

	/**
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSINGRESOURCESPECIFICATION = UTILISATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Resource Specification Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_SPECIFICATION_RESULT_FEATURE_COUNT = UTILISATION_RESULT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults <em>Linking Resource Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linking Resource Results</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults
	 * @generated
	 */
	EClass getLinkingResourceResults();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults#getLinkingresource <em>Linkingresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linkingresource</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults#getLinkingresource()
	 * @see #getLinkingResourceResults()
	 * @generated
	 */
	EReference getLinkingResourceResults_Linkingresource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult <em>Utilisation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Utilisation Result</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult
	 * @generated
	 */
	EClass getUtilisationResult();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation <em>Normalised Resource Utilisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Resource Utilisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation()
	 * @see #getUtilisationResult()
	 * @generated
	 */
	EAttribute getUtilisationResult_NormalisedResourceUtilisation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedDemandedTime <em>Normalised Demanded Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Demanded Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedDemandedTime()
	 * @see #getUtilisationResult()
	 * @generated
	 */
	EAttribute getUtilisationResult_NormalisedDemandedTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime <em>Normalised Wait Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Normalised Wait Time</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime()
	 * @see #getUtilisationResult()
	 * @generated
	 */
	EAttribute getUtilisationResult_NormalisedWaitTime();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults <em>Resource Container Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Container Results</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults
	 * @generated
	 */
	EClass getResourceContainerResults();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults#getResourcecontainer <em>Resourcecontainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resourcecontainer</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults#getResourcecontainer()
	 * @see #getResourceContainerResults()
	 * @generated
	 */
	EReference getResourceContainerResults_Resourcecontainer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult <em>Processing Resource Specification Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource Specification Result</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult
	 * @generated
	 */
	EClass getProcessingResourceSpecificationResult();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult#getProcessingresourcespecification <em>Processingresourcespecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcespecification</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult#getProcessingresourcespecification()
	 * @see #getProcessingResourceSpecificationResult()
	 * @generated
	 */
	EReference getProcessingResourceSpecificationResult_Processingresourcespecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceenvironmentdecoratorFactory getResourceenvironmentdecoratorFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl <em>Linking Resource Results</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getLinkingResourceResults()
		 * @generated
		 */
		EClass LINKING_RESOURCE_RESULTS = eINSTANCE.getLinkingResourceResults();

		/**
		 * The meta object literal for the '<em><b>Linkingresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKING_RESOURCE_RESULTS__LINKINGRESOURCE = eINSTANCE.getLinkingResourceResults_Linkingresource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl <em>Utilisation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getUtilisationResult()
		 * @generated
		 */
		EClass UTILISATION_RESULT = eINSTANCE.getUtilisationResult();

		/**
		 * The meta object literal for the '<em><b>Normalised Resource Utilisation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION = eINSTANCE.getUtilisationResult_NormalisedResourceUtilisation();

		/**
		 * The meta object literal for the '<em><b>Normalised Demanded Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILISATION_RESULT__NORMALISED_DEMANDED_TIME = eINSTANCE.getUtilisationResult_NormalisedDemandedTime();

		/**
		 * The meta object literal for the '<em><b>Normalised Wait Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILISATION_RESULT__NORMALISED_WAIT_TIME = eINSTANCE.getUtilisationResult_NormalisedWaitTime();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl <em>Resource Container Results</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getResourceContainerResults()
		 * @generated
		 */
		EClass RESOURCE_CONTAINER_RESULTS = eINSTANCE.getResourceContainerResults();

		/**
		 * The meta object literal for the '<em><b>Resourcecontainer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONTAINER_RESULTS__RESOURCECONTAINER = eINSTANCE.getResourceContainerResults_Resourcecontainer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl <em>Processing Resource Specification Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getProcessingResourceSpecificationResult()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE_SPECIFICATION_RESULT = eINSTANCE.getProcessingResourceSpecificationResult();

		/**
		 * The meta object literal for the '<em><b>Processingresourcespecification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSINGRESOURCESPECIFICATION = eINSTANCE.getProcessingResourceSpecificationResult_Processingresourcespecification();

	}

} //ResourceenvironmentdecoratorPackage
