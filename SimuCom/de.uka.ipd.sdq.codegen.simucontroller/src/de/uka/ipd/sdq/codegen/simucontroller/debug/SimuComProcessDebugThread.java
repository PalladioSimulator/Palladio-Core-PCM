package de.uka.ipd.sdq.codegen.simucontroller.debug;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;

public class SimuComProcessDebugThread extends SimulationDebugElement implements IThread, Adapter {

    private Process myProcess;

    public SimuComProcessDebugThread(IDebugTarget myDebugTarget, ILaunch launch, Process p) {
        super(myDebugTarget, launch);
        this.myProcess = p;
        p.eAdapters().add(this);
    }

    public IBreakpoint[] getBreakpoints() {
        return new IBreakpoint[] {};
    }

    public String getName() throws DebugException {
        return myProcess.getId() + ": " + new ProcessActionPrintVisitor().doSwitch(myProcess.getCurrentAction());
    }

    public int getPriority() throws DebugException {
        return 0;
    }

    public IStackFrame[] getStackFrames() throws DebugException {
        return new IStackFrame[] {};
    }

    public IStackFrame getTopStackFrame() throws DebugException {
        return null;
    }

    public boolean hasStackFrames() throws DebugException {
        return false;
    }

    public ILaunch getLaunch() {
        return this.launch;
    }

    public boolean canResume() {
        return true;
    }

    public boolean canSuspend() {
        return true;
    }

    public boolean isSuspended() {
        return this.myDebugTarget.isSuspended();
    }

    public void resume() throws DebugException {
        this.myDebugTarget.resume();
    }

    public void suspend() throws DebugException {
        this.myDebugTarget.suspend();
    }

    public boolean canStepInto() {
        return false;
    }

    public boolean canStepOver() {
        return false;
    }

    public boolean canStepReturn() {
        return false;
    }

    public boolean isStepping() {
        return false;
    }

    public void stepInto() throws DebugException {
    }

    public void stepOver() throws DebugException {
    }

    public void stepReturn() throws DebugException {
    }

    public boolean canTerminate() {
        return false;
    }

    public boolean isTerminated() {
        return this.myDebugTarget.isTerminated();
    }

    public void terminate() throws DebugException {
    }

    public Notifier getTarget() {
        return this.myProcess;
    }

    public boolean isAdapterForType(Object type) {
        return true;
    }

    public void notifyChanged(Notification notification) {
        if (myDebugTarget.isSuspended()) {
            if (notification.getEventType() == Notification.SET) {
                if (notification.getFeature() == SimucomstatusPackage.eINSTANCE.getProcess_CurrentAction()) {
                    this.fireEvent(this, DebugEvent.CHANGE);
                }
            }
        }
    }

    public void setTarget(Notifier newTarget) {
    }

    public void dispose() {
        this.myProcess.eAdapters().remove(this);
    }

    public Process getProcess() {
        return this.myProcess;
    }

}
