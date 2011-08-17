/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Passive Resource Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.PassiveResourceConfiguration#getStaticPriorityBoostConfiguration <em>Static Priority Boost Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.PassiveResourceConfiguration#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link scheduler.configuration.PassiveResourceConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link scheduler.configuration.PassiveResourceConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.PassiveResourceConfiguration#getManagingResource <em>Managing Resource</em>}</li>
 *   <li>{@link scheduler.configuration.PassiveResourceConfiguration#getAcquisitionDemand <em>Acquisition Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration()
 * @model
 * @generated
 */
public interface PassiveResourceConfiguration extends Identifier {
	/**
	 * Returns the value of the '<em><b>Static Priority Boost Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Priority Boost Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Priority Boost Configuration</em>' containment reference.
	 * @see #setStaticPriorityBoostConfiguration(StaticPriorityBoost)
	 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration_StaticPriorityBoostConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StaticPriorityBoost getStaticPriorityBoostConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PassiveResourceConfiguration#getStaticPriorityBoostConfiguration <em>Static Priority Boost Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Priority Boost Configuration</em>' containment reference.
	 * @see #getStaticPriorityBoostConfiguration()
	 * @generated
	 */
	void setStaticPriorityBoostConfiguration(StaticPriorityBoost value);

	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(int)
	 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration_Capacity()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getCapacity();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PassiveResourceConfiguration#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.PassiveResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see scheduler.configuration.PassiveResourceType
	 * @see #setType(PassiveResourceType)
	 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PassiveResourceType getType();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PassiveResourceConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see scheduler.configuration.PassiveResourceType
	 * @see #getType()
	 * @generated
	 */
	void setType(PassiveResourceType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PassiveResourceConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Managing Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managing Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managing Resource</em>' reference.
	 * @see #setManagingResource(ActiveResourceConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration_ManagingResource()
	 * @model ordered="false"
	 * @generated
	 */
	ActiveResourceConfiguration getManagingResource();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PassiveResourceConfiguration#getManagingResource <em>Managing Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managing Resource</em>' reference.
	 * @see #getManagingResource()
	 * @generated
	 */
	void setManagingResource(ActiveResourceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Acquisition Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acquisition Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquisition Demand</em>' attribute.
	 * @see #setAcquisitionDemand(double)
	 * @see scheduler.configuration.ConfigurationPackage#getPassiveResourceConfiguration_AcquisitionDemand()
	 * @model
	 * @generated
	 */
	double getAcquisitionDemand();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PassiveResourceConfiguration#getAcquisitionDemand <em>Acquisition Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acquisition Demand</em>' attribute.
	 * @see #getAcquisitionDemand()
	 * @generated
	 */
	void setAcquisitionDemand(double value);

} // PassiveResourceConfiguration
