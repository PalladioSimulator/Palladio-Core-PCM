/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.impl;

import de.uka.ipd.sdq.pipesandfilters.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class pipesandfiltersFactoryImpl extends EFactoryImpl implements pipesandfiltersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static pipesandfiltersFactory init() {
		try {
			pipesandfiltersFactory thepipesandfiltersFactory = (pipesandfiltersFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PipesAndFilters/0.1"); 
			if (thepipesandfiltersFactory != null) {
				return thepipesandfiltersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new pipesandfiltersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pipesandfiltersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case pipesandfiltersPackage.RAW_RECORDER: return createRawRecorder();
			case pipesandfiltersPackage.SIMPLE_WARM_UP_FILTER: return createSimpleWarmUpFilter();
			case pipesandfiltersPackage.SLIDING_MEAN_RECORDER: return createSlidingMeanRecorder();
			case pipesandfiltersPackage.EDP2_WRITER: return createEDP2Writer();
			case pipesandfiltersPackage.PIPES_AND_FILTERS_REPOSITORY: return createPipesAndFiltersRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawRecorder createRawRecorder() {
		RawRecorderImpl rawRecorder = new RawRecorderImpl();
		return rawRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleWarmUpFilter createSimpleWarmUpFilter() {
		SimpleWarmUpFilterImpl simpleWarmUpFilter = new SimpleWarmUpFilterImpl();
		return simpleWarmUpFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlidingMeanRecorder createSlidingMeanRecorder() {
		SlidingMeanRecorderImpl slidingMeanRecorder = new SlidingMeanRecorderImpl();
		return slidingMeanRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDP2Writer createEDP2Writer() {
		EDP2WriterImpl edp2Writer = new EDP2WriterImpl();
		return edp2Writer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipesAndFiltersRepository createPipesAndFiltersRepository() {
		PipesAndFiltersRepositoryImpl pipesAndFiltersRepository = new PipesAndFiltersRepositoryImpl();
		return pipesAndFiltersRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pipesandfiltersPackage getpipesandfiltersPackage() {
		return (pipesandfiltersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static pipesandfiltersPackage getPackage() {
		return pipesandfiltersPackage.eINSTANCE;
	}

} //pipesandfiltersFactoryImpl
