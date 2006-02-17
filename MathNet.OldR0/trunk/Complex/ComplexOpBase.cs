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

namespace cdrnet.Lib.MathLib.Complex
{
	#region Complex Parameters
	public class Complex1Parameters: Parameters
	{
		private IComplexExpression complex1;
		public Complex1Parameters() : base(1) {}
		public Complex1Parameters(IComplexExpression c1) : base(1)
		{
			complex1 = c1;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex1Parameters(complex1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex1Parameters(complex1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex1Parameters(complex1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex2Parameters: Parameters
	{
		private IComplexExpression complex1, complex2;
		public Complex2Parameters() : base(2) {}
		public Complex2Parameters(IComplexExpression c1, IComplexExpression c2) : base(2)
		{
			complex1 = c1;
			complex2 = c2;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexExpression Complex2
		{
			get {return complex2;}
			set {complex2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexConversionMap.Convert(ref complex2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex2Parameters(complex1.Simplify(),complex2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex2Parameters(complex1.Expand(),complex2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex2Parameters(complex1.Substitute(original,replacement),complex2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complex2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Complex3Parameters: Parameters
	{
		private IComplexExpression complex1, complex2, complex3;
		public Complex3Parameters() : base(3) {}
		public Complex3Parameters(IComplexExpression c1, IComplexExpression c2, IComplexExpression c3) : base(3)
		{
			complex1 = c1;
			complex2 = c2;
			complex3 = c3;
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public IComplexExpression Complex2
		{
			get {return complex2;}
			set {complex2 = value;}
		}
		public IComplexExpression Complex3
		{
			get {return complex3;}
			set {complex3 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex1, conversionType);
			ComplexConversionMap.Convert(ref complex2, conversionType);
			ComplexConversionMap.Convert(ref complex3, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Complex3Parameters(complex1.Simplify(),complex2.Simplify(),complex3.Simplify());
		}
		public override Parameters Expand()
		{
			return new Complex3Parameters(complex1.Expand(),complex2.Expand(),complex3.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Complex3Parameters(complex1.Substitute(original,replacement),complex2.Substitute(original,replacement),
				complex3.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return complex1;
					case 1:
						return complex2;
					case 2:
						return complex3;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Complex Scalar Parameters
	public class Scalar1Complex1Parameters: Parameters
	{
		private IComplexExpression complex1;
		private IScalarExpression scalar1;
		public Scalar1Complex1Parameters() : base(2) {}
		public Scalar1Complex1Parameters(IScalarExpression s1, IComplexExpression c1) : base(2)
		{
			scalar1 = s1;
			complex1 = c1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IComplexExpression Complex1
		{
			get {return complex1;}
			set {complex1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ComplexConversionMap.Convert(ref complex1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Complex1Parameters(scalar1.Simplify(),complex1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Complex1Parameters(scalar1.Expand(),complex1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Complex1Parameters(scalar1.Substitute(original,replacement),complex1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return scalar1;
					case 1:
						return complex1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Complex Operator
	/// <summary>
	/// ComplexOperator is a base operator for operators
	/// returning an <see cref="IComplexExpression"/>.
	/// </summary>
	/// <remarks>It's very important to implement either Expand() or ExpandReal() and ExpandImag()!</remarks>
	public abstract class ComplexOperator: MathExpression, IComplexExpression
	{
		public ComplexOperator(Context context): base(context) {}
		public virtual ValueComplex Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual ScalarComplex Expand()
		{
			return new ScalarComplex(context,ExpandReal(),ExpandImag());
		}
		public virtual IScalarExpression ExpandReal()
		{
			return Expand().Real;
		}
		public virtual IScalarExpression ExpandImag()
		{
			return Expand().Imag;
		}
		public IComplexExpression SafeExpand()
		{
			return (IComplexExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IComplexExpression Simplify()
		{
			return (IComplexExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IComplexExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IComplexExpression) InnerSubstitute(original,replacement);
		}
		#endregion

//		public virtual IComplexExpression Differentiate(ScalarExpressionVariable rvar, ScalarExpressionVariable ivar)
//		{
//			return new ScalarComplex(ExpandReal().Differentiate(rvar),ExpandImag().Differentiate(ivar));
//		}
		public virtual IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			throw new Exceptions.ExpressionNotDeriveableException();
			//return new ComplexDerive(this,var);
		}
		public virtual IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			throw new Exceptions.ExpressionNotIntegratableException();
			//return new ComplexIntegrate(this,var);
		}
	}
	#endregion
}
