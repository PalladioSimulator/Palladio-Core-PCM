/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionFactory;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;
import de.fzi.se.controlflowdescription.ControlFlowDescriptions;

import de.fzi.se.controlflowdescription.graph.GraphPackage;

import de.fzi.se.controlflowdescription.graph.impl.GraphPackageImpl;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathsPackageImpl;

import de.fzi.se.controlflowdescription.util.ControlFlowDescriptionValidator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ControlFlowDescriptionPackageImpl extends EPackageImpl implements ControlFlowDescriptionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlFlowDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlFlowDescriptionsEClass = null;

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
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ControlFlowDescriptionPackageImpl() {
		super(eNS_URI, ControlFlowDescriptionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ControlFlowDescriptionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ControlFlowDescriptionPackage init() {
		if (isInited) return (ControlFlowDescriptionPackage)EPackage.Registry.INSTANCE.getEPackage(ControlFlowDescriptionPackage.eNS_URI);

		// Obtain or create and register package
		ControlFlowDescriptionPackageImpl theControlFlowDescriptionPackage = (ControlFlowDescriptionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ControlFlowDescriptionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ControlFlowDescriptionPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		JJnPathsPackageImpl theJJnPathsPackage = (JJnPathsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JJnPathsPackage.eNS_URI) instanceof JJnPathsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JJnPathsPackage.eNS_URI) : JJnPathsPackage.eINSTANCE);

		// Create package meta-data objects
		theControlFlowDescriptionPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theJJnPathsPackage.createPackageContents();

		// Initialize created meta-data
		theControlFlowDescriptionPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theJJnPathsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theControlFlowDescriptionPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ControlFlowDescriptionValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theControlFlowDescriptionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ControlFlowDescriptionPackage.eNS_URI, theControlFlowDescriptionPackage);
		return theControlFlowDescriptionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlFlowDescription() {
		return controlFlowDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlFlowDescription_Jjnpathsets() {
		return (EReference)controlFlowDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlFlowDescription_Jjpaths() {
		return (EReference)controlFlowDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlFlowDescription_Controlflowdescriptions() {
		return (EReference)controlFlowDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlFlowDescription_Graph() {
		return (EReference)controlFlowDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlFlowDescriptions() {
		return controlFlowDescriptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlFlowDescriptions_ControlFlowDescription() {
		return (EReference)controlFlowDescriptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescriptionFactory getControlFlowDescriptionFactory() {
		return (ControlFlowDescriptionFactory)getEFactoryInstance();
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
		controlFlowDescriptionEClass = createEClass(CONTROL_FLOW_DESCRIPTION);
		createEReference(controlFlowDescriptionEClass, CONTROL_FLOW_DESCRIPTION__JJNPATHSETS);
		createEReference(controlFlowDescriptionEClass, CONTROL_FLOW_DESCRIPTION__JJPATHS);
		createEReference(controlFlowDescriptionEClass, CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS);
		createEReference(controlFlowDescriptionEClass, CONTROL_FLOW_DESCRIPTION__GRAPH);

		controlFlowDescriptionsEClass = createEClass(CONTROL_FLOW_DESCRIPTIONS);
		createEReference(controlFlowDescriptionsEClass, CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION);
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
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);
		JJnPathsPackage theJJnPathsPackage = (JJnPathsPackage)EPackage.Registry.INSTANCE.getEPackage(JJnPathsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGraphPackage);
		getESubpackages().add(theJJnPathsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(controlFlowDescriptionEClass, ControlFlowDescription.class, "ControlFlowDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlFlowDescription_Jjnpathsets(), theJJnPathsPackage.getJJnPathSet(), theJJnPathsPackage.getJJnPathSet_Controlflowdescription(), "jjnpathsets", null, 0, -1, ControlFlowDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getControlFlowDescription_Jjpaths(), theJJnPathsPackage.getJJPath(), theJJnPathsPackage.getJJPath_Controlflowdescription(), "jjpaths", null, 0, -1, ControlFlowDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getControlFlowDescription_Controlflowdescriptions(), this.getControlFlowDescriptions(), this.getControlFlowDescriptions_ControlFlowDescription(), "controlflowdescriptions", null, 1, 1, ControlFlowDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getControlFlowDescription_Graph(), theGraphPackage.getGraph(), theGraphPackage.getGraph_Controlflowdescription(), "graph", null, 0, 1, ControlFlowDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(controlFlowDescriptionEClass, ecorePackage.getEBoolean(), "GraphMustBeDefinedIfJJnPathsPresent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(controlFlowDescriptionsEClass, ControlFlowDescriptions.class, "ControlFlowDescriptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlFlowDescriptions_ControlFlowDescription(), this.getControlFlowDescription(), this.getControlFlowDescription_Controlflowdescriptions(), "controlFlowDescription", null, 0, -1, ControlFlowDescriptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ControlFlowDescriptionPackageImpl
