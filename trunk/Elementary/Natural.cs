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
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Scalar.Elementary
{
	[ParsingObject(ParsingObjectType.Function,250,Character="gcd")]
	public class ElementaryGreatestCommonDivisor: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ElementaryGreatestCommonDivisor(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ElementaryGreatestCommonDivisor(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			return MathHelper.EvaluateGcd(Math.Floor(parameters.Scalar1.Calculate()),Math.Floor(parameters.Scalar2.Calculate()));
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="floor")]
	public class ElementaryFloor: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ElementaryFloor(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ElementaryFloor(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Floor(parameters.Scalar1.Calculate());
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="ceiling")]
	public class ElementaryCeiling: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ElementaryCeiling(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ElementaryCeiling(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Ceiling(parameters.Scalar1.Calculate());
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="bround")]
	public class ElementaryIEEE754Round: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ElementaryIEEE754Round(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ElementaryIEEE754Round(Context context, IScalarExpression expr, IScalarExpression digits): base(context)
		{
			this.parameters = new Scalar2Parameters(expr,digits);
			Init(parameters);
		}
		public ElementaryIEEE754Round(Context context, IScalarExpression expr): base(context)
		{
			this.parameters = new Scalar2Parameters(expr,ScalarExpressionValue.Zero(context));
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Round(parameters.Scalar1.Calculate(),(int)Math.Floor(parameters.Scalar2.Calculate()));
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="round")]
	public class ElementaryRound: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ElementaryRound(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ElementaryRound(Context context, IScalarExpression expr, IScalarExpression digits): base(context)
		{
			this.parameters = new Scalar2Parameters(expr,digits);
			Init(parameters);
		}
		public ElementaryRound(Context context, IScalarExpression expr): base(context)
		{
			this.parameters = new Scalar2Parameters(expr,ScalarExpressionValue.Zero(context));
			Init(parameters);
		}
		public override double Calculate()
		{
			double a = parameters.Scalar1.Calculate();
			int b = (int)Math.Floor(parameters.Scalar2.Calculate());
			double ar = Math.Round(a,b);
			double a1 = Math.Floor(a*Math.Pow(10,b+1));
			double a2 = Math.Floor(a1/10);
			int right = (int)(a1-10*a2);
			return(right==5 && ar<a ? ar+Math.Pow(10,-b) : ar);
		}
	}
}
