/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.navigator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.navigator.SaveablesProvider;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryAwareItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.GenericCategoryItemProvider;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.PalladioCategoryDescriptions;


class MySaveable extends Saveable
{

	private Resource myResource;
	
	public MySaveable(Resource r) {
		myResource = r;
		r.setTrackingModification(true);
	}

	@Override
	public void doSave(IProgressMonitor monitor) throws CoreException {
		try {
			myResource.save(null);
		} catch (IOException e) {
			throw new CoreException(null);
		}
	}

	public Resource getResource()
	{
		return myResource;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof MySaveable)
		{
			MySaveable other = (MySaveable) object;
			if (other.getResource() == myResource)
				return true;
		}
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return myResource.toString();
	}

	@Override
	public String getToolTipText() {
		return myResource.toString();
	}

	@Override
	public int hashCode() {
		return myResource.hashCode();
	}

	@Override
	public boolean isDirty() {
		return myResource.isModified();
	}
}

class MySaveablesProvider extends SaveablesProvider {
	
	private ResourceSet rs = null;
	
	public MySaveablesProvider(ResourceSet resourceSet) {
		rs = resourceSet;
		EContentAdapter dirtyListeners = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				if (notification.getNotifier() instanceof EObject)
				{
					EObject eObject = (EObject)notification.getNotifier();
					Resource r = eObject.eResource();
					MySaveable s = new MySaveable(r);
					MySaveablesProvider.this.fireSaveablesDirtyChanged(new Saveable[]{s});
				}
			}
		};
		resourceSet.eAdapters().add(dirtyListeners);	
		
		EContentAdapter repositoryResourceListeners = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				if (notification.getNotifier() instanceof ResourceSet) {
					switch (notification.getFeatureID(ResourceSet.class)) {
					case ResourceSet.RESOURCE_SET__RESOURCES:
						if (notification.getEventType() == Notification.ADD) {
							Resource r = (Resource)notification.getNewValue();
							MySaveable s = new MySaveable(r);
							MySaveablesProvider.this.fireSaveablesOpened(new Saveable[]{s});
						}
						break;
					}
				} else {
					super.notifyChanged(notification);
				}
			}

			protected void setTarget(ResourceSet target) {
				basicSetTarget(target);
			}

			protected void unsetTarget(ResourceSet target) {
				basicUnsetTarget(target);
			}
		};
		repositoryResourceListeners.setTarget(resourceSet);
		resourceSet.eAdapters().add(
				repositoryResourceListeners);
	}

	@Override
	public Object[] getElements(Saveable saveable) {
		MySaveable s = (MySaveable)saveable;
		if (!s.getResource().isLoaded()) {
			try {
				s.getResource().load(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		EList objects = s.getResource().getContents();
		ArrayList result = new ArrayList();
		for (EObject o : (List<EObject>)objects)
		{
			result.add(o);
		}
		return result.toArray();
	}

	@Override
	public Saveable getSaveable(Object element) {
		if (element instanceof EObject)
		{
			EObject eElement = (EObject)element;
			Resource r = eElement.eResource();
			Saveable saveable = new MySaveable(r);
			return saveable;
		}
		return null;
	}

	@Override
	public Saveable[] getSaveables() {
		ArrayList<MySaveable> result = new ArrayList<MySaveable>();
		for (Resource r : (List<Resource>) rs.getResources())
		{
		   result.add(new MySaveable(r));
		}
		return result.toArray(new Saveable[]{});
	}
};


/**
 * @author Snowball
 * This class is OBSOLETE and only left for demonstration purposes.
 */
public class PCMNavigatorContentProvider implements ITreeContentProvider, IAdaptable {

	private Object input;
	final protected TransactionalEditingDomain editingDomain = null;
//		TransactionalEditingDomain.Registry.INSTANCE
//		.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	private StructuredViewer viewer;
	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryContentProvider contentProvider;
	private MySaveablesProvider saveProvider = null;
	private Hashtable<IProject,LinkedRepositoriesNode> myLinkedRepositoriesNodes = new Hashtable<IProject,LinkedRepositoriesNode>();

	public PCMNavigatorContentProvider()
	{
		//saveProvider = new MySaveablesProvider(editingDomain.getResourceSet());
		
		EContentAdapter repositoryResourceListeners = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				if (notification.getNotifier() instanceof ResourceSet) {
					switch (notification.getFeatureID(ResourceSet.class)) {
					case ResourceSet.RESOURCE_SET__RESOURCES:
						if (notification.getEventType() == Notification.ADD) {
							System.out.println("New Resource loaded...");
							viewer.refresh();
						}
						break;
					}
				} else if (notification.getNotifier() instanceof Resource) {
					switch (notification.getFeatureID(Resource.class)) {
					case Resource.RESOURCE__IS_LOADED:
						if (notification.getEventType() == Notification.SET) {
							System.out.println("New Resource loaded...");
							viewer.refresh();
						}
						break;
					}
				}
				else {
					super.notifyChanged(notification);
				}
			}
		};
		repositoryResourceListeners.setTarget(editingDomain.getResourceSet());
		editingDomain.getResourceSet().eAdapters().add(
				repositoryResourceListeners);
		
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		AdapterFactory decoratorFactory = new CategoryAwareItemProviderAdapterFactory(adapterFactory, new PalladioCategoryDescriptions());
		
		contentProvider = new AdapterFactoryContentProvider(decoratorFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject)
		{
			ArrayList children = new ArrayList();
			children.add(myLinkedRepositoriesNodes.get(parentElement));
			return children.toArray();
		}
		if (parentElement instanceof LinkedRepositoriesNode)
		{
			ArrayList resourceList = new ArrayList();
			for (Iterator it=editingDomain.getResourceSet().getResources().iterator();
				it.hasNext();)
			{
				Resource r = (Resource)it.next();
				if (!r.isLoaded())
					try {
						r.load(new HashMap());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (r.isLoaded())
				{
					Collection repositories = EcoreUtil.getObjectsByType(r.getContents(), RepositoryPackage.eINSTANCE.getRepository());
					resourceList.addAll(repositories);
				}
			}
			return resourceList.toArray();
		}
		if (parentElement instanceof EObject || parentElement instanceof GenericCategoryItemProvider)
		{
			return contentProvider.getChildren(parentElement);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		if (element instanceof LinkedRepositoriesNode)
			return ((LinkedRepositoriesNode)element).getParent();
		if (element instanceof EObject) {
			Object originalParent = contentProvider.getParent(element);
			if (originalParent instanceof Resource)
				return myLinkedRepositoriesNodes.get(ResourcesPlugin.getWorkspace().getRoot().getProjects()[0]); //TODO: Works only with one project in the workspace
			return originalParent;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (getChildren(element) == null)
			return false;
		return getChildren(element).length > 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		input = newInput;
		this.viewer = (StructuredViewer)viewer;
		contentProvider.inputChanged(viewer, oldInput, newInput);
		populateHashtable();
	}

	private void 
	populateHashtable() {
		myLinkedRepositoriesNodes.clear();
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects())
		{
			myLinkedRepositoriesNodes.put(p,new LinkedRepositoriesNode(p));
		}
	}

	public Object getAdapter(Class adapter) {
		//if (adapter == SaveablesProvider.class)
		//	return saveProvider;
 		return null;
	}

}
