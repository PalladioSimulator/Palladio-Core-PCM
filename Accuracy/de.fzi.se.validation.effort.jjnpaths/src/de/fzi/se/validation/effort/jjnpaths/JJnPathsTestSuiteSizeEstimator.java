/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import de.fzi.se.controlflowdescription.graph.Vertex;
import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;

/**Estimates the required test suite size for a given {@link JJnPathSet}.
 * @author groenda
 *
 */
public class JJnPathsTestSuiteSizeEstimator {
	/** Path set used for the estimation. */
	private JJnPathSet jjnpathset;
	/** The minimal number of test cases necessary to reach a vertex. The probability for {@link Vertex} with number 1 is at position 0, for number 2 at position 1 and so forth. */
	private double[] probabilitesOfReachingVertices;

	/**Contructor.
	 * @param jjnpathset The path set used for the size estimations.
	 */
	JJnPathsTestSuiteSizeEstimator(final JJnPathSet jjnpathset) {
		this.jjnpathset = jjnpathset;
		this.probabilitesOfReachingVertices = probabilitesToReachVertices();
	}

	/**Calculates the probability to reach a vertex for one iteration / test.
	 * @return Array with probabilities ordered by number of vertices.
	 */
	private double[] probabilitesToReachVertices() {
		double[] probabilites = new double[jjnpathset.getControlflowdescription().getGraph().getVertices().size()];
		probabilites[0] = 1;
		Vertex vertex;
		for (int number = 1; number <= probabilites.length; number++) {
			vertex = getVertex(number);
			for (int index = 0; index < vertex.getTo().size(); index++) {
				probabilites[vertex.getTo().get(index).getNumber() - 1] += probabilites[number - 1] * vertex.getTransitionProbability().get(index).getProbability();
				if (probabilites[vertex.getTo().get(index).getNumber() - 1] > 1) {
					probabilites[vertex.getTo().get(index).getNumber() - 1] = 1;
				}
			}
		}
		return probabilites;
	}

	/**
	 * @param number Number of the vertex.
	 * @return The vertex with the given number.
	 */
	private Vertex getVertex(int number) {
		for (Vertex vertex : jjnpathset.getControlflowdescription().getGraph().getVertices()) {
			if (vertex.getNumber() == number) {
				return vertex;
			}
		}
		return null;
	}

	/**Estimates the test set size.
	 * @param confidence The confidence.
	 * @return The minimal required number of tests for the given confidence.
	 */
	public long estimate(double confidence) {
		if (confidence == 0) {
			return 0;
		}
		long sizeEstimate = 0;
		for (Vertex vertex : jjnpathset.getControlflowdescription().getGraph().getVertices()) {
			sizeEstimate = (long) Math.max(sizeEstimate, Math.ceil(probabilitesOfReachingVertices[vertex.getNumber() - 1] * getTestSuiteSizeEstimate(vertex, confidence)));
		}
		return sizeEstimate;
	}

	/**Calculates the test suite size for a vertex.
	 * @param v The vertex.
	 * @param confidence The confidence that each path crossing the vertex has been tested at least once.
	 * @return Size in number of iterations.
	 */
	private long getTestSuiteSizeEstimate(Vertex v, double confidence) {
		long sizeEstimate = 0;
		for (JJnPath jjnpath : jjnpathset.getJjnpaths()) {
			if (contains(jjnpath, v)) {
				sizeEstimate += getTestSuiteSizeEstimate(jjnpath, confidence);
			}
		}
		return (long) Math.ceil(sizeEstimate / v.getIterations());
	}

	/**Checks the containment of a vertex in a path.
	 * @param jjnpath The path.
	 * @param vertex The vertex.
	 * @return <code>true</code> if vertex is contained in the path.
	 */
	private boolean contains(JJnPath jjnpath, Vertex vertex) {
		for (JJPath jjpath : jjnpath.getJjpaths()) {
			if (jjpath.getFrom().getNumber() <= vertex.getNumber()
					&& jjpath.getTo().getNumber() >= vertex.getNumber()) {
				return true;
			}
			if (jjpath.getJumpTo() == vertex) {
				return true;
			}
		}
		return false;
	}

	/**Calculates the test suite size for testing a JJnPath.
	 * @param jjnpath The JJnPath.
	 * @param confidence The confidence for testing the path at least once.
	 * @return Size in number of iterations.
	 */
	private long getTestSuiteSizeEstimate(JJnPath jjnpath, double confidence) {
		double p = getTransitionProbability(jjnpath);
		if (p == 1.0d) {
			return 1; // at least one test is necessary
		} else {
			return (long) Math.ceil(Math.log(1.0d - confidence) / Math.log(1-p));
		}
	}

	/**Calculates the possibility of taking a certain path.
	 * @param jjnpath The JJn-Path.
	 * @return Probability to take the path.
	 */
	private double getTransitionProbability(final JJnPath jjnpath) {
		double probability = 1;
		for (JJPath jjpath : jjnpath.getJjpaths()) {
			probability *= getTransitionProbability(jjpath);
		}
		return probability;
	}

	/**Calculates the probability of taking a certain path.
	 * @param jjpath The JJ-Path.
	 * @return Probability to take the specified JJ-Path.
	 */
	private double getTransitionProbability(final JJPath jjpath) {
		assert (jjpath.getFrom() != null && jjpath.getJumpTo() != null);
		double probability = 1;
		int index;
		Vertex vertex = jjpath.getFrom();
		// probability to take jump-free path
		while (vertex != jjpath.getTo() && jjpath.getTo() != null) {
			for (index = 0; index < vertex.getTo().size(); index++) {
				if (vertex.getTo().get(index).getNumber() == vertex.getNumber() + 1) {
					break;
				}
			}
			probability *= vertex.getTransitionProbability().get(index).getProbability();
			vertex = vertex.getTo().get(index);
		}
		// probability to take jump
		if (vertex.getNumber() != jjpath.getJumpTo().getNumber()) {
			for (index = 0; index < vertex.getTo().size(); index++) {
				if (vertex.getTo().get(index).getNumber() == jjpath.getJumpTo().getNumber()) {
					break;
				}
			}
			probability *= vertex.getTransitionProbability().get(index).getProbability();
		}
		return probability;
	}
}
