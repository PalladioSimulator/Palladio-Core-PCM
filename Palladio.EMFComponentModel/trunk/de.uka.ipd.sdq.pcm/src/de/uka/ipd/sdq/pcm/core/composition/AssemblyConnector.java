/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.connectors.Connector;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiringAssemblyContext_AssemblyConnector <em>Requiring Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidingAssemblyContext_AssemblyConnector <em>Providing Assembly Context Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidedRole_AssemblyConnector <em>Provided Role Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiredRole_AssemblyConnector <em>Required Role Assembly Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getParentStructure_AssemblyConnector <em>Parent Structure Assembly Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector()
 * @model
 * @generated
 */
public interface AssemblyConnector extends Connector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Requiring Assembly Context Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Assembly Context Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Assembly Context Assembly Connector</em>' reference.
	 * @see #setRequiringAssemblyContext_AssemblyConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_RequiringAssemblyContext_AssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getRequiringAssemblyContext_AssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiringAssemblyContext_AssemblyConnector <em>Requiring Assembly Context Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiring Assembly Context Assembly Connector</em>' reference.
	 * @see #getRequiringAssemblyContext_AssemblyConnector()
	 * @generated
	 */
	void setRequiringAssemblyContext_AssemblyConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Providing Assembly Context Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Assembly Context Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Assembly Context Assembly Connector</em>' reference.
	 * @see #setProvidingAssemblyContext_AssemblyConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_ProvidingAssemblyContext_AssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getProvidingAssemblyContext_AssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidingAssemblyContext_AssemblyConnector <em>Providing Assembly Context Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Assembly Context Assembly Connector</em>' reference.
	 * @see #getProvidingAssemblyContext_AssemblyConnector()
	 * @generated
	 */
	void setProvidingAssemblyContext_AssemblyConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Provided Role Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Role Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Role Assembly Connector</em>' reference.
	 * @see #setProvidedRole_AssemblyConnector(ProvidedRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_ProvidedRole_AssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProvidedRole getProvidedRole_AssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getProvidedRole_AssemblyConnector <em>Provided Role Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Role Assembly Connector</em>' reference.
	 * @see #getProvidedRole_AssemblyConnector()
	 * @generated
	 */
	void setProvidedRole_AssemblyConnector(ProvidedRole value);

	/**
	 * Returns the value of the '<em><b>Required Role Assembly Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Role Assembly Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Role Assembly Connector</em>' reference.
	 * @see #setRequiredRole_AssemblyConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_RequiredRole_AssemblyConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getRequiredRole_AssemblyConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector#getRequiredRole_AssemblyConnector <em>Required Role Assembly Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Role Assembly Connector</em>' reference.
	 * @see #getRequiredRole_AssemblyConnector()
	 * @generated
	 */
	void setRequiredRole_AssemblyConnector(RequiredRole value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Assembly Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyConnectors_ComposedStructure <em>Assembly Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Assembly Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Assembly Connector</em>' container reference.
	 * @see #setParentStructure_AssemblyConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getAssemblyConnector_ParentStructure_AssemblyConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getAssemblyConnectors_ComposedStructure
	 * @model opposite="assemblyConnectors_ComposedStructure" required="true" transient="false" ordered="false"
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An AssemblyConnector references an assembly context and a provided role on the provider side. This constraint ensures that the referenced provided role is really available in the referenced assembly context. 
	 * self.providingAssemblyContext_AssemblyConnector.encapsulatedComponent_AssemblyContext.providedRoles_InterfaceProvidingEntity->includes(self.providedRole_AssemblyConnector)
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.providingAssemblyContext_AssemblyConnector.encapsulatedComponent_AssemblyContext.providedRoles_InterfaceProvidingEntity->includes(self.providedRole_AssemblyConnector)\r\n'"
	 * @generated
	 */
	boolean AssemblyConnectorsReferencedProvidedRolesAndChildContextMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An AssemblyConnector references an assembly context and a required role on the client side. This constraint ensures that the referenced required role is really available in the referenced assembly context. 
	 * self.requiringAssemblyContext_AssemblyConnector.encapsulatedComponent_AssemblyContext.requiredRoles_InterfaceRequiringEntity->includes(self.requiredRole_AssemblyConnector)
	 * 
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.requiringAssemblyContext_AssemblyConnector.encapsulatedComponent_AssemblyContext.requiredRoles_InterfaceRequiringEntity->includes(self.requiredRole_AssemblyConnector)\r\n\r\n'"
	 * @generated
	 */
	boolean AssemblyConnectorsReferencedRequiredRoleAndChildContextMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Interfaces references by this Connector must match. This means that either 
	 * 1) the referenced providedRole and the referenced requiredRole refer to the same Interface (first part of the expression) or 2)  the Interface A referenced by the providedRole is a subtype of the Interface B referenced by the requiredRole as transitively defined by the parentInterface__Interface property. That means that either Interface A is the parentInterface__Interface of Interface B, or there is a set of Interfaces 
	 * self.providedRole_AssemblyConnector.providedInterface__ProvidedRole = self.requiredRole_AssemblyConnector.requiredInterface__RequiredRole or 
	 * self.providedRole_AssemblyConnector.providedInterface__ProvidedRole->closure(parentInterface__Interface)->exists(interface|interface = self.requiredRole_AssemblyConnector.requiredInterface__RequiredRole)
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.providedRole_AssemblyConnector.providedInterface__ProvidedRole = self.requiredRole_AssemblyConnector.requiredInterface__RequiredRole or \r\nself.providedRole_AssemblyConnector.providedInterface__ProvidedRole->closure(parentInterface__Interface)->exists(interface|interface = self.requiredRole_AssemblyConnector.requiredInterface__RequiredRole)\r\n'"
	 * @generated
	 */
	boolean AssemblyConnectorsReferencedInterfacesMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AssemblyConnector
