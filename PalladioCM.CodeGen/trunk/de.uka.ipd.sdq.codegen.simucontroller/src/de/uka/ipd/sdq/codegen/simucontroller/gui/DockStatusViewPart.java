package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import ch.ethz.iks.r_osgi.RemoteOSGiService;
import ch.ethz.iks.r_osgi.RemoteServiceReference;
import ch.ethz.iks.r_osgi.URI;
import ch.ethz.iks.r_osgi.service_discovery.ServiceDiscoveryHandler;
import ch.ethz.iks.r_osgi.service_discovery.ServiceDiscoveryListener;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

public class DockStatusViewPart extends ViewPart implements Observer {

	public static final String ID = "de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart"; //$NON-NLS-1$
	private HashMap<String,DockStatusViewer> viewers = new HashMap<String, DockStatusViewer>();
	private DockModel model;
	private Composite container;

	/**
	 * Create contents of the view part
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
		model = SimuControllerPlugin.getDockModel();
		
		for(DockStatusModel dock : model.getAllDocks()) {
			update(model,new DockAddedEvent(dock));
		}
		model.addObserver(this);
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	@Override
	public void dispose() {
		model.deleteObserver(this);
		super.dispose();
	}

	/**
	 * Create the actions
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	public void update(Observable o, Object arg) {
		if (arg instanceof DockAddedEvent) {
			final DockAddedEvent addedEvent = (DockAddedEvent) arg;
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){

				public void run() {
					DockStatusViewPart.this.viewers.put(addedEvent.getAddedDock().getID(), 
							new DockStatusViewer(addedEvent.getAddedDock(),container,SWT.NONE));
					container.layout();
					container.redraw();
				}
				
			});
		}
		if (arg instanceof DockDeletedEvent) {
			final DockDeletedEvent deleteEvent = (DockDeletedEvent) arg;
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){

				public void run() {
					DockStatusViewer viewer = DockStatusViewPart.this.viewers.get(deleteEvent.getDeletedDock().getID());
					DockStatusViewPart.this.viewers.remove(deleteEvent.getDeletedDock().getID());
					viewer.dispose();
					container.layout();
					container.redraw();
				}
				
			});
		}
	}

}
