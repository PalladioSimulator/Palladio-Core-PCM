package de.uka.ipd.sdq.featureinstance;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.provider.featureconfigItemProviderAdapterFactory;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Node;
import de.uka.ipd.sdq.featuremodel.provider.featuremodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;

public class FeatureModelInstanceEditor extends MultiPageEditorPart {
	
	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;
	
	protected CheckboxTreeViewer treeViewer;
	protected PropertySheetPage propertySheetPage;
	
	protected ICheckStateListener listener;
	
	protected Resource resource;
	
	protected Object root;
	
	protected FeatureConfig defaultConfig;
	protected FeatureConfig overridesConfig;
	
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
            throw new PartInitException("Invalid");
		}
        super.init(site, input);
	}
	
	@Override
	protected void createPages() {
		
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		resource = null;
		try {
			// Load the resource through the editing domain.
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
			throw new NullPointerException("BA");
		}

		FeatureDiagram newDiagram = null;
		Object newResource = null;

		//TODO Returns empty List for *.featureconfig
		EList<EObject> tempList = resource.getContents();
		Iterator<EObject> tempIterator = tempList.iterator();
		if (tempIterator.hasNext()) {
			newResource = tempIterator.next();
		}
		
		if (newResource instanceof FeatureDiagram) {
			newDiagram = (FeatureDiagram) newResource;
		}
		else if (newResource instanceof Configuration) {
			Configuration config = (Configuration) newResource;
			defaultConfig = config.getDefaultConfig();
			overridesConfig = config.getConfigOverrides();

			newDiagram = (FeatureDiagram)defaultConfig.getReferencedObject();
			
		}
		else if (newResource instanceof FeatureConfig) {
			newDiagram = (FeatureDiagram)((FeatureConfig)newResource).getReferencedObject();
		}

		comp = new Composite(getContainer(), SWT.NONE);
		comp.setLayout(new FillLayout());

		createViewer(newDiagram);

		int index = addPage(comp);
		setPageText(index, "");
        
        //Hide editor tabs
		if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
		}
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
							checkParents(event.getElement());
						}
						else {
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
	
	public void markDefaultConfig () {
		//mark all default configNodes
		EList<ConfigNode> defaultNodes = defaultConfig.getConfignode();
		Iterator<ConfigNode> tempIter = defaultNodes.iterator();
		ConfigNode next;
		Feature referenced;
		while (tempIter.hasNext()) {
			next = tempIter.next();
			referenced = next.getOrigin();

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
			referenced = next.getOrigin();

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
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}
	
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
	
	}

	@Override
	public void doSaveAs() {
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


