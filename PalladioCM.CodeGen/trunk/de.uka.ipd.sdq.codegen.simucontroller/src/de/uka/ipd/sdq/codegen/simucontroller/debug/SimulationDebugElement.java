/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.debug;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

/**
 * @author Snowball
 *
 */
public class SimulationDebugElement extends PlatformObject implements IDebugElement {
	
	protected IDebugTarget myDebugTarget = null;
	protected ILaunch launch = null;

	public SimulationDebugElement(IDebugTarget myDebugTarget, ILaunch launch) {
		super();
		this.myDebugTarget = myDebugTarget;
		this.launch = launch;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return myDebugTarget;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return launch;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return "de.uka.ipd.sdq.pcm.simucom.SimuComDebugModel";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		if (adapter == IDebugElement.class) {
			return this;
		}
		return super.getAdapter(adapter);
	}

	/**
	 * Fires a debug event
	 * 
	 * @param event the event to be fired
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {event});
	}

	/**
	 * Fires a debug event
	 * 
	 * @param event the event to be fired
	 */
	protected void fireEvent(Object source, int eventKind) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(source,eventKind)});
	}
	
}
