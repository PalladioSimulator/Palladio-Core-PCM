/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class represents DegreeOfFreedoms that have an enumeration domain. The set of possile values of the degree of freedom are referenced with the domainOfEntities property. Any kind of PCM element can be annotated here. Subclasses restrict the type of annotated elements with OCL constraints.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree#getDomainOfEntities <em>Domain Of Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumerationDegree()
 * @model abstract="true"
 * @generated
 */
public interface EnumerationDegree extends DegreeOfFreedom {
	/**
	 * Returns the value of the '<em><b>Domain Of Entities</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.core.entity.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Of Entities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Of Entities</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumerationDegree_DomainOfEntities()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Entity> getDomainOfEntities();

} // EnumerationDegree
