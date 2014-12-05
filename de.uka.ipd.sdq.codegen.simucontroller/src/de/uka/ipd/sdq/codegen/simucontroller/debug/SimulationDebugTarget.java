/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.debug;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.notify.Notification;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimulationStartedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimulationTerminatedEvent;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

/**
 * Class to support SimuCom debugging interactions
 * 
 * @author Steffen Becker
 */
public class SimulationDebugTarget extends SimulationDebugElement implements IDebugTarget, Observer {

    private SimulationDockService simControl;
    private SimulationDebugThread myEventProcessorThread = null;
    private DockModel myDock;
    private boolean isTerminated;
    private ArrayList<IThread> runningSimThreads = new ArrayList<IThread>();
    private SimuComStatus simulationStatus;

    public SimulationDebugTarget(ILaunch launch, DockModel dock) {
        super(null, launch);
        myDebugTarget = this;
        this.myDock = dock;
        this.simControl = dock.getService();
        this.myDock.addObserver(this);
        myEventProcessorThread = new SimulationDebugThread(this, launch, dock);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugTarget#getName()
     */
    public String getName() throws DebugException {
        return "SimuCom Simulation Run";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
     */
    public IProcess getProcess() {
        return launch.getProcesses()[0];
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
     */
    public IThread[] getThreads() throws DebugException {
        ArrayList<IThread> result = new ArrayList<IThread>();
        if (!this.isTerminated) {
            result.add(myEventProcessorThread);
            result.addAll(runningSimThreads);
        }
        return result.toArray(new IThread[] {});
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
     */
    public boolean hasThreads() throws DebugException {
        return !isTerminated();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model
     * .IBreakpoint)
     */
    public boolean supportsBreakpoint(IBreakpoint breakpoint) {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
     */
    public boolean canTerminate() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
     */
    public boolean isTerminated() {
        return this.isTerminated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ITerminate#terminate()
     */
    public void terminate() throws DebugException {
        simControl.stopSimulation();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
     */
    public boolean canResume() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
     */
    public boolean canSuspend() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
     */
    public boolean isSuspended() {
        return this.myDock.isSuspended();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#resume()
     */
    public void resume() throws DebugException {
        // Do not execute resume in a UI thread
        new Thread(new Runnable() {

            public void run() {
                simControl.resume();
            }

        }).run();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
     */
    public void suspend() throws DebugException {
        simControl.suspend();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.
     * IBreakpoint)
     */
    public void breakpointAdded(IBreakpoint breakpoint) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model
     * .IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
     */
    public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model
     * .IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
     */
    public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
     */
    public boolean canDisconnect() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
     */
    public void disconnect() throws DebugException {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
     */
    public boolean isDisconnected() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
     */
    public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
     */
    public boolean supportsStorageRetrieval() {
        return false;
    }

    public void dispose() {
        assert isTerminated;

        this.myEventProcessorThread.dispose();

        this.simControl = null;
        this.myDock.deleteObserver(this);
        this.myDock = null;
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof DockEvent) {
            DockEvent dockEvent = (DockEvent) arg;
            if (dockEvent.comesFrom(this.myDock)) {
                if (dockEvent instanceof DockSimulationTerminatedEvent) {
                    this.isTerminated = true;
                    if (!this.myDock.isRemote()) {
                        this.simulationStatus.eAdapters().remove(this);
                        this.simulationStatus.getProcessStatus().eAdapters().remove(this);
                        this.simulationStatus.getResourceStatus().eAdapters().remove(this);
                    }
                    fireEvent(this, DebugEvent.TERMINATE);
                }
                if (dockEvent instanceof DockSimulationStartedEvent) {
                    if (!this.myDock.isRemote()) {
                        this.simulationStatus = this.simControl.getSimuComStatus();
                        this.simulationStatus.eAdapters().add(this);
                        this.simulationStatus.getProcessStatus().eAdapters().add(this);
                        this.simulationStatus.getResourceStatus().eAdapters().add(this);
                    }
                }
            }
        }
    }

    @Override
    public void notifyChanged(Notification notification) {
        if (notification.getEventType() == Notification.ADD) {
            if (notification.getFeature() == SimucomstatusPackage.eINSTANCE.getSimulatedProcesses_Processes()) {
                this.runningSimThreads.add(new SimuComProcessDebugThread(this, launch, (Process) notification
                        .getNewValue()));
                fireEvent(this, DebugEvent.CHANGE);
            }
        }
        if (notification.getEventType() == Notification.REMOVE) {
            if (notification.getFeature() == SimucomstatusPackage.eINSTANCE.getSimulatedProcesses_Processes()) {
                SimuComProcessDebugThread candidate = null;
                for (IThread thread : runningSimThreads) {
                    if (thread instanceof SimuComProcessDebugThread) {
                        candidate = (SimuComProcessDebugThread) thread;
                        if (candidate.getProcess() == notification.getOldValue()) {
                            break;
                        }
                    }
                }
                this.runningSimThreads.remove(candidate);
                candidate.dispose();
                fireEvent(this, DebugEvent.CHANGE);
            }
        }
    }
}
