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
using System.Text;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.Trigonometry;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	#region BiVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexVectorComplexVectorDotMultiplication: ComplexOperator
	{
		protected ComplexVector2Parameters parameters;
		public ComplexVector2Parameters Parameters {get {return parameters;}}
		public ComplexVectorComplexVectorDotMultiplication(Context context, ComplexVector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorComplexVectorDotMultiplication(Context context, IComplexVectorExpression first, IComplexVectorExpression last): base(context)
		{
			this.parameters = new ComplexVector2Parameters(first,last);
			Init(parameters);
		}
		public override ScalarComplex Expand()
		{
			ComplexVector va = parameters.ComplexVector1.Expand();
			ComplexVector vb = parameters.ComplexVector2.Expand();
			IComplexExpression se = new ComplexMultiplication(context,new ComplexConjugate(context,va[0]),vb[0]);
			for(int i=1;i<Math.Min(parameters.ComplexVector1.Length,parameters.ComplexVector2.Length);i++)
			{
				se = new ComplexAddition(context,se,new ComplexMultiplication(context,new ComplexConjugate(context,va[i]),vb[i]));
			}
			return se.Expand();
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class ComplexVectorComplexVectorAddition: ComplexVectorOperator
	{
		protected ComplexVector2Parameters parameters;
		public ComplexVector2Parameters Parameters {get {return parameters;}}
		public ComplexVectorComplexVectorAddition(Context context, ComplexVector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorComplexVectorAddition(Context context, IComplexVectorExpression first, IComplexVectorExpression last): base(context)
		{
			this.parameters = new ComplexVector2Parameters(first,last);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector va = parameters.ComplexVector1.Expand();
			ComplexVector vb = parameters.ComplexVector2.Expand();
			int len = Math.Min(va.Length,vb.Length);
			IComplexExpression[] se = new IComplexExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ComplexAddition(context,va[i],vb[i]);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return Math.Min(parameters.ComplexVector1.Length,parameters.ComplexVector2.Length);}
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexVectorComplexVectorSubtraction: ComplexVectorOperator
	{
		protected ComplexVector2Parameters parameters;
		public ComplexVector2Parameters Parameters {get {return parameters;}}
		public ComplexVectorComplexVectorSubtraction(Context context, ComplexVector2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorComplexVectorSubtraction(Context context, IComplexVectorExpression first, IComplexVectorExpression last): base(context)
		{
			this.parameters = new ComplexVector2Parameters(first,last);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector va = parameters.ComplexVector1.Expand();
			ComplexVector vb = parameters.ComplexVector2.Expand();
			int len = Math.Min(va.Length,vb.Length);
			IComplexExpression[] se = new IComplexExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ComplexSubtraction(context,va[i],vb[i]);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return Math.Min(parameters.ComplexVector1.Length,parameters.ComplexVector2.Length);}
		}
	}
	#endregion

	#region SingleVector Operator
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class ComplexVectorNegative: ComplexVectorOperator
	{
		protected ComplexVector1Parameters parameters;
		public ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexVectorNegative(Context context, ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorNegative(Context context, IComplexVectorExpression sub): base(context)
		{
			this.parameters = new ComplexVector1Parameters(sub);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector smin = parameters.ComplexVector1.Expand();
			IComplexExpression[] se = new IComplexExpression[Length];
			for(int y=0;y<Length;y++)
				se[y] = new ComplexNegative(context,smin[y]);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="conj")]
	public class ComplexVectorConjugate: ComplexVectorOperator
	{
		protected ComplexVector1Parameters parameters;
		public ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexVectorConjugate(Context context, ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorConjugate(Context context, IComplexVectorExpression sub): base(context)
		{
			this.parameters = new ComplexVector1Parameters(sub);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector smin = parameters.ComplexVector1.Expand();
			IComplexExpression[] se = new IComplexExpression[Length];
			for(int y=0;y<Length;y++)
				se[y] = new ComplexConjugate(context,smin[y]);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	#endregion

	#region ComplexVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexVectorComplexMultiplication: ComplexVectorOperator
	{
		protected Complex1ComplexVector1Parameters parameters;
		public Complex1ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexVectorComplexMultiplication(Context context, Complex1ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorComplexMultiplication(Context context, IComplexVectorExpression vector, IComplexExpression complex): base(context)
		{
			this.parameters = new Complex1ComplexVector1Parameters(complex,vector);
			Init(parameters);
		}
		public ComplexVectorComplexMultiplication(Context context, IComplexExpression complex, IComplexVectorExpression vector): base(context)
		{
			this.parameters = new Complex1ComplexVector1Parameters(complex,vector);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector v = parameters.ComplexVector1.Expand();
			int len = v.Length;
			IComplexExpression[] se = new IComplexExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ComplexMultiplication(context,parameters.Complex1,v[i]);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	#endregion

	#region ScalarVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexVectorScalarMultiplication: ComplexVectorOperator
	{
		protected Scalar1ComplexVector1Parameters parameters;
		public Scalar1ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexVectorScalarMultiplication(Context context, Scalar1ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorScalarMultiplication(Context context, IComplexVectorExpression vector, IScalarExpression scalar): base(context)
		{
			this.parameters = new Scalar1ComplexVector1Parameters(scalar,vector);
			Init(parameters);
		}
		public ComplexVectorScalarMultiplication(Context context, IScalarExpression scalar, IComplexVectorExpression vector): base(context)
		{
			this.parameters = new Scalar1ComplexVector1Parameters(scalar,vector);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector v = parameters.ComplexVector1.Expand();
			int len = v.Length;
			IComplexExpression[] se = new IComplexExpression[len];
			for(int i=0;i<len;i++)
				se[i] = new ComplexMultiplication(context,parameters.Scalar1,v[i]);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	#endregion
}
