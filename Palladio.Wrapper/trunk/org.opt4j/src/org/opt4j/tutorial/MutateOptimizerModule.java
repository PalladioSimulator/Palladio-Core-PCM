package org.opt4j.tutorial;

import org.opt4j.config.annotations.Parent;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.OptimizerModule;

@Parent(TutorialModule.class)
public class MutateOptimizerModule extends OptimizerModule {

	@Iterations
	protected int iterations = 1000;

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public void config() {
		bindOptimizer(MutateOptimizer.class);
	}

}
