/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF.impl;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.*;

import org.eclipse.emf.ecore.EClass;
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
public class GDoFFactoryImpl extends EFactoryImpl implements GDoFFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GDoFFactory init() {
		try {
			GDoFFactory theGDoFFactory = (GDoFFactory)EPackage.Registry.INSTANCE.getEFactory("http:///DesignDecision/GDoF.ecore"); 
			if (theGDoFFactory != null) {
				return theGDoFFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GDoFFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GDoFFactoryImpl() {
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
			case GDoFPackage.CHANGEABLE_ELEMENT_DESCRIPTION: return createChangeableElementDescription();
			case GDoFPackage.VALUE_RULE: return createValueRule();
			case GDoFPackage.OCL_RULE: return createOCLRule();
			case GDoFPackage.HELPER_OCL_DEFINITION: return createHelperOCLDefinition();
			case GDoFPackage.DO_FREPOSITORY: return createDoFRepository();
			case GDoFPackage.INSTANCE_SELECTION_RULE: return createInstanceSelectionRule();
			case GDoFPackage.STATIC_SELECTION_RULE: return createStaticSelectionRule();
			case GDoFPackage.DEGREE_OF_FREEDOM: return createDegreeOfFreedom();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription createChangeableElementDescription() {
		ChangeableElementDescriptionImpl changeableElementDescription = new ChangeableElementDescriptionImpl();
		return changeableElementDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueRule createValueRule() {
		ValueRuleImpl valueRule = new ValueRuleImpl();
		return valueRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLRule createOCLRule() {
		OCLRuleImpl oclRule = new OCLRuleImpl();
		return oclRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HelperOCLDefinition createHelperOCLDefinition() {
		HelperOCLDefinitionImpl helperOCLDefinition = new HelperOCLDefinitionImpl();
		return helperOCLDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoFRepository createDoFRepository() {
		DoFRepositoryImpl doFRepository = new DoFRepositoryImpl();
		return doFRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSelectionRule createInstanceSelectionRule() {
		InstanceSelectionRuleImpl instanceSelectionRule = new InstanceSelectionRuleImpl();
		return instanceSelectionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticSelectionRule createStaticSelectionRule() {
		StaticSelectionRuleImpl staticSelectionRule = new StaticSelectionRuleImpl();
		return staticSelectionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DegreeOfFreedom createDegreeOfFreedom() {
		DegreeOfFreedomImpl degreeOfFreedom = new DegreeOfFreedomImpl();
		return degreeOfFreedom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GDoFPackage getGDoFPackage() {
		return (GDoFPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GDoFPackage getPackage() {
		return GDoFPackage.eINSTANCE;
	}

} //GDoFFactoryImpl
