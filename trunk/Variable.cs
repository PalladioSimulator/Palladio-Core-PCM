#region Copyright 2001-2003 Christoph Daniel Rüegg [Modified BSD License]

/*
Math.NET, a symbolic math library
Copyright (c) 2001-2003, Christoph Daniel Rueegg, http://cdrnet.net/. All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice,
this list of conditions and the following disclaimer. 

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
THE POSSIBILITY OF SUCH DAMAGE.
*/

#endregion

using System.Collections.Specialized;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Core
{
	/// <summary>
	/// Math.NET Type: Executable Procedure
	/// </summary>
	[ParsingType(ParsingExpressionType.Scalar, 1)]
	public interface IProcExpression : IExpression
	{
		/// <summary>
		/// Executes the procedure
		/// </summary>
		/// <returns>True, if the operation was successful</returns>
		bool Execute();
	}

	/// <summary>
	/// An abstract base class for imperative style procedures (in a functional environment)
	/// </summary>
	public abstract class StdProcedure : MathExpression, IProcExpression
	{
		protected StdProcedure(Context context) : base(context)
		{
		}

		/// <summary>
		/// Execures the procedure defined by the inheriting operator
		/// </summary>
		/// <returns>true if the operation was successful</returns>
		public abstract bool Execute();

		/// <summary>
		/// expands the expression (does nothing per default in this case!)
		/// </summary>
		/// <returns>the expanded expression</returns>
		public override IExpression ExpressionExpand()
		{
			return this;
		}

		/// <summary>
		/// simplifies the expression (does nothing per default in this case!)
		/// </summary>
		/// <returns>the simplified expression</returns>
		public override IExpression ExpressionSimplify()
		{
			return this;
		}

		/// <summary>
		/// substitutes a given subterm to another (does nothing per default in this case!)
		/// </summary>
		/// <param name="original">the term to look for (to be replaced)</param>
		/// <param name="replacement">the replacement for the original subterm (same type)</param>
		/// <returns>the substituted term</returns>
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			if (Equals(original))
				return replacement;
			return this;
		}

		/// <summary>
		/// indicates wether the expression is an entity leaf expression (false per default in this case)
		/// </summary>
		public override bool IsEntity
		{
			get { return false; }
		}

		/// <summary>
		/// indicates whether the expressions contains unknown variables or not (true per default in this case)
		/// </summary>
		public override bool IsConstant
		{
			get { return true; }
		}
	}

	/// <summary>
	/// all specific variable implementations derive from this abstract base class
	/// </summary>
	public abstract class Variable : MathExpression
	{
		/// <summary>
		/// the variable's name (eg. 'x')
		/// </summary>
		protected string name = string.Empty;

		/// <summary>
		/// defines wether the variable is locked (threatened as a variable) or unlocked (threatened as its value) at the moment.
		/// </summary>
		protected bool symbolicMode = true;

		protected Variable(Context context, string name) : base(context)
		{
			this.name = name;
			this.context = context;
		}

		/// <summary>
		/// call this method in the constructor of the deriven class to pass the parameter (value) instance.
		/// </summary>
		/// <remarks>the parameter collection must be of size one, otherwise an <see cref="cdrnet.Lib.MathLib.Exceptions.InternalException"/> is thrown</remarks>
		/// <param name="parameters">the parameter collection</param>
		protected override void Init(Parameters parameters)
		{
			base.Init(parameters);
			if (parameters.Count != 1)
				throw new InternalException("Variable parameters must have size 1!");
		}

		/// <summary>
		/// defines wether the variable is locked (threatened as a variable) or unlocked (threatened as its value) at the moment.
		/// </summary>
		public bool IsThreatenedAsVariable
		{
			set { symbolicMode = value; }
			get { return symbolicMode; }
		}

		/// <summary>
		/// the variable's name (eg. 'x')
		/// </summary>
		public string VariableName
		{
			get { return name; }
		}

		/// <summary>
		/// expands the expression if not locked
		/// </summary>
		/// <returns>the expanded expression</returns>
		public override IExpression ExpressionExpand()
		{
			if (symbolicMode)
				return this;
			else
				return ExpressionParameters[0].ExpressionExpand();
		}

		/// <summary>
		/// simplifies the expression if not locked
		/// </summary>
		/// <returns>the simplified expression</returns>
		public override IExpression ExpressionSimplify()
		{
			if (symbolicMode)
				return this;
			else
				return ExpressionParameters[0].ExpressionSimplify();
		}

		/// <summary>
		/// substitutes a given subterm to another if not locked. substitutes itself if matching.
		/// </summary>
		/// <param name="original">the term to look for (to be replaced)</param>
		/// <param name="replacement">the replacement for the original subterm (same type)</param>
		/// <returns>the substituted term</returns>
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			if (Equals(original))
				return replacement;
			if (!symbolicMode)
				return ExpressionParameters[0].ExpressionSubstitute(original, replacement);
			return this;
		}

		/// <summary>
		/// ireturns the variable name if locked, its value otherweise.
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			if (symbolicMode)
				return name;
			else
				return ExpressionParameters[0].ToString();
		}

		/// <summary>
		/// indicates whether the expressions contains unknown variables or not. always false if locked, depending on its value otherwise.
		/// </summary>
		public override bool IsConstant
		{
			get
			{
				if (symbolicMode)
					return false;
				else
					return ExpressionParameters[0].IsConstant;
			}
		}

		// <summary>
		/// indicates wether the expression is an entity leaf expression. always false if locked, depending on its value otherwise.
		/// </summary>
		public override bool IsEntity
		{
			get
			{
				if (symbolicMode)
					return false;
				else
					return ExpressionParameters[0].IsEntity;
			}
		}

		public override bool Equals(object exp)
		{
			Variable x = exp as Variable;
			if (x != null && x.VariableName == this.VariableName)
				return true;
			return false;
		}

		public override int GetHashCode()
		{
			return name.GetHashCode();
		}

		/// <summary>
		/// collects variables in the current expression
		/// </summary>
		/// <param name="vars">the variable manager where the variables are put into</param>
		/// <param name="deep">if true it will even look for hidden variables</param>
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			if (deep || symbolicMode)
				vars.AddVariable(this);
			if (deep || !symbolicMode)
				ExpressionParameters[0].CollectVariables(vars, deep);
		}

		/// <summary>
		/// converts the expression's childs to the given type, eg. "simple".
		/// </summary>
		/// <param name="conversionType">the type the childs shall be converted to</param>
		public override void ConvertChilds(string conversionType)
		{
			if (!symbolicMode)
				base.ConvertChilds(conversionType);
		}
	}

	/// <summary>
	/// A collection of Math.NET variables deriving from <see cref="Variable"/>
	/// </summary>
	public class VariableManager
	{
		private HybridDictionary hd;
		private Context context;

		public VariableManager(Context context)
		{
			hd = new HybridDictionary();
			this.context = context;
		}

		public Variable[] Variables
		{
			get
			{
				Variable[] result = new Variable[hd.Count];
				hd.Values.CopyTo(result, 0);
				return result;
			}
		}

		/// <summary>
		/// returns the variable with the given name if existing, create a new one otherwise with the given scalar value.
		/// </summary>
		/// <param name="name">the name of the variable to look for</param>
		/// <param name="exp">the default value if a new variable needs to be created</param>
		/// <returns>the variable</returns>
		public Variable GetCreateVariable(string name, IScalarExpression exp)
		{
			if (hd.Contains(name))
				return (Variable) hd[name];
			else
			{
				ScalarExpressionVariable sev = new ScalarExpressionVariable(context, name, exp);
				hd.Add(sev.VariableName, sev);
				return sev;
			}
		}

		/// <summary>
		/// returns the variable with the given name if existing, create a new one otherwise with the value of a scalar one.
		/// </summary>
		/// <param name="name">the name of the variable to look for</param>
		/// <returns>the variable</returns>
		public Variable GetCreateVariable(string name)
		{
			if (hd.Contains(name))
				return (Variable) hd[name];
			else
			{
				ScalarExpressionVariable sev = new ScalarExpressionVariable(context, name, ScalarExpressionValue.One(context));
				hd.Add(sev.VariableName, sev);
				return sev;
			}
		}

		/// <summary>
		/// creates a new unique scalar variable with the given prefix.
		/// </summary>
		/// <remarks>let's say you choose the prefix 't'. in this case it creates and returns the variable 't1'. if 't1' already exists it creates 't2' etc.</remarks>
		/// <param name="prefix">the prefix character</param>
		/// <returns>the unique scalar variable</returns>
		public ScalarExpressionVariable CreateNewParameter(string prefix)
		{
			for (int i = 1;; i++)
			{
				if (hd.Contains(prefix + i.ToString()))
					continue;
				ScalarExpressionVariable sev = new ScalarExpressionVariable(context, prefix + i.ToString(), ScalarExpressionValue.One(context));
				hd.Add(sev.VariableName, sev);
				return sev;
			}
		}

		/// <summary>
		/// add a variable to the collection
		/// </summary>
		/// <remarks>AddVariable overwrites existing variables with the same name</remarks>
		/// <param name="variable"></param>
		public void AddVariable(Variable variable)
		{
			if (!hd.Contains(variable.VariableName))
				hd.Add(variable.VariableName, variable);
			else
				hd[variable.VariableName] = variable;
		}

		/// <summary>
		/// checks wether a variable with the given name exists in the collection
		/// </summary>
		/// <param name="name">the name to look for</param>
		/// <returns>true if it exists</returns>
		public bool IsDefined(string name)
		{
			return hd.Contains(name);
		}

		/// <summary>
		/// checks wether a variable exists in the collection with the same name as the given variable
		/// </summary>
		/// <param name="var">the variable with the name to look for</param>
		/// <returns>true if it exists</returns>
		public bool IsDefined(Variable var)
		{
			return hd.Contains(var.VariableName);
		}

		/// <summary>
		/// checks wether an expression refers to the given variable (wich is temporarely locked).
		/// </summary>
		/// <param name="var">the variable to look for</param>
		/// <param name="expression">the expression to check for variable references</param>
		/// <param name="deep">if true, also hidden references are scanned (eg. locked expressions)</param>
		/// <returns>true if there is at least one reference to the given variable</returns>
		public static bool IsDefined(Variable var, IExpression expression, bool deep)
		{
			bool virt = var.IsThreatenedAsVariable;
			var.IsThreatenedAsVariable = true;
			VariableManager m = new VariableManager(expression.Context);
			expression.CollectVariables(m, deep);
			var.IsThreatenedAsVariable = virt;
			return m.IsDefined(var);
		}

		/// <summary>
		/// checks wether an expression refers to a variable with the given name.
		/// </summary>
		/// <param name="name">the name of the variable to look for</param>
		/// <param name="deep">if true, also hidden references are scanned (eg. locked expressions)</param>
		/// <param name="exp">the expression to check for variable references</param>
		/// <returns>true if there is at least one reference to the given variable</returns>
		public static bool Contains(string name, bool deep, IExpression exp)
		{
			VariableManager m = new VariableManager(exp.Context);
			exp.CollectVariables(m, deep);
			return m.IsDefined(name);
		}

		/// <summary>
		/// removes all variables out of the collextion
		/// </summary>
		public void ClearVariables()
		{
			hd.Clear();
		}

		/// <summary>
		/// remove the variable if the given name out of collection
		/// </summary>
		/// <param name="name"></param>
		public void RemoveVariable(string name)
		{
			hd.Remove(name);
		}
	}
}