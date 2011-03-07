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

package org.opt4j.operator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.opt4j.core.IncompatibilityException;
import org.opt4j.core.optimizer.Operator;
import org.opt4j.core.problem.Genotype;

import com.google.inject.Inject;

/**
 * Superclass for generic operators.
 * 
 * @author lukasiewycz
 * 
 * @param <O>
 *            The specified {@code Operator}.
 * 
 */
public class AbstractGenericOperator<O extends Operator<?>> implements
		GenericOperator<O> {

	/**
	 * Comparator for a specific order: Superclasses always are sorted after
	 * subclasses.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected class ClassComparator implements
			Comparator<Class<? extends Genotype>> {

		public int compare(Class<? extends Genotype> arg0,
				Class<? extends Genotype> arg1) {
			if (arg0.equals(arg1)) {
				return 0;
			} else if (arg0.isAssignableFrom(arg1)) {
				// arg0 is superclass of arg1
				return 1;
			} else if (arg1.isAssignableFrom(arg0)) {
				// arg1 is superclass of arg0
				return -1;
			} else {
				return arg0.getCanonicalName().compareTo(
						arg1.getCanonicalName());
			}
		}

	}

	protected SortedMap<Class<? extends Genotype>, O> operators = new TreeMap<Class<? extends Genotype>, O>(
			new ClassComparator());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.common.GenericOperator#addOperator(org.opt4j.core.
	 * optimizer.Operator)
	 */
	public void addOperator(O operator) {
		Class<? extends Genotype> clazz = getTarget(operator);
		addOperator(clazz, operator);
	}

	protected void addOperator(Class<? extends Genotype> clazz, O operator) {
		operators.put(clazz, operator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.common.GenericOperator#getHandler(java.lang.Class)
	 */
	public O getOperator(Class<? extends Genotype> clazz) {
		O operator = operators.get(clazz);

		if (operator != null) {
			return operator;
		}
		/*
		 * Searches for a superclass that is registered as an operator.
		 */
		for (Entry<Class<? extends Genotype>, O> entry : operators.entrySet()) {
			Class<? extends Genotype> c = entry.getKey();
			if (c.isAssignableFrom(clazz)) {
				operator = entry.getValue();
				addOperator(clazz, operator);
				return operator;
			}
		}
		throw new IncompatibilityException("No handler found for " + clazz
				+ " in " + this.getClass());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.common.GenericOperator#getHandlers()
	 */
	public Collection<O> getOperators() {
		return operators.values();
	}

	/**
	 * Returns the target {@link Genotype} for an operator based on the
	 * {@link Apply} annotation.
	 * 
	 * @param <O>
	 *            the type of operator
	 * @param operator
	 * @return
	 */
	protected static <O> Class<? extends Genotype> getTarget(O operator) {
		Apply apply = operator.getClass().getAnnotation(Apply.class);

		if (apply != null) {
			return apply.value();
		}

		Type type = Parameters.getType(Operator.class, operator, "G");
		if (type != null) {
			Class<? extends Genotype> target = Parameters.getClass(type)
					.asSubclass(Genotype.class);
			return target;
		}

		throw new IllegalArgumentException(
				"No target specified for the operator "
						+ operator.getClass().getName()
						+ ". Either parameterize the Operator or use the "
						+ Apply.class.getName()
						+ " annotation to specify a target.");
	}

	protected static class OperatorHolder<P> {

		@Inject(optional = true)
		protected Set<P> operators = new HashSet<P>();
		protected List<P> list = new ArrayList<P>();
		protected boolean init = false;

		public synchronized Collection<P> get() {
			if (!init) {
				for (P operator : operators) {
					add(operator);
				}
				init = true;
			}
			return list;
		}

		public void add(P operator) {
			list.add(operator);
		}

	}

}
