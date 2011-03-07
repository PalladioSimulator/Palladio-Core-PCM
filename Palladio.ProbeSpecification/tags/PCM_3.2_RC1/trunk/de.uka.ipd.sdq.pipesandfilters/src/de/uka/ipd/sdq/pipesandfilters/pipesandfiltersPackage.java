/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory
 * @model kind="package"
 * @generated
 */
public interface pipesandfiltersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pipesandfilters";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PipesAndFilters/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pipesandfilters";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	pipesandfiltersPackage eINSTANCE = de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.PipeElementImpl <em>Pipe Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.PipeElementImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getPipeElement()
	 * @generated
	 */
	int PIPE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_ELEMENT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Pipe Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPE_ELEMENT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.FilterImpl <em>Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.FilterImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getFilter()
	 * @generated
	 */
	int FILTER = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__ID = PIPE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER__SUCCESSORS = PIPE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FEATURE_COUNT = PIPE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.RecorderImpl <em>Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.RecorderImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getRecorder()
	 * @generated
	 */
	int RECORDER = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDER__ID = PIPE_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDER_FEATURE_COUNT = PIPE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.AggregationRecorderImpl <em>Aggregation Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.AggregationRecorderImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getAggregationRecorder()
	 * @generated
	 */
	int AGGREGATION_RECORDER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_RECORDER__ID = RECORDER__ID;

	/**
	 * The feature id for the '<em><b>Writer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_RECORDER__WRITER = RECORDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aggregation Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_RECORDER_FEATURE_COUNT = RECORDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.WriterImpl <em>Writer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.WriterImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getWriter()
	 * @generated
	 */
	int WRITER = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITER__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Writer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITER_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.RawRecorderImpl <em>Raw Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.RawRecorderImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getRawRecorder()
	 * @generated
	 */
	int RAW_RECORDER = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RECORDER__ID = RECORDER__ID;

	/**
	 * The feature id for the '<em><b>Writer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RECORDER__WRITER = RECORDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Raw Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RECORDER_FEATURE_COUNT = RECORDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.SimpleWarmUpFilterImpl <em>Simple Warm Up Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.SimpleWarmUpFilterImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getSimpleWarmUpFilter()
	 * @generated
	 */
	int SIMPLE_WARM_UP_FILTER = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_WARM_UP_FILTER__ID = FILTER__ID;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_WARM_UP_FILTER__SUCCESSORS = FILTER__SUCCESSORS;

	/**
	 * The number of structural features of the '<em>Simple Warm Up Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_WARM_UP_FILTER_FEATURE_COUNT = FILTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.SlidingMeanRecorderImpl <em>Sliding Mean Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.SlidingMeanRecorderImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getSlidingMeanRecorder()
	 * @generated
	 */
	int SLIDING_MEAN_RECORDER = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDING_MEAN_RECORDER__ID = AGGREGATION_RECORDER__ID;

	/**
	 * The feature id for the '<em><b>Writer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDING_MEAN_RECORDER__WRITER = AGGREGATION_RECORDER__WRITER;

	/**
	 * The number of structural features of the '<em>Sliding Mean Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDING_MEAN_RECORDER_FEATURE_COUNT = AGGREGATION_RECORDER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.EDP2WriterImpl <em>EDP2 Writer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.EDP2WriterImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getEDP2Writer()
	 * @generated
	 */
	int EDP2_WRITER = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_WRITER__ID = WRITER__ID;

	/**
	 * The number of structural features of the '<em>EDP2 Writer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDP2_WRITER_FEATURE_COUNT = WRITER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.PipesAndFiltersRepositoryImpl <em>Pipes And Filters Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.PipesAndFiltersRepositoryImpl
	 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getPipesAndFiltersRepository()
	 * @generated
	 */
	int PIPES_AND_FILTERS_REPOSITORY = 9;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPES_AND_FILTERS_REPOSITORY__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Pipes And Filters Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPES_AND_FILTERS_REPOSITORY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.PipeElement <em>Pipe Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipe Element</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.PipeElement
	 * @generated
	 */
	EClass getPipeElement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.Filter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.Filter
	 * @generated
	 */
	EClass getFilter();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pipesandfilters.Filter#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Successors</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.Filter#getSuccessors()
	 * @see #getFilter()
	 * @generated
	 */
	EReference getFilter_Successors();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.Recorder <em>Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recorder</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.Recorder
	 * @generated
	 */
	EClass getRecorder();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.AggregationRecorder <em>Aggregation Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation Recorder</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.AggregationRecorder
	 * @generated
	 */
	EClass getAggregationRecorder();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pipesandfilters.AggregationRecorder#getWriter <em>Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Writer</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.AggregationRecorder#getWriter()
	 * @see #getAggregationRecorder()
	 * @generated
	 */
	EReference getAggregationRecorder_Writer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.Writer <em>Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Writer</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.Writer
	 * @generated
	 */
	EClass getWriter();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.RawRecorder <em>Raw Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Recorder</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.RawRecorder
	 * @generated
	 */
	EClass getRawRecorder();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pipesandfilters.RawRecorder#getWriter <em>Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Writer</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.RawRecorder#getWriter()
	 * @see #getRawRecorder()
	 * @generated
	 */
	EReference getRawRecorder_Writer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.SimpleWarmUpFilter <em>Simple Warm Up Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Warm Up Filter</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.SimpleWarmUpFilter
	 * @generated
	 */
	EClass getSimpleWarmUpFilter();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.SlidingMeanRecorder <em>Sliding Mean Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sliding Mean Recorder</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.SlidingMeanRecorder
	 * @generated
	 */
	EClass getSlidingMeanRecorder();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.EDP2Writer <em>EDP2 Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDP2 Writer</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.EDP2Writer
	 * @generated
	 */
	EClass getEDP2Writer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository <em>Pipes And Filters Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipes And Filters Repository</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository
	 * @generated
	 */
	EClass getPipesAndFiltersRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository#getElements()
	 * @see #getPipesAndFiltersRepository()
	 * @generated
	 */
	EReference getPipesAndFiltersRepository_Elements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	pipesandfiltersFactory getpipesandfiltersFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.PipeElementImpl <em>Pipe Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.PipeElementImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getPipeElement()
		 * @generated
		 */
		EClass PIPE_ELEMENT = eINSTANCE.getPipeElement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.FilterImpl <em>Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.FilterImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getFilter()
		 * @generated
		 */
		EClass FILTER = eINSTANCE.getFilter();

		/**
		 * The meta object literal for the '<em><b>Successors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER__SUCCESSORS = eINSTANCE.getFilter_Successors();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.RecorderImpl <em>Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.RecorderImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getRecorder()
		 * @generated
		 */
		EClass RECORDER = eINSTANCE.getRecorder();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.AggregationRecorderImpl <em>Aggregation Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.AggregationRecorderImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getAggregationRecorder()
		 * @generated
		 */
		EClass AGGREGATION_RECORDER = eINSTANCE.getAggregationRecorder();

		/**
		 * The meta object literal for the '<em><b>Writer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION_RECORDER__WRITER = eINSTANCE.getAggregationRecorder_Writer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.WriterImpl <em>Writer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.WriterImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getWriter()
		 * @generated
		 */
		EClass WRITER = eINSTANCE.getWriter();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.RawRecorderImpl <em>Raw Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.RawRecorderImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getRawRecorder()
		 * @generated
		 */
		EClass RAW_RECORDER = eINSTANCE.getRawRecorder();

		/**
		 * The meta object literal for the '<em><b>Writer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_RECORDER__WRITER = eINSTANCE.getRawRecorder_Writer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.SimpleWarmUpFilterImpl <em>Simple Warm Up Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.SimpleWarmUpFilterImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getSimpleWarmUpFilter()
		 * @generated
		 */
		EClass SIMPLE_WARM_UP_FILTER = eINSTANCE.getSimpleWarmUpFilter();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.SlidingMeanRecorderImpl <em>Sliding Mean Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.SlidingMeanRecorderImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getSlidingMeanRecorder()
		 * @generated
		 */
		EClass SLIDING_MEAN_RECORDER = eINSTANCE.getSlidingMeanRecorder();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.EDP2WriterImpl <em>EDP2 Writer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.EDP2WriterImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getEDP2Writer()
		 * @generated
		 */
		EClass EDP2_WRITER = eINSTANCE.getEDP2Writer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pipesandfilters.impl.PipesAndFiltersRepositoryImpl <em>Pipes And Filters Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.PipesAndFiltersRepositoryImpl
		 * @see de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersPackageImpl#getPipesAndFiltersRepository()
		 * @generated
		 */
		EClass PIPES_AND_FILTERS_REPOSITORY = eINSTANCE.getPipesAndFiltersRepository();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPES_AND_FILTERS_REPOSITORY__ELEMENTS = eINSTANCE.getPipesAndFiltersRepository_Elements();

	}

} //pipesandfiltersPackage
