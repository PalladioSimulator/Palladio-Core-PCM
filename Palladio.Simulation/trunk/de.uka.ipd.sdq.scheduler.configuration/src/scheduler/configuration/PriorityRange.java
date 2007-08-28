/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.PriorityRange#getHighest <em>Highest</em>}</li>
 *   <li>{@link scheduler.configuration.PriorityRange#getHigh <em>High</em>}</li>
 *   <li>{@link scheduler.configuration.PriorityRange#getAverage <em>Average</em>}</li>
 *   <li>{@link scheduler.configuration.PriorityRange#getLow <em>Low</em>}</li>
 *   <li>{@link scheduler.configuration.PriorityRange#getLowest <em>Lowest</em>}</li>
 *   <li>{@link scheduler.configuration.PriorityRange#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange()
 * @model
 * @generated
 */
public interface PriorityRange extends EObject {
	/**
	 * Returns the value of the '<em><b>Highest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highest</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highest</em>' attribute.
	 * @see #setHighest(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange_Highest()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getHighest();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityRange#getHighest <em>Highest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highest</em>' attribute.
	 * @see #getHighest()
	 * @generated
	 */
	void setHighest(int value);

	/**
	 * Returns the value of the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>High</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>High</em>' attribute.
	 * @see #setHigh(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange_High()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getHigh();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityRange#getHigh <em>High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High</em>' attribute.
	 * @see #getHigh()
	 * @generated
	 */
	void setHigh(int value);

	/**
	 * Returns the value of the '<em><b>Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Average</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Average</em>' attribute.
	 * @see #setAverage(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange_Average()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getAverage();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityRange#getAverage <em>Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Average</em>' attribute.
	 * @see #getAverage()
	 * @generated
	 */
	void setAverage(int value);

	/**
	 * Returns the value of the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Low</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Low</em>' attribute.
	 * @see #setLow(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange_Low()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLow();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityRange#getLow <em>Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low</em>' attribute.
	 * @see #getLow()
	 * @generated
	 */
	void setLow(int value);

	/**
	 * Returns the value of the '<em><b>Lowest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lowest</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lowest</em>' attribute.
	 * @see #setLowest(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange_Lowest()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLowest();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityRange#getLowest <em>Lowest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lowest</em>' attribute.
	 * @see #getLowest()
	 * @generated
	 */
	void setLowest(int value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityRange_Default()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getDefault();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityRange#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(int value);

} // PriorityRange
