/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
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
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory
 * @model kind="package"
 * @generated
 */
public interface ComputedUsagePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "computed_usage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Context/Usage/1.0";

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
	ComputedUsagePackage eINSTANCE = de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getComputedUsageContext()
	 * @generated
	 */
	int COMPUTED_USAGE_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Branch Probabilities Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loopiterations Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assembly Context Computed Usage Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input Computed Usage Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>External Call Output Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>External Call Input Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Output Computed Usage Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.BranchProbabilityImpl <em>Branch Probability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.BranchProbabilityImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getBranchProbability()
	 * @generated
	 */
	int BRANCH_PROBABILITY = 1;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_PROBABILITY__PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Branchtransition Branch Probability</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY = 1;

	/**
	 * The number of structural features of the '<em>Branch Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_PROBABILITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.LoopIterationImpl <em>Loop Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.LoopIterationImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getLoopIteration()
	 * @generated
	 */
	int LOOP_ITERATION = 2;

	/**
	 * The feature id for the '<em><b>Loopaction Loop Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ITERATION__LOOPACTION_LOOP_ITERATION = 0;

	/**
	 * The feature id for the '<em><b>Specification Loop Iteration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION = 1;

	/**
	 * The number of structural features of the '<em>Loop Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ITERATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.InputImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 3;

	/**
	 * The feature id for the '<em><b>Parameter Chacterisations Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__PARAMETER_CHACTERISATIONS_INPUT = 0;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallOutputImpl <em>External Call Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallOutputImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getExternalCallOutput()
	 * @generated
	 */
	int EXTERNAL_CALL_OUTPUT = 4;

	/**
	 * The feature id for the '<em><b>Parameter Characterisations External Call Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT = 0;

	/**
	 * The feature id for the '<em><b>External Call Action External Call Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT = 1;

	/**
	 * The number of structural features of the '<em>External Call Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_OUTPUT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallInputImpl <em>External Call Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallInputImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getExternalCallInput()
	 * @generated
	 */
	int EXTERNAL_CALL_INPUT = 5;

	/**
	 * The feature id for the '<em><b>Parameter Characterisations External Call Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT = 0;

	/**
	 * The feature id for the '<em><b>External Call Action External Call Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT = 1;

	/**
	 * The feature id for the '<em><b>Computed Usage Context External Call Input</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_INPUT__COMPUTED_USAGE_CONTEXT_EXTERNAL_CALL_INPUT = 2;

	/**
	 * The number of structural features of the '<em>External Call Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_INPUT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.OutputImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 6;

	/**
	 * The feature id for the '<em><b>Parameter Characterisations Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT = 0;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl <em>Computed Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getComputedUsage()
	 * @generated
	 */
	int COMPUTED_USAGE = 7;

	/**
	 * The feature id for the '<em><b>Usage Contexts Computed Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Computed Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext
	 * @generated
	 */
	EClass getComputedUsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getBranchProbabilities_ComputedUsageContext <em>Branch Probabilities Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branch Probabilities Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getBranchProbabilities_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_BranchProbabilities_ComputedUsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getLoopiterations_ComputedUsageContext <em>Loopiterations Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Loopiterations Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getLoopiterations_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_Loopiterations_ComputedUsageContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getAssemblyContext_ComputedUsageContext <em>Assembly Context Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assembly Context Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getAssemblyContext_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_AssemblyContext_ComputedUsageContext();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getInput_ComputedUsageContext <em>Input Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getInput_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_Input_ComputedUsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallOutput_ComputedUsageContext <em>External Call Output Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>External Call Output Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallOutput_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_ExternalCallOutput_ComputedUsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallInput_ComputedUsageContext <em>External Call Input Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>External Call Input Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallInput_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_ExternalCallInput_ComputedUsageContext();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getOutput_ComputedUsageContext <em>Output Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getOutput_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_Output_ComputedUsageContext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability <em>Branch Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Probability</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.BranchProbability
	 * @generated
	 */
	EClass getBranchProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.BranchProbability#getProbability()
	 * @see #getBranchProbability()
	 * @generated
	 */
	EAttribute getBranchProbability_Probability();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.computed_usage.BranchProbability#getBranchtransition_BranchProbability <em>Branchtransition Branch Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Branchtransition Branch Probability</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.BranchProbability#getBranchtransition_BranchProbability()
	 * @see #getBranchProbability()
	 * @generated
	 */
	EReference getBranchProbability_Branchtransition_BranchProbability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration <em>Loop Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Iteration</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.LoopIteration
	 * @generated
	 */
	EClass getLoopIteration();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loopaction Loop Iteration</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.LoopIteration#getLoopaction_LoopIteration()
	 * @see #getLoopIteration()
	 * @generated
	 */
	EReference getLoopIteration_Loopaction_LoopIteration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.context.computed_usage.LoopIteration#getSpecification_LoopIteration <em>Specification Loop Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification Loop Iteration</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.LoopIteration#getSpecification_LoopIteration()
	 * @see #getLoopIteration()
	 * @generated
	 */
	EReference getLoopIteration_Specification_LoopIteration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.Input#getParameterChacterisations_Input <em>Parameter Chacterisations Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Chacterisations Input</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.Input#getParameterChacterisations_Input()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_ParameterChacterisations_Input();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput <em>External Call Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Call Output</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput
	 * @generated
	 */
	EClass getExternalCallOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getParameterCharacterisations_ExternalCallOutput <em>Parameter Characterisations External Call Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Characterisations External Call Output</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getParameterCharacterisations_ExternalCallOutput()
	 * @see #getExternalCallOutput()
	 * @generated
	 */
	EReference getExternalCallOutput_ParameterCharacterisations_ExternalCallOutput();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getExternalCallAction_ExternalCallOutput <em>External Call Action External Call Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>External Call Action External Call Output</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getExternalCallAction_ExternalCallOutput()
	 * @see #getExternalCallOutput()
	 * @generated
	 */
	EReference getExternalCallOutput_ExternalCallAction_ExternalCallOutput();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput <em>External Call Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Call Input</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallInput
	 * @generated
	 */
	EClass getExternalCallInput();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getParameterCharacterisations_ExternalCallInput <em>Parameter Characterisations External Call Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Characterisations External Call Input</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getParameterCharacterisations_ExternalCallInput()
	 * @see #getExternalCallInput()
	 * @generated
	 */
	EReference getExternalCallInput_ParameterCharacterisations_ExternalCallInput();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getExternalCallAction_ExternalCallInput <em>External Call Action External Call Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>External Call Action External Call Input</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getExternalCallAction_ExternalCallInput()
	 * @see #getExternalCallInput()
	 * @generated
	 */
	EReference getExternalCallInput_ExternalCallAction_ExternalCallInput();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getComputedUsageContext_ExternalCallInput <em>Computed Usage Context External Call Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Computed Usage Context External Call Input</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getComputedUsageContext_ExternalCallInput()
	 * @see #getExternalCallInput()
	 * @generated
	 */
	EReference getExternalCallInput_ComputedUsageContext_ExternalCallInput();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.Output#getParameterCharacterisations_Output <em>Parameter Characterisations Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Characterisations Output</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.Output#getParameterCharacterisations_Output()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_ParameterCharacterisations_Output();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsage <em>Computed Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computed Usage</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsage
	 * @generated
	 */
	EClass getComputedUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsage#getUsageContexts_ComputedUsage <em>Usage Contexts Computed Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usage Contexts Computed Usage</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsage#getUsageContexts_ComputedUsage()
	 * @see #getComputedUsage()
	 * @generated
	 */
	EReference getComputedUsage_UsageContexts_ComputedUsage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComputedUsageFactory getComputedUsageFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getComputedUsageContext()
		 * @generated
		 */
		EClass COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>Branch Probabilities Computed Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_BranchProbabilities_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>Loopiterations Computed Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_Loopiterations_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Computed Usage Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_AssemblyContext_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>Input Computed Usage Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_Input_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>External Call Output Computed Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_ExternalCallOutput_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>External Call Input Computed Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_ExternalCallInput_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>Output Computed Usage Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_Output_ComputedUsageContext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.BranchProbabilityImpl <em>Branch Probability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.BranchProbabilityImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getBranchProbability()
		 * @generated
		 */
		EClass BRANCH_PROBABILITY = eINSTANCE.getBranchProbability();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRANCH_PROBABILITY__PROBABILITY = eINSTANCE.getBranchProbability_Probability();

		/**
		 * The meta object literal for the '<em><b>Branchtransition Branch Probability</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY = eINSTANCE.getBranchProbability_Branchtransition_BranchProbability();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.LoopIterationImpl <em>Loop Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.LoopIterationImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getLoopIteration()
		 * @generated
		 */
		EClass LOOP_ITERATION = eINSTANCE.getLoopIteration();

		/**
		 * The meta object literal for the '<em><b>Loopaction Loop Iteration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_ITERATION__LOOPACTION_LOOP_ITERATION = eINSTANCE.getLoopIteration_Loopaction_LoopIteration();

		/**
		 * The meta object literal for the '<em><b>Specification Loop Iteration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION = eINSTANCE.getLoopIteration_Specification_LoopIteration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.InputImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Parameter Chacterisations Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__PARAMETER_CHACTERISATIONS_INPUT = eINSTANCE.getInput_ParameterChacterisations_Input();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallOutputImpl <em>External Call Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallOutputImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getExternalCallOutput()
		 * @generated
		 */
		EClass EXTERNAL_CALL_OUTPUT = eINSTANCE.getExternalCallOutput();

		/**
		 * The meta object literal for the '<em><b>Parameter Characterisations External Call Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT = eINSTANCE.getExternalCallOutput_ParameterCharacterisations_ExternalCallOutput();

		/**
		 * The meta object literal for the '<em><b>External Call Action External Call Output</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT = eINSTANCE.getExternalCallOutput_ExternalCallAction_ExternalCallOutput();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallInputImpl <em>External Call Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallInputImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getExternalCallInput()
		 * @generated
		 */
		EClass EXTERNAL_CALL_INPUT = eINSTANCE.getExternalCallInput();

		/**
		 * The meta object literal for the '<em><b>Parameter Characterisations External Call Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT = eINSTANCE.getExternalCallInput_ParameterCharacterisations_ExternalCallInput();

		/**
		 * The meta object literal for the '<em><b>External Call Action External Call Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT = eINSTANCE.getExternalCallInput_ExternalCallAction_ExternalCallInput();

		/**
		 * The meta object literal for the '<em><b>Computed Usage Context External Call Input</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_INPUT__COMPUTED_USAGE_CONTEXT_EXTERNAL_CALL_INPUT = eINSTANCE.getExternalCallInput_ComputedUsageContext_ExternalCallInput();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.OutputImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Parameter Characterisations Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT = eINSTANCE.getOutput_ParameterCharacterisations_Output();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl <em>Computed Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl
		 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getComputedUsage()
		 * @generated
		 */
		EClass COMPUTED_USAGE = eINSTANCE.getComputedUsage();

		/**
		 * The meta object literal for the '<em><b>Usage Contexts Computed Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE = eINSTANCE.getComputedUsage_UsageContexts_ComputedUsage();

	}

} //ComputedUsagePackage
