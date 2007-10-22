package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.EditorInputTransfer;
import org.eclipse.ui.part.ViewPart;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.ConfigureDatasourceDialog;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.OpenDatasourceWizard;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 */

public class ExperimentsView extends ViewPart {
	private TreeViewer viewer;

//	private DrillDownAdapter drillDownAdapter;
//	private ExperimentsAdapter experimentsAdapter;

	private Action reloadView;
	private Action collapseAll;
	private Action expandAll;
	private Action configDataSet;
	private Action openDataSet;
	

	public ExperimentsView() {
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		int ops = DND.DROP_COPY | DND.DROP_MOVE;

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
//		drillDownAdapter = new DrillDownAdapter(viewer);
//		experimentsAdapter = new ExperimentsAdapter(viewer);
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		Transfer[] transfers = new Transfer[] {EditorInputTransfer.getInstance(),
				LocalSelectionTransfer.getTransfer()};
		viewer.addDragSupport(ops, transfers, new TreeDragSourceListener(viewer));
		viewer.addDoubleClickListener(new DoubleClickListener());
		
		makeActions();
		hookContextMenu();
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
		manager.add(configDataSet);
		manager.add(openDataSet);
		manager.add(new Separator());
		manager.add(reloadView);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(configDataSet);
		manager.add(openDataSet);
		manager.add(new Separator());
		manager.add(reloadView);
//		drillDownAdapter.addNavigationActions(manager);
//		manager.add(new Separator());
//		experimentsAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(configDataSet);
		manager.add(openDataSet);
		manager.add(new Separator());
		manager.add(reloadView);
		manager.add(new Separator());
		manager.add(collapseAll);
		manager.add(expandAll);
		manager.add(new Separator());
//		drillDownAdapter.addNavigationActions(manager);
//		manager.add(new Separator());
//		experimentsAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		
		/** Reload viewer action*/
		reloadView = new Action() {
			public void run() {
				SensorFrameworkDataset.singleton().reload();
				viewer.refresh();
			}
		};
		reloadView.setText("Reload View");
		reloadView.setToolTipText("Reload View");
		reloadView.setImageDescriptor(SimuPlugin.getImageDescriptor("/icons/db_reload_obj.gif"));

		/** Collapse all action*/
		collapseAll = new Action() {
			public void run() {
				viewer.collapseAll();
			}
		};
		collapseAll.setText("Collapse All");
		collapseAll.setToolTipText("Collapse All");
		collapseAll.setImageDescriptor(SimuPlugin.getImageDescriptor("/icons/collapseall.gif"));
		
		/** Expand all action*/
		expandAll = new Action() {
			public void run() {
				viewer.expandAll();
			}
		};
		expandAll.setText("Expand All");
		expandAll.setToolTipText("Expand All");
		expandAll.setImageDescriptor(SimuPlugin.getImageDescriptor("/icons/expandall.gif"));
		
		/** Config DataSet action*/
		configDataSet = new Action() {
			public void run() {
				ConfigureDatasourceDialog dialog = new ConfigureDatasourceDialog(
						getSite().getShell(), "Confugure Datasources..." ,false);
				if (dialog.open() == Dialog.OK)
					viewer.refresh();
			}
		};
		configDataSet.setText("Config Datasources");
		configDataSet.setToolTipText("Config Datasources");
		configDataSet.setImageDescriptor(SimuPlugin.getImageDescriptor("/icons/config_obj.png"));
		
		/** Open DataSet action*/
		openDataSet = new Action() {
			public void run() {

				OpenDatasourceWizard wizard = new OpenDatasourceWizard();

				// Instantiates the wizard container with the wizard and opens
				// it
				WizardDialog dialog = new WizardDialog(getSite().getShell(),
						wizard);
				dialog.create();
				
				dialog.setTitle(ConfigureDatasourceDialog.OPEN_WISARD_TITLE);
				dialog.open();
				viewer.refresh();
			}
		};
		openDataSet.setText("Open Datasource");
		openDataSet.setToolTipText("Open existing Datasource");
		openDataSet.setImageDescriptor(SimuPlugin.getImageDescriptor("/icons/add_datasource.gif"));
	
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}