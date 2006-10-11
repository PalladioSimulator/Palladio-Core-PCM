/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction.util;

import de.uka.ipd.sdq.probfunction.*;

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
 * @see de.uka.ipd.sdq.probfunction.probfunctionPackage
 * @generated
 */
public class probfunctionSwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright by SDQ U Karlsruhe (TH) 2006";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static probfunctionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probfunctionSwitch() {
		if (modelPackage == null) {
			modelPackage = probfunctionPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case probfunctionPackage.BOXED_PDF: {
				BoxedPDF boxedPDF = (BoxedPDF)theEObject;
				Object result = caseBoxedPDF(boxedPDF);
				if (result == null) result = caseProbabilityDensityFunction(boxedPDF);
				if (result == null) result = caseProbabilityFunction(boxedPDF);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.PROBABILITY_DENSITY_FUNCTION: {
				ProbabilityDensityFunction probabilityDensityFunction = (ProbabilityDensityFunction)theEObject;
				Object result = caseProbabilityDensityFunction(probabilityDensityFunction);
				if (result == null) result = caseProbabilityFunction(probabilityDensityFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.PROBABILITY_FUNCTION: {
				ProbabilityFunction probabilityFunction = (ProbabilityFunction)theEObject;
				Object result = caseProbabilityFunction(probabilityFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.UNIT: {
				Unit unit = (Unit)theEObject;
				Object result = caseUnit(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.CONTINUOUS_SAMPLE: {
				ContinuousSample continuousSample = (ContinuousSample)theEObject;
				Object result = caseContinuousSample(continuousSample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.PROBABILITY_MASS_FUNCTION: {
				ProbabilityMassFunction probabilityMassFunction = (ProbabilityMassFunction)theEObject;
				Object result = caseProbabilityMassFunction(probabilityMassFunction);
				if (result == null) result = caseProbabilityFunction(probabilityMassFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.SAMPLE: {
				Sample sample = (Sample)theEObject;
				Object result = caseSample(sample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case probfunctionPackage.SAMPLE_PDF: {
				SamplePDF samplePDF = (SamplePDF)theEObject;
				Object result = caseSamplePDF(samplePDF);
				if (result == null) result = caseProbabilityDensityFunction(samplePDF);
				if (result == null) result = caseProbabilityFunction(samplePDF);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Boxed PDF</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Boxed PDF</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBoxedPDF(BoxedPDF object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Probability Density Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Probability Density Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProbabilityDensityFunction(ProbabilityDensityFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Probability Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Probability Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProbabilityFunction(ProbabilityFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Continuous Sample</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Continuous Sample</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContinuousSample(ContinuousSample object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Probability Mass Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Probability Mass Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sample</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sample</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSample(Sample object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sample PDF</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sample PDF</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSamplePDF(SamplePDF object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //probfunctionSwitch
