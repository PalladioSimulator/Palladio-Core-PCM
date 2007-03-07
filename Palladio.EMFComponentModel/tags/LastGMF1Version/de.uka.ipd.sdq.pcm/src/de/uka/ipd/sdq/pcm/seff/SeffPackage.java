/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * <!-- begin-model-doc -->
 * self.branches_Branch->forAll(bt|bt.oclIsTypeOf(ProbabilisticBranchTransition) or self.branches_Branch->forAll(bt|bt.oclIsTypeOf(GuardedBranchTransition)
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.SeffFactory
 * @model kind="package"
 * @generated
 */
public interface SeffPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "seff";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.seff";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SeffPackage eINSTANCE = de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractAction()
	 * @generated
	 */
	int ABSTRACT_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractResourceDemandingActionImpl <em>Abstract Resource Demanding Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractResourceDemandingActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractResourceDemandingAction()
	 * @generated
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION__ID = ABSTRACT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME = ABSTRACT_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Resource Demanding Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.StopActionImpl <em>Stop Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.StopActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getStopAction()
	 * @generated
	 */
	int STOP_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The number of structural features of the '<em>Stop Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ParametricResourceDemandImpl <em>Parametric Resource Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ParametricResourceDemandImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getParametricResourceDemand()
	 * @generated
	 */
	int PARAMETRIC_RESOURCE_DEMAND = 3;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__UNIT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Action Parametric Resource Demand</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parametric Resource Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.StartActionImpl <em>Start Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.StartActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getStartAction()
	 * @generated
	 */
	int START_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The number of structural features of the '<em>Start Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl <em>Service Effect Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getServiceEffectSpecification()
	 * @generated
	 */
	int SERVICE_EFFECT_SPECIFICATION = 22;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl <em>Resource Demanding SEFF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getResourceDemandingSEFF()
	 * @generated
	 */
	int RESOURCE_DEMANDING_SEFF = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_SEFF__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Seff Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Described Service SEFF</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Steps Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource Demanding SEFF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_SEFF_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl <em>Resource Demanding Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getResourceDemandingBehaviour()
	 * @generated
	 */
	int RESOURCE_DEMANDING_BEHAVIOUR = 6;

	/**
	 * The feature id for the '<em><b>Steps Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR = 0;

	/**
	 * The number of structural features of the '<em>Resource Demanding Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEMANDING_BEHAVIOUR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ReleaseActionImpl <em>Release Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ReleaseActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getReleaseAction()
	 * @generated
	 */
	int RELEASE_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Type Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__RESOURCE_TYPE_RELEASE = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Release Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractLoopActionImpl <em>Abstract Loop Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractLoopActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractLoopAction()
	 * @generated
	 */
	int ABSTRACT_LOOP_ACTION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Loop Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOOP_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl <em>Loop Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getLoopAction()
	 * @generated
	 */
	int LOOP_ACTION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__ID = ABSTRACT_LOOP_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__ENTITY_NAME = ABSTRACT_LOOP_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_LOOP_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_LOOP_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_LOOP_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__BODY_BEHAVIOUR_LOOP = ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP;

	/**
	 * The feature id for the '<em><b>Iterations Loop Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__ITERATIONS_LOOP_ACTION = ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION_FEATURE_COUNT = ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.IterationCountImpl <em>Iteration Count</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.IterationCountImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getIterationCount()
	 * @generated
	 */
	int ITERATION_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_COUNT__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Iteration Count</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_COUNT_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl <em>Internal Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getInternalAction()
	 * @generated
	 */
	int INTERNAL_ACTION = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION__FAILURE_PROBABILITY = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Internal Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl <em>Fork Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getForkAction()
	 * @generated
	 */
	int FORK_ACTION = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Forked Behaviours Fork</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__FORKED_BEHAVIOURS_FORK = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fork Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl <em>External Call Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getExternalCallAction()
	 * @generated
	 */
	int EXTERNAL_CALL_ACTION = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__ID = ABSTRACT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__ENTITY_NAME = ABSTRACT_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Called Service External Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Usage External Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION = ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Variable Usage External Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION = ABSTRACT_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>External Call Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl <em>Abstract Branch Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractBranchTransition()
	 * @generated
	 */
	int ABSTRACT_BRANCH_TRANSITION = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BRANCH_TRANSITION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Branch Behaviour Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Branch Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BRANCH_TRANSITION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ProbabilisticBranchTransitionImpl <em>Probabilistic Branch Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ProbabilisticBranchTransitionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getProbabilisticBranchTransition()
	 * @generated
	 */
	int PROBABILISTIC_BRANCH_TRANSITION = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_BRANCH_TRANSITION__ID = ABSTRACT_BRANCH_TRANSITION__ID;

	/**
	 * The feature id for the '<em><b>Branch Behaviour Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION = ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION;

	/**
	 * The feature id for the '<em><b>Branch Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_BRANCH_TRANSITION__BRANCH_PROBABILITY = ABSTRACT_BRANCH_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Probabilistic Branch Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_BRANCH_TRANSITION_FEATURE_COUNT = ABSTRACT_BRANCH_TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.BranchConditionImpl <em>Branch Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.BranchConditionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getBranchCondition()
	 * @generated
	 */
	int BRANCH_CONDITION = 18;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl <em>Branch Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getBranchAction()
	 * @generated
	 */
	int BRANCH_ACTION = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Branches Branch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION__BRANCHES_BRANCH = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Branch Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AquireActionImpl <em>Aquire Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AquireActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAquireAction()
	 * @generated
	 */
	int AQUIRE_ACTION = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Type Aquire</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aquire Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUIRE_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_CONDITION__SPECIFICATION = StoexPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Branch Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_CONDITION_FEATURE_COUNT = StoexPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.CollectionIteratorActionImpl <em>Collection Iterator Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.CollectionIteratorActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getCollectionIteratorAction()
	 * @generated
	 */
	int COLLECTION_ITERATOR_ACTION = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__ID = ABSTRACT_LOOP_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__ENTITY_NAME = ABSTRACT_LOOP_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_LOOP_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_LOOP_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_LOOP_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__BODY_BEHAVIOUR_LOOP = ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP;

	/**
	 * The feature id for the '<em><b>Parameter Collection Iterator Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION = ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Iterator Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITERATOR_ACTION_FEATURE_COUNT = ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.GuardedBranchTransitionImpl <em>Guarded Branch Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.GuardedBranchTransitionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getGuardedBranchTransition()
	 * @generated
	 */
	int GUARDED_BRANCH_TRANSITION = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_BRANCH_TRANSITION__ID = ABSTRACT_BRANCH_TRANSITION__ID;

	/**
	 * The feature id for the '<em><b>Branch Behaviour Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION = ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION;

	/**
	 * The feature id for the '<em><b>Branch Condition Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION = ABSTRACT_BRANCH_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guarded Branch Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_BRANCH_TRANSITION_FEATURE_COUNT = ABSTRACT_BRANCH_TRANSITION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.SetVariableActionImpl <em>Set Variable Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SetVariableActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getSetVariableAction()
	 * @generated
	 */
	int SET_VARIABLE_ACTION = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Variable Usage Set Variable Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Variable Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Seff Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID = 0;

	/**
	 * The feature id for the '<em><b>Described Service SEFF</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF = 1;

	/**
	 * The number of structural features of the '<em>Service Effect Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EFFECT_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.StopAction <em>Stop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.StopAction
	 * @generated
	 */
	EClass getStopAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction <em>Abstract Resource Demanding Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource Demanding Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction
	 * @generated
	 */
	EClass getAbstractResourceDemandingAction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction#getResourceDemand_Action <em>Resource Demand Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Demand Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction#getResourceDemand_Action()
	 * @see #getAbstractResourceDemandingAction()
	 * @generated
	 */
	EReference getAbstractResourceDemandingAction_ResourceDemand_Action();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction
	 * @generated
	 */
	EClass getAbstractAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor Abstract Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Predecessor_AbstractAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor Abstract Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Successor_AbstractAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand <em>Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand
	 * @generated
	 */
	EClass getParametricResourceDemand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getUnit()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EAttribute getParametricResourceDemand_Unit();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand <em>Required Resource Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Resource Parametric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getRequiredResource_ParametricResourceDemand()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EReference getParametricResourceDemand_RequiredResource_ParametricResourceDemand();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Action Parametric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getAction_ParametricResourceDemand()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EReference getParametricResourceDemand_Action_ParametricResourceDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.StartAction <em>Start Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.StartAction
	 * @generated
	 */
	EClass getStartAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF <em>Resource Demanding SEFF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Demanding SEFF</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
	 * @generated
	 */
	EClass getResourceDemandingSEFF();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Demanding Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour
	 * @generated
	 */
	EClass getResourceDemandingBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getSteps_Behaviour <em>Steps Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getSteps_Behaviour()
	 * @see #getResourceDemandingBehaviour()
	 * @generated
	 */
	EReference getResourceDemandingBehaviour_Steps_Behaviour();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction <em>Release Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ReleaseAction
	 * @generated
	 */
	EClass getReleaseAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction#getResourceType_Release <em>Resource Type Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Type Release</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ReleaseAction#getResourceType_Release()
	 * @see #getReleaseAction()
	 * @generated
	 */
	EReference getReleaseAction_ResourceType_Release();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.LoopAction <em>Loop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.LoopAction
	 * @generated
	 */
	EClass getLoopAction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations_LoopAction <em>Iterations Loop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterations Loop Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations_LoopAction()
	 * @see #getLoopAction()
	 * @generated
	 */
	EReference getLoopAction_Iterations_LoopAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.AbstractLoopAction <em>Abstract Loop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Loop Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractLoopAction
	 * @generated
	 */
	EClass getAbstractLoopAction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.AbstractLoopAction#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body Behaviour Loop</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractLoopAction#getBodyBehaviour_Loop()
	 * @see #getAbstractLoopAction()
	 * @generated
	 */
	EReference getAbstractLoopAction_BodyBehaviour_Loop();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.IterationCount <em>Iteration Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Count</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.IterationCount
	 * @generated
	 */
	EClass getIterationCount();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.InternalAction <em>Internal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.InternalAction
	 * @generated
	 */
	EClass getInternalAction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.seff.InternalAction#getFailureProbability <em>Failure Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.InternalAction#getFailureProbability()
	 * @see #getInternalAction()
	 * @generated
	 */
	EAttribute getInternalAction_FailureProbability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ForkAction <em>Fork Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ForkAction
	 * @generated
	 */
	EClass getForkAction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getForkedBehaviours_Fork <em>Forked Behaviours Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forked Behaviours Fork</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ForkAction#getForkedBehaviours_Fork()
	 * @see #getForkAction()
	 * @generated
	 */
	EReference getForkAction_ForkedBehaviours_Fork();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction <em>External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction
	 * @generated
	 */
	EClass getExternalCallAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getCalledService_ExternalService <em>Called Service External Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Service External Service</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getCalledService_ExternalService()
	 * @see #getExternalCallAction()
	 * @generated
	 */
	EReference getExternalCallAction_CalledService_ExternalService();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getParameterUsage_ExternalCallAction <em>Parameter Usage External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Usage External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getParameterUsage_ExternalCallAction()
	 * @see #getExternalCallAction()
	 * @generated
	 */
	EReference getExternalCallAction_ParameterUsage_ExternalCallAction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getOutputVariableUsage_ExternalCallAction <em>Output Variable Usage External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Variable Usage External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getOutputVariableUsage_ExternalCallAction()
	 * @see #getExternalCallAction()
	 * @generated
	 */
	EReference getExternalCallAction_OutputVariableUsage_ExternalCallAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition <em>Probabilistic Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probabilistic Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
	 * @generated
	 */
	EClass getProbabilisticBranchTransition();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition#getBranchProbability <em>Branch Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Branch Probability</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition#getBranchProbability()
	 * @see #getProbabilisticBranchTransition()
	 * @generated
	 */
	EAttribute getProbabilisticBranchTransition_BranchProbability();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition <em>Abstract Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition
	 * @generated
	 */
	EClass getAbstractBranchTransition();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition#getBranchBehaviour_BranchTransition <em>Branch Behaviour Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Branch Behaviour Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition#getBranchBehaviour_BranchTransition()
	 * @see #getAbstractBranchTransition()
	 * @generated
	 */
	EReference getAbstractBranchTransition_BranchBehaviour_BranchTransition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.BranchCondition <em>Branch Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Condition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.BranchCondition
	 * @generated
	 */
	EClass getBranchCondition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.BranchAction <em>Branch Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.BranchAction
	 * @generated
	 */
	EClass getBranchAction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.BranchAction#getBranches_Branch <em>Branches Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branches Branch</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.BranchAction#getBranches_Branch()
	 * @see #getBranchAction()
	 * @generated
	 */
	EReference getBranchAction_Branches_Branch();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.AquireAction <em>Aquire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aquire Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AquireAction
	 * @generated
	 */
	EClass getAquireAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.AquireAction#getResourceType_Aquire <em>Resource Type Aquire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Type Aquire</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AquireAction#getResourceType_Aquire()
	 * @see #getAquireAction()
	 * @generated
	 */
	EReference getAquireAction_ResourceType_Aquire();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction <em>Collection Iterator Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Iterator Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
	 * @generated
	 */
	EClass getCollectionIteratorAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction#getParameter_CollectionIteratorAction <em>Parameter Collection Iterator Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Collection Iterator Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction#getParameter_CollectionIteratorAction()
	 * @see #getCollectionIteratorAction()
	 * @generated
	 */
	EReference getCollectionIteratorAction_Parameter_CollectionIteratorAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition <em>Guarded Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guarded Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
	 * @generated
	 */
	EClass getGuardedBranchTransition();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_BranchTransition <em>Branch Condition Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Branch Condition Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_BranchTransition()
	 * @see #getGuardedBranchTransition()
	 * @generated
	 */
	EReference getGuardedBranchTransition_BranchCondition_BranchTransition();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction <em>Set Variable Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Variable Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction
	 * @generated
	 */
	EClass getSetVariableAction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction#getVariableUsage_SetVariableAction <em>Variable Usage Set Variable Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Usage Set Variable Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction#getVariableUsage_SetVariableAction()
	 * @see #getSetVariableAction()
	 * @generated
	 */
	EReference getSetVariableAction_VariableUsage_SetVariableAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification <em>Service Effect Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Effect Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification
	 * @generated
	 */
	EClass getServiceEffectSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getSeffTypeID <em>Seff Type ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seff Type ID</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getSeffTypeID()
	 * @see #getServiceEffectSpecification()
	 * @generated
	 */
	EAttribute getServiceEffectSpecification_SeffTypeID();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getDescribedService__SEFF <em>Described Service SEFF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Described Service SEFF</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getDescribedService__SEFF()
	 * @see #getServiceEffectSpecification()
	 * @generated
	 */
	EReference getServiceEffectSpecification_DescribedService__SEFF();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SeffFactory getSeffFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.StopActionImpl <em>Stop Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.StopActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getStopAction()
		 * @generated
		 */
		EClass STOP_ACTION = eINSTANCE.getStopAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractResourceDemandingActionImpl <em>Abstract Resource Demanding Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractResourceDemandingActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractResourceDemandingAction()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE_DEMANDING_ACTION = eINSTANCE.getAbstractResourceDemandingAction();

		/**
		 * The meta object literal for the '<em><b>Resource Demand Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION = eINSTANCE.getAbstractResourceDemandingAction_ResourceDemand_Action();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractAction()
		 * @generated
		 */
		EClass ABSTRACT_ACTION = eINSTANCE.getAbstractAction();

		/**
		 * The meta object literal for the '<em><b>Predecessor Abstract Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION = eINSTANCE.getAbstractAction_Predecessor_AbstractAction();

		/**
		 * The meta object literal for the '<em><b>Successor Abstract Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION = eINSTANCE.getAbstractAction_Successor_AbstractAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ParametricResourceDemandImpl <em>Parametric Resource Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ParametricResourceDemandImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getParametricResourceDemand()
		 * @generated
		 */
		EClass PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETRIC_RESOURCE_DEMAND__UNIT = eINSTANCE.getParametricResourceDemand_Unit();

		/**
		 * The meta object literal for the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_RequiredResource_ParametricResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Action Parametric Resource Demand</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_Action_ParametricResourceDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.StartActionImpl <em>Start Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.StartActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getStartAction()
		 * @generated
		 */
		EClass START_ACTION = eINSTANCE.getStartAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl <em>Resource Demanding SEFF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getResourceDemandingSEFF()
		 * @generated
		 */
		EClass RESOURCE_DEMANDING_SEFF = eINSTANCE.getResourceDemandingSEFF();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl <em>Resource Demanding Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getResourceDemandingBehaviour()
		 * @generated
		 */
		EClass RESOURCE_DEMANDING_BEHAVIOUR = eINSTANCE.getResourceDemandingBehaviour();

		/**
		 * The meta object literal for the '<em><b>Steps Behaviour</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR = eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ReleaseActionImpl <em>Release Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ReleaseActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getReleaseAction()
		 * @generated
		 */
		EClass RELEASE_ACTION = eINSTANCE.getReleaseAction();

		/**
		 * The meta object literal for the '<em><b>Resource Type Release</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE_ACTION__RESOURCE_TYPE_RELEASE = eINSTANCE.getReleaseAction_ResourceType_Release();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl <em>Loop Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.LoopActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getLoopAction()
		 * @generated
		 */
		EClass LOOP_ACTION = eINSTANCE.getLoopAction();

		/**
		 * The meta object literal for the '<em><b>Iterations Loop Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_ACTION__ITERATIONS_LOOP_ACTION = eINSTANCE.getLoopAction_Iterations_LoopAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractLoopActionImpl <em>Abstract Loop Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractLoopActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractLoopAction()
		 * @generated
		 */
		EClass ABSTRACT_LOOP_ACTION = eINSTANCE.getAbstractLoopAction();

		/**
		 * The meta object literal for the '<em><b>Body Behaviour Loop</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP = eINSTANCE.getAbstractLoopAction_BodyBehaviour_Loop();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.IterationCountImpl <em>Iteration Count</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.IterationCountImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getIterationCount()
		 * @generated
		 */
		EClass ITERATION_COUNT = eINSTANCE.getIterationCount();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl <em>Internal Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getInternalAction()
		 * @generated
		 */
		EClass INTERNAL_ACTION = eINSTANCE.getInternalAction();

		/**
		 * The meta object literal for the '<em><b>Failure Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_ACTION__FAILURE_PROBABILITY = eINSTANCE.getInternalAction_FailureProbability();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl <em>Fork Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ForkActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getForkAction()
		 * @generated
		 */
		EClass FORK_ACTION = eINSTANCE.getForkAction();

		/**
		 * The meta object literal for the '<em><b>Forked Behaviours Fork</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK_ACTION__FORKED_BEHAVIOURS_FORK = eINSTANCE.getForkAction_ForkedBehaviours_Fork();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl <em>External Call Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getExternalCallAction()
		 * @generated
		 */
		EClass EXTERNAL_CALL_ACTION = eINSTANCE.getExternalCallAction();

		/**
		 * The meta object literal for the '<em><b>Called Service External Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE = eINSTANCE.getExternalCallAction_CalledService_ExternalService();

		/**
		 * The meta object literal for the '<em><b>Parameter Usage External Call Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION = eINSTANCE.getExternalCallAction_ParameterUsage_ExternalCallAction();

		/**
		 * The meta object literal for the '<em><b>Output Variable Usage External Call Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION = eINSTANCE.getExternalCallAction_OutputVariableUsage_ExternalCallAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ProbabilisticBranchTransitionImpl <em>Probabilistic Branch Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ProbabilisticBranchTransitionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getProbabilisticBranchTransition()
		 * @generated
		 */
		EClass PROBABILISTIC_BRANCH_TRANSITION = eINSTANCE.getProbabilisticBranchTransition();

		/**
		 * The meta object literal for the '<em><b>Branch Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBABILISTIC_BRANCH_TRANSITION__BRANCH_PROBABILITY = eINSTANCE.getProbabilisticBranchTransition_BranchProbability();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl <em>Abstract Branch Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractBranchTransition()
		 * @generated
		 */
		EClass ABSTRACT_BRANCH_TRANSITION = eINSTANCE.getAbstractBranchTransition();

		/**
		 * The meta object literal for the '<em><b>Branch Behaviour Branch Transition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION = eINSTANCE.getAbstractBranchTransition_BranchBehaviour_BranchTransition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.BranchConditionImpl <em>Branch Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.BranchConditionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getBranchCondition()
		 * @generated
		 */
		EClass BRANCH_CONDITION = eINSTANCE.getBranchCondition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl <em>Branch Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getBranchAction()
		 * @generated
		 */
		EClass BRANCH_ACTION = eINSTANCE.getBranchAction();

		/**
		 * The meta object literal for the '<em><b>Branches Branch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_ACTION__BRANCHES_BRANCH = eINSTANCE.getBranchAction_Branches_Branch();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AquireActionImpl <em>Aquire Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.AquireActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAquireAction()
		 * @generated
		 */
		EClass AQUIRE_ACTION = eINSTANCE.getAquireAction();

		/**
		 * The meta object literal for the '<em><b>Resource Type Aquire</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AQUIRE_ACTION__RESOURCE_TYPE_AQUIRE = eINSTANCE.getAquireAction_ResourceType_Aquire();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.CollectionIteratorActionImpl <em>Collection Iterator Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.CollectionIteratorActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getCollectionIteratorAction()
		 * @generated
		 */
		EClass COLLECTION_ITERATOR_ACTION = eINSTANCE.getCollectionIteratorAction();

		/**
		 * The meta object literal for the '<em><b>Parameter Collection Iterator Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_ITERATOR_ACTION__PARAMETER_COLLECTION_ITERATOR_ACTION = eINSTANCE.getCollectionIteratorAction_Parameter_CollectionIteratorAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.GuardedBranchTransitionImpl <em>Guarded Branch Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.GuardedBranchTransitionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getGuardedBranchTransition()
		 * @generated
		 */
		EClass GUARDED_BRANCH_TRANSITION = eINSTANCE.getGuardedBranchTransition();

		/**
		 * The meta object literal for the '<em><b>Branch Condition Branch Transition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_BRANCH_TRANSITION = eINSTANCE.getGuardedBranchTransition_BranchCondition_BranchTransition();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.SetVariableActionImpl <em>Set Variable Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SetVariableActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getSetVariableAction()
		 * @generated
		 */
		EClass SET_VARIABLE_ACTION = eINSTANCE.getSetVariableAction();

		/**
		 * The meta object literal for the '<em><b>Variable Usage Set Variable Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE_ACTION__VARIABLE_USAGE_SET_VARIABLE_ACTION = eINSTANCE.getSetVariableAction_VariableUsage_SetVariableAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl <em>Service Effect Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getServiceEffectSpecification()
		 * @generated
		 */
		EClass SERVICE_EFFECT_SPECIFICATION = eINSTANCE.getServiceEffectSpecification();

		/**
		 * The meta object literal for the '<em><b>Seff Type ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID = eINSTANCE.getServiceEffectSpecification_SeffTypeID();

		/**
		 * The meta object literal for the '<em><b>Described Service SEFF</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF = eINSTANCE.getServiceEffectSpecification_DescribedService__SEFF();

	}

} //SeffPackage
