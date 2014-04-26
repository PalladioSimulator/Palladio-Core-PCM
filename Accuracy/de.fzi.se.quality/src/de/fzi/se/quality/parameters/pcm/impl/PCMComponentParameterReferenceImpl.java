/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl#getVariableUsage <em>Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMComponentParameterReferenceImpl extends PCMParameterReferenceImpl implements PCMComponentParameterReference {
	/**
     * The cached value of the '{@link #getImplementationComponentType() <em>Implementation Component Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementationComponentType()
     * @generated
     * @ordered
     */
	protected ImplementationComponentType implementationComponentType;

	/**
     * The cached value of the '{@link #getVariableUsage() <em>Variable Usage</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariableUsage()
     * @generated
     * @ordered
     */
	protected VariableUsage variableUsage;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMComponentParameterReferenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ImplementationComponentType getImplementationComponentType() {
        if (implementationComponentType != null && implementationComponentType.eIsProxy()) {
            InternalEObject oldImplementationComponentType = (InternalEObject)implementationComponentType;
            implementationComponentType = (ImplementationComponentType)eResolveProxy(oldImplementationComponentType);
            if (implementationComponentType != oldImplementationComponentType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE, oldImplementationComponentType, implementationComponentType));
            }
        }
        return implementationComponentType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ImplementationComponentType basicGetImplementationComponentType() {
        return implementationComponentType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImplementationComponentType(ImplementationComponentType newImplementationComponentType) {
        ImplementationComponentType oldImplementationComponentType = implementationComponentType;
        implementationComponentType = newImplementationComponentType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE, oldImplementationComponentType, implementationComponentType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableUsage getVariableUsage() {
        if (variableUsage != null && variableUsage.eIsProxy()) {
            InternalEObject oldVariableUsage = (InternalEObject)variableUsage;
            variableUsage = (VariableUsage)eResolveProxy(oldVariableUsage);
            if (variableUsage != oldVariableUsage) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, oldVariableUsage, variableUsage));
            }
        }
        return variableUsage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableUsage basicGetVariableUsage() {
        return variableUsage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariableUsage(VariableUsage newVariableUsage) {
        VariableUsage oldVariableUsage = variableUsage;
        variableUsage = newVariableUsage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, oldVariableUsage, variableUsage));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
                if (resolve) return getImplementationComponentType();
                return basicGetImplementationComponentType();
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
                if (resolve) return getVariableUsage();
                return basicGetVariableUsage();
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
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
                setImplementationComponentType((ImplementationComponentType)newValue);
                return;
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
                setVariableUsage((VariableUsage)newValue);
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
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
                setImplementationComponentType((ImplementationComponentType)null);
                return;
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
                setVariableUsage((VariableUsage)null);
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
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
                return implementationComponentType != null;
            case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
                return variableUsage != null;
        }
        return super.eIsSet(featureID);
    }

} //PCMComponentParameterReferenceImpl
