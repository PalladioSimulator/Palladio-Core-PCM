/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effort Estimation Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getNumberTestcases <em>Number Testcases</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetId <em>Target Id</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetUri <em>Target Uri</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult()
 * @model
 * @generated
 */
public interface EffortEstimationResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Testcases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Testcases</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     Estimation on the number of test cases required to test the targeted ResourceDemandingBehaviour.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Testcases</em>' attribute.
	 * @see #setNumberTestcases(int)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_NumberTestcases()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNumberTestcases();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getNumberTestcases <em>Number Testcases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Testcases</em>' attribute.
	 * @see #getNumberTestcases()
	 * @generated
	 */
	void setNumberTestcases(int value);

	/**
	 * Returns the value of the '<em><b>Target Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * UUID of the targeted ResourceDemandingBehaviour.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Id</em>' attribute.
	 * @see #setTargetId(String)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_TargetId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTargetId();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetId <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Id</em>' attribute.
	 * @see #getTargetId()
	 * @generated
	 */
	void setTargetId(String value);

	/**
	 * Returns the value of the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Confidence level. Reasonable values are within (0,1). 0 means no tests are required, 1 can only be fulfilled if there are
	 * no<br />
	 * probabilistc transitions in the graph.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alpha</em>' attribute.
	 * @see #setAlpha(double)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_Alpha()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getAlpha();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getAlpha <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha</em>' attribute.
	 * @see #getAlpha()
	 * @generated
	 */
	void setAlpha(double value);

	/**
	 * Returns the value of the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * String representation of the URI which identifies the resource containing the targeted ResourceDemandingBehaviour.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Uri</em>' attribute.
	 * @see #setTargetUri(String)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_TargetUri()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTargetUri();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getTargetUri <em>Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Uri</em>' attribute.
	 * @see #getTargetUri()
	 * @generated
	 */
	void setTargetUri(String value);

	/**
	 * Returns the value of the '<em><b>Resource Demanding Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     Direct reference of the targeted ResourceDemandingBehaviour.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Demanding Behaviour</em>' reference.
	 * @see #setResourceDemandingBehaviour(ResourceDemandingBehaviour)
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#getEffortEstimationResult_ResourceDemandingBehaviour()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceDemandingBehaviour getResourceDemandingBehaviour();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.EffortEstimationResult#getResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Demanding Behaviour</em>' reference.
	 * @see #getResourceDemandingBehaviour()
	 * @generated
	 */
	void setResourceDemandingBehaviour(ResourceDemandingBehaviour value);

} // EffortEstimationResult
