/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.navigator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryAwareItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryDescriptor;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.GenericCategoryItemProvider;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.ICategoryDescriptions;

class LinkedRepositoriesNode
{
	private IProject parent;

	/**
	 * @return the parent
	 */
	public IProject getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(IProject parent) {
		this.parent = parent;
	}
	
	public LinkedRepositoriesNode(IProject parent)
	{
		this.parent = parent;
	}
}

/**
 * @author Snowball
 *
 */
public class PCMNavigatorContentProvider implements ITreeContentProvider {

	private Object input;
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
		.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	private StructuredViewer viewer;
	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryContentProvider contentProvider;

	public PCMNavigatorContentProvider()
	{
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
		
		AdapterFactory decoratorFactory = new CategoryAwareItemProviderAdapterFactory(adapterFactory, new ICategoryDescriptions(){

			public Collection<CategoryDescriptor> getCategoriesForObject(EObject object) {
				if (object instanceof Repository)
				{
					ArrayList<CategoryDescriptor> result = new ArrayList<CategoryDescriptor>();
					result.add(new CategoryDescriptor(Repository.class, Interface.class, 
							RepositoryPackage.eINSTANCE.getRepository_Interfaces__Repository(), "Interfaces" ));
					result.add(new CategoryDescriptor(Repository.class, ProvidesComponentType.class, 
							RepositoryPackage.eINSTANCE.getRepository_Components__Repository(), "Components" ));
					return Collections.unmodifiableCollection(result);
				}
				if (object instanceof ProvidesComponentType)
				{
					ArrayList<CategoryDescriptor> result = new ArrayList<CategoryDescriptor>();
					result.add(new CategoryDescriptor(ProvidesComponentType.class, ProvidedRole.class, 
							RepositoryPackage.eINSTANCE.getProvidesComponentType_ProvidedRoles__ProvidesComponentType(), "Provided Roles" ));
					result.add(new CategoryDescriptor(ProvidesComponentType.class, RequiredRole.class, 
							RepositoryPackage.eINSTANCE.getProvidesComponentType_RequiredRoles_ProvidesComponentType(), "Required Roles" ));
					if (object instanceof BasicComponent)
					{
						result.add(new CategoryDescriptor(BasicComponent.class, ServiceEffectSpecification.class, 
								RepositoryPackage.eINSTANCE.getBasicComponent_ServiceEffectSpecifications__BasicComponent(), "Service Effect Specifications" ));
					}
					if (object instanceof CompositeComponent)
					{
						result.add(new CategoryDescriptor(CompositeComponent.class, AssemblyContext.class, 
								CompositionPackage.eINSTANCE.getAssemblyContext_EncapsulatedComponent_ChildComponentContext(), "Child Component Contexts" ));
						result.add(new CategoryDescriptor(CompositeComponent.class, AssemblyConnector.class, 
								CompositionPackage.eINSTANCE.getComposedStructure_CompositeAssemblyConnectors_ComposedStructure(), "Assembly Connectors" ));
					}
					return Collections.unmodifiableCollection(result);
				}
				return Collections.EMPTY_LIST;
			}

			public boolean hasCategoriesForObject(EObject object) {
				return getCategoriesForObject(object).size() > 0;
			}
			
		});
		
		contentProvider = new AdapterFactoryContentProvider(decoratorFactory);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject)
		{
			ArrayList children = new ArrayList();
			children.add(new LinkedRepositoriesNode((IProject)parentElement));
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
		if (element instanceof EObject)
			return contentProvider.getParent(element);
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
	}

}
