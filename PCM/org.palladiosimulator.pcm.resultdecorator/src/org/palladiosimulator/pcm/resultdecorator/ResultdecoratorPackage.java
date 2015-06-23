/**
 */
package org.palladiosimulator.pcm.resultdecorator;

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
 * @see org.palladiosimulator.pcm.resultdecorator.ResultdecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface ResultdecoratorPackage extends EPackage {

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "resultdecorator";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/PCM/ResultDecorator/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "resultdecorator";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    ResultdecoratorPackage eINSTANCE = org.palladiosimulator.pcm.resultdecorator.impl.ResultdecoratorPackageImpl.init();

    /**
     * The meta object id for the '
     * {@link org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl
     * <em>Result Decorator Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl
     * @see org.palladiosimulator.pcm.resultdecorator.impl.ResultdecoratorPackageImpl#getResultDecoratorRepository()
     * @generated
     */
    int RESULT_DECORATOR_REPOSITORY = 0;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESULT_DECORATOR_REPOSITORY__ENTITY_NAME = EntityPackage.NAMED_ELEMENT__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Component Results Result Decorator Repository</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Utilisation Results Result Decorator Repository</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT
            + 1;

    /**
     * The feature id for the '<em><b>Service Result Result Decorator Repository</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT
            + 2;

    /**
     * The number of structural features of the '<em>Result Decorator Repository</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RESULT_DECORATOR_REPOSITORY_FEATURE_COUNT = EntityPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * Returns the meta object for class '
     * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository
     * <em>Result Decorator Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Result Decorator Repository</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository
     * @generated
     */
    EClass getResultDecoratorRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getComponentResults_ResultDecoratorRepository
     * <em>Component Results Result Decorator Repository</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     *         <em>Component Results Result Decorator Repository</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getComponentResults_ResultDecoratorRepository()
     * @see #getResultDecoratorRepository()
     * @generated
     */
    EReference getResultDecoratorRepository_ComponentResults_ResultDecoratorRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationResults_ResultDecoratorRepository
     * <em>Utilisation Results Result Decorator Repository</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     *         <em>Utilisation Results Result Decorator Repository</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationResults_ResultDecoratorRepository()
     * @see #getResultDecoratorRepository()
     * @generated
     */
    EReference getResultDecoratorRepository_UtilisationResults_ResultDecoratorRepository();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getServiceResult_ResultDecoratorRepository
     * <em>Service Result Result Decorator Repository</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the containment reference list '
     *         <em>Service Result Result Decorator Repository</em>'.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getServiceResult_ResultDecoratorRepository()
     * @see #getResultDecoratorRepository()
     * @generated
     */
    EReference getResultDecoratorRepository_ServiceResult_ResultDecoratorRepository();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ResultdecoratorFactory getResultdecoratorFactory();

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
         * {@link org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl
         * <em>Result Decorator Repository</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl
         * @see org.palladiosimulator.pcm.resultdecorator.impl.ResultdecoratorPackageImpl#getResultDecoratorRepository()
         * @generated
         */
        EClass RESULT_DECORATOR_REPOSITORY = eINSTANCE.getResultDecoratorRepository();

        /**
         * The meta object literal for the '
         * <em><b>Component Results Result Decorator Repository</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY = eINSTANCE
                .getResultDecoratorRepository_ComponentResults_ResultDecoratorRepository();

        /**
         * The meta object literal for the '
         * <em><b>Utilisation Results Result Decorator Repository</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY = eINSTANCE
                .getResultDecoratorRepository_UtilisationResults_ResultDecoratorRepository();

        /**
         * The meta object literal for the '
         * <em><b>Service Result Result Decorator Repository</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY = eINSTANCE
                .getResultDecoratorRepository_ServiceResult_ResultDecoratorRepository();

    }

} // ResultdecoratorPackage
