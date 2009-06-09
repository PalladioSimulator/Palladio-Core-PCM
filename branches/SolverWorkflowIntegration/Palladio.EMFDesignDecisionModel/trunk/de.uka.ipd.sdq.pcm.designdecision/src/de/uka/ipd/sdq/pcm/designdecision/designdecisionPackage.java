/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

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
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory
 * @model kind="package"
 * @generated
 */
public interface designdecisionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "designdecision";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/DesignDecision/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "designdecision";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	designdecisionPackage eINSTANCE = de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DesignDecisionImpl <em>Design Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DesignDecisionImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDesignDecision()
	 * @generated
	 */
	int DESIGN_DECISION = 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION__DOMAIN = 0;

	/**
	 * The number of structural features of the '<em>Design Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DomainImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 1;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 2;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DESIGNDECISION = 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.RangeImpl <em>Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.RangeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getRange()
	 * @generated
	 */
	int RANGE = 3;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__UPPER_BOUND_INCLUDED = DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__LOWER_BOUND_INCLUDED = DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 4;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EquivalentComponentsImpl <em>Equivalent Components</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EquivalentComponentsImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEquivalentComponents()
	 * @generated
	 */
	int EQUIVALENT_COMPONENTS = 5;

	/**
	 * The feature id for the '<em><b>Repositorycomponent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT = ENUMERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Equivalent Components</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_COMPONENTS_FEATURE_COUNT = ENUMERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AvailableServersImpl <em>Available Servers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AvailableServersImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAvailableServers()
	 * @generated
	 */
	int AVAILABLE_SERVERS = 6;

	/**
	 * The feature id for the '<em><b>Resourcecontainer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_SERVERS__RESOURCECONTAINER = ENUMERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Available Servers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_SERVERS_FEATURE_COUNT = ENUMERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ComponentChoiceImpl <em>Component Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ComponentChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getComponentChoice()
	 * @generated
	 */
	int COMPONENT_CHOICE = 7;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CHOICE__DESIGNDECISION = CHOICE__DESIGNDECISION;

	/**
	 * The feature id for the '<em><b>Chosenrepositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationChoiceImpl <em>Allocation Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AllocationChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAllocationChoice()
	 * @generated
	 */
	int ALLOCATION_CHOICE = 8;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CHOICE__DESIGNDECISION = CHOICE__DESIGNDECISION;

	/**
	 * The feature id for the '<em><b>Chosenresourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Allocation Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateChoiceImpl <em>Processing Rate Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProcessingRateChoice()
	 * @generated
	 */
	int PROCESSING_RATE_CHOICE = 9;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_CHOICE__DESIGNDECISION = CHOICE__DESIGNDECISION;

	/**
	 * The feature id for the '<em><b>Chosen Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_CHOICE__CHOSEN_RATE = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Rate Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateDecisionImpl <em>Processing Rate Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateDecisionImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProcessingRateDecision()
	 * @generated
	 */
	int PROCESSING_RATE_DECISION = 10;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_DECISION__DOMAIN = DESIGN_DECISION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Processingresourcespecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION = DESIGN_DECISION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_DECISION__RESOURCECONTAINER = DESIGN_DECISION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Processing Rate Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RATE_DECISION_FEATURE_COUNT = DESIGN_DECISION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDecisionImpl <em>Allocation Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDecisionImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAllocationDecision()
	 * @generated
	 */
	int ALLOCATION_DECISION = 11;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_DECISION__DOMAIN = DESIGN_DECISION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Allocationcontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_DECISION__ALLOCATIONCONTEXT = DESIGN_DECISION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Allocation Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_DECISION_FEATURE_COUNT = DESIGN_DECISION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDecisionImpl <em>Assembled Component Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDecisionImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAssembledComponentDecision()
	 * @generated
	 */
	int ASSEMBLED_COMPONENT_DECISION = 12;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLED_COMPONENT_DECISION__DOMAIN = DESIGN_DECISION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Assemblycontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT = DESIGN_DECISION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assembled Component Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLED_COMPONENT_DECISION_FEATURE_COUNT = DESIGN_DECISION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.IntegerRangeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getIntegerRange()
	 * @generated
	 */
	int INTEGER_RANGE = 13;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__UPPER_BOUND_INCLUDED = RANGE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__LOWER_BOUND_INCLUDED = RANGE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__TO = RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE__FROM = RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_RANGE_FEATURE_COUNT = RANGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DoubleRangeImpl <em>Double Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DoubleRangeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDoubleRange()
	 * @generated
	 */
	int DOUBLE_RANGE = 14;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__UPPER_BOUND_INCLUDED = RANGE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__LOWER_BOUND_INCLUDED = RANGE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__TO = RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__FROM = RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_FEATURE_COUNT = RANGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationChoiceImpl <em>Resource Container Replication Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getResourceContainerReplicationChoice()
	 * @generated
	 */
	int RESOURCE_CONTAINER_REPLICATION_CHOICE = 15;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_CHOICE__DESIGNDECISION = CHOICE__DESIGNDECISION;

	/**
	 * The feature id for the '<em><b>Multiplicity Of Resource Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Container Replication Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDecisionImpl <em>Resource Container Replication Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDecisionImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getResourceContainerReplicationDecision()
	 * @generated
	 */
	int RESOURCE_CONTAINER_REPLICATION_DECISION = 16;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DECISION__DOMAIN = DESIGN_DECISION__DOMAIN;

	/**
	 * The feature id for the '<em><b>Resourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER = DESIGN_DECISION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Container Replication Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DECISION_FEATURE_COUNT = DESIGN_DECISION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.GenotypeImpl <em>Genotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.GenotypeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getGenotype()
	 * @generated
	 */
	int GENOTYPE = 17;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENOTYPE__CHOICE = 0;

	/**
	 * The number of structural features of the '<em>Genotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENOTYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 18;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__DESIGNDECISION = 0;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain <em>Discrete Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteDomain()
	 * @generated
	 */
	int DISCRETE_DOMAIN = 19;

	/**
	 * The number of structural features of the '<em>Discrete Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_DOMAIN_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDecisionImpl <em>Connector Config Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDecisionImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getConnectorConfigDecision()
	 * @generated
	 */
	int CONNECTOR_CONFIG_DECISION = 20;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIG_DECISION__DOMAIN = DESIGN_DECISION__DOMAIN;

	/**
	 * The number of structural features of the '<em>Connector Config Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIG_DECISION_FEATURE_COUNT = DESIGN_DECISION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.SoapOrRmiImpl <em>Soap Or Rmi</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.SoapOrRmiImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getSoapOrRmi()
	 * @generated
	 */
	int SOAP_OR_RMI = 21;

	/**
	 * The number of structural features of the '<em>Soap Or Rmi</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_OR_RMI_FEATURE_COUNT = ENUMERATION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DesignDecision <em>Design Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Design Decision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DesignDecision
	 * @generated
	 */
	EClass getDesignDecision();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.designdecision.DesignDecision#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DesignDecision#getDomain()
	 * @see #getDesignDecision()
	 * @generated
	 */
	EReference getDesignDecision_Domain();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.Choice#getDesigndecision <em>Designdecision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Designdecision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Choice#getDesigndecision()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Designdecision();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Range
	 * @generated
	 */
	EClass getRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.Range#isUpperBoundIncluded <em>Upper Bound Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound Included</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Range#isUpperBoundIncluded()
	 * @see #getRange()
	 * @generated
	 */
	EAttribute getRange_UpperBoundIncluded();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.Range#isLowerBoundIncluded <em>Lower Bound Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound Included</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Range#isLowerBoundIncluded()
	 * @see #getRange()
	 * @generated
	 */
	EAttribute getRange_LowerBoundIncluded();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents <em>Equivalent Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalent Components</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents
	 * @generated
	 */
	EClass getEquivalentComponents();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents#getRepositorycomponent <em>Repositorycomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Repositorycomponent</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents#getRepositorycomponent()
	 * @see #getEquivalentComponents()
	 * @generated
	 */
	EReference getEquivalentComponents_Repositorycomponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.AvailableServers <em>Available Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Available Servers</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AvailableServers
	 * @generated
	 */
	EClass getAvailableServers();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.designdecision.AvailableServers#getResourcecontainer <em>Resourcecontainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resourcecontainer</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AvailableServers#getResourcecontainer()
	 * @see #getAvailableServers()
	 * @generated
	 */
	EReference getAvailableServers_Resourcecontainer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ComponentChoice <em>Component Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ComponentChoice
	 * @generated
	 */
	EClass getComponentChoice();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.ComponentChoice#getChosenrepositorycomponent <em>Chosenrepositorycomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Chosenrepositorycomponent</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ComponentChoice#getChosenrepositorycomponent()
	 * @see #getComponentChoice()
	 * @generated
	 */
	EReference getComponentChoice_Chosenrepositorycomponent();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationChoice <em>Allocation Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AllocationChoice
	 * @generated
	 */
	EClass getAllocationChoice();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationChoice#getChosenresourcecontainer <em>Chosenresourcecontainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Chosenresourcecontainer</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AllocationChoice#getChosenresourcecontainer()
	 * @see #getAllocationChoice()
	 * @generated
	 */
	EReference getAllocationChoice_Chosenresourcecontainer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice <em>Processing Rate Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Rate Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice
	 * @generated
	 */
	EClass getProcessingRateChoice();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice#getChosenRate <em>Chosen Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Rate</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice#getChosenRate()
	 * @see #getProcessingRateChoice()
	 * @generated
	 */
	EAttribute getProcessingRateChoice_ChosenRate();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision <em>Processing Rate Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Rate Decision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision
	 * @generated
	 */
	EClass getProcessingRateDecision();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision#getProcessingresourcespecification <em>Processingresourcespecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcespecification</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision#getProcessingresourcespecification()
	 * @see #getProcessingRateDecision()
	 * @generated
	 */
	EReference getProcessingRateDecision_Processingresourcespecification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision#getResourcecontainer <em>Resourcecontainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resourcecontainer</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision#getResourcecontainer()
	 * @see #getProcessingRateDecision()
	 * @generated
	 */
	EReference getProcessingRateDecision_Resourcecontainer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationDecision <em>Allocation Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation Decision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AllocationDecision
	 * @generated
	 */
	EClass getAllocationDecision();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationDecision#getAllocationcontext <em>Allocationcontext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocationcontext</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AllocationDecision#getAllocationcontext()
	 * @see #getAllocationDecision()
	 * @generated
	 */
	EReference getAllocationDecision_Allocationcontext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision <em>Assembled Component Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembled Component Decision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision
	 * @generated
	 */
	EClass getAssembledComponentDecision();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision#getAssemblycontext <em>Assemblycontext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assemblycontext</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision#getAssemblycontext()
	 * @see #getAssembledComponentDecision()
	 * @generated
	 */
	EReference getAssembledComponentDecision_Assemblycontext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.IntegerRange <em>Integer Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Range</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.IntegerRange
	 * @generated
	 */
	EClass getIntegerRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.IntegerRange#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.IntegerRange#getTo()
	 * @see #getIntegerRange()
	 * @generated
	 */
	EAttribute getIntegerRange_To();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.IntegerRange#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.IntegerRange#getFrom()
	 * @see #getIntegerRange()
	 * @generated
	 */
	EAttribute getIntegerRange_From();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DoubleRange <em>Double Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Range</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DoubleRange
	 * @generated
	 */
	EClass getDoubleRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.DoubleRange#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DoubleRange#getTo()
	 * @see #getDoubleRange()
	 * @generated
	 */
	EAttribute getDoubleRange_To();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.DoubleRange#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DoubleRange#getFrom()
	 * @see #getDoubleRange()
	 * @generated
	 */
	EAttribute getDoubleRange_From();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice <em>Resource Container Replication Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Container Replication Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice
	 * @generated
	 */
	EClass getResourceContainerReplicationChoice();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice#getMultiplicityOfResourceContainer <em>Multiplicity Of Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity Of Resource Container</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice#getMultiplicityOfResourceContainer()
	 * @see #getResourceContainerReplicationChoice()
	 * @generated
	 */
	EAttribute getResourceContainerReplicationChoice_MultiplicityOfResourceContainer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision <em>Resource Container Replication Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Container Replication Decision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision
	 * @generated
	 */
	EClass getResourceContainerReplicationDecision();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision#getResourcecontainer <em>Resourcecontainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resourcecontainer</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision#getResourcecontainer()
	 * @see #getResourceContainerReplicationDecision()
	 * @generated
	 */
	EReference getResourceContainerReplicationDecision_Resourcecontainer();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Genotype <em>Genotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Genotype</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Genotype
	 * @generated
	 */
	EClass getGenotype();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.designdecision.Genotype#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Genotype#getChoice()
	 * @see #getGenotype()
	 * @generated
	 */
	EReference getGenotype_Choice();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.designdecision.Problem#getDesigndecision <em>Designdecision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Designdecision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Problem#getDesigndecision()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Designdecision();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain <em>Discrete Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discrete Domain</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain
	 * @generated
	 */
	EClass getDiscreteDomain();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision <em>Connector Config Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Config Decision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision
	 * @generated
	 */
	EClass getConnectorConfigDecision();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.SoapOrRmi <em>Soap Or Rmi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soap Or Rmi</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.SoapOrRmi
	 * @generated
	 */
	EClass getSoapOrRmi();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	designdecisionFactory getdesigndecisionFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DesignDecisionImpl <em>Design Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DesignDecisionImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDesignDecision()
		 * @generated
		 */
		EClass DESIGN_DECISION = eINSTANCE.getDesignDecision();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESIGN_DECISION__DOMAIN = eINSTANCE.getDesignDecision_Domain();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DomainImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Designdecision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__DESIGNDECISION = eINSTANCE.getChoice_Designdecision();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.RangeImpl <em>Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.RangeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getRange()
		 * @generated
		 */
		EClass RANGE = eINSTANCE.getRange();

		/**
		 * The meta object literal for the '<em><b>Upper Bound Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE__UPPER_BOUND_INCLUDED = eINSTANCE.getRange_UpperBoundIncluded();

		/**
		 * The meta object literal for the '<em><b>Lower Bound Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE__LOWER_BOUND_INCLUDED = eINSTANCE.getRange_LowerBoundIncluded();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EquivalentComponentsImpl <em>Equivalent Components</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EquivalentComponentsImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEquivalentComponents()
		 * @generated
		 */
		EClass EQUIVALENT_COMPONENTS = eINSTANCE.getEquivalentComponents();

		/**
		 * The meta object literal for the '<em><b>Repositorycomponent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT = eINSTANCE.getEquivalentComponents_Repositorycomponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AvailableServersImpl <em>Available Servers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AvailableServersImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAvailableServers()
		 * @generated
		 */
		EClass AVAILABLE_SERVERS = eINSTANCE.getAvailableServers();

		/**
		 * The meta object literal for the '<em><b>Resourcecontainer</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVAILABLE_SERVERS__RESOURCECONTAINER = eINSTANCE.getAvailableServers_Resourcecontainer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ComponentChoiceImpl <em>Component Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ComponentChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getComponentChoice()
		 * @generated
		 */
		EClass COMPONENT_CHOICE = eINSTANCE.getComponentChoice();

		/**
		 * The meta object literal for the '<em><b>Chosenrepositorycomponent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT = eINSTANCE.getComponentChoice_Chosenrepositorycomponent();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationChoiceImpl <em>Allocation Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AllocationChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAllocationChoice()
		 * @generated
		 */
		EClass ALLOCATION_CHOICE = eINSTANCE.getAllocationChoice();

		/**
		 * The meta object literal for the '<em><b>Chosenresourcecontainer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER = eINSTANCE.getAllocationChoice_Chosenresourcecontainer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateChoiceImpl <em>Processing Rate Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProcessingRateChoice()
		 * @generated
		 */
		EClass PROCESSING_RATE_CHOICE = eINSTANCE.getProcessingRateChoice();

		/**
		 * The meta object literal for the '<em><b>Chosen Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_RATE_CHOICE__CHOSEN_RATE = eINSTANCE.getProcessingRateChoice_ChosenRate();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateDecisionImpl <em>Processing Rate Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateDecisionImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProcessingRateDecision()
		 * @generated
		 */
		EClass PROCESSING_RATE_DECISION = eINSTANCE.getProcessingRateDecision();

		/**
		 * The meta object literal for the '<em><b>Processingresourcespecification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION = eINSTANCE.getProcessingRateDecision_Processingresourcespecification();

		/**
		 * The meta object literal for the '<em><b>Resourcecontainer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RATE_DECISION__RESOURCECONTAINER = eINSTANCE.getProcessingRateDecision_Resourcecontainer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDecisionImpl <em>Allocation Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDecisionImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAllocationDecision()
		 * @generated
		 */
		EClass ALLOCATION_DECISION = eINSTANCE.getAllocationDecision();

		/**
		 * The meta object literal for the '<em><b>Allocationcontext</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATION_DECISION__ALLOCATIONCONTEXT = eINSTANCE.getAllocationDecision_Allocationcontext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDecisionImpl <em>Assembled Component Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDecisionImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAssembledComponentDecision()
		 * @generated
		 */
		EClass ASSEMBLED_COMPONENT_DECISION = eINSTANCE.getAssembledComponentDecision();

		/**
		 * The meta object literal for the '<em><b>Assemblycontext</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT = eINSTANCE.getAssembledComponentDecision_Assemblycontext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.IntegerRangeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getIntegerRange()
		 * @generated
		 */
		EClass INTEGER_RANGE = eINSTANCE.getIntegerRange();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE__TO = eINSTANCE.getIntegerRange_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_RANGE__FROM = eINSTANCE.getIntegerRange_From();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DoubleRangeImpl <em>Double Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DoubleRangeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDoubleRange()
		 * @generated
		 */
		EClass DOUBLE_RANGE = eINSTANCE.getDoubleRange();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE__TO = eINSTANCE.getDoubleRange_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE__FROM = eINSTANCE.getDoubleRange_From();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationChoiceImpl <em>Resource Container Replication Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getResourceContainerReplicationChoice()
		 * @generated
		 */
		EClass RESOURCE_CONTAINER_REPLICATION_CHOICE = eINSTANCE.getResourceContainerReplicationChoice();

		/**
		 * The meta object literal for the '<em><b>Multiplicity Of Resource Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER = eINSTANCE.getResourceContainerReplicationChoice_MultiplicityOfResourceContainer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDecisionImpl <em>Resource Container Replication Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDecisionImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getResourceContainerReplicationDecision()
		 * @generated
		 */
		EClass RESOURCE_CONTAINER_REPLICATION_DECISION = eINSTANCE.getResourceContainerReplicationDecision();

		/**
		 * The meta object literal for the '<em><b>Resourcecontainer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER = eINSTANCE.getResourceContainerReplicationDecision_Resourcecontainer();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.GenotypeImpl <em>Genotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.GenotypeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getGenotype()
		 * @generated
		 */
		EClass GENOTYPE = eINSTANCE.getGenotype();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENOTYPE__CHOICE = eINSTANCE.getGenotype_Choice();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '<em><b>Designdecision</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__DESIGNDECISION = eINSTANCE.getProblem_Designdecision();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain <em>Discrete Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteDomain()
		 * @generated
		 */
		EClass DISCRETE_DOMAIN = eINSTANCE.getDiscreteDomain();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDecisionImpl <em>Connector Config Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDecisionImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getConnectorConfigDecision()
		 * @generated
		 */
		EClass CONNECTOR_CONFIG_DECISION = eINSTANCE.getConnectorConfigDecision();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.SoapOrRmiImpl <em>Soap Or Rmi</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.SoapOrRmiImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getSoapOrRmi()
		 * @generated
		 */
		EClass SOAP_OR_RMI = eINSTANCE.getSoapOrRmi();

	}

} //designdecisionPackage
