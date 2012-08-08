/**
 * 
 */
package de.fzi.se.quality.presentation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import de.fzi.se.quality.QualityFactory;
import de.fzi.se.quality.QualityRepository;
import de.fzi.se.quality.qualityannotation.PCMRERequestCategory;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationFactory;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

/**Wizard which allows to generate quality files for all {@link ResourceDemandingSEFF} in a {@link Repository} with default values for all categories.
 * @author groenda
 *
 */
public class DefaultQualityModelWizard extends QualityModelWizard {
	/** Page to select the quality and precision defaults. */
	protected DefaultQualityWizardPage defaultQualityWizardPage;
	/** Page to select the Palladio repository. */
	protected SelectRepositoryWizardPage selectRepositoryWizardPage;
	
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new QualityModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(QualityEditorPlugin.INSTANCE.getString("_UI_QualityModelWizard_label"));
		newFileCreationPage.setDescription(QualityEditorPlugin.INSTANCE.getString("_UI_QualityModelWizard_description"));
		newFileCreationPage.setFileName(QualityEditorPlugin.INSTANCE.getString("_UI_QualityEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);
		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				String defaultModelBaseFilename = QualityEditorPlugin.INSTANCE.getString("_UI_QualityEditorFilenameDefaultBase");
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				IContainer targetDirectory;
				if (selectedResource.getType() == IResource.FILE) {
					targetDirectory = selectedResource.getParent();
					if (selectedResource.getFileExtension().equals("repository")) {
						defaultModelBaseFilename = ((IFile)selectedResource).getName().substring(0, selectedResource.getName().length() - 1 - selectedResource.getFileExtension().length());
					} 
				} else {
					targetDirectory = (IContainer) selectedResource;
				}
				newFileCreationPage.setContainerFullPath(targetDirectory.getFullPath());
				String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
				String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
				for (int i = 1; targetDirectory.findMember(modelFilename) != null; ++i) {
					modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
				}
				newFileCreationPage.setFileName(modelFilename);
			}
		}
		// Create the page for default selection
		defaultQualityWizardPage = new DefaultQualityWizardPage("Select default quality");
		addPage(defaultQualityWizardPage);
		
		// Create the page to select the repository for which the quality should be generated
		selectRepositoryWizardPage = new SelectRepositoryWizardPage("Select the repository");
		selectRepositoryWizardPage.init(selection);
		addPage(selectRepositoryWizardPage);
	}

	@Override
	protected EObject createInitialModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(selectRepositoryWizardPage.getRepositoryFileUri()), true);
		if (resource.getContents().size() != 1) {
			throw new IllegalStateException("Loaded XMI file must only contain one root element.");
		} 
		if (! (resource.getContents().get(0) instanceof Repository)) {
			throw new IllegalStateException("Provided repository file did not contain a repository as root element. Location = " + selectRepositoryWizardPage.getRepositoryFileUri());
		}
		Repository repo = (Repository) resource.getContents().get(0);
		QualityRepository qRepo = QualityFactory.eINSTANCE.createQualityRepository();
		for (RepositoryComponent rcomp : repo.getComponents__Repository()) {
			if (rcomp instanceof BasicComponent) {
				for (final ServiceEffectSpecification seff : ((BasicComponent)rcomp).getServiceEffectSpecifications__BasicComponent()) {
					final QualityAnnotation qa = QualityAnnotationFactory.eINSTANCE.createQualityAnnotation();
					qa.setIsValid(true);
					// check which RE categories need to be specified
					// check ResourceDemand and Internal
					Boolean resourceDemandRECategory = false;
					Boolean internalRECategory = false;
					if (seff instanceof ResourceDemandingSEFF) {
						resourceDemandRECategory = true;
						if (((ResourceDemandingSEFF) seff).getResourceDemandingInternalBehaviours().size() > 0) {
							internalRECategory = true;
						}
					}
					// check Resource 
					Boolean resourceRECategory = false;
					if (rcomp.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().size() > 0) {
						resourceRECategory = true;
					}
					// check Operation and Infrastructure
					Boolean infrastructureRECategory = false;
					Boolean operationRECategory = false;
					for (RequiredRole requiredRole : rcomp.getRequiredRoles_InterfaceRequiringEntity()) {
						if (requiredRole instanceof InfrastructureRequiredRole) {
							infrastructureRECategory = true;
						}
						if (requiredRole instanceof OperationRequiredRole) {
							operationRECategory = true;
						}
					}
					// Create quality annotation
					PCMServiceSpecification serviceSpec = QualityAnnotationFactory.eINSTANCE.createPCMServiceSpecification();
					serviceSpec.setResourceDemandingSEFF((ResourceDemandingSEFF) seff);
					qa.setForServiceSpecification(serviceSpec);
					if (infrastructureRECategory) {
						qa.getStipulatedREPrecisions().add(defaultQualityWizardPage.getRequiredElement(PCMRERequestCategory.INFRASTRUCTURE));
					}
					if (operationRECategory) {
						qa.getStipulatedREPrecisions().add(defaultQualityWizardPage.getRequiredElement(PCMRERequestCategory.COMPONENT));
					}
					if (resourceRECategory) {
						qa.getStipulatedREPrecisions().add(defaultQualityWizardPage.getRequiredElement(PCMRERequestCategory.RESOURCE));
					}
					if (resourceDemandRECategory) {
						qa.getStipulatedREPrecisions().add(defaultQualityWizardPage.getRequiredElement(PCMRERequestCategory.RESOURCE_DEMAND));
					}
					if (internalRECategory) {
						qa.getStipulatedREPrecisions().add(defaultQualityWizardPage.getRequiredElement(PCMRERequestCategory.COMPONENT_INTERNAL));
					}
					qRepo.getQualityStatements().add(qa);
				}
			}
		}
		return qRepo;
	}
	
	@Override
	public boolean performFinish() {
		// copied and encoding has been removed
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
							ResourceSet resourceSet = new ResourceSetImpl();

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

							// Create a resource for this file.
							//
							Resource resource = resourceSet.createResource(fileURI);

							// Add the initial model object to the contents.
							//
							EObject rootObject = createInitialModel();
							if (rootObject != null) {
								resource.getContents().add(rootObject);
							}

							// Save the contents of the resource to the file system.
							//
							Map<Object, Object> options = new HashMap<Object, Object>();
							resource.save(options);
						}
						catch (Exception exception) {
							QualityEditorPlugin.INSTANCE.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
					(new FileEditorInput(modelFile),
					 workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), QualityEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			QualityEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}
}
