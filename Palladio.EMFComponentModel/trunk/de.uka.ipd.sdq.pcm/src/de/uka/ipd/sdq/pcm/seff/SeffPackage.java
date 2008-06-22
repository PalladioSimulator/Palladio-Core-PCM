/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
	String eNS_PREFIX = "";

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
	 * The feature id for the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND = 0;

	/**
	 * The feature id for the '<em><b>Specification Parameteric Resource Demand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Action Parametric Resource Demand</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND = 2;

	/**
	 * The number of structural features of the '<em>Parametric Resource Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_RESOURCE_DEMAND_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Passive Resource Release Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Iteration Count Loop Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION = ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ACTION_FEATURE_COUNT = ABSTRACT_LOOP_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl <em>Internal Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getInternalAction()
	 * @generated
	 */
	int INTERNAL_ACTION = 10;

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
	int FORK_ACTION = 11;

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
	 * The feature id for the '<em><b>Asynchronous Forked Behaviours Fork Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Synchronising Behaviours Fork Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fork Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl <em>Forked Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getForkedBehaviour()
	 * @generated
	 */
	int FORKED_BEHAVIOUR = 12;

	/**
	 * The feature id for the '<em><b>Steps Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORKED_BEHAVIOUR__STEPS_BEHAVIOUR = RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR;

	/**
	 * The number of structural features of the '<em>Forked Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORKED_BEHAVIOUR_FEATURE_COUNT = RESOURCE_DEMANDING_BEHAVIOUR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.SynchronisationPointImpl <em>Synchronisation Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SynchronisationPointImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getSynchronisationPoint()
	 * @generated
	 */
	int SYNCHRONISATION_POINT = 13;

	/**
	 * The feature id for the '<em><b>Synchronous Forked Behaviours Synchronisation Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT = 0;

	/**
	 * The feature id for the '<em><b>Output Parameter Usage Synchronisation Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT = 1;

	/**
	 * The number of structural features of the '<em>Synchronisation Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONISATION_POINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl <em>External Call Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getExternalCallAction()
	 * @generated
	 */
	int EXTERNAL_CALL_ACTION = 14;

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
	 * The feature id for the '<em><b>Input Parameter Usages External Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION = ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Variable Usages External Call Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION = ABSTRACT_ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Role External Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE = ABSTRACT_ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>External Call Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl <em>Abstract Branch Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AbstractBranchTransitionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAbstractBranchTransition()
	 * @generated
	 */
	int ABSTRACT_BRANCH_TRANSITION = 16;

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
	int PROBABILISTIC_BRANCH_TRANSITION = 15;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl <em>Branch Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getBranchAction()
	 * @generated
	 */
	int BRANCH_ACTION = 17;

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
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl <em>Acquire Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl
	 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAcquireAction()
	 * @generated
	 */
	int ACQUIRE_ACTION = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__ID = ABSTRACT_RESOURCE_DEMANDING_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__ENTITY_NAME = ABSTRACT_RESOURCE_DEMANDING_ACTION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__PREDECESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__PREDECESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Successor Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__SUCCESSOR_ABSTRACT_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__SUCCESSOR_ABSTRACT_ACTION;

	/**
	 * The feature id for the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__RESOURCE_DEMAND_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION__RESOURCE_DEMAND_ACTION;

	/**
	 * The feature id for the '<em><b>Passiveresource Acquire Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Acquire Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Branch Condition Guarded Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION = ABSTRACT_BRANCH_TRANSITION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Local Variable Usages Set Variable Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Variable Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_ACTION_FEATURE_COUNT = ABSTRACT_RESOURCE_DEMANDING_ACTION_FEATURE_COUNT + 1;

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
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getSpecification_ParametericResourceDemand <em>Specification Parameteric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specification Parameteric Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getSpecification_ParametericResourceDemand()
	 * @see #getParametricResourceDemand()
	 * @generated
	 */
	EReference getParametricResourceDemand_Specification_ParametericResourceDemand();

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
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction#getPassiveResource_ReleaseAction <em>Passive Resource Release Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Passive Resource Release Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ReleaseAction#getPassiveResource_ReleaseAction()
	 * @see #getReleaseAction()
	 * @generated
	 */
	EReference getReleaseAction_PassiveResource_ReleaseAction();

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
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterationCount_LoopAction <em>Iteration Count Loop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iteration Count Loop Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.LoopAction#getIterationCount_LoopAction()
	 * @see #getLoopAction()
	 * @generated
	 */
	EReference getLoopAction_IterationCount_LoopAction();

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getAsynchronousForkedBehaviours_ForkAction <em>Asynchronous Forked Behaviours Fork Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Asynchronous Forked Behaviours Fork Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ForkAction#getAsynchronousForkedBehaviours_ForkAction()
	 * @see #getForkAction()
	 * @generated
	 */
	EReference getForkAction_AsynchronousForkedBehaviours_ForkAction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getSynchronisingBehaviours_ForkAction <em>Synchronising Behaviours Fork Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Synchronising Behaviours Fork Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ForkAction#getSynchronisingBehaviours_ForkAction()
	 * @see #getForkAction()
	 * @generated
	 */
	EReference getForkAction_SynchronisingBehaviours_ForkAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour <em>Forked Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forked Behaviour</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ForkedBehaviour
	 * @generated
	 */
	EClass getForkedBehaviour();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint <em>Synchronisation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synchronisation Point</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint
	 * @generated
	 */
	EClass getSynchronisationPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getSynchronousForkedBehaviours_SynchronisationPoint <em>Synchronous Forked Behaviours Synchronisation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Synchronous Forked Behaviours Synchronisation Point</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getSynchronousForkedBehaviours_SynchronisationPoint()
	 * @see #getSynchronisationPoint()
	 * @generated
	 */
	EReference getSynchronisationPoint_SynchronousForkedBehaviours_SynchronisationPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint <em>Output Parameter Usage Synchronisation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Parameter Usage Synchronisation Point</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint()
	 * @see #getSynchronisationPoint()
	 * @generated
	 */
	EReference getSynchronisationPoint_OutputParameterUsage_SynchronisationPoint();

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getInputParameterUsages_ExternalCallAction <em>Input Parameter Usages External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Parameter Usages External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getInputParameterUsages_ExternalCallAction()
	 * @see #getExternalCallAction()
	 * @generated
	 */
	EReference getExternalCallAction_InputParameterUsages_ExternalCallAction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getOutputVariableUsages_ExternalCallAction <em>Output Variable Usages External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Variable Usages External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getOutputVariableUsages_ExternalCallAction()
	 * @see #getExternalCallAction()
	 * @generated
	 */
	EReference getExternalCallAction_OutputVariableUsages_ExternalCallAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRole_ExternalService <em>Role External Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role External Service</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRole_ExternalService()
	 * @see #getExternalCallAction()
	 * @generated
	 */
	EReference getExternalCallAction_Role_ExternalService();

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
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.seff.AcquireAction <em>Acquire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acquire Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AcquireAction
	 * @generated
	 */
	EClass getAcquireAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.seff.AcquireAction#getPassiveresource_AcquireAction <em>Passiveresource Acquire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Passiveresource Acquire Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.AcquireAction#getPassiveresource_AcquireAction()
	 * @see #getAcquireAction()
	 * @generated
	 */
	EReference getAcquireAction_Passiveresource_AcquireAction();

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
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_GuardedBranchTransition <em>Branch Condition Guarded Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Branch Condition Guarded Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_GuardedBranchTransition()
	 * @see #getGuardedBranchTransition()
	 * @generated
	 */
	EReference getGuardedBranchTransition_BranchCondition_GuardedBranchTransition();

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
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction <em>Local Variable Usages Set Variable Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Variable Usages Set Variable Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction#getLocalVariableUsages_SetVariableAction()
	 * @see #getSetVariableAction()
	 * @generated
	 */
	EReference getSetVariableAction_LocalVariableUsages_SetVariableAction();

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
	interface Literals {
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
		 * The meta object literal for the '<em><b>Required Resource Parametric Resource Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_RequiredResource_ParametricResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Specification Parameteric Resource Demand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND = eINSTANCE.getParametricResourceDemand_Specification_ParametericResourceDemand();

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
		 * The meta object literal for the '<em><b>Passive Resource Release Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE_ACTION__PASSIVE_RESOURCE_RELEASE_ACTION = eINSTANCE.getReleaseAction_PassiveResource_ReleaseAction();

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
		 * The meta object literal for the '<em><b>Iteration Count Loop Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_ACTION__ITERATION_COUNT_LOOP_ACTION = eINSTANCE.getLoopAction_IterationCount_LoopAction();

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
		 * The meta object literal for the '<em><b>Asynchronous Forked Behaviours Fork Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK_ACTION__ASYNCHRONOUS_FORKED_BEHAVIOURS_FORK_ACTION = eINSTANCE.getForkAction_AsynchronousForkedBehaviours_ForkAction();

		/**
		 * The meta object literal for the '<em><b>Synchronising Behaviours Fork Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK_ACTION__SYNCHRONISING_BEHAVIOURS_FORK_ACTION = eINSTANCE.getForkAction_SynchronisingBehaviours_ForkAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl <em>Forked Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.ForkedBehaviourImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getForkedBehaviour()
		 * @generated
		 */
		EClass FORKED_BEHAVIOUR = eINSTANCE.getForkedBehaviour();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.SynchronisationPointImpl <em>Synchronisation Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SynchronisationPointImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getSynchronisationPoint()
		 * @generated
		 */
		EClass SYNCHRONISATION_POINT = eINSTANCE.getSynchronisationPoint();

		/**
		 * The meta object literal for the '<em><b>Synchronous Forked Behaviours Synchronisation Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONISATION_POINT__SYNCHRONOUS_FORKED_BEHAVIOURS_SYNCHRONISATION_POINT = eINSTANCE.getSynchronisationPoint_SynchronousForkedBehaviours_SynchronisationPoint();

		/**
		 * The meta object literal for the '<em><b>Output Parameter Usage Synchronisation Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT = eINSTANCE.getSynchronisationPoint_OutputParameterUsage_SynchronisationPoint();

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
		 * The meta object literal for the '<em><b>Input Parameter Usages External Call Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION = eINSTANCE.getExternalCallAction_InputParameterUsages_ExternalCallAction();

		/**
		 * The meta object literal for the '<em><b>Output Variable Usages External Call Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION = eINSTANCE.getExternalCallAction_OutputVariableUsages_ExternalCallAction();

		/**
		 * The meta object literal for the '<em><b>Role External Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE = eINSTANCE.getExternalCallAction_Role_ExternalService();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl <em>Acquire Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.seff.impl.AcquireActionImpl
		 * @see de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl#getAcquireAction()
		 * @generated
		 */
		EClass ACQUIRE_ACTION = eINSTANCE.getAcquireAction();

		/**
		 * The meta object literal for the '<em><b>Passiveresource Acquire Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACQUIRE_ACTION__PASSIVERESOURCE_ACQUIRE_ACTION = eINSTANCE.getAcquireAction_Passiveresource_AcquireAction();

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
		 * The meta object literal for the '<em><b>Branch Condition Guarded Branch Transition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARDED_BRANCH_TRANSITION__BRANCH_CONDITION_GUARDED_BRANCH_TRANSITION = eINSTANCE.getGuardedBranchTransition_BranchCondition_GuardedBranchTransition();

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
		 * The meta object literal for the '<em><b>Local Variable Usages Set Variable Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION = eINSTANCE.getSetVariableAction_LocalVariableUsages_SetVariableAction();

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
