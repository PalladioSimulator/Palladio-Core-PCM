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

using System;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Core
{
	#region Enumerations
	public enum ParsingExpressionType
	{
		Scalar,			//a+3*b
		Vector,			//[0,a,1]
		List,			//{0,1,2}
		Literal,		//"abc"
		Object
	}
	public enum ParsingObjectType
	{
		Value,			//1
		Variable,		//a
		InnerOperator,	//a*b
		OuterOperator,	//|a|
		PreOperator,	//-a
		Function,		//f(a)
		Parenthesis,	//(a+b)
		Vector,			//[1,2;3,4;5,6]
		List,			//{1,2,3}
		Relation,		//a=b
		Seperator,		//,;
		Complex,		//x+I*y
		Literal,		//"abc"
		Object
	}
	#endregion

	#region Parsing Attributes
	[AttributeUsage(AttributeTargets.Class)]
	public class ParsingObjectAttribute: System.Attribute
	{
		ParsingObjectType ptype;
		string pvalue = string.Empty;
		double priority;
		bool commutative = false, associative = false;
		public ParsingObjectAttribute(ParsingObjectType type, double priority)
		{
			this.ptype = type;
			this.priority = priority;
		}
		public ParsingObjectType Type
		{
			get {return(ptype);}
		}
		public double Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public string Character
		{
			set {pvalue = value;}
			get {return(pvalue);}
		}
		public bool Commutative
		{
			set {commutative = value;}
			get {return(commutative);}
		}
		public bool Associative
		{
			set {associative = value;}
			get {return(associative);}
		}
	}
	[AttributeUsage(AttributeTargets.Interface)]
	public class ParsingTypeAttribute: System.Attribute
	{
		ParsingExpressionType ttype;
		int tdimensions;
		public ParsingTypeAttribute(ParsingExpressionType type, int dimensions)
		{
			this.ttype = type;
			this.tdimensions = dimensions;
		}
		public ParsingExpressionType Type
		{
			get {return(ttype);}
		}
		public int Dimensions
		{
			get {return(tdimensions);}
		}
	}
	#endregion

	/// <summary>
	/// IExpression is the root interface of all interface
	/// and all Math.NET expressions. All classes and interfaces
	/// implement/derive from this interface.
	/// </summary>
	public interface IExpression
	{
		/// <summary>
		/// indicates whether the expressions contains unknown variables or not
		/// </summary>
		bool IsConstant {get;}
		/// <summary>
		/// mathematical priority
		/// </summary>
		int Priority {get;set;}
		/// <summary>
		/// indicates wether the expression is an entity leaf expression
		/// </summary>
		bool IsEntity {get;}
		/// <summary>
		/// converts the expression's childs to the given type, eg. "simple".
		/// </summary>
		/// <param name="conversionType">the type the childs shall be converted to</param>
		void ConvertChilds(string conversionType);
		/// <summary>
		/// collects variables in the current expression
		/// </summary>
		/// <param name="vars">the variable manager where the variables are put into</param>
		/// <param name="deep">if true it will even look for hidden variables</param>
		void CollectVariables(VariableManager vars, bool deep);
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IExpression ExpressionSimplify();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		IExpression ExpressionExpand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// ExpressionSafeExpand() is less powerfull than <see cref="ExpressionExpand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IExpression ExpressionSafeExpand();
		/// <summary>
		/// substitutes a given subterm to another
		/// </summary>
		/// <param name="original">the term to look for (to be replaced)</param>
		/// <param name="replacement">the replacement for the original subterm (same type)</param>
		/// <returns>the substituted term</returns>
		IExpression ExpressionSubstitute(IExpression original, IExpression replacement);
		/// <summary>
		/// the parameter collection
		/// </summary>
		Parameters ExpressionParameters {get;}
		/// <summary>
		/// the expression's context
		/// </summary>
		Context Context {get;set;}
	}
	public abstract class LeafExpression: MathExpression
	{
		protected LeafExpression(Context context): base(context)
		{
			Init(new EmptyParameters());
		}
		public override IExpression ExpressionExpand()
		{
			return this;
		}
		public override IExpression ExpressionSimplify()
		{
			return this;
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			if(Equals(original))
				return replacement;
			return this;
		}
		public override bool IsEntity
		{
			get {return true;}
		}
		public override bool IsConstant
		{
			get {return true;}
		}
	}
	/// <summary>
	/// MathExpression is an abstract superclass that can be
	/// used to derive from by any (maybe also abstract)
	/// typed operator base classes like <see cref="cdrnet.Lib.MathLib.Scalar.ScalarOperator"/>
	/// </summary>
	public abstract class MathExpression: IExpression
	{
		/// <summary>
		/// the mathematical context of this operator instance
		/// </summary>
		/// <remarks>
		/// use this context if you need to interact with the
		/// variable manager, parse expressions or do other
		/// imperativ style context based stuff
		/// </remarks>
		protected Context context;
		private Parameters parameters;
		private int priority;
		/// <summary>
		/// Constructs a math expression instance using the given context and parameters.
		/// </summary>
		/// <remarks>
		/// Note that this is an abstract class and you cant
		/// create instance of this type. However, it's highly
		/// recommended to derive specialised type operator
		/// base classes form this class.
		/// </remarks>
		/// <param name="context">the context to be used by this instance</param>
		protected MathExpression(Context context)
		{
			this.context = context;
		}
		protected virtual void Init(Parameters parameters)
		{
			this.parameters = parameters;
		}

		#region Inner Manipulation Implementations
		protected IExpression InnerSimplify()
		{
			Type[] t = new Type[]{typeof(Context),parameters.GetType()};
			object[] o = new object[]{context,parameters.Simplify()};
			return (IExpression) GetType().GetConstructor(t).Invoke(o);
		}
		protected IExpression InnerExpand()
		{
			Type[] t = new Type[]{typeof(Context),parameters.GetType()};
			object[] o = new object[]{context,parameters.Expand()};
			return (IExpression) GetType().GetConstructor(t).Invoke(o);
		}
		protected IExpression InnerSubstitute(IExpression original, IExpression replacement)
		{
			if(Equals(original))
				return replacement;
			Type[] t = new Type[]{typeof(Context),parameters.GetType()};
			object[] o = new object[]{context,parameters.Substitute(original,replacement)};
			return (IExpression) GetType().GetConstructor(t).Invoke(o);
		}
		#endregion

		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <remarks>
		/// please note that not all type support basic
		/// simplification and just return the expression itself.
		/// </remarks>
		/// <returns>the simplified expression</returns>
		public virtual IExpression ExpressionSimplify()
		{
			return InnerSimplify();
		}
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		public virtual IExpression ExpressionExpand()
		{
			return InnerExpand();
		}
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// ExpressionSafeExpand() is less powerfull than <see cref="ExpressionExpand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		public virtual IExpression ExpressionSafeExpand()
		{
			try
			{
				return ExpressionExpand();
			}
			catch(ExpressionNotExpandableException e)
			{
				return this;
			}
		}
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		public virtual IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return InnerSubstitute(original,replacement);
		}
		/// <summary>
		/// indicates whether the expressions contains locked variables or not
		/// </summary>
		public virtual bool IsConstant
		{
			get {return parameters.IsConstant;}
		}
		/// <summary>
		/// indicates wether the expression is an entity leaf expression
		/// </summary>
		public virtual bool IsEntity
		{
			get {return false;}
		}
		/// <summary>
		/// mathematical priority
		/// </summary>
		public int Priority
		{
			get {return priority;}
			set {priority = value;}
		}
		/// <summary>
		/// the parameters of this operator
		/// </summary>
		public Parameters ExpressionParameters
		{
			get {return parameters;}
		}
		/// <summary>
		/// the mathematical context of this operator instance
		/// </summary>
		/// <remarks>
		/// use this context if you need to interact with the
		/// variable manager, parse expressions or do other
		/// imperativ style context based stuff
		/// </remarks>
		public Context Context
		{
			get {return context;}
			set {context = value;}
		}
		/// <summary>
		/// converts the expression's childs to the given type, eg. "simple".
		/// </summary>
		/// <param name="conversionType">the type the childs shall be converted to</param>
		public virtual void ConvertChilds(string conversionType)
		{
			parameters.ConvertChilds(conversionType);
		}
		public override bool Equals(object obj)
		{
			if(obj.GetType().Equals(this.GetType()))
				return parameters.Equals((obj as IExpression).ExpressionParameters);
			return false;
		}
		public override int GetHashCode()
		{
			return context.GetHashCode()^parameters.GetHashCode();
		}
		/// <summary>
		/// collects variables in the current expression
		/// </summary>
		/// <param name="vars">the variable manager where the variables are put into</param>
		/// <param name="deep">if true it will even look for hidden variables</param>
		public virtual void CollectVariables(VariableManager vars, bool deep)
		{
			parameters.CollectVariables(vars,deep);
		}
		/// <summary>
		/// reflects the <see cref="ParsingObjectAttribute"/> of the inheriting operator.
		/// </summary>
		protected ParsingObjectAttribute GetAttribute()
		{
			Type t = GetType();
			object[] at = t.GetCustomAttributes(typeof(ParsingObjectAttribute),false);
			if(at.Length == 0)
				throw new Exceptions.ParsingAttributeMissingException();
			return at[0] as ParsingObjectAttribute;
		}
		public override string ToString()
		{
			ParsingObjectAttribute a = GetAttribute();
			return parameters.ToString(a.Character,a.Type);
		}

	}
}
