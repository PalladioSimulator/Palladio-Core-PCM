/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equidistant Partitions Random</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.EquidistantPartitionsRandom#getNumberPartitions <em>Number Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.TestbasedPackage#getEquidistantPartitionsRandom()
 * @model
 * @generated
 */
public interface EquidistantPartitionsRandom extends TestcaseGenerationStrategy {
	/**
	 * Returns the value of the '<em><b>Number Partitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Partitions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Partitions</em>' attribute.
	 * @see #setNumberPartitions(long)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getEquidistantPartitionsRandom_NumberPartitions()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getNumberPartitions();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.EquidistantPartitionsRandom#getNumberPartitions <em>Number Partitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Partitions</em>' attribute.
	 * @see #getNumberPartitions()
	 * @generated
	 */
	void setNumberPartitions(long value);

} // EquidistantPartitionsRandom
