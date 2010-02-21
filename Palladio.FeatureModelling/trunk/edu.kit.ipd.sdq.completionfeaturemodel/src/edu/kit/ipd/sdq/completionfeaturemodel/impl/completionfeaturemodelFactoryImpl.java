/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel.impl;

import edu.kit.ipd.sdq.completionfeaturemodel.*;

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
public class completionfeaturemodelFactoryImpl extends EFactoryImpl implements completionfeaturemodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static completionfeaturemodelFactory init() {
		try {
			completionfeaturemodelFactory thecompletionfeaturemodelFactory = (completionfeaturemodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.kit.edu/CompletionFeatureModel/1.0"); 
			if (thecompletionfeaturemodelFactory != null) {
				return thecompletionfeaturemodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new completionfeaturemodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public completionfeaturemodelFactoryImpl() {
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE: return createCompletionFeature();
			case completionfeaturemodelPackage.DISAMBIGUATION_RULE: return createDisambiguationRule();
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM: return createCompletionFeatureDiagram();
			case completionfeaturemodelPackage.COMPLETION_SIMPLE: return createCompletionSimple();
			case completionfeaturemodelPackage.COMPLETION_FEATURE_GROUP: return createCompletionFeatureGroup();
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
			case completionfeaturemodelPackage.FEATURE_STATE:
				return createFeatureStateFromString(eDataType, initialValue);
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
			case completionfeaturemodelPackage.FEATURE_STATE:
				return convertFeatureStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionFeature createCompletionFeature() {
		CompletionFeatureImpl completionFeature = new CompletionFeatureImpl();
		return completionFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisambiguationRule createDisambiguationRule() {
		DisambiguationRuleImpl disambiguationRule = new DisambiguationRuleImpl();
		return disambiguationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionFeatureDiagram createCompletionFeatureDiagram() {
		CompletionFeatureDiagramImpl completionFeatureDiagram = new CompletionFeatureDiagramImpl();
		return completionFeatureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionSimple createCompletionSimple() {
		CompletionSimpleImpl completionSimple = new CompletionSimpleImpl();
		return completionSimple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionFeatureGroup createCompletionFeatureGroup() {
		CompletionFeatureGroupImpl completionFeatureGroup = new CompletionFeatureGroupImpl();
		return completionFeatureGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureState createFeatureStateFromString(EDataType eDataType, String initialValue) {
		FeatureState result = FeatureState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public completionfeaturemodelPackage getcompletionfeaturemodelPackage() {
		return (completionfeaturemodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static completionfeaturemodelPackage getPackage() {
		return completionfeaturemodelPackage.eINSTANCE;
	}

} //completionfeaturemodelFactoryImpl
