package de.uka.ipd.sdq.codegen.runconfig;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class SimProcess extends PlatformObject implements IProcess {

	private ILaunch myLaunch;
	private boolean isTerminated;

	public SimProcess(ILaunch myLaunch) {
		super();
		this.myLaunch = myLaunch;
	}

	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	public String getLabel() {
		return "Simulation Process";
	}

	public ILaunch getLaunch() {
		return this.myLaunch;
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	public boolean canTerminate() {
		return false;
	}

	public boolean isTerminated() {
		return this.isTerminated;
	}

	public void terminate() throws DebugException {
		this.isTerminated = true;
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this,DebugEvent.TERMINATE)});
	}

}
