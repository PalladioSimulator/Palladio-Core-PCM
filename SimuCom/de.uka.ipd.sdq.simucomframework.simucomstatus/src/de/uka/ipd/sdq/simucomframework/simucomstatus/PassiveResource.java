/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Passive Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getWaitingProcesses <em>
 * Waiting Processes</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getInitialResourceCount
 * <em>Initial Resource Count</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getResourcesAvailable
 * <em>Resources Available</em>}</li>
 * <li>{@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getPassiveResource()
 * @model
 * @generated
 */
public interface PassiveResource extends EObject {
    /**
     * Returns the value of the '<em><b>Waiting Processes</b></em>' reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire}. It
     * is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire#getResource
     * <em>Resource</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Waiting Processes</em>' reference list isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Waiting Processes</em>' reference list.
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getPassiveResource_WaitingProcesses()
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire#getResource
     * @model opposite="resource" ordered="false"
     * @generated
     */
    EList<WaitForAcquire> getWaitingProcesses();

    /**
     * Returns the value of the '<em><b>Initial Resource Count</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial Resource Count</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Initial Resource Count</em>' attribute.
     * @see #setInitialResourceCount(double)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getPassiveResource_InitialResourceCount()
     * @model required="true" ordered="false"
     * @generated
     */
    double getInitialResourceCount();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getInitialResourceCount
     * <em>Initial Resource Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Initial Resource Count</em>' attribute.
     * @see #getInitialResourceCount()
     * @generated
     */
    void setInitialResourceCount(double value);

    /**
     * Returns the value of the '<em><b>Resources Available</b></em>' attribute. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Resources Available</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resources Available</em>' attribute.
     * @see #setResourcesAvailable(double)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getPassiveResource_ResourcesAvailable()
     * @model required="true" transient="true" volatile="true" ordered="false"
     * @generated
     */
    double getResourcesAvailable();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getResourcesAvailable
     * <em>Resources Available</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resources Available</em>' attribute.
     * @see #getResourcesAvailable()
     * @generated
     */
    void setResourcesAvailable(double value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#getPassiveResource_Id()
     * @model required="true" ordered="false"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource#getId <em>Id</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // PassiveResource
