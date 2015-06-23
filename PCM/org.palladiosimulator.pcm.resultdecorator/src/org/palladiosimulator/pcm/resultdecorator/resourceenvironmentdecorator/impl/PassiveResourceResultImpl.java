/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Passive Resource Result</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl#getPassiveResource_PassiveResourceResult
 * <em>Passive Resource Passive Resource Result</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl#getAssemblyContext_PassiveResourceResult
 * <em>Assembly Context Passive Resource Result</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl#getAverageHoldingTime
 * <em>Average Holding Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PassiveResourceResultImpl extends UtilisationResultImpl implements PassiveResourceResult {

    /**
     * The cached value of the '{@link #getPassiveResource_PassiveResourceResult()
     * <em>Passive Resource Passive Resource Result</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getPassiveResource_PassiveResourceResult()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveResource_PassiveResourceResult;

    /**
     * The cached value of the '{@link #getAssemblyContext_PassiveResourceResult()
     * <em>Assembly Context Passive Resource Result</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getAssemblyContext_PassiveResourceResult()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_PassiveResourceResult;

    /**
     * The default value of the '{@link #getAverageHoldingTime() <em>Average Holding Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageHoldingTime()
     * @generated
     * @ordered
     */
    protected static final double AVERAGE_HOLDING_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getAverageHoldingTime() <em>Average Holding Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageHoldingTime()
     * @generated
     * @ordered
     */
    protected double averageHoldingTime = AVERAGE_HOLDING_TIME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PassiveResourceResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentdecoratorPackage.Literals.PASSIVE_RESOURCE_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PassiveResource getPassiveResource_PassiveResourceResult() {
        if (this.passiveResource_PassiveResourceResult != null
                && ((EObject) this.passiveResource_PassiveResourceResult).eIsProxy()) {
            final InternalEObject oldPassiveResource_PassiveResourceResult = (InternalEObject) this.passiveResource_PassiveResourceResult;
            this.passiveResource_PassiveResourceResult = (PassiveResource) this
                    .eResolveProxy(oldPassiveResource_PassiveResourceResult);
            if (this.passiveResource_PassiveResourceResult != oldPassiveResource_PassiveResourceResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT,
                            oldPassiveResource_PassiveResourceResult, this.passiveResource_PassiveResourceResult));
                }
            }
        }
        return this.passiveResource_PassiveResourceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveResource_PassiveResourceResult() {
        return this.passiveResource_PassiveResourceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveResource_PassiveResourceResult(
            final PassiveResource newPassiveResource_PassiveResourceResult) {
        final PassiveResource oldPassiveResource_PassiveResourceResult = this.passiveResource_PassiveResourceResult;
        this.passiveResource_PassiveResourceResult = newPassiveResource_PassiveResourceResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT,
                    oldPassiveResource_PassiveResourceResult, this.passiveResource_PassiveResourceResult));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext_PassiveResourceResult() {
        if (this.assemblyContext_PassiveResourceResult != null
                && ((EObject) this.assemblyContext_PassiveResourceResult).eIsProxy()) {
            final InternalEObject oldAssemblyContext_PassiveResourceResult = (InternalEObject) this.assemblyContext_PassiveResourceResult;
            this.assemblyContext_PassiveResourceResult = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext_PassiveResourceResult);
            if (this.assemblyContext_PassiveResourceResult != oldAssemblyContext_PassiveResourceResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT,
                            oldAssemblyContext_PassiveResourceResult, this.assemblyContext_PassiveResourceResult));
                }
            }
        }
        return this.assemblyContext_PassiveResourceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_PassiveResourceResult() {
        return this.assemblyContext_PassiveResourceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext_PassiveResourceResult(
            final AssemblyContext newAssemblyContext_PassiveResourceResult) {
        final AssemblyContext oldAssemblyContext_PassiveResourceResult = this.assemblyContext_PassiveResourceResult;
        this.assemblyContext_PassiveResourceResult = newAssemblyContext_PassiveResourceResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT,
                    oldAssemblyContext_PassiveResourceResult, this.assemblyContext_PassiveResourceResult));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getAverageHoldingTime() {
        return this.averageHoldingTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAverageHoldingTime(final double newAverageHoldingTime) {
        final double oldAverageHoldingTime = this.averageHoldingTime;
        this.averageHoldingTime = newAverageHoldingTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME,
                    oldAverageHoldingTime, this.averageHoldingTime));
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
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
            if (resolve) {
                return this.getPassiveResource_PassiveResourceResult();
            }
            return this.basicGetPassiveResource_PassiveResourceResult();
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
            if (resolve) {
                return this.getAssemblyContext_PassiveResourceResult();
            }
            return this.basicGetAssemblyContext_PassiveResourceResult();
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
            return this.getAverageHoldingTime();
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
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
            this.setPassiveResource_PassiveResourceResult((PassiveResource) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
            this.setAssemblyContext_PassiveResourceResult((AssemblyContext) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
            this.setAverageHoldingTime((Double) newValue);
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
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
            this.setPassiveResource_PassiveResourceResult((PassiveResource) null);
            return;
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
            this.setAssemblyContext_PassiveResourceResult((AssemblyContext) null);
            return;
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
            this.setAverageHoldingTime(AVERAGE_HOLDING_TIME_EDEFAULT);
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
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
            return this.passiveResource_PassiveResourceResult != null;
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
            return this.assemblyContext_PassiveResourceResult != null;
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
            return this.averageHoldingTime != AVERAGE_HOLDING_TIME_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (averageHoldingTime: ");
        result.append(this.averageHoldingTime);
        result.append(')');
        return result.toString();
    }

} // PassiveResourceResultImpl
