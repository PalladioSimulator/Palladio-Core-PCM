package de.uka.ipd.sdq.codegen.simucontroller.dockmodel;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockAddedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockDeletedEvent;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

/**
 * The dock model class is used to store the central model of the simulation docks. A simulation
 * dock is an OSGi service capable of accepting a simulation bundle. It simulates the bundle
 * informing is dock model via OSGi events of its progress. The dock model uses the events to
 * synchronize its view. It also uses remote OSGi events to discover new remote docks.
 * 
 * @author Steffen Becker
 *
 */
public class DocksModel extends Observable implements EventHandler {
    /** Logger of this class. */
    private static final Logger LOGGER = Logger.getLogger(DocksModel.class);

    /**
     * A hashmap for mapping dock IDs to the respective dock models. Used when events arrive to
     * retrieve the affected dock.
     */
    private HashMap<String, DockModel> clientDocks = new HashMap<String, DockModel>();

    /**
     * A priority queue of available docks. Used in {@link getBestFreeDock} to retrieve the best
     * available next dock.
     */
    private PriorityBlockingQueue<DockModel> freeDocks = new PriorityBlockingQueue<DockModel>(10,
            new Comparator<DockModel>() {

                /**
                 * Basis sorting strategy: Prefer remote docks over local docks
                 * 
                 * @param o1
                 *            First argument
                 * @param o2
                 *            Second argument
                 * @return The sort order of the arguments
                 */
                public int compare(DockModel o1, DockModel o2) {
                    if (o1.isRemote())
                        return -1;
                    if (o2.isRemote())
                        return 1;
                    return 0;
                }

            });

    /**
     * The event listener registered with OSGi by this model
     */
    private ServiceRegistration eventListener = null;

    /**
     * Context object for OSGi interaction
     */
    private BundleContext context = null;

    /**
     * Listener for local dock service discoveries
     */
    private ServiceListener localServiceListener;

    /**
     * Listener for remote dock discoveries
     */
    private ServiceRegistration remoteServiceListener;

    /**
     * Constructor of the dock model
     * 
     * @param context
     *            The bundle context of the plugin which contains the dock model. Used to interact
     *            with OSGi's event service and remote OSGi
     */
    public DocksModel(BundleContext context) {
        this.context = context;
        findExisitingDocks();
        addListeners();
        registerEventListener();
    }

    /**
     * Unregister the listener
     * 
     * @see java.lang.Object#finalize()
     */
    @Override
    protected void finalize() throws Throwable {
        context.removeServiceListener(localServiceListener);
        remoteServiceListener.unregister();
        eventListener.unregister();
        super.finalize();
    }

    /**
     * Register the local and remote listener for discovering dock events
     */
    private void addListeners() {
        try {
            localServiceListener = createServiceListener();
            context.addServiceListener(localServiceListener);

            remoteServiceListener = context.registerService(ServiceDiscoveryListener.class.getName(),
                    createRemoteServiceListener(context), new Hashtable<String, String[]>());
        } catch (Exception e) {
            throw new RuntimeException("Unable to register dock listners ", e);
        }
    }

    private ServiceDiscoveryListener createRemoteServiceListener(final BundleContext context) {
        return new ServiceDiscoveryListener() {

            public void announceService(String iface, URI uri) {
                ServiceReference sRef = context.getServiceReference(RemoteOSGiService.class.getName());
                ServiceTracker remoteService = new ServiceTracker(context, sRef, null);
                remoteService.open();
                RemoteOSGiService roserv = (RemoteOSGiService) remoteService.getService();
                RemoteServiceReference[] rserv;
                try {
                    rserv = roserv.connect(uri);
                } catch (Exception e) {
                    String msg = "Unable to connect to remote server ";
                    if (LOGGER.isEnabledFor(Level.ERROR))
                        LOGGER.error(msg, e);
                    throw new RuntimeException(msg, e);
                }
                // FIXME: Build-Eclipse and local Eclipse have a different opinion which Exceptions
                // should be caught.
                // Thus, used general Exception.
                // } catch (RemoteOSGiException e) {
                // e.printStackTrace();
                // throw new RuntimeException("Unable to connect to remote server ",e);
                // }
                // catch (IOException e) {
                // e.printStackTrace();
                // throw new RuntimeException("Unable to connect to remote server ",e);
                // }
                SimulationDockService service = (SimulationDockService) roserv.getRemoteService(rserv[0]);
                DocksModel.this.addDock(service, uri.toString());
                remoteService.close();
            }

            public void discardService(String iface, URI uri) {
                DockModel dock = DocksModel.this.getDockByURI(uri);
                DocksModel.this.removeDock(dock);
            }
        };
    }

    private ServiceListener createServiceListener() {
        return new ServiceListener() {

            public void serviceChanged(ServiceEvent event) {
                if (event.getServiceReference().getProperty("objectClass")
                        .equals(SimulationDockService.class.getName())) {
                    if (event.getType() == ServiceEvent.REGISTERED) {
                        // TODO
                    }
                    if (event.getType() == ServiceEvent.UNREGISTERING) {
                        // TODO
                    }
                }
            }

        };
    }

    /**
     * Called by service unregister events to remove the dock from this model
     * 
     * @param dock
     *            The dock which has been removed externally
     */
    protected void removeDock(DockModel dock) {
        synchronized (clientDocks) {
            clientDocks.remove(dock.getID());
            if (freeDocks.contains(dock)) {
                freeDocks.remove(dock);
            } else {
                // TODO: Lost a busy dock....
            }
            setChanged();
            notifyObservers(new DockDeletedEvent(dock));
        }
    }

    /**
     * Retrieve a dock status model by the docks URI. Returns null if the dock is unknown or a local
     * dock.
     * 
     * @param uri
     *            The URI of the dock to retrieve
     * @return The requested dock or null if the dock does not exist or is local
     */
    protected DockModel getDockByURI(URI uri) {
        synchronized (clientDocks) {
            for (DockModel m : clientDocks.values()) {
                if (m.getRemoteMaschineURI() != null && m.getRemoteMaschineURI().equals(uri.toString())) {
                    return m;
                }
            }
        }
        return null;
    }

    /**
     * Initialise this dock model's status when this dock model is first initialised
     */
    private void findExisitingDocks() {
        // Initially get all local Docks
        try {
            ServiceReference[] services = context.getAllServiceReferences(SimulationDockService.class.getName(), null);
            for (ServiceReference ref : services) {
                // TODO: This does not track the services lifecyle :-(
                this.addDock((SimulationDockService) context.getService(ref));
            }
        } catch (InvalidSyntaxException e1) {
            if (LOGGER.isEnabledFor(Level.ERROR))
                LOGGER.error("Dock model status could not be initializd properly. Invalid filter expression used.", e1);
        }
    }

    /**
     * Returns a collection of all docks currently known in this dock model
     * 
     * @return A collection of all docks currently known in this dock model
     */
    public Collection<DockModel> getAllDocks() {
        synchronized (clientDocks) {
            return Collections.unmodifiableCollection(this.clientDocks.values());
        }
    }

    /**
     * Gets the next best free dock from the list of unused docks. Waits for a dock to become
     * available if all docks are busy. The dock is removed from the list of free docks.
     *
     * @return The next best dock available to process a request
     * @throws InterruptedException
     *             Execption when the thread is terminated
     */
    public DockModel getBestFreeDock() throws InterruptedException {
        DockModel result = freeDocks.take();
        return result;
    }

    /**
     * Return a list of all local docks
     * 
     * @return A list of local docks
     */
    public List<DockModel> getLocalDocks() {
        return Collections.unmodifiableList(findDocksByDistance(false));
    }

    /**
     * Return a list of all remote docks
     * 
     * @return A list of remote docks
     */
    public List<DockModel> getRemoteDocks() {
        return Collections.unmodifiableList(findDocksByDistance(true));
    }

    private List<DockModel> findDocksByDistance(boolean remote) {
        return null;
    }

    /**
     * Method to handle OSGi Events sent by the SimulationDock to inform about status updates
     * (non-Javadoc).
     *
     * The method is not intended to be called directly!
     *
     * @see org.osgi.service.event.EventHandler#handleEvent(org.osgi.service.event.Event)
     */
    public void handleEvent(Event event) {
        String dockId = (String) event.getProperty("DOCK_ID");
        DockModel dock = this.getDockById(dockId);
        if (event.getTopic().endsWith("UPDATE_SIM_STATUS")) {
            dock.setPercentDone((Integer) event.getProperty("PERCENT_DONE"));
            dock.setSimTime((Double) event.getProperty("CURRENT_TIME"));
            dock.setMeasurementCount((Long) event.getProperty("MEASUREMENTS_TAKEN"));
        }
        if (event.getTopic().endsWith("DOCK_BUSY")) {
            dock.setIdle(false);
            if (freeDocks.contains(dock)) {
                freeDocks.remove(dock);
            }
        }
        if (event.getTopic().endsWith("DOCK_IDLE")) {
            dock.setIdle(true);
            freeDocks.put(dock);
        }
        if (event.getTopic().endsWith("PERFORMED_STEP")) {
            dock.setIsStepping(false);
        }
        if (event.getTopic().endsWith("SIM_STARTED")) {
            dock.setStarted(true);
            dock.setIsSuspended(false);
        }
        if (event.getTopic().endsWith("SIM_STOPPED")) {
            dock.setStarted(false);
        }
        if (event.getTopic().endsWith("SIM_SUSPENDED")) {
            dock.setIsSuspended(true);
        }
        if (event.getTopic().endsWith("SIM_RESUMED")) {
            dock.setIsSuspended(false);
        }
        if (event.getTopic().endsWith("STARTED_STEP")) {
            dock.setIsStepping(true);
        }
    }

    /**
     * Return the dock status model with of the dock with the given ID
     * 
     * @param dockId
     *            ID of the dock to retrieve. The dock with the given ID has to exist
     * @return The model of the requested dock
     */
    public DockModel getDockById(String dockId) {
        synchronized (clientDocks) {
            if (!clientDocks.containsKey(dockId))
                throw new IllegalArgumentException("Dock model does not contain dock with ID " + dockId);
            return clientDocks.get(dockId);
        }
    }

    /**
     * Registers this object as event listener for dock events raised by local and remote simulation
     * docks
     */
    private void registerEventListener() {
        String[] topics = new String[] {
            "de/uka/ipd/sdq/simucomframework/simucomdock/*"
        };
        Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
        ht.put(EventConstants.EVENT_TOPIC, topics);
        eventListener = context.registerService(EventHandler.class.getName(), this, ht);
    }

    /**
     * Adds a new dock. Called by discovery events of local docks.
     * 
     * @param service
     *            The reference to the simulation dock's public interface
     * @return A new dock status model representing the newly discovered dock
     */
    private DockModel addDock(SimulationDockService service) {
        return addDock(service, null);
    }

    /**
     * Adds a new dock. Called by discovery events of remote docks.
     * 
     * @param service
     *            The reference to the simulation dock's public interface
     * @param remoteMaschineURI
     *            The URI of the remote service
     * @return A new dock status model representing the newly discovered dock
     */
    private DockModel addDock(SimulationDockService service, String remoteMaschineURI) {
        DockModel result = new DockModel(service, remoteMaschineURI);

        synchronized (clientDocks) { // Only one thread my update the client dock list
            clientDocks.put(result.getID(), result);
            freeDocks.put(result);
            setChanged();
            notifyObservers(new DockAddedEvent(result));
        }

        return result;
    }

}
