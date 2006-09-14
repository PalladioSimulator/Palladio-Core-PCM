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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.Logarithm;
using cdrnet.Lib.MathLib.Scalar.Trigonometry;
using cdrnet.Lib.MathLib.Parsing;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Complex
{
	/// <summary>
	/// Math.NET type: a complex expression (complex of a real and an imaginary scalar)
	/// </summary>
	[ParsingType(ParsingExpressionType.Scalar,2)]
	public interface IComplexExpression: IExpression
	{
		/// <summary>
		/// calculate the complex expressions as a ValueComplex
		/// </summary>
		ValueComplex Calculate();
		/// <summary>
		/// the real component of the complex expression
		/// </summary>
		/// <returns>the real component</returns>
		IScalarExpression ExpandReal();
		/// <summary>
		/// the imaginary component og the complex expression
		/// </summary>
		/// <returns>the imaginary component</returns>
		IScalarExpression ExpandImag();
		/// <summary>
		/// splits the complex expression to a real and an imaginary part
		/// </summary>
		/// <returns>the splitted expression</returns>
		ScalarComplex Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IComplexExpression SafeExpand();
		/// <summary>
		/// simplifies the complex expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IComplexExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IComplexExpression Substitute(IExpression original, IExpression replacement);
		/// <summary>
		/// derives the complex expression to a complex variable (as long as the expression is holomorph)
		/// </summary>
		/// <param name="var">the variable to derive to</param>
		/// <returns>the deriven expression</returns>
		IComplexExpression Differentiate(ComplexExpressionVariable var);
		/// <summary>
		/// integrates the complex expression to a complex variable
		/// </summary>
		/// <param name="var">the variable to integrate to</param>
		/// <returns>the integrated expression</returns>
		IComplexExpression Integrate(ComplexExpressionVariable var);
	}
	/// <summary>
	/// the native data structure for discrete (numeric) complex numbers
	/// </summary>
	public struct ValueComplex
	{
		public double Real,Imag;
		public override string ToString()
		{
			if(Imag == 0)
				return(Real.ToString());
			if(Real == 0 && Imag == 1)
				return("I");
			if(Real == 0)
				return("(I*"+Imag+")");
			if(Imag == 1)
				return("("+Real+"+I)");
			return("("+Real+"+I*"+Imag+")");
		}
	}

	#region Specific Math Objects
	[ParsingObject(ParsingObjectType.Complex,11)]
	public class ScalarComplex: ComplexOperator
	{
		private Scalar2Parameters parameters;
		public ScalarComplex(Context context, Scalar2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarComplex(Context context, IScalarExpression real, IScalarExpression imag): base(context)
		{
			this.parameters = new Scalar2Parameters(real,imag);
			Init(parameters);
		}
		public ScalarComplex(Context context): base(context) 
		{
			this.parameters = new Scalar2Parameters(ScalarExpressionValue.One(context),ScalarExpressionValue.One(context));
			Init(parameters);
		}

		#region Static Complex Templates
		public static ScalarComplex I(Context context)
		{
			return new ScalarComplex(context,ScalarExpressionValue.Zero(context),ScalarExpressionValue.One(context));
		}
		public static ScalarComplex One(Context context)
		{
			return new ScalarComplex(context,ScalarExpressionValue.One(context),ScalarExpressionValue.Zero(context));
		}
		public static ScalarComplex Two(Context context)
		{
			return new ScalarComplex(context,ScalarExpressionValue.Two(context),ScalarExpressionValue.Zero(context));
		}
		public static ScalarComplex Zero(Context context)
		{
			IScalarExpression se = ScalarExpressionValue.Zero(context);
			return new ScalarComplex(context,se,se);
		}
		#endregion

		public IScalarExpression Real
		{
			set {parameters.Scalar1 = value;}
			get {return parameters.Scalar1;}
		}
		public IScalarExpression Imag
		{
			set {parameters.Scalar2 = value;}
			get {return parameters.Scalar2;}
		}
		public override IScalarExpression ExpandReal()
		{
			return parameters.Scalar1;
		}
		public override IScalarExpression ExpandImag()
		{
			return parameters.Scalar2;
		}
		public override ScalarComplex Expand()
		{
			return this;
		}
		public override ValueComplex Calculate()
		{
			ValueComplex rsp;
			rsp.Real = Real.Calculate();
			rsp.Imag = Imag.Calculate();
			return(rsp);
		}
		public override string ToString()
		{
			return string.Format("({0}+I*{1})",Real.ToString(),Imag.ToString());
		}
		public override bool IsEntity
		{
			get {return true;}
		}
	}
	#endregion

	#region Operator Base (deactive)
	/*
	public abstract class BiComplexOperator
	{
		protected IComplexExpression first, last;
		private int priority;
		protected BiComplexOperator(IComplexExpression first, IComplexExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IComplexExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IComplexExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref first,conversionType);
			ComplexConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiComplexOperator x = exp as BiComplexOperator;
				//override this method if not true!!
				if(x.first.IsEqualTo(this.first) && x.last.IsEqualTo(this.last) || x.first.IsEqualTo(this.last) && x.last.IsEqualTo(this.first))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class SingleComplexOperator
	{
		protected IComplexExpression sub;
		private int priority;
		protected SingleComplexOperator(IComplexExpression sub)
		{
			this.sub = sub;
		}
		public IComplexExpression SubExpression
		{
			set {sub = value;}
			get {return(sub);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(sub.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleComplexOperator x = exp as SingleComplexOperator;
				//override this method if not true!!
				if(x.sub.IsEqualTo(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class ScalarComplexOperator
	{
		protected IScalarExpression scalar;
		protected IComplexExpression complex;
		private int priority;
		protected ScalarComplexOperator(IScalarExpression scalar, IComplexExpression complex)
		{
			this.complex = complex;
			this.scalar = scalar;
		}
		public IComplexExpression ComplexExpression
		{
			set {complex = value;}
			get {return(complex);}
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(scalar.IsConstant && complex.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ComplexConversionMap.Convert(ref complex,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarComplexOperator x = exp as ScalarComplexOperator;
				//override this method if not true!!
				if(x.complex.IsEqualTo(this.complex) && x.scalar.IsEqualTo(this.scalar))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			scalar.CollectVariables(vars,deep);
			complex.CollectVariables(vars,deep);
		}
	}
	*/
	#endregion

	#region Typed Operator Base (deactive)
	/*
	public abstract class BiComplexToComplexOperator: BiComplexOperator
	{
		protected BiComplexToComplexOperator(IComplexExpression first, IComplexExpression last): base(first, last) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	public abstract class ScalarComplexToComplexOperator: ScalarComplexOperator
	{
		protected ScalarComplexToComplexOperator(IScalarExpression scalar, IComplexExpression complex): base(scalar, complex) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	public abstract class SingleComplexToComplexOperator: SingleComplexOperator
	{
		protected SingleComplexToComplexOperator(IComplexExpression sub): base(sub) {}
		public abstract IScalarExpression Real
		{
			get;
		}
		public abstract IScalarExpression Imag
		{
			get;
		}
		public virtual IComplexExpression ExpressionComplex
		{
			get	{return(new ScalarComplex(this.Real,this.Imag));}
		}
		public virtual ValueComplex Calculate()
		{
			return(this.ExpressionComplex.Calculate());
		}
		public virtual IComplexExpression Simplify()
		{
			return(new ScalarComplex(this.Real.Simplify(),this.Imag.Simplify()));
		}
	}
	*/
	#endregion

	#region SingleComplex Operations
	[ParsingObject(ParsingObjectType.OuterOperator,30,Character="|")]
	public class ComplexAbsolute: ScalarOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexAbsolute(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexAbsolute(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			return(Math.Sqrt(Math.Pow(sub.Real,2)+Math.Pow(sub.Imag,2)));
		}
		public override IScalarExpression Simplify()
		{
			IComplexExpression xc1 = parameters.Complex1.Simplify();
			ScalarComplex c = xc1.Expand();
			if(c.Real.IsEntity && c.Real.Calculate() == 0)
			{
				return new ScalarAbsolute(context,c.Imag).Simplify();
			}
			if(c.Imag.IsEntity && c.Imag.Calculate() == 0)
			{
				return new ScalarAbsolute(context,c.Real).Simplify();
			}
			return new ComplexAbsolute(context,xc1);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="arg")]
	public class ComplexArgument: ScalarOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexArgument(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexArgument(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			return(Math.Atan2(sub.Imag,sub.Real));
		}
		public override IScalarExpression Simplify()
		{
			IComplexExpression xc1 = parameters.Complex1.Simplify();
			ScalarComplex c = xc1.Expand();
			if(c.Real.IsEntity && c.Real.Calculate() == 0)
			{
				if(!c.Imag.IsEntity)
				{
					return new ScalarDivision(context,new ScalarMultiplication(context,new ConstantPi(context),new ScalarSign(context,c.Imag)),ScalarExpressionValue.Two(context));
				}
				else
				{
					if(c.Imag.Calculate() > 0)
						return new ScalarDivision(context,new ConstantPi(context),new ScalarExpressionValue(context,2));
					if(c.Imag.Calculate() < 0)
						return new ScalarDivision(context,new ConstantPi(context),new ScalarExpressionValue(context,-2));
					return ScalarExpressionValue.Zero(context);
				}
			}
			if(c.Imag.IsEntity && c.Imag.Calculate() == 0)
			{
				return new ScalarDivision(context,new ScalarSubtraction(context,new ConstantPi(context),new ScalarMultiplication(context,new ConstantPi(context),new ScalarSign(context,c.Real))),ScalarExpressionValue.Two(context)).Simplify();
			}
			return new ComplexArgument(context,xc1);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="real")]
	public class ComplexReal: ScalarOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexReal(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexReal(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
	
		public override double Calculate()
		{
			return parameters.Complex1.ExpandReal().Calculate();
		}
		public override IScalarExpression Simplify()
		{
			if(parameters.Complex1.IsConstant)
				return parameters.Complex1.ExpandReal().Simplify();
			return base.Simplify ();
		}
		public override IScalarExpression Expand()
		{
			return parameters.Complex1.ExpandReal().Expand();
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="imag")]
	public class ComplexImag: ScalarOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexImag(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexImag(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			return parameters.Complex1.ExpandImag().Calculate();
		}
		public override IScalarExpression Simplify()
		{
			if(parameters.Complex1.IsConstant)
				return parameters.Complex1.ExpandImag().Simplify();
			return base.Simplify();
		}
		public override IScalarExpression Expand()
		{
			return parameters.Complex1.ExpandImag().Expand();
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="sgn")]
	public class ComplexSign: ScalarOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexSign(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexSign(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override double Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			if(sub.Real > 0 || (sub.Real == 0 && sub.Imag > 0))
				return(1);
			if(sub.Real < 0 || (sub.Real == 0 && sub.Imag < 0))
				return(-1);
			return(0);
		}
	}
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class ComplexNegative: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexNegative(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexNegative(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			return new ScalarNegative(context,parameters.Complex1.ExpandReal());
		}
		public override IScalarExpression ExpandImag()
		{
			return new ScalarNegative(context,parameters.Complex1.ExpandImag());
		}
		public override ValueComplex Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			ValueComplex rsp;
			rsp.Real = -sub.Real;
			rsp.Imag = -sub.Imag;
			return rsp;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="conj")]
	public class ComplexConjugate: ComplexOperator
	{
		protected Complex1Parameters parameters;
		public Complex1Parameters Parameters {get {return parameters;}}
		public ComplexConjugate(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexConjugate(Context context, IComplexExpression sub): base(context)
		{
			this.parameters = new Complex1Parameters(sub);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			return parameters.Complex1.ExpandReal();
		}
		public override IScalarExpression ExpandImag()
		{
			return new ScalarNegative(context,parameters.Complex1.ExpandImag());
		}
		public override ValueComplex Calculate()
		{
			ValueComplex sub = parameters.Complex1.Calculate();
			ValueComplex rsp;
			rsp.Real = sub.Real;
			rsp.Imag = -sub.Imag;
			return(rsp);
		}
	}
	#endregion

	#region BiComplex Operations
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexMultiplication: ComplexOperator
	{
		protected Complex2Parameters parameters;
		public Complex2Parameters Parameters {get {return parameters;}}
		public ComplexMultiplication(Context context, Complex2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMultiplication(Context context, IComplexExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last);
			Init(parameters);
		}
		public ComplexMultiplication(Context context, IComplexExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last.ToComplex());
			Init(parameters);
		}
		public ComplexMultiplication(Context context, IScalarExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first.ToComplex(),last);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c1 = parameters.Complex1.Expand();
			ScalarComplex c2 = parameters.Complex2.Expand();
			return new ScalarSubtraction(context,new ScalarMultiplication(context,c1.Real,c2.Real),new ScalarMultiplication(context,c1.Imag,c2.Imag));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c1 = parameters.Complex1.Expand();
			ScalarComplex c2 = parameters.Complex2.Expand();
			return new ScalarAddition(context,new ScalarMultiplication(context,c1.Real,c2.Imag),new ScalarMultiplication(context,c1.Imag,c2.Real));
		}
		public override ValueComplex Calculate()
		{
			ValueComplex a = parameters.Complex1.Calculate();
			ValueComplex b = parameters.Complex2.Calculate();
			ValueComplex rsp;
			rsp.Real = a.Real * b.Real - a.Imag * b.Imag;
			rsp.Imag = a.Real * b.Imag + a.Imag * b.Real;
			return(rsp);
		}
		public override IComplexExpression Simplify()
		{
			IComplexExpression a = parameters.Complex1.Simplify();
			IComplexExpression b = parameters.Complex2.Simplify();
			if(a.Equals(ScalarComplex.Zero(context)) || b.Equals(ScalarComplex.Zero(context)))
				return ScalarComplex.Zero(context);
			if(a.Equals(ScalarComplex.One(context)))
				return b;
			if(b.Equals(ScalarComplex.One(context)))
				return a;
			return new ComplexMultiplication(context,a,b);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class ComplexAddition: ComplexOperator
	{
		protected Complex2Parameters parameters;
		public Complex2Parameters Parameters {get {return parameters;}}
		public ComplexAddition(Context context, Complex2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexAddition(Context context, IComplexExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last);
			Init(parameters);
		}
		public ComplexAddition(Context context, IComplexExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last.ToComplex());
			Init(parameters);
		}
		public ComplexAddition(Context context, IScalarExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first.ToComplex(),last);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			return new ScalarAddition(context,parameters.Complex1.ExpandReal(),parameters.Complex2.ExpandReal());
		}
		public override IScalarExpression ExpandImag()
		{
			return new ScalarAddition(context,parameters.Complex1.ExpandImag(),parameters.Complex2.ExpandImag());
		}
		public override ValueComplex Calculate()
		{
			ValueComplex a = parameters.Complex1.Calculate();
			ValueComplex b = parameters.Complex2.Calculate();
			ValueComplex rsp;
			rsp.Real = a.Real + b.Real;
			rsp.Imag = a.Imag + b.Imag;
			return(rsp);
		}
		public override IComplexExpression Simplify()
		{
			IComplexExpression a = parameters.Complex1.Simplify();
			IComplexExpression b = parameters.Complex2.Simplify();
			if(a.Equals(ScalarComplex.Zero(context)))
				return b;
			if(b.Equals(ScalarComplex.Zero(context)))
				return a;
			return new ComplexAddition(context,a,b);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class ComplexSubtraction: ComplexOperator
	{
		protected Complex2Parameters parameters;
		public Complex2Parameters Parameters {get {return parameters;}}
		public ComplexSubtraction(Context context, Complex2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexSubtraction(Context context, IComplexExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last);
			Init(parameters);
		}
		public ComplexSubtraction(Context context, IComplexExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last.ToComplex());
			Init(parameters);
		}
		public ComplexSubtraction(Context context, IScalarExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first.ToComplex(),last);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			return new ScalarSubtraction(context,parameters.Complex1.ExpandReal(),parameters.Complex2.ExpandReal());
		}
		public override IScalarExpression ExpandImag()
		{
			return new ScalarSubtraction(context,parameters.Complex1.ExpandImag(),parameters.Complex2.ExpandImag());
		}
		public override ValueComplex Calculate()
		{
			ValueComplex a = parameters.Complex1.Calculate();
			ValueComplex b = parameters.Complex2.Calculate();
			ValueComplex rsp;
			rsp.Real = a.Real - b.Real;
			rsp.Imag = a.Imag - b.Imag;
			return(rsp);
		}
		public override IComplexExpression Simplify()
		{
			IComplexExpression a = parameters.Complex1.Simplify();
			IComplexExpression b = parameters.Complex2.Simplify();
			if(a.Equals(ScalarComplex.Zero(context)))
				return new ComplexNegative(context,b);
			if(b.Equals(ScalarComplex.Zero(context)))
				return a;
			return new ComplexSubtraction(context,a,b);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="/")]
	public class ComplexDivision: ComplexOperator
	{
		protected Complex2Parameters parameters;
		public Complex2Parameters Parameters {get {return parameters;}}
		public ComplexDivision(Context context, Complex2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexDivision(Context context, IComplexExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last);
			Init(parameters);
		}
		public ComplexDivision(Context context, IComplexExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last.ToComplex());
			Init(parameters);
		}
		public ComplexDivision(Context context, IScalarExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first.ToComplex(),last);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c1 = parameters.Complex1.Expand();
			ScalarComplex c2 = parameters.Complex2.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,c2.Real),new ScalarSquare(context,c2.Imag));
			return new ScalarAddition(context,new ScalarDivision(context,new ScalarMultiplication(context,c1.Real,c2.Real),a),new ScalarDivision(context,new ScalarMultiplication(context,c1.Imag,c2.Imag),a));
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c1 = parameters.Complex1.Expand();
			ScalarComplex c2 = parameters.Complex2.Expand();
			ScalarAddition a = new ScalarAddition(context,new ScalarSquare(context,c2.Real),new ScalarSquare(context,c2.Imag));
			return new ScalarSubtraction(context,new ScalarDivision(context,new ScalarMultiplication(context,c1.Imag,c2.Real),a),new ScalarDivision(context,new ScalarMultiplication(context,c1.Real,c2.Imag),a));
		}
		public override ValueComplex Calculate()
		{
			ValueComplex a = parameters.Complex1.Calculate();
			ValueComplex b = parameters.Complex2.Calculate();
			ValueComplex rsp;
			double c = Math.Pow(b.Real,2) + Math.Pow(b.Imag,2);
			rsp.Real = a.Real * b.Real / c + a.Imag * b.Imag / c;
			rsp.Imag = a.Imag * b.Real / c - a.Real * b.Imag / c;
			return(rsp);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,40,Character="^")]
	public class ComplexRaiseToPower: ComplexOperator
	{
		protected Complex2Parameters parameters;
		public Complex2Parameters Parameters {get {return parameters;}}
		public ComplexRaiseToPower(Context context, Complex2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexRaiseToPower(Context context, IComplexExpression expr, IComplexExpression power): base(context)
		{
			this.parameters = new Complex2Parameters(expr,power);
			Init(parameters);
		}
		public ComplexRaiseToPower(Context context, IComplexExpression first, IScalarExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first,last.ToComplex());
			Init(parameters);
		}
		public ComplexRaiseToPower(Context context, IScalarExpression first, IComplexExpression last): base(context)
		{
			this.parameters = new Complex2Parameters(first.ToComplex(),last);
			Init(parameters);
		}
		public override IScalarExpression ExpandReal()
		{
			ScalarComplex c1 = parameters.Complex1.Expand();
			ScalarComplex c2 = parameters.Complex2.Expand();
			IScalarExpression arg = new ComplexArgument(context,c1);
			IScalarExpression bin = new ScalarDivision(context,new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarSquare(context,c1.Real),new ScalarSquare(context,c1.Imag))),ScalarExpressionValue.Two(context));
			IScalarExpression part1 = new ScalarExponential(context,new ScalarSubtraction(context,new ScalarMultiplication(context,bin,c2.Real),new ScalarMultiplication(context,arg,c2.Imag)));
			IScalarExpression part2 = new ScalarTrigCosinus(context,new ScalarAddition(context,new ScalarMultiplication(context,bin,c2.Imag),new ScalarMultiplication(context,arg,c2.Real)));
			return new ScalarMultiplication(context,part1,part2);
		}
		public override IScalarExpression ExpandImag()
		{
			ScalarComplex c1 = parameters.Complex1.Expand();
			ScalarComplex c2 = parameters.Complex2.Expand();
			IScalarExpression arg = new ComplexArgument(context,c1);
			IScalarExpression bin = new ScalarDivision(context,new ScalarNaturalLogarithm(context,new ScalarAddition(context,new ScalarSquare(context,c1.Real),new ScalarSquare(context,c1.Imag))),ScalarExpressionValue.Two(context));
			IScalarExpression part1 = new ScalarExponential(context,new ScalarSubtraction(context,new ScalarMultiplication(context,bin,c2.Real),new ScalarMultiplication(context,arg,c2.Imag)));
			IScalarExpression part2 = new ScalarTrigSinus(context,new ScalarAddition(context,new ScalarMultiplication(context,bin,c2.Imag),new ScalarMultiplication(context,arg,c2.Real)));
			return new ScalarMultiplication(context,part1,part2);
		}
	}
	#endregion

	#region Complex Conversion Maps
	public abstract class ComplexMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IComplexExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IComplexExpression ex = exp as IComplexExpression;
			bool res = ConvertTo(ref ex);
			if(res)
				exp = ex;
			return(res);
		}
	}
	public class ComplexConversionMap
	{
		public static void Convert(ref IComplexExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(ComplexMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	#endregion
}
