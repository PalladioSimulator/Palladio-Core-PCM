/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents DegreeOfFreedoms that have an enumeration domain. The set of possile values of the degree of freedom are referenced with the domainOfEntities property. Any kind of PCM element can be annotated here. Subclasses restrict the type of annotated elements with OCL constraints.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ClassDegree#getClassDesignOptions <em>Class Design Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getClassDegree()
 * @model abstract="true"
 * @generated
 */
public interface ClassDegree extends DegreeOfFreedomInstance {
	/**
	 * Returns the value of the '<em><b>Class Design Options</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Design Options</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Design Options</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getClassDegree_ClassDesignOptions()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<EObject> getClassDesignOptions();

} // ClassDegree
