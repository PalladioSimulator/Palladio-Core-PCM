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
using System.Text;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Literal
{
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class LiteralAddition: LiteralOperator
	{
		protected Literal2Parameters parameters;
		public Literal2Parameters Parameters {get {return parameters;}}
		public LiteralAddition(Context context, Literal2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LiteralAddition(Context context, ILiteralExpression first, ILiteralExpression last): base(context)
		{
			this.parameters = new Literal2Parameters(first,last);
			Init(parameters);
		}
		public override string Calculate()
		{
			return string.Concat(parameters.Literal1.Calculate(),parameters.Literal2.Calculate());
		}
		public override ILiteralExpression Simplify()
		{
			ILiteralExpression xFirst = parameters.Literal1.Simplify();
			ILiteralExpression xLast = parameters.Literal2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new LiteralExpressionValue(context,Calculate());
			}
			if(xFirst.IsEntity && xFirst.Calculate().Length == 0)
			{
				return xLast;
			}
			if(xLast.IsEntity && xLast.Calculate().Length == 0)
			{
				return xFirst;
			}
			return new LiteralAddition(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class LiteralSubtraction: LiteralOperator
	{
		protected Literal2Parameters parameters;
		public Literal2Parameters Parameters {get {return parameters;}}
		public LiteralSubtraction(Context context, Literal2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LiteralSubtraction(Context context, ILiteralExpression first, ILiteralExpression last): base(context)
		{
			this.parameters = new Literal2Parameters(first,last);
			Init(parameters);
		}
		public override string Calculate()
		{
			return parameters.Literal1.Calculate().Replace(parameters.Literal2.Calculate(),string.Empty);
		}
		public override ILiteralExpression Simplify()
		{
			ILiteralExpression xFirst = parameters.Literal1.Simplify();
			ILiteralExpression xLast = parameters.Literal2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new LiteralExpressionValue(context,Calculate());
			}
			if(xFirst.IsEntity && xFirst.Calculate().Length == 0)
			{
				return LiteralExpressionValue.Empty(context);
			}
			if(xLast.IsEntity && xLast.Calculate().Length == 0)
			{
				return(xFirst);
			}
			return(new LiteralSubtraction(context,xFirst,xLast));
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ScalarLiteralMultiplication: LiteralOperator
	{
		protected Scalar1Literal1Parameters parameters;
		public Scalar1Literal1Parameters Parameters {get {return parameters;}}
		public ScalarLiteralMultiplication(Context context, Scalar1Literal1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarLiteralMultiplication(Context context, ILiteralExpression literal, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1Literal1Parameters(scalar,literal);
			Init(parameters);
		}
		public ScalarLiteralMultiplication(Context context, IScalarExpression scalar, ILiteralExpression literal): base(context)
		{
			this.parameters = new Scalar1Literal1Parameters(scalar,literal);
			Init(parameters);
		}
		public override string Calculate()
		{
			string lit = parameters.Literal1.Calculate();
			int times = Math.Abs((int)Math.Floor(parameters.Scalar1.Calculate()));
			int len = lit.Length;
			char[] rsp = new Char[times*len];
			for(int i=0;i<times;i++)
				lit.CopyTo(0,rsp,i*len,len);
			return new String(rsp);
		}
		public override ILiteralExpression Simplify()
		{
			ILiteralExpression xLiteral = parameters.Literal1.Simplify();
			IScalarExpression xScalar = parameters.Scalar1.Simplify();
			if(xLiteral.IsEntity && xScalar.IsEntity && xScalar.Calculate() >= 0)
			{
				return new LiteralExpressionValue(context,Calculate());
			}
			if(xLiteral.IsEntity && xLiteral.Calculate().Length == 0)
			{
				return LiteralExpressionValue.Empty(context);
			}
			if(xScalar.IsEntity && xScalar.Calculate() == 0)
			{
				return LiteralExpressionValue.Empty(context);
			}
			if(xScalar.IsEntity && xScalar.Calculate() == 1)
			{
				return xLiteral;
			}
			return(new ScalarLiteralMultiplication(context,xLiteral,xScalar));
		}
	}
	[ParsingObject(ParsingObjectType.Function,60,Character="CountOccurrence")]
	public class LiteralCountOccurrence: ScalarOperator
	{
		protected Literal2Parameters parameters;
		public Literal2Parameters Parameters {get {return parameters;}}
		public LiteralCountOccurrence(Context context, Literal2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LiteralCountOccurrence(Context context, ILiteralExpression first, ILiteralExpression last): base(context)
		{
			this.parameters = new Literal2Parameters(first,last);
			Init(parameters);
		}
		public override double Calculate()
		{
			string a = parameters.Literal1.Calculate();
			string b = parameters.Literal2.Calculate();
			int oc = -1;
			int shift = 0;
			do
			{
				oc++;
				shift = a.IndexOf(b,shift);
			}
			while(++shift > 0 && shift<=a.Length);
			return(oc);
		}
		public override IScalarExpression Simplify()
		{
			ILiteralExpression xFirst = parameters.Literal1.Simplify();
			ILiteralExpression xLast = parameters.Literal2.Simplify();
			if(xFirst.IsEntity && xLast.IsEntity)
			{
				return new ScalarExpressionValue(context,Calculate());
			}
			if(xFirst.IsEntity && xFirst.Calculate().Length == 0)
			{
				return ScalarExpressionValue.Zero(context);
			}
			if(xLast.IsEntity && xLast.Calculate().Length == 0)
			{
				return ScalarExpressionValue.Zero(context);
			}
			return(new LiteralCountOccurrence(context,xFirst,xLast));
		}
	}
}
