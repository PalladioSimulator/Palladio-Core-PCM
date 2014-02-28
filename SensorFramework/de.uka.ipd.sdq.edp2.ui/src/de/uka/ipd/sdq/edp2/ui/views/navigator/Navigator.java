package de.uka.ipd.sdq.edp2.ui.views.navigator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.ui.EDP2UIPlugin;

// implements ISaveablePart2
public class Navigator extends ViewPart {
	/** Logger for this class. */
	private final static Logger logger = Logger.getLogger(NavigatorTreeLabelProviderImpl.class.getCanonicalName());

	/** Resource set used to persist the state of this view. */
	ResourceSet rs = new ResourceSetImpl();
	
	/** Resource used to persist the state of this view. */
	Resource resource = rs.createResource(URI.createURI("memory:///"));
	
	/** The shown tree. */
	private TreeViewer treeViewer;
	
	public Navigator() {
		// Register package, necessary to load data from files
		//RepositoryPackage rp = RepositoryPackage.eINSTANCE;
		rs.getPackageRegistry().put(RepositoryPackage.eNS_URI, RepositoryPackage.eINSTANCE);
	}

	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		treeViewer = new TreeViewer(parent);
		treeViewer.setAutoExpandLevel(8);

		ObservableListTreeContentProvider contentProvider = new ObservableListTreeContentProvider(
				new NavigatorTreeFactoryImpl(),
				new NavigatorTreeStructureAdvisorImpl());
		treeViewer.setContentProvider(contentProvider);
		
		// Label Provider; Observe model for change wrt to labels
		IObservableSet set = contentProvider.getKnownElements();  
		IObservableMap[] map = new IObservableMap [3];
		map[0] = EMFProperties.value(
		     RepositoryPackage.Literals.LOCAL_DIRECTORY_REPOSITORY__URI  
		   ).observeDetail(set); 
		map[1] = EMFProperties.value(
			     RepositoryPackage.Literals.LOCAL_MEMORY_REPOSITORY__DOMAIN  
			   ).observeDetail(set); 
		map[2] = EMFProperties.value(
			     RepositoryPackage.Literals.REMOTE_CDO_REPOSITORY__URL
			   ).observeDetail(set);
		// TODO: Observe other labels
		treeViewer.setLabelProvider(new NavigatorTreeLabelProviderImpl(map));
		
		IEMFListProperty nodes = EMFProperties.list(RepositoryPackage.Literals.REPOSITORIES__AVAILABLE_REPOSITORIES);
		treeViewer.setInput(nodes.observe(EDP2UIPlugin.INSTANCE.getRepositories()));

		// Add double click listener
		treeViewer.addDoubleClickListener(new NavigatorDoubleClickListener());
		
		getSite().setSelectionProvider(treeViewer);
	}

	// it is important to implement setFocus()!
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}

	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		resource = rs.createResource(URI.createURI("memory:///"));
		resource.getContents().add(EDP2UIPlugin.INSTANCE.getRepositories());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			logger.log(Level.WARNING, "Could not store current model in memento.");
		}
		
		try {
			memento.putTextData(outputStream.toString("ASCII"));
		} catch (UnsupportedEncodingException e) {
			logger.log(Level.SEVERE, "Could not store state of view in memento. Saving in ASCII failed.", e);
		}
	}
	
	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		if (memento==null || memento.getTextData() == null) { // no saved data (yet)
			return;
		}
		ByteArrayInputStream inputStream;
		try {
			inputStream = new ByteArrayInputStream(memento.getTextData().getBytes("ASCII"));
			resource = rs.createResource(URI.createURI("memory:///"));
			resource.load(inputStream, null);
			// load previous state (if existing)
			if (resource.getContents().size()==1) {
				Repositories repos = (Repositories) resource.getContents().get(0);
				EDP2UIPlugin.INSTANCE.getRepositories().getAvailableRepositories().addAll(repos.getAvailableRepositories());
				for (Repository repo : EDP2UIPlugin.INSTANCE.getRepositories().getAvailableRepositories()) {
					if (repo.canOpen()) {
						try {
							repo.open();
						} catch (DataNotAccessibleException e) {
							logger.log(Level.WARNING, "Could not open repository after reloading. Repository is " + repo);
						}
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.log(Level.SEVERE, "Could not load state of view in memento. Loading from ASCII bytes failed.", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Could not load state of view in memento.", e);
		}
	}
}
