/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Repository;

import de.uka.ipd.sdq.edp2.MetaDao;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.edp2.MetaDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.Description;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getStatus <em>Status</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getExperimentGroup <em>Experiment Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRepository()
 * @model abstract="true" superTypes="de.uka.ipd.sdq.edp2.models.emfmodel.Identifiable de.uka.ipd.sdq.edp2.models.emfmodel.Repository.MetaDao"
 * @generated
 */
public interface Repository extends Identifiable, MetaDao {
	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories#getAvailableRepositories <em>Available Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositories</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' container reference.
	 * @see #setRepositories(Repositories)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRepository_Repositories()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories#getAvailableRepositories
	 * @model opposite="availableRepositories" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Repositories getRepositories();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getRepositories <em>Repositories</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repositories</em>' container reference.
	 * @see #getRepositories()
	 * @generated
	 */
	void setRepositories(Repositories value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryStatus
	 * @see #setStatus(RepositoryStatus)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRepository_Status()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RepositoryStatus getStatus();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(RepositoryStatus value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRepository_ReadOnly()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.Description}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Description#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRepository_Description()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Description#getRepository
	 * @model opposite="repository" ordered="false"
	 * @generated
	 */
	EList<Description> getDescription();

	/**
	 * Returns the value of the '<em><b>Experiment Group</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Group</em>' reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage#getRepository_ExperimentGroup()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getRepository
	 * @model opposite="repository" ordered="false"
	 * @generated
	 */
	EList<ExperimentGroup> getExperimentGroup();

} // Repository
