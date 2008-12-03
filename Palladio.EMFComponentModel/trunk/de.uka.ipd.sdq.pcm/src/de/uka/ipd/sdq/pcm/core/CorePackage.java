/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

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
 * <!-- begin-model-doc -->
 * This package contains the PCM Core meta-classes used throughout the PCM: entities carrying a  globally unique ID (GUID), an abstract model for entities which provide and require interfaces, and  an abstract model to describe entities composed from other entities.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Core/4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl <em>PCM Random Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl
	 * @see de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl#getPCMRandomVariable()
	 * @generated
	 */
	int PCM_RANDOM_VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE__EXPRESSION = StoexPackage.RANDOM_VARIABLE__EXPRESSION;

	/**
	 * The number of structural features of the '<em>PCM Random Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCM_RANDOM_VARIABLE_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable <em>PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCM Random Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable
	 * @generated
	 */
	EClass getPCMRandomVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl <em>PCM Random Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.core.impl.PCMRandomVariableImpl
		 * @see de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl#getPCMRandomVariable()
		 * @generated
		 */
		EClass PCM_RANDOM_VARIABLE = eINSTANCE.getPCMRandomVariable();

	}

} //CorePackage
