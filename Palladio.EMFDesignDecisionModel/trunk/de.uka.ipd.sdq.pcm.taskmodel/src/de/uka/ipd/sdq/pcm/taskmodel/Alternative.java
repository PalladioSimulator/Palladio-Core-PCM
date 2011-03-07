/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * One Alternative contains all AlternativeTasks that together represent a component selection. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Alternative#getAlternativetasks_Alternative <em>Alternativetasks Alternative</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends EObject {
	/**
	 * Returns the value of the '<em><b>Alternativetasks Alternative</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.taskmodel.AlternativeTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternativetasks Alternative</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternativetasks Alternative</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getAlternative_Alternativetasks_Alternative()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<AlternativeTask> getAlternativetasks_Alternative();

} // Alternative
