/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantum Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.QuantumTimeSliceConfiguration#getQuanta <em>Quanta</em>}</li>
 *   <li>{@link scheduler.configuration.QuantumTimeSliceConfiguration#getMinQuanta <em>Min Quanta</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getQuantumTimeSliceConfiguration()
 * @model
 * @generated
 */
public interface QuantumTimeSliceConfiguration extends TimeSliceConfiguration {
	/**
	 * Returns the value of the '<em><b>Quanta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quanta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quanta</em>' attribute.
	 * @see #setQuanta(int)
	 * @see scheduler.configuration.ConfigurationPackage#getQuantumTimeSliceConfiguration_Quanta()
	 * @model
	 * @generated
	 */
	int getQuanta();

	/**
	 * Sets the value of the '{@link scheduler.configuration.QuantumTimeSliceConfiguration#getQuanta <em>Quanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quanta</em>' attribute.
	 * @see #getQuanta()
	 * @generated
	 */
	void setQuanta(int value);

	/**
	 * Returns the value of the '<em><b>Min Quanta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Quanta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Quanta</em>' attribute.
	 * @see #setMinQuanta(int)
	 * @see scheduler.configuration.ConfigurationPackage#getQuantumTimeSliceConfiguration_MinQuanta()
	 * @model
	 * @generated
	 */
	int getMinQuanta();

	/**
	 * Sets the value of the '{@link scheduler.configuration.QuantumTimeSliceConfiguration#getMinQuanta <em>Min Quanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Quanta</em>' attribute.
	 * @see #getMinQuanta()
	 * @generated
	 */
	void setMinQuanta(int value);

} // QuantumTimeSliceConfiguration
