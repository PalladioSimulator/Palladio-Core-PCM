/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.parameter.*;

import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.ParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterUsage;

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
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage
 * @generated
 */
public class ParameterSwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ParameterPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterSwitch() {
		if (modelPackage == null) {
			modelPackage = ParameterPackage.eINSTANCE;
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
			case ParameterPackage.PARAMETER_CHARACTERISATION: {
				ParameterCharacterisation parameterCharacterisation = (ParameterCharacterisation)theEObject;
				Object result = caseParameterCharacterisation(parameterCharacterisation);
				if (result == null) result = caseRandomVariable(parameterCharacterisation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE: {
				CompositeParameterUsage compositeParameterUsage = (CompositeParameterUsage)theEObject;
				Object result = caseCompositeParameterUsage(compositeParameterUsage);
				if (result == null) result = caseParameterUsage(compositeParameterUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParameterPackage.COLLECTION_PARAMETER_USAGE: {
				CollectionParameterUsage collectionParameterUsage = (CollectionParameterUsage)theEObject;
				Object result = caseCollectionParameterUsage(collectionParameterUsage);
				if (result == null) result = caseParameterUsage(collectionParameterUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParameterPackage.COLLECTION_PARAMETER_CHARACTERISATION: {
				CollectionParameterCharacterisation collectionParameterCharacterisation = (CollectionParameterCharacterisation)theEObject;
				Object result = caseCollectionParameterCharacterisation(collectionParameterCharacterisation);
				if (result == null) result = caseRandomVariable(collectionParameterCharacterisation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParameterPackage.PRIMITIVE_PARAMETER_USAGE: {
				PrimitiveParameterUsage primitiveParameterUsage = (PrimitiveParameterUsage)theEObject;
				Object result = casePrimitiveParameterUsage(primitiveParameterUsage);
				if (result == null) result = caseParameterUsage(primitiveParameterUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ParameterPackage.PARAMETER_USAGE: {
				ParameterUsage parameterUsage = (ParameterUsage)theEObject;
				Object result = caseParameterUsage(parameterUsage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Characterisation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Characterisation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParameterCharacterisation(ParameterCharacterisation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParameterUsage(ParameterUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Composite Parameter Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Composite Parameter Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeParameterUsage(CompositeParameterUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Parameter Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Parameter Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionParameterUsage(CollectionParameterUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Parameter Characterisation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Parameter Characterisation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionParameterCharacterisation(CollectionParameterCharacterisation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Parameter Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Parameter Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveParameterUsage(PrimitiveParameterUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Random Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Random Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRandomVariable(RandomVariable object) {
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

} //ParameterSwitch
