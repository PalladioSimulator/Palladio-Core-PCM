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

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.sensitivity.CommunicationLinkReliabilityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Link Reliability Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.CommunicationLinkReliabilityParameterImpl#getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter <em>Communication Link Resource Specification Communication Link Reliability Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationLinkReliabilityParameterImpl extends SingleSensitivityParameterImpl implements CommunicationLinkReliabilityParameter {
	/**
     * The cached value of the '{@link #getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter() <em>Communication Link Resource Specification Communication Link Reliability Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter()
     * @generated
     * @ordered
     */
	protected CommunicationLinkResourceSpecification communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CommunicationLinkReliabilityParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.COMMUNICATION_LINK_RELIABILITY_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CommunicationLinkResourceSpecification getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter() {
        if (communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter != null && communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter.eIsProxy()) {
            InternalEObject oldCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter = (InternalEObject)communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter;
            communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter = (CommunicationLinkResourceSpecification)eResolveProxy(oldCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter);
            if (communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter != oldCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER, oldCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter, communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter));
            }
        }
        return communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CommunicationLinkResourceSpecification basicGetCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter() {
        return communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter(CommunicationLinkResourceSpecification newCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter) {
        CommunicationLinkResourceSpecification oldCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter = communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter;
        communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter = newCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER, oldCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter, communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean CommunicationLinkParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         SensitivityValidator.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "CommunicationLinkParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
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
            case SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER:
                if (resolve) return getCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter();
                return basicGetCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter();
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
            case SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER:
                setCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter((CommunicationLinkResourceSpecification)newValue);
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
            case SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER:
                setCommunicationLinkResourceSpecification__CommunicationLinkReliabilityParameter((CommunicationLinkResourceSpecification)null);
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
            case SensitivityPackage.COMMUNICATION_LINK_RELIABILITY_PARAMETER__COMMUNICATION_LINK_RESOURCE_SPECIFICATION_COMMUNICATION_LINK_RELIABILITY_PARAMETER:
                return communicationLinkResourceSpecification__CommunicationLinkReliabilityParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //CommunicationLinkReliabilityParameterImpl
