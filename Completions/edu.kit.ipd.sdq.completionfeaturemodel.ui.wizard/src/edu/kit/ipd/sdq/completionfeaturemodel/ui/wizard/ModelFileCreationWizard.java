package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;


public abstract class ModelFileCreationWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;
	private ModelFileCreationPage modelFileCreationPage;
	private IWorkbench workbench;
	private String defaultFileName;
	private String fileCreationPageName;
	private String fileCreationPageTitle;
	private String fileExtension;

	@Override
	public boolean performFinish() {
		final IFile modelFile = modelFileCreationPage.getModelFile();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(modelFile, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			fetchDataFromPages();
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	protected void fetchDataFromPages() {
	}

	protected void doFinish(final IFile modelFile,IProgressMonitor monitor) throws CoreException {
		
		monitor.beginTask("Creating " + modelFile, 2);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		
		URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
		Resource resource = resourceSet.createResource(fileURI);
		
		EObject rootObject = createInitialModel();
		if(rootObject != null) {
			resource.getContents().add(rootObject);
		}
		
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING, "Utf-8");
		try {
			resource.save(options);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					workbench.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, modelFile, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
		
	}

	protected abstract EObject createInitialModel();

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
	}
	
	@Override
	public void addPages() {
		modelFileCreationPage = new ModelFileCreationPage(fileCreationPageName, selection);
		modelFileCreationPage.setTitle(fileCreationPageTitle);
		modelFileCreationPage.setDescription("Select file that will contain domain model.");
		modelFileCreationPage.setFileExtension(fileExtension);
		modelFileCreationPage.setFileName(defaultFileName);
		addPage(modelFileCreationPage);
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}

	public void setDefaultFileName(String defaultFileName) {
		this.defaultFileName = defaultFileName;
	}

	public void setFileCreationPageName(String fileCreationPageName) {
		this.fileCreationPageName = fileCreationPageName;
	}

	public void setFileCreationPageTitle(String fileCreationPageTitle) {
		this.fileCreationPageTitle = fileCreationPageTitle;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

}
