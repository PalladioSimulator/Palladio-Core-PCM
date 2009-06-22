/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repository.impl;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class repositorydecoratorFactoryImpl extends EFactoryImpl implements repositorydecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static repositorydecoratorFactory init() {
		try {
			repositorydecoratorFactory therepositorydecoratorFactory = (repositorydecoratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ResultDecorator/Repository/1.0"); 
			if (therepositorydecoratorFactory != null) {
				return therepositorydecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new repositorydecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public repositorydecoratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case repositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS: return createInterfaceProvidingRequiringEntityResults();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingRequiringEntityResults createInterfaceProvidingRequiringEntityResults() {
		InterfaceProvidingRequiringEntityResultsImpl interfaceProvidingRequiringEntityResults = new InterfaceProvidingRequiringEntityResultsImpl();
		return interfaceProvidingRequiringEntityResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public repositorydecoratorPackage getrepositorydecoratorPackage() {
		return (repositorydecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static repositorydecoratorPackage getPackage() {
		return repositorydecoratorPackage.eINSTANCE;
	}

} //repositorydecoratorFactoryImpl
