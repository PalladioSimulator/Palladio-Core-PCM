/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator.util;

import SourceCodeDecorator.sourcecodedecorator.*;

import de.uka.ipd.sdq.identifier.Identifier;

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
 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage
 * @generated
 */
public class SourcecodedecoratorSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SourcecodedecoratorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcecodedecoratorSwitch() {
		if (modelPackage == null) {
			modelPackage = SourcecodedecoratorPackage.eINSTANCE;
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
			case SourcecodedecoratorPackage.SOURCE_CODE_ID: {
				SourceCodeID sourceCodeID = (SourceCodeID)theEObject;
				T result = caseSourceCodeID(sourceCodeID);
				if (result == null) result = caseIdentifier(sourceCodeID);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK: {
				FileLevelSourceCodeLink fileLevelSourceCodeLink = (FileLevelSourceCodeLink)theEObject;
				T result = caseFileLevelSourceCodeLink(fileLevelSourceCodeLink);
				if (result == null) result = caseSourceCodeID(fileLevelSourceCodeLink);
				if (result == null) result = caseIdentifier(fileLevelSourceCodeLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.SOURCE_FILE: {
				SourceFile sourceFile = (SourceFile)theEObject;
				T result = caseSourceFile(sourceFile);
				if (result == null) result = caseIdentifier(sourceFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.METHODS: {
				Methods methods = (Methods)theEObject;
				T result = caseMethods(methods);
				if (result == null) result = caseIdentifier(methods);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK: {
				MethodLevelSourceCodeLink methodLevelSourceCodeLink = (MethodLevelSourceCodeLink)theEObject;
				T result = caseMethodLevelSourceCodeLink(methodLevelSourceCodeLink);
				if (result == null) result = caseFileLevelSourceCodeLink(methodLevelSourceCodeLink);
				if (result == null) result = caseSourceCodeID(methodLevelSourceCodeLink);
				if (result == null) result = caseIdentifier(methodLevelSourceCodeLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK: {
				ControlFlowLevelSourceCodeLink controlFlowLevelSourceCodeLink = (ControlFlowLevelSourceCodeLink)theEObject;
				T result = caseControlFlowLevelSourceCodeLink(controlFlowLevelSourceCodeLink);
				if (result == null) result = caseMethodLevelSourceCodeLink(controlFlowLevelSourceCodeLink);
				if (result == null) result = caseFileLevelSourceCodeLink(controlFlowLevelSourceCodeLink);
				if (result == null) result = caseSourceCodeID(controlFlowLevelSourceCodeLink);
				if (result == null) result = caseIdentifier(controlFlowLevelSourceCodeLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.CONTROL_FLOW: {
				ControlFlow controlFlow = (ControlFlow)theEObject;
				T result = caseControlFlow(controlFlow);
				if (result == null) result = caseIdentifier(controlFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY: {
				SourceCodeDecoratorRepository sourceCodeDecoratorRepository = (SourceCodeDecoratorRepository)theEObject;
				T result = caseSourceCodeDecoratorRepository(sourceCodeDecoratorRepository);
				if (result == null) result = caseIdentifier(sourceCodeDecoratorRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Code ID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Code ID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceCodeID(SourceCodeID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Level Source Code Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Level Source Code Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileLevelSourceCodeLink(FileLevelSourceCodeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFile(SourceFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Methods</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Methods</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethods(Methods object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Level Source Code Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Level Source Code Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodLevelSourceCodeLink(MethodLevelSourceCodeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Flow Level Source Code Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Flow Level Source Code Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlFlowLevelSourceCodeLink(ControlFlowLevelSourceCodeLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlFlow(ControlFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Code Decorator Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Code Decorator Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceCodeDecoratorRepository(SourceCodeDecoratorRepository object) {
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

} //SourcecodedecoratorSwitch
