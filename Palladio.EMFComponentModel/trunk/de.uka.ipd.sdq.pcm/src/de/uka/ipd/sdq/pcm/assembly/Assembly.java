
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.Assembly#getAssemblycontexts_Assembly <em>Assemblycontexts Assembly</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.Assembly#getAssemblyConnectors_Assembly <em>Assembly Connectors Assembly</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getAssembly()
 * @model
 * @generated
 */
public interface Assembly extends Entity {
	/**
	 * Returns the value of the '<em><b>Assemblycontexts Assembly</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.assembly.AssemblyContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assemblycontexts Assembly</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assemblycontexts Assembly</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getAssembly_Assemblycontexts_Assembly()
	 * @model type="de.uka.ipd.sdq.pcm.assembly.AssemblyContext" containment="true" ordered="false"
	 * @generated
	 */
	EList getAssemblycontexts_Assembly();

	/**
	 * Returns the value of the '<em><b>Assembly Connectors Assembly</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assembly Connectors Assembly</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assembly Connectors Assembly</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.assembly.AssemblyPackage#getAssembly_AssemblyConnectors_Assembly()
	 * @model type="de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector" containment="true" ordered="false"
	 * @generated
	 */
	EList getAssemblyConnectors_Assembly();

} // Assembly