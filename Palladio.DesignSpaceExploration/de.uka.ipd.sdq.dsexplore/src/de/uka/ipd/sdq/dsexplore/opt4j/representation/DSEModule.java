package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.common.archive.BasicArchive;
import org.opt4j.config.annotations.Name;
import org.opt4j.core.Archive;
import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.problem.ProblemModule;


public class DSEModule extends ProblemModule {

	@Name("Use the GUI?")
	boolean useGui = false;

	public boolean isUseGui() {
		return useGui;
	}

	public void setUseGui(boolean useGui) {
		this.useGui = useGui;
	}

	public void configure() {
		bindProblem(DSECreator.class, DSEDecoder.class,
				DSEEvaluator.class);

	}

	//@Override
	protected void config() {
		Class<? extends Creator<?>> creator = DSECreator.class;
		Class<? extends Decoder<?, ?>> decoder = DSEDecoder.class;
		Class<? extends Evaluator<?>> evaluator = DSEEvaluator.class;
		
		bindProblem(creator, decoder, evaluator);
		
		bind(Archive.class).to(BasicArchive.class).in(SINGLETON);
		
	}

}
