/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pipesandfilters.AggregationRecorder;
import de.uka.ipd.sdq.pipesandfilters.EDP2Writer;
import de.uka.ipd.sdq.pipesandfilters.Filter;
import de.uka.ipd.sdq.pipesandfilters.PipeElement;
import de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository;
import de.uka.ipd.sdq.pipesandfilters.RawRecorder;
import de.uka.ipd.sdq.pipesandfilters.Recorder;
import de.uka.ipd.sdq.pipesandfilters.SimpleWarmUpFilter;
import de.uka.ipd.sdq.pipesandfilters.SlidingMeanRecorder;
import de.uka.ipd.sdq.pipesandfilters.Writer;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class pipesandfiltersPackageImpl extends EPackageImpl implements pipesandfiltersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleWarmUpFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slidingMeanRecorderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edp2WriterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipesAndFiltersRepositoryEClass = null;

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
	 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private pipesandfiltersPackageImpl() {
		super(eNS_URI, pipesandfiltersFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static pipesandfiltersPackage init() {
		if (isInited) return (pipesandfiltersPackage)EPackage.Registry.INSTANCE.getEPackage(pipesandfiltersPackage.eNS_URI);

		// Obtain or create and register package
		pipesandfiltersPackageImpl thepipesandfiltersPackage = (pipesandfiltersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof pipesandfiltersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new pipesandfiltersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thepipesandfiltersPackage.createPackageContents();

		// Initialize created meta-data
		thepipesandfiltersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thepipesandfiltersPackage.freeze();

		return thepipesandfiltersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipeElement() {
		return pipeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilter() {
		return filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilter_Successors() {
		return (EReference)filterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecorder() {
		return recorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregationRecorder() {
		return aggregationRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregationRecorder_Writer() {
		return (EReference)aggregationRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriter() {
		return writerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawRecorder() {
		return rawRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawRecorder_Writer() {
		return (EReference)rawRecorderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleWarmUpFilter() {
		return simpleWarmUpFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlidingMeanRecorder() {
		return slidingMeanRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDP2Writer() {
		return edp2WriterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipesAndFiltersRepository() {
		return pipesAndFiltersRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPipesAndFiltersRepository_Elements() {
		return (EReference)pipesAndFiltersRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pipesandfiltersFactory getpipesandfiltersFactory() {
		return (pipesandfiltersFactory)getEFactoryInstance();
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
		pipeElementEClass = createEClass(PIPE_ELEMENT);

		filterEClass = createEClass(FILTER);
		createEReference(filterEClass, FILTER__SUCCESSORS);

		recorderEClass = createEClass(RECORDER);

		aggregationRecorderEClass = createEClass(AGGREGATION_RECORDER);
		createEReference(aggregationRecorderEClass, AGGREGATION_RECORDER__WRITER);

		writerEClass = createEClass(WRITER);

		rawRecorderEClass = createEClass(RAW_RECORDER);
		createEReference(rawRecorderEClass, RAW_RECORDER__WRITER);

		simpleWarmUpFilterEClass = createEClass(SIMPLE_WARM_UP_FILTER);

		slidingMeanRecorderEClass = createEClass(SLIDING_MEAN_RECORDER);

		edp2WriterEClass = createEClass(EDP2_WRITER);

		pipesAndFiltersRepositoryEClass = createEClass(PIPES_AND_FILTERS_REPOSITORY);
		createEReference(pipesAndFiltersRepositoryEClass, PIPES_AND_FILTERS_REPOSITORY__ELEMENTS);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pipeElementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		filterEClass.getESuperTypes().add(this.getPipeElement());
		recorderEClass.getESuperTypes().add(this.getPipeElement());
		aggregationRecorderEClass.getESuperTypes().add(this.getRecorder());
		writerEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		rawRecorderEClass.getESuperTypes().add(this.getRecorder());
		simpleWarmUpFilterEClass.getESuperTypes().add(this.getFilter());
		slidingMeanRecorderEClass.getESuperTypes().add(this.getAggregationRecorder());
		edp2WriterEClass.getESuperTypes().add(this.getWriter());

		// Initialize classes and features; add operations and parameters
		initEClass(pipeElementEClass, PipeElement.class, "PipeElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterEClass, Filter.class, "Filter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilter_Successors(), this.getPipeElement(), null, "successors", null, 1, -1, Filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(recorderEClass, Recorder.class, "Recorder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(aggregationRecorderEClass, AggregationRecorder.class, "AggregationRecorder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregationRecorder_Writer(), this.getWriter(), null, "writer", null, 0, -1, AggregationRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(writerEClass, Writer.class, "Writer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rawRecorderEClass, RawRecorder.class, "RawRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawRecorder_Writer(), this.getWriter(), null, "writer", null, 0, -1, RawRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simpleWarmUpFilterEClass, SimpleWarmUpFilter.class, "SimpleWarmUpFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(slidingMeanRecorderEClass, SlidingMeanRecorder.class, "SlidingMeanRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(edp2WriterEClass, EDP2Writer.class, "EDP2Writer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pipesAndFiltersRepositoryEClass, PipesAndFiltersRepository.class, "PipesAndFiltersRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipesAndFiltersRepository_Elements(), this.getPipeElement(), null, "elements", null, 0, -1, PipesAndFiltersRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //pipesandfiltersPackageImpl
