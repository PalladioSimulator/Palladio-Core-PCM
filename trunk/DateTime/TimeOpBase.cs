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

namespace cdrnet.Lib.MathLib.Time
{
	//new stuff

	#region Time Parameters
	public class Time1Parameters: Parameters
	{
		private ITimeExpression time1;
		public Time1Parameters() : base(1) {}
		public Time1Parameters(ITimeExpression t1) : base(1)
		{
			time1 = t1;
		}
		public ITimeExpression Time1
		{
			get {return time1;}
			set {time1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TimeConversionMap.Convert(ref time1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Time1Parameters(time1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Time1Parameters(time1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Time1Parameters(time1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return time1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class Time2Parameters: Parameters
	{
		private ITimeExpression time1, time2;
		public Time2Parameters() : base(2) {}
		public Time2Parameters(ITimeExpression t1, ITimeExpression t2) : base(2)
		{
			time1 = t1;
			time2 = t2;
		}
		public ITimeExpression Time1
		{
			get {return time1;}
			set {time1 = value;}
		}
		public ITimeExpression Time2
		{
			get {return time2;}
			set {time2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TimeConversionMap.Convert(ref time1, conversionType);
			TimeConversionMap.Convert(ref time2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Time2Parameters(time1.Simplify(),time2.Simplify());
		}
		public override Parameters Expand()
		{
			return new Time2Parameters(time1.Expand(),time2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Time2Parameters(time1.Substitute(original,replacement),time2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return time1;
					case 1:
						return time2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region TimeSpan Parameters
	public class TimeSpan1Parameters: Parameters
	{
		private ITimeSpanExpression timespan1;
		public TimeSpan1Parameters() : base(1) {}
		public TimeSpan1Parameters(ITimeSpanExpression ts1) : base(1)
		{
			timespan1 = ts1;
		}
		public ITimeSpanExpression TimeSpan1
		{
			get {return timespan1;}
			set {timespan1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TimeSpanConversionMap.Convert(ref timespan1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new TimeSpan1Parameters(timespan1.Simplify());
		}
		public override Parameters Expand()
		{
			return new TimeSpan1Parameters(timespan1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new TimeSpan1Parameters(timespan1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return timespan1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	public class TimeSpan2Parameters: Parameters
	{
		private ITimeSpanExpression timespan1, timespan2;
		public TimeSpan2Parameters() : base(2) {}
		public TimeSpan2Parameters(ITimeSpanExpression t1, ITimeSpanExpression t2) : base(2)
		{
			timespan1 = t1;
			timespan2 = t2;
		}
		public ITimeSpanExpression TimeSpan1
		{
			get {return timespan1;}
			set {timespan1 = value;}
		}
		public ITimeSpanExpression TimeSpan2
		{
			get {return timespan2;}
			set {timespan2 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TimeSpanConversionMap.Convert(ref timespan1, conversionType);
			TimeSpanConversionMap.Convert(ref timespan2, conversionType);
		}
		public override Parameters Simplify()
		{
			return new TimeSpan2Parameters(timespan1.Simplify(),timespan2.Simplify());
		}
		public override Parameters Expand()
		{
			return new TimeSpan2Parameters(timespan1.Expand(),timespan2.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new TimeSpan2Parameters(timespan1.Substitute(original,replacement),timespan2.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return timespan1;
					case 1:
						return timespan2;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Time TimeSpan Parameters
	public class Time1TimeSpan1Parameters: Parameters
	{
		private ITimeExpression time1;
		private ITimeSpanExpression timespan1;
		public Time1TimeSpan1Parameters() : base(2) {}
		public Time1TimeSpan1Parameters(ITimeExpression t1, ITimeSpanExpression ts1) : base(2)
		{
			time1 = t1;
			timespan1 = ts1;
		}
		public ITimeExpression Time1
		{
			get {return time1;}
			set {time1 = value;}
		}
		public ITimeSpanExpression TimeSpan1
		{
			get {return timespan1;}
			set {timespan1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			TimeConversionMap.Convert(ref time1, conversionType);
			TimeSpanConversionMap.Convert(ref timespan1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Time1TimeSpan1Parameters(time1.Simplify(),timespan1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Time1TimeSpan1Parameters(time1.Expand(),timespan1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Time1TimeSpan1Parameters(time1.Substitute(original,replacement),timespan1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return time1;
					case 1:
						return timespan1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion
	#region Scalar TimeSpan Parameters
	public class Scalar1TimeSpan1Parameters: Parameters
	{
		private IScalarExpression scalar1;
		private ITimeSpanExpression timespan1;
		public Scalar1TimeSpan1Parameters() : base(2) {}
		public Scalar1TimeSpan1Parameters(IScalarExpression s1, ITimeSpanExpression ts1) : base(2)
		{
			scalar1 = s1;
			timespan1 = ts1;
		}
		public IScalarExpression Scalar1
		{
			get {return scalar1;}
			set {scalar1 = value;}
		}
		public ITimeSpanExpression TimeSpan1
		{
			get {return timespan1;}
			set {timespan1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar1, conversionType);
			TimeSpanConversionMap.Convert(ref timespan1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new Scalar1TimeSpan1Parameters(scalar1.Simplify(),timespan1.Simplify());
		}
		public override Parameters Expand()
		{
			return new Scalar1TimeSpan1Parameters(scalar1.Expand(),timespan1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new Scalar1TimeSpan1Parameters(scalar1.Substitute(original,replacement),timespan1.Substitute(original,replacement));
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
						return timespan1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region Time, TimeSpan Operators
	///<remarks>
	/// <b>Deriving from this operator base</b><br/>
	/// Please note that it's important to overload at least either
	/// Expand() or all the following: Calculate()
	/// to avoid infinite loops!
	/// </remarks>
	public abstract class TimeOperator: MathExpression, ITimeExpression
	{
		public TimeOperator(Context context): base(context) {}
		public virtual DateTime Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual ITimeExpression Expand()
		{
			return (ITimeExpression) InnerExpand();
		}
		public ITimeExpression SafeExpand()
		{
			return (ITimeExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual ITimeExpression Simplify()
		{
			return (ITimeExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual ITimeExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITimeExpression) InnerSubstitute(original,replacement);
		}
		#endregion
	}
	///<remarks>
	/// <b>Deriving from this operator base</b><br/>
	/// Please note that it's important to overload at least either
	/// Expand() or all the following: Calculate()
	/// to avoid infinite loops!
	/// </remarks>
	public abstract class TimeSpanOperator: MathExpression, ITimeSpanExpression
	{
		public TimeSpanOperator(Context context): base(context) {}
		public virtual TimeSpan Calculate()
		{
			return Expand().Calculate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public virtual ITimeSpanExpression Expand()
		{
			return (ITimeSpanExpression) InnerExpand();
		}
		public ITimeSpanExpression SafeExpand()
		{
			return (ITimeSpanExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify ();
		}
		public virtual ITimeSpanExpression Simplify()
		{
			return (ITimeSpanExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual ITimeSpanExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITimeSpanExpression) InnerSubstitute(original,replacement);
		}
		#endregion
	}
	#endregion

	//old stuff

	#region Time Operator Base (deactive)
	/*
	public abstract class BiTimeOperator
	{
		protected ITimeExpression first, last;
		private int priority;
		protected BiTimeOperator(ITimeExpression first, ITimeExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public ITimeExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ITimeExpression AfterExpression
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
			TimeConversionMap.Convert(ref first,conversionType);
			TimeConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiTimeOperator x = exp as BiTimeOperator;
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
	public abstract class SingleTimeOperator
	{
		protected ITimeExpression sub;
		private int priority;
		protected SingleTimeOperator(ITimeExpression sub)
		{
			this.sub = sub;
		}
		public ITimeExpression SubExpression
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
			TimeConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleTimeOperator x = exp as SingleTimeOperator;
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
	public abstract class TriTimeOperator
	{
		protected ITimeExpression first, middle, last;
		private int priority;
		protected TriTimeOperator(ITimeExpression first, ITimeExpression middle, ITimeExpression last)
		{
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public ITimeExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ITimeExpression MiddleExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public ITimeExpression AfterExpression
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
			TimeConversionMap.Convert(ref first,conversionType);
			TimeConversionMap.Convert(ref middle,conversionType);
			TimeConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriTimeOperator x = exp as TriTimeOperator;
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
	#endregion
	#region TimeSpan Operator Base
	public abstract class BiTimeSpanOperator
	{
		protected ITimeSpanExpression first, last;
		private int priority;
		protected BiTimeSpanOperator(ITimeSpanExpression first, ITimeSpanExpression last)
		{
			this.first = first;
			this.last = last;
		}
		public ITimeSpanExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ITimeSpanExpression AfterExpression
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
			TimeSpanConversionMap.Convert(ref first,conversionType);
			TimeSpanConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				BiTimeSpanOperator x = exp as BiTimeSpanOperator;
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
	public abstract class SingleTimeSpanOperator
	{
		protected ITimeSpanExpression sub;
		private int priority;
		protected SingleTimeSpanOperator(ITimeSpanExpression sub)
		{
			this.sub = sub;
		}
		public ITimeSpanExpression SubExpression
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
			TimeSpanConversionMap.Convert(ref sub,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				SingleTimeSpanOperator x = exp as SingleTimeSpanOperator;
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
	public abstract class TriTimeSpanOperator
	{
		protected ITimeSpanExpression first, middle, last;
		private int priority;
		protected TriTimeSpanOperator(ITimeSpanExpression first, ITimeSpanExpression middle, ITimeSpanExpression last)
		{
			this.first = first;
			this.middle = middle;
			this.last = last;
		}
		public ITimeSpanExpression PreExpression
		{
			set {first = value;}
			get {return(first);}
		}
		public ITimeSpanExpression MiddleExpression
		{
			set {middle = value;}
			get {return(middle);}
		}
		public ITimeSpanExpression AfterExpression
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
			TimeSpanConversionMap.Convert(ref first,conversionType);
			TimeSpanConversionMap.Convert(ref middle,conversionType);
			TimeSpanConversionMap.Convert(ref last,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TriTimeSpanOperator x = exp as TriTimeSpanOperator;
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
	#endregion

	#region Time/TimeSpan Base
	public abstract class TimeTimeSpanOperator
	{
		protected ITimeExpression time;
		protected ITimeSpanExpression span;
		private int priority;
		protected TimeTimeSpanOperator(ITimeExpression time, ITimeSpanExpression span)
		{
			this.time = time;
			this.span = span;
		}
		public ITimeExpression TimeExpression
		{
			set {time = value;}
			get {return(time);}
		}
		public ITimeSpanExpression TimeSpanExpression
		{
			set {span = value;}
			get {return(span);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(time.IsConstant && span.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			TimeConversionMap.Convert(ref time,conversionType);
			TimeSpanConversionMap.Convert(ref span,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				TimeTimeSpanOperator x = exp as TimeTimeSpanOperator;
				if(x.time.Equals(this.time) && x.span.Equals(this.span))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			time.CollectVariables(vars,deep);
			span.CollectVariables(vars,deep);
		}
	}
	#endregion
	#region Scalar/TimeSpan Base
	public abstract class ScalarTimeSpanOperator
	{
		protected IScalarExpression scalar;
		protected ITimeSpanExpression span;
		private int priority;
		protected ScalarTimeSpanOperator(IScalarExpression scalar, ITimeSpanExpression span)
		{
			this.scalar = scalar;
			this.span = span;
		}
		public IScalarExpression ScalarExpression
		{
			set {scalar = value;}
			get {return(scalar);}
		}
		public ITimeSpanExpression TimeSpanExpression
		{
			set {span = value;}
			get {return(span);}
		}
		public int Priority
		{
			set {priority = value;}
			get {return(priority);}
		}
		public bool IsConstant
		{
			get {return(scalar.IsConstant && span.IsConstant);}
		}
		public virtual bool IsEntity
		{
			get {return(false);}
		}
		public void ConvertChilds(string conversionType)
		{
			ScalarConversionMap.Convert(ref scalar,conversionType);
			TimeSpanConversionMap.Convert(ref span,conversionType);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == this.GetType())
			{
				ScalarTimeSpanOperator x = exp as ScalarTimeSpanOperator;
				if(x.scalar.Equals(this.scalar) && x.span.Equals(this.span))
					return(true);
			}
			return(false);
		}
		public void CollectVariables(VariableManager vars, bool deep)
		{
			scalar.CollectVariables(vars,deep);
			span.CollectVariables(vars,deep);
		}
	}
	*/
	#endregion
}
