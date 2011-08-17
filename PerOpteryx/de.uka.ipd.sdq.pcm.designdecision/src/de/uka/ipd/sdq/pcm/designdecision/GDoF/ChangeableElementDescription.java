/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Changeable Element Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription#getChangeable <em>Changeable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription#getValueRule <em>Value Rule</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription#getSelectionRule <em>Selection Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getChangeableElementDescription()
 * @model
 * @generated
 */
public interface ChangeableElementDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changeable</em>' reference.
	 * @see #setChangeable(EStructuralFeature)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getChangeableElementDescription_Changeable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EStructuralFeature getChangeable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription#getChangeable <em>Changeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changeable</em>' reference.
	 * @see #getChangeable()
	 * @generated
	 */
	void setChangeable(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Value Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "The value rules are defined in the context of the selected instance of $p_i$'s container class."
	 * 
	 * For each $p_i$, rules describe the set of all potential new values that $p_i$ may take in combination with any other change of the other change types for the metamodel at hand. For $p_i$, the description of all potential new values is an OCL query \function{valueRule}{$p_i$} which returns a range $R$ of possible values for \texttt{Properties} of \texttt{Type} \texttt{DataType}, or a set of model elements for \texttt{Properties} of \texttt{Type} \texttt{Class}. The value rules are defined in the context of the selected instance of $p_i$'s container class.
	 * 	
	 * 	The value rules may also refer to other changeable elements $p_j, j < i$. The restriction $j < i$ here ensures that the allowed values can be determined by one pass through all \texttt{Properties}. While the new values of \texttt{Properties} of \texttt{Type} \texttt{Class} can always be defined generically on the meta model level, the values for \texttt{Properties} of \texttt{Type} \texttt{DataType} may depend on the model instance at hand. Then, a generic range is given on the meta model level, which can be restricted on the model instance level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Rule</em>' containment reference.
	 * @see #setValueRule(ValueRule)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getChangeableElementDescription_ValueRule()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ValueRule getValueRule();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription#getValueRule <em>Value Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Rule</em>' containment reference.
	 * @see #getValueRule()
	 * @generated
	 */
	void setValueRule(ValueRule value);

	/**
	 * Returns the value of the '<em><b>Selection Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "The selection rules for the primary element can be defined in any context."
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Selection Rule</em>' containment reference.
	 * @see #setSelectionRule(SelectionRule)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getChangeableElementDescription_SelectionRule()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SelectionRule getSelectionRule();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription#getSelectionRule <em>Selection Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Rule</em>' containment reference.
	 * @see #getSelectionRule()
	 * @generated
	 */
	void setSelectionRule(SelectionRule value);

} // ChangeableElementDescription
