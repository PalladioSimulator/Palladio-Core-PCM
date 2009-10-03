package de.uka.ipd.sdq.featureinstance;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.impl.featureconfigFactoryImpl;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Simple;

/**
 * @author Grischa Liebel
 *
 */
public class FeatureModelInstanceEditor extends MultiPageEditorPart implements ISelectionProvider, IEditingDomainProvider {
	
	protected ISelectionChangedListener selectionChangedListener;
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;
	
	protected AdapterFactoryEditingDomain editingDomain;
	
	protected CheckboxTreeViewer treeViewer;
	protected PropertySheetPage propertySheetPage;
	
	protected ICheckStateListener listener;
	
	protected Resource resource;
	
	protected FeatureDiagram featureDiagram;
	
	protected Object root;
	
	protected TreeViewer contentOutlineViewer;

	protected IContentOutlinePage contentOutlinePage;
	
	protected boolean dirtyFlag = false;
	
	protected FeatureConfig defaultConfig;
	protected FeatureConfig overridesConfig;
	
	protected FeatureConfigFunctionality functions;
	
	protected Composite comp;
	
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListener = listener;
	}

	public ISelection getSelection() {
		return editorSelection;
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListener = null;
		
	}

	public void setSelection(ISelection selection) {
		editorSelection = selection;
		selectionChangedListener.selectionChanged(new SelectionChangedEvent(this, selection));	
	}
	
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}
	
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	protected void createContextMenuFor(StructuredViewer viewer) {		
		MenuManager contextMenu = new MenuManager();
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				FeatureModelInstanceEditor.this.fillContextMenu(manager);
			}
		});

		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, treeViewer);
	}
	
	protected void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator("Validate"));
		
		((FeatureModelInstanceContributor)getEditorSite().getActionBarContributor()).fillContextMenu(manager);
	}

	public FeatureModelInstanceEditor() {
		super();
		
		functions = new FeatureConfigFunctionality();
		editingDomain = functions.initializeEditingDomain();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof IFileEditorInput)) {
            throw new PartInitException("Invalid input");
		}
        super.init(site, input);
	}
	
	/**
	 * Loads the resource-object through the editingDomain
	 */
	protected void createResource(URI uri) {
		
		if (uri == null) {
		
			URI resourceURI = EditUIUtil.getURI(getEditorInput());
	
			//Try to load the resource through the editingDomain.
			resource = null;
			try {
				resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			}
			catch (Exception e) {
				resource = editingDomain.getResourceSet().getResource(resourceURI, false);
			}
		}
		else {
			URI resourceURI = uri;
			
			//Try to load the resource through the editingDomain.
			resource = null;
			try {
				resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			}
			catch (Exception e) {
				resource = editingDomain.getResourceSet().getResource(resourceURI, false);
			}
		}
	}
	
	/**
	 * @return Returns the resource-object
	 */
	protected Resource getResource() {
		return resource;
	}
	
	/**
	 * Starts a ResourceWizard to create a new File
	 * 
	 * @param fileName The default filename
	 * @return Returns the URI of the new file or null, if dialog was cancelled
	 */
	protected URI startFileWizard (String fileName, String message) {
		FeatureConfigCreationWizard myWiz = new FeatureConfigCreationWizard(fileName, message);
		myWiz.init(getEditorSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection)getSelection());
		WizardDialog dialog = new WizardDialog(null, myWiz);
		dialog.create();
		dialog.open();

		//get the location for the featureconfig
		return myWiz.getNewResource();
	}
	
	/**
	 * Starts a LoadResourceDialog
	 * 
	 * @param fileName The default filename
	 * @return Returns the URI selected by the user in the dialog or null if no file was selected or the dialog cancelled
	 */
	protected URI startOpenDialog (String fileName) {
		
		LoadResourceDialog myDialog = new LoadResourceDialog(getContainer().getShell(), editingDomain);
		myDialog.setBlockOnOpen(true);
		myDialog.open();
		
		if (myDialog.getReturnCode() == 1) {
			return null;
		}
		else {
			List<URI> uriList = myDialog.getURIs();
			if (uriList.isEmpty()) {
				return null;
			}
			else {
				return uriList.get(0);
			}
		}
	}
	
	/**
	 * Creates a new Configuration-Resource with the given newResourceURI corresponding to the given featureDiagram
	 * Overrides the old (*.featuremodel) resource-object 
	 * 
	 * @param newResourceURI The URI for the new Resource
	 * @param featureDiagram A FeatureDiagram-object to which the new Configuration should reference
	 * @param defaultRef A reference to the defaultConfig object or null, if none exists
	 */
	protected void createNewConfigResource (URI newResourceURI, FeatureDiagram featureDiagram, FeatureConfig defaultRef) {
		if (newResourceURI == null) {
			throw new NullPointerException ("No Config file stored in resource!");
		}
		else {
			//Create new featureconfig-resource and change current resource
			resource = resource.getResourceSet().createResource(newResourceURI);

			featureconfigFactoryImpl factory = new featureconfigFactoryImpl();
			Configuration newConfig = factory.createConfiguration();
			newConfig.setName(featureDiagram.getName() + "_config");
			
			FeatureConfig newOverrides = factory.createFeatureConfig();
			newConfig.getConfigOverrides().add(newOverrides);
			
			//set reference to default
			if (defaultRef == null) {
				defaultRef = factory.createFeatureConfig();
			}
			newConfig.setDefaultConfig(defaultRef);
			
			ConfigNode rootConfigNode = factory.createConfigNode();
			rootConfigNode.setConfigState(ConfigState.ELIMINATED);
			rootConfigNode.setOrigin((Feature)(featureDiagram).getRootFeature());
			
			newOverrides.getConfignode().add(rootConfigNode);
			
			resource.getContents().add(newConfig);
			
			defaultConfig = defaultRef;
			overridesConfig = newOverrides;

			try {
				resource.load(Collections.EMPTY_MAP);
				resource.save(Collections.EMPTY_MAP);
			}
			catch (IOException e) {
				ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Could not load or save the Resource!"));
				errord.open();
			}
		}
	}
	
	/**
	 * Checks if the FeatureDiagram object can be accessed in the loaded resource and returns it if possible
	 * 
	 * @param resource The resource from which the FeatureDiagram-object can be accessed (a *.featuremodel-file)
	 * @return Returns a FeatureDiagram-object or null, if it can be accessed (e.g. no *.featuremodel-file)
	 */
	protected FeatureDiagram getFeatureDiagram (Resource resource) {
		EList<EObject> tempList = resource.getContents();
		Iterator<EObject> tempIterator = tempList.iterator();
		EObject newResource;
		if (tempIterator.hasNext()) {
			newResource = tempIterator.next();
		}
		else {
			return null;
		}
		
		if (!(newResource instanceof FeatureDiagram)) {
			return null;
		}
		return (FeatureDiagram)newResource;
	}
	
	
	/**
	 * Handles the different file types for the loaded resource.
	 * 
	 * @param fileExtension The file extension of the loaded resource
	 * @param path The complete path to the file including the fileName
	 * @param fileName The filename
	 */
	protected void handleFileCases(String fileExtension, String path, String fileName) {
		//featuremodel file present
		if (fileExtension.equals("featuremodel")) {
			//Check if featuremodel file is valid (FeatureDiagram object can be referenced)
			featureDiagram = getFeatureDiagram(resource);
			boolean valid = true;
			if (featureDiagram == null) {
				ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Loaded *.featuremodel file is not valid! The FeatureDiagram object cannot be accessed."));
				errord.open();
				valid = false;
			}
			
			//Check if the equivalent featureconfig-file already exists
			File myFile = new File(path + ".featureconfig");
			
			if (valid && myFile.exists()) {
				//ask if existing file should be used
				boolean answer = MessageDialog.openQuestion(null, "Load FeatureConfig ?", "A file named \""+ fileName + ".featureconfig\" was found. Should it be loaded?");
				
				//use existing file
				if (answer) {
					
					//load existing featureconfig file
					Resource existingResource = resource.getResourceSet().createResource(URI.createFileURI(myFile.getPath()));
					
					try {
						existingResource.load(Collections.EMPTY_MAP);
					}
					catch (IOException e) {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Existing featureconfig file couldn't be loaded!"));
						errord.open();
						valid = false;
					}
					
					//Check if *.featureconfig references right FeatureDiagram
					if (functions.isFeatureDiagramReferenceCorrect(existingResource)) {
						existingResource = handleConfigCases(existingResource);
						try {
							resource = existingResource;
							resource.load(Collections.EMPTY_MAP);
							resource.save(Collections.EMPTY_MAP);
						}
						catch (IOException e) {
							ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Resource couldn't be loaded or saved!"));
							errord.open();
							valid = false;
						}
					}
					else {
						URI newResourceURI = startFileWizard(fileName, "Loaded configuration file references wrong diagram. Create a new config file.");
						createNewConfigResource(newResourceURI, featureDiagram, null);
					}
					
				}
				else {
					URI newResourceURI = startFileWizard(fileName, "Create a new config file for the loaded diagram.");
					createNewConfigResource(newResourceURI, featureDiagram, null);
				}
			}
			else if (valid) {
				URI configPath = startOpenDialog(fileName);
				
				if (configPath == null) {
					//File selection Dialog has been canceled, call new file wizard
					URI newResourceURI = startFileWizard(fileName, "File selection dialog has been cancelled. Create a new config resource.");
					createNewConfigResource(newResourceURI, featureDiagram, null);
				} 
				else {
					Resource existingResource = resource.getResourceSet().createResource(configPath);
					
					try {
						existingResource.load(Collections.EMPTY_MAP);
					}
					catch (IOException e) {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Resource couldn't be loaded or saved!"));
						errord.open();
						valid = false;
					}
					
					//Check if *.featureconfig references right FeatureDiagram
					if (functions.isFeatureDiagramReferenceCorrect(existingResource)) {
						existingResource = handleConfigCases(existingResource);
						try {
							resource = existingResource;
							resource.load(Collections.EMPTY_MAP);
							resource.save(Collections.EMPTY_MAP);
						}
						catch (IOException e) {
							ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Resource couldn't be loaded or saved!"));
							errord.open();
							valid = false;
						}
					}
					else {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("The selected *.featureconfig file references the wrong FeatureDiagram! A new FileWizard will be started."));
						errord.open();
						URI newResourceURI = startFileWizard(fileName, "Loaded configuration file references wrong diagram. Create a new config file.");
						createNewConfigResource(newResourceURI, featureDiagram, null);
					}
				}
			}
		}
		//featureconfig file present
		else if (fileExtension.equals("featureconfig")){
			handleConfigCases(resource);
		}
		//no featureconfig or featuremodel file present
		else {
			ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Editor supports only *.featuremodel and *.featureconfig files!"));
			errord.open();
			URI newResourceURI = startOpenDialog("");
			createResource(newResourceURI);
		}
	}
	
	/**
	 * Handles the different cases for a loaded *.featuremodel-resource
	 * http://sdqweb.ipd.uka.de/mediawiki/images/6/61/Check_Cases.png
	 * @param resource The resource in which the configuration object should be stored
	 * @return The resource object which stores the (prop. new) overrides config object
	 */
	protected Resource handleConfigCases(Resource resource) {
		
		//Check if featureconfig file is valid (Configuration object can be referenced)
		Configuration configuration = functions.getConfiguration(resource);
		
		EList<FeatureConfig> tempOverrides = configuration.getConfigOverrides();
		FeatureConfig tempDefault = configuration.getDefaultConfig();
		
		//Both FeatureConfigs are null
		if ( (tempOverrides == null || tempOverrides.isEmpty()) && tempDefault == null) {
			//TODO: check whether to throw an exception
		} 
		else if (tempOverrides == null && tempDefault != null) { //default exists
			EList<ConfigNode> configList = tempDefault.getConfignode();
			
			if (!configList.isEmpty()) {
				//Try to reference the Feature Diagram object and create a new overrides from it
				featureDiagram = functions.navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin(), editingDomain);
				String fileName = resource.getURI().trimFileExtension().lastSegment();
				
				//start wizard an ask for a new file location
				//*.featureconfig with only a default config shall only be used as template
				URI newResourceURI = startFileWizard(fileName, "Only a default configuration was found. Create a new file with a overrides configuration!");
				createNewConfigResource(newResourceURI, featureDiagram, tempDefault);
			}
			else {
				//TODO: check whether to throw an exception
			}
		}
		else if (tempOverrides != null && !tempOverrides.isEmpty() && tempDefault == null) {
			FeatureConfig featureConfig = tempOverrides.get(0); //assumption: only one feature diagram present
			EList<ConfigNode> configList = featureConfig.getConfignode();
			
			//Try to reference the Feature Diagram object
			if (!configList.isEmpty()) {
				featureDiagram = functions.navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin(), editingDomain);
				overridesConfig = featureConfig;
			}
			else {
				//TODO: check whether to throw an exception
			}
		}
		else {
			//both configs are present
			boolean configPresent = false;
			EList<ConfigNode> configList;
			
			//Check for OverridesConfig
			if (!tempOverrides.isEmpty()) {
				FeatureConfig featureConfig = tempOverrides.get(0); //assumption: only one feature diagram present
				configList = featureConfig.getConfignode();						

				//Try to reference the Feature Diagram object
				if (!(configList.isEmpty())) {
					featureDiagram = functions.navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin(), editingDomain);
					overridesConfig = featureConfig;
					configPresent = true;
				}
			}
			
			//Check for DefaultConfig
			configList = tempDefault.getConfignode();
			
			if (!(configList.isEmpty())) {
				//if the feature diagram is already referenced, just save the default config
				if (configPresent) {
					defaultConfig = tempDefault;
				}
				//else, try to reference the feature config object by using the default config
				//and ask for new save location (see case that only a default config is present)
				else {
					featureDiagram = functions.navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin(), editingDomain);
					String fileName = resource.getURI().trimFileExtension().lastSegment();
					URI newResourceURI = startFileWizard(fileName, "Only a default configuration was found. Create a new file with a overrides configuration!");
					createNewConfigResource(newResourceURI, featureDiagram, tempDefault);
				}
			}
		}
		return resource;
	}
	
	protected void createPages() {
		createResource(null);
		createEditor();		
	}
	
	
	/**
	 * Creates the editor layout and content
	 */
	protected void createEditor() {		
		//get the file extension, file name and the full path to the resource
		String fileExtension = resource.getURI().fileExtension();
		String fileName = resource.getURI().trimFileExtension().lastSegment();
		String path = Platform.getLocation() + resource.getURI().trimFileExtension().toPlatformString(true);
		
		//handles the different cases of opened files and model/configuration cases
		handleFileCases(fileExtension, path, fileName);
		
		if (featureDiagram != null && overridesConfig != null) {

			//Create the Viewer
			comp = new Composite(getContainer(), SWT.NONE);
			comp.setLayout(new FillLayout());
	
			createViewer(featureDiagram);
	
			int index = addPage(comp);
			setPageText(index, "");
			
			//set the needed attributes for the validation in the actionBarContributor
			EditingDomainActionBarContributor contrib = getActionBarContributor();
			if (contrib instanceof FeatureModelInstanceContributor) {
				((FeatureModelInstanceContributor)contrib).setConfiguration(functions.getConfiguration(resource));
				((FeatureModelInstanceContributor)contrib).setShell(getContainer().getShell());
			}
	        
	        //Hide editor tabs
			if (getContainer() instanceof CTabFolder) {
					((CTabFolder)getContainer()).setTabHeight(1);
					Point point = getContainer().getSize();
					getContainer().setSize(point.x, point.y + 6);
			}
		}
	}
	
	/**
	 * Creates a treeViewer of the given FeatureDiagram
	 * 
	 * @param root The FeatureDiagram-object which shall be displayed
	 */
	public void createViewer (FeatureDiagram root) {
		treeViewer = new CheckboxTreeViewer(comp);
		
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setLabelProvider(new TreeLabelProvider());		
		treeViewer.setInput(root);
		treeViewer.expandAll();
		getSite().setSelectionProvider(treeViewer);

		if (root != null) {
			treeViewer.setGrayed(root.getRootFeature(), true);

			//Gray FeatureGroups
			Feature curRoot = root.getRootFeature();
			functions.grayFeatureGroups(curRoot.getChildrelation(), treeViewer);
		}
		
		if (defaultConfig != null) {
			functions.markDefaultConfig(defaultConfig,treeViewer);
		}
		if (overridesConfig != null) {
			functions.markOverridesConfig(overridesConfig,treeViewer);
		}
		
		listener = new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				
				//make FeatureGroups readonly
				if (event.getElement() instanceof FeatureGroup) {
					treeViewer.setChecked(event.getElement(), !(event.getChecked()));
				}
				else {
					Object parent = editingDomain.getParent(event.getElement());					
					
					//automatically unchecks Feature again, if its a mandatory Feature and the parent node is selected
					if ((event.getElement() instanceof Feature) && (functions.checkMandatory((Feature)event.getElement(), editingDomain))) {
						if (parent instanceof ChildRelation) {
							parent = editingDomain.getParent(parent);
						}
						
						if (treeViewer.getChecked(parent)) {
							treeViewer.setChecked(event.getElement(), true);							
						}
					}
					//check if node is NOT the root node
					if (parent != null && !(parent instanceof FeatureDiagram)) {
						if (treeViewer.getGrayed(event.getElement())) {
							treeViewer.setGrayed(event.getElement(), false);
						}
						
						//check/uncheck recursively
						if (event.getChecked()) {
							dirtyFlag = true;
							functions.uncheckInModel((Feature)event.getElement(),true, overridesConfig);
							functions.checkParents(event.getElement(),treeViewer,overridesConfig,editingDomain);
						}
						else {
							functions.uncheckInModel((Feature)event.getElement(),false, overridesConfig);
							functions.uncheckParents(event.getElement(),treeViewer,overridesConfig,editingDomain);
						}
					}
					//make root node readonly
					else {
						treeViewer.setChecked(event.getElement(), !(event.getChecked()));
					}
				}
			}
		};
		
		treeViewer.addCheckStateListener(listener);
		createContextMenuFor(treeViewer);
		
		//Selects all mandatory Features
		if (root != null) {
			Feature curRoot = root.getRootFeature();
			functions.selectMandatoryFeatures(curRoot.getChildrelation(), treeViewer, overridesConfig);
		}
		

	}
	
	@Override
	public boolean isDirty() {
		return dirtyFlag;
	}
	
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation =
			new WorkspaceModifyOperation() {
				// This is the method that gets invoked when the operation runs.
				//
				public void execute(IProgressMonitor monitor) {
					// Save the resources to the file system.
					//
					boolean first = true;
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if ((first || !resource.getContents().isEmpty() || functions.isPersisted(resource, editingDomain)) && !editingDomain.isReadOnly(resource)) {
							try {
								resource.save(saveOptions);
							}
							catch (IOException exception) {
								ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Resource couldn't be loaded or saved!"));
								errord.open();
							}
							first = false;
						}
					}
				}
			};

		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			dirtyFlag = false;
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (InvocationTargetException e) {
			ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Resource couldn't be saved!"));
			errord.open();
		}
		catch (InterruptedException e) {
			ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Resource couldn't be saved!"));
			errord.open();
		}
	}

	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public boolean isSaveAsAllowed() {
		return true;
	}
}

class TreeLabelProvider implements ILabelProvider {

	public Image getImage(Object element){
		ImageDescriptor descriptor = null;
		if (element instanceof Feature) {
			descriptor = FeatureModelInstancePlugin.getImageDescriptor("Feature.png");
		}
		else if (element instanceof FeatureGroup) {
			descriptor = FeatureModelInstancePlugin.getImageDescriptor("FeatureGroup.png");
		}
		Image image = descriptor.createImage();
		return image;
	}

	public String getText(Object element) {
		if (element instanceof Feature) {
			return ((Feature)element).getName();
		}
		else if (element instanceof FeatureGroup) {
			return "FeatureGroup; Min: " + ((FeatureGroup)element).getMin() + ", Max: " + ((FeatureGroup)element).getMax();
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {		
	}

	public void dispose() {		
		
	}	
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		
	}
	
}

class TreeContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Feature) {
			Object [] children;
			ChildRelation childRel = ((Feature)parentElement).getChildrelation();
			if (childRel instanceof Simple) {
				Object [] mandatory = ((Simple)childRel).getMandatoryChildren().toArray();
				Object [] optional = ((Simple)childRel).getOptionalChildren().toArray();
				children = new Object [mandatory.length + optional.length];
				
				System.arraycopy(mandatory, 0, children, 0, mandatory.length);
				System.arraycopy(optional, 0, children, mandatory.length, optional.length);
			}
			//childRel is FeatureGroup
			else {
				children = new Object[1];
				children[0] = ((FeatureGroup)childRel);
			}
			return children;
		}
		else if (parentElement instanceof FeatureGroup) {
			return ((FeatureGroup)parentElement).getChildren().toArray();
		}
		else if (parentElement instanceof FeatureDiagram) {
			Object [] newArray = new Object[1];
			newArray[0] = ((FeatureDiagram)parentElement).getRootFeature();
			return newArray;
		}
			return null;
	}

	public Object getParent(Object element) {
		if (element instanceof Feature) {
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		boolean children = true;
		if (element instanceof Feature) {
			ChildRelation childRel = ((Feature)element).getChildrelation();
			if (childRel == null) {
				children = false;
			}
			else if (childRel instanceof Simple) {
				if ((((Simple)childRel).getMandatoryChildren().size() == 0) && (((Simple)childRel).getOptionalChildren().size() == 0)) {
					children = false;
				}
			}
			else {
				if (((FeatureGroup)childRel).getChildren().size() == 0) {
					children = false;
				}
			}
		}
		else if (element instanceof FeatureGroup) {
			if (((FeatureGroup) element).getChildren().size() == 0) {
				children = false;
			}
		}
		return children;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
	}
	
}