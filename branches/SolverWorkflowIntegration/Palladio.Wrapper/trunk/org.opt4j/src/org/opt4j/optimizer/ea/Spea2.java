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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import org.opt4j.core.Individual;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code Spea2}-Selector is a Java implementation of the <a
 * href="http://e-collection.ethbib.ethz.ch/ecol-pool/incoll/incoll_324.pdf"
 * >SPEA2-MOEA</a>.
 * 
 * @author glass, lukasiewycz
 * 
 */
public class Spea2 implements Selector {

	protected final int tournament;

	protected final Random random;

	protected double[][] distance;

	protected double maxsize;

	protected Map<Individual, Integer> toID = new HashMap<Individual, Integer>();

	protected Stack<Integer> freeIDs = new Stack<Integer>();

	protected Map<Individual, Double> fitness = new HashMap<Individual, Double>();

	protected List<Individual> nonDominated = new ArrayList<Individual>();

	protected List<Individual> dominated = new ArrayList<Individual>();

	protected boolean isInit = false;

	/**
	 * Constructs a {@code Spea2}-Selector.
	 * 
	 * @param tournament
	 *            the number of individuals that fight against each other to
	 *            become a parent
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public Spea2(
			@Constant(value = "tournament", namespace = Spea2.class) int tournament,
			Random random) {
		this.tournament = tournament;
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.optimizer.ea.Selector#init(int)
	 */
	public void init(int maxsize) {
		if (isInit) {
			throw new IllegalStateException(
					"Spea2 can be initialized only once.");
		}

		this.maxsize = maxsize;
		distance = new double[maxsize][maxsize];

		for (int i = 0; i < maxsize; i++) {
			freeIDs.push(i);
		}

		for (int i = 0; i < maxsize; i++) {
			for (int j = 0; j < maxsize; j++) {
				distance[i][j] = Double.MAX_VALUE;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.optimizer.ea.Selector#getParents(int,
	 * java.util.Collection)
	 */
	public Collection<Individual> getParents(int mu,
			Collection<Individual> population) {
		register(population);
		calculateFitness(population);

		List<Individual> individuals = new ArrayList<Individual>(population);

		return selectParents(mu, individuals);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.optimizer.ea.Selector#getLames(int, java.util.Collection)
	 */
	public Collection<Individual> getLames(int lambda,
			Collection<Individual> population) {
		register(population);

		List<Individual> lames = new ArrayList<Individual>();

		if (lambda > 0) {
			int alpha = population.size() - lambda;

			calculateFitness(population);
			determineFittest(population);

			if (nonDominated.size() >= alpha) {
				lames = dominated;
				lames.addAll(selectLamesFromNonDominated(nonDominated.size()
						- alpha));
			} else {
				lames = selectLamesFromDominated(population.size() - alpha);
			}

		}
		return lames;
	}

	protected List<Individual> selectLamesFromNonDominated(int n) {
		List<Individual> lames = new ArrayList<Individual>();

		Map<Individual, List<Individual>> orderedLists = new HashMap<Individual, List<Individual>>();

		for (Individual individual : nonDominated) {
			List<Individual> list = getNNList(individual, nonDominated);
			orderedLists.put(individual, list);
		}

		while (lames.size() < n) {
			List<Individual> candidates = new ArrayList<Individual>();
			candidates.addAll(nonDominated);

			for (int k = 0; k < nonDominated.size() - 1; k++) {
				double min = Double.MAX_VALUE;

				for (Individual candidate : candidates) {
					double value = getDistance(candidate, orderedLists.get(
							candidate).get(k));
					min = Math.min(min, value);
				}

				for (Iterator<Individual> it = candidates.iterator(); it
						.hasNext();) {
					Individual candidate = it.next();
					double value = getDistance(candidate, orderedLists.get(
							candidate).get(k));
					if (value > min) {
						it.remove();
					}
				}

				if (candidates.size() == 1) {
					break;
				}
			}

			Individual lame = candidates.get(0);
			lames.add(lame);
			nonDominated.remove(lame);

			for (Map.Entry<Individual, List<Individual>> entry : orderedLists
					.entrySet()) {
				List<Individual> list = entry.getValue();
				list.remove(lame);
			}

		}
		return lames;
	}

	protected List<Individual> selectLamesFromDominated(int n) {
		List<Individual> lames = new ArrayList<Individual>();

		Collections.sort(dominated, new FitnessComparator());
		for (int i = 0; i < dominated.size() && i < n; i++) {
			Individual lame = dominated.get(i);
			lames.add(lame);
		}
		return lames;
	}

	protected void determineFittest(Collection<Individual> individuals) {
		dominated.clear();
		nonDominated.clear();

		for (Individual individual : individuals) {
			if (fitness.get(individual) == 0) {
				nonDominated.add(individual);
			} else {
				dominated.add(individual);
			}
		}
	}

	protected List<Individual> selectParents(int mu, List<Individual> population) {
		List<Individual> parents = new ArrayList<Individual>();
		int size = population.size();

		for (int i = 0; i < mu; i++) {
			Individual winner = population.get(random.nextInt(size));

			for (int j = 1; j < tournament; j++) {
				Individual opponent = population.get(random.nextInt(size));

				double oFitness = fitness.get(opponent);
				double wFitness = fitness.get(winner);

				if (oFitness > wFitness || (winner == opponent)) {
					winner = opponent;
				} else if (oFitness == wFitness) {

					double oDist = getDistance(opponent, getNN(opponent,
							population));
					double wDist = getDistance(winner,
							getNN(winner, population));

					if (oDist > wDist) {
						winner = opponent;
					}
				}
			}
			parents.add(winner);
		}
		return parents;
	}

	/**
	 * Sorts a list of individuals by the diversity to one individual. If the
	 * list contains the individual itself it is removed. The returned list is a
	 * copy of the orginial list.
	 * 
	 * @param individual
	 *            the reference individual
	 * @param individuals
	 *            the list to sort
	 * @return the sorted list
	 */
	protected List<Individual> getNNList(Individual individual,
			List<Individual> individuals) {
		List<Individual> list = new ArrayList<Individual>();
		list.addAll(individuals);
		list.remove(individual);

		int id = toID.get(individual);

		DistanceComparator comparator = new DistanceComparator(distance[id]);
		Collections.sort(list, comparator);

		return list;
	}

	protected Individual getNN(Individual individual,
			List<Individual> candidates) {
		Individual found = null;
		double min = Double.MAX_VALUE;

		for (Individual candidate : candidates) {
			if (candidate != individual) {
				double dist = getDistance(individual, candidate);
				if (dist < min) {
					min = dist;
					found = candidate;
				}
			}
		}
		return found;
	}

	protected Double getDistance(Individual a, Individual b) {
		return distance[toID.get(a)][toID.get(b)];
	}

	protected void calculateDistance(Individual a, Individual b) {
		int aID = toID.get(a);
		int bID = toID.get(b);

		double dist = 0;
		double[] va = a.getObjectives().array();
		double[] vb = b.getObjectives().array();
		for (int i = 0; i < va.length; i++) {
			dist += Math.pow((va[i] - vb[i]), 2);
		}
		distance[aID][bID] = Math.sqrt(dist);
		distance[bID][aID] = Math.sqrt(dist);
	}

	protected void calculateFitness(Collection<Individual> individuals) {
		HashMap<Individual, Double> strength = new HashMap<Individual, Double>();
		fitness.clear();

		/*
		 * Strength calculates as the number of other individuals that are
		 * dominated by the individual
		 */
		for (Individual individual : individuals) {
			double s = 0;
			for (Individual other : individuals) {
				if (individual != other) {
					s += updateStrength(individual, other);
				}
			}
			strength.put(individual, s);
		}
		/*
		 * Fitness calculates as the sum of the strength of each other
		 * individual that dominates the individual
		 */
		for (Individual individual : individuals) {
			double f = 0;
			for (Individual other : individuals) {
				if (individual != other) {
					f += updateFitness(individual, other, strength);
				}
			}
			fitness.put(individual, f);
		}

	}

	protected double updateStrength(Individual individual, Individual other) {
		if (individual.getObjectives().dominates(other.getObjectives())) {
			return 1.0;
		}
		return 0.0;
	}

	protected double updateFitness(Individual individual, Individual other,
			Map<Individual, Double> strength) {
		if (other.getObjectives().dominates(individual.getObjectives())) {
			return strength.get(other);
		}
		return 0.0;
	}

	protected void register(Iterable<Individual> candidates) {
		Set<Individual> removes = new HashSet<Individual>();
		removes.addAll(toID.keySet());
		Set<Individual> adds = new HashSet<Individual>();

		for (Individual candidate : candidates) {
			if (removes.contains(candidate)) {
				removes.remove(candidate);
			} else {
				adds.add(candidate);
			}
		}

		for (Individual candidate : removes) {
			unregister(candidate);
		}

		for (Individual candidate : adds) {
			register(candidate);
		}
	}

	protected void register(Individual candidate) {
		if (!isRegistered(candidate)) {
			Set<Individual> registered = toID.keySet();
			toID.put(candidate, freeIDs.pop());

			for (Individual individual : registered) {
				calculateDistance(candidate, individual);
			}
		}
	}

	protected void unregister(Individual candidate) {
		if (isRegistered(candidate)) {
			int id = toID.get(candidate);

			for (int i = 0; i < (maxsize); i++) {
				distance[id][i] = Double.MAX_VALUE;
				distance[i][id] = Double.MAX_VALUE;
			}
			freeIDs.push(id);
			toID.remove(candidate);
		}
	}

	protected boolean isRegistered(Individual individual) {
		return toID.containsKey(individual);
	}

	protected class FitnessComparator implements Comparator<Individual> {

		public int compare(Individual o1, Individual o2) {
			int comp = 0;
			double f1 = fitness.get(o1);
			double f2 = fitness.get(o2);
			if (f1 < f2) {
				comp = 1;
			} else if (f1 > f2) {
				comp = -1;
			}
			return comp;
		}

	}

	protected class DistanceComparator implements Comparator<Individual> {

		protected double[] distance;

		public DistanceComparator(double[] distance) {
			this.distance = distance;
		}

		public int compare(Individual a, Individual b) {
			int comp = 0;
			int aID = toID.get(a);
			int bID = toID.get(b);

			double aDistance = distance[aID];
			double bDistance = distance[bID];
			double diff = aDistance - bDistance;
			if (diff < 0) {
				comp = -1;
			} else if (diff > 0) {
				comp = 1;
			} else {
				comp = aID - bID;
			}
			return comp;
		}

	}

}
