/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

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
 * @see de.uka.ipd.sdq.pcm.cost.costFactory
 * @model kind="package"
 * @generated
 */
public interface costPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cost";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/CostModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cost";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	costPackage eINSTANCE = de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.CostImpl <em>Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.CostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getCost()
	 * @generated
	 */
	int COST = 1;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__ANNOTATED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__OPERATING_COST = 1;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST__INITIAL_COST = 2;

	/**
	 * The number of structural features of the '<em>Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl <em>Component Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getComponentCost()
	 * @generated
	 */
	int COMPONENT_COST = 0;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST__ANNOTATED_ELEMENT = COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST__OPERATING_COST = COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST__INITIAL_COST = COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Component Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST__COMPONENT_OPERATING_COST = COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST__COMPONENT_INITIAL_COST = COST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repository Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST__REPOSITORY_COMPONENT = COST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_FEATURE_COUNT = COST_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.FixedLinkingResourceCostImpl <em>Fixed Linking Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.FixedLinkingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getFixedLinkingResourceCost()
	 * @generated
	 */
	int FIXED_LINKING_RESOURCE_COST = 2;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__ANNOTATED_ELEMENT = COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__OPERATING_COST = COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__INITIAL_COST = COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE = COST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed Linking Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST_FEATURE_COUNT = COST_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl <em>Fixed Processing Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getFixedProcessingResourceCost()
	 * @generated
	 */
	int FIXED_PROCESSING_RESOURCE_COST = 3;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__ANNOTATED_ELEMENT = COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__OPERATING_COST = COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__INITIAL_COST = COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST = COST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fixed Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST = COST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Fixed Processing Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST_FEATURE_COUNT = COST_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl <em>Variable Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableCost()
	 * @generated
	 */
	int VARIABLE_COST = 4;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_COST__ANNOTATED_ELEMENT = COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_COST__OPERATING_COST = COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_COST__INITIAL_COST = COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Fixed Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_COST__FIXED_INITIAL_COST = COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_COST__FIXED_OPERATING_COST = COST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_COST_FEATURE_COUNT = COST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableLinkingResourceCostImpl <em>Variable Linking Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableLinkingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableLinkingResourceCost()
	 * @generated
	 */
	int VARIABLE_LINKING_RESOURCE_COST = 5;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__ANNOTATED_ELEMENT = VARIABLE_COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__OPERATING_COST = VARIABLE_COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__INITIAL_COST = VARIABLE_COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Fixed Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__FIXED_INITIAL_COST = VARIABLE_COST__FIXED_INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Fixed Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__FIXED_OPERATING_COST = VARIABLE_COST__FIXED_OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Bandwith Initial Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__BANDWITH_INITIAL_FACTOR = VARIABLE_COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bandwidth Operating Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__BANDWIDTH_OPERATING_FACTOR = VARIABLE_COST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__LINKINGRESOURCE = VARIABLE_COST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Linking Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST_FEATURE_COUNT = VARIABLE_COST_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl <em>Variable Processing Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableProcessingResourceCost()
	 * @generated
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST = 6;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__ANNOTATED_ELEMENT = VARIABLE_COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__OPERATING_COST = VARIABLE_COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__INITIAL_COST = VARIABLE_COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Fixed Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST = VARIABLE_COST__FIXED_INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Fixed Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST = VARIABLE_COST__FIXED_OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Processing Rate Initial Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR = VARIABLE_COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processing Rate Operating Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR = VARIABLE_COST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = VARIABLE_COST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Processing Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST_FEATURE_COUNT = VARIABLE_COST_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl <em>Cost Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getCostRepository()
	 * @generated
	 */
	int COST_REPOSITORY = 7;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_REPOSITORY__COST = 0;

	/**
	 * The number of structural features of the '<em>Cost Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_REPOSITORY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost <em>Component Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ComponentCost
	 * @generated
	 */
	EClass getComponentCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentOperatingCost <em>Component Operating Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Operating Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentOperatingCost()
	 * @see #getComponentCost()
	 * @generated
	 */
	EAttribute getComponentCost_ComponentOperatingCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentInitialCost <em>Component Initial Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Initial Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ComponentCost#getComponentInitialCost()
	 * @see #getComponentCost()
	 * @generated
	 */
	EAttribute getComponentCost_ComponentInitialCost();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.ComponentCost#getRepositoryComponent <em>Repository Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repository Component</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ComponentCost#getRepositoryComponent()
	 * @see #getComponentCost()
	 * @generated
	 */
	EReference getComponentCost_RepositoryComponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.Cost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.Cost
	 * @generated
	 */
	EClass getCost();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.Cost#getAnnotatedElement <em>Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotated Element</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.Cost#getAnnotatedElement()
	 * @see #getCost()
	 * @generated
	 */
	EReference getCost_AnnotatedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.Cost#getOperatingCost <em>Operating Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.Cost#getOperatingCost()
	 * @see #getCost()
	 * @generated
	 */
	EAttribute getCost_OperatingCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.Cost#getInitialCost <em>Initial Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.Cost#getInitialCost()
	 * @see #getCost()
	 * @generated
	 */
	EAttribute getCost_InitialCost();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost <em>Fixed Linking Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Linking Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost
	 * @generated
	 */
	EClass getFixedLinkingResourceCost();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost#getLinkingresource <em>Linkingresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linkingresource</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost#getLinkingresource()
	 * @see #getFixedLinkingResourceCost()
	 * @generated
	 */
	EReference getFixedLinkingResourceCost_Linkingresource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost <em>Fixed Processing Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Processing Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost
	 * @generated
	 */
	EClass getFixedProcessingResourceCost();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcespecification</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost#getProcessingresourcespecification()
	 * @see #getFixedProcessingResourceCost()
	 * @generated
	 */
	EReference getFixedProcessingResourceCost_Processingresourcespecification();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost#getFixedOperatingCost <em>Fixed Operating Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Operating Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost#getFixedOperatingCost()
	 * @see #getFixedProcessingResourceCost()
	 * @generated
	 */
	EAttribute getFixedProcessingResourceCost_FixedOperatingCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost#getFixedInitialCost <em>Fixed Initial Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Initial Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost#getFixedInitialCost()
	 * @see #getFixedProcessingResourceCost()
	 * @generated
	 */
	EAttribute getFixedProcessingResourceCost_FixedInitialCost();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.VariableCost <em>Variable Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableCost
	 * @generated
	 */
	EClass getVariableCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.VariableCost#getFixedInitialCost <em>Fixed Initial Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Initial Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableCost#getFixedInitialCost()
	 * @see #getVariableCost()
	 * @generated
	 */
	EAttribute getVariableCost_FixedInitialCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.VariableCost#getFixedOperatingCost <em>Fixed Operating Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Operating Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableCost#getFixedOperatingCost()
	 * @see #getVariableCost()
	 * @generated
	 */
	EAttribute getVariableCost_FixedOperatingCost();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost <em>Variable Linking Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Linking Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost
	 * @generated
	 */
	EClass getVariableLinkingResourceCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwithInitialFactor <em>Bandwith Initial Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bandwith Initial Factor</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwithInitialFactor()
	 * @see #getVariableLinkingResourceCost()
	 * @generated
	 */
	EAttribute getVariableLinkingResourceCost_BandwithInitialFactor();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwidthOperatingFactor <em>Bandwidth Operating Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bandwidth Operating Factor</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwidthOperatingFactor()
	 * @see #getVariableLinkingResourceCost()
	 * @generated
	 */
	EAttribute getVariableLinkingResourceCost_BandwidthOperatingFactor();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getLinkingresource <em>Linkingresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linkingresource</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getLinkingresource()
	 * @see #getVariableLinkingResourceCost()
	 * @generated
	 */
	EReference getVariableLinkingResourceCost_Linkingresource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost <em>Variable Processing Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Processing Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost
	 * @generated
	 */
	EClass getVariableProcessingResourceCost();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFactor <em>Processing Rate Initial Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Rate Initial Factor</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFactor()
	 * @see #getVariableProcessingResourceCost()
	 * @generated
	 */
	EAttribute getVariableProcessingResourceCost_ProcessingRateInitialFactor();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFactor <em>Processing Rate Operating Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Rate Operating Factor</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFactor()
	 * @see #getVariableProcessingResourceCost()
	 * @generated
	 */
	EAttribute getVariableProcessingResourceCost_ProcessingRateOperatingFactor();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcespecification</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingresourcespecification()
	 * @see #getVariableProcessingResourceCost()
	 * @generated
	 */
	EReference getVariableProcessingResourceCost_Processingresourcespecification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.CostRepository <em>Cost Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cost Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.CostRepository
	 * @generated
	 */
	EClass getCostRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.CostRepository#getCost()
	 * @see #getCostRepository()
	 * @generated
	 */
	EReference getCostRepository_Cost();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	costFactory getcostFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl <em>Component Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getComponentCost()
		 * @generated
		 */
		EClass COMPONENT_COST = eINSTANCE.getComponentCost();

		/**
		 * The meta object literal for the '<em><b>Component Operating Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_COST__COMPONENT_OPERATING_COST = eINSTANCE.getComponentCost_ComponentOperatingCost();

		/**
		 * The meta object literal for the '<em><b>Component Initial Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_COST__COMPONENT_INITIAL_COST = eINSTANCE.getComponentCost_ComponentInitialCost();

		/**
		 * The meta object literal for the '<em><b>Repository Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_COST__REPOSITORY_COMPONENT = eINSTANCE.getComponentCost_RepositoryComponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.CostImpl <em>Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.CostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getCost()
		 * @generated
		 */
		EClass COST = eINSTANCE.getCost();

		/**
		 * The meta object literal for the '<em><b>Annotated Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COST__ANNOTATED_ELEMENT = eINSTANCE.getCost_AnnotatedElement();

		/**
		 * The meta object literal for the '<em><b>Operating Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COST__OPERATING_COST = eINSTANCE.getCost_OperatingCost();

		/**
		 * The meta object literal for the '<em><b>Initial Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COST__INITIAL_COST = eINSTANCE.getCost_InitialCost();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.FixedLinkingResourceCostImpl <em>Fixed Linking Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.FixedLinkingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getFixedLinkingResourceCost()
		 * @generated
		 */
		EClass FIXED_LINKING_RESOURCE_COST = eINSTANCE.getFixedLinkingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Linkingresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE = eINSTANCE.getFixedLinkingResourceCost_Linkingresource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl <em>Fixed Processing Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getFixedProcessingResourceCost()
		 * @generated
		 */
		EClass FIXED_PROCESSING_RESOURCE_COST = eINSTANCE.getFixedProcessingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Processingresourcespecification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = eINSTANCE.getFixedProcessingResourceCost_Processingresourcespecification();

		/**
		 * The meta object literal for the '<em><b>Fixed Operating Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST = eINSTANCE.getFixedProcessingResourceCost_FixedOperatingCost();

		/**
		 * The meta object literal for the '<em><b>Fixed Initial Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST = eINSTANCE.getFixedProcessingResourceCost_FixedInitialCost();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl <em>Variable Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableCost()
		 * @generated
		 */
		EClass VARIABLE_COST = eINSTANCE.getVariableCost();

		/**
		 * The meta object literal for the '<em><b>Fixed Initial Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_COST__FIXED_INITIAL_COST = eINSTANCE.getVariableCost_FixedInitialCost();

		/**
		 * The meta object literal for the '<em><b>Fixed Operating Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_COST__FIXED_OPERATING_COST = eINSTANCE.getVariableCost_FixedOperatingCost();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableLinkingResourceCostImpl <em>Variable Linking Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableLinkingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableLinkingResourceCost()
		 * @generated
		 */
		EClass VARIABLE_LINKING_RESOURCE_COST = eINSTANCE.getVariableLinkingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Bandwith Initial Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_LINKING_RESOURCE_COST__BANDWITH_INITIAL_FACTOR = eINSTANCE.getVariableLinkingResourceCost_BandwithInitialFactor();

		/**
		 * The meta object literal for the '<em><b>Bandwidth Operating Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_LINKING_RESOURCE_COST__BANDWIDTH_OPERATING_FACTOR = eINSTANCE.getVariableLinkingResourceCost_BandwidthOperatingFactor();

		/**
		 * The meta object literal for the '<em><b>Linkingresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_LINKING_RESOURCE_COST__LINKINGRESOURCE = eINSTANCE.getVariableLinkingResourceCost_Linkingresource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl <em>Variable Processing Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableProcessingResourceCost()
		 * @generated
		 */
		EClass VARIABLE_PROCESSING_RESOURCE_COST = eINSTANCE.getVariableProcessingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Processing Rate Initial Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR = eINSTANCE.getVariableProcessingResourceCost_ProcessingRateInitialFactor();

		/**
		 * The meta object literal for the '<em><b>Processing Rate Operating Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR = eINSTANCE.getVariableProcessingResourceCost_ProcessingRateOperatingFactor();

		/**
		 * The meta object literal for the '<em><b>Processingresourcespecification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = eINSTANCE.getVariableProcessingResourceCost_Processingresourcespecification();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl <em>Cost Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getCostRepository()
		 * @generated
		 */
		EClass COST_REPOSITORY = eINSTANCE.getCostRepository();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COST_REPOSITORY__COST = eINSTANCE.getCostRepository_Cost();

	}

} //costPackage
