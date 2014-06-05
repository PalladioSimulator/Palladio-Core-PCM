/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_performance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.ComponentSpecifiedExecutionTime;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Component Specified Execution Time</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.impl.ComponentSpecifiedExecutionTimeImpl#getAssemblyContext_ComponentSpecifiedExecutionTime
 * <em>Assembly Context Component Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ComponentSpecifiedExecutionTimeImpl extends SpecifiedExecutionTimeImpl implements
        ComponentSpecifiedExecutionTime {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getAssemblyContext_ComponentSpecifiedExecutionTime()
     * <em>Assembly Context Component Specified Execution Time</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getAssemblyContext_ComponentSpecifiedExecutionTime()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_ComponentSpecifiedExecutionTime;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComponentSpecifiedExecutionTimeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosPerformancePackage.Literals.COMPONENT_SPECIFIED_EXECUTION_TIME;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext getAssemblyContext_ComponentSpecifiedExecutionTime() {
        if (assemblyContext_ComponentSpecifiedExecutionTime != null
                && ((EObject) assemblyContext_ComponentSpecifiedExecutionTime).eIsProxy()) {
            InternalEObject oldAssemblyContext_ComponentSpecifiedExecutionTime = (InternalEObject) assemblyContext_ComponentSpecifiedExecutionTime;
            assemblyContext_ComponentSpecifiedExecutionTime = (AssemblyContext) eResolveProxy(oldAssemblyContext_ComponentSpecifiedExecutionTime);
            if (assemblyContext_ComponentSpecifiedExecutionTime != oldAssemblyContext_ComponentSpecifiedExecutionTime) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME,
                            oldAssemblyContext_ComponentSpecifiedExecutionTime,
                            assemblyContext_ComponentSpecifiedExecutionTime));
            }
        }
        return assemblyContext_ComponentSpecifiedExecutionTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_ComponentSpecifiedExecutionTime() {
        return assemblyContext_ComponentSpecifiedExecutionTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAssemblyContext_ComponentSpecifiedExecutionTime(
            AssemblyContext newAssemblyContext_ComponentSpecifiedExecutionTime) {
        AssemblyContext oldAssemblyContext_ComponentSpecifiedExecutionTime = assemblyContext_ComponentSpecifiedExecutionTime;
        assemblyContext_ComponentSpecifiedExecutionTime = newAssemblyContext_ComponentSpecifiedExecutionTime;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME,
                    oldAssemblyContext_ComponentSpecifiedExecutionTime, assemblyContext_ComponentSpecifiedExecutionTime));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            if (resolve)
                return getAssemblyContext_ComponentSpecifiedExecutionTime();
            return basicGetAssemblyContext_ComponentSpecifiedExecutionTime();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            setAssemblyContext_ComponentSpecifiedExecutionTime((AssemblyContext) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            setAssemblyContext_ComponentSpecifiedExecutionTime((AssemblyContext) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            return assemblyContext_ComponentSpecifiedExecutionTime != null;
        }
        return super.eIsSet(featureID);
    }

} // ComponentSpecifiedExecutionTimeImpl
