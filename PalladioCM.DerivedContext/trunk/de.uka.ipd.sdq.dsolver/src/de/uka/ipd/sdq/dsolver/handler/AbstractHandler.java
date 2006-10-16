package de.uka.ipd.sdq.dsolver.handler;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsolver.visitors.SeffSwitchDSolver;

public abstract class AbstractHandler {

	public AbstractHandler successor;
	
	public void handle(EObject object){}

	public static AbstractHandler createHandler(SeffSwitchDSolver visitor){
	
		// build up chain of responsibility
		ExternalCallActionHandler ech = 
			new ExternalCallActionHandler(
				visitor.getPcmInstance(), visitor.getMyContext(), null);
	
		InternalActionHandler iah = 
			new InternalActionHandler(visitor.getMyContext(), ech);
		
		BranchActionHandler bah = 
			new BranchActionHandler(visitor.getMyContext(), visitor, iah);
		
		LoopActionHandler lah = 
			new LoopActionHandler(visitor.getMyContext(), visitor, bah);
		
		// add further handlers here...
		
		return lah;
	}

}
