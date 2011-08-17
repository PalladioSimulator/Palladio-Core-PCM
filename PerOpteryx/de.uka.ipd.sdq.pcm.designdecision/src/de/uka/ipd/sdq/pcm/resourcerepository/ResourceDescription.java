/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcerepository;

import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getFixedProcessingResourceCost_ResourceDescription <em>Fixed Processing Resource Cost Resource Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getProcessingResourceSpecification_ResourceDescription <em>Processing Resource Specification Resource Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage#getResourceDescription()
 * @model
 * @generated
 */
public interface ResourceDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Fixed Processing Resource Cost Resource Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Processing Resource Cost Resource Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Processing Resource Cost Resource Description</em>' containment reference.
	 * @see #setFixedProcessingResourceCost_ResourceDescription(FixedProcessingResourceCost)
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage#getResourceDescription_FixedProcessingResourceCost_ResourceDescription()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	FixedProcessingResourceCost getFixedProcessingResourceCost_ResourceDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getFixedProcessingResourceCost_ResourceDescription <em>Fixed Processing Resource Cost Resource Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Processing Resource Cost Resource Description</em>' containment reference.
	 * @see #getFixedProcessingResourceCost_ResourceDescription()
	 * @generated
	 */
	void setFixedProcessingResourceCost_ResourceDescription(FixedProcessingResourceCost value);

	/**
	 * Returns the value of the '<em><b>Processing Resource Specification Resource Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Resource Specification Resource Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Resource Specification Resource Description</em>' containment reference.
	 * @see #setProcessingResourceSpecification_ResourceDescription(ProcessingResourceSpecification)
	 * @see de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage#getResourceDescription_ProcessingResourceSpecification_ResourceDescription()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getProcessingResourceSpecification_ResourceDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcerepository.ResourceDescription#getProcessingResourceSpecification_ResourceDescription <em>Processing Resource Specification Resource Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Resource Specification Resource Description</em>' containment reference.
	 * @see #getProcessingResourceSpecification_ResourceDescription()
	 * @generated
	 */
	void setProcessingResourceSpecification_ResourceDescription(ProcessingResourceSpecification value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.fixedProcessingResourceCost_ResourceDescription.processingresourcespecification = self.processingresourcespecification
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean CostAndResourceMustMatch(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceDescription
