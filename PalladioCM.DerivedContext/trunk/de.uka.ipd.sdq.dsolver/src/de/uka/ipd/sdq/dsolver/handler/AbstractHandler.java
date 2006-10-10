package de.uka.ipd.sdq.dsolver.handler;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractHandler {

	public AbstractHandler successor;
	
	public void handle(EObject object){}

}
