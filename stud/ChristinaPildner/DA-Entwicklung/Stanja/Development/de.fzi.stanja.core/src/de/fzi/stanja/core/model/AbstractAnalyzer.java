package de.fzi.stanja.core.model;

import java.util.List;

public abstract class AbstractAnalyzer {
	
	protected String name;
	protected String id;
	
	protected List<AbstractPolicy> policies;
	protected List<Output> outputs;
	
	
	public abstract void runAnalyzer();

}
