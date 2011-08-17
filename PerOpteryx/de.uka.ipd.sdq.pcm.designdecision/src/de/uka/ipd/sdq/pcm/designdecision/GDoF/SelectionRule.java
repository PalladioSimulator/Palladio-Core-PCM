/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Properties cannot be directly selected in models based on EMOF. Thus, we select the changeable container \function{changeableContainer}{$p_i$}. 
 * 
 * 	The default selection rule selects all instances of \function{changeableContainer}{$p_i$}. In that case, selectionRule is null. 
 * 
 * The GDoF may specify more specific rules that constrain which instances of \function{changeableContainer}{$p_i$} can be selected. For each changeable element, this can be expressed by an OCL query \function{selectionRule}{$p_i$} selecting the instances of this \texttt{Property}'s class \function{changeableContainer}{$p_i$}. 
 * 
 * This query defines which instances of \function{changeableContainer}{$p_i$} are possible, either statically or based on another selected instance of $C_j, j < i$. In the latter case, the query is defined in the OCL context of the selected instance of $C_j$. To avoid cycles, only the values of preceding \texttt{Properties} $p_j, j < i$ may be referenced. 
 * 
 * 	The selection rules for the primary element can be defined in any context. They are executed for each instance of the metamodel element in whose context they are defined and the union of the results is the set of matching model elements.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getSelectionRule()
 * @model abstract="true"
 * @generated
 */
public interface SelectionRule extends OCLRule {
} // SelectionRule
