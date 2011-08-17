/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Channel Source Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector#getSourceRole__EventChannelSourceRole <em>Source Role Event Channel Source Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector#getAssemblyContext__EventChannelSourceConnector <em>Assembly Context Event Channel Source Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannelSourceConnector()
 * @model
 * @generated
 */
public interface EventChannelSourceConnector extends Connector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Source Role Event Channel Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Role Event Channel Source Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role Event Channel Source Role</em>' reference.
	 * @see #setSourceRole__EventChannelSourceRole(SourceRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannelSourceConnector_SourceRole__EventChannelSourceRole()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SourceRole getSourceRole__EventChannelSourceRole();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector#getSourceRole__EventChannelSourceRole <em>Source Role Event Channel Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role Event Channel Source Role</em>' reference.
	 * @see #getSourceRole__EventChannelSourceRole()
	 * @generated
	 */
	void setSourceRole__EventChannelSourceRole(SourceRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Event Channel Source Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Event Channel Source Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Event Channel Source Connector</em>' reference.
	 * @see #setAssemblyContext__EventChannelSourceConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getEventChannelSourceConnector_AssemblyContext__EventChannelSourceConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext__EventChannelSourceConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector#getAssemblyContext__EventChannelSourceConnector <em>Assembly Context Event Channel Source Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Event Channel Source Connector</em>' reference.
	 * @see #getAssemblyContext__EventChannelSourceConnector()
	 * @generated
	 */
	void setAssemblyContext__EventChannelSourceConnector(AssemblyContext value);

} // EventChannelSourceConnector
