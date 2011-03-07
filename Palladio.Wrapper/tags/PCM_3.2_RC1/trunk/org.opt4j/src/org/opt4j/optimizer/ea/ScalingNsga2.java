/**
 * 
 */
package org.opt4j.optimizer.ea;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.opt4j.common.random.Rand;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Population;
import org.opt4j.core.Range;
import org.opt4j.core.Value;
import org.opt4j.start.Constant;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Latest version of NSGA-II with the dimensions scaled on the basis of the 
 * individual ranges when calculating the crowding distance as described in
 * K. Deb, A. Pratap, S. Agarwal, and T. Meyarivan, "A fast and elitist 
 * multiobjective genetic algorithm : Nsga-ii," Evolutionary Computation, 
 * IEEETransactions on, vol. 6, no. 2, pp. 182-197, August 2002.
 * 
 * 
 * @author noorshams
 *
 */
@Singleton
public class ScalingNsga2 extends Nsga2 implements IndividualCollectionListener, IndividualStateListener{
	
	// stores range of each constraint
	// make it thread safe to avoid accidental problems 
	protected Map<Objective, Range> objectiveRanges = new ConcurrentHashMap<Objective, Range>(); 
	
	
	
	/**
	 * Constructs a {@code ScalingNsga2} {@code Selector}.
	 * 
	 * @param random
	 *            the random number generator
	 * @param tournament
	 *            the tournament value
	 */
	//as this class listens on Population, it must be registered there
	@Inject
	public ScalingNsga2(
			Rand random,
			@Constant(value = "tournament", namespace = ScalingNsga2.class) int tournament, Population population) {
		super(random, tournament);
		// XXX: when individuals are added, they are NOT yet evaluated!! 
		// Wait for a state change
		population.addListener(this);
	}
	
	@Override
	protected void calcDistance(List<Integer> list) {
		if (list.size() < 3) {
			return;
		}

		for (int e : list) {
			dist[e] = 0;
		}

		if (m == null) { // initialize the number of objectives
			m = ind[list.get(0)].getObjectives().array().length;
		}

		Objective[] objectives = new Objective[m];
		int h = 0;
		for (Iterator<Map.Entry<Objective, Value<?>>> iterator = ind[list.get(0)].getObjectives().iterator(); iterator.hasNext();) {
			Map.Entry<Objective, Value<?>> entry = (Map.Entry<Objective, Value<?>>) iterator.next();
			objectives[h] = entry.getKey();
			h++;
		}
		
		for (int i = 0; i < m; i++) {
			Collections.sort(list, new DimensionSort(i));
			dist[list.get(0)] = Double.MAX_VALUE;
			dist[list.get(list.size() - 1)] = Double.MAX_VALUE;
			for (int j = 1; j < list.size() - 1; j++) {
				double p = ind[list.get(j - 1)].getObjectives().array()[i];
				double n = ind[list.get(j + 1)].getObjectives().array()[i];
				dist[list.get(j)] += (n - p)/
					(objectiveRanges.get(objectives[i]).getMax()-objectiveRanges.get(objectives[i]).getMin());
			}
		}

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer p, Integer q) {
				double pv = dist[p];
				double qv = dist[q];

				if (pv - qv > 0) {
					return -1;
				} else if (qv - pv > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		});

	}

	@Override
	public void individualAdded(IndividualCollection collection,
			Individual individual) {
		// Added Individuals are not yet evaluated
		// However, to be sure inidividualStateChanged() can be called
		
	}

	@Override
	public void individualRemoved(IndividualCollection collection,
			Individual individual) {

		for (Iterator<Map.Entry<Objective, Value<?>>> iterator = individual.getObjectives().iterator(); iterator.hasNext();) {
			Map.Entry<Objective, Value<?>> entry = iterator.next();
			
			
			Range range = this.objectiveRanges.get(entry.getKey());
			if (range != null) {
				if (entry.getValue().getDouble() == range.getMin() || entry.getValue().getDouble() == range.getMax()) {
					// Check, if current range still is valid
					double currentMin = range.getMin();
					double currentMax = range.getMax();
					boolean currentMinStillExists = false;
					boolean currentMaxStillExists = false;					
										
					// Recalculate range
					double min = Double.MAX_VALUE;
					double max = Double.MIN_VALUE;
					for (Iterator<Individual> iterator2 = collection.iterator(); iterator2
							.hasNext();) {
						Individual individual2 = (Individual) iterator2.next();
						Value<?> v = individual2.getObjectives().get(entry.getKey());
						if (v.getDouble() > max) {
							max = v.getDouble();
						}
						if (v.getDouble() < min) {
							min = v.getDouble();
						}
						
												
						if (v.getDouble() == currentMin) {
							currentMinStillExists = true;
						}						
						if (v.getDouble() == currentMax) {
							currentMaxStillExists = true;
						}						
						if (currentMaxStillExists && currentMinStillExists) {
							break;
						}
					}

					// If current range still is valid, there is no need for change
					if (!currentMaxStillExists || !currentMinStillExists) {
						this.objectiveRanges.remove(entry.getKey());
						objectiveRanges.put(entry.getKey(), new Range(min, max));
					}
										
				}
			}
		}
		
	}

	@Override
	public void inidividualStateChanged(Individual individual) {
		// We need evaluated individuals 
		if (!individual.isEvaluated()) {
			return;
		}
		// Evaluated individuals belong to the population
		
		
		//Check the range of each objective
		for (Iterator<Map.Entry<Objective, Value<?>>> iterator = individual.getObjectives().iterator(); 
		iterator.hasNext();) {
			Map.Entry<Objective, Value<?>> entry = iterator.next();
			
			Range range = this.objectiveRanges.get(entry.getKey());
			if (range == null ){ // Range is not initialized
				Range r = new Range(entry.getValue().getDouble(), entry.getValue().getDouble());
				this.objectiveRanges.put(entry.getKey(), r);
			} else { // Check min/max
				if (entry.getValue().getDouble() < range.getMin()) {
					range.setMin(entry.getValue().getDouble());
				} else if (entry.getValue().getDouble() > range.getMax()) {
					range.setMax(entry.getValue().getDouble());
				}
			}
		}
		
	}
	
}
