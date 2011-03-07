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
 * A representation of the model object '<em><b>Static Priority Boost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.StaticPriorityBoost#isResetTimeslice <em>Reset Timeslice</em>}</li>
 *   <li>{@link scheduler.configuration.StaticPriorityBoost#getBonus <em>Bonus</em>}</li>
 *   <li>{@link scheduler.configuration.StaticPriorityBoost#getDegradation <em>Degradation</em>}</li>
 *   <li>{@link scheduler.configuration.StaticPriorityBoost#getTimePenalty <em>Time Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoost()
 * @model
 * @generated
 */
public interface StaticPriorityBoost extends EObject {
	/**
	 * Returns the value of the '<em><b>Reset Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset Timeslice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Timeslice</em>' attribute.
	 * @see #setResetTimeslice(boolean)
	 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoost_ResetTimeslice()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isResetTimeslice();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StaticPriorityBoost#isResetTimeslice <em>Reset Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Timeslice</em>' attribute.
	 * @see #isResetTimeslice()
	 * @generated
	 */
	void setResetTimeslice(boolean value);

	/**
	 * Returns the value of the '<em><b>Bonus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bonus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bonus</em>' attribute.
	 * @see #setBonus(int)
	 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoost_Bonus()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getBonus();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StaticPriorityBoost#getBonus <em>Bonus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bonus</em>' attribute.
	 * @see #getBonus()
	 * @generated
	 */
	void setBonus(int value);

	/**
	 * Returns the value of the '<em><b>Degradation</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.PriorityDegradation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degradation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degradation</em>' attribute.
	 * @see scheduler.configuration.PriorityDegradation
	 * @see #setDegradation(PriorityDegradation)
	 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoost_Degradation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PriorityDegradation getDegradation();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StaticPriorityBoost#getDegradation <em>Degradation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Degradation</em>' attribute.
	 * @see scheduler.configuration.PriorityDegradation
	 * @see #getDegradation()
	 * @generated
	 */
	void setDegradation(PriorityDegradation value);

	/**
	 * Returns the value of the '<em><b>Time Penalty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Penalty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Penalty</em>' attribute.
	 * @see #setTimePenalty(double)
	 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoost_TimePenalty()
	 * @model
	 * @generated
	 */
	double getTimePenalty();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StaticPriorityBoost#getTimePenalty <em>Time Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Penalty</em>' attribute.
	 * @see #getTimePenalty()
	 * @generated
	 */
	void setTimePenalty(double value);

} // StaticPriorityBoost
