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
using cdrnet.Lib.MathLib.Scalar.Logarithm;
using cdrnet.Lib.MathLib.Scalar.Trigonometry;

namespace cdrnet.Lib.MathLib.Complex.Logarithm
{
	[ParsingObject(ParsingObjectType.Function,250,Character="ln")]
	public class ComplexNaturalLogarithm: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexNaturalLogarithm(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexNaturalLogarithm(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override ValueComplex Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			ValueComplex rsp;
			rsp.Real = 1.0/2.0 * Math.Log(Math.Pow(sub.Real,2)+Math.Pow(sub.Imag,2),Math.E);
			rsp.Imag = Math.Atan2(sub.Imag,sub.Real);
			return(rsp);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarDivision(context,new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarSquare(context,c.Real),new ScalarSquare(context,c.Imag))),ScalarExpressionValue.Two(context));
		}
		public override IScalarExpression ExpandImag()
		{
			return new ComplexArgument(context,parameters.Complex1);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexDivision(context,parameters.Complex1.Differentiate(var),parameters.Complex1);
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexMultiplication(context,parameters.Complex1,new ComplexSubtraction(context,this,ScalarComplex.One(context)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lg")]
	public class ComplexCommonLogarithm: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexCommonLogarithm(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexCommonLogarithm(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override ValueComplex Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			ValueComplex rsp;
			rsp.Real = 1.0/2 * Math.Log10(Math.Pow(sub.Real,2)+Math.Pow(sub.Imag,2));
			rsp.Imag = Math.Atan2(sub.Imag,sub.Real)/Math.Log(10,Math.E);
			return(rsp);
		}
		public override IScalarExpression ExpandReal()
		{
			return new ScalarCommonLogarithm(context,new ComplexAbsolute(context,parameters.Complex1));
		}
		public override IScalarExpression ExpandImag()
		{
			return new ScalarDivision(context,new ComplexArgument(context,parameters.Complex1),new ScalarNaturalLogarithm(context,new ScalarExpressionValue(context,10)));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexDivision(context,parameters.Complex1.Differentiate(var),new ComplexMultiplication(context,new ScalarNaturalLogarithm(context,new ScalarExpressionValue(context,10)),parameters.Complex1));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexDivision(context,new ComplexMultiplication(context,parameters.Complex1,new ComplexSubtraction(context,this,ScalarComplex.One(context))),new ScalarNaturalLogarithm(context,new ScalarExpressionValue(context,10)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="log")]
	public class ComplexGeneralLogarithm: ComplexOperator
	{
		Complex2Parameters parameters;
		public Complex2Parameters Parameters {get {return parameters;}}
		public ComplexGeneralLogarithm(Context context, Complex2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexGeneralLogarithm(Context context, IComplexExpression lsub, IComplexExpression lbase): base(context)
		{
			this.parameters = new Complex2Parameters(lsub,lbase);
			Init(parameters);
		}
		public ComplexGeneralLogarithm(Context context, IComplexExpression lsub, IScalarExpression lbase): base(context)
		{
			this.parameters = new Complex2Parameters(lsub,new ScalarComplex(context,lbase,ScalarExpressionValue.Zero(context)));
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			return Expand().Real;
		}
		public override IScalarExpression ExpandImag()
		{
			return Expand().Imag;
		}
		public override ScalarComplex Expand()
		{
			return new ComplexDivision(context,new ComplexNaturalLogarithm(context,parameters.Complex1),new ComplexNaturalLogarithm(context,parameters.Complex2)).Expand();
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			IComplexExpression s1 = new ComplexMultiplication(context,new ComplexMultiplication(context,parameters.Complex2,parameters.Complex1.Differentiate(var)),new ComplexNaturalLogarithm(context,parameters.Complex2));
			IComplexExpression s2 = new ComplexMultiplication(context,new ComplexMultiplication(context,parameters.Complex1,parameters.Complex2.Differentiate(var)),new ComplexNaturalLogarithm(context,parameters.Complex1));
			return new ComplexDivision(context,new ComplexSubtraction(context,s1,s2),new ComplexMultiplication(context,new ComplexMultiplication(context,parameters.Complex1,parameters.Complex2),new ComplexRaiseToPower(context,new ComplexNaturalLogarithm(context,parameters.Complex2),ScalarComplex.Two(context))));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			bool lastnotx = !VariableManager.IsDefined(var,parameters.Complex2,false);
			if(!VariableManager.IsDefined(var,parameters.Complex1,false) && lastnotx)
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var) && parameters.Complex2.Equals(var))
				return var;
			if(parameters.Complex1.Equals(var) && lastnotx)
				return new ComplexDivision(context, new ComplexMultiplication(context,parameters.Complex1,new ComplexSubtraction(context,new ComplexNaturalLogarithm(context,parameters.Complex1),ScalarComplex.One(context))),new ComplexNaturalLogarithm(context,parameters.Complex2));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="exp")]
	public class ComplexExponential: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexExponential(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexExponential(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override ValueComplex Calculate()
		{
			double real = parameters.Complex1.ExpandReal().Calculate();
			double imag = parameters.Complex1.ExpandImag().Calculate();
			ValueComplex rsp;
			rsp.Real = Math.Exp(real)*Math.Cos(imag);
			rsp.Imag = Math.Exp(real)*Math.Sin(imag);
			return(rsp);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex sub = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarExponential(context,sub.Real),new ScalarTrigCosinus(context,sub.Imag));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex sub = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarExponential(context,sub.Real),new ScalarTrigSinus(context,sub.Imag));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,parameters.Complex1.Differentiate(var),this);
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return this;
			return base.Integrate(var);
		}
	}
}
