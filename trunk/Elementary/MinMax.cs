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

namespace cdrnet.Lib.MathLib.Scalar
{
	[ParsingObject(ParsingObjectType.Function,250,Character="min")]
	public class ScalarMin: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarMin(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarMin(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public ScalarMin(Context context, IScalarExpression left): base(context)
		{
			this.parameters = new Scalar2Parameters(left,ScalarExpressionValue.Zero(context));
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Min(parameters.Scalar1.Calculate(),parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
			{
				if(xFirst.Calculate() < xLast.Calculate())
					return xFirst;
				else
					return xLast;
			}
			return new ScalarMin(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="max")]
	public class ScalarMax: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarMax(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarMax(Context context, IScalarExpression left, IScalarExpression right): base(context)
		{
			this.parameters = new Scalar2Parameters(left,right);
			Init(parameters);
		}
		public ScalarMax(Context context, IScalarExpression left): base(context)
		{
			this.parameters = new Scalar2Parameters(left, ScalarExpressionValue.Zero(context));
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Max(parameters.Scalar1.Calculate(),parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
			{
				if(xFirst.Calculate() > xLast.Calculate())
					return xFirst;
				else
					return xLast;
			}
			return new ScalarMax(context,xFirst,xLast);
		}
	}
}