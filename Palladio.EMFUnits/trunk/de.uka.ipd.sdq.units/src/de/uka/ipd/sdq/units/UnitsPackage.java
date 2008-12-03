/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.units;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see de.uka.ipd.sdq.units.UnitsFactory
 * @model kind="package"
 * @generated
 */
public interface UnitsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "units";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Units/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "units";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UnitsPackage eINSTANCE = de.uka.ipd.sdq.units.impl.UnitsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl <em>Unit Carrying Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitCarryingElement()
	 * @generated
	 */
	int UNIT_CARRYING_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CARRYING_ELEMENT__UNIT = 0;

	/**
	 * The feature id for the '<em><b>Unit Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION = 1;

	/**
	 * The number of structural features of the '<em>Unit Carrying Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CARRYING_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.UnitImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 1;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.BaseUnitImpl <em>Base Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.BaseUnitImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getBaseUnit()
	 * @generated
	 */
	int BASE_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Base Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_UNIT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.UnitRepositoryImpl <em>Unit Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.UnitRepositoryImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitRepository()
	 * @generated
	 */
	int UNIT_REPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REPOSITORY__UNITS = 0;

	/**
	 * The number of structural features of the '<em>Unit Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REPOSITORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.UnitMultiplicationImpl <em>Unit Multiplication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.UnitMultiplicationImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitMultiplication()
	 * @generated
	 */
	int UNIT_MULTIPLICATION = 4;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MULTIPLICATION__UNITS = UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit Multiplication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MULTIPLICATION_FEATURE_COUNT = UNIT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.UnitPowerImpl <em>Unit Power</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.UnitPowerImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitPower()
	 * @generated
	 */
	int UNIT_POWER = 5;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_POWER__UNIT = UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_POWER__EXPONENT = UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unit Power</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_POWER_FEATURE_COUNT = UNIT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.units.impl.UnitLiteralImpl <em>Unit Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.units.impl.UnitLiteralImpl
	 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitLiteral()
	 * @generated
	 */
	int UNIT_LITERAL = 6;

	/**
	 * The feature id for the '<em><b>Base Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LITERAL__BASE_UNIT = UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LITERAL_FEATURE_COUNT = UNIT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.UnitCarryingElement <em>Unit Carrying Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Carrying Element</em>'.
	 * @see de.uka.ipd.sdq.units.UnitCarryingElement
	 * @generated
	 */
	EClass getUnitCarryingElement();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.units.UnitCarryingElement#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.units.UnitCarryingElement#getUnit()
	 * @see #getUnitCarryingElement()
	 * @generated
	 */
	EReference getUnitCarryingElement_Unit();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.units.UnitCarryingElement#getUnitSpecification <em>Unit Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Specification</em>'.
	 * @see de.uka.ipd.sdq.units.UnitCarryingElement#getUnitSpecification()
	 * @see #getUnitCarryingElement()
	 * @generated
	 */
	EAttribute getUnitCarryingElement_UnitSpecification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.units.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.BaseUnit <em>Base Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Unit</em>'.
	 * @see de.uka.ipd.sdq.units.BaseUnit
	 * @generated
	 */
	EClass getBaseUnit();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.units.BaseUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.units.BaseUnit#getName()
	 * @see #getBaseUnit()
	 * @generated
	 */
	EAttribute getBaseUnit_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.UnitRepository <em>Unit Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Repository</em>'.
	 * @see de.uka.ipd.sdq.units.UnitRepository
	 * @generated
	 */
	EClass getUnitRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.units.UnitRepository#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see de.uka.ipd.sdq.units.UnitRepository#getUnits()
	 * @see #getUnitRepository()
	 * @generated
	 */
	EReference getUnitRepository_Units();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.UnitMultiplication <em>Unit Multiplication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Multiplication</em>'.
	 * @see de.uka.ipd.sdq.units.UnitMultiplication
	 * @generated
	 */
	EClass getUnitMultiplication();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.units.UnitMultiplication#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see de.uka.ipd.sdq.units.UnitMultiplication#getUnits()
	 * @see #getUnitMultiplication()
	 * @generated
	 */
	EReference getUnitMultiplication_Units();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.UnitPower <em>Unit Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Power</em>'.
	 * @see de.uka.ipd.sdq.units.UnitPower
	 * @generated
	 */
	EClass getUnitPower();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.units.UnitPower#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.units.UnitPower#getUnit()
	 * @see #getUnitPower()
	 * @generated
	 */
	EReference getUnitPower_Unit();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.units.UnitPower#getExponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exponent</em>'.
	 * @see de.uka.ipd.sdq.units.UnitPower#getExponent()
	 * @see #getUnitPower()
	 * @generated
	 */
	EAttribute getUnitPower_Exponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.units.UnitLiteral <em>Unit Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Literal</em>'.
	 * @see de.uka.ipd.sdq.units.UnitLiteral
	 * @generated
	 */
	EClass getUnitLiteral();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.units.UnitLiteral#getBaseUnit <em>Base Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Unit</em>'.
	 * @see de.uka.ipd.sdq.units.UnitLiteral#getBaseUnit()
	 * @see #getUnitLiteral()
	 * @generated
	 */
	EReference getUnitLiteral_BaseUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UnitsFactory getUnitsFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl <em>Unit Carrying Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.UnitCarryingElementImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitCarryingElement()
		 * @generated
		 */
		EClass UNIT_CARRYING_ELEMENT = eINSTANCE.getUnitCarryingElement();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CARRYING_ELEMENT__UNIT = eINSTANCE.getUnitCarryingElement_Unit();

		/**
		 * The meta object literal for the '<em><b>Unit Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION = eINSTANCE.getUnitCarryingElement_UnitSpecification();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.UnitImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.BaseUnitImpl <em>Base Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.BaseUnitImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getBaseUnit()
		 * @generated
		 */
		EClass BASE_UNIT = eINSTANCE.getBaseUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_UNIT__NAME = eINSTANCE.getBaseUnit_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.UnitRepositoryImpl <em>Unit Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.UnitRepositoryImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitRepository()
		 * @generated
		 */
		EClass UNIT_REPOSITORY = eINSTANCE.getUnitRepository();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_REPOSITORY__UNITS = eINSTANCE.getUnitRepository_Units();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.UnitMultiplicationImpl <em>Unit Multiplication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.UnitMultiplicationImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitMultiplication()
		 * @generated
		 */
		EClass UNIT_MULTIPLICATION = eINSTANCE.getUnitMultiplication();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_MULTIPLICATION__UNITS = eINSTANCE.getUnitMultiplication_Units();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.UnitPowerImpl <em>Unit Power</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.UnitPowerImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitPower()
		 * @generated
		 */
		EClass UNIT_POWER = eINSTANCE.getUnitPower();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_POWER__UNIT = eINSTANCE.getUnitPower_Unit();

		/**
		 * The meta object literal for the '<em><b>Exponent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_POWER__EXPONENT = eINSTANCE.getUnitPower_Exponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.units.impl.UnitLiteralImpl <em>Unit Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.units.impl.UnitLiteralImpl
		 * @see de.uka.ipd.sdq.units.impl.UnitsPackageImpl#getUnitLiteral()
		 * @generated
		 */
		EClass UNIT_LITERAL = eINSTANCE.getUnitLiteral();

		/**
		 * The meta object literal for the '<em><b>Base Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_LITERAL__BASE_UNIT = eINSTANCE.getUnitLiteral_BaseUnit();

	}

} //UnitsPackage
