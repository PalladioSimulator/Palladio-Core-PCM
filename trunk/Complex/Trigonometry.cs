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
using cdrnet.Lib.MathLib.Scalar.Logarithm;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Complex.Logarithm;
using cdrnet.Lib.MathLib.Scalar.Trigonometry;
using cdrnet.Lib.MathLib.Parsing;

namespace cdrnet.Lib.MathLib.Complex.Trigonometry
{
	#region Simple Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="sin")]
	public class ComplexTrigSinus: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigSinus(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigSinus(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Real),new ScalarHypCosinus(context,c.Imag));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarTrigCosinus(context,c.Real),new ScalarHypSinus(context,c.Imag));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexTrigCosinus(context,parameters.Complex1),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNegative(context,new ComplexTrigCosinus(context,parameters.Complex1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="cos")]
	public class ComplexTrigCosinus: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigCosinus(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigCosinus(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarMultiplication(context,new ScalarTrigCosinus(context,c.Real),new ScalarHypCosinus(context,c.Imag));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarNegative(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Real),new ScalarHypSinus(context,c.Imag)));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexNegative(context,new ComplexMultiplication(context,new ComplexTrigSinus(context,parameters.Complex1),parameters.Complex1.Differentiate(var)));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexTrigCosinus(context,parameters.Complex1);
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="tan")]
	public class ComplexTrigTangens: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigTangens(Context context,Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigTangens(Context context,IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigCosinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Real),new ScalarTrigCosinus(context,c.Real)),a);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigCosinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarHypSinus(context,c.Imag),new ScalarHypCosinus(context,c.Imag)),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexAddition(context,ScalarComplex.One(context),new ComplexRaiseToPower(context,new ComplexTrigTangens(context,parameters.Complex1),ScalarComplex.Two(context))),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNegative(context,new ComplexNaturalLogarithm(context,new ComplexTrigCosinus(context,parameters.Complex1)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="cot")]
	public class ComplexTrigCotangens: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigCotangens(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigCotangens(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigSinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Real),new ScalarTrigCosinus(context,c.Real)),a);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigSinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarHypSinus(context,c.Imag),new ScalarHypCosinus(context,c.Imag))),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexSubtraction(context,new ComplexNegative(context,ScalarComplex.One(context)),new ComplexRaiseToPower(context,this,ScalarComplex.Two(context))),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNaturalLogarithm(context,new ComplexTrigSinus(context,parameters.Complex1));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sec")]
	public class ComplexTrigSecans: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigSecans(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigSecans(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigCosinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigCosinus(context,c.Real),new ScalarHypCosinus(context,c.Imag)),a);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigCosinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Real),new ScalarHypSinus(context,c.Imag)),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexMultiplication(context,new ComplexMultiplication(context,this,new ComplexTrigTangens(context,parameters.Complex1)),parameters.Complex1.Differentiate(var));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNaturalLogarithm(context,new ComplexAddition(context,this,new ComplexTrigTangens(context,parameters.Complex1)));
			return base.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="csc")]
	public class ComplexTrigCosecans: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigCosecans(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigCosecans(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigSinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarMultiplication(context,new ScalarTrigSinus(context,c.Real),new ScalarHypCosinus(context,c.Imag)),a);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,new ScalarTrigSinus(context,c.Real)),new ScalarSquare(context,new ScalarHypSinus(context,c.Imag)));
			return new ScalarDivision(context,new ScalarNegative(context,new ScalarMultiplication(context,new ScalarTrigCosinus(context,c.Real),new ScalarHypSinus(context,c.Imag))),a);
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexNegative(context,new ComplexMultiplication(context,new ComplexMultiplication(context,this,new ComplexTrigCotangens(context,parameters.Complex1)),parameters.Complex1.Differentiate(var)));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexNegative(context,new ComplexNaturalLogarithm(context,new ComplexAddition(context,this,new ComplexTrigCotangens(context,parameters.Complex1))));
			return base.Integrate(var);
		}
	}
	#endregion 

	#region Inverse Trigonometry
	[ParsingObject(ParsingObjectType.Function,250,Character="atan")]
	public class ComplexTrigArcTangens: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexTrigArcTangens(Context context,Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexTrigArcTangens(Context context,IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			return new ScalarSubtraction(context,new ScalarDivision(context,new ComplexArgument(context,new ScalarComplex(context,c.Real,new ScalarSubtraction(context,ScalarExpressionValue.One(context),c.Imag))),ScalarExpressionValue.Two(context)),new ScalarDivision(context,new ComplexArgument(context,new ScalarComplex(context,new ScalarNegative(context,c.Real),new ScalarAddition(context,ScalarExpressionValue.One(context),c.Imag))),ScalarExpressionValue.Two(context)));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c = parameters.Complex1.Expand();
			ScalarAddition top = new ScalarAddition(context,new ScalarSquare(context,c.Real),new ScalarSquare(context,new ScalarAddition(context,c.Imag,ScalarExpressionValue.One(context))));
			ScalarAddition bottom = new ScalarAddition(context,new ScalarSquare(context,c.Real),new ScalarSquare(context,new ScalarSubtraction(context,c.Imag,ScalarExpressionValue.One(context))));
			return new ScalarDivision(context,new ScalarNaturalLogarithm(context,new ScalarDivision(context,top,bottom)),new ScalarExpressionValue(context,4));
		}
		public override IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			return new ComplexDivision(context,parameters.Complex1.Differentiate(var),new ComplexAddition(context,ScalarComplex.One(context),new ComplexRaiseToPower(context,parameters.Complex1,ScalarComplex.Two(context))));
		}
		public override IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(!VariableManager.IsDefined(var,parameters.Complex1,false))
				return new ComplexMultiplication(context,this,var);
			if(parameters.Complex1.Equals(var))
				return new ComplexSubtraction(context,new ComplexMultiplication(context,var,this),new ComplexDivision(context,new ComplexNaturalLogarithm(context,new ComplexAddition(context,new ComplexRaiseToPower(context,var,ScalarExpressionValue.Two(context)),ScalarExpressionValue.One(context))),ScalarExpressionValue.Two(context)));
			return base.Integrate(var);
		}
	}
	#endregion
}
