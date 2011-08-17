package de.uka.ipd.sdq.tcfmoop.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;

import de.uka.ipd.sdq.tcfmoop.Activator;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;
import de.uka.ipd.sdq.tcfmoop.tcmanager.IOptimizationTerminatedListener;
import de.uka.ipd.sdq.tcfmoop.tcmanager.IOutputChangedListener;
import de.uka.ipd.sdq.tcfmoop.tcmanager.IRequestManualTerminationListener;
import de.uka.ipd.sdq.tcfmoop.tcmanager.IRequestManualTerminationProvider;
import de.uka.ipd.sdq.tcfmoop.tcmanager.ITerminationCriteriaManager;
import de.uka.ipd.sdq.tcfmoop.tcmanager.ITerminationCriteriaManagerInitializedListener;
import de.uka.ipd.sdq.tcfmoop.tcmanager.TerminationCriteriaManager;

public class TerminationCriteriaView extends ViewPart implements IOutputChangedListener,
																 ITerminationCriteriaManagerInitializedListener,
																 IOptimizationTerminatedListener,
																 IRequestManualTerminationProvider{

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.uka.ipd.sdq.tcfmoop.views.TerminationCriteriaView";
	public Tree terminationCriteriaManagerOutput;
	private List<IRequestManualTerminationListener> requestManualTerminationListeners = new ArrayList<IRequestManualTerminationListener>();
	
	private TreeViewer viewer;
	//private DrillDownAdapter drillDownAdapter;
	private Action requestTerminationAction;
	private Action expandAllaction;
	private Action colapseAllAction;
	private Action copyAllAction;
	private Action doubleClickAction;
	private Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>(11);

	private class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			ImageDescriptor descriptor = null;
			if (obj instanceof Node){
				switch(((Node)obj).type){
				case EXPRESSION: 
					descriptor = Activator.getImageDescriptor("icons/expression.gif");
				break;
				case MANAGER:
					descriptor = Activator.getImageDescriptor("icons/manager.gif");
				break;
				case PARAMETER:
					descriptor = Activator.getImageDescriptor("icons/parameter.gif");
				break;
				case PARAMETER_GROUP:
					descriptor = Activator.getImageDescriptor("icons/parameterGroup.gif");
				break;
				case TERMINATION_CRITERIA:
					descriptor = Activator.getImageDescriptor("icons/terminationCriteria.gif");
				break;
				case WARNING:
					descriptor = Activator.getImageDescriptor("icons/warning.gif");
				break;
				default: 
				}
			}
			
			Image image = (Image)imageCache.get(descriptor);
			if (image == null) {
				image = descriptor.createImage();
				imageCache.put(descriptor, image);
			}
			return image;
		}
		
	}
	
	private class NameSorter extends ViewerSorter {		
		@Override
		public void sort(Viewer viewer, Object[] elements){
			/*
			 * Leave the sorting job to the TerminationCriteriaManager
			 * and don't sort anything here
			 */
		};
	}

	/**
	 * The constructor.
	 */
	public TerminationCriteriaView() {
		TerminationCriteriaManager.addTerminationCriteriaManagerInitializedListener(this);
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new TerminationCriteriaViewContentProvider(this));
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "de.uka.ipd.sdq.tcfmoop.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				TerminationCriteriaView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(requestTerminationAction);
		manager.add(copyAllAction);
		manager.add(colapseAllAction);
		manager.add(expandAllaction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(requestTerminationAction);
		manager.add(new Separator());
		manager.add(copyAllAction);
		manager.add(new Separator());
		manager.add(expandAllaction);
		manager.add(colapseAllAction);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(requestTerminationAction);
		manager.add(new Separator());
		manager.add(copyAllAction);
		manager.add(new Separator());
		manager.add(expandAllaction);
		manager.add(colapseAllAction);
	}

	private void makeActions() {
		requestTerminationAction = new Action() {
			public void run() {
				fireRequestManualTerminationEvent();
			}
		};
		requestTerminationAction.setText("Request Manual Stop");
		requestTerminationAction.setToolTipText("Request Manual Stop: Stops the optimization after the execution of the current iteration.");
		requestTerminationAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_ELCL_STOP));
		requestTerminationAction.setEnabled(false);
		
		expandAllaction = new Action() {
			public void run() {
				viewer.expandAll();
			}
		};
		expandAllaction.setText("Expand All");
		expandAllaction.setToolTipText("Expand All Nodes");
		expandAllaction.setImageDescriptor(Activator.getImageDescriptor("icons/expandall.gif"));
		
		colapseAllAction = new Action() {
			public void run() {
				viewer.collapseAll();
			}
		};
		colapseAllAction.setText("Colapse All");
		colapseAllAction.setToolTipText("Colapse All Nodes");
		colapseAllAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_ELCL_COLLAPSEALL));
		
		copyAllAction = new Action() {
			public void run() {
				Clipboard cb = new Clipboard(Display.getDefault());
				
				String clipBoardText = terminationCriteriaManagerOutput.subTreeToString("\t", 0);
			
				TextTransfer textTransfer = TextTransfer.getInstance();
				cb.setContents(new Object[] { clipBoardText }, new Transfer[] { textTransfer });
			}
		};
		copyAllAction.setText("Copy to Clipboard");
		copyAllAction.setToolTipText("Copy the content of this view to the clipboard in a suitable Tree representation.");
		copyAllAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		
		doubleClickAction = new Action() {
			public void run() {
				Object obj = ((IStructuredSelection)(viewer.getSelection())).iterator().next();
				if(viewer.getExpandedState(obj)){
					viewer.collapseToLevel(obj, 1);
				}else{
				   	viewer.expandToLevel(obj, 1);
				}
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void handleTerminationCriteriaManagerInitializedEvent(
			ITerminationCriteriaManager instance) {
		instance.addOutputChangedListener(this);
		instance.addOptimizationTerminatedListener(this);
		
		this.requestTerminationAction.setEnabled(true);
	}
	
	@Override
	public void handleOutputChangedEvent(final Tree outPut) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				terminationCriteriaManagerOutput = outPut;
				viewer.refresh();
			}
		});	
	}

	@Override
	public void handleOptimizationTerminatedListener(TerminationCriteriaManager instance) {
		instance.removeOutputChangedListener(this);
		instance.removeOptimizationTerminatedListener(this);
		
		this.requestTerminationAction.setEnabled(false);
	}
	
	private void fireRequestManualTerminationEvent(){
		for(IRequestManualTerminationListener listener : this.requestManualTerminationListeners){
			listener.handleManualTerminationRequest();
		}
		this.requestTerminationAction.setEnabled(false);
	}

	@Override
	public void addRequestManualTerminationListener(
			IRequestManualTerminationListener listener) {
		this.requestManualTerminationListeners.add(listener);
		
	}

	@Override
	public void removeRequestManualTerminationListener(
			IRequestManualTerminationListener listener) {
		this.requestManualTerminationListeners.remove(listener);
		
	}
}