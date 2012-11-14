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

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.UsageBranchParameter;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Branch Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.UsageBranchParameterImpl#getBranch__UsageBranchParameter <em>Branch Usage Branch Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.UsageBranchParameterImpl#getScenarioBehaviour__UsageBranchParameter <em>Scenario Behaviour Usage Branch Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageBranchParameterImpl extends SingleSensitivityParameterImpl implements UsageBranchParameter {
	/**
	 * The cached value of the '{@link #getBranch__UsageBranchParameter() <em>Branch Usage Branch Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranch__UsageBranchParameter()
	 * @generated
	 * @ordered
	 */
	protected Branch branch__UsageBranchParameter;

	/**
	 * The cached value of the '{@link #getScenarioBehaviour__UsageBranchParameter() <em>Scenario Behaviour Usage Branch Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarioBehaviour__UsageBranchParameter()
	 * @generated
	 * @ordered
	 */
	protected ScenarioBehaviour scenarioBehaviour__UsageBranchParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageBranchParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SensitivityPackage.Literals.USAGE_BRANCH_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch getBranch__UsageBranchParameter() {
		if (branch__UsageBranchParameter != null && branch__UsageBranchParameter.eIsProxy()) {
			InternalEObject oldBranch__UsageBranchParameter = (InternalEObject)branch__UsageBranchParameter;
			branch__UsageBranchParameter = (Branch)eResolveProxy(oldBranch__UsageBranchParameter);
			if (branch__UsageBranchParameter != oldBranch__UsageBranchParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER, oldBranch__UsageBranchParameter, branch__UsageBranchParameter));
			}
		}
		return branch__UsageBranchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch basicGetBranch__UsageBranchParameter() {
		return branch__UsageBranchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranch__UsageBranchParameter(Branch newBranch__UsageBranchParameter) {
		Branch oldBranch__UsageBranchParameter = branch__UsageBranchParameter;
		branch__UsageBranchParameter = newBranch__UsageBranchParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER, oldBranch__UsageBranchParameter, branch__UsageBranchParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioBehaviour getScenarioBehaviour__UsageBranchParameter() {
		if (scenarioBehaviour__UsageBranchParameter != null && scenarioBehaviour__UsageBranchParameter.eIsProxy()) {
			InternalEObject oldScenarioBehaviour__UsageBranchParameter = (InternalEObject)scenarioBehaviour__UsageBranchParameter;
			scenarioBehaviour__UsageBranchParameter = (ScenarioBehaviour)eResolveProxy(oldScenarioBehaviour__UsageBranchParameter);
			if (scenarioBehaviour__UsageBranchParameter != oldScenarioBehaviour__UsageBranchParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER, oldScenarioBehaviour__UsageBranchParameter, scenarioBehaviour__UsageBranchParameter));
			}
		}
		return scenarioBehaviour__UsageBranchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioBehaviour basicGetScenarioBehaviour__UsageBranchParameter() {
		return scenarioBehaviour__UsageBranchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenarioBehaviour__UsageBranchParameter(ScenarioBehaviour newScenarioBehaviour__UsageBranchParameter) {
		ScenarioBehaviour oldScenarioBehaviour__UsageBranchParameter = scenarioBehaviour__UsageBranchParameter;
		scenarioBehaviour__UsageBranchParameter = newScenarioBehaviour__UsageBranchParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER, oldScenarioBehaviour__UsageBranchParameter, scenarioBehaviour__UsageBranchParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean UsageBranchParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 SensitivityValidator.USAGE_BRANCH_PARAMETER__USAGE_BRANCH_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "UsageBranchParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
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
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER:
				if (resolve) return getBranch__UsageBranchParameter();
				return basicGetBranch__UsageBranchParameter();
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER:
				if (resolve) return getScenarioBehaviour__UsageBranchParameter();
				return basicGetScenarioBehaviour__UsageBranchParameter();
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
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER:
				setBranch__UsageBranchParameter((Branch)newValue);
				return;
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER:
				setScenarioBehaviour__UsageBranchParameter((ScenarioBehaviour)newValue);
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
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER:
				setBranch__UsageBranchParameter((Branch)null);
				return;
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER:
				setScenarioBehaviour__UsageBranchParameter((ScenarioBehaviour)null);
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
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER:
				return branch__UsageBranchParameter != null;
			case SensitivityPackage.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER:
				return scenarioBehaviour__UsageBranchParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //UsageBranchParameterImpl
