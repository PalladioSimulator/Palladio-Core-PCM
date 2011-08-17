/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class QMLContractTypeFactoryImpl extends EFactoryImpl implements QMLContractTypeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QMLContractTypeFactory init() {
		try {
			QMLContractTypeFactory theQMLContractTypeFactory = (QMLContractTypeFactory)EPackage.Registry.INSTANCE.getEFactory("http:///QMLContractType.ecore"); 
			if (theQMLContractTypeFactory != null) {
				return theQMLContractTypeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QMLContractTypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractTypeFactoryImpl() {
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
			case QMLContractTypePackage.DIMENSION_TYPE_SET: return createDimensionTypeSet();
			case QMLContractTypePackage.RELATION_SEMANTICS: return createRelationSemantics();
			case QMLContractTypePackage.ELEMENT: return createElement();
			case QMLContractTypePackage.ORDER: return createOrder();
			case QMLContractTypePackage.DIMENSION_TYPE_ENUM: return createDimensionTypeEnum();
			case QMLContractTypePackage.UNIT: return createUnit();
			case QMLContractTypePackage.DIMENSION_TYPE_NUMERIC: return createDimensionTypeNumeric();
			case QMLContractTypePackage.NUMERIC_RANGE: return createNumericRange();
			case QMLContractTypePackage.QML_CONTRACT_TYPE: return createQMLContractType();
			case QMLContractTypePackage.UNIT_REPOSITORY: return createUnitRepository();
			case QMLContractTypePackage.DIMENSION_TYPE_REPOSITORY: return createDimensionTypeRepository();
			case QMLContractTypePackage.DIMENSION: return createDimension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case QMLContractTypePackage.ENUM_RELATION_SEMANTICS:
				return createEnumRelationSemanticsFromString(eDataType, initialValue);
			case QMLContractTypePackage.ENUM_NUMERIC_DOMAIN:
				return createEnumNumericDomainFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case QMLContractTypePackage.ENUM_RELATION_SEMANTICS:
				return convertEnumRelationSemanticsToString(eDataType, instanceValue);
			case QMLContractTypePackage.ENUM_NUMERIC_DOMAIN:
				return convertEnumNumericDomainToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionTypeSet createDimensionTypeSet() {
		DimensionTypeSetImpl dimensionTypeSet = new DimensionTypeSetImpl();
		return dimensionTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationSemantics createRelationSemantics() {
		RelationSemanticsImpl relationSemantics = new RelationSemanticsImpl();
		return relationSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Order createOrder() {
		OrderImpl order = new OrderImpl();
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionTypeEnum createDimensionTypeEnum() {
		DimensionTypeEnumImpl dimensionTypeEnum = new DimensionTypeEnumImpl();
		return dimensionTypeEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionTypeNumeric createDimensionTypeNumeric() {
		DimensionTypeNumericImpl dimensionTypeNumeric = new DimensionTypeNumericImpl();
		return dimensionTypeNumeric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericRange createNumericRange() {
		NumericRangeImpl numericRange = new NumericRangeImpl();
		return numericRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractType createQMLContractType() {
		QMLContractTypeImpl qmlContractType = new QMLContractTypeImpl();
		return qmlContractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitRepository createUnitRepository() {
		UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();
		return unitRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionTypeRepository createDimensionTypeRepository() {
		DimensionTypeRepositoryImpl dimensionTypeRepository = new DimensionTypeRepositoryImpl();
		return dimensionTypeRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension createDimension() {
		DimensionImpl dimension = new DimensionImpl();
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumRelationSemantics createEnumRelationSemanticsFromString(EDataType eDataType, String initialValue) {
		EnumRelationSemantics result = EnumRelationSemantics.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumRelationSemanticsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumNumericDomain createEnumNumericDomainFromString(EDataType eDataType, String initialValue) {
		EnumNumericDomain result = EnumNumericDomain.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumNumericDomainToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractTypePackage getQMLContractTypePackage() {
		return (QMLContractTypePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QMLContractTypePackage getPackage() {
		return QMLContractTypePackage.eINSTANCE;
	}

} //QMLContractTypeFactoryImpl
