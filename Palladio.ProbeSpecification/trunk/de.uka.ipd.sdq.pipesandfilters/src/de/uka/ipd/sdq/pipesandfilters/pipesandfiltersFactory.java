/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage
 * @generated
 */
public interface pipesandfiltersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	pipesandfiltersFactory eINSTANCE = de.uka.ipd.sdq.pipesandfilters.impl.pipesandfiltersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Raw Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Raw Recorder</em>'.
	 * @generated
	 */
	RawRecorder createRawRecorder();

	/**
	 * Returns a new object of class '<em>Simple Warm Up Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Warm Up Filter</em>'.
	 * @generated
	 */
	SimpleWarmUpFilter createSimpleWarmUpFilter();

	/**
	 * Returns a new object of class '<em>Sliding Mean Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sliding Mean Recorder</em>'.
	 * @generated
	 */
	SlidingMeanRecorder createSlidingMeanRecorder();

	/**
	 * Returns a new object of class '<em>EDP2 Writer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDP2 Writer</em>'.
	 * @generated
	 */
	EDP2Writer createEDP2Writer();

	/**
	 * Returns a new object of class '<em>Pipes And Filters Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipes And Filters Repository</em>'.
	 * @generated
	 */
	PipesAndFiltersRepository createPipesAndFiltersRepository();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	pipesandfiltersPackage getpipesandfiltersPackage();

} //pipesandfiltersFactory
