/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.*;

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
public class costFactoryImpl extends EFactoryImpl implements costFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static costFactory init() {
		try {
			costFactory thecostFactory = (costFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/CostModel/1.0"); 
			if (thecostFactory != null) {
				return thecostFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new costFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public costFactoryImpl() {
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
			case costPackage.COMPONENT_COST: return createComponentCost();
			case costPackage.FIXED_LINKING_RESOURCE_COST: return createFixedLinkingResourceCost();
			case costPackage.FIXED_PROCESSING_RESOURCE_COST: return createFixedProcessingResourceCost();
			case costPackage.VARIABLE_LINKING_RESOURCE_COST: return createVariableLinkingResourceCost();
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST: return createVariableProcessingResourceCost();
			case costPackage.SCALAR_FUNCTION: return createScalarFunction();
			case costPackage.COST_REPOSITORY: return createCostRepository();
			case costPackage.COMPONENT_COST_PER_INSTANCE: return createComponentCostPerInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentCost createComponentCost() {
		ComponentCostImpl componentCost = new ComponentCostImpl();
		return componentCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedLinkingResourceCost createFixedLinkingResourceCost() {
		FixedLinkingResourceCostImpl fixedLinkingResourceCost = new FixedLinkingResourceCostImpl();
		return fixedLinkingResourceCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedProcessingResourceCost createFixedProcessingResourceCost() {
		FixedProcessingResourceCostImpl fixedProcessingResourceCost = new FixedProcessingResourceCostImpl();
		return fixedProcessingResourceCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableLinkingResourceCost createVariableLinkingResourceCost() {
		VariableLinkingResourceCostImpl variableLinkingResourceCost = new VariableLinkingResourceCostImpl();
		return variableLinkingResourceCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableProcessingResourceCost createVariableProcessingResourceCost() {
		VariableProcessingResourceCostImpl variableProcessingResourceCost = new VariableProcessingResourceCostImpl();
		return variableProcessingResourceCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarFunction createScalarFunction() {
		ScalarFunctionImpl scalarFunction = new ScalarFunctionImpl();
		return scalarFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CostRepository createCostRepository() {
		CostRepositoryImpl costRepository = new CostRepositoryImpl();
		return costRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentCostPerInstance createComponentCostPerInstance() {
		ComponentCostPerInstanceImpl componentCostPerInstance = new ComponentCostPerInstanceImpl();
		return componentCostPerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public costPackage getcostPackage() {
		return (costPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static costPackage getPackage() {
		return costPackage.eINSTANCE;
	}

} //costFactoryImpl
