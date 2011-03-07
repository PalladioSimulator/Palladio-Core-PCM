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

import static org.opt4j.sat.Constraint.Operator.EQ;
import static org.opt4j.sat.Constraint.Operator.GE;
import static org.opt4j.sat.Constraint.Operator.LE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.opt4j.sat.Constraint;
import org.opt4j.sat.ContradictionException;
import org.opt4j.sat.Instance;
import org.opt4j.sat.Literal;
import org.opt4j.sat.Model;
import org.opt4j.sat.Order;
import org.opt4j.sat.TimeoutException;
import org.opt4j.sat.VarOrder;
import org.opt4j.sat.Constraint.Operator;
import org.opt4j.sat.sat4j.SAT4JSolver.Learning;
import org.opt4j.sat.sat4j.SAT4JSolver.Restarts;
import org.sat4j.core.Vec;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.core.LearningStrategy;
import org.sat4j.minisat.core.RestartStrategy;
import org.sat4j.minisat.learning.ClauseOnlyLearning;
import org.sat4j.minisat.learning.FixedLengthLearning;
import org.sat4j.minisat.learning.MiniSATLearning;
import org.sat4j.minisat.orders.PositiveLiteralSelectionStrategy;
import org.sat4j.minisat.orders.VarOrderHeap;
import org.sat4j.minisat.restarts.ArminRestarts;
import org.sat4j.minisat.restarts.LubyRestarts;
import org.sat4j.minisat.restarts.MiniSATRestarts;
import org.sat4j.minisat.uip.FirstUIP;
import org.sat4j.pb.constraints.CompetResolutionPBMixedHTClauseCardConstrDataStructure;
import org.sat4j.pb.core.PBDataStructureFactory;
import org.sat4j.pb.core.PBSolverResolution;
import org.sat4j.specs.IVec;

/**
 * The {@code SAT4JInstance} is an {@code Instance} of the {@code SAT4JSolver}.
 * 
 * @author lukasiewycz
 * 
 */
public class SAT4JInstance implements Instance {

	protected int maxVar = -1;

	protected PBSolverResolution solver;

	protected Order order;

	protected Model model;

	protected Map<Object, Integer> variables = new HashMap<Object, Integer>();

	protected int nextVariable = 1;

	protected int nVars = 0;

	protected boolean okay = true;

	/**
	 * Constructs a SAT4J instance.
	 * 
	 * @param timeout
	 *            the timeout in seconds
	 * @param clauseLearningLength
	 *            the length of constraints for the learning strategy
	 * @param learning
	 *            the learning strategy
	 * @param restarts
	 *            the restart strategy
	 */
	@SuppressWarnings("unchecked")
	public SAT4JInstance(int timeout, int clauseLearningLength,
			Learning learning, Restarts restarts) {

		LearningStrategy<PBDataStructureFactory> l = null;
		switch (learning) {
		case FIXEDLENGTH:
			l = new FixedLengthLearning<PBDataStructureFactory>(
					clauseLearningLength);
			break;
		case MINISAT:
			l = new MiniSATLearning<PBDataStructureFactory>();
			break;
		case CLAUSEONLY:
			l = new ClauseOnlyLearning<PBDataStructureFactory>();
			break;
		}

		RestartStrategy r = null;
		switch (restarts) {
		case MINISAT:
			r = new MiniSATRestarts();
			break;
		case LUBY:
			r = new LubyRestarts();
			break;
		case RAPID:
			r = new ArminRestarts();
			break;
		}
		solver = new PBSolverResolution(new FirstUIP(), l,
				new CompetResolutionPBMixedHTClauseCardConstrDataStructure(),
				new VarOrderHeap(new PositiveLiteralSelectionStrategy()), r);
		l.setSolver(solver);
		l.setVarActivityListener(solver);
		if (l instanceof MiniSATLearning) {
			((MiniSATLearning) l)
					.setDataStructureFactory(solver.getDSFactory());
		}

		if (timeout <= 0) {
			throw new IllegalArgumentException("Invalid timeout: " + timeout);
		}
		solver.setTimeout(timeout);

		setNVars(100);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Instance#addVars(int)
	 */
	public void addVars(int newVars) {
		if (newVars > 0) {
			setNVars(nVars + newVars);
		}
	}

	/**
	 * Sets the instance to n vars.
	 * 
	 * @param n
	 *            the number of vars.
	 */
	protected void setNVars(int n) {
		solver.newVar(n);
		nVars = n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Instance#addConstraint(org.opt4j.sat.Constraint)
	 */
	public void addConstraint(Constraint constraint) {

		VecInt lits = toVecInt(constraint.getLiterals());

		IVec<BigInteger> coeffs = new Vec<BigInteger>();

		for (Integer value : constraint.getCoefficients()) {
			coeffs.push(new BigInteger(value.toString()));
		}

		Operator operator = constraint.getOperator();

		int value = constraint.getRhs();

		BigInteger d = BigInteger.valueOf(value);
		try {
			if (operator == LE || operator == EQ) {
				solver.addPseudoBoolean(lits, coeffs, false, d);
			}
			if (operator == GE || operator == EQ) {
				solver.addPseudoBoolean(lits, coeffs, true, d);
			}
		} catch (org.sat4j.specs.ContradictionException e) {
			okay = false;
			throw new ContradictionException();
		}
	}

	protected VecInt toVecInt(Iterable<Literal> list) {
		VecInt vector = new VecInt();

		for (Literal literal : list) {
			Object var = literal.variable();
			if (!variables.containsKey(var)) {
				variables.put(var, nextVariable++);
				if (variables.size() > nVars) {
					setNVars(nVars * 2);
				}
			}
			boolean phase = literal.phase();

			vector.push(variables.get(var) * (phase ? 1 : -1));
		}

		return vector;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Instance#setOrder(org.opt4j.sat.Order)
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Instance#solve()
	 */
	public boolean solve() throws TimeoutException {
		if (!okay) {
			return false;
		}
		return solve(new ArrayList<Literal>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Instance#solve(java.util.List)
	 */
	public boolean solve(List<Literal> assumptions) throws TimeoutException {

		if (order instanceof VarOrder) {

			VarOrder varOrder = (VarOrder) order;

			VariableOrder o = new VariableOrder();
			solver.setOrder(o);

			for (Entry<Object, Double> entry : varOrder.getActivityEntrySet()) {
				if (variables.containsKey(entry.getKey())) {
					int var = variables.get(entry.getKey());
					o.setVarActivity(var, entry.getValue());
				}
			}

			for (Entry<Object, Boolean> entry : varOrder.getPhaseEntrySet()) {
				if (variables.containsKey(entry.getKey())) {
					int var = variables.get(entry.getKey());
					o.setVarPhase(var, entry.getValue());
				}
			}

			o.setVarInc(varOrder.getVarInc());
			o.setVarDecay(varOrder.getVarDecay());

		}

		try {
			VecInt assumps = toVecInt(assumptions);

			if (assumps.isEmpty()) {
				okay = okay && solver.isSatisfiable();
			} else {
				okay = solver.isSatisfiable(assumps);
			}

			if (okay) {

				model = new Model();

				for (Entry<Object, Integer> entry : variables.entrySet()) {
					Object identifier = entry.getKey();
					int var = entry.getValue();
					model.set(identifier, solver.model(var));
				}

				return true;
			}
		} catch (org.sat4j.specs.TimeoutException e) {
			throw new TimeoutException();
		}

		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Instance#getModel()
	 */
	public Model getModel() {
		return model;
	}
}
