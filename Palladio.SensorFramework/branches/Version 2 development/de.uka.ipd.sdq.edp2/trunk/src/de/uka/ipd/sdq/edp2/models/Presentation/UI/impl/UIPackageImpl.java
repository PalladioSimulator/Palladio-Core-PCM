/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentDataPackageImpl;
import de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.EmfmodelPackageImpl;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationConfiguration;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationInput;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationPropertyPane;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationType;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationView;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.UIFactory;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage;
import de.uka.ipd.sdq.edp2.models.Presentation.impl.PresentationPackageImpl;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryPackageImpl;







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
public class UIPackageImpl extends EPackageImpl implements UIPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationControllerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationPropertyPaneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationViewEClass = null;

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
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UIPackageImpl() {
		super(eNS_URI, UIFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UIPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UIPackage init() {
		if (isInited) return (UIPackage)EPackage.Registry.INSTANCE.getEPackage(UIPackage.eNS_URI);

		// Obtain or create and register package
		UIPackageImpl theUIPackage = (UIPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UIPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UIPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		PresentationPackageImpl thePresentationPackage = (PresentationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI) instanceof PresentationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI) : PresentationPackage.eINSTANCE);
		ExperimentDataPackageImpl theExperimentDataPackage = (ExperimentDataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI) instanceof ExperimentDataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentDataPackage.eNS_URI) : ExperimentDataPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);

		// Create package meta-data objects
		theUIPackage.createPackageContents();
		thePresentationPackage.createPackageContents();
		theExperimentDataPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();

		// Initialize created meta-data
		theUIPackage.initializePackageContents();
		thePresentationPackage.initializePackageContents();
		theExperimentDataPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUIPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UIPackage.eNS_URI, theUIPackage);
		return theUIPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationConfiguration() {
		return presentationConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationController() {
		return presentationControllerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_Configuration() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_View() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_PropertyPane() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationController_DataReader() {
		return (EReference)presentationControllerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationPropertyPane() {
		return presentationPropertyPaneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationInput() {
		return presentationInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPresentationInput_DataSourceDescription() {
		return (EReference)presentationInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationType() {
		return presentationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPresentationView() {
		return presentationViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIFactory getUIFactory() {
		return (UIFactory)getEFactoryInstance();
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
		presentationConfigurationEClass = createEClass(PRESENTATION_CONFIGURATION);

		presentationControllerEClass = createEClass(PRESENTATION_CONTROLLER);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__CONFIGURATION);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__VIEW);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__PROPERTY_PANE);
		createEReference(presentationControllerEClass, PRESENTATION_CONTROLLER__DATA_READER);

		presentationPropertyPaneEClass = createEClass(PRESENTATION_PROPERTY_PANE);

		presentationInputEClass = createEClass(PRESENTATION_INPUT);
		createEReference(presentationInputEClass, PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION);

		presentationTypeEClass = createEClass(PRESENTATION_TYPE);

		presentationViewEClass = createEClass(PRESENTATION_VIEW);
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
		PresentationPackage thePresentationPackage = (PresentationPackage)EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(presentationConfigurationEClass, PresentationConfiguration.class, "PresentationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationControllerEClass, PresentationController.class, "PresentationController", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentationController_Configuration(), this.getPresentationConfiguration(), null, "configuration", null, 1, 1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPresentationController_View(), this.getPresentationView(), null, "view", null, 1, 1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPresentationController_PropertyPane(), this.getPresentationPropertyPane(), null, "propertyPane", null, 0, -1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPresentationController_DataReader(), thePresentationPackage.getDataReader(), null, "dataReader", null, 0, -1, PresentationController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(presentationPropertyPaneEClass, PresentationPropertyPane.class, "PresentationPropertyPane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationInputEClass, PresentationInput.class, "PresentationInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentationInput_DataSourceDescription(), thePresentationPackage.getDataSource(), null, "dataSourceDescription", null, 0, -1, PresentationInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(presentationTypeEClass, PresentationType.class, "PresentationType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationViewEClass, PresentationView.class, "PresentationView", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";			
		addAnnotation
		  (presentationConfigurationEClass, 
		   source, 
		   new String[] {
			 "persistable", null
		   });
	}

} //UIPackageImpl
