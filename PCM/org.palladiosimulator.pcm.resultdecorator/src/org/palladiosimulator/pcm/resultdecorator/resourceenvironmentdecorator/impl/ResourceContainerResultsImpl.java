/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Container Results</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl#getResourceContainer_ResourceContainerResults
 * <em>Resource Container Resource Container Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceContainerResultsImpl extends ActiveResourceUtilisationResultImpl
        implements ResourceContainerResults {

    /**
     * The cached value of the '{@link #getResourceContainer_ResourceContainerResults()
     * <em>Resource Container Resource Container Results</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getResourceContainer_ResourceContainerResults()
     * @generated
     * @ordered
     */
    protected ResourceContainer resourceContainer_ResourceContainerResults;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceContainerResultsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentdecoratorPackage.Literals.RESOURCE_CONTAINER_RESULTS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer_ResourceContainerResults() {
        if (this.resourceContainer_ResourceContainerResults != null
                && ((EObject) this.resourceContainer_ResourceContainerResults).eIsProxy()) {
            final InternalEObject oldResourceContainer_ResourceContainerResults = (InternalEObject) this.resourceContainer_ResourceContainerResults;
            this.resourceContainer_ResourceContainerResults = (ResourceContainer) this
                    .eResolveProxy(oldResourceContainer_ResourceContainerResults);
            if (this.resourceContainer_ResourceContainerResults != oldResourceContainer_ResourceContainerResults) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS,
                            oldResourceContainer_ResourceContainerResults,
                            this.resourceContainer_ResourceContainerResults));
                }
            }
        }
        return this.resourceContainer_ResourceContainerResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceContainer basicGetResourceContainer_ResourceContainerResults() {
        return this.resourceContainer_ResourceContainerResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceContainer_ResourceContainerResults(
            final ResourceContainer newResourceContainer_ResourceContainerResults) {
        final ResourceContainer oldResourceContainer_ResourceContainerResults = this.resourceContainer_ResourceContainerResults;
        this.resourceContainer_ResourceContainerResults = newResourceContainer_ResourceContainerResults;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS,
                    oldResourceContainer_ResourceContainerResults, this.resourceContainer_ResourceContainerResults));
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
        case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
            if (resolve) {
                return this.getResourceContainer_ResourceContainerResults();
            }
            return this.basicGetResourceContainer_ResourceContainerResults();
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
        case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
            this.setResourceContainer_ResourceContainerResults((ResourceContainer) newValue);
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
        case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
            this.setResourceContainer_ResourceContainerResults((ResourceContainer) null);
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
        case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
            return this.resourceContainer_ResourceContainerResults != null;
        }
        return super.eIsSet(featureID);
    }

} // ResourceContainerResultsImpl
