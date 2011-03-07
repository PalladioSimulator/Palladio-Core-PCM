package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.completionfeaturemodel;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature;
import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelFactory;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage;
import edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.IModelSelectionWizard;
import edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.ModelElementSelectionPage;
import edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.ModelFileCreationWizard;
import edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard.ModelSelectionPage;

public class CompletionFeatureModelCreationWizard extends ModelFileCreationWizard implements IModelSelectionWizard{
	
	protected completionfeaturemodelPackage _completionfeaturemodelPackage = completionfeaturemodelPackage.eINSTANCE;
	protected completionfeaturemodelFactory _completionfeaturemodelFactory = _completionfeaturemodelPackage.getcompletionfeaturemodelFactory();

	private ModelSelectionPage modelSelectionPage;
	private ModelElementSelectionPage<EClass> modelElementSelectionPage;
	private EClass selectedEClass;

	public CompletionFeatureModelCreationWizard() {
		super();
		setFileCreationPageName("CompletionFeatureModelFile");
		setFileCreationPageTitle("Create Completion Feature Model");
		setFileExtension("completionfeaturemodel");
		setDefaultFileName("default.completionfeaturemodel");
		
	}
	
	@Override
	public void addPages() {
		super.addPages();
		modelSelectionPage = new ModelSelectionPage("MetaModelImport");
		modelSelectionPage.setTitle("Metamodel Import");
		modelSelectionPage.setDescription("Specify one metamodel and try to load them");
		addPage(modelSelectionPage);
		modelElementSelectionPage = new ModelElementSelectionPage<EClass>("MetaModelImport",EClass.class);
		modelElementSelectionPage.setTitle("Select Annotateable Type");
		modelElementSelectionPage.setDescription("Specify the class type of the element to annotate");
		addPage(modelElementSelectionPage);
	}
	
	@Override
	protected EObject createInitialModel() {
		//EClass eClass = (EClass) _completionfeaturemodelPackage.getCompletionFeatureDiagram();
		//EObject rootObject = _completionfeaturemodelFactory.create(eClass);
		CompletionFeatureDiagram rootObject = _completionfeaturemodelFactory.createCompletionFeatureDiagram();
		rootObject.setAnnotatableElementType(selectedEClass);
		CompletionFeature feature = _completionfeaturemodelFactory.createCompletionFeature();
		rootObject.setRootFeature(feature);
		
		return rootObject;
	}

	@Override
	protected void fetchDataFromPages() {
		super.fetchDataFromPages();
		selectedEClass = modelElementSelectionPage.getSelectedElements().get(0);
	}

	@Override
	public Collection<EPackage> getSelectedModelPackages() {
		return modelSelectionPage.getSelectedModelPackages();
	}


}
