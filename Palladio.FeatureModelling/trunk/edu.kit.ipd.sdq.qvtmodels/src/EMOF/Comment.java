/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EMOF;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EMOF.Comment#getAnnotatedElement <em>Annotated Element</em>}</li>
 *   <li>{@link EMOF.Comment#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see EMOF.EMOFPackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends Element {
	/**
	 * Returns the value of the '<em><b>Annotated Element</b></em>' reference list.
	 * The list contents are of type {@link EMOF.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Element</em>' reference list.
	 * @see EMOF.EMOFPackage#getComment_AnnotatedElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<NamedElement> getAnnotatedElement();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see EMOF.EMOFPackage#getComment_Body()
	 * @model dataType="EMOF.String"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link EMOF.Comment#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

} // Comment
