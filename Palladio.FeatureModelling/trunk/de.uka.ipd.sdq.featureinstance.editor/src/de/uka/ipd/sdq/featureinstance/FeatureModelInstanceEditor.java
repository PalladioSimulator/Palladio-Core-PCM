package de.uka.ipd.sdq.featureinstance;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.impl.featureconfigFactoryImpl;
import de.uka.ipd.sdq.featureconfig.provider.featureconfigItemProviderAdapterFactory;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.provider.featuremodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;

/**
 * @author fish
 *
 */
public class FeatureModelInstanceEditor extends MultiPageEditorPart implements ISelectionProvider {
	
	protected ISelectionChangedListener selectionChangedListener;
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;
	
	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;
	
	protected CheckboxTreeViewer treeViewer;
	protected PropertySheetPage propertySheetPage;
	
	protected ICheckStateListener listener;
	
	protected Resource resource;
	
	protected FeatureDiagram featureDiagram;
	
	protected Object root;
	
	protected boolean dirtyFlag = false;
	
	protected FeatureConfig defaultConfig;
	protected FeatureConfig overridesConfig;
	
	
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListener = listener;
	}

	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListener = null;
		
	}

	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;
		selectionChangedListener.selectionChanged(new SelectionChangedEvent(this, selection));	
	}
	
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * Initializes the adapterFactory, the commandStack and with these objects the editingDomain
	 */
	protected void initializeEditingDomain () {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new featureconfigItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new featuremodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new IdentifierItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}
    private Composite comp;

	public FeatureModelInstanceEditor() {
		super();
		initializeEditingDomain();
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
	protected void createResource() {
		
		URI resourceURI = EditUIUtil.getURI(getEditorInput());

		//Try to load the resource through the editingDomain.
		resource = null;
		try {
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
			if (resource == null) {
				e.printStackTrace();
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
	protected URI startFileWizard (String fileName) {
		ResourceWizard myWiz = new ResourceWizard(fileName);
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
			FeatureConfig newOverrides = factory.createFeatureConfig();
			newConfig.setConfigOverrides(newOverrides);
			
			//set reference to default if existing
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
			catch (Exception e) {
				e.printStackTrace();
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
	 * Checks if the Configuration object can be accessed in the loaded resource and returns it if possible
	 * 
	 * @param resource The resource from which the Configuration-object can be accessed (a *.featureconfig-file)
	 * @return Returns a Configuration-object or null, if it can be accessed (e.g. no *.featureconfig-file)
	 */
	protected Configuration getConfiguration (Resource resource) {
		EList<EObject> tempList = resource.getContents();
		Iterator<EObject> tempIterator = tempList.iterator();
		EObject newResource;
		if (tempIterator.hasNext()) {
			newResource = tempIterator.next();
		}
		else {
			return null;
		}
		
		if (!(newResource instanceof Configuration)) {
			return null;
		}
		return (Configuration)newResource;
	}
	
	
	/**
	 * Handles the different file types for the loaded resource.
	 * 
	 * @param fileExtension The file extension of the loaded resource
	 * @param path The complete path to the file
	 * @param fileName The filename
	 */
	protected void handleFileCases(String fileExtension, String path, String fileName) {
		//featuremodel file present
		if (fileExtension.equals("featuremodel")) {
			//Check if featuremodel file is valid (FeatureDiagram object can be referenced)
			featureDiagram = getFeatureDiagram(resource);
			if (featureDiagram == null) {
				ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Loaded *.featuremodel file is not valid! The FeatureDiagram object cannot be accessed."));
				errord.open();
				
				//TODO Null Pointer Exception needs to be prevented here (e.g. load resource dialog)
			}
			
			//Check if the equivalent featureconfig-file already exists
			File myFile = new File(path + fileName + ".featureconfig");
			
			if (myFile.exists()) {
				//ask if existing file should be used
				boolean answer = MessageDialog.openQuestion(null, "Load FeatureConfig ?", "A file named \""+ fileName + ".featureconfig\" was found. Should it be loaded?");
				
				//use existing file
				if (answer) {
					
					//load existing featureconfig file
					Resource existingResource = resource.getResourceSet().createResource(URI.createFileURI(myFile.getPath()));
					
					try {
						existingResource.load(Collections.EMPTY_MAP);
					}
					catch (Exception e) {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Existing featureconfig file couldn't be loaded!"));
						errord.open();
						//TODO what to do after errorDialog ?
					}
					
					//Check if *.featureconfig references right FeatureDiagram
					if (isFeatureDiagramReferenceCorrect(existingResource)) {
						existingResource = handleConfigCases(existingResource);
						try {
							resource = existingResource;
							resource.load(Collections.EMPTY_MAP);
							resource.save(Collections.EMPTY_MAP);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					else {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("The selected *.featureconfig file references the wrong FeatureDiagram! A new FileWizard will be started."));
						errord.open();
						URI newResourceURI = startFileWizard(fileName);
						createNewConfigResource(newResourceURI, featureDiagram, null);
					}
					
				}
				else {
					URI newResourceURI = startFileWizard(fileName);
					createNewConfigResource(newResourceURI, featureDiagram, null);
				}
			}
			else {
				URI configPath = startOpenDialog(fileName);
				
				if (configPath == null) {
					//File selection Dialog has been canceled, call new file wizard
					ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("No file has been selected! A new file wizard will be started."));
					errord.open();
					URI newResourceURI = startFileWizard(fileName);
					createNewConfigResource(newResourceURI, featureDiagram, null);
				} 
				else {
					Resource existingResource = resource.getResourceSet().createResource(configPath);
					
					try {
						existingResource.load(Collections.EMPTY_MAP);
					}
					catch (Exception e) {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Existing featureconfig file couldn't be loaded!"));
						errord.open();
						//TODO what to do after errorDialog ?
					}
					
					//Check if *.featureconfig references right FeatureDiagram
					if (isFeatureDiagramReferenceCorrect(existingResource)) {
						existingResource = handleConfigCases(existingResource);
						try {
							resource = existingResource;
							resource.load(Collections.EMPTY_MAP);
							resource.save(Collections.EMPTY_MAP);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					else {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("The selected *.featureconfig file references the wrong FeatureDiagram! A new FileWizard will be started."));
						errord.open();
						URI newResourceURI = startFileWizard(fileName);
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
			
		}
	}
	
	/**
	 * Handles the different cases for a loaded *.featuremodel-resource
	 * 
	 * @param resource The resource in which the configuration object should be stored
	 * @return The resource object which stores the (prop. new) overrides config object
	 */
	protected Resource handleConfigCases(Resource resource) {
		//Check if featureconfig file is valid (Configuration object can be referenced)
		Configuration configuration = getConfiguration(resource);
		
		FeatureConfig tempOverrides = configuration.getConfigOverrides();
		FeatureConfig tempDefault = configuration.getDefaultConfig();
		
		//Both FeatureConfigs are null
		if (tempOverrides == null && tempDefault == null) {
			//TODO needs to be checked if its really necessary to ask for BOTH locations:
			//file selection wizard asking for featuremodel and configmodel location
			//instanciate a overrides config
		}
		else if (tempOverrides == null && tempDefault != null) {
			EList<ConfigNode> configList = tempDefault.getConfignode();
			
			if (configList.isEmpty()) {
				//TODO needs to be checked if its really necessary to ask for BOTH locations:
				//file selection wizard asking for featuremodel and configmodel location
				//instanciate a overrides config
			}
			else {
				featureDiagram = navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin());
				String fileName = resource.getURI().trimFileExtension().lastSegment();
				URI newResourceURI = startFileWizard(fileName);
				createNewConfigResource(newResourceURI, featureDiagram, tempDefault);
			}
		}
		else if (tempOverrides != null && tempDefault == null) {
			EList<ConfigNode> configList = tempOverrides.getConfignode();
			
			if (configList.isEmpty()) {
				//TODO needs to be checked if its really necessary to ask for BOTH locations:
				//file selection wizard asking for featuremodel and configmodel location
				//instanciate a overrides config
			}
			else {
				featureDiagram = navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin());
				overridesConfig = tempOverrides;
			}
		}
		else {
			boolean configPresent = false;
			
			//Check for OverridesConfig
			EList<ConfigNode> configList = tempOverrides.getConfignode();
			
			if (!(configList.isEmpty())) {
				featureDiagram = navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin());
				overridesConfig = tempOverrides;
				configPresent = true;
			}
			
			//Check for DefaultConfig
			configList = tempDefault.getConfignode();
			
			if (!(configList.isEmpty())) {
				if (configPresent) {
					defaultConfig = tempDefault;
				}
				else {
					featureDiagram = navigateToFeatureDiagram((Feature)configList.iterator().next().getOrigin());
					String fileName = resource.getURI().trimFileExtension().lastSegment();
					URI newResourceURI = startFileWizard(fileName);
					createNewConfigResource(newResourceURI, featureDiagram, tempDefault);
				}
			}
		}
		return resource;
	}
	
	@Override
	protected void createPages() {
		
		createResource();
		
		//get the file extension, file name and the full path to the resource
		String fileExtension = resource.getURI().fileExtension();
		String fileName = resource.getURI().trimFileExtension().lastSegment();
		String path = Platform.getLocation() + resource.getURI().trimFileExtension().toPlatformString(true);
		int fileNameLocation = path.lastIndexOf(fileName);
		path = path.substring(0, fileNameLocation);
		
		//handles the different cases of opened files and model/configuration cases
		handleFileCases(fileExtension, path, fileName);
		
		if (featureDiagram == null || overridesConfig == null) {
			ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Something went wrong during the resource loading process. Please restart the Editor with a correct *.featureconfig or *.featuremodel file!"));
			errord.open();
		}

		//Create the Viewer
		comp = new Composite(getContainer(), SWT.NONE);
		comp.setLayout(new FillLayout());

		createViewer(featureDiagram);

		int index = addPage(comp);
		setPageText(index, "");
        
        //Hide editor tabs
		if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
		}
		
	}
	
	/**
	 * Navigates to the FeatureDiagram from a given Feature-object
	 * 
	 * @param feature A Feature-object
	 * @return the parent FeatureDiagram to the given Feature-object
	 */
	public FeatureDiagram navigateToFeatureDiagram (Feature feature) {
		Object parent = editingDomain.getParent(feature);
		
		while (parent != null && !(parent instanceof FeatureDiagram)) {
			parent = editingDomain.getParent(parent);
		}
		
		return (FeatureDiagram)parent;
	}
	
	/**
	 * Checks if a newly loaded featureconfig-file references the opened FeatureDiagram resource
	 * 
	 * @param existingResource Newly loaded Resource-object (should be a featureconfig-file)
	 * @return <code>false</code>, if existingResource doesn't include a Configuration-object or if no ConifgNode references to the opened model
	 * 		   <code>true</code> otherwise
	 */
	public boolean isFeatureDiagramReferenceCorrect (Resource existingResource) {
		Configuration configuration = getConfiguration(existingResource);
		
		boolean correct = false;
		
		if (configuration == null) {
			return correct;
		}
		else {
			FeatureConfig tempOverrides = configuration.getConfigOverrides();
			FeatureConfig tempDefault = configuration.getDefaultConfig();
			
			if (tempOverrides != null) {
				EList <ConfigNode> configList = tempOverrides.getConfignode();
				if (!(configList.isEmpty())) {
					Iterator<ConfigNode> configIterator = configList.iterator();
					while (configIterator.hasNext()) {
						if (configIterator.next().getOrigin() != null) {
							correct = true;
						}
					}
				}
			}
			
			if (!correct && tempDefault != null) {
				EList <ConfigNode> configList = tempDefault.getConfignode();
				if (!(configList.isEmpty())) {
					Iterator<ConfigNode> configIterator = configList.iterator();
					while (configIterator.hasNext()) {
						if (configIterator.next().getOrigin() != null) {
							correct = true;
						}
					}
				}
			}
		}
		return correct;
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
			//grayFeatureGroups(curRoot);
		}
		
		if (defaultConfig != null) {
			markDefaultConfig();
		}
		if (overridesConfig != null) {
			markOverridesConfig();
		}
		
		listener = new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				
				//make FeatureGroups readonly
				if (event.getElement() instanceof FeatureGroup) {
					treeViewer.setChecked(event.getElement(), !(event.getChecked()));
				}
				else {
					Object parent = editingDomain.getParent(event.getElement());					
					
					//check if node is NOT the root node
					if (parent != null && !(parent instanceof FeatureDiagram)) {
						if (treeViewer.getGrayed(event.getElement())) {
							treeViewer.setGrayed(event.getElement(), false);
						}
						
						//check/uncheck recursively
						if (event.getChecked()) {
							uncheckInModel((Feature)event.getElement(),true);
							checkParents(event.getElement());
						}
						else {
							uncheckInModel((Feature)event.getElement(),false);
							uncheckParents(event.getElement());
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

	}
	
	/**
	 * Registers changes made in the TreeViewer to the resource
	 * 
	 * @param element The changed Feature
	 * @param state The checked/unchecked state
	 */
	public void uncheckInModel (Feature element, boolean state) {
		dirtyFlag = true;
		firePropertyChange(IEditorPart.PROP_DIRTY);
		int hash = element.hashCode();
		boolean found = false;
		Iterator<ConfigNode> tempIter = overridesConfig.getConfignode().iterator();
		
		//search for existing ConfigNodes in the overridesConfig and register changes
		while (tempIter.hasNext()) {
			ConfigNode next = tempIter.next(); 
			if (next.getOrigin().hashCode() == hash) {
				found = true;
				if (state) {
					next.setConfigState(ConfigState.SELECTED);
				}
				else {
					next.setConfigState(ConfigState.ELIMINATED);
				}
			}
		}
		
		//if no ConfigNode exists, create new one
		if (!(found)) {
			featureconfigFactoryImpl factory = new featureconfigFactoryImpl();
			ConfigNode newConfig = factory.createConfigNode();
			newConfig.setOrigin(element);
	
			if (state) {
				newConfig.setConfigState(ConfigState.SELECTED);
			}
			else {
				newConfig.setConfigState(ConfigState.ELIMINATED);
			}
			overridesConfig.getConfignode().add(newConfig);
		}
	}
	
	/**
	 * Checks/unchecks the defaultConfiguration in the Viewer
	 */
	public void markDefaultConfig () {
		//mark all default configNodes
		EList<ConfigNode> defaultNodes = defaultConfig.getConfignode();
		Iterator<ConfigNode> tempIter = defaultNodes.iterator();
		ConfigNode next;
		Feature referenced;
		while (tempIter.hasNext()) {
			next = tempIter.next();
			referenced = (Feature)next.getOrigin();

			//selected
			if (next.getConfigState().getValue() == 0) {
				treeViewer.setGrayChecked(referenced, true);
			}
			//eliminated
			else if (next.getConfigState().getValue() == 1) {
				treeViewer.setGrayChecked(referenced, false);
			}
		}
	}
	
	/**
	 * Checks/unchecks the configurationOverrides in the Viewer
	 */
	public void markOverridesConfig () {
		//mark all overrides configNodes
		EList<ConfigNode> overridesNodes = overridesConfig.getConfignode();
		Iterator<ConfigNode> tempIter = overridesNodes.iterator();
		ConfigNode next;
		Feature referenced;
		while (tempIter.hasNext()) {
			next = tempIter.next();
			referenced = (Feature)next.getOrigin();

			//selected
			if (next.getConfigState().getValue() == 0) {
				treeViewer.setGrayed(referenced, false);
				treeViewer.setChecked(referenced, true);
			}
			//eliminated
			else if (next.getConfigState().getValue() == 1) {
				treeViewer.setGrayed(referenced, false);
				treeViewer.setChecked(referenced, false);
			}
		}
	}
	
	/**
	 * Unchecks recursively parent nodes, if no children nodes are checked
	 * 
	 * @param current The unchecked Feature
	 */
	public void uncheckParents (Object current) {
		boolean checked = getAnyChecked(current);

		if (!checked) {
			Object parent = editingDomain.getParent(current);

			if (parent != null && !(parent instanceof FeatureDiagram)) {
				treeViewer.setChecked(parent, false);
				
				if (parent instanceof Feature) {
					uncheckInModel((Feature)parent,false);
				}
				uncheckParents(parent);
			}
		}
	}
	
	/**
	 * Checks recursively parent nodes, if a Node is checked
	 * 
	 * @param current The checked Feature
	 */
	public void checkParents (Object current) {
		Object parent = editingDomain.getParent(current);
		if (parent != null) {
			if (!(treeViewer.getChecked(parent))) {
				treeViewer.setChecked(parent, true);
				
				if (parent instanceof Feature) {
					uncheckInModel((Feature)parent,true);
				}
				checkParents(parent);
			}
		}
	}
	
	/**
	 * Checks, if any siblings of the selected Node are also selected
	 * 
	 * @param current
	 * @return <code>true</code> if there are any siblings of current checked
	 * 		   <code>false</code> otherwise
	 */
	public boolean getAnyChecked (Object current) {
		Object parent = editingDomain.getParent(current);

		boolean checked = false;

		if (parent instanceof FeatureGroup) {
			EList<Feature> children = ((FeatureGroup) parent).getChildren();
			Iterator<Feature> tempIter = children.iterator();
			Feature next;
			while(tempIter.hasNext()) {
				next = tempIter.next();
				if (treeViewer.getChecked(next)) {
					checked = true;
				}
			}
		}
		else if (parent instanceof Feature) {
			ChildRelation childRel = ((Feature) parent).getChildrelation();
			if (!(childRel instanceof FeatureGroup)) {
				EList<Feature> childrenMan = ((Simple)childRel).getMandatoryChildren();
				EList<Feature> childrenOpt = ((Simple)childRel).getOptionalChildren();
				
				Iterator<Feature> manIter = childrenMan.iterator();
				Feature next;
				while(manIter.hasNext()) {
					next = manIter.next();
					if (treeViewer.getChecked(next)) {
						checked = true;
					}
				}
				if (!checked) {
					Iterator<Feature> optIter = childrenOpt.iterator();
					while(optIter.hasNext()) {
						next = optIter.next();
						if (treeViewer.getChecked(next)) {
							checked = true;
						}
					}
				}
			}
		}

		return checked;
	}
	
	
	/**
	 * Grays out the FeatureGroups in the treeViewer
	 * 
	 * @param curRoot The root Node, where the graying should be started
	 * @deprecated not necessary any more after the model changes (no FeatureGroups)
	 */
	public void grayFeatureGroups (Feature curRoot) {
		//TODO: Parameter needs to be changed, cause Node doesnt exist anymore and Feature doesnt make sense
		if (curRoot != null) {
			if (curRoot instanceof FeatureGroup) {
				treeViewer.setGrayed(curRoot, true);
				EList<Feature> nodes = ((FeatureGroup)curRoot).getChildren();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					grayFeatureGroups(nodesIter.next());
				}
			}
			/*else if(curRoot instanceof Feature) {
				EList<Feature> nodes = ((Feature)curRoot).getChildrelation();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					grayFeatureGroups(nodesIter.next());
				}
			}*/
			
		
		}
	}
	
	@Override
	public boolean isDirty() {
		return dirtyFlag;
	}
	
	@Override
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
				@Override
				public void execute(IProgressMonitor monitor) {
					// Save the resources to the file system.
					//
					boolean first = true;
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
							try {
								resource.save(saveOptions);
							}
							catch (Exception exception) {
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
		catch (Exception exception) {
		}
	}
	
	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		}
		catch (IOException e) {
			// Ignore
		}
		return result;
	}

	@Override
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


	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}
}

class TreeLabelProvider implements ILabelProvider {

	@Override
	public Image getImage(Object element){
		ImageDescriptor descriptor = null;
		if (element instanceof Feature) {
			descriptor = FeatureModelInstancePlugin.getImageDescriptor("Feature.gif");
		}
		else if (element instanceof FeatureGroup) {
			descriptor = FeatureModelInstancePlugin.getImageDescriptor("FeatureGroup.gif");
		}
		Image image = descriptor.createImage();
		return image;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Feature) {
			return ((Feature)element).getName();
		}
		else if (element instanceof FeatureGroup) {
			return "FeatureGroup; Min: " + ((FeatureGroup)element).getMin() + ", Max: " + ((FeatureGroup)element).getMax();
		}
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {		
	}

	@Override
	public void dispose() {		
		//TODO Disposing TreeLabelProvider/TreeViewer
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		
	}
	
}

class TreeContentProvider implements ITreeContentProvider {

	@Override
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

	@Override
	public Object getParent(Object element) {
		if (element instanceof Feature) {
		}
		return null;
	}

	@Override
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

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
	}
	
}