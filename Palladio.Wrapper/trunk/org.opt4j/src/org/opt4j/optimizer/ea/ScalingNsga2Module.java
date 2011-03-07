/**
 * 
 */
package org.opt4j.optimizer.ea;

import org.opt4j.config.annotations.Info;
import org.opt4j.start.Constant;

/**
 * Module for the {@link ScalingNsga2} {@code Selector}.
 * 
 * 
 * @see ScalingNsga2
 * @author noorshams
 *
 */
@Info("A Fast Elitist Non-Dominated Sorting Genetic Algorithm for Multi-Objective Optimization")
public class ScalingNsga2Module extends SelectorModule {
	
	@Info("The tournament value")
	@Constant(value = "tournament", namespace = ScalingNsga2.class)
	int tournament;
	
	/**
	 * Returns the tournament value.
	 * 
	 * @return the tournament value
	 */
	public int getTournament() {
		return tournament;
	}

	/**
	 * Sets the tournament value.
	 * 
	 * @param tournament
	 *            the tournament to set
	 */
	public void setTournament(int tournament) {
		this.tournament = tournament;
	}

	@Override
	protected void config() {
		bindSelector(ScalingNsga2.class);
		//register as IndividualStateListener (required!)
		addIndividualStateListener(ScalingNsga2.class);
	}
}
