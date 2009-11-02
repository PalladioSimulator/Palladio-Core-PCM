/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.util;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;

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
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage
 * @generated
 */
public class LoggerlinkSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LoggerlinkPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggerlinkSwitch() {
		if (modelPackage == null) {
			modelPackage = LoggerlinkPackage.eINSTANCE;
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK: {
				BeforeReturnValueLoggingPositionLink beforeReturnValueLoggingPositionLink = (BeforeReturnValueLoggingPositionLink)theEObject;
				T result = caseBeforeReturnValueLoggingPositionLink(beforeReturnValueLoggingPositionLink);
				if (result == null) result = caseOutputLoggingPositionLink(beforeReturnValueLoggingPositionLink);
				if (result == null) result = caseLoggingPositionIdLink(beforeReturnValueLoggingPositionLink);
				if (result == null) result = caseIdentifier(beforeReturnValueLoggingPositionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoggerlinkPackage.OUTPUT_LOGGING_POSITION_LINK: {
				OutputLoggingPositionLink outputLoggingPositionLink = (OutputLoggingPositionLink)theEObject;
				T result = caseOutputLoggingPositionLink(outputLoggingPositionLink);
				if (result == null) result = caseLoggingPositionIdLink(outputLoggingPositionLink);
				if (result == null) result = caseIdentifier(outputLoggingPositionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoggerlinkPackage.BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK: {
				BeforeExternalCallLoggingPositionLink beforeExternalCallLoggingPositionLink = (BeforeExternalCallLoggingPositionLink)theEObject;
				T result = caseBeforeExternalCallLoggingPositionLink(beforeExternalCallLoggingPositionLink);
				if (result == null) result = caseOutputLoggingPositionLink(beforeExternalCallLoggingPositionLink);
				if (result == null) result = caseLoggingPositionIdLink(beforeExternalCallLoggingPositionLink);
				if (result == null) result = caseIdentifier(beforeExternalCallLoggingPositionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK: {
				MethodCallLoggingPositionLink methodCallLoggingPositionLink = (MethodCallLoggingPositionLink)theEObject;
				T result = caseMethodCallLoggingPositionLink(methodCallLoggingPositionLink);
				if (result == null) result = caseInputLoggingPositionLink(methodCallLoggingPositionLink);
				if (result == null) result = caseLoggingPositionIdLink(methodCallLoggingPositionLink);
				if (result == null) result = caseIdentifier(methodCallLoggingPositionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoggerlinkPackage.INPUT_LOGGING_POSITION_LINK: {
				InputLoggingPositionLink inputLoggingPositionLink = (InputLoggingPositionLink)theEObject;
				T result = caseInputLoggingPositionLink(inputLoggingPositionLink);
				if (result == null) result = caseLoggingPositionIdLink(inputLoggingPositionLink);
				if (result == null) result = caseIdentifier(inputLoggingPositionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK: {
				AfterExternalCallLoggingPositionLink afterExternalCallLoggingPositionLink = (AfterExternalCallLoggingPositionLink)theEObject;
				T result = caseAfterExternalCallLoggingPositionLink(afterExternalCallLoggingPositionLink);
				if (result == null) result = caseInputLoggingPositionLink(afterExternalCallLoggingPositionLink);
				if (result == null) result = caseLoggingPositionIdLink(afterExternalCallLoggingPositionLink);
				if (result == null) result = caseIdentifier(afterExternalCallLoggingPositionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LoggerlinkPackage.LOGGING_POSITION_ID_LINK: {
				LoggingPositionIdLink loggingPositionIdLink = (LoggingPositionIdLink)theEObject;
				T result = caseLoggingPositionIdLink(loggingPositionIdLink);
				if (result == null) result = caseIdentifier(loggingPositionIdLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Before Return Value Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Before Return Value Logging Position Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeforeReturnValueLoggingPositionLink(BeforeReturnValueLoggingPositionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Logging Position Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputLoggingPositionLink(OutputLoggingPositionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Before External Call Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Before External Call Logging Position Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeforeExternalCallLoggingPositionLink(BeforeExternalCallLoggingPositionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Call Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Call Logging Position Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodCallLoggingPositionLink(MethodCallLoggingPositionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Logging Position Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputLoggingPositionLink(InputLoggingPositionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>After External Call Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>After External Call Logging Position Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAfterExternalCallLoggingPositionLink(AfterExternalCallLoggingPositionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logging Position Id Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logging Position Id Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoggingPositionIdLink(LoggingPositionIdLink object) {
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

} //LoggerlinkSwitch
