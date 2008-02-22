package de.uka.ipd.sdq.simucomframework.simulationdock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;

import de.uka.ipd.sdq.simucomframework.ISimuComControl;
import de.uka.ipd.sdq.simucomframework.IStatusObserver;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimulationDockServiceImpl implements SimulationDockService {

	private BundleContext context;
	private String myID = EcoreUtil.generateUUID();

	public SimulationDockServiceImpl(BundleContext context) {
		this.context = context;
	}
	
	public void simulate(SimuComConfig config, byte[] simulationBundle) {
		ServiceReference eventServiceRef = context.getServiceReference(EventAdmin.class.getName());
		ServiceTracker eventService = new ServiceTracker(context,eventServiceRef,null);
		eventService.open();
		EventAdmin eventAdmin = (EventAdmin)eventService.getService();

		postEvent(eventAdmin,"de/uka/ipd/sdq/simucomframework/simucomdock/DOCK_BUSY");

		ensurePluginLoaded(context, "org.eclipse.equinox.event");
		unloadPluginIfExists(context, "de.uka.ipd.sdq.codegen.simucominstance");
		loadAndSimulateBundle(config, simulationBundle, eventAdmin);
		
		postEvent(eventAdmin,"de/uka/ipd/sdq/simucomframework/simucomdock/DOCK_IDLE");
		eventService.close();
	}

	private void loadAndSimulateBundle(SimuComConfig config,
			byte[] simulationBundle, EventAdmin eventAdmin) {
		String bundleLocation = persistBundleInTempDir(simulationBundle);
		Bundle simulationBundleRef = null;
		try {
			simulationBundleRef = context.installBundle(new File(bundleLocation).toURI().toString());
			simulationBundleRef.start();
			
			simulate(config, simulationBundleRef, eventAdmin);

			simulationBundleRef.stop();
		} catch (BundleException e) {
			e.printStackTrace();
		} finally {
			if (simulationBundleRef != null) {
				try {
					simulationBundleRef.uninstall();
				} catch (BundleException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void simulate(SimuComConfig config, Bundle simulationBundleRef, final EventAdmin eventAdmin) {
		ServiceReference[] services = simulationBundleRef.getRegisteredServices();
		assert services.length == 1;
		
		ServiceTracker service = new ServiceTracker(context,services[0],null);
		service.open();
		postEvent(eventAdmin,"de/uka/ipd/sdq/simucomframework/simucomdock/SIM_STARTED");
		((ISimuComControl)service.getService()).startSimulation(config, new IStatusObserver(){
			int lastPercent = 0;
			
			public void updateStatus(int percentDone, double currentTime, long measurementsTaken) {
				if (percentDone > lastPercent){
					Hashtable properties = new Hashtable();
					properties.put("PERCENT_DONE", percentDone);
					properties.put("CURRENT_TIME", currentTime);
					properties.put("MEASUREMENTS_TAKEN", measurementsTaken);
					postEvent(eventAdmin,"de/uka/ipd/sdq/simucomframework/simucomdock/UPDATE_SIM_STATUS",properties);
					lastPercent = percentDone;
				}
			}
			
		});
		service.close();
		postEvent(eventAdmin,"de/uka/ipd/sdq/simucomframework/simucomdock/SIM_STOPPED");
	}

	private void postEvent(EventAdmin eventAdmin, String topic) {
		postEvent(eventAdmin, topic, new Hashtable());
	}
	
	private void postEvent(EventAdmin eventAdmin, String topic, Hashtable newProperties) {
		Hashtable properties = new Hashtable();
		properties.put("DOCK_ID", SimulationDockServiceImpl.this.getDockId());
		properties.putAll(newProperties);
		Event event = new Event(topic, properties);
		eventAdmin.postEvent(event);
	}
	
	private String persistBundleInTempDir(byte[] simulationBundle) {
		File tempFile = null;
		try {
			tempFile = File.createTempFile("simucominstance", ".jar");
			tempFile.deleteOnExit();
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(simulationBundle);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempFile.getAbsolutePath();
	}

	public String getDockId() {
		return myID;
	}

	private void ensurePluginLoaded(BundleContext context, String bundleName) {
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName() != null && b.getSymbolicName().equals(bundleName)) {
				if (b.getState() != Bundle.ACTIVE){
					try {
						b.uninstall();
					} catch (BundleException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private void unloadPluginIfExists(BundleContext context, String bundleName) {
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName() != null && b.getSymbolicName().equals(bundleName)) {
				if (b.getState() != Bundle.ACTIVE){
					try {
						b.start();
						while (b.getState() != Bundle.ACTIVE){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} catch (BundleException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
