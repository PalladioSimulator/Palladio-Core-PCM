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

namespace cdrnet.Lib.MathLib.Literal
{
	//new stuff

	#region Literal Parameters
	public class Literal1Parameters: Parameters
	{
		private ILiteralExpression literal1;
		public Literal1Parameters() : base(1) {}
		public Literal1Parameters(ILiteralExpression t1) : base(1)
		{
			literal1 = t1;
		}
		public ILiteralExpression Literal1
		{
			get {return literal1;}
			set {literal1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			LiteralConversionMap.Convert(ref literal1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Literal1Parameters(literal1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Literal1Parameters(literal1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Literal1Parameters(literal1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return literal1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Literal2Parameters: Parameters
	{
		private ILiteralExpression literal1, literal2;
		public Literal2Parameters() : base(2) {}
		public Literal2Parameters(ILiteralExpression t1, ILiteralExpression t2) : base(2)
		{
			literal1 = t1;
			literal2 = t2;
		}
		public ILiteralExpression Literal1
		{
			get {return literal1;}
			set {literal1 = value;}
		}
		public ILiteralExpression Literal2
		{
			get {return literal2;}
			set {literal2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			LiteralConversionMap.Convert(ref literal1, conversionType);
			LiteralConversionMap.Convert(ref literal2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Literal2Parameters(literal1.Simplify(),literal2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Literal2Parameters(literal1.Expand(),literal2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Literal2Parameters(literal1.Substitute(original,replacement),literal2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return literal1;
					case 1:
						return literal2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar Literal Parameters
	public class Scalar1Literal1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private ILiteralExpression literal1;
		public Scalar1Literal1Parameters() : base(2) {}
		public Scalar1Literal1Parameters(IScalarExpression s1, ILiteralExpression ts1) : base(2)
		{
			scalar1 = s1;
			literal1 = ts1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public ILiteralExpression Literal1
		{
			get {return literal1;}
			set {literal1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			LiteralConversionMap.Convert(ref literal1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1Literal1Parameters(scalar1.Simplify(),literal1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1Literal1Parameters(scalar1.Expand(),literal1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1Literal1Parameters(scalar1.Substitute(original,replacement),literal1.Substitute(original,replacement));
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
						return literal1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Literal Operator
	///<remarks>
	/// <b>Deriving from this operator base</b><br/>
	/// Please note that it's important to overload at least either
	/// Expand() or all the following: Calculate()
	/// to avoid infinite loops!
	/// </remarks>
	public abstract class LiteralOperator: MathExpression, ILiteralExpression
	{
		public LiteralOperator(Context context): base(context) {}
		public virtual string Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual ILiteralExpression Expand()
		{
			return (ILiteralExpression) InnerExpand();
		}
		public ILiteralExpression SafeExpand()
		{
			return (ILiteralExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual ILiteralExpression Simplify()
		{
			return (ILiteralExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual ILiteralExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ILiteralExpression) InnerSubstitute(original,replacement);
		}
		#endregion
	}
	#endregion

	//old stuff

	#region Literal Operator Base (deactive)
	/*
	public abstract class BiLiteralOperator
	{
		protected ILiteralExpression first, last;
		private int priority;
		protected BiLiteralOperator(ILiteralExpression first, ILiteralExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public ILiteralExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ILiteralExpression AfterExpression
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
			LiteralConversionMap.Convert(ref first,conversionType);
			LiteralConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiLiteralOperator x = exp as BiLiteralOperator;
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
	public abstract class SingleLiteralOperator
	{
		protected ILiteralExpression sub;
		private int priority;
		protected SingleLiteralOperator(ILiteralExpression sub)
		{
			this.sub = sub;
		}
		public ILiteralExpression SubExpression
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
			LiteralConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleLiteralOperator x = exp as SingleLiteralOperator;
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
	public abstract class TriLiteralOperator
	{
		protected ILiteralExpression first, middle, last;
		private int priority;
		protected TriLiteralOperator(ILiteralExpression first, ILiteralExpression middle, ILiteralExpression last)
		{
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public ILiteralExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ILiteralExpression MiddleExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public ILiteralExpression AfterExpression
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
			get {return(first.IsConstant && middle.IsConstant && last.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			LiteralConversionMap.Convert(ref first,conversionType);
			LiteralConversionMap.Convert(ref middle,conversionType);
			LiteralConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriLiteralOperator x = exp as TriLiteralOperator;
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
	*/
	#endregion

	#region Literal/Scalar Operator Base (deactive)
	/*
	public abstract class ScalarLiteralOperator
	{
		protected ILiteralExpression literal;
		protected IScalarExpression scalar;
		private int priority;
		protected ScalarLiteralOperator(ILiteralExpression literal, IScalarExpression scalar)
		{
			this.literal = literal;
			this.scalar = scalar;
		}
		public ILiteralExpression LiteralExpression
		{
			set {literal = value;}
			get {return(literal);}
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
			get {return(scalar.IsConstant && literal.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			LiteralConversionMap.Convert(ref literal,conversionType);
			ScalarConversionMap.Convert(ref scalar,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarLiteralOperator x = exp as ScalarLiteralOperator;
				if(x.scalar.IsEqualTo(this.scalar) && x.literal.IsEqualTo(this.literal))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			literal.CollectVariables(vars,deep);
			scalar.CollectVariables(vars,deep);
		}
	}
	*/
	#endregion
}
