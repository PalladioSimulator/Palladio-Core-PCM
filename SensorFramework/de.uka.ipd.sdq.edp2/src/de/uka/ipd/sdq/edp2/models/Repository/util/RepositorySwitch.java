/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository.util;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Switch;
import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.MetaDao;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable;
import de.uka.ipd.sdq.edp2.models.Repository.*;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage
 * @generated
 */
public class RepositorySwitch<T> extends Switch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static RepositoryPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RepositorySwitch() {
        if (modelPackage == null) {
            modelPackage = RepositoryPackage.eINSTANCE;
        }
    }

	/**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	@Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case RepositoryPackage.LOCAL_DIRECTORY_REPOSITORY: {
                LocalDirectoryRepository localDirectoryRepository = (LocalDirectoryRepository)theEObject;
                T result = caseLocalDirectoryRepository(localDirectoryRepository);
                if (result == null) result = caseRepository(localDirectoryRepository);
                if (result == null) result = caseIdentifiable(localDirectoryRepository);
                if (result == null) result = caseMetaDao(localDirectoryRepository);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.FILE: {
                File file = (File)theEObject;
                T result = caseFile(file);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.LOCAL_MEMORY_REPOSITORY: {
                LocalMemoryRepository localMemoryRepository = (LocalMemoryRepository)theEObject;
                T result = caseLocalMemoryRepository(localMemoryRepository);
                if (result == null) result = caseRepository(localMemoryRepository);
                if (result == null) result = caseIdentifiable(localMemoryRepository);
                if (result == null) result = caseMetaDao(localMemoryRepository);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.REMOTE_CDO_REPOSITORY: {
                RemoteCdoRepository remoteCdoRepository = (RemoteCdoRepository)theEObject;
                T result = caseRemoteCdoRepository(remoteCdoRepository);
                if (result == null) result = caseRepository(remoteCdoRepository);
                if (result == null) result = caseIdentifiable(remoteCdoRepository);
                if (result == null) result = caseMetaDao(remoteCdoRepository);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.LOCAL_SENSOR_FRAMEWORK_REPOSITORY: {
                LocalSensorFrameworkRepository localSensorFrameworkRepository = (LocalSensorFrameworkRepository)theEObject;
                T result = caseLocalSensorFrameworkRepository(localSensorFrameworkRepository);
                if (result == null) result = caseRepository(localSensorFrameworkRepository);
                if (result == null) result = caseIdentifiable(localSensorFrameworkRepository);
                if (result == null) result = caseMetaDao(localSensorFrameworkRepository);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.REPOSITORIES: {
                Repositories repositories = (Repositories)theEObject;
                T result = caseRepositories(repositories);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.IRESOURCE_SET: {
                ResourceSet iResourceSet = (ResourceSet)theEObject;
                T result = caseIResourceSet(iResourceSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.MEASUREMENTS_DAO_FACTORY: {
                MeasurementsDaoFactory measurementsDaoFactory = (MeasurementsDaoFactory)theEObject;
                T result = caseMeasurementsDaoFactory(measurementsDaoFactory);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.META_DAO: {
                MetaDao metaDao = (MetaDao)theEObject;
                T result = caseMetaDao(metaDao);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case RepositoryPackage.REPOSITORY: {
                Repository repository = (Repository)theEObject;
                T result = caseRepository(repository);
                if (result == null) result = caseIdentifiable(repository);
                if (result == null) result = caseMetaDao(repository);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Local Directory Repository</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Local Directory Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLocalDirectoryRepository(LocalDirectoryRepository object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>File</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFile(File object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Local Memory Repository</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Local Memory Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLocalMemoryRepository(LocalMemoryRepository object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Remote Cdo Repository</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Remote Cdo Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRemoteCdoRepository(RemoteCdoRepository object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Local Sensor Framework Repository</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Local Sensor Framework Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLocalSensorFrameworkRepository(LocalSensorFrameworkRepository object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Repositories</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Repositories</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRepositories(Repositories object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>IResource Set</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IResource Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIResourceSet(ResourceSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Measurements Dao Factory</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Measurements Dao Factory</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMeasurementsDaoFactory(MeasurementsDaoFactory object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Meta Dao</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Meta Dao</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMetaDao(MetaDao object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRepository(Repository object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIdentifiable(Identifiable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	@Override
    public T defaultCase(EObject object) {
        return null;
    }

} //RepositorySwitch
