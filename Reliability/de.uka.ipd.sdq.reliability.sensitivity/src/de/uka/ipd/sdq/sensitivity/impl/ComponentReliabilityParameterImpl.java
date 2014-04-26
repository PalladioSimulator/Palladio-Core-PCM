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

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.sensitivity.ComponentReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Reliability Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.ComponentReliabilityParameterImpl#getBasicComponent__ComponentReliabilityParameter <em>Basic Component Component Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentReliabilityParameterImpl extends SingleSensitivityParameterImpl implements ComponentReliabilityParameter {
	/**
     * The cached value of the '{@link #getBasicComponent__ComponentReliabilityParameter() <em>Basic Component Component Reliability Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBasicComponent__ComponentReliabilityParameter()
     * @generated
     * @ordered
     */
	protected BasicComponent basicComponent__ComponentReliabilityParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ComponentReliabilityParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.COMPONENT_RELIABILITY_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BasicComponent getBasicComponent__ComponentReliabilityParameter() {
        if (basicComponent__ComponentReliabilityParameter != null && basicComponent__ComponentReliabilityParameter.eIsProxy()) {
            InternalEObject oldBasicComponent__ComponentReliabilityParameter = (InternalEObject)basicComponent__ComponentReliabilityParameter;
            basicComponent__ComponentReliabilityParameter = (BasicComponent)eResolveProxy(oldBasicComponent__ComponentReliabilityParameter);
            if (basicComponent__ComponentReliabilityParameter != oldBasicComponent__ComponentReliabilityParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER, oldBasicComponent__ComponentReliabilityParameter, basicComponent__ComponentReliabilityParameter));
            }
        }
        return basicComponent__ComponentReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BasicComponent basicGetBasicComponent__ComponentReliabilityParameter() {
        return basicComponent__ComponentReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBasicComponent__ComponentReliabilityParameter(BasicComponent newBasicComponent__ComponentReliabilityParameter) {
        BasicComponent oldBasicComponent__ComponentReliabilityParameter = basicComponent__ComponentReliabilityParameter;
        basicComponent__ComponentReliabilityParameter = newBasicComponent__ComponentReliabilityParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER, oldBasicComponent__ComponentReliabilityParameter, basicComponent__ComponentReliabilityParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean ComponentReliabilityParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         SensitivityValidator.COMPONENT_RELIABILITY_PARAMETER__COMPONENT_RELIABILITY_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ComponentReliabilityParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
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
            case SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER:
                if (resolve) return getBasicComponent__ComponentReliabilityParameter();
                return basicGetBasicComponent__ComponentReliabilityParameter();
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
            case SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER:
                setBasicComponent__ComponentReliabilityParameter((BasicComponent)newValue);
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
            case SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER:
                setBasicComponent__ComponentReliabilityParameter((BasicComponent)null);
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
            case SensitivityPackage.COMPONENT_RELIABILITY_PARAMETER__BASIC_COMPONENT_COMPONENT_RELIABILITY_PARAMETER:
                return basicComponent__ComponentReliabilityParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //ComponentReliabilityParameterImpl
