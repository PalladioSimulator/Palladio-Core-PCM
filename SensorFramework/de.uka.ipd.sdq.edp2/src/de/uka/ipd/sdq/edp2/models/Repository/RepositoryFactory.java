/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage
 * @generated
 */
public interface RepositoryFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	RepositoryFactory eINSTANCE = de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Local Directory Repository</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Local Directory Repository</em>'.
     * @generated
     */
	LocalDirectoryRepository createLocalDirectoryRepository();

	/**
     * Returns a new object of class '<em>Local Memory Repository</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Local Memory Repository</em>'.
     * @generated
     */
	LocalMemoryRepository createLocalMemoryRepository();

	/**
     * Returns a new object of class '<em>Remote Cdo Repository</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Remote Cdo Repository</em>'.
     * @generated
     */
	RemoteCdoRepository createRemoteCdoRepository();

	/**
     * Returns a new object of class '<em>Local Sensor Framework Repository</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Local Sensor Framework Repository</em>'.
     * @generated
     */
	LocalSensorFrameworkRepository createLocalSensorFrameworkRepository();

	/**
     * Returns a new object of class '<em>Repositories</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Repositories</em>'.
     * @generated
     */
	Repositories createRepositories();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	RepositoryPackage getRepositoryPackage();

} //RepositoryFactory
