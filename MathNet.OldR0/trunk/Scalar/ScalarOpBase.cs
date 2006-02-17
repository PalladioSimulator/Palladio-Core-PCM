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
using cdrnet.Lib.MathLib.Complex;

namespace cdrnet.Lib.MathLib.Scalar
{
	//new stuff

	#region Scalar Parameters
	public class Scalar1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		public Scalar1Parameters() : base(1) {}
		public Scalar1Parameters(IScalarExpression s1) : base(1)
		{
			scalar1 = s1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Parameters(scalar1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Parameters(scalar1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Parameters(scalar1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return scalar1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar2Parameters: Parameters
	{
		protected IScalarExpression scalar1, scalar2;
		public Scalar2Parameters() : base(2) {}
		public Scalar2Parameters(IScalarExpression s1, IScalarExpression s2) : base(2)
		{
			scalar1 = s1;
			scalar2 = s2;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar2Parameters(scalar1.Simplify(),scalar2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar2Parameters(scalar1.Expand(),scalar2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar2Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement));
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
						return scalar2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar3Parameters: Parameters
	{
		protected IScalarExpression scalar1, scalar2, scalar3;
		public Scalar3Parameters() : base(3) {}
		public Scalar3Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3) : base(3)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public IScalarExpression Scalar3
		{
			get {return scalar3;}
			set {scalar3 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar3Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar3Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar3Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement));
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
						return scalar2;
					case 2:
						return scalar3;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar4Parameters: Parameters
	{
		protected IScalarExpression scalar1, scalar2, scalar3, scalar4;
		public Scalar4Parameters() : base(4) {}
		public Scalar4Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3, IScalarExpression s4) : base(4)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
			scalar4 = s4;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public IScalarExpression Scalar3
		{
			get {return scalar3;}
			set {scalar3 = value;}
		}
		public IScalarExpression Scalar4
		{
			get {return scalar4;}
			set {scalar4 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
			ScalarConversionMap.Convert(ref scalar4, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar4Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify(),scalar4.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar4Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand(),scalar4.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar4Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement),scalar4.Substitute(original,replacement));
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
						return scalar2;
					case 2:
						return scalar3;
					case 3:
						return scalar4;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Scalar5Parameters: Parameters
	{
		protected IScalarExpression scalar1, scalar2, scalar3, scalar4, scalar5;
		public Scalar5Parameters() : base(5) {}
		public Scalar5Parameters(IScalarExpression s1, IScalarExpression s2, IScalarExpression s3, IScalarExpression s4, IScalarExpression s5) : base(5)
		{
			scalar1 = s1;
			scalar2 = s2;
			scalar3 = s3;
			scalar4 = s4;
			scalar5 = s5;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public IScalarExpression Scalar2
		{
			get {return scalar2;}
			set {scalar2 = value;}
		}
		public IScalarExpression Scalar3
		{
			get {return scalar3;}
			set {scalar3 = value;}
		}
		public IScalarExpression Scalar4
		{
			get {return scalar4;}
			set {scalar4 = value;}
		}
		public IScalarExpression Scalar5
		{
			get {return scalar5;}
			set {scalar5 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			ScalarConversionMap.Convert(ref scalar2, conversionType);
			ScalarConversionMap.Convert(ref scalar3, conversionType);
			ScalarConversionMap.Convert(ref scalar4, conversionType);
			ScalarConversionMap.Convert(ref scalar5, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar5Parameters(scalar1.Simplify(),scalar2.Simplify(),scalar3.Simplify(),scalar4.Simplify(),scalar5.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar5Parameters(scalar1.Expand(),scalar2.Expand(),scalar3.Expand(),scalar4.Expand(),scalar5.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar5Parameters(scalar1.Substitute(original,replacement),scalar2.Substitute(original,replacement),
				scalar3.Substitute(original,replacement),scalar4.Substitute(original,replacement),scalar5.Substitute(original,replacement));
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
						return scalar2;
					case 2:
						return scalar3;
					case 3:
						return scalar4;
					case 4:
						return scalar5;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Scalar Operator
	/// <summary>
	/// ScalarOperator is a base operator for operators
	/// returning an <see cref="IScalarExpression"/>.
	/// </summary>
	/// <remarks>
	/// <b>Deriving from this operator base</b><br/>
	/// Please note that it's important to overload at least either
	/// Expand() or all the following: Calculate()
	/// to avoid infinite loops!
	/// </remarks>
	public abstract class ScalarOperator: MathExpression, IScalarExpression
	{
		public ScalarOperator(Context context): base(context) {}
		public virtual double Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual IScalarExpression Expand()
		{
			return (IScalarExpression) InnerExpand();
		}
		public IScalarExpression SafeExpand()
		{
			return (IScalarExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IScalarExpression Simplify()
		{
			return (IScalarExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IScalarExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IScalarExpression) InnerSubstitute(original,replacement);
		}
		#endregion

		public virtual IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			return new ScalarDerive(context,this,var);
		}
		public virtual IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			return new ScalarIntegrate(context,this,var);
		}
		public IComplexExpression ToComplex()
		{
			return new ScalarComplex(context,this,ScalarExpressionValue.Zero(context));
		}
	}
	#endregion

	//old stuff

	#region Operator Base (deactive)
	/*
	public abstract class BiScalarOperator
	{
		protected IScalarExpression first, last;
		private int priority;
		protected BiScalarOperator(IScalarExpression first, IScalarExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public IScalarExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public virtual bool IsConstant
		{
			get {return(first.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiScalarOperator x = exp as BiScalarOperator;
				//override this method if not true!!
				if(x.first.Equals(this.first) && x.last.Equals(this.last) || x.first.Equals(this.last) && x.last.Equals(this.first))
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
	public abstract class SingleScalarOperator
	{
		protected IScalarExpression sub;
		private int priority;
		protected SingleScalarOperator(IScalarExpression sub)
		{
			this.sub = sub;
		}
		public IScalarExpression SubExpression
		{
			set {sub = value;}
			get {return(sub);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public virtual bool IsConstant
		{
			get {return(sub.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleScalarOperator x = exp as SingleScalarOperator;
				//override this method if not true!!
				if(x.sub.Equals(this.sub))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			sub.CollectVariables(vars,deep);
		}
	}
	public abstract class TriScalarOperator
	{
		protected IScalarExpression first, middle, last;
		private int priority;
		protected TriScalarOperator(IScalarExpression first, IScalarExpression middle, IScalarExpression last)
		{
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public IScalarExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression MiddleExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public IScalarExpression AfterExpression
		{
			set {last = value;}
			get {return(last);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public virtual bool IsConstant
		{
			get {return(first.IsConstant && middle.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref middle,conversionType);
			ScalarConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriScalarOperator x = exp as TriScalarOperator;
				//override this method if not true!!
				if(x.first.Equals(this.first) && x.last.Equals(this.last) && x.middle.Equals(this.middle))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			middle.CollectVariables(vars,deep);
			last.CollectVariables(vars,deep);
		}
	}
	public abstract class FourScalarOperator
	{
		protected IScalarExpression first, second, third, fourth;
		private int priority;
		protected FourScalarOperator(IScalarExpression first, IScalarExpression second, IScalarExpression third, IScalarExpression fourth)
		{
			this.first = first;
			this.second = second;
			this.third = third;
			this.fourth = fourth;
		}
		public IScalarExpression FirstExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression SecondExpression
		{
			set {second = value;}
			get {return(second);}
		}
		public IScalarExpression ThirdExpression
		{
			set {third = value;}
			get {return(third);}
		}
		public IScalarExpression FourthExpression
		{
			set {fourth = value;}
			get {return(fourth);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public virtual bool IsConstant
		{
			get {return(first.IsConstant && second.IsConstant && third.IsConstant && fourth.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref second,conversionType);
			ScalarConversionMap.Convert(ref third,conversionType);
			ScalarConversionMap.Convert(ref fourth,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				FourScalarOperator x = exp as FourScalarOperator;
				if(x.first.Equals(this.first) && x.second.Equals(this.second) && x.third.Equals(this.third) && x.fourth.Equals(this.fourth))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			second.CollectVariables(vars,deep);
			third.CollectVariables(vars,deep);
			fourth.CollectVariables(vars,deep);
		}
	}
	public abstract class FiveScalarOperator
	{
		protected IScalarExpression first, second, third, fourth, fifth;
		private int priority;
		protected FiveScalarOperator(IScalarExpression first, IScalarExpression second, IScalarExpression third, IScalarExpression fourth, IScalarExpression fifth)
		{
			this.first = first;
			this.second = second;
			this.third = third;
			this.fourth = fourth;
			this.fifth = fifth;
		}
		public IScalarExpression FirstExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public IScalarExpression SecondExpression
		{
			set {second = value;}
			get {return(second);}
		}
		public IScalarExpression ThirdExpression
		{
			set {third = value;}
			get {return(third);}
		}
		public IScalarExpression FourthExpression
		{
			set {fourth = value;}
			get {return(fourth);}
		}
		public IScalarExpression FifthExpression
		{
			set {fifth = value;}
			get {return(fifth);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public virtual bool IsConstant
		{
			get {return(first.IsConstant && second.IsConstant && third.IsConstant && fourth.IsConstant && fifth.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref first,conversionType);
			ScalarConversionMap.Convert(ref second,conversionType);
			ScalarConversionMap.Convert(ref third,conversionType);
			ScalarConversionMap.Convert(ref fourth,conversionType);
			ScalarConversionMap.Convert(ref fifth,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				FiveScalarOperator x = exp as FiveScalarOperator;
				if(x.first.Equals(this.first) && x.second.Equals(this.second) && x.third.Equals(this.third) && x.fourth.Equals(this.fourth) && x.fifth.Equals(this.fifth))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			first.CollectVariables(vars,deep);
			second.CollectVariables(vars,deep);
			third.CollectVariables(vars,deep);
			fourth.CollectVariables(vars,deep);
			fifth.CollectVariables(vars,deep);
		}
	}
//	public abstract class EmptyOperator
//	{
//		private int priority;
//		public int Priority
//		{
//			set {priority = value;}
//			get {return(priority);}
//		}
//		public virtual bool IsEntity
//		{
//			get {return(false);}
//		}
//		public void ConvertChilds(string conversionType)
//		{
//		}
//		public override bool Equals(object exp)
//		{
//			if(exp.GetType() == this.GetType())
//				return(true);
//			return(false);
//		}
//		public void CollectVariables(VariableManager vars, bool deep)
//		{
//		}
//	}
*/
	#endregion

	#region Typed Operator Base (deactive)
	#endregion
}
