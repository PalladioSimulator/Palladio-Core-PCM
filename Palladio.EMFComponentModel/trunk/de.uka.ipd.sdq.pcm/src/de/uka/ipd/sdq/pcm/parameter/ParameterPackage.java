/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * The parameter package allows to model data dependent performance characteristics of software systems. It is mainly used to specify performance dependencies on input and output parameters of single service calls. It can also be used to describe dependencies on the state of components by the use of component parameters. The latter describe stochastically a component state which does not change over time. 
 * 
 * Parameters are described by the use of variable usages which on the one side contain a performance abstraction of the variable's value and on the other side the name of the variable for refering to the variable. Characterisations available include Structure (information on the data's internal structure like "sorted" or "unsorted" for an array), Number of Elements (size of a collection), Value (the actuall variable value), Bytesize (the variable's memory footprint), or type (the type of the variable in polymorphic cases).
 * 
 * Example for variable usages may be a.NUMBER_OF_ELEMENTS = 10 (array "a" contains 10 elements), tree.STRUCTURE = "balanced" (tree "tree" is a balanced tree), and so on.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterFactory
 * @model kind="package"
 * @generated
 */
public interface ParameterPackage extends EPackage {
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
	String eNAME = "parameter";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/4.0";

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
	ParameterPackage eINSTANCE = de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl <em>Variable Characterisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisation()
	 * @generated
	 */
	int VARIABLE_CHARACTERISATION = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Specification Variable Characterisation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION = 1;

	/**
	 * The number of structural features of the '<em>Variable Characterisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CHARACTERISATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl <em>Characterised Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCharacterisedVariable()
	 * @generated
	 */
	int CHARACTERISED_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Id Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE__ID_VARIABLE = StoexPackage.VARIABLE__ID_VARIABLE;

	/**
	 * The feature id for the '<em><b>Characterisation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE = StoexPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Characterised Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISED_VARIABLE_FEATURE_COUNT = StoexPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl <em>Variable Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableUsage()
	 * @generated
	 */
	int VARIABLE_USAGE = 2;

	/**
	 * The feature id for the '<em><b>Variable Characterisation Variable Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE = 0;

	/**
	 * The feature id for the '<em><b>Named Reference Variable Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE = 1;

	/**
	 * The number of structural features of the '<em>Variable Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_USAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType <em>Variable Characterisation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisationType()
	 * @generated
	 */
	int VARIABLE_CHARACTERISATION_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation <em>Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation
	 * @generated
	 */
	EClass getVariableCharacterisation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getType()
	 * @see #getVariableCharacterisation()
	 * @generated
	 */
	EAttribute getVariableCharacterisation_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation <em>Specification Variable Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification Variable Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation#getSpecification_VariableCharacterisation()
	 * @see #getVariableCharacterisation()
	 * @generated
	 */
	EReference getVariableCharacterisation_Specification_VariableCharacterisation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable <em>Characterised Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterised Variable</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable
	 * @generated
	 */
	EClass getCharacterisedVariable();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationType <em>Characterisation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Characterisation Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable#getCharacterisationType()
	 * @see #getCharacterisedVariable()
	 * @generated
	 */
	EAttribute getCharacterisedVariable_CharacterisationType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage <em>Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage
	 * @generated
	 */
	EClass getVariableUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Characterisation Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getVariableCharacterisation_VariableUsage()
	 * @see #getVariableUsage()
	 * @generated
	 */
	EReference getVariableUsage_VariableCharacterisation_VariableUsage();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Named Reference Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getNamedReference_VariableUsage()
	 * @see #getVariableUsage()
	 * @generated
	 */
	EReference getVariableUsage_NamedReference_VariableUsage();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType <em>Variable Characterisation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Characterisation Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
	 * @generated
	 */
	EEnum getVariableCharacterisationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParameterFactory getParameterFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl <em>Variable Characterisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableCharacterisationImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisation()
		 * @generated
		 */
		EClass VARIABLE_CHARACTERISATION = eINSTANCE.getVariableCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_CHARACTERISATION__TYPE = eINSTANCE.getVariableCharacterisation_Type();

		/**
		 * The meta object literal for the '<em><b>Specification Variable Characterisation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION = eINSTANCE.getVariableCharacterisation_Specification_VariableCharacterisation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl <em>Characterised Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.CharacterisedVariableImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCharacterisedVariable()
		 * @generated
		 */
		EClass CHARACTERISED_VARIABLE = eINSTANCE.getCharacterisedVariable();

		/**
		 * The meta object literal for the '<em><b>Characterisation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE = eINSTANCE.getCharacterisedVariable_CharacterisationType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl <em>Variable Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableUsage()
		 * @generated
		 */
		EClass VARIABLE_USAGE = eINSTANCE.getVariableUsage();

		/**
		 * The meta object literal for the '<em><b>Variable Characterisation Variable Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE = eINSTANCE.getVariableUsage_VariableCharacterisation_VariableUsage();

		/**
		 * The meta object literal for the '<em><b>Named Reference Variable Usage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE = eINSTANCE.getVariableUsage_NamedReference_VariableUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType <em>Variable Characterisation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getVariableCharacterisationType()
		 * @generated
		 */
		EEnum VARIABLE_CHARACTERISATION_TYPE = eINSTANCE.getVariableCharacterisationType();

	}

} //ParameterPackage
