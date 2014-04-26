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
import de.uka.ipd.sdq.sensitivity.ResourceMTTRParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource MTTR Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTRParameterImpl#getResourceContainer__ResourceMTTRParameter <em>Resource Container Resource MTTR Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.ResourceMTTRParameterImpl#getProcessingResourceType__ResourceMTTRParameter <em>Processing Resource Type Resource MTTR Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceMTTRParameterImpl extends SingleSensitivityParameterImpl implements ResourceMTTRParameter {
	/**
     * The cached value of the '{@link #getResourceContainer__ResourceMTTRParameter() <em>Resource Container Resource MTTR Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getResourceContainer__ResourceMTTRParameter()
     * @generated
     * @ordered
     */
	protected ResourceContainer resourceContainer__ResourceMTTRParameter;

	/**
     * The cached value of the '{@link #getProcessingResourceType__ResourceMTTRParameter() <em>Processing Resource Type Resource MTTR Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProcessingResourceType__ResourceMTTRParameter()
     * @generated
     * @ordered
     */
	protected ProcessingResourceType processingResourceType__ResourceMTTRParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ResourceMTTRParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.RESOURCE_MTTR_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResourceContainer getResourceContainer__ResourceMTTRParameter() {
        if (resourceContainer__ResourceMTTRParameter != null && resourceContainer__ResourceMTTRParameter.eIsProxy()) {
            InternalEObject oldResourceContainer__ResourceMTTRParameter = (InternalEObject)resourceContainer__ResourceMTTRParameter;
            resourceContainer__ResourceMTTRParameter = (ResourceContainer)eResolveProxy(oldResourceContainer__ResourceMTTRParameter);
            if (resourceContainer__ResourceMTTRParameter != oldResourceContainer__ResourceMTTRParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER, oldResourceContainer__ResourceMTTRParameter, resourceContainer__ResourceMTTRParameter));
            }
        }
        return resourceContainer__ResourceMTTRParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResourceContainer basicGetResourceContainer__ResourceMTTRParameter() {
        return resourceContainer__ResourceMTTRParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setResourceContainer__ResourceMTTRParameter(ResourceContainer newResourceContainer__ResourceMTTRParameter) {
        ResourceContainer oldResourceContainer__ResourceMTTRParameter = resourceContainer__ResourceMTTRParameter;
        resourceContainer__ResourceMTTRParameter = newResourceContainer__ResourceMTTRParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER, oldResourceContainer__ResourceMTTRParameter, resourceContainer__ResourceMTTRParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessingResourceType getProcessingResourceType__ResourceMTTRParameter() {
        if (processingResourceType__ResourceMTTRParameter != null && processingResourceType__ResourceMTTRParameter.eIsProxy()) {
            InternalEObject oldProcessingResourceType__ResourceMTTRParameter = (InternalEObject)processingResourceType__ResourceMTTRParameter;
            processingResourceType__ResourceMTTRParameter = (ProcessingResourceType)eResolveProxy(oldProcessingResourceType__ResourceMTTRParameter);
            if (processingResourceType__ResourceMTTRParameter != oldProcessingResourceType__ResourceMTTRParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SensitivityPackage.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER, oldProcessingResourceType__ResourceMTTRParameter, processingResourceType__ResourceMTTRParameter));
            }
        }
        return processingResourceType__ResourceMTTRParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessingResourceType basicGetProcessingResourceType__ResourceMTTRParameter() {
        return processingResourceType__ResourceMTTRParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setProcessingResourceType__ResourceMTTRParameter(ProcessingResourceType newProcessingResourceType__ResourceMTTRParameter) {
        ProcessingResourceType oldProcessingResourceType__ResourceMTTRParameter = processingResourceType__ResourceMTTRParameter;
        processingResourceType__ResourceMTTRParameter = newProcessingResourceType__ResourceMTTRParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER, oldProcessingResourceType__ResourceMTTRParameter, processingResourceType__ResourceMTTRParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean ResourceMTTRParameterMustHaveDoubleVariation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
                         SensitivityValidator.RESOURCE_MTTR_PARAMETER__RESOURCE_MTTR_PARAMETER_MUST_HAVE_DOUBLE_VARIATION,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceMTTRParameterMustHaveDoubleVariation", EObjectValidator.getObjectLabel(this, context) }),
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
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER:
                if (resolve) return getResourceContainer__ResourceMTTRParameter();
                return basicGetResourceContainer__ResourceMTTRParameter();
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER:
                if (resolve) return getProcessingResourceType__ResourceMTTRParameter();
                return basicGetProcessingResourceType__ResourceMTTRParameter();
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
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER:
                setResourceContainer__ResourceMTTRParameter((ResourceContainer)newValue);
                return;
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER:
                setProcessingResourceType__ResourceMTTRParameter((ProcessingResourceType)newValue);
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
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER:
                setResourceContainer__ResourceMTTRParameter((ResourceContainer)null);
                return;
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER:
                setProcessingResourceType__ResourceMTTRParameter((ProcessingResourceType)null);
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
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__RESOURCE_CONTAINER_RESOURCE_MTTR_PARAMETER:
                return resourceContainer__ResourceMTTRParameter != null;
            case SensitivityPackage.RESOURCE_MTTR_PARAMETER__PROCESSING_RESOURCE_TYPE_RESOURCE_MTTR_PARAMETER:
                return processingResourceType__ResourceMTTRParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //ResourceMTTRParameterImpl
