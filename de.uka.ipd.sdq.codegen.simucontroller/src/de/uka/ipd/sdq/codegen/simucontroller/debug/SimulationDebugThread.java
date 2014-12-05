/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.debug;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.notify.Notification;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockPerformedDebugStepEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockResumedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimTimeChangedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimulationTerminatedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockStartedDebugStepEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSuspendedEvent;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

/**
 * @author Snowball
 *
 */
public class SimulationDebugThread extends SimulationDebugElement implements IThread, Observer {

    private DockModel myDock;
    private boolean isTerminated;

    public SimulationDebugThread(IDebugTarget myDebugTarget, ILaunch launch, DockModel dock) {
        super(myDebugTarget, launch);

        if (this.myDebugTarget == null)
            throw new IllegalArgumentException("Debug target has to be set");

        this.myDock = dock;
        this.myDock.addObserver(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IThread#getBreakpoints()
     */
    public IBreakpoint[] getBreakpoints() {
        return new IBreakpoint[0];
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IThread#getName()
     */
    public String getName() throws DebugException {
        return "Simulation Event Processor - SimTime: " + this.myDock.getSimTime();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IThread#getPriority()
     */
    public int getPriority() throws DebugException {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IThread#getStackFrames()
     */
    public IStackFrame[] getStackFrames() throws DebugException {
        return new IStackFrame[0];
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IThread#getTopStackFrame()
     */
    public IStackFrame getTopStackFrame() throws DebugException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IThread#hasStackFrames()
     */
    public boolean hasStackFrames() throws DebugException {
        return false;
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
        return myDock.isSuspended();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#resume()
     */
    public void resume() throws DebugException {
        myDock.getService().resume();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
     */
    public void suspend() throws DebugException {
        myDock.getService().suspend();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#canStepInto()
     */
    public boolean canStepInto() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#canStepOver()
     */
    public boolean canStepOver() {
        return myDebugTarget == null ? false : myDebugTarget.isSuspended();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#canStepReturn()
     */
    public boolean canStepReturn() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#isStepping()
     */
    public boolean isStepping() {
        return myDock.isStepping();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#stepInto()
     */
    public void stepInto() throws DebugException {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#stepOver()
     */
    public void stepOver() throws DebugException {
        myDock.getService().step();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.debug.core.model.IStep#stepReturn()
     */
    public void stepReturn() throws DebugException {
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
        myDock.getService().stopSimulation();
    }

    public void setSimControl(SimulationDockService service) {
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof DockEvent) {
            DockEvent dockEvent = (DockEvent) arg;
            if (dockEvent.comesFrom(this.myDock)) {
                if (dockEvent instanceof DockResumedEvent) {
                    fireEvent(this, DebugEvent.RESUME);
                }
                if (dockEvent instanceof DockSuspendedEvent) {
                    fireEvent(this, DebugEvent.SUSPEND);
                }
                if (dockEvent instanceof DockPerformedDebugStepEvent) {
                    fireEvent(this, DebugEvent.STEP_END);
                }
                if (dockEvent instanceof DockStartedDebugStepEvent) {
                    fireEvent(this, DebugEvent.STEP_OVER);
                }
                if (dockEvent instanceof DockSimTimeChangedEvent) {
                    if (this.getDebugTarget().isSuspended()) {
                        // Only in suspend mode update the UI, otherwise too many event will cause a
                        // deadlock of the debug view
                        fireEvent(this, DebugEvent.CHANGE);
                    }
                }
                if (dockEvent instanceof DockSimulationTerminatedEvent) {
                    this.isTerminated = true;
                    fireEvent(this, DebugEvent.TERMINATE);
                }
            }
        }
    }

    public void dispose() {
        this.myDock.deleteObserver(this);
        this.myDock = null;
        this.myDebugTarget = null;
    }

    @Override
    public void notifyChanged(Notification notification) {
    }

}
