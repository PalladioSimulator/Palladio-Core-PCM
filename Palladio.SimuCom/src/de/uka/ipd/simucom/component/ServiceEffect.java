package de.uka.ipd.simucom.component;

import org.eclipse.uml2.Activity;

import de.uka.ipd.simucom.threads.IThreadActionVisitor;
import desmoj.core.simulator.Model;

public class ServiceEffect {

	protected String ID = "<not set>";
	protected Model m;
	protected Activity myActivity;
	
	public ServiceEffect(String ID, Model m) {
		this.ID = ID;
		this.m = m;
	}
	
	public void accept(IThreadActionVisitor t) throws Exception {
		t.visitServiceEffect(this);
	}

	public String getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return "ServiceEffect >"+ID+"<";
	}

	public void setActivity(Activity a) {
		myActivity = a;
	}

	public Activity getSimulatedActivity() {
		return myActivity;
	}
}
