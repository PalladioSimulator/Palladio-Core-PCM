/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.PCMLink;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.PCMLink.PCMLinkRepository#getComponentfilelink <em>Componentfilelink</em>}</li>
 *   <li>{@link SourceCodeDecorator.PCMLink.PCMLinkRepository#getSeffmethodlink <em>Seffmethodlink</em>}</li>
 *   <li>{@link SourceCodeDecorator.PCMLink.PCMLinkRepository#getActioncontrolflowlink <em>Actioncontrolflowlink</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository()
 * @model
 * @generated
 */
public interface PCMLinkRepository extends Identifier {
	/**
	 * Returns the value of the '<em><b>Componentfilelink</b></em>' containment reference list.
	 * The list contents are of type {@link SourceCodeDecorator.PCMLink.ComponentFileLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Componentfilelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Componentfilelink</em>' containment reference list.
	 * @see SourceCodeDecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_Componentfilelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ComponentFileLink> getComponentfilelink();

	/**
	 * Returns the value of the '<em><b>Seffmethodlink</b></em>' containment reference list.
	 * The list contents are of type {@link SourceCodeDecorator.PCMLink.SEFFMethodLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seffmethodlink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seffmethodlink</em>' containment reference list.
	 * @see SourceCodeDecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_Seffmethodlink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SEFFMethodLink> getSeffmethodlink();

	/**
	 * Returns the value of the '<em><b>Actioncontrolflowlink</b></em>' containment reference list.
	 * The list contents are of type {@link SourceCodeDecorator.PCMLink.ActionControlFlowLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actioncontrolflowlink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actioncontrolflowlink</em>' containment reference list.
	 * @see SourceCodeDecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_Actioncontrolflowlink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ActionControlFlowLink> getActioncontrolflowlink();

} // PCMLinkRepository
