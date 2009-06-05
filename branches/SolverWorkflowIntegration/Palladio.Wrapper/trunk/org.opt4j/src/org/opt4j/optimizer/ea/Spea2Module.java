/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.optimizer.ea;

import org.opt4j.config.annotations.Info;
import org.opt4j.start.Constant;

/**
 * Module for the {@link Spea2} selector.
 * 
 * @author lukasiewycz
 * 
 */
@Info("The Strength Pareto Evolutionary Algorithm.")
public class Spea2Module extends SelectorModule {

	@Info("The tournament value")
	@Constant(value = "tournament", namespace = Spea2.class)
	protected int tournament = 0;

	/**
	 * Constructs a {@code Spea2Module}.
	 */
	public Spea2Module() {
		super();
	}

	/**
	 * Returns the number of tournaments.
	 * 
	 * @return the number of tournaments
	 */
	public int getTournament() {
		return tournament;
	}

	/**
	 * Sets the number of tournaments.
	 * 
	 * @param tournament
	 *            the number of tournaments
	 */
	public void setTournament(int tournament) {
		this.tournament = tournament;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		bindSelector(Spea2.class);
	}
}
