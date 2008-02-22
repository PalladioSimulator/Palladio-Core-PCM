package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;

import ch.ethz.iks.r_osgi.RemoteOSGiService;
import ch.ethz.iks.r_osgi.RemoteServiceReference;
import ch.ethz.iks.r_osgi.URI;
import ch.ethz.iks.r_osgi.service_discovery.ServiceDiscoveryListener;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

public class DockModel extends Observable implements EventHandler {
	private HashMap<String,DockStatusModel> clientDocks = new HashMap<String, DockStatusModel>();
	
	public DockModel(BundleContext context) {
		findExisitingDocks(context);
		addListeners(context);
		registerEventListener(context);
	}

	private void registerEventListener(BundleContext context) {
		String[] topics = new String[] { "de/uka/ipd/sdq/simucomframework/simucomdock/*" };
		Hashtable ht = new Hashtable();
		ht.put(EventConstants.EVENT_TOPIC, topics);
		ServiceRegistration eventListener = context.registerService(
				EventHandler.class.getName(), this, ht);
	}

	public synchronized DockStatusModel addDock(SimulationDockService service) {
		return addDock(service,null);
	}
	
	public synchronized DockStatusModel addDock(SimulationDockService service, String remoteMaschineURI) {
		DockStatusModel result = new DockStatusModel(service,remoteMaschineURI);
		
		clientDocks.put(result.getID(),result);
		setChanged();
		notifyObservers(new DockAddedEvent(result));
		
		return result;
	}

	private void addListeners(final BundleContext context) {
		try {
			context.addServiceListener(new ServiceListener(){

				public void serviceChanged(ServiceEvent event) {
					if (event.getServiceReference().getProperty("objectClass").equals(SimulationDockService.class.getName())){
						if (event.getType() == ServiceEvent.REGISTERED) {
							System.out.println("New Dock appeared");
						}
						if (event.getType() == ServiceEvent.UNREGISTERING) {
							System.out.println("Dock vanished");
						}
					}
				}
				
			});
			context.registerService(ServiceDiscoveryListener.class.getName(), new ServiceDiscoveryListener(){

				public void announceService(String iface, URI uri) {
					System.out.println("Found: "+iface+" "+uri);
					ServiceReference sRef = context.getServiceReference(RemoteOSGiService.class.getName());
					ServiceTracker remoteService = new ServiceTracker(context,sRef,null);
					remoteService.open();
					RemoteOSGiService roserv = (RemoteOSGiService) remoteService.getService();
					RemoteServiceReference[] rserv = roserv.connect(uri);
					SimulationDockService service = (SimulationDockService) roserv.getRemoteService(rserv[0]);
					DockModel.this.addDock(service,uri.toString());
					remoteService.close();
				}

				public void discardService(String iface, URI uri) {
					System.out.println("Lost: "+iface+" "+uri);
					DockStatusModel dock = DockModel.this.getDockByURI(uri);
					DockModel.this.removeDock(dock);
				}}
			, new Hashtable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void removeDock(DockStatusModel dock) {
		clientDocks.remove(dock.getID());
		setChanged();
		notifyObservers(new DockDeletedEvent(dock));
	}

	protected DockStatusModel getDockByURI(URI uri) {
		for (DockStatusModel m : clientDocks.values()) {
			if (m.getRemoteMaschineURI() != null && m.getRemoteMaschineURI().equals(uri.toString())) {
				return m;
			}
		}
		return null;
	}

	private void findExisitingDocks(BundleContext context) {
		// Initially get all local Docks
		try {
			ServiceReference[] services = context.getAllServiceReferences(SimulationDockService.class.getName(), null);
			for (ServiceReference ref : services) {
				// TODO: This does not track the services lifecyle :-(
				this.addDock((SimulationDockService) context.getService(ref));
			}
		} catch (InvalidSyntaxException e1) {
			e1.printStackTrace();
		}
	}

	public Collection<DockStatusModel> getAllDocks() {
		return this.clientDocks.values();
	}

	public DockStatusModel getBestFreeDock() {
		List<DockStatusModel> remote = findIdle(getRemoteDocks());
		List<DockStatusModel> local = findIdle(getLocalDocks());
		if (remote.size() >= 1)
			return remote.get(0);
		else
			return local.get(0);
	}
	
	private List<DockStatusModel> findIdle(List<DockStatusModel> docks) {
		ArrayList<DockStatusModel> localDocks = new ArrayList<DockStatusModel>();
		for (DockStatusModel m : docks) {
			if (m.isIdle()) {
				localDocks.add(m);
			}
		}
		return localDocks;
	}

	public List<DockStatusModel> getLocalDocks() {
		return findDocksByDistance(false);
	}

	public List<DockStatusModel> getRemoteDocks() {
		return findDocksByDistance(true);
	}
	
	private List<DockStatusModel> findDocksByDistance(boolean remote) {
		ArrayList<DockStatusModel> localDocks = new ArrayList<DockStatusModel>();
		for (DockStatusModel m : clientDocks.values()) {
			if (m.isRemote() == remote) {
				localDocks.add(m);
			}
		}
		return localDocks;
	}

	/*
	 * Method to handle OSGi Events sent by the SimulationDock to inform about
	 * status updates (non-Javadoc)
	 * 
	 * @see org.osgi.service.event.EventHandler#handleEvent(org.osgi.service.event.Event)
	 */
	public void handleEvent(Event event) {
		String dockId = (String) event.getProperty("DOCK_ID");
		DockStatusModel dock = this.getDockById(dockId);
		if (event.getTopic().endsWith("UPDATE_SIM_STATUS")) {
			dock.setPercentDone((Integer)event.getProperty("PERCENT_DONE"));
			dock.setSimTime((Double)event.getProperty("CURRENT_TIME"));
			dock.setMeasurementCount((Long)event.getProperty("MEASUREMENTS_TAKEN"));
		}
		if (event.getTopic().endsWith("DOCK_BUSY")) {
			dock.setIdle(false);
		}
		if (event.getTopic().endsWith("DOCK_IDLE")) {
			dock.setIdle(true);
		}
	}

	public DockStatusModel getDockById(String dockId) {
		return clientDocks.get(dockId);
	}
}
