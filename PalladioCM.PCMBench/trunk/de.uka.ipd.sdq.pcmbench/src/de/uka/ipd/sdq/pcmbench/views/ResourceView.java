package de.uka.ipd.sdq.pcmbench.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
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
import de.uka.ipd.sdq.pcmbench.actions.OpenRepositoryAction;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryAwareItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryDescriptor;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.ICategoryDescriptions;

public class ResourceView 
extends ViewPart {

	public static final String ID = "de.uka.ipd.sdq.pcmbench.view.ResourceView";

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	private TreeViewer treeViewer;

	private ComposedAdapterFactory adapterFactory = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite)
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);

		registerResourceSetListener(editingDomain.getResourceSet());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	private void registerResourceSetListener(ResourceSet resourceSet) {
		EContentAdapter repositoryResourceListeners = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				if (notification.getNotifier() instanceof ResourceSet) {
					switch (notification.getFeatureID(ResourceSet.class)) {
					case ResourceSet.RESOURCE_SET__RESOURCES:
						if (notification.getEventType() == Notification.ADD) {
							System.out.println("New Resource loaded...");
							invalidateView();
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
		editingDomain.getResourceSet().eAdapters().add(
				repositoryResourceListeners);
	}

	private void invalidateView() {
		treeViewer.refresh();
	}

	@Override
	public void createPartControl(Composite parent) {
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL | SWT.H_SCROLL);
		getSite().setSelectionProvider(treeViewer);
		
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
					return Collections.unmodifiableCollection(result);
				}
				return Collections.EMPTY_LIST;
			}

			public boolean hasCategoriesForObject(EObject object) {
				return getCategoriesForObject(object).size() > 0;
			}
			
		});
		
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				decoratorFactory));
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(
				decoratorFactory));
		treeViewer.setInput(editingDomain.getResourceSet());

		makeActions();
	}

	private void makeActions() {
		OpenRepositoryAction openAction = new OpenRepositoryAction();
		openAction.init(getSite().getWorkbenchWindow());

		MenuManager menuMgr = new MenuManager("resourcePopup");
		menuMgr.add(openAction);
		menuMgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, treeViewer);
	}

	@Override
	public void setFocus() {
	}
}
