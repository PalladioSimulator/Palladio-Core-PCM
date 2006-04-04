package de.uka.ipd.sdq.simucom.component;

import java.util.ArrayList;

import de.uka.ipd.sdq.simucom.threads.IThreadActionVisitor;

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

	public Method findMethod(String name)
	{
		for(Method m : methods)
			if (m.getID().equals(name))
				return m;
		return null;
	}
	@Override
	public String toString() {
		return "Component >"+ID+"<";
	}	
}
