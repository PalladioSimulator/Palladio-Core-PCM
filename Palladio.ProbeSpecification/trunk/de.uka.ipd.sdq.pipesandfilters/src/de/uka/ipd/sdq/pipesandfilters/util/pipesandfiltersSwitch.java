/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pipesandfilters.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage
 * @generated
 */
public class pipesandfiltersSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static pipesandfiltersPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public pipesandfiltersSwitch() {
		if (modelPackage == null) {
			modelPackage = pipesandfiltersPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case pipesandfiltersPackage.PIPE_ELEMENT: {
				PipeElement pipeElement = (PipeElement)theEObject;
				T result = casePipeElement(pipeElement);
				if (result == null) result = caseIdentifier(pipeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.FILTER: {
				Filter filter = (Filter)theEObject;
				T result = caseFilter(filter);
				if (result == null) result = casePipeElement(filter);
				if (result == null) result = caseIdentifier(filter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.RECORDER: {
				Recorder recorder = (Recorder)theEObject;
				T result = caseRecorder(recorder);
				if (result == null) result = casePipeElement(recorder);
				if (result == null) result = caseIdentifier(recorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.AGGREGATION_RECORDER: {
				AggregationRecorder aggregationRecorder = (AggregationRecorder)theEObject;
				T result = caseAggregationRecorder(aggregationRecorder);
				if (result == null) result = caseRecorder(aggregationRecorder);
				if (result == null) result = casePipeElement(aggregationRecorder);
				if (result == null) result = caseIdentifier(aggregationRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.WRITER: {
				Writer writer = (Writer)theEObject;
				T result = caseWriter(writer);
				if (result == null) result = caseIdentifier(writer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.RAW_RECORDER: {
				RawRecorder rawRecorder = (RawRecorder)theEObject;
				T result = caseRawRecorder(rawRecorder);
				if (result == null) result = caseRecorder(rawRecorder);
				if (result == null) result = casePipeElement(rawRecorder);
				if (result == null) result = caseIdentifier(rawRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.SIMPLE_WARM_UP_FILTER: {
				SimpleWarmUpFilter simpleWarmUpFilter = (SimpleWarmUpFilter)theEObject;
				T result = caseSimpleWarmUpFilter(simpleWarmUpFilter);
				if (result == null) result = caseFilter(simpleWarmUpFilter);
				if (result == null) result = casePipeElement(simpleWarmUpFilter);
				if (result == null) result = caseIdentifier(simpleWarmUpFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.SLIDING_MEAN_RECORDER: {
				SlidingMeanRecorder slidingMeanRecorder = (SlidingMeanRecorder)theEObject;
				T result = caseSlidingMeanRecorder(slidingMeanRecorder);
				if (result == null) result = caseAggregationRecorder(slidingMeanRecorder);
				if (result == null) result = caseRecorder(slidingMeanRecorder);
				if (result == null) result = casePipeElement(slidingMeanRecorder);
				if (result == null) result = caseIdentifier(slidingMeanRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.EDP2_WRITER: {
				EDP2Writer edp2Writer = (EDP2Writer)theEObject;
				T result = caseEDP2Writer(edp2Writer);
				if (result == null) result = caseWriter(edp2Writer);
				if (result == null) result = caseIdentifier(edp2Writer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case pipesandfiltersPackage.PIPES_AND_FILTERS_REPOSITORY: {
				PipesAndFiltersRepository pipesAndFiltersRepository = (PipesAndFiltersRepository)theEObject;
				T result = casePipesAndFiltersRepository(pipesAndFiltersRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipe Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipe Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePipeElement(PipeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilter(Filter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecorder(Recorder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregationRecorder(AggregationRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Writer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Writer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWriter(Writer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawRecorder(RawRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Warm Up Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Warm Up Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleWarmUpFilter(SimpleWarmUpFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sliding Mean Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sliding Mean Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlidingMeanRecorder(SlidingMeanRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDP2 Writer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDP2 Writer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDP2Writer(EDP2Writer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipes And Filters Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipes And Filters Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePipesAndFiltersRepository(PipesAndFiltersRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //pipesandfiltersSwitch
