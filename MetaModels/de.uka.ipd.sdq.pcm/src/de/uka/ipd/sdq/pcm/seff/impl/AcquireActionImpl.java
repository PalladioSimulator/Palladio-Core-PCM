/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Acquire Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl#getPassiveresource_AcquireAction <em>
 * Passiveresource Acquire Action</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl#isTimeout <em>Timeout</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl#getTimeoutValue <em>Timeout Value</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AcquireActionImpl extends AbstractInternalControlFlowActionImpl implements AcquireAction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getPassiveresource_AcquireAction()
     * <em>Passiveresource Acquire Action</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getPassiveresource_AcquireAction()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveresource_AcquireAction;

    /**
     * The default value of the '{@link #isTimeout() <em>Timeout</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isTimeout()
     * @generated
     * @ordered
     */
    protected static final boolean TIMEOUT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isTimeout() <em>Timeout</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isTimeout()
     * @generated
     * @ordered
     */
    protected boolean timeout = TIMEOUT_EDEFAULT;

    /**
     * The default value of the '{@link #getTimeoutValue() <em>Timeout Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTimeoutValue()
     * @generated
     * @ordered
     */
    protected static final double TIMEOUT_VALUE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getTimeoutValue() <em>Timeout Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTimeoutValue()
     * @generated
     * @ordered
     */
    protected double timeoutValue = TIMEOUT_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AcquireActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.ACQUIRE_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PassiveResource getPassiveresource_AcquireAction() {
        if (this.passiveresource_AcquireAction != null && ((EObject) this.passiveresource_AcquireAction).eIsProxy()) {
            final InternalEObject oldPassiveresource_AcquireAction = (InternalEObject) this.passiveresource_AcquireAction;
            this.passiveresource_AcquireAction = (PassiveResource) this.eResolveProxy(oldPassiveresource_AcquireAction);
            if (this.passiveresource_AcquireAction != oldPassiveresource_AcquireAction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION,
                            oldPassiveresource_AcquireAction, this.passiveresource_AcquireAction));
                }
            }
        }
        return this.passiveresource_AcquireAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveresource_AcquireAction() {
        return this.passiveresource_AcquireAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveresource_AcquireAction(final PassiveResource newPassiveresource_AcquireAction) {
        final PassiveResource oldPassiveresource_AcquireAction = this.passiveresource_AcquireAction;
        this.passiveresource_AcquireAction = newPassiveresource_AcquireAction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION, oldPassiveresource_AcquireAction,
                    this.passiveresource_AcquireAction));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isTimeout() {
        return this.timeout;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTimeout(final boolean newTimeout) {
        final boolean oldTimeout = this.timeout;
        this.timeout = newTimeout;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.ACQUIRE_ACTION__TIMEOUT, oldTimeout,
                    this.timeout));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getTimeoutValue() {
        return this.timeoutValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTimeoutValue(final double newTimeoutValue) {
        final double oldTimeoutValue = this.timeoutValue;
        this.timeoutValue = newTimeoutValue;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE,
                    oldTimeoutValue, this.timeoutValue));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #TimeoutValueOfAcquireActionMustNotBeNegative(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Timeout Value Of Acquire Action Must Not Be Negative</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #TimeoutValueOfAcquireActionMustNotBeNegative(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.timeoutValue.oclAsType(Real) >= 0.0";

    /**
     * The cached OCL invariant for the '
     * {@link #TimeoutValueOfAcquireActionMustNotBeNegative(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Timeout Value Of Acquire Action Must Not Be Negative</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #TimeoutValueOfAcquireActionMustNotBeNegative(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean TimeoutValueOfAcquireActionMustNotBeNegative(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.ACQUIRE_ACTION);
            try {
                TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                        SeffValidator.ACQUIRE_ACTION__TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "TimeoutValueOfAcquireActionMustNotBeNegative",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
            if (resolve) {
                return this.getPassiveresource_AcquireAction();
            }
            return this.basicGetPassiveresource_AcquireAction();
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
            return this.isTimeout();
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
            return this.getTimeoutValue();
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
        case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
            this.setPassiveresource_AcquireAction((PassiveResource) newValue);
            return;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
            this.setTimeout((Boolean) newValue);
            return;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
            this.setTimeoutValue((Double) newValue);
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
        case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
            this.setPassiveresource_AcquireAction((PassiveResource) null);
            return;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
            this.setTimeout(TIMEOUT_EDEFAULT);
            return;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
            this.setTimeoutValue(TIMEOUT_VALUE_EDEFAULT);
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
        case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
            return this.passiveresource_AcquireAction != null;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
            return this.timeout != TIMEOUT_EDEFAULT;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
            return this.timeoutValue != TIMEOUT_VALUE_EDEFAULT;
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
        result.append(" (timeout: ");
        result.append(this.timeout);
        result.append(", timeoutValue: ");
        result.append(this.timeoutValue);
        result.append(')');
        return result.toString();
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // AcquireActionImpl
