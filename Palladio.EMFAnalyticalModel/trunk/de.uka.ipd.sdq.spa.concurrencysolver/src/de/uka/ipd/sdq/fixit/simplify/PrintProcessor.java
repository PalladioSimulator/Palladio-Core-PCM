package de.uka.ipd.sdq.fixit.simplify;


import de.uka.ipd.sdq.analysis.model.*;

public class PrintProcessor  implements RegExProcessor {
	
	public void processAcquire(Acquire acquire){
		System.out.print("ac("+acquire.getResource().getName()+")");
	}
	
	public void processRelease(Release release){
		System.out.print("rel("+release.getResource().getName()+")");		
	}
	
	public void processSleep(Sleep sleep){
		System.out.print("zzzzzzzZZZZ");
	}
	
	public void processTerminal(Terminal terminal){
		System.out.print(terminal.getSymbol());
	}
	
	public void processSequence(Sequence sequence){
		System.out.print(";");
	}
	
	public void processAlternative(Alternative alternative){
		System.out.print("+");
	}
	
	public void processLoop(Loop loop){
		System.out.print("*");
	}
	
	public void processParallel(Parallel parallel){
		System.out.print("|");
	}
	
	public void openBrace(){
		System.out.print("(");
	}
	
	public void closeBrace(){
		System.out.print(")");
	}

}
