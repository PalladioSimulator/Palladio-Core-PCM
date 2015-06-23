/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Interface Providing Requiring Entity Results</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.InterfaceProvidingRequiringEntityResultsImpl#getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult
 * <em>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceProvidingRequiringEntityResultsImpl extends ComponentResultImpl
        implements InterfaceProvidingRequiringEntityResults {

    /**
     * The cached value of the '
     * {@link #getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult()
     * <em>Interface Providing Requiring Entity Interface Providing Requiring Entity Result</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult()
     * @generated
     * @ordered
     */
    protected InterfaceProvidingRequiringEntity interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected InterfaceProvidingRequiringEntityResultsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositorydecoratorPackage.Literals.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InterfaceProvidingRequiringEntity getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() {
        if (this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult != null
                && ((EObject) this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult)
                        .eIsProxy()) {
            final InternalEObject oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = (InternalEObject) this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
            this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = (InterfaceProvidingRequiringEntity) this
                    .eResolveProxy(oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult);
            if (this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult != oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT,
                            oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult,
                            this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult));
                }
            }
        }
        return this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InterfaceProvidingRequiringEntity basicGetInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() {
        return this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult(
            final InterfaceProvidingRequiringEntity newInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult) {
        final InterfaceProvidingRequiringEntity oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
        this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult = newInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT,
                    oldInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult,
                    this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
            if (resolve) {
                return this.getInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult();
            }
            return this.basicGetInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
            this.setInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult(
                    (InterfaceProvidingRequiringEntity) newValue);
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
        case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
            this.setInterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult(
                    (InterfaceProvidingRequiringEntity) null);
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
        case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT:
            return this.interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult != null;
        }
        return super.eIsSet(featureID);
    }

} // InterfaceProvidingRequiringEntityResultsImpl
