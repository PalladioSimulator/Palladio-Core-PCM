/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Repository entity represents composition of FirstClassEntities that could be reused and composed into more complex architectures.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.FirstClassEntity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property associates all the entities that are available in repository.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getRepository_Entities()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FirstClassEntity> getEntities();

} // Repository
