package de.uka.ipd.sdq.pcmbench.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.PCMBenchActivator;
import de.uka.ipd.sdq.pcmbench.actions.OpenRepositoryAction;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryAwareItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.PalladioCategoryDescriptions;

public class ResourceView extends ViewPart {

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

		File stateFile = new File(getPathToConfigFile());

		if (stateFile.exists()) {
			IMemento memento = null;

			try {
				memento = XMLMemento.createReadRoot(new InputStreamReader(
						new FileInputStream(stateFile), "UTF-8"));

			} catch (WorkbenchException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// won't happen because we already checked it exists
			} catch (UnsupportedEncodingException e) {
				// not possible - UTF8 is required
			}

			IMemento[] children = memento.getChildren("XMIResource");

			for (int i = 0; i < children.length; i++) {
				String resourceName = children[i].getString("path");

				URI model = URI.createFileURI(resourceName);
				ResourceSet resourceSet = editingDomain.getResourceSet();
				try {
					resourceSet.getResource(model, true);
				} catch (Throwable t) {
					MessageDialog.openInformation(site.getShell(),
							"Resource Loader Error", t.getMessage());
				}
			}
		}
		registerResourceSetListener(editingDomain.getResourceSet());
	}

	/*
	 * (non-Javadoc)
	 * 
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

		AdapterFactory decoratorFactory = new CategoryAwareItemProviderAdapterFactory(
				adapterFactory, new PalladioCategoryDescriptions());

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

	/**
	 * Return absolute path of the config file. It develops out location in the
	 * local file system of the plug-in state area for this plug-in and defined
	 * name.
	 */
	static String getPathToConfigFile() {
		IPath path = PCMBenchActivator.getDefault().getStateLocation();

		return path.toPortableString() + "/" + "load_resources.xml";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.ViewPart#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		ResourceSet resourceSet = null;
		EList resourcesList = null;
		OutputStreamWriter writer = null;

		try {
			writer = new OutputStreamWriter(new FileOutputStream(
					getPathToConfigFile()), "UTF-8");

		} catch (UnsupportedEncodingException e1) {
			// not possible, UTF-8 is required to be implemented by all JVMs
		} catch (FileNotFoundException e1) {
			// creating a new file, won't happen unless the path eclipse
			// specifies is totally wrong, or its read-only
		}

		Object object = treeViewer.getInput();

		if (object instanceof ResourceSet)
			resourceSet = (ResourceSet) object;
		Assert.isNotNull(resourceSet);
		resourcesList = resourceSet.getResources();

		XMLMemento xmlmemento = (XMLMemento) memento;

		for (int i = 0; i < resourcesList.size(); i++) {
			XMIResource resource = (XMIResource) resourcesList.get(i);

			IMemento child = xmlmemento.createChild("XMIResource");
			child.putString("path", resource.getURI().devicePath());
		}

		try {
			xmlmemento.save(writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
