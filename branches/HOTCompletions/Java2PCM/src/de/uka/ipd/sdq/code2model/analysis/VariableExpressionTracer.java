/**
 * 
 */
package de.uka.ipd.sdq.code2model.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

/**
 * Traces the influence of the input parameters of a service.
 * <p>
 * The parameters of a new service are registered via {@link #newService(List)}.
 * Assignments are recorded via {@link #updateVariable(IBinding, Expression)}.
 * {@link #expandExpression(Expression)} returns a String, given an Expression,
 * of the expression with variables replaced by the service parameters.
 * </p>
 * 
 * @author thomas
 */
public class VariableExpressionTracer {

	private Hashtable<IBinding, Expression> varToExp;
	private Set<IBinding> serviceParams;
	private ExpressionExpanderVisitor expander;
	private static Logger logger;
	

	public VariableExpressionTracer() {
		varToExp = new Hashtable<IBinding, Expression>();
		expander = new ExpressionExpanderVisitor();
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * Register a new service with its parameters in the tracer.
	 * <p>
	 * This resets the tracer, all previously stored information is lost.
	 * </p>
	 * 
	 * @param params
	 *            the list of parameters of the service
	 */
	public void newService(List<SingleVariableDeclaration> params) {
		varToExp.clear();
		serviceParams = new HashSet<IBinding>();
		for (SingleVariableDeclaration decl : params) {
			IBinding nameBinding = decl.getName().resolveBinding();
			serviceParams.add(nameBinding);
		}
	}

	/**
	 * Expand an expression by replacing those variables whose value is
	 * (partially) determined by a service parameter by the expression
	 * containing the parameter.
	 * 
	 * @param exp
	 *            the expression to expand
	 * @return a String where the expandable variables are substituted with their
	 *         expansions
	 */
	public String expandExpression(Expression exp) {
		expander.reset();
		exp.accept(expander);
		List<VariableExpressionMapping> intermediateVars = expander
				.getIntermediateVariables();

		// Then, replace these variables by the expressions recorded in the
		// mapping given by the ExpressionExpanderVisitor. We need not care for
		// the sequence of replacements, or looping several times to get all
		// matches, because the ExpressionExpanderVisitor gives the mappings in
		// the correct order.
		String expression = exp.toString();
		for (VariableExpressionMapping mapping : intermediateVars) {
			String var = mapping.variable.getName().toString();
			String expandedExp = mapping.expression.toString();
			expression = replaceVariableNameInExpression(expression, var,
					expandedExp);
		}

		return expression;
	}
	
	public Set<String> getInfluencingParameters(Expression exp) {
		expander.reset();
		exp.accept(expander);

		Set<String> influencingParamsStr = new HashSet<String>();
		for (IBinding param : expander.getInfluencingParameters()) {
			String paramStr = param.getName();
			influencingParamsStr.add(paramStr);
		}
		return influencingParamsStr;
	}

	/**
	 * TODO Duplicated in StoexGenerator!
	 * 
	 * @param expression
	 * @param var
	 * @param replacement
	 * @return the expression with the replacements performed
	 */
	private String replaceVariableNameInExpression(String expression,
			String var, String replacement) {
		// (1) Everything but alphanumerics (that can be part of names), or
		// the start of the expression - (2) our variable - (3) same as (1)
		// with end of expression instead of start
		Pattern pattern = Pattern.compile("(?<=(\\W|^))" + var + "(?=(\\W|$))");
		Matcher matcher = pattern.matcher(expression);
		String newExpression = matcher.replaceAll(replacement);
		return newExpression;
	}

	/**
	 * Register a variable assignment with its assigned expression, enabling the
	 * tracing of this variable's influence.
	 * 
	 * @param varBinding
	 *            the binding of the variable being assigned to
	 * @param initExp
	 *            the assigned expression
	 */
	public void updateVariable(IBinding varBinding, Expression initExp) {
		if (varBinding != null) {
			logger.debug("Binding for " + varBinding + " is ok.");
			this.varToExp.put(varBinding, initExp);
		} else {
			logger.warn("Got an unresolved binding for expression " + initExp);
		}
	}

	public Expression getVariableContent(IBinding varBinding) {
		return this.varToExp.get(varBinding);
	}

	/**
	 * An {@link ASTVisitor} checking an expression whether it contains any of
	 * the parameters of the service in whose body the expression occurs.
	 * <p>
	 * For this to work, variable assignments (including declarations with
	 * initalizer) have to be registered with the enclosing
	 * {@link VariableExpressionTracer}.
	 * </p>
	 * <p>
	 * The process works recursively, i.e., for a service parameter
	 * <code>a</code> in <code>a = b; b = c;</code>, its influence in
	 * <code>c</code> is recognized.
	 * </p>
	 * 
	 * @author thomas
	 */
	public class ExpressionExpanderVisitor extends ASTVisitor {
		private static final boolean skipChildren = false;
		private Set<IBinding> influencingParameters;
		private Set<IBinding> alreadyVisitedNames;
		private List<VariableExpressionMapping> intermediateVariables;

		public ExpressionExpanderVisitor() {
			influencingParameters = new HashSet<IBinding>();
			intermediateVariables = new ArrayList<VariableExpressionMapping>();
			alreadyVisitedNames = new HashSet<IBinding>();
		}

		/**
		 * Reset the expander for a new expression (mandatory!).
		 */
		public void reset() {
			this.influencingParameters.clear();
			this.intermediateVariables.clear();
			this.alreadyVisitedNames.clear();			
		}

		/**
		 * Get the list of service parameters influencing an expression.
		 * 
		 * @return the influencing params
		 */
		public Set<IBinding> getInfluencingParameters() {
			return this.influencingParameters;
		}

		/**
		 * Get the list of intermediate variables, i.e., variables in the
		 * assignment chain from the analyzed variable to the service parameter.
		 * The parameters themselves are not included.
		 * 
		 * @return the intermediate variables
		 */
		public List<VariableExpressionMapping> getIntermediateVariables() {
			return this.intermediateVariables;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.SimpleName)
		 */
		@Override
		public boolean visit(SimpleName node) {
			logger.debug("ExpanderVisitor: visiting " + node);
			IBinding binding = node.resolveBinding();
			if (binding == null) {
				logger.warn("Binding of " + node + " could not be resolved.");
				return skipChildren;
			}
			
			// RECURSION CHECK
			if (alreadyVisitedNames.contains(binding)) {
				logger.info("Recursion detected - visiting " + node + " again");
				return skipChildren;				
			}
			alreadyVisitedNames.add(binding);
			
			// Either this name is a registered service parameter, or it is the
			// name of another variable. Then visit the assigned expression.
			if (serviceParams.contains(binding)) {
				influencingParameters.add(binding);
			} else {
				Expression assignedExp = varToExp.get(binding);
				if (assignedExp != null) {
					VariableExpressionMapping mapping = new VariableExpressionMapping(
							binding, assignedExp);

					logger.debug("Checking " + assignedExp);
					if (isRelatedToParam(assignedExp)) {
						// We add the mapping at the beginning of the list
						// because when the list is iterated upon later, the
						// expressions must be encountered in the order in
						// which they appear in the source.
						intermediateVariables.add(0, mapping);
					}
				}

			}
			return skipChildren;
		}

		/**
		 * Decide if the given expression is "related" to a service parameter,
		 * i.e., whether it either contains the parameter itself or another
		 * expression that is related to the parameter.
		 * 
		 * @param exp
		 *            the expression to check
		 * @return true if related to some parameter, false otherwise
		 */
		private boolean isRelatedToParam(Expression exp) {
			// First make a copy of influencingParameters, then visit
			// the expression, then check if it has changed. If so, the
			// variable currently visited is somehow connected with a
			// service parameter, so store it.
			Set<IBinding> tempSet = new HashSet<IBinding>();
			tempSet.addAll(influencingParameters);

			exp.accept(this);

			return (!tempSet.equals(influencingParameters));
		}

	}

	/**
	 * Encapsulates a mapping from a variable to the expression currently
	 * assigned to the variable.
	 * 
	 * @author thomas
	 */
	private class VariableExpressionMapping {
		protected IBinding variable;
		protected Expression expression;

		public VariableExpressionMapping(IBinding binding, Expression exp) {
			variable = binding;
			expression = exp;
		}

		/**
		 * In jdt.dom, only bindings can be reliably compared with
		 * <code>equals()</code>. And that's enough here, anyway.
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (obj == null || obj.getClass() != this.getClass()) {
				return false;
			}
			VariableExpressionMapping compMapping = (VariableExpressionMapping) obj;
			return variable.equals(compMapping.variable);
		}
	}

}
