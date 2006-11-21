/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Demand Server Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getDemand <em>Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getServer <em>Server</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getUsageProbability <em>Usage Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getMeanUsageTime <em>Mean Usage Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandServerUsage()
 * @model
 * @generated
 */
public interface DemandServerUsage extends EObject {
	/**
	 * Returns the value of the '<em><b>Demand</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServerUsages <em>Server Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand</em>' reference.
	 * @see #setDemand(DemandResult)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandServerUsage_Demand()
	 * @see de.uka.ipd.sdq.qnm.qnResult.DemandResult#getServerUsages
	 * @model opposite="serverUsages" required="true"
	 * @generated
	 */
	DemandResult getDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getDemand <em>Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demand</em>' reference.
	 * @see #getDemand()
	 * @generated
	 */
	void setDemand(DemandResult value);

	/**
	 * Returns the value of the '<em><b>Server</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsageDemands <em>Usage Demands</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server</em>' reference.
	 * @see #setServer(ServerResult)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandServerUsage_Server()
	 * @see de.uka.ipd.sdq.qnm.qnResult.ServerResult#getUsageDemands
	 * @model opposite="usageDemands" required="true"
	 * @generated
	 */
	ServerResult getServer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getServer <em>Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server</em>' reference.
	 * @see #getServer()
	 * @generated
	 */
	void setServer(ServerResult value);

	/**
	 * Returns the value of the '<em><b>Usage Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Probability</em>' attribute.
	 * @see #setUsageProbability(double)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandServerUsage_UsageProbability()
	 * @model required="true"
	 * @generated
	 */
	double getUsageProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getUsageProbability <em>Usage Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Probability</em>' attribute.
	 * @see #getUsageProbability()
	 * @generated
	 */
	void setUsageProbability(double value);

	/**
	 * Returns the value of the '<em><b>Mean Usage Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean Usage Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mean Usage Time</em>' attribute.
	 * @see #setMeanUsageTime(double)
	 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage#getDemandServerUsage_MeanUsageTime()
	 * @model required="true"
	 * @generated
	 */
	double getMeanUsageTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.qnResult.DemandServerUsage#getMeanUsageTime <em>Mean Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean Usage Time</em>' attribute.
	 * @see #getMeanUsageTime()
	 * @generated
	 */
	void setMeanUsageTime(double value);

} // DemandServerUsage