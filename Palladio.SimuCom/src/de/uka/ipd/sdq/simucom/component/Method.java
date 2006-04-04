package de.uka.ipd.sdq.simucom.component;

import de.uka.ipd.sdq.simucom.threads.IThreadActionVisitor;
import desmoj.core.simulator.Model;

public class Method {
	protected String ID = "<not set>";
	protected ServiceEffect serviceEffectSpecification = null;
	
	public String getID() {
		return ID;
	}
	
	public Method(String id){
		this.ID = id;
	}

	public void accept(IThreadActionVisitor t) throws Exception {
		t.visitMethod(this);
	}

	public ServiceEffect getServiceEffectSpecification() {
		return serviceEffectSpecification;
	}

	public void setServiceEffectSpecification(ServiceEffect effect) {
		serviceEffectSpecification = effect;
	}
	
	@Override
	public String toString() {
		return "Method >"+ID+"<";
	}	
}
