/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Component Instance</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.ComponentInstanceImpl#getComponentReference <em>
 * Component Reference</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ComponentInstanceImpl#getParameterInstances <em>
 * Parameter Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends IdentifierImpl implements ComponentInstance {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComponentInstanceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.COMPONENT_INSTANCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComponentReference getComponentReference() {
        return (ComponentReference) this.eDynamicGet(ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE,
                ParametersPackage.Literals.COMPONENT_INSTANCE__COMPONENT_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetComponentReference(final ComponentReference newComponentReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newComponentReference,
                ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setComponentReference(final ComponentReference newComponentReference) {
        this.eDynamicSet(ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE,
                ParametersPackage.Literals.COMPONENT_INSTANCE__COMPONENT_REFERENCE, newComponentReference);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParameterInstance> getParameterInstances() {
        return (EList<ParameterInstance>) this.eDynamicGet(ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES,
                ParametersPackage.Literals.COMPONENT_INSTANCE__PARAMETER_INSTANCES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
            final ComponentReference componentReference = this.getComponentReference();
            if (componentReference != null) {
                msgs = ((InternalEObject) componentReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, null, msgs);
            }
            return this.basicSetComponentReference((ComponentReference) otherEnd, msgs);
        case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getParameterInstances()).basicAdd(
                    otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
            return this.basicSetComponentReference(null, msgs);
        case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
            return ((InternalEList<?>) this.getParameterInstances()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
            return this.getComponentReference();
        case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
            return this.getParameterInstances();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
            this.setComponentReference((ComponentReference) newValue);
            return;
        case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
            this.getParameterInstances().clear();
            this.getParameterInstances().addAll((Collection<? extends ParameterInstance>) newValue);
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
        case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
            this.setComponentReference((ComponentReference) null);
            return;
        case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
            this.getParameterInstances().clear();
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
        case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
            return this.getComponentReference() != null;
        case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
            return !this.getParameterInstances().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ComponentInstanceImpl
