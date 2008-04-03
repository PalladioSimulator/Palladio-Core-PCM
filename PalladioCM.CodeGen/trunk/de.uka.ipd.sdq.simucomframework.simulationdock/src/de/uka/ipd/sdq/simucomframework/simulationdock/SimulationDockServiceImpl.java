package de.uka.ipd.sdq.simucomframework.simulationdock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.log4j.Logger;
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
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;

public class SimulationDockServiceImpl implements SimulationDockService {

	protected static Logger logger = 
		Logger.getLogger(SimulationDockServiceImpl.class.getName());
	
	private BundleContext context;
	private String myID = EcoreUtil.generateUUID();
	private ServiceTracker service;
	private boolean suspended;
	private Object suspendedBarrier = new Object();
	private boolean isStepping;
	private ServiceTracker eventService;
	private EventAdmin eventAdmin;

	public SimulationDockServiceImpl(BundleContext context) {
		this.context = context;
		ServiceReference eventServiceRef = context.getServiceReference(EventAdmin.class.getName());
		eventService = new ServiceTracker(context,eventServiceRef,null);
		eventService.open();
		eventAdmin = (EventAdmin)eventService.getService();
		
		logger.debug("Simulation Dock Started");
	}
	
	@Override
	protected void finalize() throws Throwable {
		eventService.close();
		super.finalize();
	}

	public void simulate(SimuComConfig config, byte[] simulationBundle, boolean isRemoteRun) {
		postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/DOCK_BUSY");

		ensurePluginLoaded(context, "org.eclipse.equinox.event");
		unloadPluginIfExists(context, "de.uka.ipd.sdq.codegen.simucominstance");
		try {
			this.suspended = config.isDebug();
			loadAndSimulateBundle(config, simulationBundle, eventAdmin, isRemoteRun);
		} catch (Exception e) {
			throw new RuntimeException("Simulation failed",e);
		} finally {
			unloadPluginIfExists(context, "de.uka.ipd.sdq.codegen.simucominstance");
			postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/DOCK_IDLE");
		}
	}

	private void loadAndSimulateBundle(SimuComConfig config,
			byte[] simulationBundle, EventAdmin eventAdmin, boolean isRemoteRun) {
		String bundleLocation = persistBundleInTempDir(simulationBundle);
		Bundle simulationBundleRef = null;
		try {
			simulationBundleRef = context.installBundle(new File(bundleLocation).toURI().toString());
			simulationBundleRef.start();
			
			simulate(config, simulationBundleRef, eventAdmin, isRemoteRun);
		} catch (BundleException e) {
			throw new RuntimeException("OSGi failure",e);
		} finally {
			if (simulationBundleRef != null) {
				try {
					if (simulationBundleRef.getState() == Bundle.ACTIVE)
						simulationBundleRef.stop();

					simulationBundleRef.uninstall();
				} catch (BundleException e) {
					throw new RuntimeException("OSGi failure",e);
				}
			}
		}
	}

	private void simulate(final SimuComConfig config, Bundle simulationBundleRef, final EventAdmin eventAdmin, boolean isRemoteRun) {
		ServiceReference[] services = simulationBundleRef.getRegisteredServices();
		assert services.length == 1;
		
		service = new ServiceTracker(context,services[0],null);
		service.open();
		postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_STARTED");
		try {
			SimuComStatus result = ((ISimuComControl)service.getService()).startSimulation(config, new IStatusObserver(){
				int lastPercent = 0;
				
				public void updateStatus(int percentDone, double currentTime, long measurementsTaken) {
					if (config.isDebug()) {
						if (isStepping) {
							isStepping = false;
							postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/PERFORMED_STEP");
						}
	
						synchronized(SimulationDockServiceImpl.this.suspendedBarrier) {
							while (SimulationDockServiceImpl.this.suspended && !isStepping) {
								try {
									postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_SUSPENDED");
									SimulationDockServiceImpl.this.suspendedBarrier.wait();
								} catch (InterruptedException e) { }
							}
						}
						
						if (SimulationDockServiceImpl.this.suspended){
							postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_RESUMED");
							logger.debug("------------------------- Simulation Resumed ----------------------------------");
						}
					}
					
					if (percentDone > lastPercent ||  (config.isDebug() && SimulationDockServiceImpl.this.suspended)){
						Hashtable properties = new Hashtable();
						properties.put("PERCENT_DONE", percentDone);
						properties.put("CURRENT_TIME", currentTime);
						properties.put("MEASUREMENTS_TAKEN", measurementsTaken);
						postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/UPDATE_SIM_STATUS",properties);
						lastPercent = percentDone;
					}
				}
				
			}, isRemoteRun);
			if (result == SimuComStatus.ERROR) {
				throw new RuntimeException("Simulation failed.",((ISimuComControl)service.getService()).getErrorThrowable());
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			service.close();
			postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/SIM_STOPPED");
		}
	}

	public void suspend() {
		this.suspended = true;
		synchronized (this.suspendedBarrier) {
			this.suspendedBarrier.notifyAll();
		}
	}

	public void resume() {
		this.suspended = false;
		synchronized (this.suspendedBarrier) {
			this.suspendedBarrier.notifyAll();
		}
	}

	private void postEvent(String topic) {
		postEvent(topic, new Hashtable());
	}
	
	private void postEvent(String topic, Hashtable newProperties) {
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
			throw new RuntimeException("OSGi failure",e);
		}
		return tempFile.getAbsolutePath();
	}

	public String getDockId() {
		return myID;
	}

	private void unloadPluginIfExists(BundleContext context, String bundleName) {
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName() != null && b.getSymbolicName().equals(bundleName)) {
				try {
					if (b.getState() == Bundle.ACTIVE){
						b.stop();
					}
					b.uninstall();
				} catch (BundleException e) {
					throw new RuntimeException("OSGi failure",e);
				}
			}
		}
	}
	
	private void ensurePluginLoaded(BundleContext context, String bundleName) {
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName() != null && b.getSymbolicName().equals(bundleName)) {
				if (b.getState() != Bundle.ACTIVE){
					try {
						b.start();
					} catch (BundleException e) {
						throw new RuntimeException("OSGi failure",e);
					}
				}
			}
		}
	}

	public void stopSimulation() {
		((ISimuComControl)service.getService()).stopSimulation();
	}

	public void step() {
		if (suspended && !isStepping) {
			this.isStepping = true;
			postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/STARTED_STEP");
			synchronized (this.suspendedBarrier) {
				this.suspendedBarrier.notifyAll();
			}
		}
	}
}
