/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.util;

import AnnotationPackage.Annotation;

import AnnotationPackage.DefaultAnnotationDataTypes.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage
 * @generated
 */
public class DefaultAnnotationDataTypesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DefaultAnnotationDataTypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnotationDataTypesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DefaultAnnotationDataTypesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultAnnotationDataTypesSwitch modelSwitch =
		new DefaultAnnotationDataTypesSwitch() {
			public Object caseBooleanAnnotation(BooleanAnnotation object) {
				return createBooleanAnnotationAdapter();
			}
			public Object caseDoubleAnnotation(DoubleAnnotation object) {
				return createDoubleAnnotationAdapter();
			}
			public Object caseIntegerAnnotation(IntegerAnnotation object) {
				return createIntegerAnnotationAdapter();
			}
			public Object caseLongAnnotation(LongAnnotation object) {
				return createLongAnnotationAdapter();
			}
			public Object caseShortAnnotation(ShortAnnotation object) {
				return createShortAnnotationAdapter();
			}
			public Object caseStringAnnotation(StringAnnotation object) {
				return createStringAnnotationAdapter();
			}
			public Object caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation <em>Boolean Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation
	 * @generated
	 */
	public Adapter createBooleanAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.DefaultAnnotationDataTypes.DoubleAnnotation <em>Double Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.DoubleAnnotation
	 * @generated
	 */
	public Adapter createDoubleAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation <em>Integer Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation
	 * @generated
	 */
	public Adapter createIntegerAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.DefaultAnnotationDataTypes.LongAnnotation <em>Long Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.LongAnnotation
	 * @generated
	 */
	public Adapter createLongAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.DefaultAnnotationDataTypes.ShortAnnotation <em>Short Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.ShortAnnotation
	 * @generated
	 */
	public Adapter createShortAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation <em>String Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation
	 * @generated
	 */
	public Adapter createStringAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link AnnotationPackage.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see AnnotationPackage.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DefaultAnnotationDataTypesAdapterFactory
