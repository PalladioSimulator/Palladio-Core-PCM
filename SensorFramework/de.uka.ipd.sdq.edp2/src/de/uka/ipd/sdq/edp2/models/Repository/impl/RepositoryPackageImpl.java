/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository.impl;

import java.io.File;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.MetaDao;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentDataPackageImpl;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryPackageImpl extends EPackageImpl implements RepositoryPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass localDirectoryRepositoryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass fileEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass localMemoryRepositoryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass remoteCdoRepositoryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass localSensorFrameworkRepositoryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass repositoriesEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass iResourceSetEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass measurementsDaoFactoryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass metaDaoEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass repositoryEClass = null;

	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private RepositoryPackageImpl() {
        super(eNS_URI, RepositoryFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link RepositoryPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static RepositoryPackage init() {
        if (isInited) return (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

        // Obtain or create and register package
        RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RepositoryPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        ExperimentDataPackageImpl theExperimentDataPackage = (ExperimentDataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI) instanceof ExperimentDataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI) : ExperimentDataPackage.eINSTANCE);

        // Create package meta-data objects
        theRepositoryPackage.createPackageContents();
        theExperimentDataPackage.createPackageContents();

        // Initialize created meta-data
        theRepositoryPackage.initializePackageContents();
        theExperimentDataPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRepositoryPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RepositoryPackage.eNS_URI, theRepositoryPackage);
        return theRepositoryPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLocalDirectoryRepository() {
        return localDirectoryRepositoryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLocalDirectoryRepository_Uri() {
        return (EAttribute)localDirectoryRepositoryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFile() {
        return fileEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLocalMemoryRepository() {
        return localMemoryRepositoryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLocalMemoryRepository_Domain() {
        return (EAttribute)localMemoryRepositoryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRemoteCdoRepository() {
        return remoteCdoRepositoryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRemoteCdoRepository_Url() {
        return (EAttribute)remoteCdoRepositoryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLocalSensorFrameworkRepository() {
        return localSensorFrameworkRepositoryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLocalSensorFrameworkRepository_Uri() {
        return (EAttribute)localSensorFrameworkRepositoryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLocalSensorFrameworkRepository_ImportSettings() {
        return (EAttribute)localSensorFrameworkRepositoryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRepositories() {
        return repositoriesEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepositories_AvailableRepositories() {
        return (EReference)repositoriesEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepositories_CommonResourceSet() {
        return (EReference)repositoriesEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIResourceSet() {
        return iResourceSetEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMeasurementsDaoFactory() {
        return measurementsDaoFactoryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMetaDao() {
        return metaDaoEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRepository() {
        return repositoryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepository_Repositories() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRepository_ReadOnly() {
        return (EAttribute)repositoryEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepository_Descriptions() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepository_ExperimentGroups() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RepositoryFactory getRepositoryFactory() {
        return (RepositoryFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        localDirectoryRepositoryEClass = createEClass(LOCAL_DIRECTORY_REPOSITORY);
        createEAttribute(localDirectoryRepositoryEClass, LOCAL_DIRECTORY_REPOSITORY__URI);

        fileEClass = createEClass(FILE);

        localMemoryRepositoryEClass = createEClass(LOCAL_MEMORY_REPOSITORY);
        createEAttribute(localMemoryRepositoryEClass, LOCAL_MEMORY_REPOSITORY__DOMAIN);

        remoteCdoRepositoryEClass = createEClass(REMOTE_CDO_REPOSITORY);
        createEAttribute(remoteCdoRepositoryEClass, REMOTE_CDO_REPOSITORY__URL);

        localSensorFrameworkRepositoryEClass = createEClass(LOCAL_SENSOR_FRAMEWORK_REPOSITORY);
        createEAttribute(localSensorFrameworkRepositoryEClass, LOCAL_SENSOR_FRAMEWORK_REPOSITORY__URI);
        createEAttribute(localSensorFrameworkRepositoryEClass, LOCAL_SENSOR_FRAMEWORK_REPOSITORY__IMPORT_SETTINGS);

        repositoriesEClass = createEClass(REPOSITORIES);
        createEReference(repositoriesEClass, REPOSITORIES__AVAILABLE_REPOSITORIES);
        createEReference(repositoriesEClass, REPOSITORIES__COMMON_RESOURCE_SET);

        iResourceSetEClass = createEClass(IRESOURCE_SET);

        measurementsDaoFactoryEClass = createEClass(MEASUREMENTS_DAO_FACTORY);

        metaDaoEClass = createEClass(META_DAO);

        repositoryEClass = createEClass(REPOSITORY);
        createEReference(repositoryEClass, REPOSITORY__REPOSITORIES);
        createEReference(repositoryEClass, REPOSITORY__EXPERIMENT_GROUPS);
        createEAttribute(repositoryEClass, REPOSITORY__READ_ONLY);
        createEReference(repositoryEClass, REPOSITORY__DESCRIPTIONS);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ExperimentDataPackage theExperimentDataPackage = (ExperimentDataPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        localDirectoryRepositoryEClass.getESuperTypes().add(this.getRepository());
        localMemoryRepositoryEClass.getESuperTypes().add(this.getRepository());
        remoteCdoRepositoryEClass.getESuperTypes().add(this.getRepository());
        localSensorFrameworkRepositoryEClass.getESuperTypes().add(this.getRepository());
        repositoryEClass.getESuperTypes().add(theExperimentDataPackage.getIdentifiable());
        repositoryEClass.getESuperTypes().add(this.getMetaDao());

        // Initialize classes and features; add operations and parameters
        initEClass(localDirectoryRepositoryEClass, LocalDirectoryRepository.class, "LocalDirectoryRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLocalDirectoryRepository_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, LocalDirectoryRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        EOperation op = addEOperation(localDirectoryRepositoryEClass, this.getFile(), "convertUriStringToFile", 1, 1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "uriString", 1, 1, IS_UNIQUE, !IS_ORDERED);

        initEClass(fileEClass, File.class, "File", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(localMemoryRepositoryEClass, LocalMemoryRepository.class, "LocalMemoryRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLocalMemoryRepository_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, LocalMemoryRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(remoteCdoRepositoryEClass, RemoteCdoRepository.class, "RemoteCdoRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRemoteCdoRepository_Url(), ecorePackage.getEString(), "url", null, 1, 1, RemoteCdoRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(localSensorFrameworkRepositoryEClass, LocalSensorFrameworkRepository.class, "LocalSensorFrameworkRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLocalSensorFrameworkRepository_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, LocalSensorFrameworkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getLocalSensorFrameworkRepository_ImportSettings(), ecorePackage.getEString(), "importSettings", null, 1, 1, LocalSensorFrameworkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(repositoriesEClass, Repositories.class, "Repositories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRepositories_AvailableRepositories(), this.getRepository(), this.getRepository_Repositories(), "availableRepositories", null, 0, -1, Repositories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getRepositories_CommonResourceSet(), this.getIResourceSet(), null, "commonResourceSet", null, 1, 1, Repositories.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(iResourceSetEClass, ResourceSet.class, "IResourceSet", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(measurementsDaoFactoryEClass, MeasurementsDaoFactory.class, "MeasurementsDaoFactory", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(metaDaoEClass, MetaDao.class, "MetaDao", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(repositoryEClass, Repository.class, "Repository", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRepository_Repositories(), this.getRepositories(), this.getRepositories_AvailableRepositories(), "repositories", null, 1, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getRepository_ExperimentGroups(), theExperimentDataPackage.getExperimentGroup(), theExperimentDataPackage.getExperimentGroup_Repository(), "experimentGroups", null, 0, -1, Repository.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getRepository_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 1, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getRepository_Descriptions(), theExperimentDataPackage.getDescription(), theExperimentDataPackage.getDescription_Repository(), "descriptions", null, 0, -1, Repository.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        addEOperation(repositoryEClass, null, "resetExperimentGroups", 1, 1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(repositoryEClass, null, "resetDescriptions", 1, 1, IS_UNIQUE, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //RepositoryPackageImpl
