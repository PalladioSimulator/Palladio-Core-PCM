/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

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

import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.sensitivity.InternalActionReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Action Reliability Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.InternalActionReliabilityParameterImpl#getSoftwareInducedFailureType__InternalActionReliabilityParameter <em>Software Induced Failure Type Internal Action Reliability Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.InternalActionReliabilityParameterImpl#getInternalAction__InternalActionReliabilityParameter <em>Internal Action Internal Action Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalActionReliabilityParameterImpl extends SingleSensitivityParameterImpl implements InternalActionReliabilityParameter {
	/**
     * The cached value of the '{@link #getSoftwareInducedFailureType__InternalActionReliabilityParameter() <em>Software Induced Failure Type Internal Action Reliability Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSoftwareInducedFailureType__InternalActionReliabilityParameter()
     * @generated
     * @ordered
     */
	protected SoftwareInducedFailureType softwareInducedFailureType__InternalActionReliabilityParameter;

	/**
     * The cached value of the '{@link #getInternalAction__InternalActionReliabilityParameter() <em>Internal Action Internal Action Reliability Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInternalAction__InternalActionReliabilityParameter()
     * @generated
     * @ordered
     */
	protected InternalAction internalAction__InternalActionReliabilityParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected InternalActionReliabilityParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.INTERNAL_ACTION_RELIABILITY_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SoftwareInducedFailureType getSoftwareInducedFailureType__InternalActionReliabilityParameter() {
        if (softwareInducedFailureType__InternalActionReliabilityParameter != null && softwareInducedFailureType__InternalActionReliabilityParameter.eIsProxy()) {
            InternalEObject oldSoftwareInducedFailureType__InternalActionReliabilityParameter = (InternalEObject)softwareInducedFailureType__InternalActionReliabilityParameter;
            softwareInducedFailureType__InternalActionReliabilityParameter = (SoftwareInducedFailureType)eResolveProxy(oldSoftwareInducedFailureType__InternalActionReliabilityParameter);
            if (softwareInducedFailureType__InternalActionReliabilityParameter != oldSoftwareInducedFailureType__InternalActionReliabilityParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER, oldSoftwareInducedFailureType__InternalActionReliabilityParameter, softwareInducedFailureType__InternalActionReliabilityParameter));
            }
        }
        return softwareInducedFailureType__InternalActionReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SoftwareInducedFailureType basicGetSoftwareInducedFailureType__InternalActionReliabilityParameter() {
        return softwareInducedFailureType__InternalActionReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSoftwareInducedFailureType__InternalActionReliabilityParameter(SoftwareInducedFailureType newSoftwareInducedFailureType__InternalActionReliabilityParameter) {
        SoftwareInducedFailureType oldSoftwareInducedFailureType__InternalActionReliabilityParameter = softwareInducedFailureType__InternalActionReliabilityParameter;
        softwareInducedFailureType__InternalActionReliabilityParameter = newSoftwareInducedFailureType__InternalActionReliabilityParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER, oldSoftwareInducedFailureType__InternalActionReliabilityParameter, softwareInducedFailureType__InternalActionReliabilityParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InternalAction getInternalAction__InternalActionReliabilityParameter() {
        if (internalAction__InternalActionReliabilityParameter != null && internalAction__InternalActionReliabilityParameter.eIsProxy()) {
            InternalEObject oldInternalAction__InternalActionReliabilityParameter = (InternalEObject)internalAction__InternalActionReliabilityParameter;
            internalAction__InternalActionReliabilityParameter = (InternalAction)eResolveProxy(oldInternalAction__InternalActionReliabilityParameter);
            if (internalAction__InternalActionReliabilityParameter != oldInternalAction__InternalActionReliabilityParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER, oldInternalAction__InternalActionReliabilityParameter, internalAction__InternalActionReliabilityParameter));
            }
        }
        return internalAction__InternalActionReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InternalAction basicGetInternalAction__InternalActionReliabilityParameter() {
        return internalAction__InternalActionReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInternalAction__InternalActionReliabilityParameter(InternalAction newInternalAction__InternalActionReliabilityParameter) {
        InternalAction oldInternalAction__InternalActionReliabilityParameter = internalAction__InternalActionReliabilityParameter;
        internalAction__InternalActionReliabilityParameter = newInternalAction__InternalActionReliabilityParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER, oldInternalAction__InternalActionReliabilityParameter, internalAction__InternalActionReliabilityParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean InternalActionReliabilityParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         SensitivityValidator.DIAGNOSTIC_SOURCE,
                         SensitivityValidator.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_RELIABILITY_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InternalActionReliabilityParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                if (resolve) return getSoftwareInducedFailureType__InternalActionReliabilityParameter();
                return basicGetSoftwareInducedFailureType__InternalActionReliabilityParameter();
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                if (resolve) return getInternalAction__InternalActionReliabilityParameter();
                return basicGetInternalAction__InternalActionReliabilityParameter();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                setSoftwareInducedFailureType__InternalActionReliabilityParameter((SoftwareInducedFailureType)newValue);
                return;
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                setInternalAction__InternalActionReliabilityParameter((InternalAction)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                setSoftwareInducedFailureType__InternalActionReliabilityParameter((SoftwareInducedFailureType)null);
                return;
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                setInternalAction__InternalActionReliabilityParameter((InternalAction)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__SOFTWARE_INDUCED_FAILURE_TYPE_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                return softwareInducedFailureType__InternalActionReliabilityParameter != null;
            case SensitivityPackage.INTERNAL_ACTION_RELIABILITY_PARAMETER__INTERNAL_ACTION_INTERNAL_ACTION_RELIABILITY_PARAMETER:
                return internalAction__InternalActionReliabilityParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //InternalActionReliabilityParameterImpl
