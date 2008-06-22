/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiringChildComponentContext_CompositeAssemblyConnector <em>Requiring Child Component Context Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidingChildComponentContext_CompositeAssemblyConnector <em>Providing Child Component Context Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidedRole_CompositeAssemblyConnector <em>Provided Role Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiredRole_CompositeAssemblyConnector <em>Required Role Composite Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector <em>Parent Structure Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector()
 * @model
 * @generated
 */
public interface AssemblyConnector extends Connector, Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Requiring Child Component Context Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Child Component Context Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #setRequiringChildComponentContext_CompositeAssemblyConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_RequiringChildComponentContext_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getRequiringChildComponentContext_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiringChildComponentContext_CompositeAssemblyConnector <em>Requiring Child Component Context Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #getRequiringChildComponentContext_CompositeAssemblyConnector()
	 * @generated
	 */
	void setRequiringChildComponentContext_CompositeAssemblyConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Providing Child Component Context Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Child Component Context Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #setProvidingChildComponentContext_CompositeAssemblyConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_ProvidingChildComponentContext_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getProvidingChildComponentContext_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidingChildComponentContext_CompositeAssemblyConnector <em>Providing Child Component Context Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Child Component Context Composite Assembly Connector</em>' reference.
	 * @see #getProvidingChildComponentContext_CompositeAssemblyConnector()
	 * @generated
	 */
	void setProvidingChildComponentContext_CompositeAssemblyConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Provided Role Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Role Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Role Composite Assembly Connector</em>' reference.
	 * @see #setProvidedRole_CompositeAssemblyConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_ProvidedRole_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getProvidedRole_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidedRole_CompositeAssemblyConnector <em>Provided Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Role Composite Assembly Connector</em>' reference.
	 * @see #getProvidedRole_CompositeAssemblyConnector()
	 * @generated
	 */
	void setProvidedRole_CompositeAssemblyConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Required Role Composite Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Role Composite Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Role Composite Assembly Connector</em>' reference.
	 * @see #setRequiredRole_CompositeAssemblyConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_RequiredRole_CompositeAssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getRequiredRole_CompositeAssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiredRole_CompositeAssemblyConnector <em>Required Role Composite Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Role Composite Assembly Connector</em>' reference.
	 * @see #getRequiredRole_CompositeAssemblyConnector()
	 * @generated
	 */
	void setRequiredRole_CompositeAssemblyConnector(RequiredRole value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Assembly Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getCompositeAssemblyConnectors_ComposedStructure <em>Composite Assembly Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Assembly Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Assembly Connector</em>' container reference.
	 * @see #setParentStructure_AssemblyConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_ParentStructure_AssemblyConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getCompositeAssemblyConnectors_ComposedStructure
	 * @model opposite="compositeAssemblyConnectors_ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_AssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector <em>Parent Structure Assembly Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Assembly Connector</em>' container reference.
	 * @see #getParentStructure_AssemblyConnector()
	 * @generated
	 */
	void setParentStructure_AssemblyConnector(ComposedStructure value);

} // AssemblyConnector
