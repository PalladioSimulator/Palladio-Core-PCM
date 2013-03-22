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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Acquire Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl#getPassiveresource_AcquireAction <em>Passiveresource Acquire Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl#isTimeout <em>Timeout</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl#getTimeoutValue <em>Timeout Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AcquireActionImpl extends AbstractInternalControlFlowActionImpl implements AcquireAction {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached value of the '{@link #getPassiveresource_AcquireAction() <em>Passiveresource Acquire Action</em>}' reference.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
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
	 * @generated
	 */
    protected AcquireActionImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return SeffPackage.Literals.ACQUIRE_ACTION;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public PassiveResource getPassiveresource_AcquireAction() {
		if (passiveresource_AcquireAction != null && passiveresource_AcquireAction.eIsProxy()) {
			InternalEObject oldPassiveresource_AcquireAction = (InternalEObject)passiveresource_AcquireAction;
			passiveresource_AcquireAction = (PassiveResource)eResolveProxy(oldPassiveresource_AcquireAction);
			if (passiveresource_AcquireAction != oldPassiveresource_AcquireAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION, oldPassiveresource_AcquireAction, passiveresource_AcquireAction));
			}
		}
		return passiveresource_AcquireAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public PassiveResource basicGetPassiveresource_AcquireAction() {
		return passiveresource_AcquireAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setPassiveresource_AcquireAction(PassiveResource newPassiveresource_AcquireAction) {
		PassiveResource oldPassiveresource_AcquireAction = passiveresource_AcquireAction;
		passiveresource_AcquireAction = newPassiveresource_AcquireAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION, oldPassiveresource_AcquireAction, passiveresource_AcquireAction));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isTimeout() {
		return timeout;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setTimeout(boolean newTimeout) {
		boolean oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.ACQUIRE_ACTION__TIMEOUT, oldTimeout, timeout));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public double getTimeoutValue() {
		return timeoutValue;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setTimeoutValue(double newTimeoutValue) {
		double oldTimeoutValue = timeoutValue;
		timeoutValue = newTimeoutValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE, oldTimeoutValue, timeoutValue));
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
	 * @generated
	 */
    public boolean TimeoutValueOfAcquireActionMustNotBeNegative(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.ACQUIRE_ACTION);
			try {
				TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.ACQUIRE_ACTION__TIMEOUT_VALUE_OF_ACQUIRE_ACTION_MUST_NOT_BE_NEGATIVE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "TimeoutValueOfAcquireActionMustNotBeNegative", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
				if (resolve) return getPassiveresource_AcquireAction();
				return basicGetPassiveresource_AcquireAction();
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
				return isTimeout();
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
				return getTimeoutValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
				setPassiveresource_AcquireAction((PassiveResource)newValue);
				return;
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
				setTimeout((Boolean)newValue);
				return;
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
				setTimeoutValue((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
				setPassiveresource_AcquireAction((PassiveResource)null);
				return;
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
				setTimeoutValue(TIMEOUT_VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION:
				return passiveresource_AcquireAction != null;
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
			case SeffPackage.ACQUIRE_ACTION__TIMEOUT_VALUE:
				return timeoutValue != TIMEOUT_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (timeout: ");
		result.append(timeout);
		result.append(", timeoutValue: ");
		result.append(timeoutValue);
		result.append(')');
		return result.toString();
	}

    /**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // AcquireActionImpl
