package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.config.annotations.Name;
import org.opt4j.core.problem.ProblemModule;


public class DSEModule { //extends ProblemModule {

	@Name("Use the GUI?")
	boolean useGui = false;

	public boolean isUseGui() {
		return useGui;
	}

	public void setUseGui(boolean useGui) {
		this.useGui = useGui;
	}

	public void configure() {
		/*bindProblem(DSECreator.class, DSEDecoder.class,
				DSEEvaluator.class);*/

	}

	//@Override
	protected void config() {
		// TODO Auto-generated method stub
		
	}

}
