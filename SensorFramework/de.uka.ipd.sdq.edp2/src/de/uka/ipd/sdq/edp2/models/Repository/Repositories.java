/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repositories</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains&nbsp;a&nbsp;list&nbsp;of&nbsp;available&nbsp;repositories.&nbsp;Can&nbsp;be&nbsp;used&nbsp;to&nbsp;load/store&nbsp;the&nbsp;list&nbsp;of&nbsp;available&nbsp;repositories.
 * Also provides the advantage that links between the different available repositories at runtime can be resolved. E.g. this
 * allows reusing metric definitions from one repository in another one.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories#getAvailableRepositories <em>Available Repositories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories#getCommonResourceSet <em>Common Resource Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getRepositories()
 * @model
 * @generated
 */
public interface Repositories extends EObject {
	/**
     * Returns the value of the '<em><b>Available Repositories</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.Repository.Repository}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#getRepositories <em>Repositories</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Repositories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Available Repositories</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getRepositories_AvailableRepositories()
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#getRepositories
     * @model opposite="repositories" containment="true" ordered="false"
     * @generated
     */
	EList<Repository> getAvailableRepositories();

	/**
     * Returns the value of the '<em><b>Common Resource Set</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Common Resource Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Common Resource Set</em>' reference.
     * @see #setCommonResourceSet(ResourceSet)
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#getRepositories_CommonResourceSet()
     * @model type="de.uka.ipd.sdq.edp2.models.Repository.IResourceSet" required="true" transient="true" ordered="false"
     * @generated
     */
	ResourceSet getCommonResourceSet();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories#getCommonResourceSet <em>Common Resource Set</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Common Resource Set</em>' reference.
     * @see #getCommonResourceSet()
     * @generated
     */
	void setCommonResourceSet(ResourceSet value);

} // Repositories
