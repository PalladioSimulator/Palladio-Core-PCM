/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 * 
 */


using System;
using System.Collections;

using Palladio.Utils.Collections;

using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Tools;

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
			get { return (Variable[])variableSet.ToArray(typeof(Variable)); }
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
			VariableManager vm = new VariableManager(anExpression.Context);
			variableSet = new Set( vm.Variables );
		}
		
		/// <summary>
		/// Creates a new VariableExpression representing aValue.
		/// </summary>
		/// <param name="aValue">Value of the new Constant.</param>
		public VariableExpression(double aValue)
		{
			expression = new ScalarExpressionValue(new Context(), aValue);	
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
			variableSet = new Set();
			variableSet.Add(expression);
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
		
		#region Static Methods
		
		public static Variable[] GetVariables(IScalarExpression anExpression)
		{
			VariableManager vm = new VariableManager(anExpression.Context);
			anExpression.CollectVariables(vm, true);
			return vm.Variables;
		}
		#endregion
		
		#region Data
		
		protected IScalarExpression expression;
		protected Set variableSet;
		#endregion
	}
}
