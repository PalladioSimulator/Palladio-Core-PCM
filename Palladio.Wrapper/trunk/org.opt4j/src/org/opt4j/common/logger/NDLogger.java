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

package org.opt4j.common.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.problem.Evaluator;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code NDLogger} writes all {@code Individuals} from the {@code Archive}
 * to the specified file. It can be configured to write the data each {@code
 * iterationStep} iterations or each {@code evaluationStep} evaluations.
 * 
 * @author reimann, lukasiewycz
 */
public class NDLogger extends AbstractLogger implements Logger {

	protected final Archive archive;

	protected final Evaluator<?> evaluator;

	private final PrintWriter out;

	private long timeOffset;

	/**
	 * Constructs an {@code NDLogger}.
	 * 
	 * @param optimizer
	 *            the optimizer
	 * @param individualBuilder
	 *            the individual builder
	 * @param archive
	 *            the archive
	 * @param evaluator
	 *            the evaluator
	 * @param filename
	 *            the filename (using namespace {@code NDLogger})
	 * @param evaluationStep
	 *            the number of evaluations between two logging events (using
	 *            namespace {@code NDLogger})
	 * @param iterationStep
	 *            the number of iterations between two logging events (using
	 *            namespace {@code NDLogger})
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public NDLogger(
			Optimizer optimizer,
			IndividualBuilder individualBuilder,
			Archive archive,
			Evaluator evaluator,
			@Constant(value = "filename", namespace = NDLogger.class) String filename,
			@Constant(value = "evaluationStep", namespace = NDLogger.class) int evaluationStep,
			@Constant(value = "iterationStep", namespace = NDLogger.class) int iterationStep) {
		super(optimizer, individualBuilder, iterationStep, evaluationStep);

		this.archive = archive;
		this.evaluator = evaluator;

		if (filename == null || filename.equals("")) {
			throw new IllegalArgumentException(
					"Filename must not be the empty string.");
		}

		try {
			File file = new File(filename);
			File dir = file.getParentFile();
			if (dir != null) {
				dir.mkdirs();
			}
			file.createNewFile();

			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.common.logger.AbstractLogger#logEvent(int, int)
	 */
	@Override
	public void logEvent(int iteration, int evaluation) {
		double seconds = ((double) System.currentTimeMillis() - timeOffset) / 1000.0;

		for (Individual individual : archive) {
			out.print(iteration + "\t" + evaluation + "\t" + seconds);

			Objectives objectives = individual.getObjectives();
			for (Entry<Objective, Value<?>> entry : objectives) {
				Value<?> value = entry.getValue();
				out.print("\t" + value.getDouble());
			}
			out.println();
		}
		out.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.common.logger.AbstractLogger#optimizationStarted()
	 */
	@Override
	public void optimizationStarted() {
		out.print("#generations\tevaluations\truntime[s]");
		for (Objective objective : evaluator.getObjectives()) {
			out.print("\t" + objective.getName());
		}
		out.println();

		out.print("#-\t-\t-");
		for (Objective objective : evaluator.getObjectives()) {
			out.print("\t" + objective.getSign());
		}
		out.println();

		timeOffset = System.currentTimeMillis();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.common.logger.AbstractLogger#optimizationStopped()
	 */
	@Override
	public void optimizationStopped() {
		out.close();
	}
}
