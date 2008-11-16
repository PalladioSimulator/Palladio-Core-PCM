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
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Node;
import de.uka.ipd.sdq.featuremodel.provider.featuremodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;

public class FeatureModelInstanceEditor extends MultiPageEditorPart implements ISelectionProvider {
	
	protected ISelectionChangedListener selectionChangedListener;
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;
	
	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;
	
	protected CheckboxTreeViewer treeViewer;
	protected PropertySheetPage propertySheetPage;
	
	protected ICheckStateListener listener;
	
	protected Resource resource;
	
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
				throw new NullPointerException("No Resource found!");
			}
		}

	}
	
	protected Resource getResource() {
		return resource;
	}
	
	//starts a new file creation wizard
	protected URI startFileWizard (String fileName) {
		ResourceWizard myWiz = new ResourceWizard(fileName);
		myWiz.init(getEditorSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection)getSelection());
		WizardDialog dialog = new WizardDialog(null, myWiz);
		dialog.create();
		dialog.open();
		
		//get the location for the featureconfig
		return myWiz.getNewResource();
	}
	
	//starts an load resource dialog
	protected URI startOpenDialog (String fileName, String extension) {
		
		LoadResourceDialog myDialog = new LoadResourceDialog(getContainer().getShell(), editingDomain);
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
	
	//creates the new resource with Configuration included and overwrites resource object with the newly generated one
	protected void createNewConfigResource (URI newResourceURI, FeatureDiagram featureDiagram) {
		if (newResourceURI == null) {
			throw new NullPointerException ("No Config file stored!");
		}
		else {
			//Create new featureconfig-resource and change current resource
			resource = resource.getResourceSet().createResource(newResourceURI);

			featureconfigFactoryImpl factory = new featureconfigFactoryImpl();
			Configuration newConfig = factory.createConfiguration();
			FeatureConfig newOverrides = factory.createFeatureConfig();
			newConfig.setConfigOverrides(newOverrides);
			
			ConfigNode rootConfigNode = factory.createConfigNode();
			rootConfigNode.setConfigState(ConfigState.ELIMINATED);
			rootConfigNode.setOrigin((Feature)(featureDiagram).getRootFeature());
			
			newOverrides.getConfignode().add(rootConfigNode);
			
			resource.getContents().add(newConfig);
			
			overridesConfig = newOverrides;
			
			try {
				resource.load(Collections.EMPTY_MAP);
				resource.save(Collections.EMPTY_MAP);
			}
			catch (Exception e) {
				throw new NullPointerException("BLA!");
			}
		}
	}
	
	//check if the FeatureDiagram object can be accessed in the loaded resource
	protected FeatureDiagram getFeatureDiagram () {
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
	
	@Override
	protected void createPages() {
		
		createResource();
		
		//get the file extension, file name and the full path to the resource
		String fileExtension = resource.getURI().fileExtension();
		String fileName = resource.getURI().trimFileExtension().lastSegment();
		String path = Platform.getLocation() + resource.getURI().trimFileExtension().toPlatformString(true);
		int fileNameLocation = path.lastIndexOf(fileName);
		path = path.substring(0, fileNameLocation);
		

		FeatureDiagram featureDiagram = null;
		
		//featuremodel file present
		if (fileExtension.equals("featuremodel")) {
			//Check if featuremodel file is valid (FeatureDiagram obejct can be referenced)
			featureDiagram = getFeatureDiagram();
			if (featureDiagram == null) {
				ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("Loaded *.featuremodel file is not valid! The FeatureDiagram object cannot be accessed."));
				errord.open();
				
				//TODO Null Pointer Exception needs to be prevented here (e.g. load resource dialog)
			}
			
			//Check if the equivalent featureconfig-file already exists
			File myFile = new File(path + fileName + ".featureconfig");
			System.out.println(myFile.getPath());
			
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
					}
					
					//Check if *.featureconfig references right FeatureDiagram
					if (isFeatureDiagramReferenceCorrect()) {
						//set overridesConfig, overwrite resource
					}
					else {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("The selected *.featureconfig file references the wrong FeatureDiagram! A new FileWizard will be started."));
						errord.open();
						URI newResourceURI = startFileWizard(fileName);
						createNewConfigResource(newResourceURI, featureDiagram);
					}
					
				}
				else {
					URI newResourceURI = startFileWizard(fileName);
					createNewConfigResource(newResourceURI, featureDiagram);
				}
			}
			else {
				URI configPath = startOpenDialog(fileName, "featureconfig");
				
				if (configPath == null) {
					//File selection Dialog has been canceled, call new file wizard
					ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("No file has been selected! A new file wizard will be started."));
					errord.open();
					URI newResourceURI = startFileWizard(fileName);
					createNewConfigResource(newResourceURI, featureDiagram);
				} 
				else {
					//Check if *.featureconfig references right FeatureDiagram
					if (isFeatureDiagramReferenceCorrect()) {
						//set overridesConfig, overwrite resource
					}
					else {
						ErrorDisplayDialog errord = new ErrorDisplayDialog(getContainer().getShell(),new Throwable("The selected *.featureconfig file references the wrong FeatureDiagram! A new FileWizard will be started."));
						errord.open();
						URI newResourceURI = startFileWizard(fileName);
						createNewConfigResource(newResourceURI, featureDiagram);
					}
				}
			}
			
		}
		//featureconfig file present
		else if (fileExtension.equals("featureconfig")){
			System.out.println("Featureconfig-File present!");
			//TODO Check cases
		}
		//no featureconfig or featuremodel file present
		else {
			System.out.println("Other file extension!");
			//TODO Handle Errors etc.
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
	
	//Checks if a selected featureconfig file references the opened FeatureDiagram resource
	public boolean isFeatureDiagramReferenceCorrect () {
		return true;
	}
	
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
			Node curRoot = root.getRootFeature();
			grayFeatureGroups(curRoot);
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
	
	//registers changes in the Resource object
	public void uncheckInModel (Feature element, boolean state) {
		dirtyFlag = true;
		firePropertyChange(IEditorPart.PROP_DIRTY);
		int hash = element.hashCode();
		boolean found = false;
		Iterator<ConfigNode> tempIter = overridesConfig.getConfignode().iterator();
		
		//search for existing ConfigNodes in the overridesConfig and register changes
		loop: while (tempIter.hasNext()) {
			ConfigNode next = tempIter.next(); 
			if (next.getOrigin().hashCode() == hash) {
				found = true;
				if (state) {
					next.setConfigState(ConfigState.SELECTED);
				}
				else {
					next.setConfigState(ConfigState.ELIMINATED);
				}
				break loop;
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
	
	//Unchecks recursively parent nodes, if no children nodes are checked
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
	
	//returns true, if there are any siblings of current checked, else false
	public boolean getAnyChecked (Object current) {
		Object parent = editingDomain.getParent(current);

		boolean checked = false;

		if (parent instanceof FeatureGroup) {
			EList<Feature> children = ((FeatureGroup) parent).getChildren();
			Iterator<Feature> tempIter = children.iterator();
			Feature next;
			loop: while(tempIter.hasNext()) {
				next = tempIter.next();
				if (treeViewer.getChecked(next)) {
					checked = true;
					break loop;
				}
			}
		}
		else if (parent instanceof Feature) {
			EList<Node> children = ((Feature) parent).getChildren();
			Iterator<Node> tempIter = children.iterator();
			Node next;
			loop: while(tempIter.hasNext()) {
				next = tempIter.next();
				if (treeViewer.getChecked(next)) {
					checked = true;
					break loop;
				}
			}
		}

		return checked;
	}
	
	//checks recursively parent nodes
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
	
	public void grayFeatureGroups (Node curRoot) {
		if (curRoot != null) {
			if (curRoot instanceof FeatureGroup) {
				treeViewer.setGrayed(curRoot, true);
				EList<Feature> nodes = ((FeatureGroup)curRoot).getChildren();
				Iterator<Feature> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					grayFeatureGroups(nodesIter.next());
				}
			}
			else if(curRoot instanceof Feature) {
				EList<Node> nodes = ((Feature)curRoot).getChildren();
				Iterator<Node> nodesIter = nodes.iterator();
				while (nodesIter.hasNext()) {
					grayFeatureGroups(nodesIter.next());
				}
			}
			
		
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
			return "FeatureGroup: " + ((FeatureGroup)element).getName();
		}
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}

class TreeContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Feature) {
			return ((Feature)parentElement).getChildren().toArray();
		}
		else if (parentElement instanceof FeatureDiagram) {
			Object [] newArray = new Object[1];
			newArray[0] = ((FeatureDiagram)parentElement).getRootFeature();
			return newArray;
		}
		else if (parentElement instanceof FeatureGroup) {
			return ((FeatureGroup)parentElement).getChildren().toArray();
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
		if (element instanceof Feature) {
			return (((Feature) element).getChildren().size() != 0);	
		}
		else if (element instanceof FeatureGroup) {
			return (((FeatureGroup) element).getChildren().size() != 0);	
		}
		return false;
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