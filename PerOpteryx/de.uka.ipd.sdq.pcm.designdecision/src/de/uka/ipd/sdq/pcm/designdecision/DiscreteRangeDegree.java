/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Discrete Range Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents DegreeOfFreedoms that have a range of integer values as their domain. The set of possile values of the degree of freedom is defined as the integer interval between "from" and "to".
 * 
 * TODO OCL: from must be smaller that to. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getTo <em>To</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDiscreteRangeDegree()
 * @model
 * @generated
 */
public interface DiscreteRangeDegree extends RangeDegree, DiscreteDegree {
	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(int)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDiscreteRangeDegree_To()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getTo();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(int value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(int)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDiscreteRangeDegree_From()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getFrom();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(int value);

} // DiscreteRangeDegree
