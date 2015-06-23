/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Linking Resource Results</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl#getLinkingResource_LinkingResourceResults
 * <em>Linking Resource Linking Resource Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkingResourceResultsImpl extends ActiveResourceUtilisationResultImpl implements LinkingResourceResults {

    /**
     * The cached value of the '{@link #getLinkingResource_LinkingResourceResults()
     * <em>Linking Resource Linking Resource Results</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getLinkingResource_LinkingResourceResults()
     * @generated
     * @ordered
     */
    protected LinkingResource linkingResource_LinkingResourceResults;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected LinkingResourceResultsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentdecoratorPackage.Literals.LINKING_RESOURCE_RESULTS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LinkingResource getLinkingResource_LinkingResourceResults() {
        if (this.linkingResource_LinkingResourceResults != null
                && ((EObject) this.linkingResource_LinkingResourceResults).eIsProxy()) {
            final InternalEObject oldLinkingResource_LinkingResourceResults = (InternalEObject) this.linkingResource_LinkingResourceResults;
            this.linkingResource_LinkingResourceResults = (LinkingResource) this
                    .eResolveProxy(oldLinkingResource_LinkingResourceResults);
            if (this.linkingResource_LinkingResourceResults != oldLinkingResource_LinkingResourceResults) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS,
                            oldLinkingResource_LinkingResourceResults, this.linkingResource_LinkingResourceResults));
                }
            }
        }
        return this.linkingResource_LinkingResourceResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public LinkingResource basicGetLinkingResource_LinkingResourceResults() {
        return this.linkingResource_LinkingResourceResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLinkingResource_LinkingResourceResults(
            final LinkingResource newLinkingResource_LinkingResourceResults) {
        final LinkingResource oldLinkingResource_LinkingResourceResults = this.linkingResource_LinkingResourceResults;
        this.linkingResource_LinkingResourceResults = newLinkingResource_LinkingResourceResults;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS,
                    oldLinkingResource_LinkingResourceResults, this.linkingResource_LinkingResourceResults));
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
        case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
            if (resolve) {
                return this.getLinkingResource_LinkingResourceResults();
            }
            return this.basicGetLinkingResource_LinkingResourceResults();
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
        case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
            this.setLinkingResource_LinkingResourceResults((LinkingResource) newValue);
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
        case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
            this.setLinkingResource_LinkingResourceResults((LinkingResource) null);
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
        case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
            return this.linkingResource_LinkingResourceResults != null;
        }
        return super.eIsSet(featureID);
    }

} // LinkingResourceResultsImpl
