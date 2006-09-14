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
using cdrnet.Lib.MathLib.Scalar.Logarithm;

namespace cdrnet.Lib.MathLib.Scalar
{
	[ParsingObject(ParsingObjectType.OuterOperator,30,Character="|")]
	public class ScalarAbsolute: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarAbsolute(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarAbsolute(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Abs(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				if(xSub.Calculate() >= 0)
					return xSub;
				else
					return (new ScalarNegative(context,xSub)).Simplify();
			}
			return new ScalarAbsolute(context,xSub);
		}
	}
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class ScalarNegative: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarNegative(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarNegative(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return -parameters.Scalar1.Calculate();
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				return new ScalarExpressionValue(context,-xSub.Calculate());
			}
			return new ScalarNegative(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarNegative(context,parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			return new ScalarNegative(context,parameters.Scalar1.Integrate(var));
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sgn")]
	public class ScalarSign: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarSign(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarSign(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			double res = parameters.Scalar1.Calculate();
			if(res > 0)
				return 1;
			if(res < 0)
				return -1;
			return 0;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				if(xSub.Calculate() > 0)
					return ScalarExpressionValue.One(context);
				if(xSub.Calculate() < 0)
					return ScalarExpressionValue.MinusOne(context);
				return ScalarExpressionValue.Zero(context);
			}
			return new ScalarSign(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return ScalarExpressionValue.Zero(context);
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			return var;		
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sqrt")]
	public class ScalarSquareRoot: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarSquareRoot(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarSquareRoot(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Sqrt(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				double test = Math.Sqrt(xSub.Calculate());
				if(test == Math.Floor(test))
					return new ScalarExpressionValue(context,test);
			}
			return new ScalarSquareRoot(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,ScalarExpressionValue.Two(context),new ScalarSquareRoot(context,parameters.Scalar1)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(!VariableManager.IsDefined(var,xSub,false))
				return new ScalarMultiplication(context,var,this);
			if(xSub.Equals(var))
				return new ScalarMultiplication(context,new ScalarDivision(context,ScalarExpressionValue.Two(context),new ScalarExpressionValue(context,3)),new ScalarRaiseToPower(context,xSub,new ScalarDivision(context,new ScalarExpressionValue(context,3),ScalarExpressionValue.Two(context))));
			return base.Integrate(var);
		}
		public override bool Equals(object obj)
		{
			if(obj.GetType().Equals(typeof(ScalarSquareRoot)))
				return parameters.Equals((obj as IExpression).ExpressionParameters);
			if(obj.GetType().Equals(typeof(ScalarRoot)))
			{
				ScalarRoot x = obj as ScalarRoot;
				return parameters.Scalar1.Equals(x.ExpressionParameters[0]) && x.ExpressionParameters[1].Equals(ScalarExpressionValue.Two(context));
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sqr")]
	public class ScalarSquare: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarSquare(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarSquare(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Pow(parameters.Scalar1.Calculate(),2);
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				double test = Math.Pow(xSub.Calculate(),2);
				if(test == Math.Floor(test))
					return new ScalarExpressionValue(context,test);
			}
			return new ScalarSquare(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,ScalarExpressionValue.Two(context),new ScalarMultiplication(context,parameters.Scalar1,parameters.Scalar1.Differentiate(var)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(!VariableManager.IsDefined(var,xSub,false))
				return new ScalarMultiplication(context,var,this);
			if(xSub.Equals(var))
				return new ScalarDivision(context,new ScalarRaiseToPower(context,parameters.Scalar1,new ScalarExpressionValue(context,3)),new ScalarExpressionValue(context,3));
			return base.Integrate(var);
		}
		public override bool Equals(object obj)
		{
			if(obj.GetType().Equals(typeof(ScalarSquareRoot)))
				return parameters.Equals((obj as IExpression).ExpressionParameters);
			if(obj.GetType().Equals(typeof(ScalarRaiseToPower)))
			{
				ScalarRaiseToPower x = obj as ScalarRaiseToPower;
				return parameters.Scalar1.Equals(x.ExpressionParameters[0]) && x.ExpressionParameters[1].Equals(ScalarExpressionValue.Two(context));
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.PreOperator,45,Character="!")]
	public class ScalarFactorial: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarFactorial(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarFactorial(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			int a = (int)Math.Floor(parameters.Scalar1.Calculate());
			if(a == 0)
				return 1;
			int x;
			if(a > 0)
			{
				x = 1;
				for(int i=2;i<=a;i++)
					x *= i;
			}
			else
			{
				x = -1;
				for(int i=2;i<=(-a);i++)
					x *= i;
			}
			return (double)x;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() < 5.0)
			{
				return new ScalarExpressionValue(context,Calculate());
			}
			return new ScalarFactorial(context,xSub);
		}
		public override IScalarExpression Expand()
		{
			IScalarExpression exp = parameters.Scalar1.Expand();
			if(!exp.IsConstant)
				return new ScalarFactorial(context,exp);
			int a = (int)Math.Floor(exp.Calculate());
			if(a == 0)
				return ScalarExpressionValue.One(context);
			//TODO: implement expand ....
			return new ScalarFactorial(context,exp);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarMultiplication(context,new ScalarPsi(context,new ScalarAddition(context,parameters.Scalar1,ScalarExpressionValue.One(context))),this),parameters.Scalar1.Differentiate(var));
		}
	}
}
