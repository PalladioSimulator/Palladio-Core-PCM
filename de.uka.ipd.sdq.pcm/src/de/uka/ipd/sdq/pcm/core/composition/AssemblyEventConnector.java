/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;

import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Event Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkRole__AssemblyEventConnector <em>Sink Role Assembly Event Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceRole__AssemblyEventConnector <em>Source Role Assembly Event Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkAssemblyContext__AssemblyEventConnector <em>Sink Assembly Context Assembly Event Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceAssemblyContext__AssemblyEventConnector <em>Source Assembly Context Assembly Event Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getParentStructure__AssemblyEventConnector <em>Parent Structure Assembly Event Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyEventConnector()
 * @model
 * @generated
 */
public interface AssemblyEventConnector extends Connector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Sink Role Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sink Role Assembly Event Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Role Assembly Event Connector</em>' reference.
	 * @see #setSinkRole__AssemblyEventConnector(SinkRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyEventConnector_SinkRole__AssemblyEventConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SinkRole getSinkRole__AssemblyEventConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkRole__AssemblyEventConnector <em>Sink Role Assembly Event Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Role Assembly Event Connector</em>' reference.
	 * @see #getSinkRole__AssemblyEventConnector()
	 * @generated
	 */
	void setSinkRole__AssemblyEventConnector(SinkRole value);

	/**
	 * Returns the value of the '<em><b>Source Role Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Role Assembly Event Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role Assembly Event Connector</em>' reference.
	 * @see #setSourceRole__AssemblyEventConnector(SourceRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyEventConnector_SourceRole__AssemblyEventConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SourceRole getSourceRole__AssemblyEventConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceRole__AssemblyEventConnector <em>Source Role Assembly Event Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role Assembly Event Connector</em>' reference.
	 * @see #getSourceRole__AssemblyEventConnector()
	 * @generated
	 */
	void setSourceRole__AssemblyEventConnector(SourceRole value);

	/**
	 * Returns the value of the '<em><b>Sink Assembly Context Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sink Assembly Context Assembly Event Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink Assembly Context Assembly Event Connector</em>' reference.
	 * @see #setSinkAssemblyContext__AssemblyEventConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyEventConnector_SinkAssemblyContext__AssemblyEventConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getSinkAssemblyContext__AssemblyEventConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSinkAssemblyContext__AssemblyEventConnector <em>Sink Assembly Context Assembly Event Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink Assembly Context Assembly Event Connector</em>' reference.
	 * @see #getSinkAssemblyContext__AssemblyEventConnector()
	 * @generated
	 */
	void setSinkAssemblyContext__AssemblyEventConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Source Assembly Context Assembly Event Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Assembly Context Assembly Event Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Assembly Context Assembly Event Connector</em>' reference.
	 * @see #setSourceAssemblyContext__AssemblyEventConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyEventConnector_SourceAssemblyContext__AssemblyEventConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getSourceAssemblyContext__AssemblyEventConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getSourceAssemblyContext__AssemblyEventConnector <em>Source Assembly Context Assembly Event Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Assembly Context Assembly Event Connector</em>' reference.
	 * @see #getSourceAssemblyContext__AssemblyEventConnector()
	 * @generated
	 */
	void setSourceAssemblyContext__AssemblyEventConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Assembly Event Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyEventConnector__ComposedStructure <em>Assembly Event Connector Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Assembly Event Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Assembly Event Connector</em>' container reference.
	 * @see #setParentStructure__AssemblyEventConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyEventConnector_ParentStructure__AssemblyEventConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyEventConnector__ComposedStructure
	 * @model opposite="assemblyEventConnector__ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure__AssemblyEventConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector#getParentStructure__AssemblyEventConnector <em>Parent Structure Assembly Event Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Assembly Event Connector</em>' container reference.
	 * @see #getParentStructure__AssemblyEventConnector()
	 * @generated
	 */
	void setParentStructure__AssemblyEventConnector(ComposedStructure value);

} // AssemblyEventConnector
