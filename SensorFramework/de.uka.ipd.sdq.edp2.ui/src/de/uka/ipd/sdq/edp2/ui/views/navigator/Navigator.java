package de.uka.ipd.sdq.edp2.ui.views.navigator;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.edp2.EDP2Plugin;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * ViewPart for the Navigator.
 * 
 * @author Sebastian Lehrig
 */
public class Navigator extends ViewPart{
	/** The shown tree. */
	private TreeViewer treeViewer;
	
	/**
	 * The constructor.
	 */
	public Navigator() {
	    super();
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
		treeViewer.setInput(nodes.observe(EDP2Plugin.INSTANCE.getRepositories()));

		// Add double click listener
		treeViewer.addDoubleClickListener(new NavigatorDoubleClickListener());
		
		getSite().setSelectionProvider(treeViewer);
	}

	// it is important to implement setFocus()!
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}
}
