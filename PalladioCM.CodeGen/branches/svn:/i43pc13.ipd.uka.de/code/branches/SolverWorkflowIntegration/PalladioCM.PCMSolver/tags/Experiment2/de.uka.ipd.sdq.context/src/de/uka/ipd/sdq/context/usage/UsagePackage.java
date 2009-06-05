/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage;

import de.uka.ipd.sdq.stoex.StoexPackage;

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
 * @see de.uka.ipd.sdq.context.usage.UsageFactory
 * @model kind="package"
 * @generated
 */
public interface UsagePackage extends EPackage {
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
	String eNAME = "usage";

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
	String eNS_PREFIX = "context.usage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsagePackage eINSTANCE = de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.usage.impl.UsageContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.usage.impl.UsageContextImpl
	 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getUsageContext()
	 * @generated
	 */
	int USAGE_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Branchprobabilities Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Loopiterations Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Actual Parameter Usage Usage Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT = 2;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_CONTEXT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.usage.impl.BranchProbabilityImpl <em>Branch Probability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.usage.impl.BranchProbabilityImpl
	 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getBranchProbability()
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
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl <em>Loop Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl
	 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getLoopIteration()
	 * @generated
	 */
	int LOOP_ITERATION = 2;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ITERATION__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Loopaction Loop Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ITERATION__LOOPACTION_LOOP_ITERATION = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ITERATION_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.usage.impl.UsageImpl <em>Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.usage.impl.UsageImpl
	 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getUsage()
	 * @generated
	 */
	int USAGE = 3;

	/**
	 * The feature id for the '<em><b>Usage Contexts Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE__USAGE_CONTEXTS_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.usage.UsageContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see de.uka.ipd.sdq.context.usage.UsageContext
	 * @generated
	 */
	EClass getUsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.usage.UsageContext#getBranchprobabilities_UsageContext <em>Branchprobabilities Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branchprobabilities Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.usage.UsageContext#getBranchprobabilities_UsageContext()
	 * @see #getUsageContext()
	 * @generated
	 */
	EReference getUsageContext_Branchprobabilities_UsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.usage.UsageContext#getLoopiterations_UsageContext <em>Loopiterations Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Loopiterations Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.usage.UsageContext#getLoopiterations_UsageContext()
	 * @see #getUsageContext()
	 * @generated
	 */
	EReference getUsageContext_Loopiterations_UsageContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.usage.UsageContext#getActualParameterUsage_UsageContext <em>Actual Parameter Usage Usage Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actual Parameter Usage Usage Context</em>'.
	 * @see de.uka.ipd.sdq.context.usage.UsageContext#getActualParameterUsage_UsageContext()
	 * @see #getUsageContext()
	 * @generated
	 */
	EReference getUsageContext_ActualParameterUsage_UsageContext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.usage.BranchProbability <em>Branch Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Probability</em>'.
	 * @see de.uka.ipd.sdq.context.usage.BranchProbability
	 * @generated
	 */
	EClass getBranchProbability();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.context.usage.BranchProbability#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.context.usage.BranchProbability#getProbability()
	 * @see #getBranchProbability()
	 * @generated
	 */
	EAttribute getBranchProbability_Probability();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.usage.BranchProbability#getBranchtransition_BranchProbability <em>Branchtransition Branch Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Branchtransition Branch Probability</em>'.
	 * @see de.uka.ipd.sdq.context.usage.BranchProbability#getBranchtransition_BranchProbability()
	 * @see #getBranchProbability()
	 * @generated
	 */
	EReference getBranchProbability_Branchtransition_BranchProbability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.usage.LoopIteration <em>Loop Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Iteration</em>'.
	 * @see de.uka.ipd.sdq.context.usage.LoopIteration
	 * @generated
	 */
	EClass getLoopIteration();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.usage.LoopIteration#getLoopaction_LoopIteration <em>Loopaction Loop Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loopaction Loop Iteration</em>'.
	 * @see de.uka.ipd.sdq.context.usage.LoopIteration#getLoopaction_LoopIteration()
	 * @see #getLoopIteration()
	 * @generated
	 */
	EReference getLoopIteration_Loopaction_LoopIteration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.usage.Usage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usage</em>'.
	 * @see de.uka.ipd.sdq.context.usage.Usage
	 * @generated
	 */
	EClass getUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.usage.Usage#getUsageContexts_Usage <em>Usage Contexts Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usage Contexts Usage</em>'.
	 * @see de.uka.ipd.sdq.context.usage.Usage#getUsageContexts_Usage()
	 * @see #getUsage()
	 * @generated
	 */
	EReference getUsage_UsageContexts_Usage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsageFactory getUsageFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.usage.impl.UsageContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.usage.impl.UsageContextImpl
		 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getUsageContext()
		 * @generated
		 */
		EClass USAGE_CONTEXT = eINSTANCE.getUsageContext();

		/**
		 * The meta object literal for the '<em><b>Branchprobabilities Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT = eINSTANCE.getUsageContext_Branchprobabilities_UsageContext();

		/**
		 * The meta object literal for the '<em><b>Loopiterations Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT = eINSTANCE.getUsageContext_Loopiterations_UsageContext();

		/**
		 * The meta object literal for the '<em><b>Actual Parameter Usage Usage Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT = eINSTANCE.getUsageContext_ActualParameterUsage_UsageContext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.usage.impl.BranchProbabilityImpl <em>Branch Probability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.usage.impl.BranchProbabilityImpl
		 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getBranchProbability()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl <em>Loop Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.usage.impl.LoopIterationImpl
		 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getLoopIteration()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.usage.impl.UsageImpl <em>Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.usage.impl.UsageImpl
		 * @see de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl#getUsage()
		 * @generated
		 */
		EClass USAGE = eINSTANCE.getUsage();

		/**
		 * The meta object literal for the '<em><b>Usage Contexts Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USAGE__USAGE_CONTEXTS_USAGE = eINSTANCE.getUsage_UsageContexts_Usage();

	}

} //UsagePackage
