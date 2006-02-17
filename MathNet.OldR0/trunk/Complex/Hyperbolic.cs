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
using cdrnet.Lib.MathLib.Scalar.Trigonometry;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Complex.Logarithm;

namespace cdrnet.Lib.MathLib.Complex.Trigonometry
{
	#region Hyperbolic Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="sinh")]
	public class ComplexHypSinus: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexHypSinus(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexHypSinus(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarHypSinus(context,c.Real),new ScalarTrigCosinus(context,c.Imag));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarHypCosinus(context,c.Real),new ScalarTrigSinus(context,c.Imag));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexHypCosinus(context,parameters.Complex1),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexHypCosinus(context,parameters.Complex1);
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="cosh")]
	public class ComplexHypCosinus: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexHypCosinus(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexHypCosinus(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarHypCosinus(context,c.Real),new ScalarTrigCosinus(context,c.Imag));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarHypSinus(context,c.Real),new ScalarTrigSinus(context,c.Imag));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexHypSinus(context,parameters.Complex1),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexHypSinus(context,parameters.Complex1);
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="tanh")]
	public class ComplexHypTangens: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexHypTangens(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexHypTangens(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigCosinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarHypSinus(context,c.Real),new ScalarHypCosinus(context,c.Real)),a);	
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigCosinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Imag),new ScalarTrigCosinus(context,c.Imag)),a);	
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexSubtraction(context,ScalarComplex.One(context),new ComplexRaiseToPower(context,this,ScalarComplex.Two(context))),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNaturalLogarithm(context,new ComplexHypCosinus(context,parameters.Complex1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="coth")]
	public class ComplexHypCotangens: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexHypCotangens(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexHypCotangens(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarHypSinus(context,c.Real),new ScalarHypCosinus(context,c.Real)),a);	
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Imag),new ScalarTrigCosinus(context,c.Imag))),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexSubtraction(context,ScalarComplex.One(context),new ComplexRaiseToPower(context,this,ScalarComplex.Two(context))),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNaturalLogarithm(context,new ComplexHypSinus(context,parameters.Complex1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sech")]
	public class ComplexHypSecans: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexHypSecans(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexHypSecans(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigCosinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigCosinus(context,c.Imag),new ScalarHypCosinus(context,c.Real)),a);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigCosinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Imag),new ScalarHypSinus(context,c.Real))),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexNegative(context,new ComplexMultiplication(context,new ComplexMultiplication(context,this,new ComplexHypTangens(context,parameters.Complex1)),parameters.Complex1.Differentiate(var)));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexTrigArcTangens(context,new ComplexHypSinus(context,parameters.Complex1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="csch")]
	public class ComplexHypCosecans: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexHypCosecans(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexHypCosecans(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarHypSinus(context,c.Real),new ScalarTrigCosinus(context,c.Imag)),a);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarHypSinus(context,c.Real)),new ScalarSquare(context,new ScalarTrigSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarHypCosinus(context,c.Real),new ScalarHypSinus(context,c.Imag))),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexNegative(context,new ComplexMultiplication(context,new ComplexMultiplication(context,this,new ComplexHypCotangens(context,parameters.Complex1)),parameters.Complex1.Differentiate(var)));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNaturalLogarithm(context,new ComplexHypTangens(context,new ComplexDivision(context,parameters.Complex1,ScalarComplex.Two(context))));
			return base.Integrate(var);
		}
	}
	#endregion 
}
