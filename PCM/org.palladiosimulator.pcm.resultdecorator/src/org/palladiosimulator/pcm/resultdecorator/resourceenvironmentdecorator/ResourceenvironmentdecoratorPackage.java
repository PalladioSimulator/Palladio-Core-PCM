/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.pcm.core.entity.EntityPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
 *      ResourceenvironmentdecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface ResourceenvironmentdecoratorPackage extends EPackage {

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "resourceenvironmentdecorator";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/PCM/ResultDecorator/ResourceEnvironment/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "resourceenvironmentdecorator";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    ResourceenvironmentdecoratorPackage eINSTANCE = org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl
     * <em>Utilisation Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
     *      UtilisationResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getUtilisationResult()
     * @generated
     */
    int UTILISATION_RESULT = 2;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__NORMALISED_WAIT_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Resource Utilisation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__RESOURCE_UTILISATION = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Average Wait Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__AVERAGE_WAIT_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Average Queue Length</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Max Queue Length</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT__MAX_QUEUE_LENGTH = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Utilisation Result</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int UTILISATION_RESULT_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ActiveResourceUtilisationResultImpl
     * <em>Active Resource Utilisation Result</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
     *      ActiveResourceUtilisationResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getActiveResourceUtilisationResult()
     * @generated
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT = 1;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__ENTITY_NAME = UTILISATION_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION = UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_WAIT_TIME = UTILISATION_RESULT__NORMALISED_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Resource Utilisation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__RESOURCE_UTILISATION = UTILISATION_RESULT__RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Average Wait Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_WAIT_TIME = UTILISATION_RESULT__AVERAGE_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Average Queue Length</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH = UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Max Queue Length</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__MAX_QUEUE_LENGTH = UTILISATION_RESULT__MAX_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME = UTILISATION_RESULT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Demanded Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME = UTILISATION_RESULT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Active Resource Utilisation Result</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT = UTILISATION_RESULT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl
     * <em>Linking Resource Results</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
     *      LinkingResourceResultsImpl
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getLinkingResourceResults()
     * @generated
     */
    int LINKING_RESOURCE_RESULTS = 0;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__ENTITY_NAME = ACTIVE_RESOURCE_UTILISATION_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__NORMALISED_RESOURCE_UTILISATION = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__NORMALISED_WAIT_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Resource Utilisation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__RESOURCE_UTILISATION = ACTIVE_RESOURCE_UTILISATION_RESULT__RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Average Wait Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__AVERAGE_WAIT_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Average Queue Length</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__AVERAGE_QUEUE_LENGTH = ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Max Queue Length</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__MAX_QUEUE_LENGTH = ACTIVE_RESOURCE_UTILISATION_RESULT__MAX_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__NORMALISED_DEMANDED_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME;

    /**
     * The feature id for the '<em><b>Demanded Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__DEMANDED_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME;

    /**
     * The feature id for the '<em><b>Linking Resource Linking Resource Results</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS = ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Linking Resource Results</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int LINKING_RESOURCE_RESULTS_FEATURE_COUNT = ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl
     * <em>Resource Container Results</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
     *      ResourceContainerResultsImpl
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getResourceContainerResults()
     * @generated
     */
    int RESOURCE_CONTAINER_RESULTS = 3;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__ENTITY_NAME = ACTIVE_RESOURCE_UTILISATION_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__NORMALISED_RESOURCE_UTILISATION = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__NORMALISED_WAIT_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Resource Utilisation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__RESOURCE_UTILISATION = ACTIVE_RESOURCE_UTILISATION_RESULT__RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Average Wait Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__AVERAGE_WAIT_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Average Queue Length</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__AVERAGE_QUEUE_LENGTH = ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Max Queue Length</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__MAX_QUEUE_LENGTH = ACTIVE_RESOURCE_UTILISATION_RESULT__MAX_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__NORMALISED_DEMANDED_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME;

    /**
     * The feature id for the '<em><b>Demanded Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__DEMANDED_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME;

    /**
     * The feature id for the '<em><b>Resource Container Resource Container Results</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS = ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Resource Container Results</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESOURCE_CONTAINER_RESULTS_FEATURE_COUNT = ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl
     * <em>Processing Resource Specification Result</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
     *      ProcessingResourceSpecificationResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getProcessingResourceSpecificationResult()
     * @generated
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT = 4;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__ENTITY_NAME = ACTIVE_RESOURCE_UTILISATION_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__NORMALISED_RESOURCE_UTILISATION = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__NORMALISED_WAIT_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Resource Utilisation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__RESOURCE_UTILISATION = ACTIVE_RESOURCE_UTILISATION_RESULT__RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Average Wait Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__AVERAGE_WAIT_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Average Queue Length</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__AVERAGE_QUEUE_LENGTH = ACTIVE_RESOURCE_UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Max Queue Length</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__MAX_QUEUE_LENGTH = ACTIVE_RESOURCE_UTILISATION_RESULT__MAX_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Normalised Demanded Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__NORMALISED_DEMANDED_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME;

    /**
     * The feature id for the '<em><b>Demanded Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__DEMANDED_TIME = ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME;

    /**
     * The feature id for the '
     * <em><b>Processing Resource Specification Processing Resource Specification Result</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT = ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '<em>Processing Resource Specification Result</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PROCESSING_RESOURCE_SPECIFICATION_RESULT_FEATURE_COUNT = ACTIVE_RESOURCE_UTILISATION_RESULT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl
     * <em>Passive Resource Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
     *      PassiveResourceResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getPassiveResourceResult()
     * @generated
     */
    int PASSIVE_RESOURCE_RESULT = 5;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__ENTITY_NAME = UTILISATION_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Utilisation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__NORMALISED_RESOURCE_UTILISATION = UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Normalised Wait Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__NORMALISED_WAIT_TIME = UTILISATION_RESULT__NORMALISED_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Resource Utilisation</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__RESOURCE_UTILISATION = UTILISATION_RESULT__RESOURCE_UTILISATION;

    /**
     * The feature id for the '<em><b>Average Wait Time</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__AVERAGE_WAIT_TIME = UTILISATION_RESULT__AVERAGE_WAIT_TIME;

    /**
     * The feature id for the '<em><b>Average Queue Length</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__AVERAGE_QUEUE_LENGTH = UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Max Queue Length</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__MAX_QUEUE_LENGTH = UTILISATION_RESULT__MAX_QUEUE_LENGTH;

    /**
     * The feature id for the '<em><b>Passive Resource Passive Resource Result</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT = UTILISATION_RESULT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Assembly Context Passive Resource Result</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT = UTILISATION_RESULT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Average Holding Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME = UTILISATION_RESULT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Passive Resource Result</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PASSIVE_RESOURCE_RESULT_FEATURE_COUNT = UTILISATION_RESULT_FEATURE_COUNT + 3;

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults
     * <em>Linking Resource Results</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Linking Resource Results</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      LinkingResourceResults
     * @generated
     */
    EClass getLinkingResourceResults();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults#getLinkingResource_LinkingResourceResults
     * <em>Linking Resource Linking Resource Results</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '<em>Linking Resource Linking Resource Results</em>
     *         '.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults#getLinkingResource_LinkingResourceResults()
     * @see #getLinkingResourceResults()
     * @generated
     */
    EReference getLinkingResourceResults_LinkingResource_LinkingResourceResults();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult
     * <em>Active Resource Utilisation Result</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Active Resource Utilisation Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      ActiveResourceUtilisationResult
     * @generated
     */
    EClass getActiveResourceUtilisationResult();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getNormalisedDemandedTime
     * <em>Normalised Demanded Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Normalised Demanded Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getNormalisedDemandedTime()
     * @see #getActiveResourceUtilisationResult()
     * @generated
     */
    EAttribute getActiveResourceUtilisationResult_NormalisedDemandedTime();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getDemandedTime
     * <em>Demanded Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Demanded Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult#getDemandedTime()
     * @see #getActiveResourceUtilisationResult()
     * @generated
     */
    EAttribute getActiveResourceUtilisationResult_DemandedTime();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult
     * <em>Utilisation Result</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Utilisation Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult
     * @generated
     */
    EClass getUtilisationResult();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation
     * <em>Normalised Resource Utilisation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Normalised Resource Utilisation</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedResourceUtilisation()
     * @see #getUtilisationResult()
     * @generated
     */
    EAttribute getUtilisationResult_NormalisedResourceUtilisation();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime
     * <em>Normalised Wait Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Normalised Wait Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getNormalisedWaitTime()
     * @see #getUtilisationResult()
     * @generated
     */
    EAttribute getUtilisationResult_NormalisedWaitTime();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getResourceUtilisation
     * <em>Resource Utilisation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Resource Utilisation</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getResourceUtilisation()
     * @see #getUtilisationResult()
     * @generated
     */
    EAttribute getUtilisationResult_ResourceUtilisation();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageWaitTime
     * <em>Average Wait Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Average Wait Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageWaitTime()
     * @see #getUtilisationResult()
     * @generated
     */
    EAttribute getUtilisationResult_AverageWaitTime();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageQueueLength
     * <em>Average Queue Length</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Average Queue Length</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getAverageQueueLength()
     * @see #getUtilisationResult()
     * @generated
     */
    EAttribute getUtilisationResult_AverageQueueLength();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getMaxQueueLength
     * <em>Max Queue Length</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Max Queue Length</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult#getMaxQueueLength()
     * @see #getUtilisationResult()
     * @generated
     */
    EAttribute getUtilisationResult_MaxQueueLength();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults
     * <em>Resource Container Results</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Resource Container Results</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      ResourceContainerResults
     * @generated
     */
    EClass getResourceContainerResults();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults#getResourceContainer_ResourceContainerResults
     * <em>Resource Container Resource Container Results</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '
     *         <em>Resource Container Resource Container Results</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults#getResourceContainer_ResourceContainerResults()
     * @see #getResourceContainerResults()
     * @generated
     */
    EReference getResourceContainerResults_ResourceContainer_ResourceContainerResults();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult
     * <em>Processing Resource Specification Result</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Processing Resource Specification Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      ProcessingResourceSpecificationResult
     * @generated
     */
    EClass getProcessingResourceSpecificationResult();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult#getProcessingResourceSpecification_ProcessingResourceSpecificationResult
     * <em>Processing Resource Specification Processing Resource Specification Result</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '
     *         <em>Processing Resource Specification Processing Resource Specification Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult#getProcessingResourceSpecification_ProcessingResourceSpecificationResult()
     * @see #getProcessingResourceSpecificationResult()
     * @generated
     */
    EReference getProcessingResourceSpecificationResult_ProcessingResourceSpecification_ProcessingResourceSpecificationResult();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult
     * <em>Passive Resource Result</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Passive Resource Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
     *      PassiveResourceResult
     * @generated
     */
    EClass getPassiveResourceResult();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getPassiveResource_PassiveResourceResult
     * <em>Passive Resource Passive Resource Result</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '<em>Passive Resource Passive Resource Result</em>
     *         '.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getPassiveResource_PassiveResourceResult()
     * @see #getPassiveResourceResult()
     * @generated
     */
    EReference getPassiveResourceResult_PassiveResource_PassiveResourceResult();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAssemblyContext_PassiveResourceResult
     * <em>Assembly Context Passive Resource Result</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '<em>Assembly Context Passive Resource Result</em>
     *         '.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAssemblyContext_PassiveResourceResult()
     * @see #getPassiveResourceResult()
     * @generated
     */
    EReference getPassiveResourceResult_AssemblyContext_PassiveResourceResult();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAverageHoldingTime
     * <em>Average Holding Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Average Holding Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult#getAverageHoldingTime()
     * @see #getPassiveResourceResult()
     * @generated
     */
    EAttribute getPassiveResourceResult_AverageHoldingTime();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ResourceenvironmentdecoratorFactory getResourceenvironmentdecoratorFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     *
     * @generated
     */
    interface Literals {

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl
         * <em>Linking Resource Results</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
         *      LinkingResourceResultsImpl
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getLinkingResourceResults()
         * @generated
         */
        EClass LINKING_RESOURCE_RESULTS = eINSTANCE.getLinkingResourceResults();

        /**
         * The meta object literal for the '
         * <em><b>Linking Resource Linking Resource Results</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS = eINSTANCE
                .getLinkingResourceResults_LinkingResource_LinkingResourceResults();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ActiveResourceUtilisationResultImpl
         * <em>Active Resource Utilisation Result</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
         *      ActiveResourceUtilisationResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getActiveResourceUtilisationResult()
         * @generated
         */
        EClass ACTIVE_RESOURCE_UTILISATION_RESULT = eINSTANCE.getActiveResourceUtilisationResult();

        /**
         * The meta object literal for the '<em><b>Normalised Demanded Time</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME = eINSTANCE
                .getActiveResourceUtilisationResult_NormalisedDemandedTime();

        /**
         * The meta object literal for the '<em><b>Demanded Time</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME = eINSTANCE
                .getActiveResourceUtilisationResult_DemandedTime();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl
         * <em>Utilisation Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
         *      UtilisationResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getUtilisationResult()
         * @generated
         */
        EClass UTILISATION_RESULT = eINSTANCE.getUtilisationResult();

        /**
         * The meta object literal for the '<em><b>Normalised Resource Utilisation</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION = eINSTANCE
                .getUtilisationResult_NormalisedResourceUtilisation();

        /**
         * The meta object literal for the '<em><b>Normalised Wait Time</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute UTILISATION_RESULT__NORMALISED_WAIT_TIME = eINSTANCE.getUtilisationResult_NormalisedWaitTime();

        /**
         * The meta object literal for the '<em><b>Resource Utilisation</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute UTILISATION_RESULT__RESOURCE_UTILISATION = eINSTANCE.getUtilisationResult_ResourceUtilisation();

        /**
         * The meta object literal for the '<em><b>Average Wait Time</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute UTILISATION_RESULT__AVERAGE_WAIT_TIME = eINSTANCE.getUtilisationResult_AverageWaitTime();

        /**
         * The meta object literal for the '<em><b>Average Queue Length</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH = eINSTANCE.getUtilisationResult_AverageQueueLength();

        /**
         * The meta object literal for the '<em><b>Max Queue Length</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute UTILISATION_RESULT__MAX_QUEUE_LENGTH = eINSTANCE.getUtilisationResult_MaxQueueLength();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl
         * <em>Resource Container Results</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
         *      ResourceContainerResultsImpl
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getResourceContainerResults()
         * @generated
         */
        EClass RESOURCE_CONTAINER_RESULTS = eINSTANCE.getResourceContainerResults();

        /**
         * The meta object literal for the '
         * <em><b>Resource Container Resource Container Results</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS = eINSTANCE
                .getResourceContainerResults_ResourceContainer_ResourceContainerResults();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl
         * <em>Processing Resource Specification Result</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
         *      ProcessingResourceSpecificationResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getProcessingResourceSpecificationResult()
         * @generated
         */
        EClass PROCESSING_RESOURCE_SPECIFICATION_RESULT = eINSTANCE.getProcessingResourceSpecificationResult();

        /**
         * The meta object literal for the '
         * <em><b>Processing Resource Specification Processing Resource Specification Result</b></em>
         * ' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT = eINSTANCE
                .getProcessingResourceSpecificationResult_ProcessingResourceSpecification_ProcessingResourceSpecificationResult();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl
         * <em>Passive Resource Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.
         *      PassiveResourceResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl#getPassiveResourceResult()
         * @generated
         */
        EClass PASSIVE_RESOURCE_RESULT = eINSTANCE.getPassiveResourceResult();

        /**
         * The meta object literal for the '<em><b>Passive Resource Passive Resource Result</b></em>
         * ' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT = eINSTANCE
                .getPassiveResourceResult_PassiveResource_PassiveResourceResult();

        /**
         * The meta object literal for the '<em><b>Assembly Context Passive Resource Result</b></em>
         * ' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT = eINSTANCE
                .getPassiveResourceResult_AssemblyContext_PassiveResourceResult();

        /**
         * The meta object literal for the '<em><b>Average Holding Time</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME = eINSTANCE
                .getPassiveResourceResult_AverageHoldingTime();

    }

} // ResourceenvironmentdecoratorPackage
