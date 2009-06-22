/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface ResultdecoratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resultdecorator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ResultDecorator/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resultdecorator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultdecoratorPackage eINSTANCE = de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl <em>Result Decorator Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl#getResultDecoratorRepository()
	 * @generated
	 */
	int RESULT_DECORATOR_REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Interfaceprovidingrequiringentityresults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS = 0;

	/**
	 * The feature id for the '<em><b>Utilisationresult</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT = 1;

	/**
	 * The number of structural features of the '<em>Result Decorator Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DECORATOR_REPOSITORY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository <em>Result Decorator Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Decorator Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository
	 * @generated
	 */
	EClass getResultDecoratorRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getInterfaceprovidingrequiringentityresults <em>Interfaceprovidingrequiringentityresults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interfaceprovidingrequiringentityresults</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getInterfaceprovidingrequiringentityresults()
	 * @see #getResultDecoratorRepository()
	 * @generated
	 */
	EReference getResultDecoratorRepository_Interfaceprovidingrequiringentityresults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationresult <em>Utilisationresult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Utilisationresult</em>'.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationresult()
	 * @see #getResultDecoratorRepository()
	 * @generated
	 */
	EReference getResultDecoratorRepository_Utilisationresult();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResultdecoratorFactory getResultdecoratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl <em>Result Decorator Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl#getResultDecoratorRepository()
		 * @generated
		 */
		EClass RESULT_DECORATOR_REPOSITORY = eINSTANCE.getResultDecoratorRepository();

		/**
		 * The meta object literal for the '<em><b>Interfaceprovidingrequiringentityresults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS = eINSTANCE.getResultDecoratorRepository_Interfaceprovidingrequiringentityresults();

		/**
		 * The meta object literal for the '<em><b>Utilisationresult</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT = eINSTANCE.getResultDecoratorRepository_Utilisationresult();

	}

} //ResultdecoratorPackage
