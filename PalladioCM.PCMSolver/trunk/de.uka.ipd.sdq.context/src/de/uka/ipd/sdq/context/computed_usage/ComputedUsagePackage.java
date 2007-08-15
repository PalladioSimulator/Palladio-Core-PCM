/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

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
	String eNS_PREFIX = "context.computed_usage";

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
	 * The feature id for the '<em><b>Branch Probabilities Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Loopiterations Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Parameter Usages Computed Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Assembly Context Computed Usage Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT = 3;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_USAGE_CONTEXT_FEATURE_COUNT = 4;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl <em>Computed Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl
	 * @see de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl#getComputedUsage()
	 * @generated
	 */
	int COMPUTED_USAGE = 3;

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getParameterUsages_ComputedUsageContext <em>Parameter Usages Computed Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Usages Computed Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getParameterUsages_ComputedUsageContext()
	 * @see #getComputedUsageContext()
	 * @generated
	 */
	EReference getComputedUsageContext_ParameterUsages_ComputedUsageContext();

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
		 * The meta object literal for the '<em><b>Parameter Usages Computed Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_ParameterUsages_ComputedUsageContext();

		/**
		 * The meta object literal for the '<em><b>Assembly Context Computed Usage Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT = eINSTANCE.getComputedUsageContext_AssemblyContext_ComputedUsageContext();

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
