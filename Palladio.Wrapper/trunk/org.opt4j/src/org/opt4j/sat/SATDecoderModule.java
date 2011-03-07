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

package org.opt4j.sat;

import static com.google.inject.internal.Preconditions.checkState;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.config.annotations.Info;
import org.opt4j.start.Constant;
import org.opt4j.start.Opt4JModule;

/**
 * The {@code SATDecoderModule} is used to configure the {@code MixedSATDecoder}
 * .
 * 
 * @author lukasiewycz
 * 
 */
@Icon(Icons.PUZZLE_GREEN)
@Info("Module for the configuration of SAT decoding.")
public class SATDecoderModule extends Opt4JModule {

	@Info("The number of instances (pooled).")
	@Constant(value = "instances", namespace = MixedSATManager.class)
	protected int instances = 2;

	/**
	 * Returns the number of instances (pooled).
	 * 
	 * @return the number of instances
	 */
	public int getInstances() {
		return instances;
	}

	/**
	 * Sets the number of instances (pooled).
	 * 
	 * @param instances
	 *            the number of instances
	 */

	public void setInstances(int instances) {
		checkState(instances > 0,
				"The number of instances must be positive: %s", instances);
		this.instances = instances;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		bind(SATManager.class).to(MixedSATManager.class).in(SINGLETON);
	}

}
