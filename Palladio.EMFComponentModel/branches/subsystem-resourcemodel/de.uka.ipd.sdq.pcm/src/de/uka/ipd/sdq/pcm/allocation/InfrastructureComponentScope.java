/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Component Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getAssemblyContext_InfrastructureComponentScope <em>Assembly Context Infrastructure Component Scope</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope()
 * @model
 * @generated
 */
public interface InfrastructureComponentScope extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Assembly Context Infrastructure Component Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Infrastructure Component Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Infrastructure Component Scope</em>' reference.
	 * @see #setAssemblyContext_InfrastructureComponentScope(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_AssemblyContext_InfrastructureComponentScope()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_InfrastructureComponentScope();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getAssemblyContext_InfrastructureComponentScope <em>Assembly Context Infrastructure Component Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Infrastructure Component Scope</em>' reference.
	 * @see #getAssemblyContext_InfrastructureComponentScope()
	 * @generated
	 */
	void setAssemblyContext_InfrastructureComponentScope(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Lower Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Layer</em>' reference.
	 * @see #setLowerLayer(InfrastructureComponentScope)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_LowerLayer()
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer
	 * @model opposite="upperLayer" ordered="false"
	 * @generated
	 */
	InfrastructureComponentScope getLowerLayer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Layer</em>' reference.
	 * @see #getLowerLayer()
	 * @generated
	 */
	void setLowerLayer(InfrastructureComponentScope value);

	/**
	 * Returns the value of the '<em><b>Upper Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Layer</em>' reference.
	 * @see #setUpperLayer(InfrastructureComponentScope)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_UpperLayer()
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer
	 * @model opposite="lowerLayer" ordered="false"
	 * @generated
	 */
	InfrastructureComponentScope getUpperLayer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Layer</em>' reference.
	 * @see #getUpperLayer()
	 * @generated
	 */
	void setUpperLayer(InfrastructureComponentScope value);

} // InfrastructureComponentScope
