/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;



import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unordered Primitive Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.UnorderedPrimitiveDegree#getPrimitiveValues <em>Primitive Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getUnorderedPrimitiveDegree()
 * @model
 * @generated
 */
public interface UnorderedPrimitiveDegree extends UnorderedDegree {
	/**
	 * Returns the value of the '<em><b>Primitive Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Values</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getUnorderedPrimitiveDegree_PrimitiveValues()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<EDataType> getPrimitiveValues();

} // UnorderedPrimitiveDegree
