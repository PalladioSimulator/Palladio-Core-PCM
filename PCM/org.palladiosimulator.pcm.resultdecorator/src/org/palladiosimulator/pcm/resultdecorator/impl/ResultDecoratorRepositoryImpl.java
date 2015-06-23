/**
 */
package org.palladiosimulator.pcm.resultdecorator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository;
import org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import org.palladiosimulator.pcm.core.entity.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Result Decorator Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getComponentResults_ResultDecoratorRepository
 * <em>Component Results Result Decorator Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getUtilisationResults_ResultDecoratorRepository
 * <em>Utilisation Results Result Decorator Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getServiceResult_ResultDecoratorRepository
 * <em>Service Result Result Decorator Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultDecoratorRepositoryImpl extends NamedElementImpl implements ResultDecoratorRepository {

    /**
     * The cached value of the '{@link #getComponentResults_ResultDecoratorRepository()
     * <em>Component Results Result Decorator Repository</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComponentResults_ResultDecoratorRepository()
     * @generated
     * @ordered
     */
    protected EList<ComponentResult> componentResults_ResultDecoratorRepository;

    /**
     * The cached value of the '{@link #getUtilisationResults_ResultDecoratorRepository()
     * <em>Utilisation Results Result Decorator Repository</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getUtilisationResults_ResultDecoratorRepository()
     * @generated
     * @ordered
     */
    protected EList<UtilisationResult> utilisationResults_ResultDecoratorRepository;

    /**
     * The cached value of the '{@link #getServiceResult_ResultDecoratorRepository()
     * <em>Service Result Result Decorator Repository</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getServiceResult_ResultDecoratorRepository()
     * @generated
     * @ordered
     */
    protected EList<ServiceResult> serviceResult_ResultDecoratorRepository;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResultDecoratorRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ComponentResult> getComponentResults_ResultDecoratorRepository() {
        if (this.componentResults_ResultDecoratorRepository == null) {
            this.componentResults_ResultDecoratorRepository = new EObjectContainmentEList<ComponentResult>(
                    ComponentResult.class, this,
                    ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY);
        }
        return this.componentResults_ResultDecoratorRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<UtilisationResult> getUtilisationResults_ResultDecoratorRepository() {
        if (this.utilisationResults_ResultDecoratorRepository == null) {
            this.utilisationResults_ResultDecoratorRepository = new EObjectContainmentEList<UtilisationResult>(
                    UtilisationResult.class, this,
                    ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY);
        }
        return this.utilisationResults_ResultDecoratorRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ServiceResult> getServiceResult_ResultDecoratorRepository() {
        if (this.serviceResult_ResultDecoratorRepository == null) {
            this.serviceResult_ResultDecoratorRepository = new EObjectContainmentEList<ServiceResult>(
                    ServiceResult.class, this,
                    ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY);
        }
        return this.serviceResult_ResultDecoratorRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
            return ((InternalEList<?>) this.getComponentResults_ResultDecoratorRepository()).basicRemove(otherEnd,
                    msgs);
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
            return ((InternalEList<?>) this.getUtilisationResults_ResultDecoratorRepository()).basicRemove(otherEnd,
                    msgs);
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
            return ((InternalEList<?>) this.getServiceResult_ResultDecoratorRepository()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
            return this.getComponentResults_ResultDecoratorRepository();
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
            return this.getUtilisationResults_ResultDecoratorRepository();
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
            return this.getServiceResult_ResultDecoratorRepository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
            this.getComponentResults_ResultDecoratorRepository().clear();
            this.getComponentResults_ResultDecoratorRepository()
                    .addAll((Collection<? extends ComponentResult>) newValue);
            return;
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
            this.getUtilisationResults_ResultDecoratorRepository().clear();
            this.getUtilisationResults_ResultDecoratorRepository()
                    .addAll((Collection<? extends UtilisationResult>) newValue);
            return;
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
            this.getServiceResult_ResultDecoratorRepository().clear();
            this.getServiceResult_ResultDecoratorRepository().addAll((Collection<? extends ServiceResult>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
            this.getComponentResults_ResultDecoratorRepository().clear();
            return;
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
            this.getUtilisationResults_ResultDecoratorRepository().clear();
            return;
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
            this.getServiceResult_ResultDecoratorRepository().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
            return this.componentResults_ResultDecoratorRepository != null
                    && !this.componentResults_ResultDecoratorRepository.isEmpty();
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
            return this.utilisationResults_ResultDecoratorRepository != null
                    && !this.utilisationResults_ResultDecoratorRepository.isEmpty();
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
            return this.serviceResult_ResultDecoratorRepository != null
                    && !this.serviceResult_ResultDecoratorRepository.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ResultDecoratorRepositoryImpl
