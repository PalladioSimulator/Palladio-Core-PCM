/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultdecoratorFactoryImpl extends EFactoryImpl implements ResultdecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResultdecoratorFactory init() {
		try {
			ResultdecoratorFactory theResultdecoratorFactory = (ResultdecoratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/ResultDecorator/1.0"); 
			if (theResultdecoratorFactory != null) {
				return theResultdecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResultdecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultdecoratorFactoryImpl() {
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
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY: return createResultDecoratorRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDecoratorRepository createResultDecoratorRepository() {
		ResultDecoratorRepositoryImpl resultDecoratorRepository = new ResultDecoratorRepositoryImpl();
		return resultDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultdecoratorPackage getResultdecoratorPackage() {
		return (ResultdecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResultdecoratorPackage getPackage() {
		return ResultdecoratorPackage.eINSTANCE;
	}

} //ResultdecoratorFactoryImpl
