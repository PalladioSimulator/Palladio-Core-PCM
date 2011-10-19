/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import de.uka.ipd.sdq.featuremodel.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.featuremodel.AttributeTypes;
import de.uka.ipd.sdq.featuremodel.ContinousIntervalRange;
import de.uka.ipd.sdq.featuremodel.DoubleAttribute;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.IntegerAttribute;
import de.uka.ipd.sdq.featuremodel.IntegerIntervalRange;
import de.uka.ipd.sdq.featuremodel.ProhibitsConstraint;
import de.uka.ipd.sdq.featuremodel.RequiredConstraint;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.featuremodelFactory;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class featuremodelFactoryImpl extends EFactoryImpl implements featuremodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static featuremodelFactory init() {
		try {
			featuremodelFactory thefeaturemodelFactory = (featuremodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/FeatureModel/2.0"); 
			if (thefeaturemodelFactory != null) {
				return thefeaturemodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new featuremodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featuremodelFactoryImpl() {
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
			case featuremodelPackage.FEATURE: return createFeature();
			case featuremodelPackage.SIMPLE: return createSimple();
			case featuremodelPackage.FEATURE_GROUP: return createFeatureGroup();
			case featuremodelPackage.FEATURE_DIAGRAM: return createFeatureDiagram();
			case featuremodelPackage.REQUIRED_CONSTRAINT: return createRequiredConstraint();
			case featuremodelPackage.PROHIBITS_CONSTRAINT: return createProhibitsConstraint();
			case featuremodelPackage.INTEGER_INTERVAL_RANGE: return createIntegerIntervalRange();
			case featuremodelPackage.CONTINOUS_INTERVAL_RANGE: return createContinousIntervalRange();
			case featuremodelPackage.INTEGER_ATTRIBUTE: return createIntegerAttribute();
			case featuremodelPackage.DOUBLE_ATTRIBUTE: return createDoubleAttribute();
			case featuremodelPackage.STRING_ATTRIBUTE: return createStringAttribute();
			case featuremodelPackage.EXTERNAL_OBJECT_ATTRIBUTE: return createExternalObjectAttribute();
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
			case featuremodelPackage.ATTRIBUTE_TYPES:
				return createAttributeTypesFromString(eDataType, initialValue);
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
			case featuremodelPackage.ATTRIBUTE_TYPES:
				return convertAttributeTypesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simple createSimple() {
		SimpleImpl simple = new SimpleImpl();
		return simple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroup createFeatureGroup() {
		FeatureGroupImpl featureGroup = new FeatureGroupImpl();
		return featureGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureDiagram createFeatureDiagram() {
		FeatureDiagramImpl featureDiagram = new FeatureDiagramImpl();
		return featureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerIntervalRange createIntegerIntervalRange() {
		IntegerIntervalRangeImpl integerIntervalRange = new IntegerIntervalRangeImpl();
		return integerIntervalRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinousIntervalRange createContinousIntervalRange() {
		ContinousIntervalRangeImpl continousIntervalRange = new ContinousIntervalRangeImpl();
		return continousIntervalRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAttribute createIntegerAttribute() {
		IntegerAttributeImpl integerAttribute = new IntegerAttributeImpl();
		return integerAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleAttribute createDoubleAttribute() {
		DoubleAttributeImpl doubleAttribute = new DoubleAttributeImpl();
		return doubleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAttribute createStringAttribute() {
		StringAttributeImpl stringAttribute = new StringAttributeImpl();
		return stringAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalObjectAttribute createExternalObjectAttribute() {
		ExternalObjectAttributeImpl externalObjectAttribute = new ExternalObjectAttributeImpl();
		return externalObjectAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredConstraint createRequiredConstraint() {
		RequiredConstraintImpl requiredConstraint = new RequiredConstraintImpl();
		return requiredConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProhibitsConstraint createProhibitsConstraint() {
		ProhibitsConstraintImpl prohibitsConstraint = new ProhibitsConstraintImpl();
		return prohibitsConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeTypes createAttributeTypesFromString(EDataType eDataType, String initialValue) {
		AttributeTypes result = AttributeTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public featuremodelPackage getfeaturemodelPackage() {
		return (featuremodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static featuremodelPackage getPackage() {
		return featuremodelPackage.eINSTANCE;
	}

} //featuremodelFactoryImpl
