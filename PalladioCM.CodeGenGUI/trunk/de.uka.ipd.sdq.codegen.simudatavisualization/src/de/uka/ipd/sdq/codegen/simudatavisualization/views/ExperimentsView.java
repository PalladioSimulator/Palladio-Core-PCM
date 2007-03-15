package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import de.uka.ipd.sdq.codegen.simudatavisualization.Activator;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 */

public class ExperimentsView extends ViewPart {
	private TreeViewer viewer;

	private DrillDownAdapter drillDownAdapter;

	private Action reloadView;
	private Action collapseAll;
	private Action doubleClickAction;

	/**
	 * The constructor.
	 */
	public ExperimentsView() {
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new TreeViewContentProvider(getViewSite()));
		viewer.setLabelProvider(new TreeViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

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
				ExperimentsView.this.fillContextMenu(manager);
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
		manager.add(reloadView);
		manager.add(new Separator());
		manager.add(collapseAll);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(reloadView);
		manager.add(new Separator());
		manager.add(collapseAll);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(reloadView);
		manager.add(new Separator());
		manager.add(collapseAll);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		reloadView = new Action() {
			public void run() {
				viewer.refresh();
			}
		};
		reloadView.setText("Reload View");
		reloadView.setToolTipText("Reload View");
		reloadView.setImageDescriptor(Activator.getImageDescriptor("/icons/db_reload_obj.gif"));

		collapseAll = new Action() {
			public void run() {
				viewer.collapseAll();
			}
		};
		collapseAll.setText("Collapse All");
		collapseAll.setToolTipText("Collapse All");
		collapseAll.setImageDescriptor(Activator.getImageDescriptor("/icons/collapseall.gif"));
		
		// TODO ???
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
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

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Experiments View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}