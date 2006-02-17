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
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar.Logarithm;

namespace cdrnet.Lib.MathLib.Scalar.Trigonometry
{
	#region Hyperbolic Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="sinh")]
	public class ScalarHypSinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypSinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypSinus(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Sinh(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypSinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarHypCosinus(context,parameters.Scalar1),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarHypCosinus(context,parameters.Scalar1);
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="cosh")]
	public class ScalarHypCosinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypCosinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypCosinus(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Cosh(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.One(context);
			return new ScalarHypCosinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarHypSinus(context,parameters.Scalar1),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarHypSinus(context,parameters.Scalar1);
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="tanh")]
	public class ScalarHypTangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypTangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypTangens(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Tanh(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypTangens(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,new ScalarHypTangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNaturalLogarithm(context,new ScalarHypCosinus(context,parameters.Scalar1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="coth")]
	public class ScalarHypCotangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypCotangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypCotangens(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return 1/Math.Tanh(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,new ScalarHypCotangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNaturalLogarithm(context,new ScalarHypSinus(context,parameters.Scalar1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sech")]
	public class ScalarHypSecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypSecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypSecans(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return 1/Math.Cosh(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.One(context);
			return new ScalarHypSecans(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarHypSecans(context,parameters.Scalar1),new ScalarHypTangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarTrigArcTangens(context,new ScalarHypSinus(context,parameters.Scalar1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="csch")]
	public class ScalarHypCosecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypCosecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypCosecans(Context context, IScalarExpression radangle): base(context)
		{
			this.parameters = new Scalar1Parameters(radangle);
			Init(parameters);
		}
		public override double Calculate()
		{
			return 1/Math.Sinh(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarHypCosecans(context,parameters.Scalar1),new ScalarHypTangens(context,parameters.Scalar1))),parameters.Scalar1.Differentiate(var));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarNaturalLogarithm(context,new ScalarHypTangens(context,new ScalarDivision(context,parameters.Scalar1,ScalarExpressionValue.Two(context))));
			return base.Integrate(var);
		}
	}
	#endregion

	#region Simple Inverse Hyperbolic Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="asinh")]
	public class ScalarHypAreaSinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypAreaSinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypAreaSinus(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			//ln(x+(x^2+1)^(1/2))
			double x = parameters.Scalar1.Calculate();
			return Math.Log(x+Math.Pow((x*x+1),1/2),Math.E);
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypAreaSinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarSquareRoot(context,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarSquareRoot(context,new ScalarAddition(context,new ScalarSquare(context,parameters.Scalar1),ScalarExpressionValue.One(context))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="acosh")]
	public class ScalarHypAreaCosinus: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypAreaCosinus(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypAreaCosinus(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			//ln(x+(x-1)^(1/2)*(x+1)^(1/2))
			double x = parameters.Scalar1.Calculate();
			return Math.Log(x+Math.Pow((x-1),1/2)*Math.Pow((x+1),1/2),Math.E);
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 1)
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypAreaCosinus(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,new ScalarSquareRoot(context,new ScalarSubtraction(context,parameters.Scalar1,ScalarExpressionValue.One(context))),new ScalarSquareRoot(context,new ScalarAddition(context,parameters.Scalar1,ScalarExpressionValue.One(context)))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarMultiplication(context,new ScalarSquareRoot(context,new ScalarSubtraction(context,parameters.Scalar1,ScalarExpressionValue.One(context))),new ScalarSquareRoot(context,new ScalarAddition(context,parameters.Scalar1,ScalarExpressionValue.One(context)))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="atanh")]
	public class ScalarHypAreaTangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypAreaTangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypAreaTangens(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			//1/2*ln(x+1)-1/2*ln(1-x)
			double x = parameters.Scalar1.Calculate();
			return Math.Log(1+x,Math.E)/2-Math.Log(1-x,Math.E)/2;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypAreaTangens(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarDivision(context,new ScalarNaturalLogarithm(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1))),ScalarExpressionValue.Two(context)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="acoth")]
	public class ScalarHypAreaCotangens: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypAreaCotangens(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypAreaCotangens(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			//1/2*ln(x+1)-1/2*ln(x-1)
			double x = parameters.Scalar1.Calculate();
			return Math.Log(1+x,Math.E)/2-Math.Log(x-1,Math.E)/2;
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && double.IsInfinity(xSub.Calculate()))
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypAreaCotangens(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarSubtraction(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarDivision(context,new ScalarNaturalLogarithm(context,new ScalarSubtraction(context,new ScalarSquare(context,parameters.Scalar1),ScalarExpressionValue.One(context))),ScalarExpressionValue.Two(context)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="asech")]
	public class ScalarHypAreaSecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypAreaSecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypAreaSecans(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			//ln(1/x+(1/x-1)^(1/2)*(1/x+1)^(1/2))
			double x = parameters.Scalar1.Calculate();
			return Math.Log(1/x+Math.Sqrt(1/x-1)*Math.Sqrt(1/x+1),Math.E);
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate()==1)
				return ScalarExpressionValue.Zero(context);
			return new ScalarHypAreaSecans(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			//-x'/(x^2*(1/x-1)^(1/2)*(1/x+1)^(1/2))
			return new ScalarNegative(context,new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,new ScalarSquare(context,parameters.Scalar1),new ScalarMultiplication(context,new ScalarSquareRoot(context,new ScalarSubtraction(context,new ScalarDivision(context,ScalarExpressionValue.One(context),parameters.Scalar1),ScalarExpressionValue.One(context))),new ScalarSquareRoot(context,new ScalarAddition(context,new ScalarDivision(context,ScalarExpressionValue.One(context),parameters.Scalar1),ScalarExpressionValue.One(context)))))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var)) //x*arcsech(x)-arctan((1/x-1)^(1/2)*(1/x+1)^(1/2))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarTrigArcTangens(context,new ScalarMultiplication(context,new ScalarSquareRoot(context,new ScalarSubtraction(context,new ScalarDivision(context,ScalarExpressionValue.One(context),parameters.Scalar1),ScalarExpressionValue.One(context))),new ScalarSquareRoot(context,new ScalarAddition(context,new ScalarDivision(context,ScalarExpressionValue.One(context),parameters.Scalar1),ScalarExpressionValue.One(context))))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="acsch")]
	public class ScalarHypAreaCosecans: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarHypAreaCosecans(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarHypAreaCosecans(Context context, IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			//ln(1/x+(1+1/(x^2))^(1/2))
			double x = parameters.Scalar1.Calculate();
			return Math.Log(1/x+Math.Sqrt(1/(x*x)+1),Math.E);
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && double.IsInfinity(xSub.Calculate()))
				return ScalarExpressionValue.Zero(context);
			if(xSub.IsEntity && xSub.Calculate()==1)
				return new ScalarNaturalLogarithm(context,new ScalarAddition(context,ScalarExpressionValue.One(context),new ScalarSquareRoot(context,ScalarExpressionValue.Two(context))));
			return new ScalarHypAreaCosecans(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			//-x'/(x^2*(1+1/(x^2))^(1/2))
			return new ScalarNegative(context,new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,new ScalarSquare(context,parameters.Scalar1),new ScalarSquareRoot(context,new ScalarAddition(context,new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)),ScalarExpressionValue.One(context))))));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var)) //x*arccsch(x)+ln(x+x*(1+1/(x^2))^(1/2))
				return new ScalarAddition(context,new ScalarMultiplication(context,parameters.Scalar1,this),new ScalarNaturalLogarithm(context,new ScalarAddition(context,parameters.Scalar1,new ScalarMultiplication(context,parameters.Scalar1,new ScalarSquareRoot(context,new ScalarAddition(context,new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarSquare(context,parameters.Scalar1)),ScalarExpressionValue.One(context)))))));
			return base.Integrate(var);
		}
	}
	#endregion
}
