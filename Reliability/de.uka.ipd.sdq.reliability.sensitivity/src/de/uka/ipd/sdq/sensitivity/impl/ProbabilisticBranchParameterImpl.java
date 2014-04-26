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

import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.sensitivity.ProbabilisticBranchParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Probabilistic Branch Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.ProbabilisticBranchParameterImpl#getProbabilisticBranchTransition__ProbabilisticBranchParameter <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProbabilisticBranchParameterImpl extends SingleSensitivityParameterImpl implements ProbabilisticBranchParameter {
	/**
     * The cached value of the '{@link #getProbabilisticBranchTransition__ProbabilisticBranchParameter() <em>Probabilistic Branch Transition Probabilistic Branch Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProbabilisticBranchTransition__ProbabilisticBranchParameter()
     * @generated
     * @ordered
     */
	protected ProbabilisticBranchTransition probabilisticBranchTransition__ProbabilisticBranchParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ProbabilisticBranchParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.PROBABILISTIC_BRANCH_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProbabilisticBranchTransition getProbabilisticBranchTransition__ProbabilisticBranchParameter() {
        if (probabilisticBranchTransition__ProbabilisticBranchParameter != null && probabilisticBranchTransition__ProbabilisticBranchParameter.eIsProxy()) {
            InternalEObject oldProbabilisticBranchTransition__ProbabilisticBranchParameter = (InternalEObject)probabilisticBranchTransition__ProbabilisticBranchParameter;
            probabilisticBranchTransition__ProbabilisticBranchParameter = (ProbabilisticBranchTransition)eResolveProxy(oldProbabilisticBranchTransition__ProbabilisticBranchParameter);
            if (probabilisticBranchTransition__ProbabilisticBranchParameter != oldProbabilisticBranchTransition__ProbabilisticBranchParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER, oldProbabilisticBranchTransition__ProbabilisticBranchParameter, probabilisticBranchTransition__ProbabilisticBranchParameter));
            }
        }
        return probabilisticBranchTransition__ProbabilisticBranchParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProbabilisticBranchTransition basicGetProbabilisticBranchTransition__ProbabilisticBranchParameter() {
        return probabilisticBranchTransition__ProbabilisticBranchParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setProbabilisticBranchTransition__ProbabilisticBranchParameter(ProbabilisticBranchTransition newProbabilisticBranchTransition__ProbabilisticBranchParameter) {
        ProbabilisticBranchTransition oldProbabilisticBranchTransition__ProbabilisticBranchParameter = probabilisticBranchTransition__ProbabilisticBranchParameter;
        probabilisticBranchTransition__ProbabilisticBranchParameter = newProbabilisticBranchTransition__ProbabilisticBranchParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER, oldProbabilisticBranchTransition__ProbabilisticBranchParameter, probabilisticBranchTransition__ProbabilisticBranchParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean ProbabilisticBranchParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         SensitivityValidator.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProbabilisticBranchParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
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
            case SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER:
                if (resolve) return getProbabilisticBranchTransition__ProbabilisticBranchParameter();
                return basicGetProbabilisticBranchTransition__ProbabilisticBranchParameter();
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
            case SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER:
                setProbabilisticBranchTransition__ProbabilisticBranchParameter((ProbabilisticBranchTransition)newValue);
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
            case SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER:
                setProbabilisticBranchTransition__ProbabilisticBranchParameter((ProbabilisticBranchTransition)null);
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
            case SensitivityPackage.PROBABILISTIC_BRANCH_PARAMETER__PROBABILISTIC_BRANCH_TRANSITION_PROBABILISTIC_BRANCH_PARAMETER:
                return probabilisticBranchTransition__ProbabilisticBranchParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //ProbabilisticBranchParameterImpl
