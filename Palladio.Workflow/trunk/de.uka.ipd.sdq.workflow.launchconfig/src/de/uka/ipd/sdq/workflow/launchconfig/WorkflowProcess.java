package de.uka.ipd.sdq.workflow.launchconfig;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

import de.uka.ipd.sdq.workflow.launchconfig.logging.Log4JBasedStreamsProxy;
import de.uka.ipd.sdq.workflow.launchconfig.logging.StreamsProxyAppender;

/**
 * An implementation of an IProcess which is able to log to the provided
 * process console, but otherwise unable to terminate, suspend, etc.
 * 
 * Extend this class if you can provide additional control over the running 
 * process.
 * 
 * @author Steffen Becker
 */
public class WorkflowProcess extends PlatformObject implements IProcess {

	private ILaunch myLaunch;
	private boolean isTerminated;
	private Log4JBasedStreamsProxy myStreamsProxy = null;

	public WorkflowProcess(ILaunch myLaunch) {
		super();
		this.myLaunch = myLaunch;
		this.myStreamsProxy = new Log4JBasedStreamsProxy();
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
		return myStreamsProxy;
	}

	public void setAttribute(String key, String value) {
	}

	@SuppressWarnings("unchecked")
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
		
		this.myStreamsProxy.dispose();

		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this,DebugEvent.TERMINATE)});
	}
	
	public void addAppender(StreamsProxyAppender appender) {
		this.myStreamsProxy.addAppender(appender);
	}

}
