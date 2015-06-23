/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.seff.AcquireAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Acquire Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcm.seff.impl.AcquireActionImpl#getPassiveresource_AcquireAction
 * <em>Passiveresource Acquire Action</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.seff.impl.AcquireActionImpl#isTimeout <em>Timeout</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.seff.impl.AcquireActionImpl#getTimeoutValue
 * <em>Timeout Value</em>}</li>
 * </ul>
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
     * The default value of the '{@link #isTimeout() <em>Timeout</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isTimeout()
     * @generated
     * @ordered
     */
    protected static final boolean TIMEOUT_EDEFAULT = false;

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
        return (PassiveResource) this.eDynamicGet(SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION,
                SeffPackage.Literals.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveresource_AcquireAction() {
        return (PassiveResource) this.eDynamicGet(SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION,
                SeffPackage.Literals.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveresource_AcquireAction(final PassiveResource newPassiveresource_AcquireAction) {
        this.eDynamicSet(SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION,
                SeffPackage.Literals.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION, newPassiveresource_AcquireAction);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isTimeout() {
        return (Boolean) this.eDynamicGet(SeffPackage.ACQUIRE_ACTION__TIMEOUT,
                SeffPackage.Literals.ACQUIRE_ACTION__TIMEOUT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTimeout(final boolean newTimeout) {
        this.eDynamicSet(SeffPackage.ACQUIRE_ACTION__TIMEOUT, SeffPackage.Literals.ACQUIRE_ACTION__TIMEOUT, newTimeout);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getTimeoutValue() {
        return (Double) this.eDynamicGet(SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE,
                SeffPackage.Literals.ACQUIRE_ACTION__TIMEOUT_VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTimeoutValue(final double newTimeoutValue) {
        this.eDynamicSet(SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE, SeffPackage.Literals.ACQUIRE_ACTION__TIMEOUT_VALUE,
                newTimeoutValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean TimeoutValueOfAcquireActionMustNotBeNegative(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                                SeffValidator.ACQUIRE_ACTION__TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "TimeoutValueOfAcquireActionMustNotBeNegative",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
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
            return this.basicGetPassiveresource_AcquireAction() != null;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
            return this.isTimeout() != TIMEOUT_EDEFAULT;
        case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
            return this.getTimeoutValue() != TIMEOUT_VALUE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} // AcquireActionImpl
