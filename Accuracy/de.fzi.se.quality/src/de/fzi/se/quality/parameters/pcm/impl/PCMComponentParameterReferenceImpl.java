/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Component Parameter Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl#getImplementationComponentType
 * <em>Implementation Component Type</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl#getVariableUsage
 * <em>Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMComponentParameterReferenceImpl extends PCMParameterReferenceImpl implements
        PCMComponentParameterReference {

    /**
     * The cached value of the '{@link #getImplementationComponentType()
     * <em>Implementation Component Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getImplementationComponentType()
     * @generated
     * @ordered
     */
    protected ImplementationComponentType implementationComponentType;

    /**
     * The cached value of the '{@link #getVariableUsage() <em>Variable Usage</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getVariableUsage()
     * @generated
     * @ordered
     */
    protected VariableUsage variableUsage;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMComponentParameterReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ImplementationComponentType getImplementationComponentType() {
        if (this.implementationComponentType != null && ((EObject) this.implementationComponentType).eIsProxy()) {
            final InternalEObject oldImplementationComponentType = (InternalEObject) this.implementationComponentType;
            this.implementationComponentType = (ImplementationComponentType) this
                    .eResolveProxy(oldImplementationComponentType);
            if (this.implementationComponentType != oldImplementationComponentType) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE,
                            oldImplementationComponentType, this.implementationComponentType));
                }
            }
        }
        return this.implementationComponentType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ImplementationComponentType basicGetImplementationComponentType() {
        return this.implementationComponentType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setImplementationComponentType(final ImplementationComponentType newImplementationComponentType) {
        final ImplementationComponentType oldImplementationComponentType = this.implementationComponentType;
        this.implementationComponentType = newImplementationComponentType;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE,
                    oldImplementationComponentType, this.implementationComponentType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public VariableUsage getVariableUsage() {
        if (this.variableUsage != null && ((EObject) this.variableUsage).eIsProxy()) {
            final InternalEObject oldVariableUsage = (InternalEObject) this.variableUsage;
            this.variableUsage = (VariableUsage) this.eResolveProxy(oldVariableUsage);
            if (this.variableUsage != oldVariableUsage) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, oldVariableUsage,
                            this.variableUsage));
                }
            }
        }
        return this.variableUsage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public VariableUsage basicGetVariableUsage() {
        return this.variableUsage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setVariableUsage(final VariableUsage newVariableUsage) {
        final VariableUsage oldVariableUsage = this.variableUsage;
        this.variableUsage = newVariableUsage;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, oldVariableUsage, this.variableUsage));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            if (resolve) {
                return this.getImplementationComponentType();
            }
            return this.basicGetImplementationComponentType();
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            if (resolve) {
                return this.getVariableUsage();
            }
            return this.basicGetVariableUsage();
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
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            this.setImplementationComponentType((ImplementationComponentType) newValue);
            return;
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            this.setVariableUsage((VariableUsage) newValue);
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
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            this.setImplementationComponentType((ImplementationComponentType) null);
            return;
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            this.setVariableUsage((VariableUsage) null);
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
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            return this.implementationComponentType != null;
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            return this.variableUsage != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMComponentParameterReferenceImpl
