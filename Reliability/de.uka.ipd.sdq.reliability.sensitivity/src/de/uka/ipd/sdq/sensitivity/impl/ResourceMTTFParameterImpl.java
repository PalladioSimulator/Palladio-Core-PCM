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

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.sensitivity.ResourceMTTFParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource MTTF Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTFParameterImpl#getProcessingResourceType__ResourceMTTFParameter <em>Processing Resource Type Resource MTTF Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTFParameterImpl#getResourceContainer__ResourceMTTFParameter <em>Resource Container Resource MTTF Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceMTTFParameterImpl extends SingleSensitivityParameterImpl implements ResourceMTTFParameter {
	/**
     * The cached value of the '{@link #getProcessingResourceType__ResourceMTTFParameter() <em>Processing Resource Type Resource MTTF Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProcessingResourceType__ResourceMTTFParameter()
     * @generated
     * @ordered
     */
	protected ProcessingResourceType processingResourceType__ResourceMTTFParameter;

	/**
     * The cached value of the '{@link #getResourceContainer__ResourceMTTFParameter() <em>Resource Container Resource MTTF Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getResourceContainer__ResourceMTTFParameter()
     * @generated
     * @ordered
     */
	protected ResourceContainer resourceContainer__ResourceMTTFParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ResourceMTTFParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.RESOURCE_MTTF_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessingResourceType getProcessingResourceType__ResourceMTTFParameter() {
        if (processingResourceType__ResourceMTTFParameter != null && processingResourceType__ResourceMTTFParameter.eIsProxy()) {
            InternalEObject oldProcessingResourceType__ResourceMTTFParameter = (InternalEObject)processingResourceType__ResourceMTTFParameter;
            processingResourceType__ResourceMTTFParameter = (ProcessingResourceType)eResolveProxy(oldProcessingResourceType__ResourceMTTFParameter);
            if (processingResourceType__ResourceMTTFParameter != oldProcessingResourceType__ResourceMTTFParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER, oldProcessingResourceType__ResourceMTTFParameter, processingResourceType__ResourceMTTFParameter));
            }
        }
        return processingResourceType__ResourceMTTFParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessingResourceType basicGetProcessingResourceType__ResourceMTTFParameter() {
        return processingResourceType__ResourceMTTFParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setProcessingResourceType__ResourceMTTFParameter(ProcessingResourceType newProcessingResourceType__ResourceMTTFParameter) {
        ProcessingResourceType oldProcessingResourceType__ResourceMTTFParameter = processingResourceType__ResourceMTTFParameter;
        processingResourceType__ResourceMTTFParameter = newProcessingResourceType__ResourceMTTFParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER, oldProcessingResourceType__ResourceMTTFParameter, processingResourceType__ResourceMTTFParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResourceContainer getResourceContainer__ResourceMTTFParameter() {
        if (resourceContainer__ResourceMTTFParameter != null && resourceContainer__ResourceMTTFParameter.eIsProxy()) {
            InternalEObject oldResourceContainer__ResourceMTTFParameter = (InternalEObject)resourceContainer__ResourceMTTFParameter;
            resourceContainer__ResourceMTTFParameter = (ResourceContainer)eResolveProxy(oldResourceContainer__ResourceMTTFParameter);
            if (resourceContainer__ResourceMTTFParameter != oldResourceContainer__ResourceMTTFParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER, oldResourceContainer__ResourceMTTFParameter, resourceContainer__ResourceMTTFParameter));
            }
        }
        return resourceContainer__ResourceMTTFParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResourceContainer basicGetResourceContainer__ResourceMTTFParameter() {
        return resourceContainer__ResourceMTTFParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setResourceContainer__ResourceMTTFParameter(ResourceContainer newResourceContainer__ResourceMTTFParameter) {
        ResourceContainer oldResourceContainer__ResourceMTTFParameter = resourceContainer__ResourceMTTFParameter;
        resourceContainer__ResourceMTTFParameter = newResourceContainer__ResourceMTTFParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER, oldResourceContainer__ResourceMTTFParameter, resourceContainer__ResourceMTTFParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean ResourceMTTFParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         SensitivityValidator.RESOURCE_MTTF_PARAMETER__RESOURCE_MTTF_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceMTTFParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
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
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER:
                if (resolve) return getProcessingResourceType__ResourceMTTFParameter();
                return basicGetProcessingResourceType__ResourceMTTFParameter();
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER:
                if (resolve) return getResourceContainer__ResourceMTTFParameter();
                return basicGetResourceContainer__ResourceMTTFParameter();
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
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER:
                setProcessingResourceType__ResourceMTTFParameter((ProcessingResourceType)newValue);
                return;
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER:
                setResourceContainer__ResourceMTTFParameter((ResourceContainer)newValue);
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
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER:
                setProcessingResourceType__ResourceMTTFParameter((ProcessingResourceType)null);
                return;
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER:
                setResourceContainer__ResourceMTTFParameter((ResourceContainer)null);
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
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTF_PARAMETER:
                return processingResourceType__ResourceMTTFParameter != null;
            case SensitivityPackage.RESOURCE_MTTF_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTF_PARAMETER:
                return resourceContainer__ResourceMTTFParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceMTTFParameterImpl
