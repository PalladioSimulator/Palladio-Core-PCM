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

package org.opt4j.sat.sat4j;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.opt4j.config.annotations.Info;
import org.opt4j.sat.Constraint;
import org.opt4j.sat.Instance;
import org.opt4j.sat.Solver;
import org.opt4j.start.Constant;

import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;

/**
 * The {@code SAT4JSolver} implements a {@code Solver} and its accesses to the
 * Java SAT/PB-Solver of <a href="http://www.sat4j.org">Sat4J.org</a>.
 * 
 * @author lukasiewycz
 * 
 */
public class SAT4JSolver implements Solver {
	private static final long serialVersionUID = 1L;

	@Retention(RUNTIME)
	@BindingAnnotation
	protected @interface Timeout {
	}

	protected int timeout;

	@Retention(RUNTIME)
	@BindingAnnotation
	protected @interface ClauseLearningLength {
	}

	protected int clauseLearningLength;

	/**
	 * The {@code Learning} strategy.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum Learning {
		/**
		 * Fixed length learning
		 * 
		 * @see org.sat4j.minisat.learning.FixedLengthLearning
		 */
		@Info("Learning only constraints with less or equal number of variables.")
		FIXEDLENGTH,
		/**
		 * MiniSAT learning
		 * 
		 * @see org.sat4j.minisat.learning.MiniSATLearning
		 */
		@Info("Use the MiniSAT learning scheme.")
		MINISAT,
		/**
		 * Clause only learning
		 * 
		 * @see org.sat4j.minisat.learning.ClauseOnlyLearning
		 */
		@Info("Learn only clauses.")
		CLAUSEONLY;
	}

	/**
	 * The {@code Restarts} strategy.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum Restarts {

		/**
		 * MiniSAT restarts
		 * 
		 * @see org.sat4j.minisat.restarts.MiniSATRestarts
		 */
		@Info("Use MiniSAT restarts.")
		MINISAT,
		/**
		 * Luby restarts
		 * 
		 * @see org.sat4j.minisat.restarts.LubyRestarts
		 */
		@Info("Use Luby restarts.")
		LUBY,
		/**
		 * Rapid restarts
		 * 
		 * @see org.sat4j.minisat.restarts.ArminRestarts
		 */
		@Info("Use Rapid restarts.")
		RAPID;
	}

	protected Restarts restarts;

	protected Learning learning;

	Instance instance;

	/**
	 * Constructs a new {@code SAT4J2Solver} with a timeout and the number of
	 * kept learning clauses. The learning strategy is fixed size learning and
	 * the restarts are minisat based.
	 * 
	 * @param timeout
	 *            timeout in seconds
	 * @param clauseLearningLength
	 *            clauses are learned if they have a smaller or equal number of
	 *            literals per clause
	 */
	public SAT4JSolver(int timeout, int clauseLearningLength) {
		this(timeout, clauseLearningLength, Learning.FIXEDLENGTH,
				Restarts.MINISAT);
	}

	/**
	 * Constructs a new {@code SAT4J2Solver} with a timeout and the number of
	 * kept learning clauses. Additionally, this constructor allows the
	 * specification of the learning and restart strategy.
	 * 
	 * @param timeout
	 *            timeout in seconds
	 * @param clauseLearningLength
	 *            clauses are learned if they have a smaller or equal number of
	 *            literals per clause
	 * @param learning
	 *            the learning strategy
	 * @param restarts
	 *            the restart strategy
	 */
	@Inject
	public SAT4JSolver(
			@Constant(value = "timeout", namespace = SAT4JSolver.class) int timeout,
			@Constant(value = "clauseLearningLength", namespace = SAT4JSolver.class) int clauseLearningLength,
			@Constant(value = "learning", namespace = SAT4JSolver.class) Learning learning,
			@Constant(value = "restarts", namespace = SAT4JSolver.class) Restarts restarts) {
		this.timeout = timeout;
		this.clauseLearningLength = clauseLearningLength;
		this.learning = learning;
		this.restarts = restarts;

		instance = createInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#addConstraint(org.opt4j.sat.Constraint)
	 */
	public void addConstraint(Constraint constraint) {
		if (instance == null) {
			instance = createInstance();
		}
		instance.addConstraint(constraint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#getInstance()
	 */
	public Instance getInstance() {
		if (instance == null) {
			return createInstance();
		}
		Instance i = instance;
		instance = null;
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#returnInstance(org.opt4j.sat.Instance)
	 */
	public void returnInstance(Instance instance) {
		this.instance = instance;
	}

	/**
	 * Creates a new SAT4JInstace.
	 * 
	 * @return the created instance
	 */
	private Instance createInstance() {
		return new SAT4JInstance(timeout, clauseLearningLength, learning,
				restarts);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Solver#addVars(int)
	 */
	public void addVars(int newVars) {
		instance.addVars(newVars);
	}
}
