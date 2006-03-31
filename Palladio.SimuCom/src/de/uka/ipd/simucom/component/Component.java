package de.uka.ipd.simucom.component;

import java.util.ArrayList;

import de.uka.ipd.simucom.threads.IThreadActionVisitor;

public class Component {
	protected ArrayList<Method> methods = null;
	
	protected String ID = "<not set>";

	public Component (String id) {
		methods = new ArrayList<Method>();
		this.ID = id;
	}
	
	public void AddMethod(Method m){
		methods.add(m);
	}
	
	public Method[] getMethods(){
		return methods.toArray(new Method[0]);
	}

	public void accept(IThreadActionVisitor t) throws Exception {
		t.visitComponent(this);
	}
	
	@Override
	public String toString() {
		return "Component >"+ID+"<";
	}	
}
