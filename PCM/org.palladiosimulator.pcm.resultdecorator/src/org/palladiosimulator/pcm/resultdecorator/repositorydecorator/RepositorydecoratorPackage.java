/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator;

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
 * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface RepositorydecoratorPackage extends EPackage {

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "repositorydecorator";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/PCM/ResultDecorator/Repository/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "repositorydecorator";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    RepositorydecoratorPackage eINSTANCE = org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl
     * <em>Component Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getComponentResult()
     * @generated
     */
    int COMPONENT_RESULT = 1;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT__NORMALISED_RESPONSE_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Average Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Mean Response Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT__MEAN_RESPONSE_TIME = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Average Number Of Sent Messages</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Component Result</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int COMPONENT_RESULT_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl
     * <em>Interface Providing Requiring Entity Results</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
     *      InterfaceProvidingRequiringEntityResultsImpl
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getInterfaceProvidingRequiringEntityResults()
     * @generated
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS = 0;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__ENTITY_NAME = COMPONENT_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESOURCE_DEMAND = COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND;

    /**
     * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__NORMALISED_RESPONSE_TIME = COMPONENT_RESULT__NORMALISED_RESPONSE_TIME;

    /**
     * The feature id for the '<em><b>Average Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__AVERAGE_RESOURCE_DEMAND = COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND;

    /**
     * The feature id for the '<em><b>Mean Response Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__MEAN_RESPONSE_TIME = COMPONENT_RESULT__MEAN_RESPONSE_TIME;

    /**
     * The feature id for the '<em><b>Average Number Of Sent Messages</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__AVERAGE_NUMBER_OF_SENT_MESSAGES = COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES;

    /**
     * The feature id for the '
     * <em><b>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</b></em>
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT = COMPONENT_RESULT_FEATURE_COUNT
            + 0;

    /**
     * The number of structural features of the '
     * <em>Interface Providing Requiring Entity Results</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS_FEATURE_COUNT = COMPONENT_RESULT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl
     * <em>Allocation Context Results</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
     *      AllocationContextResultsImpl
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getAllocationContextResults()
     * @generated
     */
    int ALLOCATION_CONTEXT_RESULTS = 2;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__ENTITY_NAME = COMPONENT_RESULT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Normalised Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__NORMALISED_RESOURCE_DEMAND = COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND;

    /**
     * The feature id for the '<em><b>Normalised Response Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__NORMALISED_RESPONSE_TIME = COMPONENT_RESULT__NORMALISED_RESPONSE_TIME;

    /**
     * The feature id for the '<em><b>Average Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__AVERAGE_RESOURCE_DEMAND = COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND;

    /**
     * The feature id for the '<em><b>Mean Response Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__MEAN_RESPONSE_TIME = COMPONENT_RESULT__MEAN_RESPONSE_TIME;

    /**
     * The feature id for the '<em><b>Average Number Of Sent Messages</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__AVERAGE_NUMBER_OF_SENT_MESSAGES = COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES;

    /**
     * The feature id for the '<em><b>Allocation Context Allocation Context Result</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT = COMPONENT_RESULT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Allocation Context Results</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_CONTEXT_RESULTS_FEATURE_COUNT = COMPONENT_RESULT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl
     * <em>Service Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getServiceResult()
     * @generated
     */
    int SERVICE_RESULT = 3;

    /**
     * The feature id for the '<em><b>Mean Response Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SERVICE_RESULT__MEAN_RESPONSE_TIME = 0;

    /**
     * The feature id for the '<em><b>Throughput</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SERVICE_RESULT__THROUGHPUT = 1;

    /**
     * The feature id for the '<em><b>Service Effect Specification Service Result</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT = 2;

    /**
     * The number of structural features of the '<em>Service Result</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SERVICE_RESULT_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.AllocationServiceResultImpl
     * <em>Allocation Service Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
     *      AllocationServiceResultImpl
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getAllocationServiceResult()
     * @generated
     */
    int ALLOCATION_SERVICE_RESULT = 4;

    /**
     * The feature id for the '<em><b>Mean Response Time</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_SERVICE_RESULT__MEAN_RESPONSE_TIME = SERVICE_RESULT__MEAN_RESPONSE_TIME;

    /**
     * The feature id for the '<em><b>Throughput</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_SERVICE_RESULT__THROUGHPUT = SERVICE_RESULT__THROUGHPUT;

    /**
     * The feature id for the '<em><b>Service Effect Specification Service Result</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT = SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT;

    /**
     * The feature id for the '<em><b>Allocation Context Allocation Service Result</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT = SERVICE_RESULT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Allocation Service Result</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ALLOCATION_SERVICE_RESULT_FEATURE_COUNT = SERVICE_RESULT_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults
     * <em>Interface Providing Requiring Entity Results</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Interface Providing Requiring Entity Results</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.
     *      InterfaceProvidingRequiringEntityResults
     * @generated
     */
    EClass getInterfaceProvidingRequiringEntityResults();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults#getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult
     * <em>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '
     *         <em>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</em>
     *         '.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults#getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult()
     * @see #getInterfaceProvidingRequiringEntityResults()
     * @generated
     */
    EReference getInterfaceProvidingRequiringEntityResults_InterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult
     * <em>Component Result</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Component Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult
     * @generated
     */
    EClass getComponentResult();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResourceDemand
     * <em>Normalised Resource Demand</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Normalised Resource Demand</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResourceDemand()
     * @see #getComponentResult()
     * @generated
     */
    EAttribute getComponentResult_NormalisedResourceDemand();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResponseTime
     * <em>Normalised Response Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Normalised Response Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getNormalisedResponseTime()
     * @see #getComponentResult()
     * @generated
     */
    EAttribute getComponentResult_NormalisedResponseTime();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageResourceDemand
     * <em>Average Resource Demand</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Average Resource Demand</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageResourceDemand()
     * @see #getComponentResult()
     * @generated
     */
    EAttribute getComponentResult_AverageResourceDemand();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getMeanResponseTime
     * <em>Mean Response Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Mean Response Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getMeanResponseTime()
     * @see #getComponentResult()
     * @generated
     */
    EAttribute getComponentResult_MeanResponseTime();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageNumberOfSentMessages
     * <em>Average Number Of Sent Messages</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Average Number Of Sent Messages</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult#getAverageNumberOfSentMessages()
     * @see #getComponentResult()
     * @generated
     */
    EAttribute getComponentResult_AverageNumberOfSentMessages();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults
     * <em>Allocation Context Results</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Allocation Context Results</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults
     * @generated
     */
    EClass getAllocationContextResults();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults#getAllocationContext_AllocationContextResult
     * <em>Allocation Context Allocation Context Result</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '
     *         <em>Allocation Context Allocation Context Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults#getAllocationContext_AllocationContextResult()
     * @see #getAllocationContextResults()
     * @generated
     */
    EReference getAllocationContextResults_AllocationContext_AllocationContextResult();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult
     * <em>Service Result</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Service Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult
     * @generated
     */
    EClass getServiceResult();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getMeanResponseTime
     * <em>Mean Response Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Mean Response Time</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getMeanResponseTime()
     * @see #getServiceResult()
     * @generated
     */
    EAttribute getServiceResult_MeanResponseTime();

    /**
     * Returns the meta object for the attribute '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getThroughput
     * <em>Throughput</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Throughput</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getThroughput()
     * @see #getServiceResult()
     * @generated
     */
    EAttribute getServiceResult_Throughput();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getServiceEffectSpecification_ServiceResult
     * <em>Service Effect Specification Service Result</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '
     *         <em>Service Effect Specification Service Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult#getServiceEffectSpecification_ServiceResult()
     * @see #getServiceResult()
     * @generated
     */
    EReference getServiceResult_ServiceEffectSpecification_ServiceResult();

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult
     * <em>Allocation Service Result</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Allocation Service Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult
     * @generated
     */
    EClass getAllocationServiceResult();

    /**
     * Returns the meta object for the reference '
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult#getAllocationContext_AllocationServiceResult
     * <em>Allocation Context Allocation Service Result</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the reference '
     *         <em>Allocation Context Allocation Service Result</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult#getAllocationContext_AllocationServiceResult()
     * @see #getAllocationServiceResult()
     * @generated
     */
    EReference getAllocationServiceResult_AllocationContext_AllocationServiceResult();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RepositorydecoratorFactory getRepositorydecoratorFactory();

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
         * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl
         * <em>Interface Providing Requiring Entity Results</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
         *      InterfaceProvidingRequiringEntityResultsImpl
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getInterfaceProvidingRequiringEntityResults()
         * @generated
         */
        EClass INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS = eINSTANCE.getInterfaceProvidingRequiringEntityResults();

        /**
         * The meta object literal for the '
         * <em><b>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</b></em>
         * ' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT = eINSTANCE
                .getInterfaceProvidingRequiringEntityResults_InterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl
         * <em>Component Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
         *      ComponentResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getComponentResult()
         * @generated
         */
        EClass COMPONENT_RESULT = eINSTANCE.getComponentResult();

        /**
         * The meta object literal for the '<em><b>Normalised Resource Demand</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND = eINSTANCE
                .getComponentResult_NormalisedResourceDemand();

        /**
         * The meta object literal for the '<em><b>Normalised Response Time</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COMPONENT_RESULT__NORMALISED_RESPONSE_TIME = eINSTANCE.getComponentResult_NormalisedResponseTime();

        /**
         * The meta object literal for the '<em><b>Average Resource Demand</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND = eINSTANCE.getComponentResult_AverageResourceDemand();

        /**
         * The meta object literal for the '<em><b>Mean Response Time</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COMPONENT_RESULT__MEAN_RESPONSE_TIME = eINSTANCE.getComponentResult_MeanResponseTime();

        /**
         * The meta object literal for the '<em><b>Average Number Of Sent Messages</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES = eINSTANCE
                .getComponentResult_AverageNumberOfSentMessages();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl
         * <em>Allocation Context Results</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
         *      AllocationContextResultsImpl
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getAllocationContextResults()
         * @generated
         */
        EClass ALLOCATION_CONTEXT_RESULTS = eINSTANCE.getAllocationContextResults();

        /**
         * The meta object literal for the '
         * <em><b>Allocation Context Allocation Context Result</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT = eINSTANCE
                .getAllocationContextResults_AllocationContext_AllocationContextResult();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl
         * <em>Service Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getServiceResult()
         * @generated
         */
        EClass SERVICE_RESULT = eINSTANCE.getServiceResult();

        /**
         * The meta object literal for the '<em><b>Mean Response Time</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute SERVICE_RESULT__MEAN_RESPONSE_TIME = eINSTANCE.getServiceResult_MeanResponseTime();

        /**
         * The meta object literal for the '<em><b>Throughput</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute SERVICE_RESULT__THROUGHPUT = eINSTANCE.getServiceResult_Throughput();

        /**
         * The meta object literal for the '
         * <em><b>Service Effect Specification Service Result</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT = eINSTANCE
                .getServiceResult_ServiceEffectSpecification_ServiceResult();

        /**
         * The meta object literal for the '
         * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.AllocationServiceResultImpl
         * <em>Allocation Service Result</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.
         *      AllocationServiceResultImpl
         * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl#getAllocationServiceResult()
         * @generated
         */
        EClass ALLOCATION_SERVICE_RESULT = eINSTANCE.getAllocationServiceResult();

        /**
         * The meta object literal for the '
         * <em><b>Allocation Context Allocation Service Result</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT = eINSTANCE
                .getAllocationServiceResult_AllocationContext_AllocationServiceResult();

    }

} // RepositorydecoratorPackage
