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

namespace cdrnet.Lib.MathLib.Scalar.Relations
{
	[ParsingObject(ParsingObjectType.Relation,90,Character="=")]
	public class ScalarEqual: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public ScalarEqual(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarEqual(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() == parameters.Scalar2.Calculate())
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
			{
				if(xFirst.Calculate() == xLast.Calculate())
					return ScalarExpressionValue.One(context);
				else
					return ScalarExpressionValue.Zero(context);
			}
			if(xFirst.Equals(xLast))
				return ScalarExpressionValue.One(context);
			return new ScalarEqual(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Relation,90,Character=">")]
	public class ScalarGreaterThan: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public ScalarGreaterThan(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarGreaterThan(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() > parameters.Scalar2.Calculate())
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				if(xFirst.Calculate() > xLast.Calculate())
					return ScalarExpressionValue.One(context);
				else
					return ScalarExpressionValue.Zero(context);
			}
			if(xFirst.Equals(xLast))
				return ScalarExpressionValue.Zero(context);
			return new ScalarGreaterThan(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Relation,90,Character="<")]
	public class ScalarLessThan: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public ScalarLessThan(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters; 
			Init(parameters);
		}
		public ScalarLessThan(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() < parameters.Scalar2.Calculate())
				return 1;
			else
				return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				if(xFirst.Calculate() < xLast.Calculate())
					return ScalarExpressionValue.One(context);
				else
					return ScalarExpressionValue.Zero(context);
			}
			if(xFirst.Equals(xLast))
				return ScalarExpressionValue.Zero(context);
			return new ScalarLessThan(context,xFirst,xLast);
		}
	}
}
