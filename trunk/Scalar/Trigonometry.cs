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
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar.Logarithm;

namespace cdrnet.Lib.MathLib.Scalar.Trigonometry
{
	#region Constants
	[ParsingObject(ParsingObjectType.Function,250,Character="pi")]
	public class ConstantPi: ScalarOperator
	{
		protected EmptyParameters parameters;
		public ConstantPi(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ConstantPi(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.PI;
		}
		public override bool IsConstant
		{
			get {return(true);}
		}
		public override IScalarExpression Simplify()
		{
			return this;
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return ScalarExpressionValue.Zero(context);
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,this,var);
		}
	}
	#endregion

	#region Simple Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="sin")]
	public class ScalarTrigSinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigSinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigSinus(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Sin(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				double xCalc = xSub.Calculate();
				if(xCalc % Math.PI == 0)
					return ScalarExpressionValue.Zero(context);
				if((xCalc % (2*Math.PI)) / (Math.PI/2) == 1 || (xCalc % (2*Math.PI)) / (Math.PI/2) == -3)
					return ScalarExpressionValue.One(context);
				if((xCalc % (2*Math.PI)) / (Math.PI/2) == 3 || (xCalc % (2*Math.PI)) / (Math.PI/2) == -1)
					return ScalarExpressionValue.MinusOne(context);
			}
			return new ScalarTrigSinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarTrigCosinus(context,parameters.Scalar1),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNegative(context,new ScalarTrigCosinus(context,parameters.Scalar1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="cos")]
	public class ScalarTrigCosinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigCosinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigCosinus(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Cos(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				double xCalc = Math.Abs(xSub.Calculate());
				if((xCalc % (Math.PI)) / (Math.PI/2) == 1)
					return ScalarExpressionValue.Zero(context);
				if((xCalc % (2*Math.PI)) / (Math.PI/2) == 0)
					return ScalarExpressionValue.One(context);
				if((xCalc % (2*Math.PI)) / (Math.PI/2) == 2)
					return ScalarExpressionValue.MinusOne(context);
			}
			return new ScalarTrigCosinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarNegative(context,new ScalarTrigSinus(context,parameters.Scalar1)),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarTrigSinus(context,parameters.Scalar1);
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="tan")]
	public class ScalarTrigTangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigTangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigTangens(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Tan(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsConstant)
			{
				double xCalc = xSub.Calculate();
				if(xCalc % Math.PI == 0)
					return ScalarExpressionValue.Zero(context);
			}
			return new ScalarTrigTangens(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquare(context,new ScalarTrigTangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNegative(context,new ScalarNaturalLogarithm(context,new ScalarTrigCosinus(context,parameters.Scalar1)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="cot")]
	public class ScalarTrigCotangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigCotangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigCotangens(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return 1/Math.Tan(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarSubtraction(context,ScalarExpressionValue.MinusOne(context),new ScalarSquare(context,new ScalarTrigCotangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNaturalLogarithm(context,new ScalarTrigSinus(context,parameters.Scalar1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sec")]
	public class ScalarTrigSecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigSecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigSecans(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return 1/Math.Cos(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.One(context);
			return new ScalarTrigSecans(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarMultiplication(context,new ScalarTrigSecans(context,parameters.Scalar1),new ScalarTrigTangens(context,parameters.Scalar1)),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarTrigSecans(context,parameters.Scalar1),new ScalarTrigTangens(context,parameters.Scalar1)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="csc")]
	public class ScalarTrigCosecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigCosecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigCosecans(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return 1/Math.Sin(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarTrigCosecans(context,parameters.Scalar1),new ScalarTrigCotangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNegative(context,new Logarithm.ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarTrigCosecans(context,parameters.Scalar1),new ScalarTrigCotangens(context,parameters.Scalar1))));
			return base.Integrate(var);
		}
	}
	#endregion 

	#region Simple Inverse Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="asin")]
	public class ScalarTrigArcSinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigArcSinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigArcSinus(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Asin(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				double d = xSub.Calculate();
				if(d == 0)
					return xSub;
				if(d == 1)
					return new ScalarDivision(context,new ConstantPi(context),new ScalarExpressionValue(context,2));
				if(d == -1)
					return new ScalarDivision(context,new ConstantPi(context),new ScalarExpressionValue(context,-2));
			}
			return new ScalarTrigArcSinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="acos")]
	public class ScalarTrigArcCosinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigArcCosinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigArcCosinus(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Acos(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				double d = xSub.Calculate();
				if(d == 0)
					return new ScalarDivision(context,new ConstantPi(context),ScalarExpressionValue.Two(context));
				if(d == 1)
					return ScalarExpressionValue.Zero(context);
				if(d == -1)
					return new ConstantPi(context);
			}
			return new ScalarTrigArcCosinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarNegative(context,new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="atan")]
	public class ScalarTrigArcTangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigArcTangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigArcTangens(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Atan(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return xSub;
			return new ScalarTrigArcTangens(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarDivision(context,new Logarithm.ScalarNaturalLogarithm(context,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))),ScalarExpressionValue.Two(context)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="acot")]
	public class ScalarTrigArcCotangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigArcCotangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigArcCotangens(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Atan(1/parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return new ScalarDivision(context,new ConstantPi(context),new ScalarExpressionValue(context,2));
			return new ScalarTrigArcCotangens(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarNegative(context,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarDivision(context,new Logarithm.ScalarNaturalLogarithm(context,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))),ScalarExpressionValue.Two(context)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="asec")]
	public class ScalarTrigArcSecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigArcSecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigArcSecans(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Acos(1/parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				double d = xSub.Calculate();
				if(d == -1)
					return new ConstantPi(context);
				if(d == 1)
					return ScalarExpressionValue.Zero(context);
			}
			return new ScalarTrigArcSecans(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,new ScalarSquare(context,parameters.Scalar1),new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,this),new Logarithm.ScalarNaturalLogarithm(context,new ScalarAddition(context,parameters.Scalar1,new ScalarMultiplication(context,parameters.Scalar1,new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))))))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="acsc")]
	public class ScalarTrigArcCosecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarTrigArcCosecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTrigArcCosecans(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Asin(1/parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity)
			{
				double d = xSub.Calculate();
				if(d == 1)
					return new ScalarDivision(context,new ConstantPi(context),ScalarExpressionValue.Two(context));
				if(d == -1)
					return new ScalarDivision(context,new ConstantPi(context),new ScalarExpressionValue(context,-2));
			}
			return new ScalarTrigArcCosecans(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarNegative(context,new ScalarMultiplication(context,new ScalarSquare(context,parameters.Scalar1),new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)))))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,this),new Logarithm.ScalarNaturalLogarithm(context,new ScalarAddition(context,parameters.Scalar1,new ScalarMultiplication(context,parameters.Scalar1,new ScalarSquareRoot(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))))))));
			return base.Integrate(var);
		}
	}
	#endregion
}
