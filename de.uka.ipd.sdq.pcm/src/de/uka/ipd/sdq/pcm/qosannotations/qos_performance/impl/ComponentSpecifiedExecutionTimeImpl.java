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
    @Override
    public AssemblyContext getAssemblyContext_ComponentSpecifiedExecutionTime() {
        if (this.assemblyContext_ComponentSpecifiedExecutionTime != null
                && ((EObject) this.assemblyContext_ComponentSpecifiedExecutionTime).eIsProxy()) {
            final InternalEObject oldAssemblyContext_ComponentSpecifiedExecutionTime = (InternalEObject) this.assemblyContext_ComponentSpecifiedExecutionTime;
            this.assemblyContext_ComponentSpecifiedExecutionTime = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext_ComponentSpecifiedExecutionTime);
            if (this.assemblyContext_ComponentSpecifiedExecutionTime != oldAssemblyContext_ComponentSpecifiedExecutionTime) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME,
                            oldAssemblyContext_ComponentSpecifiedExecutionTime,
                            this.assemblyContext_ComponentSpecifiedExecutionTime));
                }
            }
        }
        return this.assemblyContext_ComponentSpecifiedExecutionTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_ComponentSpecifiedExecutionTime() {
        return this.assemblyContext_ComponentSpecifiedExecutionTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext_ComponentSpecifiedExecutionTime(
            final AssemblyContext newAssemblyContext_ComponentSpecifiedExecutionTime) {
        final AssemblyContext oldAssemblyContext_ComponentSpecifiedExecutionTime = this.assemblyContext_ComponentSpecifiedExecutionTime;
        this.assemblyContext_ComponentSpecifiedExecutionTime = newAssemblyContext_ComponentSpecifiedExecutionTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME,
                    oldAssemblyContext_ComponentSpecifiedExecutionTime,
                    this.assemblyContext_ComponentSpecifiedExecutionTime));
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
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            if (resolve) {
                return this.getAssemblyContext_ComponentSpecifiedExecutionTime();
            }
            return this.basicGetAssemblyContext_ComponentSpecifiedExecutionTime();
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
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            this.setAssemblyContext_ComponentSpecifiedExecutionTime((AssemblyContext) newValue);
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
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            this.setAssemblyContext_ComponentSpecifiedExecutionTime((AssemblyContext) null);
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
        case QosPerformancePackage.COMPONENT_SPECIFIED_EXECUTION_TIME__ASSEMBLY_CONTEXT_COMPONENT_SPECIFIED_EXECUTION_TIME:
            return this.assemblyContext_ComponentSpecifiedExecutionTime != null;
        }
        return super.eIsSet(featureID);
    }

} // ComponentSpecifiedExecutionTimeImpl
