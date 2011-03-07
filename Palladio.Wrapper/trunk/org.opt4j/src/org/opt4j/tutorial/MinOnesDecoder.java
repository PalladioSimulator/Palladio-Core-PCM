package org.opt4j.tutorial;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.opt4j.common.random.Rand;
import org.opt4j.core.problem.Genotype;
import org.opt4j.sat.AbstractSATDecoder;
import org.opt4j.sat.Constraint;
import org.opt4j.sat.Literal;
import org.opt4j.sat.Model;
import org.opt4j.sat.SATManager;

import com.google.inject.Inject;

public class MinOnesDecoder extends AbstractSATDecoder<Genotype, MinOnesResult> {

	@Inject
	public MinOnesDecoder(SATManager manager, Rand random) {
		super(manager, random);
	}

	// Here you can set the constraints of your problem. In our case, we will
	// randomly generate a problem as a 3SAT problem (3 literals per clause)
	// with 1000 variables and 1000 clauses. This problem is known to be
	// NP-complete. However, we hope that there exists at least one feasible
	// solution (and with the seed 0 of random it does ;) ).
	@Override
	public void init(Set<Constraint> constraints) {

		Random random = new Random(0);

		for (int i = 0; i < 1000; i++) {
			Constraint clause = new Constraint(">=", 1);
			HashSet<Integer> vars = new HashSet<Integer>();
			do {
				vars.add(random.nextInt(1000));
			} while (vars.size() < 3);

			for (int n : vars) {
				clause.add(new Literal(n, random.nextBoolean()));
			}

			constraints.add(clause);
		}

	}

	@Override
	public MinOnesResult convertModel(Model model) {

		MinOnesResult minOnesResult = new MinOnesResult();

		for (int i = 0; i < 1000; i++) {
			if (model.get(i) == null || model.get(i) == false) {
				minOnesResult.put(i, false);
			} else {
				minOnesResult.put(i, true);
			}
		}

		return minOnesResult;
	}

}
