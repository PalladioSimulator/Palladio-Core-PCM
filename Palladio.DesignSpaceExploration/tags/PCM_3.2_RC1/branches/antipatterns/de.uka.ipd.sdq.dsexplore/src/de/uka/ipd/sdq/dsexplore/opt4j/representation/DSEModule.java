package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.config.annotations.Name;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.problem.Evaluator;
import org.opt4j.core.problem.ProblemModule;
import org.opt4j.optimizer.mopso.ParticleBuilder;


public class DSEModule extends ProblemModule {

	@Name("Use the GUI?")
	boolean useGui = false;

	public boolean isUseGui() {
		return useGui;
	}

	public void setUseGui(boolean useGui) {
		this.useGui = useGui;
	}

	@Override
	public void configure() {
		//bind(DSENeighbor.class).asEagerSingleton();
		bindProblem(DSECreator.class, DSEDecoder.class,
				DSEEvaluator.class);

	}

	//@Override
	@Override
	protected void config() {
		
		//bind(DSENeighbor.class).asEagerSingleton();
		
		Class<? extends Creator<?>> creator = DSECreator.class;
		Class<? extends Decoder<?, ?>> decoder = DSEDecoder.class;
		Class<? extends Evaluator<?>> evaluator = DSEEvaluator.class;
		
		bindProblem(creator, decoder, evaluator);
		
		//This did not work, so I moved it to Opt4JStarter.runTask(..)
		//bindIndividualStateListener(DSEIndividualStateListener.class);

		
		
	}

}
