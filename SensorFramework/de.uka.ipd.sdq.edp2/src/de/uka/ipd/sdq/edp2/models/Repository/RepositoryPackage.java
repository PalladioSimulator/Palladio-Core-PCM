/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * <p>
 *     Contains&nbsp;all&nbsp;elements&nbsp;to&nbsp;handle&nbsp;repositories.&nbsp;Repositories&nbsp;are&nbsp;responsible&nbsp;to&nbsp;load/store&nbsp;experiment&nbsp;data.
 * </p>
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface RepositoryPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "Repository";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://sdq.ipd.uka.de/EDP2/Repository/0.9.1";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "de.uka.ipd.sdq.edp2.models";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	RepositoryPackage eINSTANCE = de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl.init();

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl <em>Repository</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getRepository()
     * @generated
     */
	int REPOSITORY = 9;

	/**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORY__UUID = ExperimentDataPackage.IDENTIFIABLE__UUID;

	/**
     * The feature id for the '<em><b>Repositories</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORY__REPOSITORIES = ExperimentDataPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Experiment Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORY__EXPERIMENT_GROUPS = ExperimentDataPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORY__READ_ONLY = ExperimentDataPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Descriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORY__DESCRIPTIONS = ExperimentDataPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Repository</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORY_FEATURE_COUNT = ExperimentDataPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalDirectoryRepositoryImpl <em>Local Directory Repository</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.LocalDirectoryRepositoryImpl
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getLocalDirectoryRepository()
     * @generated
     */
	int LOCAL_DIRECTORY_REPOSITORY = 0;

	/**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY__UUID = REPOSITORY__UUID;

	/**
     * The feature id for the '<em><b>Repositories</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY__REPOSITORIES = REPOSITORY__REPOSITORIES;

	/**
     * The feature id for the '<em><b>Experiment Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY__EXPERIMENT_GROUPS = REPOSITORY__EXPERIMENT_GROUPS;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY__READ_ONLY = REPOSITORY__READ_ONLY;

	/**
     * The feature id for the '<em><b>Descriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY__DESCRIPTIONS = REPOSITORY__DESCRIPTIONS;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY__URI = REPOSITORY_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Local Directory Repository</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_DIRECTORY_REPOSITORY_FEATURE_COUNT = REPOSITORY_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link java.io.File <em>File</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see java.io.File
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getFile()
     * @generated
     */
	int FILE = 1;

	/**
     * The number of structural features of the '<em>File</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FILE_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalMemoryRepositoryImpl <em>Local Memory Repository</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.LocalMemoryRepositoryImpl
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getLocalMemoryRepository()
     * @generated
     */
	int LOCAL_MEMORY_REPOSITORY = 2;

	/**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY__UUID = REPOSITORY__UUID;

	/**
     * The feature id for the '<em><b>Repositories</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY__REPOSITORIES = REPOSITORY__REPOSITORIES;

	/**
     * The feature id for the '<em><b>Experiment Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY__EXPERIMENT_GROUPS = REPOSITORY__EXPERIMENT_GROUPS;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY__READ_ONLY = REPOSITORY__READ_ONLY;

	/**
     * The feature id for the '<em><b>Descriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY__DESCRIPTIONS = REPOSITORY__DESCRIPTIONS;

	/**
     * The feature id for the '<em><b>Domain</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY__DOMAIN = REPOSITORY_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Local Memory Repository</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_MEMORY_REPOSITORY_FEATURE_COUNT = REPOSITORY_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RemoteCdoRepositoryImpl <em>Remote Cdo Repository</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RemoteCdoRepositoryImpl
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getRemoteCdoRepository()
     * @generated
     */
	int REMOTE_CDO_REPOSITORY = 3;

	/**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY__UUID = REPOSITORY__UUID;

	/**
     * The feature id for the '<em><b>Repositories</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY__REPOSITORIES = REPOSITORY__REPOSITORIES;

	/**
     * The feature id for the '<em><b>Experiment Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY__EXPERIMENT_GROUPS = REPOSITORY__EXPERIMENT_GROUPS;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY__READ_ONLY = REPOSITORY__READ_ONLY;

	/**
     * The feature id for the '<em><b>Descriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY__DESCRIPTIONS = REPOSITORY__DESCRIPTIONS;

	/**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY__URL = REPOSITORY_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Remote Cdo Repository</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOTE_CDO_REPOSITORY_FEATURE_COUNT = REPOSITORY_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalSensorFrameworkRepositoryImpl <em>Local Sensor Framework Repository</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.LocalSensorFrameworkRepositoryImpl
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getLocalSensorFrameworkRepository()
     * @generated
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY = 4;

	/**
     * The feature id for the '<em><b>Uuid</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__UUID = REPOSITORY__UUID;

	/**
     * The feature id for the '<em><b>Repositories</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__REPOSITORIES = REPOSITORY__REPOSITORIES;

	/**
     * The feature id for the '<em><b>Experiment Groups</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__EXPERIMENT_GROUPS = REPOSITORY__EXPERIMENT_GROUPS;

	/**
     * The feature id for the '<em><b>Read Only</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__READ_ONLY = REPOSITORY__READ_ONLY;

	/**
     * The feature id for the '<em><b>Descriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__DESCRIPTIONS = REPOSITORY__DESCRIPTIONS;

	/**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI = REPOSITORY_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Import Settings</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS = REPOSITORY_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Local Sensor Framework Repository</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LOCAL_SENSOR_FRAMEWORK_REPOSITORY_FEATURE_COUNT = REPOSITORY_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoriesImpl <em>Repositories</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoriesImpl
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getRepositories()
     * @generated
     */
	int REPOSITORIES = 5;

	/**
     * The feature id for the '<em><b>Available Repositories</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORIES__AVAILABLE_REPOSITORIES = 0;

	/**
     * The feature id for the '<em><b>Common Resource Set</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORIES__COMMON_RESOURCE_SET = 1;

	/**
     * The number of structural features of the '<em>Repositories</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPOSITORIES_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.eclipse.emf.ecore.resource.ResourceSet <em>IResource Set</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.resource.ResourceSet
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getIResourceSet()
     * @generated
     */
	int IRESOURCE_SET = 6;

	/**
     * The number of structural features of the '<em>IResource Set</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IRESOURCE_SET_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.MeasurementsDaoFactory <em>Measurements Dao Factory</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.MeasurementsDaoFactory
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getMeasurementsDaoFactory()
     * @generated
     */
	int MEASUREMENTS_DAO_FACTORY = 7;

	/**
     * The number of structural features of the '<em>Measurements Dao Factory</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MEASUREMENTS_DAO_FACTORY_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link de.uka.ipd.sdq.edp2.MetaDao <em>Meta Dao</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.uka.ipd.sdq.edp2.MetaDao
     * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getMetaDao()
     * @generated
     */
	int META_DAO = 8;

	/**
     * The number of structural features of the '<em>Meta Dao</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int META_DAO_FEATURE_COUNT = 0;

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository <em>Local Directory Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Local Directory Repository</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository
     * @generated
     */
	EClass getLocalDirectoryRepository();

	/**
     * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository#getUri()
     * @see #getLocalDirectoryRepository()
     * @generated
     */
	EAttribute getLocalDirectoryRepository_Uri();

	/**
     * Returns the meta object for class '{@link java.io.File <em>File</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>File</em>'.
     * @see java.io.File
     * @model instanceClass="java.io.File"
     * @generated
     */
	EClass getFile();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository <em>Local Memory Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Local Memory Repository</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository
     * @generated
     */
	EClass getLocalMemoryRepository();

	/**
     * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository#getDomain <em>Domain</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Domain</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository#getDomain()
     * @see #getLocalMemoryRepository()
     * @generated
     */
	EAttribute getLocalMemoryRepository_Domain();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository <em>Remote Cdo Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Remote Cdo Repository</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository
     * @generated
     */
	EClass getRemoteCdoRepository();

	/**
     * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository#getUrl()
     * @see #getRemoteCdoRepository()
     * @generated
     */
	EAttribute getRemoteCdoRepository_Url();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository <em>Local Sensor Framework Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Local Sensor Framework Repository</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository
     * @generated
     */
	EClass getLocalSensorFrameworkRepository();

	/**
     * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getUri()
     * @see #getLocalSensorFrameworkRepository()
     * @generated
     */
	EAttribute getLocalSensorFrameworkRepository_Uri();

	/**
     * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getImportSettings <em>Import Settings</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Import Settings</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository#getImportSettings()
     * @see #getLocalSensorFrameworkRepository()
     * @generated
     */
	EAttribute getLocalSensorFrameworkRepository_ImportSettings();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories <em>Repositories</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Repositories</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repositories
     * @generated
     */
	EClass getRepositories();

	/**
     * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories#getAvailableRepositories <em>Available Repositories</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Available Repositories</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repositories#getAvailableRepositories()
     * @see #getRepositories()
     * @generated
     */
	EReference getRepositories_AvailableRepositories();

	/**
     * Returns the meta object for the reference '{@link de.uka.ipd.sdq.edp2.models.Repository.Repositories#getCommonResourceSet <em>Common Resource Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Common Resource Set</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repositories#getCommonResourceSet()
     * @see #getRepositories()
     * @generated
     */
	EReference getRepositories_CommonResourceSet();

	/**
     * Returns the meta object for class '{@link org.eclipse.emf.ecore.resource.ResourceSet <em>IResource Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>IResource Set</em>'.
     * @see org.eclipse.emf.ecore.resource.ResourceSet
     * @model instanceClass="org.eclipse.emf.ecore.resource.ResourceSet"
     * @generated
     */
	EClass getIResourceSet();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.MeasurementsDaoFactory <em>Measurements Dao Factory</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Measurements Dao Factory</em>'.
     * @see de.uka.ipd.sdq.edp2.MeasurementsDaoFactory
     * @model instanceClass="de.uka.ipd.sdq.edp2.MeasurementsDaoFactory"
     * @generated
     */
	EClass getMeasurementsDaoFactory();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.MetaDao <em>Meta Dao</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Meta Dao</em>'.
     * @see de.uka.ipd.sdq.edp2.MetaDao
     * @model instanceClass="de.uka.ipd.sdq.edp2.MetaDao"
     * @generated
     */
	EClass getMetaDao();

	/**
     * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Repository</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository
     * @generated
     */
	EClass getRepository();

	/**
     * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#getRepositories <em>Repositories</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Repositories</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#getRepositories()
     * @see #getRepository()
     * @generated
     */
	EReference getRepository_Repositories();

	/**
     * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#isReadOnly <em>Read Only</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Only</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#isReadOnly()
     * @see #getRepository()
     * @generated
     */
	EAttribute getRepository_ReadOnly();

	/**
     * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#getDescriptions <em>Descriptions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Descriptions</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#getDescriptions()
     * @see #getRepository()
     * @generated
     */
	EReference getRepository_Descriptions();

	/**
     * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.edp2.models.Repository.Repository#getExperimentGroups <em>Experiment Groups</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Experiment Groups</em>'.
     * @see de.uka.ipd.sdq.edp2.models.Repository.Repository#getExperimentGroups()
     * @see #getRepository()
     * @generated
     */
	EReference getRepository_ExperimentGroups();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	RepositoryFactory getRepositoryFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalDirectoryRepositoryImpl <em>Local Directory Repository</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.LocalDirectoryRepositoryImpl
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getLocalDirectoryRepository()
         * @generated
         */
		EClass LOCAL_DIRECTORY_REPOSITORY = eINSTANCE.getLocalDirectoryRepository();

		/**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LOCAL_DIRECTORY_REPOSITORY__URI = eINSTANCE.getLocalDirectoryRepository_Uri();

		/**
         * The meta object literal for the '{@link java.io.File <em>File</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see java.io.File
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getFile()
         * @generated
         */
		EClass FILE = eINSTANCE.getFile();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalMemoryRepositoryImpl <em>Local Memory Repository</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.LocalMemoryRepositoryImpl
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getLocalMemoryRepository()
         * @generated
         */
		EClass LOCAL_MEMORY_REPOSITORY = eINSTANCE.getLocalMemoryRepository();

		/**
         * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LOCAL_MEMORY_REPOSITORY__DOMAIN = eINSTANCE.getLocalMemoryRepository_Domain();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RemoteCdoRepositoryImpl <em>Remote Cdo Repository</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RemoteCdoRepositoryImpl
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getRemoteCdoRepository()
         * @generated
         */
		EClass REMOTE_CDO_REPOSITORY = eINSTANCE.getRemoteCdoRepository();

		/**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute REMOTE_CDO_REPOSITORY__URL = eINSTANCE.getRemoteCdoRepository_Url();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.LocalSensorFrameworkRepositoryImpl <em>Local Sensor Framework Repository</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.LocalSensorFrameworkRepositoryImpl
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getLocalSensorFrameworkRepository()
         * @generated
         */
		EClass LOCAL_SENSOR_FRAMEWORK_REPOSITORY = eINSTANCE.getLocalSensorFrameworkRepository();

		/**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI = eINSTANCE.getLocalSensorFrameworkRepository_Uri();

		/**
         * The meta object literal for the '<em><b>Import Settings</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS = eINSTANCE.getLocalSensorFrameworkRepository_ImportSettings();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoriesImpl <em>Repositories</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoriesImpl
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getRepositories()
         * @generated
         */
		EClass REPOSITORIES = eINSTANCE.getRepositories();

		/**
         * The meta object literal for the '<em><b>Available Repositories</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPOSITORIES__AVAILABLE_REPOSITORIES = eINSTANCE.getRepositories_AvailableRepositories();

		/**
         * The meta object literal for the '<em><b>Common Resource Set</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPOSITORIES__COMMON_RESOURCE_SET = eINSTANCE.getRepositories_CommonResourceSet();

		/**
         * The meta object literal for the '{@link org.eclipse.emf.ecore.resource.ResourceSet <em>IResource Set</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.emf.ecore.resource.ResourceSet
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getIResourceSet()
         * @generated
         */
		EClass IRESOURCE_SET = eINSTANCE.getIResourceSet();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.MeasurementsDaoFactory <em>Measurements Dao Factory</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.MeasurementsDaoFactory
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getMeasurementsDaoFactory()
         * @generated
         */
		EClass MEASUREMENTS_DAO_FACTORY = eINSTANCE.getMeasurementsDaoFactory();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.MetaDao <em>Meta Dao</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.MetaDao
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getMetaDao()
         * @generated
         */
		EClass META_DAO = eINSTANCE.getMetaDao();

		/**
         * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl <em>Repository</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl
         * @see de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl#getRepository()
         * @generated
         */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
         * The meta object literal for the '<em><b>Repositories</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPOSITORY__REPOSITORIES = eINSTANCE.getRepository_Repositories();

		/**
         * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute REPOSITORY__READ_ONLY = eINSTANCE.getRepository_ReadOnly();

		/**
         * The meta object literal for the '<em><b>Descriptions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPOSITORY__DESCRIPTIONS = eINSTANCE.getRepository_Descriptions();

		/**
         * The meta object literal for the '<em><b>Experiment Groups</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPOSITORY__EXPERIMENT_GROUPS = eINSTANCE.getRepository_ExperimentGroups();

	}

} //RepositoryPackage
