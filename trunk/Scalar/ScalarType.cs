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
using System.Collections;
using System.Collections.Specialized;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Complex;

namespace cdrnet.Lib.MathLib.Scalar
{
	/// <summary>
	/// Math.NET type: a scalar expression (floating point number)
	/// </summary>
	[ParsingType(ParsingExpressionType.Scalar,1)]
	public interface IScalarExpression: IExpression
	{
		/// <summary>
		/// calculate the scalar expressions as real double
		/// </summary>
		/// <returns>result as double value</returns>
		double Calculate();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		IScalarExpression Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IScalarExpression SafeExpand();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IScalarExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IScalarExpression Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// derives the expression to the given variable
		/// </summary>
		/// <param name="var">the variable to derive to</param>
		/// <returns>the deriven expression</returns>
		IScalarExpression Differentiate(ScalarExpressionVariable var);
		/// <summary>
		/// integrates the expression to the given variable
		/// </summary>
		/// <param name="var">the variable to integrate to</param>
		/// <returns>the integrated expression</returns>
		IScalarExpression Integrate(ScalarExpressionVariable var);
		/// <summary>
		/// returns a complex expression with the given expression as its real component
		/// </summary>
		/// <returns>the scalar as a complex expression</returns>
		IComplexExpression ToComplex();
	}

	#region Specific Math Objects
	[ParsingObject(ParsingObjectType.Value,10)]
	public class ScalarExpressionValue: LeafExpression, IScalarExpression
	{
		public ScalarExpressionValue(Context context, double init): base(context)
		{
			val = init;
		}
		#region Static ScalarValue Templates
		public static ScalarExpressionValue Zero(Context context)
		{
			return new ScalarExpressionValue(context,0);
		}
		public static ScalarExpressionValue One(Context context)
		{
			return new ScalarExpressionValue(context,1);
		}
		public static ScalarExpressionValue MinusOne(Context context)
		{
			return new ScalarExpressionValue(context,-1);
		}
		public static ScalarExpressionValue Two(Context context)
		{
			return new ScalarExpressionValue(context,2);
		}
		public static ScalarExpressionValue PositiveInfinity(Context context)
		{
			return new ScalarExpressionValue(context,double.PositiveInfinity);
		}
		public static ScalarExpressionValue NegativeInfinity(Context context)
		{
			return new ScalarExpressionValue(context,double.NegativeInfinity);
		}
		#endregion
		private double val;
		public double Value
		{
			set {val = value;}
			get {return(val);}
		}
		public double Calculate()
		{
			return val;
		}
		public override string ToString()
		{
			return val.ToString();
		}
		public IScalarExpression Expand()
		{
			return this;
		}
		public IScalarExpression SafeExpand()
		{
			return this;
		}
		public IScalarExpression Simplify()
		{
			return this;
		}
		public IScalarExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IScalarExpression) base.ExpressionSubstitute(original, replacement);
		}
		public IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return ScalarExpressionValue.Zero(context);
		}
		public IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			ScalarMultiplication exp = new ScalarMultiplication(context,new ScalarExpressionValue(context,val),var);
			return exp;
		}
		public IComplexExpression ToComplex()
		{
			return new ScalarComplex(context,this,Zero(context));
		}
		public override bool Equals(object obj)
		{
			ScalarExpressionValue x = obj as ScalarExpressionValue;
			if(x != null && x.val == val)
				return true;
			return false;
		}
		public override int GetHashCode()
		{
			return val.GetHashCode();
		}
	}
	#endregion
}
