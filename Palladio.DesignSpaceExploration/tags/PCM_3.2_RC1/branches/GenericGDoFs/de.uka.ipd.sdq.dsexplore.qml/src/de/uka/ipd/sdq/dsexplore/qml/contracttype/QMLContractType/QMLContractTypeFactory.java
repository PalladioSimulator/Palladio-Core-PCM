/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage
 * @generated
 */
public interface QMLContractTypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QMLContractTypeFactory eINSTANCE = de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Dimension Type Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension Type Set</em>'.
	 * @generated
	 */
	DimensionTypeSet createDimensionTypeSet();

	/**
	 * Returns a new object of class '<em>Relation Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Semantics</em>'.
	 * @generated
	 */
	RelationSemantics createRelationSemantics();

	/**
	 * Returns a new object of class '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element</em>'.
	 * @generated
	 */
	Element createElement();

	/**
	 * Returns a new object of class '<em>Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order</em>'.
	 * @generated
	 */
	Order createOrder();

	/**
	 * Returns a new object of class '<em>Dimension Type Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension Type Enum</em>'.
	 * @generated
	 */
	DimensionTypeEnum createDimensionTypeEnum();

	/**
	 * Returns a new object of class '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit</em>'.
	 * @generated
	 */
	Unit createUnit();

	/**
	 * Returns a new object of class '<em>Dimension Type Numeric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension Type Numeric</em>'.
	 * @generated
	 */
	DimensionTypeNumeric createDimensionTypeNumeric();

	/**
	 * Returns a new object of class '<em>Numeric Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Range</em>'.
	 * @generated
	 */
	NumericRange createNumericRange();

	/**
	 * Returns a new object of class '<em>QML Contract Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QML Contract Type</em>'.
	 * @generated
	 */
	QMLContractType createQMLContractType();

	/**
	 * Returns a new object of class '<em>Unit Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Repository</em>'.
	 * @generated
	 */
	UnitRepository createUnitRepository();

	/**
	 * Returns a new object of class '<em>Dimension Type Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension Type Repository</em>'.
	 * @generated
	 */
	DimensionTypeRepository createDimensionTypeRepository();

	/**
	 * Returns a new object of class '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension</em>'.
	 * @generated
	 */
	Dimension createDimension();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QMLContractTypePackage getQMLContractTypePackage();

} //QMLContractTypeFactory
