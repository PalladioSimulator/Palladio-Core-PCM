/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.util;

import AnnotationPackage.Annotation;

import AnnotationPackage.DefaultAnnotationDataTypes.*;

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
 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage
 * @generated
 */
public class DefaultAnnotationDataTypesSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DefaultAnnotationDataTypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnotationDataTypesSwitch() {
		if (modelPackage == null) {
			modelPackage = DefaultAnnotationDataTypesPackage.eINSTANCE;
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
			case DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION: {
				BooleanAnnotation booleanAnnotation = (BooleanAnnotation)theEObject;
				Object result = caseBooleanAnnotation(booleanAnnotation);
				if (result == null) result = caseAnnotation(booleanAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefaultAnnotationDataTypesPackage.DOUBLE_ANNOTATION: {
				DoubleAnnotation doubleAnnotation = (DoubleAnnotation)theEObject;
				Object result = caseDoubleAnnotation(doubleAnnotation);
				if (result == null) result = caseAnnotation(doubleAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefaultAnnotationDataTypesPackage.INTEGER_ANNOTATION: {
				IntegerAnnotation integerAnnotation = (IntegerAnnotation)theEObject;
				Object result = caseIntegerAnnotation(integerAnnotation);
				if (result == null) result = caseAnnotation(integerAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefaultAnnotationDataTypesPackage.LONG_ANNOTATION: {
				LongAnnotation longAnnotation = (LongAnnotation)theEObject;
				Object result = caseLongAnnotation(longAnnotation);
				if (result == null) result = caseAnnotation(longAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefaultAnnotationDataTypesPackage.SHORT_ANNOTATION: {
				ShortAnnotation shortAnnotation = (ShortAnnotation)theEObject;
				Object result = caseShortAnnotation(shortAnnotation);
				if (result == null) result = caseAnnotation(shortAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefaultAnnotationDataTypesPackage.STRING_ANNOTATION: {
				StringAnnotation stringAnnotation = (StringAnnotation)theEObject;
				Object result = caseStringAnnotation(stringAnnotation);
				if (result == null) result = caseAnnotation(stringAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Boolean Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Boolean Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanAnnotation(BooleanAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Double Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Double Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDoubleAnnotation(DoubleAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Integer Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Integer Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerAnnotation(IntegerAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Long Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Long Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLongAnnotation(LongAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Short Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Short Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseShortAnnotation(ShortAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>String Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>String Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringAnnotation(StringAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnnotation(Annotation object) {
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

} //DefaultAnnotationDataTypesSwitch
