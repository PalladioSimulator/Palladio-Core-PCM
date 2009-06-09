/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.designdecision.AllocationChoice;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDecision;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision;
import de.uka.ipd.sdq.pcm.designdecision.AvailableServers;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ComponentChoice;
import de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteDomain;
import de.uka.ipd.sdq.pcm.designdecision.Domain;
import de.uka.ipd.sdq.pcm.designdecision.DoubleRange;
import de.uka.ipd.sdq.pcm.designdecision.Enumeration;
import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.Genotype;
import de.uka.ipd.sdq.pcm.designdecision.IntegerRange;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;
import de.uka.ipd.sdq.pcm.designdecision.Range;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision;
import de.uka.ipd.sdq.pcm.designdecision.SoapOrRmi;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class designdecisionPackageImpl extends EPackageImpl implements designdecisionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass designDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalentComponentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availableServersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingRateChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingRateDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assembledComponentDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceContainerReplicationChoiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceContainerReplicationDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genotypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass problemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorConfigDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soapOrRmiEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private designdecisionPackageImpl() {
		super(eNS_URI, designdecisionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static designdecisionPackage init() {
		if (isInited) return (designdecisionPackage)EPackage.Registry.INSTANCE.getEPackage(designdecisionPackage.eNS_URI);

		// Obtain or create and register package
		designdecisionPackageImpl thedesigndecisionPackage = (designdecisionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof designdecisionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new designdecisionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();
		ParameterPackage.eINSTANCE.eClass();
		SeffPackage.eINSTANCE.eClass();
		ResourcetypePackage.eINSTANCE.eClass();
		AllocationPackage.eINSTANCE.eClass();
		ResourceenvironmentPackage.eINSTANCE.eClass();
		SystemPackage.eINSTANCE.eClass();
		QosannotationsPackage.eINSTANCE.eClass();
		UsagemodelPackage.eINSTANCE.eClass();
		SubsystemPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thedesigndecisionPackage.createPackageContents();

		// Initialize created meta-data
		thedesigndecisionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thedesigndecisionPackage.freeze();

		return thedesigndecisionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDesignDecision() {
		return designDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDesignDecision_Domain() {
		return (EReference)designDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_Designdecision() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRange() {
		return rangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRange_UpperBoundIncluded() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRange_LowerBoundIncluded() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalentComponents() {
		return equivalentComponentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquivalentComponents_Repositorycomponent() {
		return (EReference)equivalentComponentsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvailableServers() {
		return availableServersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvailableServers_Resourcecontainer() {
		return (EReference)availableServersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentChoice() {
		return componentChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentChoice_Chosenrepositorycomponent() {
		return (EReference)componentChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllocationChoice() {
		return allocationChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllocationChoice_Chosenresourcecontainer() {
		return (EReference)allocationChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingRateChoice() {
		return processingRateChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessingRateChoice_ChosenRate() {
		return (EAttribute)processingRateChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingRateDecision() {
		return processingRateDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessingRateDecision_Processingresourcespecification() {
		return (EReference)processingRateDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessingRateDecision_Resourcecontainer() {
		return (EReference)processingRateDecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllocationDecision() {
		return allocationDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllocationDecision_Allocationcontext() {
		return (EReference)allocationDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssembledComponentDecision() {
		return assembledComponentDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssembledComponentDecision_Assemblycontext() {
		return (EReference)assembledComponentDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerRange() {
		return integerRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRange_To() {
		return (EAttribute)integerRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerRange_From() {
		return (EAttribute)integerRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleRange() {
		return doubleRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRange_To() {
		return (EAttribute)doubleRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRange_From() {
		return (EAttribute)doubleRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceContainerReplicationChoice() {
		return resourceContainerReplicationChoiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceContainerReplicationChoice_MultiplicityOfResourceContainer() {
		return (EAttribute)resourceContainerReplicationChoiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceContainerReplicationDecision() {
		return resourceContainerReplicationDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceContainerReplicationDecision_Resourcecontainer() {
		return (EReference)resourceContainerReplicationDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenotype() {
		return genotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenotype_Choice() {
		return (EReference)genotypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProblem() {
		return problemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProblem_Designdecision() {
		return (EReference)problemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteDomain() {
		return discreteDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorConfigDecision() {
		return connectorConfigDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoapOrRmi() {
		return soapOrRmiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionFactory getdesigndecisionFactory() {
		return (designdecisionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		designDecisionEClass = createEClass(DESIGN_DECISION);
		createEReference(designDecisionEClass, DESIGN_DECISION__DOMAIN);

		domainEClass = createEClass(DOMAIN);

		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__DESIGNDECISION);

		rangeEClass = createEClass(RANGE);
		createEAttribute(rangeEClass, RANGE__UPPER_BOUND_INCLUDED);
		createEAttribute(rangeEClass, RANGE__LOWER_BOUND_INCLUDED);

		enumerationEClass = createEClass(ENUMERATION);

		equivalentComponentsEClass = createEClass(EQUIVALENT_COMPONENTS);
		createEReference(equivalentComponentsEClass, EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT);

		availableServersEClass = createEClass(AVAILABLE_SERVERS);
		createEReference(availableServersEClass, AVAILABLE_SERVERS__RESOURCECONTAINER);

		componentChoiceEClass = createEClass(COMPONENT_CHOICE);
		createEReference(componentChoiceEClass, COMPONENT_CHOICE__CHOSENREPOSITORYCOMPONENT);

		allocationChoiceEClass = createEClass(ALLOCATION_CHOICE);
		createEReference(allocationChoiceEClass, ALLOCATION_CHOICE__CHOSENRESOURCECONTAINER);

		processingRateChoiceEClass = createEClass(PROCESSING_RATE_CHOICE);
		createEAttribute(processingRateChoiceEClass, PROCESSING_RATE_CHOICE__CHOSEN_RATE);

		processingRateDecisionEClass = createEClass(PROCESSING_RATE_DECISION);
		createEReference(processingRateDecisionEClass, PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION);
		createEReference(processingRateDecisionEClass, PROCESSING_RATE_DECISION__RESOURCECONTAINER);

		allocationDecisionEClass = createEClass(ALLOCATION_DECISION);
		createEReference(allocationDecisionEClass, ALLOCATION_DECISION__ALLOCATIONCONTEXT);

		assembledComponentDecisionEClass = createEClass(ASSEMBLED_COMPONENT_DECISION);
		createEReference(assembledComponentDecisionEClass, ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT);

		integerRangeEClass = createEClass(INTEGER_RANGE);
		createEAttribute(integerRangeEClass, INTEGER_RANGE__TO);
		createEAttribute(integerRangeEClass, INTEGER_RANGE__FROM);

		doubleRangeEClass = createEClass(DOUBLE_RANGE);
		createEAttribute(doubleRangeEClass, DOUBLE_RANGE__TO);
		createEAttribute(doubleRangeEClass, DOUBLE_RANGE__FROM);

		resourceContainerReplicationChoiceEClass = createEClass(RESOURCE_CONTAINER_REPLICATION_CHOICE);
		createEAttribute(resourceContainerReplicationChoiceEClass, RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER);

		resourceContainerReplicationDecisionEClass = createEClass(RESOURCE_CONTAINER_REPLICATION_DECISION);
		createEReference(resourceContainerReplicationDecisionEClass, RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER);

		genotypeEClass = createEClass(GENOTYPE);
		createEReference(genotypeEClass, GENOTYPE__CHOICE);

		problemEClass = createEClass(PROBLEM);
		createEReference(problemEClass, PROBLEM__DESIGNDECISION);

		discreteDomainEClass = createEClass(DISCRETE_DOMAIN);

		connectorConfigDecisionEClass = createEClass(CONNECTOR_CONFIG_DECISION);

		soapOrRmiEClass = createEClass(SOAP_OR_RMI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rangeEClass.getESuperTypes().add(this.getDomain());
		enumerationEClass.getESuperTypes().add(this.getDomain());
		equivalentComponentsEClass.getESuperTypes().add(this.getEnumeration());
		availableServersEClass.getESuperTypes().add(this.getEnumeration());
		componentChoiceEClass.getESuperTypes().add(this.getChoice());
		allocationChoiceEClass.getESuperTypes().add(this.getChoice());
		processingRateChoiceEClass.getESuperTypes().add(this.getChoice());
		processingRateDecisionEClass.getESuperTypes().add(this.getDesignDecision());
		allocationDecisionEClass.getESuperTypes().add(this.getDesignDecision());
		assembledComponentDecisionEClass.getESuperTypes().add(this.getDesignDecision());
		integerRangeEClass.getESuperTypes().add(this.getRange());
		doubleRangeEClass.getESuperTypes().add(this.getRange());
		resourceContainerReplicationChoiceEClass.getESuperTypes().add(this.getChoice());
		resourceContainerReplicationDecisionEClass.getESuperTypes().add(this.getDesignDecision());
		connectorConfigDecisionEClass.getESuperTypes().add(this.getDesignDecision());
		soapOrRmiEClass.getESuperTypes().add(this.getEnumeration());

		// Initialize classes and features; add operations and parameters
		initEClass(designDecisionEClass, DesignDecision.class, "DesignDecision", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDesignDecision_Domain(), this.getDomain(), null, "domain", null, 1, 1, DesignDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choiceEClass, Choice.class, "Choice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_Designdecision(), this.getDesignDecision(), null, "designdecision", null, 1, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rangeEClass, Range.class, "Range", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRange_UpperBoundIncluded(), ecorePackage.getEBoolean(), "upperBoundIncluded", "true", 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_LowerBoundIncluded(), ecorePackage.getEBoolean(), "lowerBoundIncluded", "true", 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equivalentComponentsEClass, EquivalentComponents.class, "EquivalentComponents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquivalentComponents_Repositorycomponent(), theRepositoryPackage.getRepositoryComponent(), null, "repositorycomponent", null, 1, -1, EquivalentComponents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(availableServersEClass, AvailableServers.class, "AvailableServers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAvailableServers_Resourcecontainer(), theResourceenvironmentPackage.getResourceContainer(), null, "resourcecontainer", null, 1, -1, AvailableServers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentChoiceEClass, ComponentChoice.class, "ComponentChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentChoice_Chosenrepositorycomponent(), theRepositoryPackage.getRepositoryComponent(), null, "chosenrepositorycomponent", null, 0, 1, ComponentChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationChoiceEClass, AllocationChoice.class, "AllocationChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllocationChoice_Chosenresourcecontainer(), theResourceenvironmentPackage.getResourceContainer(), null, "chosenresourcecontainer", null, 0, 1, AllocationChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingRateChoiceEClass, ProcessingRateChoice.class, "ProcessingRateChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessingRateChoice_ChosenRate(), ecorePackage.getEDouble(), "chosenRate", null, 1, 1, ProcessingRateChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingRateDecisionEClass, ProcessingRateDecision.class, "ProcessingRateDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingRateDecision_Processingresourcespecification(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "processingresourcespecification", null, 1, 1, ProcessingRateDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcessingRateDecision_Resourcecontainer(), theResourceenvironmentPackage.getResourceContainer(), null, "resourcecontainer", null, 0, 1, ProcessingRateDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationDecisionEClass, AllocationDecision.class, "AllocationDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllocationDecision_Allocationcontext(), theAllocationPackage.getAllocationContext(), null, "allocationcontext", null, 1, 1, AllocationDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assembledComponentDecisionEClass, AssembledComponentDecision.class, "AssembledComponentDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssembledComponentDecision_Assemblycontext(), theCompositionPackage.getAssemblyContext(), null, "assemblycontext", null, 1, 1, AssembledComponentDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(integerRangeEClass, IntegerRange.class, "IntegerRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerRange_To(), ecorePackage.getEInt(), "to", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntegerRange_From(), ecorePackage.getEInt(), "from", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(doubleRangeEClass, DoubleRange.class, "DoubleRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleRange_To(), ecorePackage.getEDouble(), "to", null, 1, 1, DoubleRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDoubleRange_From(), ecorePackage.getEDouble(), "from", null, 1, 1, DoubleRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerReplicationChoiceEClass, ResourceContainerReplicationChoice.class, "ResourceContainerReplicationChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceContainerReplicationChoice_MultiplicityOfResourceContainer(), ecorePackage.getEInt(), "multiplicityOfResourceContainer", null, 1, 1, ResourceContainerReplicationChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerReplicationDecisionEClass, ResourceContainerReplicationDecision.class, "ResourceContainerReplicationDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceContainerReplicationDecision_Resourcecontainer(), theResourceenvironmentPackage.getResourceContainer(), null, "resourcecontainer", null, 0, 1, ResourceContainerReplicationDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genotypeEClass, Genotype.class, "Genotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenotype_Choice(), this.getChoice(), null, "choice", null, 1, -1, Genotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(problemEClass, Problem.class, "Problem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProblem_Designdecision(), this.getDesignDecision(), null, "designdecision", null, 1, -1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(discreteDomainEClass, DiscreteDomain.class, "DiscreteDomain", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectorConfigDecisionEClass, ConnectorConfigDecision.class, "ConnectorConfigDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(soapOrRmiEClass, SoapOrRmi.class, "SoapOrRmi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //designdecisionPackageImpl
