/*
 * $Id$
 * 
 * $Log$
 * Revision 1.5  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.4  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.3  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.2  2004/07/13 02:14:50  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using System;
using System.Collections;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Scalar;
using Palladio.Utils.Collections;

namespace Palladio.Reliability.Math
{
	/// <summary>
	/// A VariableExpression adds information about the variables contained
	/// in an IScalarExpression to the expression.	
	/// </summary>
	public class VariableExpression : IVariableExpression
	{
		#region Properties

		/// <summary>
		/// Represented mathematical expression.
		/// </summary>
		public IScalarExpression Expression
		{
			get { return expression; }
			set
			{
				expression = value;
				variableSet = new Set(expression.Context.ContextVariables.Variables);
			}
		}

		/// <summary>
		/// Set of variables used by the expression above.
		/// </summary>
		public ICollection VariableSet
		{
			get { return variableSet; }
		}

		/// <summary>
		/// Variables used by the expression above.
		/// </summary>
		public Variable[] Variables
		{
			get { return (Variable[]) variableSet.ToArray(typeof (Variable)); }
		}

		/// <summary>
		/// Indicates whether the expression has variables or not.
		/// </summary>
		public bool HasVariables
		{
			get { return variableSet.Count != 0; }
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new VariableExpression representing the scalar expression
		/// anExpression. The Constructor extracts the Variables used by anExpression.
		/// </summary>
		/// <param name="anExpression">Mathematical expression</param>
		public VariableExpression(IScalarExpression anExpression)
		{
			expression = anExpression;
			variableSet = new Set(expression.Context.ContextVariables.Variables);
		}

		/// <summary>
		/// Creates a new VariableExpression representing aValue.
		/// </summary>
		/// <param name="aValue">Value of the new Constant.</param>
		public VariableExpression(double aValue)
		{
			// the conversion to a fraction is needed to make the Math.NET
			// symbolic math library work. Otherwise it gets confused...

			Parser parser = new Parser();
			parser.Provider = new InfixTokenizer();
			expression = (IScalarExpression) parser.Parse(ToFraction(aValue)).ExpressionSimplify();
			variableSet = new Set();
		}

		/// <summary>
		/// Creates a new VariableExpression representing a variable
		/// with the name aVarName.
		/// </summary>
		/// <param name="aVarName">Name of the variable.</param>
		public VariableExpression(string aVarName)
		{
			Context context = new Context();
			expression = (IScalarExpression) context.ContextVariables.GetCreateVariable(aVarName);
			variableSet = new Set(expression.Context.ContextVariables.Variables);
		}

		/// <summary>
		/// Creates an empty VariableExpression.
		/// </summary>
		protected VariableExpression()
		{
			expression = null;
			variableSet = new Set();
		}

		#endregion

		#region Methods

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			if (expression.IsConstant)
				return expression.Calculate().ToString();
			return expression.ToString();
		}

		/// <summary>
		/// Gets the variables used in anExpresspion.
		/// </summary>
		/// <param name="anExpression">Mathematical expression.</param>
		/// <returns>Variables used in anExpression.</returns>
		public static Variable[] GetVariables(IScalarExpression anExpression)
		{
			VariableManager vm = new VariableManager(anExpression.Context);
			anExpression.CollectVariables(vm, true);
			return vm.Variables;
		}

		/// <summary>
		/// Converts a double value to a fraction represented as string
		/// </summary>
		/// <param name="aValue"></param>
		/// <returns></returns>
		private string ToFraction(double aValue)
		{
			long numerator = 0;
			long denominator = 1;
			for (int i = 0; i < 50; i++)
			{
				numerator = (long) aValue;
				double rest = aValue%numerator;
				if (rest.Equals(0.0))
					break;
				denominator *= 10;
				aValue *= 10;
			}
			return String.Format("({0}/{1})", numerator, denominator);
		}

		#endregion

		#region Data

		protected IScalarExpression expression;
		protected Set variableSet;

		#endregion
	}
}