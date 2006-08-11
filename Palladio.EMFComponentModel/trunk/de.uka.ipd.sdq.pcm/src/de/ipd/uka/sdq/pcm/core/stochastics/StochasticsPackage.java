/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.core.stochastics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.ipd.uka.sdq.pcm.core.stochastics.StochasticsFactory
 * @model kind="package"
 * @generated
 */
public interface StochasticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stochastics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Core/Stochastics/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.core.stochastics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StochasticsPackage eINSTANCE = de.ipd.uka.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ipd.uka.sdq.pcm.core.stochastics.impl.RandomVariableImpl <em>Random Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.ipd.uka.sdq.pcm.core.stochastics.impl.RandomVariableImpl
	 * @see de.ipd.uka.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getRandomVariable()
	 * @generated
	 */
	int RANDOM_VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE__SPECIFICATION = 0;

	/**
	 * The number of structural features of the '<em>Random Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VARIABLE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.ipd.uka.sdq.pcm.core.stochastics.RandomVariable <em>Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Variable</em>'.
	 * @see de.ipd.uka.sdq.pcm.core.stochastics.RandomVariable
	 * @generated
	 */
	EClass getRandomVariable();

	/**
	 * Returns the meta object for the attribute '{@link de.ipd.uka.sdq.pcm.core.stochastics.RandomVariable#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see de.ipd.uka.sdq.pcm.core.stochastics.RandomVariable#getSpecification()
	 * @see #getRandomVariable()
	 * @generated
	 */
	EAttribute getRandomVariable_Specification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StochasticsFactory getStochasticsFactory();

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
		 * The meta object literal for the '{@link de.ipd.uka.sdq.pcm.core.stochastics.impl.RandomVariableImpl <em>Random Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.ipd.uka.sdq.pcm.core.stochastics.impl.RandomVariableImpl
		 * @see de.ipd.uka.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl#getRandomVariable()
		 * @generated
		 */
		EClass RANDOM_VARIABLE = eINSTANCE.getRandomVariable();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_VARIABLE__SPECIFICATION = eINSTANCE.getRandomVariable_Specification();

	}

} //StochasticsPackage
