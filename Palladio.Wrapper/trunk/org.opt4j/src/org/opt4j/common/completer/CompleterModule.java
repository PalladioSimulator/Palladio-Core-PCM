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

package org.opt4j.common.completer;

import static com.google.inject.internal.Preconditions.checkState;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Required;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.start.Constant;
import org.opt4j.start.Opt4JModule;

/**
 * The {@code CompleterModule} is used to choose and configure a
 * {@link Completer}.
 * 
 * @author lukasiewycz
 * 
 */
@Icon(Icons.PUZZLE_BLUE)
@Info("The Completer decodes and evaluates the individuals in the optimization process.")
public class CompleterModule extends Opt4JModule {

	@Info("Sets the type of the completer.")
	protected Type type = Type.SEQUENTIAL;

	@Info("Sets the numer of maximal parallel processes.")
	@Required(property = "type", elements = { "PARALLEL" })
	@Constant(value = "maxThreads", namespace = ParallelCompleter.class)
	protected int threads = 4;

	/**
	 * The {@code Type} of {@code Completer} to use.
	 * 
	 * @author glass
	 * 
	 */
	public enum Type {
		/**
		 * Use a sequential completer.
		 * 
		 * @see SequentialCompleter
		 */
		@Info("Use a SequentialCompleter")
		SEQUENTIAL,

		/**
		 * Use a parallel completer.
		 * 
		 * @see ParallelCompleter
		 */
		@Info("Use a ParallelCompleter")
		PARALLEL;
	}

	/**
	 * Constructs a {@code CompleterModule}.
	 * 
	 */
	public CompleterModule() {
		super();
	}

	/**
	 * Returns the type of the completer.
	 * 
	 * @return type of the completer
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type of the completer.
	 * 
	 * @param type
	 *            the type of the completer
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Returns the maximal number of parallel threads.
	 * 
	 * @return the maximal number of parallel threads
	 */
	public int getThreads() {
		return threads;
	}

	/**
	 * Sets the maximal number of parallel threads
	 * 
	 * @param threads
	 *            the maximal number of parallel threads
	 */
	public void setThreads(int threads) {
		checkState(threads > 0, "The number of threads must be positive: %s",
				threads);
		this.threads = threads;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		switch (type) {
		case SEQUENTIAL:
			bind(Completer.class).to(SequentialCompleter.class).in(SINGLETON);
			break;
		default: // PARALLEL
			bind(ParallelCompleter.class).in(SINGLETON);
			bind(Completer.class).to(ParallelCompleter.class);
			addOptimizerStateListener(ParallelCompleter.class);
			break;
		}
	}
}
