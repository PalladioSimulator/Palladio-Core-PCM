/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.repository.DelegationConnector;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getAssemblyContext_RequiredDelegationConnector <em>Assembly Context Required Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getParentStructure_RequiredDelegationConnector <em>Parent Structure Required Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getRequiredDelegationConnector()
 * @model
 * @generated
 */
public interface RequiredDelegationConnector extends DelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Inner Required Role Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Required Role Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Required Role Required Delegation Connector</em>' reference.
	 * @see #setInnerRequiredRole_RequiredDelegationConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getRequiredDelegationConnector_InnerRequiredRole_RequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getInnerRequiredRole_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getInnerRequiredRole_RequiredDelegationConnector <em>Inner Required Role Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Required Role Required Delegation Connector</em>' reference.
	 * @see #getInnerRequiredRole_RequiredDelegationConnector()
	 * @generated
	 */
	void setInnerRequiredRole_RequiredDelegationConnector(RequiredRole value);

	/**
	 * Returns the value of the '<em><b>Outer Required Role Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Required Role Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Required Role Required Delegation Connector</em>' reference.
	 * @see #setOuterRequiredRole_RequiredDelegationConnector(RequiredRole)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getRequiredDelegationConnector_OuterRequiredRole_RequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RequiredRole getOuterRequiredRole_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getOuterRequiredRole_RequiredDelegationConnector <em>Outer Required Role Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Required Role Required Delegation Connector</em>' reference.
	 * @see #getOuterRequiredRole_RequiredDelegationConnector()
	 * @generated
	 */
	void setOuterRequiredRole_RequiredDelegationConnector(RequiredRole value);

	/**
	 * Returns the value of the '<em><b>Assembly Context Required Delegation Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Context Required Delegation Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Context Required Delegation Connector</em>' reference.
	 * @see #setAssemblyContext_RequiredDelegationConnector(AssemblyContext)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getRequiredDelegationConnector_AssemblyContext_RequiredDelegationConnector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AssemblyContext getAssemblyContext_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getAssemblyContext_RequiredDelegationConnector <em>Assembly Context Required Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assembly Context Required Delegation Connector</em>' reference.
	 * @see #getAssemblyContext_RequiredDelegationConnector()
	 * @generated
	 */
	void setAssemblyContext_RequiredDelegationConnector(AssemblyContext value);

	/**
	 * Returns the value of the '<em><b>Parent Structure Required Delegation Connector</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Structure Required Delegation Connector</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Structure Required Delegation Connector</em>' container reference.
	 * @see #setParentStructure_RequiredDelegationConnector(ComposedStructure)
	 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage#getRequiredDelegationConnector_ParentStructure_RequiredDelegationConnector()
	 * @see de.uka.ipd.sdq.pcm.core.composition.ComposedStructure#getRequiredDelegationConnectors_ComposedStructure
	 * @model opposite="requiredDelegationConnectors_ComposedStructure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ComposedStructure getParentStructure_RequiredDelegationConnector();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector#getParentStructure_RequiredDelegationConnector <em>Parent Structure Required Delegation Connector</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Structure Required Delegation Connector</em>' container reference.
	 * @see #getParentStructure_RequiredDelegationConnector()
	 * @generated
	 */
	void setParentStructure_RequiredDelegationConnector(ComposedStructure value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parentStructure_RequiredDelegationConnector = self.assemblyContext_RequiredDelegationConnector.parentStructure_AssemblyContext
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean RequiredDelegationConnectorandtheconnectedComponentmustbepartofthesamecompositestructure(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.innerRequiredRole_RequiredDelegationConnector.requiringEntity_RequiredRole = self.assemblyContext_RequiredDelegationConnector.encapsulatedComponent_AssemblyContext
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ComponentOfAssemblyContextAndInnerRoleRequiringComponentNeedToBeTheSame(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RequiredDelegationConnector
