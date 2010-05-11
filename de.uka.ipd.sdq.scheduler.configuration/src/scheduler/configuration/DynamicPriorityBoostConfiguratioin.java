/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Priority Boost Configuratioin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxBonus <em>Max Bonus</em>}</li>
 *   <li>{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxSleepAverage <em>Max Sleep Average</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getDynamicPriorityBoostConfiguratioin()
 * @model
 * @generated
 */
public interface DynamicPriorityBoostConfiguratioin extends PriorityBoostConfiguration {
	/**
	 * Returns the value of the '<em><b>Max Bonus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Bonus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Bonus</em>' attribute.
	 * @see #setMaxBonus(int)
	 * @see scheduler.configuration.ConfigurationPackage#getDynamicPriorityBoostConfiguratioin_MaxBonus()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getMaxBonus();

	/**
	 * Sets the value of the '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxBonus <em>Max Bonus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Bonus</em>' attribute.
	 * @see #getMaxBonus()
	 * @generated
	 */
	void setMaxBonus(int value);

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(int)
	 * @see scheduler.configuration.ConfigurationPackage#getDynamicPriorityBoostConfiguratioin_Threshold()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getThreshold();

	/**
	 * Sets the value of the '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(int value);

	/**
	 * Returns the value of the '<em><b>Max Sleep Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Sleep Average</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Sleep Average</em>' attribute.
	 * @see #setMaxSleepAverage(double)
	 * @see scheduler.configuration.ConfigurationPackage#getDynamicPriorityBoostConfiguratioin_MaxSleepAverage()
	 * @model
	 * @generated
	 */
	double getMaxSleepAverage();

	/**
	 * Sets the value of the '{@link scheduler.configuration.DynamicPriorityBoostConfiguratioin#getMaxSleepAverage <em>Max Sleep Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Sleep Average</em>' attribute.
	 * @see #getMaxSleepAverage()
	 * @generated
	 */
	void setMaxSleepAverage(double value);

} // DynamicPriorityBoostConfiguratioin
