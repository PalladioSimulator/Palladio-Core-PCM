/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.seff;

import de.ipd.uka.sdq.pcm.resourcetype.ProcessingResourceType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getDemand <em>Demand</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getUnit <em>Unit</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getParametricResourceDemand()
 * @model
 * @generated
 */
public interface ParametricResourceDemand extends EObject {
	/**
	 * Returns the value of the '<em><b>Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demand</em>' attribute.
	 * @see #setDemand(String)
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getParametricResourceDemand_Demand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDemand();

	/**
	 * Sets the value of the '{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getDemand <em>Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demand</em>' attribute.
	 * @see #getDemand()
	 * @generated
	 */
	void setDemand(String value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getParametricResourceDemand_Unit()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

	/**
	 * Returns the value of the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Resource Parametric Resource Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Resource Parametric Resource Demand</em>' reference.
	 * @see #setRequiredResource_ParametricResourceDemand(ProcessingResourceType)
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getParametricResourceDemand_RequiredResource_ParametricResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceType getRequiredResource_ParametricResourceDemand();

	/**
	 * Sets the value of the '{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Resource Parametric Resource Demand</em>' reference.
	 * @see #getRequiredResource_ParametricResourceDemand()
	 * @generated
	 */
	void setRequiredResource_ParametricResourceDemand(ProcessingResourceType value);

	/**
	 * Returns the value of the '<em><b>Action Parametric Resource Demand</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.ipd.uka.sdq.pcm.seff.AbstractResourceDemandingAction#getResourceDemand_Action <em>Resource Demand Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Parametric Resource Demand</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Parametric Resource Demand</em>' reference.
	 * @see #setAction_ParametricResourceDemand(AbstractResourceDemandingAction)
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getParametricResourceDemand_Action_ParametricResourceDemand()
	 * @see de.ipd.uka.sdq.pcm.seff.AbstractResourceDemandingAction#getResourceDemand_Action
	 * @model opposite="resourceDemand_Action" required="true" ordered="false"
	 * @generated
	 */
	AbstractResourceDemandingAction getAction_ParametricResourceDemand();

	/**
	 * Sets the value of the '{@link de.ipd.uka.sdq.pcm.seff.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Parametric Resource Demand</em>' reference.
	 * @see #getAction_ParametricResourceDemand()
	 * @generated
	 */
	void setAction_ParametricResourceDemand(AbstractResourceDemandingAction value);

} // ParametricResourceDemand