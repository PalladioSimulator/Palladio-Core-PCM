/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QML Declarations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Declarations&nbsp;contain definitions of any of the three abstraction mechanisms: contract type, contract,
 *     profile.&nbsp;Contract and profile can be a definition (simple) or a refinement.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarations#getQmlDeclarations <em>Qml Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage#getQMLDeclarations()
 * @model
 * @generated
 */
public interface QMLDeclarations extends Identifier {
	/**
	 * Returns the value of the '<em><b>Qml Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qml Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qml Declarations</em>' containment reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage#getQMLDeclarations_QmlDeclarations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<QMLDeclaration> getQmlDeclarations();

} // QMLDeclarations
