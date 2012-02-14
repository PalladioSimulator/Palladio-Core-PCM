/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties.util;

import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage
 * @generated
 */
public class QualityPropertiesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QualityPropertiesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityPropertiesSwitch() {
		if (modelPackage == null) {
			modelPackage = QualityPropertiesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QualityPropertiesPackage.NUMERIC_QUALITY_PROPERTY: {
				NumericQualityProperty numericQualityProperty = (NumericQualityProperty)theEObject;
				T result = caseNumericQualityProperty(numericQualityProperty);
				if (result == null) result = caseQualityProperty(numericQualityProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL: {
				ConfidenceInterval confidenceInterval = (ConfidenceInterval)theEObject;
				T result = caseConfidenceInterval(confidenceInterval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QualityPropertiesPackage.ELEMENT_QUALITY_PROPERTY: {
				ElementQualityProperty elementQualityProperty = (ElementQualityProperty)theEObject;
				T result = caseElementQualityProperty(elementQualityProperty);
				if (result == null) result = caseQualityProperty(elementQualityProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QualityPropertiesPackage.INTEGER_QUALITY_PROPERTY: {
				IntegerQualityProperty integerQualityProperty = (IntegerQualityProperty)theEObject;
				T result = caseIntegerQualityProperty(integerQualityProperty);
				if (result == null) result = caseNumericQualityProperty(integerQualityProperty);
				if (result == null) result = caseQualityProperty(integerQualityProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QualityPropertiesPackage.DOUBLE_QUALITY_PROPERTY: {
				DoubleQualityProperty doubleQualityProperty = (DoubleQualityProperty)theEObject;
				T result = caseDoubleQualityProperty(doubleQualityProperty);
				if (result == null) result = caseNumericQualityProperty(doubleQualityProperty);
				if (result == null) result = caseQualityProperty(doubleQualityProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QualityPropertiesPackage.QUALITY_PREDICTION: {
				QualityPrediction qualityPrediction = (QualityPrediction)theEObject;
				T result = caseQualityPrediction(qualityPrediction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QualityPropertiesPackage.QUALITY_PROPERTY: {
				QualityProperty qualityProperty = (QualityProperty)theEObject;
				T result = caseQualityProperty(qualityProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Quality Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericQualityProperty(NumericQualityProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Confidence Interval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Confidence Interval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfidenceInterval(ConfidenceInterval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Quality Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementQualityProperty(ElementQualityProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Quality Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerQualityProperty(IntegerQualityProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Quality Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleQualityProperty(DoubleQualityProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quality Prediction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quality Prediction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualityPrediction(QualityPrediction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quality Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualityProperty(QualityProperty object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QualityPropertiesSwitch
