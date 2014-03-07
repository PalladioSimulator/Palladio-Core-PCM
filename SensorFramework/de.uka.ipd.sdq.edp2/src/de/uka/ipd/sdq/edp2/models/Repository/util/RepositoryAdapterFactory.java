/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository.util;

import java.io.File;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage
 * @generated
 */
public class RepositoryAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static RepositoryPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RepositoryAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RepositoryPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RepositorySwitch<Adapter> modelSwitch =
		new RepositorySwitch<Adapter>() {
            @Override
            public Adapter caseLocalDirectoryRepository(LocalDirectoryRepository object) {
                return createLocalDirectoryRepositoryAdapter();
            }
            @Override
            public Adapter caseFile(File object) {
                return createFileAdapter();
            }
            @Override
            public Adapter caseLocalMemoryRepository(LocalMemoryRepository object) {
                return createLocalMemoryRepositoryAdapter();
            }
            @Override
            public Adapter caseRemoteCdoRepository(RemoteCdoRepository object) {
                return createRemoteCdoRepositoryAdapter();
            }
            @Override
            public Adapter caseLocalSensorFrameworkRepository(LocalSensorFrameworkRepository object) {
                return createLocalSensorFrameworkRepositoryAdapter();
            }
            @Override
            public Adapter caseRepositories(Repositories object) {
                return createRepositoriesAdapter();
            }
            @Override
            public Adapter caseIResourceSet(ResourceSet object) {
                return createIResourceSetAdapter();
            }
            @Override
            public Adapter caseMeasurementsDaoFactory(MeasurementsDaoFactory object) {
                return createMeasurementsDaoFactoryAdapter();
            }
            @Override
            public Adapter caseMetaDao(MetaDao object) {
                return createMetaDaoAdapter();
            }
            @Override
            public Adapter caseRepository(Repository object) {
                return createRepositoryAdapter();
            }
            @Override
            public Adapter caseIdentifiable(Identifiable object) {
                return createIdentifiableAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository <em>Local Directory Repository</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository
     * @generated
     */
	public Adapter createLocalDirectoryRepositoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.io.File <em>File</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.io.File
     * @generated
     */
	public Adapter createFileAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository <em>Local Memory Repository</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository
     * @generated
     */
	public Adapter createLocalMemoryRepositoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository <em>Remote Cdo Repository</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository
     * @generated
     */
	public Adapter createRemoteCdoRepositoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository <em>Local Sensor Framework Repository</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository
     * @generated
     */
	public Adapter createLocalSensorFrameworkRepositoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories <em>Repositories</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repositories
     * @generated
     */
	public Adapter createRepositoriesAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.resource.ResourceSet <em>IResource Set</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.emf.ecore.resource.ResourceSet
     * @generated
     */
	public Adapter createIResourceSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.MeasurementsDaoFactory <em>Measurements Dao Factory</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.MeasurementsDaoFactory
     * @generated
     */
	public Adapter createMeasurementsDaoFactoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.MetaDao <em>Meta Dao</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.MetaDao
     * @generated
     */
	public Adapter createMetaDaoAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository
     * @generated
     */
	public Adapter createRepositoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable <em>Identifiable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable
     * @generated
     */
	public Adapter createIdentifiableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //RepositoryAdapterFactory
