/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Processing Resource Specification Result</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl#getProcessingResourceSpecification_ProcessingResourceSpecificationResult
 * <em>Processing Resource Specification Processing Resource Specification Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessingResourceSpecificationResultImpl extends ActiveResourceUtilisationResultImpl
        implements ProcessingResourceSpecificationResult {

    /**
     * The cached value of the '
     * {@link #getProcessingResourceSpecification_ProcessingResourceSpecificationResult()
     * <em>Processing Resource Specification Processing Resource Specification Result</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProcessingResourceSpecification_ProcessingResourceSpecificationResult()
     * @generated
     * @ordered
     */
    protected ProcessingResourceSpecification processingResourceSpecification_ProcessingResourceSpecificationResult;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ProcessingResourceSpecificationResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentdecoratorPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProcessingResourceSpecification getProcessingResourceSpecification_ProcessingResourceSpecificationResult() {
        if (this.processingResourceSpecification_ProcessingResourceSpecificationResult != null
                && ((EObject) this.processingResourceSpecification_ProcessingResourceSpecificationResult).eIsProxy()) {
            final InternalEObject oldProcessingResourceSpecification_ProcessingResourceSpecificationResult = (InternalEObject) this.processingResourceSpecification_ProcessingResourceSpecificationResult;
            this.processingResourceSpecification_ProcessingResourceSpecificationResult = (ProcessingResourceSpecification) this
                    .eResolveProxy(oldProcessingResourceSpecification_ProcessingResourceSpecificationResult);
            if (this.processingResourceSpecification_ProcessingResourceSpecificationResult != oldProcessingResourceSpecification_ProcessingResourceSpecificationResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT,
                            oldProcessingResourceSpecification_ProcessingResourceSpecificationResult,
                            this.processingResourceSpecification_ProcessingResourceSpecificationResult));
                }
            }
        }
        return this.processingResourceSpecification_ProcessingResourceSpecificationResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProcessingResourceSpecification basicGetProcessingResourceSpecification_ProcessingResourceSpecificationResult() {
        return this.processingResourceSpecification_ProcessingResourceSpecificationResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProcessingResourceSpecification_ProcessingResourceSpecificationResult(
            final ProcessingResourceSpecification newProcessingResourceSpecification_ProcessingResourceSpecificationResult) {
        final ProcessingResourceSpecification oldProcessingResourceSpecification_ProcessingResourceSpecificationResult = this.processingResourceSpecification_ProcessingResourceSpecificationResult;
        this.processingResourceSpecification_ProcessingResourceSpecificationResult = newProcessingResourceSpecification_ProcessingResourceSpecificationResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT,
                    oldProcessingResourceSpecification_ProcessingResourceSpecificationResult,
                    this.processingResourceSpecification_ProcessingResourceSpecificationResult));
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
        case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
            if (resolve) {
                return this.getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
            }
            return this.basicGetProcessingResourceSpecification_ProcessingResourceSpecificationResult();
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
        case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
            this.setProcessingResourceSpecification_ProcessingResourceSpecificationResult(
                    (ProcessingResourceSpecification) newValue);
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
        case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
            this.setProcessingResourceSpecification_ProcessingResourceSpecificationResult(
                    (ProcessingResourceSpecification) null);
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
        case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
            return this.processingResourceSpecification_ProcessingResourceSpecificationResult != null;
        }
        return super.eIsSet(featureID);
    }

} // ProcessingResourceSpecificationResultImpl
