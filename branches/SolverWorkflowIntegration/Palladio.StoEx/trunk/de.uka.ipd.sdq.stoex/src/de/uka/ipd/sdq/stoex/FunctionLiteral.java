/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.FunctionLiteral#getId <em>Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.FunctionLiteral#getParameters_FunctionLiteral <em>Parameters Function Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getFunctionLiteral()
 * @model
 * @generated
 */
public interface FunctionLiteral extends Atom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getFunctionLiteral_Id()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.FunctionLiteral#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Parameters Function Literal</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.stoex.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters Function Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters Function Literal</em>' containment reference list.
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getFunctionLiteral_Parameters_FunctionLiteral()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getParameters_FunctionLiteral();

} // FunctionLiteral
