/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_performance.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.*;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.ComponentSpecifiedExecutionTime;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SystemSpecifiedExecutionTime;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage
 * @generated
 */
public class QosPerformanceAdapterFactory extends AdapterFactoryImpl {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static QosPerformancePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public QosPerformanceAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = QosPerformancePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected QosPerformanceSwitch<Adapter> modelSwitch = new QosPerformanceSwitch<Adapter>() {
            @Override
            public Adapter caseSystemSpecifiedExecutionTime(SystemSpecifiedExecutionTime object) {
                return createSystemSpecifiedExecutionTimeAdapter();
            }
            @Override
            public Adapter caseSpecifiedExecutionTime(SpecifiedExecutionTime object) {
                return createSpecifiedExecutionTimeAdapter();
            }
            @Override
            public Adapter caseComponentSpecifiedExecutionTime(ComponentSpecifiedExecutionTime object) {
                return createComponentSpecifiedExecutionTimeAdapter();
            }
            @Override
            public Adapter caseSpecifiedQoSAnnotation(SpecifiedQoSAnnotation object) {
                return createSpecifiedQoSAnnotationAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SystemSpecifiedExecutionTime <em>System Specified Execution Time</em>}'.
     * <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SystemSpecifiedExecutionTime
     * @generated
     */
    public Adapter createSystemSpecifiedExecutionTimeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime <em>Specified Execution Time</em>}'.
     * <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime
     * @generated
     */
    public Adapter createSpecifiedExecutionTimeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.ComponentSpecifiedExecutionTime <em>Component Specified Execution Time</em>}'.
     * <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.qosannotations.qos_performance.ComponentSpecifiedExecutionTime
     * @generated
     */
    public Adapter createComponentSpecifiedExecutionTimeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation <em>Specified Qo SAnnotation</em>}'.
     * <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation
     * @generated
     */
    public Adapter createSpecifiedQoSAnnotationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // QosPerformanceAdapterFactory
