package de.uka.ipd.sdq.simucom.component;

import org.eclipse.uml2.Activity;

import de.uka.ipd.sdq.simucom.threads.IThreadActionVisitor;

public class ServiceEffect {
	protected Activity myActivity;
	
	public ServiceEffect() {
	}
	
	public void accept(IThreadActionVisitor t) throws Exception {
		t.visitServiceEffect(this);
	}

	@Override
	public String toString() {
		return "ServiceEffect";
	}

	public void setActivity(Activity a) {
		myActivity = a;
	}

	public Activity getSimulatedActivity() {
		return myActivity;
	}
}
