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
 * <!-- begin-model-doc -->
 * The CostModel metamodel represents the cost of a software architecture and its alternatives. 
 * 
 * So far, the main concepts are ComponentCost and FixedProcessingResourceCost. ComponentCost specify how much is added to the software architecture cost if the referenced component is used. FixedProcessingResourceCost specify how much is added to the overall cost if the server that contains the referenced ProcessingResourceSpecification (e.g. a CPU with speed 1GHz) is used. 
 * 
 * Thus, to determine the overall cost of one candidate solution (i.e. one architecture), we need to check the PCM model to see which components and servers are used. We might want to add more classes to the taskmodel to make this easier. 
 * 
 * See the Cost element for details on the use of this model. 
 * <!-- end-model-doc -->
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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.LinkingResourceCostImpl <em>Linking Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.LinkingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getLinkingResourceCost()
	 * @generated
	 */
	int LINKING_RESOURCE_COST = 3;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_COST__ANNOTATED_ELEMENT = COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_COST__OPERATING_COST = COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_COST__INITIAL_COST = COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_COST__LINKINGRESOURCE = COST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linking Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_RESOURCE_COST_FEATURE_COUNT = COST_FEATURE_COUNT + 1;

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
	int FIXED_LINKING_RESOURCE_COST__ANNOTATED_ELEMENT = LINKING_RESOURCE_COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__OPERATING_COST = LINKING_RESOURCE_COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__INITIAL_COST = LINKING_RESOURCE_COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE = LINKING_RESOURCE_COST__LINKINGRESOURCE;

	/**
	 * The number of structural features of the '<em>Fixed Linking Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_LINKING_RESOURCE_COST_FEATURE_COUNT = LINKING_RESOURCE_COST_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ProcessingResourceCostImpl <em>Processing Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.ProcessingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getProcessingResourceCost()
	 * @generated
	 */
	int PROCESSING_RESOURCE_COST = 5;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_COST__ANNOTATED_ELEMENT = COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_COST__OPERATING_COST = COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_COST__INITIAL_COST = COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = COST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_COST_FEATURE_COUNT = COST_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl <em>Fixed Processing Resource Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getFixedProcessingResourceCost()
	 * @generated
	 */
	int FIXED_PROCESSING_RESOURCE_COST = 4;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__ANNOTATED_ELEMENT = PROCESSING_RESOURCE_COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__OPERATING_COST = PROCESSING_RESOURCE_COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__INITIAL_COST = PROCESSING_RESOURCE_COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION;

	/**
	 * The feature id for the '<em><b>Fixed Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST = PROCESSING_RESOURCE_COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST = PROCESSING_RESOURCE_COST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fixed Processing Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_PROCESSING_RESOURCE_COST_FEATURE_COUNT = PROCESSING_RESOURCE_COST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl <em>Variable Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableCostImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableCost()
	 * @generated
	 */
	int VARIABLE_COST = 6;

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
	int VARIABLE_LINKING_RESOURCE_COST = 7;

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
	 * The feature id for the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__LINKINGRESOURCE = VARIABLE_COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bandwith Initial Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__BANDWITH_INITIAL_FACTOR = VARIABLE_COST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bandwidth Operating Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_LINKING_RESOURCE_COST__BANDWIDTH_OPERATING_FACTOR = VARIABLE_COST_FEATURE_COUNT + 2;

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
	int VARIABLE_PROCESSING_RESOURCE_COST = 8;

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
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = VARIABLE_COST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processing Rate Initial Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION = VARIABLE_COST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Processing Rate Operating Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION = VARIABLE_COST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Processing Resource Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PROCESSING_RESOURCE_COST_FEATURE_COUNT = VARIABLE_COST_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ScalarFunctionImpl <em>Scalar Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.ScalarFunctionImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getScalarFunction()
	 * @generated
	 */
	int SCALAR_FUNCTION = 9;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_FUNCTION__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_FUNCTION__TERM = 1;

	/**
	 * The number of structural features of the '<em>Scalar Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_FUNCTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl <em>Cost Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.CostRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getCostRepository()
	 * @generated
	 */
	int COST_REPOSITORY = 10;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_REPOSITORY__COST = 0;

	/**
	 * The feature id for the '<em><b>Time Period Years</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_REPOSITORY__TIME_PERIOD_YEARS = 1;

	/**
	 * The feature id for the '<em><b>Interest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_REPOSITORY__INTEREST = 2;

	/**
	 * The number of structural features of the '<em>Cost Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_REPOSITORY_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostPerInstanceImpl <em>Component Cost Per Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.cost.impl.ComponentCostPerInstanceImpl
	 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getComponentCostPerInstance()
	 * @generated
	 */
	int COMPONENT_COST_PER_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Annotated Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__ANNOTATED_ELEMENT = COMPONENT_COST__ANNOTATED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__OPERATING_COST = COMPONENT_COST__OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__INITIAL_COST = COMPONENT_COST__INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Component Operating Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__COMPONENT_OPERATING_COST = COMPONENT_COST__COMPONENT_OPERATING_COST;

	/**
	 * The feature id for the '<em><b>Component Initial Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__COMPONENT_INITIAL_COST = COMPONENT_COST__COMPONENT_INITIAL_COST;

	/**
	 * The feature id for the '<em><b>Repository Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__REPOSITORY_COMPONENT = COMPONENT_COST__REPOSITORY_COMPONENT;

	/**
	 * The feature id for the '<em><b>Allocation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE__ALLOCATION = COMPONENT_COST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Cost Per Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_COST_PER_INSTANCE_FEATURE_COUNT = COMPONENT_COST_FEATURE_COUNT + 1;


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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.LinkingResourceCost <em>Linking Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linking Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.LinkingResourceCost
	 * @generated
	 */
	EClass getLinkingResourceCost();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.LinkingResourceCost#getLinkingresource <em>Linkingresource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linkingresource</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.LinkingResourceCost#getLinkingresource()
	 * @see #getLinkingResourceCost()
	 * @generated
	 */
	EReference getLinkingResourceCost_Linkingresource();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost <em>Processing Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost
	 * @generated
	 */
	EClass getProcessingResourceCost();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost#getProcessingresourcespecification <em>Processingresourcespecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcespecification</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost#getProcessingresourcespecification()
	 * @see #getProcessingResourceCost()
	 * @generated
	 */
	EReference getProcessingResourceCost_Processingresourcespecification();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost <em>Variable Processing Resource Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Processing Resource Cost</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost
	 * @generated
	 */
	EClass getVariableProcessingResourceCost();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFunction <em>Processing Rate Initial Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Processing Rate Initial Function</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateInitialFunction()
	 * @see #getVariableProcessingResourceCost()
	 * @generated
	 */
	EReference getVariableProcessingResourceCost_ProcessingRateInitialFunction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFunction <em>Processing Rate Operating Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Processing Rate Operating Function</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost#getProcessingRateOperatingFunction()
	 * @see #getVariableProcessingResourceCost()
	 * @generated
	 */
	EReference getVariableProcessingResourceCost_ProcessingRateOperatingFunction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.ScalarFunction <em>Scalar Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Function</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ScalarFunction
	 * @generated
	 */
	EClass getScalarFunction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.ScalarFunction#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ScalarFunction#getSpecification()
	 * @see #getScalarFunction()
	 * @generated
	 */
	EAttribute getScalarFunction_Specification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.ScalarFunction#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Term</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ScalarFunction#getTerm()
	 * @see #getScalarFunction()
	 * @generated
	 */
	EReference getScalarFunction_Term();

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
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getTimePeriodYears <em>Time Period Years</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Period Years</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.CostRepository#getTimePeriodYears()
	 * @see #getCostRepository()
	 * @generated
	 */
	EAttribute getCostRepository_TimePeriodYears();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.cost.CostRepository#getInterest <em>Interest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interest</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.CostRepository#getInterest()
	 * @see #getCostRepository()
	 * @generated
	 */
	EAttribute getCostRepository_Interest();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance <em>Component Cost Per Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Cost Per Instance</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance
	 * @generated
	 */
	EClass getComponentCostPerInstance();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance#getAllocation <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocation</em>'.
	 * @see de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance#getAllocation()
	 * @see #getComponentCostPerInstance()
	 * @generated
	 */
	EReference getComponentCostPerInstance_Allocation();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.LinkingResourceCostImpl <em>Linking Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.LinkingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getLinkingResourceCost()
		 * @generated
		 */
		EClass LINKING_RESOURCE_COST = eINSTANCE.getLinkingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Linkingresource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKING_RESOURCE_COST__LINKINGRESOURCE = eINSTANCE.getLinkingResourceCost_Linkingresource();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ProcessingResourceCostImpl <em>Processing Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.ProcessingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getProcessingResourceCost()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE_COST = eINSTANCE.getProcessingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Processingresourcespecification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION = eINSTANCE.getProcessingResourceCost_Processingresourcespecification();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl <em>Variable Processing Resource Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getVariableProcessingResourceCost()
		 * @generated
		 */
		EClass VARIABLE_PROCESSING_RESOURCE_COST = eINSTANCE.getVariableProcessingResourceCost();

		/**
		 * The meta object literal for the '<em><b>Processing Rate Initial Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION = eINSTANCE.getVariableProcessingResourceCost_ProcessingRateInitialFunction();

		/**
		 * The meta object literal for the '<em><b>Processing Rate Operating Function</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION = eINSTANCE.getVariableProcessingResourceCost_ProcessingRateOperatingFunction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ScalarFunctionImpl <em>Scalar Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.ScalarFunctionImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getScalarFunction()
		 * @generated
		 */
		EClass SCALAR_FUNCTION = eINSTANCE.getScalarFunction();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALAR_FUNCTION__SPECIFICATION = eINSTANCE.getScalarFunction_Specification();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALAR_FUNCTION__TERM = eINSTANCE.getScalarFunction_Term();

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

		/**
		 * The meta object literal for the '<em><b>Time Period Years</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COST_REPOSITORY__TIME_PERIOD_YEARS = eINSTANCE.getCostRepository_TimePeriodYears();

		/**
		 * The meta object literal for the '<em><b>Interest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COST_REPOSITORY__INTEREST = eINSTANCE.getCostRepository_Interest();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostPerInstanceImpl <em>Component Cost Per Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.cost.impl.ComponentCostPerInstanceImpl
		 * @see de.uka.ipd.sdq.pcm.cost.impl.costPackageImpl#getComponentCostPerInstance()
		 * @generated
		 */
		EClass COMPONENT_COST_PER_INSTANCE = eINSTANCE.getComponentCostPerInstance();

		/**
		 * The meta object literal for the '<em><b>Allocation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_COST_PER_INSTANCE__ALLOCATION = eINSTANCE.getComponentCostPerInstance_Allocation();

	}

} //costPackage
