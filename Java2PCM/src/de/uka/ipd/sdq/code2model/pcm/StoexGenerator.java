/**
 * All classes that operate on the PCM (as opposed to Java code, ASTs, 
 * or Eclipse GUI stuff).
 */
package de.uka.ipd.sdq.code2model.pcm;

import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;

import de.uka.ipd.sdq.code2model.analysis.VariableExpressionTracer;

/**
 * Translates Java expressions to Stochastic Expressions as defined by the PCM.
 * 
 * @author thomas
 */
public class StoexGenerator {
	private Hashtable<IBinding, Type> paramTypes;

	public StoexGenerator() {
		paramTypes = new Hashtable<IBinding, Type>();
	}

	/**
	 * Register a new service with the generator.
	 * <p>
	 * Registers the types of the parameters.
	 * </p>
	 * 
	 * @param params
	 *            the list of the service's parameters
	 */
	public void newService(List<SingleVariableDeclaration> params) {
		for (SingleVariableDeclaration decl : params) {
			IBinding nameBinding = decl.getName().resolveBinding();
			paramTypes.put(nameBinding, decl.getType());
		}
	}

	/**
	 * Adds a <code>.VALUE</code> to all numerical variables.
	 * 
	 * @param expression the expression to perform the replacement on
	 * @return the (possibly) modified expression
	 */
	private String variableValues(String expression) {
		String newExpression = expression;
		for (IBinding paramBinding : this.paramTypes.keySet()) {
			Type curType = this.paramTypes.get(paramBinding);
			if (typeIsNumber(curType)) {
				String paramName = paramBinding.getName();
				String stoexName = paramName + ".VALUE";
				newExpression = replaceVariableNameInExpression(expression,
						paramName, stoexName);
			}
		}
		return newExpression;
	}

	/**
	 * Scans the given expression for <code>instanceof</code> checks, and
	 * replaces them with the <code>var.TYPE == foo</code> stochastic
	 * expression.
	 * 
	 * @param expression
	 *            the expression to check
	 * @return the expression with the replacement performed
	 */
	private String instanceOf(String expression) {
		Pattern pattern = Pattern.compile(" *instanceof");
		Matcher matcher = pattern.matcher(expression);
		String newExpression = matcher.replaceAll(".TYPE == ");
		return newExpression;
	}

	/**
	 * TODO duplicated in {@link VariableExpressionTracer}!
	 * 
	 * @param expression
	 * @param var
	 * @param replacement
	 * @return the expression with replaced names
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
	 * Check if a {@link Type} is a numerical type.
	 * 
	 * @return true if is numerical, false otherwise
	 */
	private boolean typeIsNumber(Type type) {
		String typeStr = type.toString();
		if (typeStr.equals("byte") || typeStr.equals("int")
				|| typeStr.equals("long") || typeStr.equals("short")
				|| typeStr.equals("AtomicInteger")
				|| typeStr.equals("AtomicLong") || typeStr.equals("BigInteger")
				|| typeStr.equals("Byte") || typeStr.equals("Integer")
				|| typeStr.equals("Long") || typeStr.equals("Short")) {
			return true;
		}
		return false;
	}

	/**
	 * Replaces the <code>.size()</code> and <code>.length</code>
	 * expressions with the stochastic expression
	 * <code>.NUMBER_OF_ELEMENTS</code>.
	 * 
	 * @param conditional
	 * @return the given conditional after the replacements 
	 */
	private String replaceNumberOfElements(String conditional) {
		String cond = conditional.replaceAll("\\.size\\(\\)", ".NUMBER_OF_ELEMENTS");
		cond = cond.replaceAll("\\.length", ".NUMBER_OF_ELEMENTS");
		return cond;
	}

	/**
	 * Convenience method to perform all replacements necessary to generate a
	 * stochastic expression.
	 * 
	 * @param conditional
	 *            the conditional to perform the replacements on
	 * @return the (possibly) modified conditional
	 */
	public String performGeneralReplacements(String conditional) {
		String cond = variableValues(conditional);
		cond = instanceOf(cond);
		cond = replaceNumberOfElements(cond);
		return cond;
	}
}
