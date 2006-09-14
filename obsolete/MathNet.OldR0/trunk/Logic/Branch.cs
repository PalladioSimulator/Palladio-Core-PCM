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
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Logic
{
	[ParsingObject(ParsingObjectType.Function,250,Character="if")]
	public class LogicIf: ScalarOperator
	{
		protected Scalar3Parameters parameters;
		public Scalar3Parameters Parameters {get {return parameters;}}
		public LogicIf(Context context, Scalar3Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicIf(Context context, IScalarExpression condition, IScalarExpression exptrue, IScalarExpression expfalse): base(context)
		{
			this.parameters = new Scalar3Parameters(condition,exptrue,expfalse);
			Init(parameters);
		}
		public override double Calculate()
		{
			if(parameters.Scalar1.Calculate() != 0)
				return(parameters.Scalar2.Calculate());
			else
				return(parameters.Scalar3.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xCond = parameters.Scalar1.Simplify();
			IScalarExpression xTrue = parameters.Scalar2.Simplify();
			IScalarExpression xFalse = parameters.Scalar3.Simplify();
			if(xTrue.Equals(xFalse))
				return xTrue;
			if(xCond.IsConstant)
			{
				if(xCond.Calculate() != 0)
					return xTrue;
				else
					return xFalse;
			}
			return new LogicIf(context,xCond,xTrue,xFalse);
		}
	}

	[ParsingObject(ParsingObjectType.Function,250,Character="case")]
	public class LogicCase: ScalarOperator
	{
		protected Scalar2Vector2Parameters parameters;
		public Scalar2Vector2Parameters Parameters {get {return parameters;}}
		public LogicCase(Context context, Scalar2Vector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LogicCase(Context context, IScalarExpression condition, IVectorExpression left, IVectorExpression right, IScalarExpression defaultval): base(context)
		{
			this.parameters = new Scalar2Vector2Parameters(condition,defaultval,left,right);
			Init(parameters);
		}
		public override double Calculate()
		{
			ScalarVector left = parameters.Vector1.Expand();
			ScalarVector right = parameters.Vector2.Expand();
			if(left.Length != right.Length)
				throw(new ExpressionRankMismatchException());
			for(int i=0; i<left.Length; i++)
				if(parameters.Scalar1.Calculate() == left[i].Calculate())
					return right[i].Calculate();
			return parameters.Scalar2.Calculate();
		}
		public override IScalarExpression Expand()
		{
			ScalarVector xLeft = parameters.Vector1.Expand();
			ScalarVector xRight = parameters.Vector2.Expand();
			IScalarExpression xCond = parameters.Scalar1.Expand();
			IScalarExpression xDefault = parameters.Scalar2.Expand();
			if(xLeft.Length != xRight.Length)
				throw(new ExpressionRankMismatchException());
			for(int i=0; i<xLeft.Length; i++)
			{
				if(xCond.Equals(xLeft[i]))
					return xRight[i];
			}
			if(xCond.IsConstant && xLeft.IsConstant)
			{
				double c = xCond.Calculate();
				for(int i=0; i<xLeft.Length; i++)
				{
					if(c ==  xLeft[i].Calculate())
						return xRight[i];
				}
				return xDefault;
			}
			return new LogicCase(context,xCond,xLeft,xRight,xDefault);
		}
		public override string ToString()
		{
			return "case("+parameters.Scalar1.ToString()+","+parameters.Vector1.ToString()+","+parameters.Vector2.ToString()+","+parameters.Scalar2.ToString()+")";
		}
	}
}
