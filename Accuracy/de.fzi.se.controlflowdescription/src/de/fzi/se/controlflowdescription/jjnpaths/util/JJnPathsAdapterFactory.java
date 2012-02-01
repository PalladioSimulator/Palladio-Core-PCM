/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.util;

import de.fzi.se.controlflowdescription.jjnpaths.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage
 * @generated
 */
public class JJnPathsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JJnPathsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JJnPathsPackage.eINSTANCE;
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
	@Override
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
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJnPathsSwitch<Adapter> modelSwitch =
		new JJnPathsSwitch<Adapter>() {
			@Override
			public Adapter caseJJnPathTestSuite(JJnPathTestSuite object) {
				return createJJnPathTestSuiteAdapter();
			}
			@Override
			public Adapter caseJJnPath(JJnPath object) {
				return createJJnPathAdapter();
			}
			@Override
			public Adapter caseJJPath(JJPath object) {
				return createJJPathAdapter();
			}
			@Override
			public Adapter caseJJnPathTestCase(JJnPathTestCase object) {
				return createJJnPathTestCaseAdapter();
			}
			@Override
			public Adapter caseJJnPathsCreationParameter(JJnPathsCreationParameter object) {
				return createJJnPathsCreationParameterAdapter();
			}
			@Override
			public Adapter caseJJnPathSet(JJnPathSet object) {
				return createJJnPathSetAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite <em>JJn Path Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite
	 * @generated
	 */
	public Adapter createJJnPathTestSuiteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath <em>JJn Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath
	 * @generated
	 */
	public Adapter createJJnPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath <em>JJ Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath
	 * @generated
	 */
	public Adapter createJJPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase <em>JJn Path Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase
	 * @generated
	 */
	public Adapter createJJnPathTestCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter <em>Creation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsCreationParameter
	 * @generated
	 */
	public Adapter createJJnPathsCreationParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet <em>JJn Path Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet
	 * @generated
	 */
	public Adapter createJJnPathSetAdapter() {
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

} //JJnPathsAdapterFactory
