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
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Scalar.Logarithm
{
	#region Constants
	[ParsingObject(ParsingObjectType.Function,250,Character="e")]
	public class ConstantE: ScalarOperator
	{
		protected EmptyParameters parameters;
		public ConstantE(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ConstantE(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.E;
		}
		public override bool IsConstant
		{
			get {return true;}
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

	[ParsingObject(ParsingObjectType.Function,250,Character="ln")]
	public class ScalarNaturalLogarithm: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarNaturalLogarithm(Context context,Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ScalarNaturalLogarithm(Context context,IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Log(parameters.Scalar1.Calculate(),Math.E);
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 1)
				return ScalarExpressionValue.Zero(context);
			return new ScalarNaturalLogarithm(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),parameters.Scalar1);
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarMultiplication(context,var,new ScalarSubtraction(context,this,ScalarExpressionValue.One(context)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lg")]
	public class ScalarCommonLogarithm: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarCommonLogarithm(Context context,Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ScalarCommonLogarithm(Context context,IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Log10(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 1)
				return ScalarExpressionValue.Zero(context);
			if(xSub.IsEntity && xSub.Calculate() == 10)
				return ScalarExpressionValue.One(context);
			return new ScalarCommonLogarithm(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,new ScalarNaturalLogarithm(context,new ScalarExpressionValue(context,10)),parameters.Scalar1));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return new ScalarSubtraction(context,new ScalarMultiplication(context,var,this),new ScalarDivision(context,var,new ScalarNaturalLogarithm(context,new ScalarExpressionValue(context,10))));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="log")]
	public class ScalarGeneralLogarithm: ScalarOperator
	{
		protected Scalar2Parameters parameters;
		public Scalar2Parameters Parameters {get {return parameters;}}
		public ScalarGeneralLogarithm(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ScalarGeneralLogarithm(Context context, IScalarExpression lsub, IScalarExpression lbase): base(context)
		{
			this.parameters = new Scalar2Parameters(lsub,lbase);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Log(parameters.Scalar1.Calculate(),parameters.Scalar2.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xFirst = parameters.Scalar1.Simplify();
			IScalarExpression xLast = parameters.Scalar2.Simplify();
			if(xFirst.IsEntity && xFirst.Calculate() == 1)
				return ScalarExpressionValue.Zero(context);
			return new ScalarDivision(context,new ScalarNaturalLogarithm(context,xFirst),new ScalarNaturalLogarithm(context,xLast));
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarSubtraction(context,new ScalarDivision(context,parameters.Scalar1.Differentiate(var),new ScalarMultiplication(context,new ScalarNaturalLogarithm(context,parameters.Scalar2),parameters.Scalar1)),new ScalarDivision(context,new ScalarMultiplication(context,new ScalarNaturalLogarithm(context,parameters.Scalar1),parameters.Scalar2.Differentiate(var)),new ScalarMultiplication(context,new ScalarSquare(context,new ScalarNaturalLogarithm(context,parameters.Scalar2)),parameters.Scalar2)));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			bool lastnotx = !VariableManager.IsDefined(var,parameters.Scalar2,false);
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false) && lastnotx)
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var) && parameters.Scalar2.Equals(var))
				return var;
			if(parameters.Scalar1.Equals(var) && lastnotx)
				return new ScalarDivision(context,new ScalarMultiplication(context,var,new ScalarSubtraction(context,new ScalarNaturalLogarithm(context,var),ScalarExpressionValue.One(context))),new ScalarNaturalLogarithm(context,parameters.Scalar2));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="exp")]
	public class ScalarExponential: ScalarOperator
	{
		protected Scalar1Parameters parameters;
		public Scalar1Parameters Parameters {get {return parameters;}}
		public ScalarExponential(Context context,Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarExponential(Context context,IScalarExpression sub): base(context)
		{
			this.parameters = new Scalar1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return Math.Exp(parameters.Scalar1.Calculate());
		}
		public override IScalarExpression Simplify()
		{
			IScalarExpression xSub = parameters.Scalar1.Simplify();
			if(xSub.IsEntity && xSub.Calculate() == 0)
				return ScalarExpressionValue.One(context);
			return new ScalarExponential(context,xSub);
		}
		public override IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarMultiplication(context,parameters.Scalar1.Differentiate(var),new ScalarExponential(context,parameters.Scalar1));
		}
		public override IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Scalar1,false))
				return new ScalarMultiplication(context,this,var);
			if(parameters.Scalar1.Equals(var))
				return this;
			return base.Integrate(var);
		}
	}
}
