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
using cdrnet.Lib.MathLib.Literal;

namespace cdrnet.Lib.MathLib.Time
{
	#region Empty Operators
	/// <summary>
	/// Math.NET Operator: returns the current date & time
	/// </summary>
	/// <remarks>
	/// please note that the date/time is evaluated whenever you
	/// call the Calculate method, an that TimeNow replaces itself
	/// with its current value if Simplify is called.
	/// </remarks>
	[ParsingObject(ParsingObjectType.Function,250,Character="now")]
	public class TimeNow: TimeOperator
	{
		protected EmptyParameters parameters;
		public TimeNow(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeNow(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override DateTime Calculate()
		{
			return DateTime.Now;
		}
		public override string ToString()
		{
			return "now()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeExpression Simplify()
		{
			return TimeExpressionValue.Now(context);
		}
	}
	/// <summary>
	/// Math.NET Operator: returns the current date
	/// </summary>
	/// <remarks>
	/// please note that the date is evaluated whenever you call
	/// the Calculate method, an that TimeToday replaces itself
	/// with its current value if Simplify is called.
	/// </remarks>
	[ParsingObject(ParsingObjectType.Function,250,Character="today")]
	public class TimeToday: TimeOperator
	{
		protected EmptyParameters parameters;
		public TimeToday(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeToday(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override DateTime Calculate()
		{
			return DateTime.Today;
		}
		public override string ToString()
		{
			return "today()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeExpression Simplify()
		{
			return TimeExpressionValue.Today(context);
		}
	}
	/// <summary>
	/// Math.NET Operator: returns a 1 day time span
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="day")]
	public class TimeSpanDay: TimeSpanOperator
	{
		protected EmptyParameters parameters;
		public TimeSpanDay(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanDay(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return new TimeSpan(1,0,0,0);
		}
		public override string ToString()
		{
			return "day()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeSpanExpression Simplify()
		{
			return new TimeSpanExpressionValue(context,Calculate());
		}
	}
	/// <summary>
	/// Math.NET Operator: returns a 1 hour time span
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="hour")]
	public class TimeSpanHour: TimeSpanOperator
	{
		protected EmptyParameters parameters;
		public TimeSpanHour(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanHour(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return new TimeSpan(1,0,0);
		}
		public override string ToString()
		{
			return "hour()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeSpanExpression Simplify()
		{
			return new TimeSpanExpressionValue(context,Calculate());
		}
	}
	/// <summary>
	/// Math.NET Operator: returns a 1 minute time span
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="minute")]
	public class TimeSpanMinute: TimeSpanOperator
	{
		protected EmptyParameters parameters;
		public TimeSpanMinute(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanMinute(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return new TimeSpan(0,1,0);
		}
		public override string ToString()
		{
			return "minute()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeSpanExpression Simplify()
		{
			return new TimeSpanExpressionValue(context,Calculate());
		}
	}
	/// <summary>
	/// Math.NET Operator: returns a 1 second time span
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="second")]
	public class TimeSpanSecond: TimeSpanOperator
	{
		protected EmptyParameters parameters;
		public TimeSpanSecond(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanSecond(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return new TimeSpan(0,0,1);
		}
		public override string ToString()
		{
			return "second()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeSpanExpression Simplify()
		{
			return new TimeSpanExpressionValue(context,Calculate());
		}
	}
	/// <summary>
	/// Math.NET Operator: returns a 1 millisecond time span
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="millisecond")]
	public class TimeSpanMillisecond: TimeSpanOperator
	{
		protected EmptyParameters parameters;
		public TimeSpanMillisecond(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanMillisecond(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return new TimeSpan(0,0,0,0,1);
		}
		public override string ToString()
		{
			return "millisecond()";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
		public override ITimeSpanExpression Simplify()
		{
			return new TimeSpanExpressionValue(context,Calculate());
		}
	}
	#endregion

	#region Time Operations
	/// <summary>
	/// Math.NET Operator: returns the time span between to given dates/times
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class TimeDifference: TimeSpanOperator
	{
		protected Time2Parameters parameters;
		public Time2Parameters Parameters {get {return parameters;}}
		public TimeDifference(Context context, Time2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeDifference(Context context, ITimeExpression left, ITimeExpression right): base(context)
		{
			this.parameters = new Time2Parameters(left,right);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return parameters.Time1.Calculate()-parameters.Time2.Calculate();
		}
		public override ITimeSpanExpression Simplify()
		{
			ITimeExpression xt1 = parameters.Time1.Simplify();
			ITimeExpression xt2 = parameters.Time2.Simplify();
			if(xt1.Equals(xt2))
				return TimeSpanExpressionValue.Zero(context);
			if(xt1.IsConstant && xt2.IsConstant)
				return new TimeSpanExpressionValue(context,Calculate());
			return new TimeDifference(context,xt1,xt2);
		}
	}
	#endregion

	#region TimeSpan Operations
	/// <summary>
	/// Math.NET Operator: returns the sum of two time spans
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class TimeSpanAddition: TimeSpanOperator
	{
		protected TimeSpan2Parameters parameters;
		public TimeSpan2Parameters Parameters {get {return parameters;}}
		public TimeSpanAddition(Context context, TimeSpan2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanAddition(Context context, ITimeSpanExpression left, ITimeSpanExpression right): base(context)
		{
			this.parameters = new TimeSpan2Parameters(left,right);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return parameters.TimeSpan1.Calculate().Add(parameters.TimeSpan2.Calculate());
		}
		public override ITimeSpanExpression Simplify()
		{
			ITimeSpanExpression xt1 = parameters.TimeSpan1.Simplify();
			ITimeSpanExpression xt2 = parameters.TimeSpan2.Simplify();
			if(xt1.IsConstant && xt2.IsConstant)
				return new TimeSpanExpressionValue(context,Calculate());
			if(xt1.IsConstant && xt1.Calculate().Ticks == 0)
				return xt2;
			if(xt2.IsConstant && xt2.Calculate().Ticks == 0)
				return xt1;
			return new TimeSpanAddition(context,xt1,xt2);
		}
	}
	/// <summary>
	/// Math.NET Operator: returns the difference of two time spans
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class TimeSpanSubtraction: TimeSpanOperator
	{
		protected TimeSpan2Parameters parameters;
		public TimeSpan2Parameters Parameters {get {return parameters;}}
		public TimeSpanSubtraction(Context context, TimeSpan2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanSubtraction(Context context, ITimeSpanExpression left, ITimeSpanExpression right): base(context)
		{
			this.parameters = new TimeSpan2Parameters(left,right);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return parameters.TimeSpan1.Calculate().Subtract(parameters.TimeSpan2.Calculate());
		}
		public override ITimeSpanExpression Simplify()
		{
			ITimeSpanExpression xt1 = parameters.TimeSpan1.Simplify();
			ITimeSpanExpression xt2 = parameters.TimeSpan2.Simplify();
			if(xt1.IsConstant && xt2.IsConstant)
				return new TimeSpanExpressionValue(context,Calculate());
			if(xt1.IsConstant && xt1.Calculate().Ticks == 0)
				return new TimeSpanNegative(context, xt2);
			if(xt2.IsConstant && xt2.Calculate().Ticks == 0)
				return xt1;
			return new TimeSpanSubtraction(context,xt1,xt2);
		}
	}
	/// <summary>
	/// Math.NET Operator: returns the negative of a time span
	/// </summary>
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="-")]
	public class TimeSpanNegative: TimeSpanOperator
	{
		protected TimeSpan1Parameters parameters;
		public TimeSpan1Parameters Parameters {get {return parameters;}}
		public TimeSpanNegative(Context context, TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanNegative(Context context, ITimeSpanExpression sub): base(context)
		{
			this.parameters = new TimeSpan1Parameters(sub);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			return parameters.TimeSpan1.Calculate().Negate();
		}
		public override ITimeSpanExpression Simplify()
		{
			ITimeSpanExpression xt1 = parameters.TimeSpan1.Simplify();
			if(xt1.IsConstant)
				return new TimeSpanExpressionValue(context,Calculate());
			return new TimeSpanNegative(context,xt1);
		}
	}
	#endregion

	#region Time <-> TimeSpan Operations
	/// <summary>
	/// Math.NET Operator: returns the date shifted forward using the given time span
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class TimeAddition: TimeOperator
	{
		protected Time1TimeSpan1Parameters parameters;
		public Time1TimeSpan1Parameters Parameters {get {return parameters;}}
		public TimeAddition(Context context, Time1TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeAddition(Context context, ITimeSpanExpression delta, ITimeExpression time): base(context)
		{
			this.parameters = new Time1TimeSpan1Parameters(time,delta);
			Init(parameters);
		}
		public TimeAddition(Context context, ITimeExpression time, ITimeSpanExpression delta): base(context)
		{
			this.parameters = new Time1TimeSpan1Parameters(time,delta);
			Init(parameters);
		}
		public override DateTime Calculate()
		{
			return parameters.Time1.Calculate().Add(parameters.TimeSpan1.Calculate());
		}
		public override ITimeExpression Simplify()
		{
			ITimeExpression xt1 = parameters.Time1.Simplify();
			ITimeSpanExpression xts1 = parameters.TimeSpan1.Simplify();
			if(xts1.IsConstant && xts1.Calculate().Ticks == 0)
				return xt1;
			if(xt1.IsConstant && xts1.IsConstant)
				return new TimeExpressionValue(context,Calculate());
			return new TimeAddition(context,xt1,xts1);
		}
	}
	/// <summary>
	/// Math.NET Operator: returns the date shifted backward using the given time span
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class TimeSubtraction: TimeOperator
	{
		protected Time1TimeSpan1Parameters parameters;
		public Time1TimeSpan1Parameters Parameters {get {return parameters;}}
		public TimeSubtraction(Context context, Time1TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSubtraction(Context context, ITimeSpanExpression delta, ITimeExpression time): base(context)
		{
			this.parameters = new Time1TimeSpan1Parameters(time,delta);
			Init(parameters);
		}
		public TimeSubtraction(Context context, ITimeExpression time, ITimeSpanExpression delta): base(context)
		{
			this.parameters = new Time1TimeSpan1Parameters(time,delta);
			Init(parameters);
		}
		public override DateTime Calculate()
		{
			return parameters.Time1.Calculate().Subtract(parameters.TimeSpan1.Calculate());
		}
		public override ITimeExpression Simplify()
		{
			ITimeExpression xt1 = parameters.Time1.Simplify();
			ITimeSpanExpression xts1 = parameters.TimeSpan1.Simplify();
			if(xts1.IsConstant && xts1.Calculate().Ticks == 0)
				return xt1;
			if(xt1.IsConstant && xts1.IsConstant)
				return new TimeExpressionValue(context,Calculate());
			return new TimeSubtraction(context,xt1,xts1);
		}
	}
	#endregion

	#region TimeSpan <-> Scalar Operations
	/// <summary>
	/// Math.NET Operators: returns the time span multiplied with the given scalar factor
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ScalarTimeSpanMultiplication: TimeSpanOperator
	{
		protected Scalar1TimeSpan1Parameters parameters;
		public Scalar1TimeSpan1Parameters Parameters {get {return parameters;}}
		public ScalarTimeSpanMultiplication(Context context, Scalar1TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTimeSpanMultiplication(Context context, IScalarExpression factor, ITimeSpanExpression span): base(context)
		{
			this.parameters = new Scalar1TimeSpan1Parameters(factor,span);
			Init(parameters);
		}
		public ScalarTimeSpanMultiplication(Context context, ITimeSpanExpression span, IScalarExpression factor): base(context)
		{
			this.parameters = new Scalar1TimeSpan1Parameters(factor,span);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			TimeSpan s = parameters.TimeSpan1.Calculate();
			double d = parameters.Scalar1.Calculate();
			return new TimeSpan((long)(d*(double)s.Ticks));
		}
		public override ITimeSpanExpression Simplify()
		{
			ITimeSpanExpression xts1 = parameters.TimeSpan1.Simplify();
			IScalarExpression xs1 = parameters.Scalar1.Simplify();
			if(xts1.IsConstant && xs1.IsConstant)
			{
				return new TimeSpanExpressionValue(context,Calculate());
			}
			return new ScalarTimeSpanMultiplication(context,xs1,xts1);
		}
	}
	/// <summary>
	/// Math.NET Operator: returns the dime span divided with the given scalar factor
	/// </summary>
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="/")]
	public class ScalarTimeSpanDivision: TimeSpanOperator
	{
		protected Scalar1TimeSpan1Parameters parameters;
		public Scalar1TimeSpan1Parameters Parameters {get {return parameters;}}
		public ScalarTimeSpanDivision(Context context, Scalar1TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarTimeSpanDivision(Context context, ITimeSpanExpression span, IScalarExpression factor): base(context)
		{
			this.parameters = new Scalar1TimeSpan1Parameters(factor,span);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			TimeSpan s = parameters.TimeSpan1.Calculate();
			double d = parameters.Scalar1.Calculate();
			return new TimeSpan((long)(((double)s.Ticks)/d));
		}
		public override ITimeSpanExpression Simplify()
		{
			ITimeSpanExpression xts1 = parameters.TimeSpan1.Simplify();
			IScalarExpression xs1 = parameters.Scalar1.Simplify();
			if(xts1.IsConstant && xs1.IsConstant && xs1.Calculate() != 0)
			{
				return new TimeSpanExpressionValue(context,Calculate());
			}
			return new ScalarTimeSpanDivision(context,xts1,xs1);
		}
		public override string ToString()
		{
			return "map("+parameters.TimeSpan1.ToString()+","+parameters.Scalar1.ToComplex()+")";
		}
	}
	#endregion

	#region Literal Operations
	/// <summary>
	/// Math.NET Operator: converts a literal to a time expression
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="time")]
	public class TimeByLiteral: TimeOperator
	{
		protected Literal1Parameters parameters;
		public Literal1Parameters Parameters {get {return parameters;}}
		public TimeByLiteral(Context context, Literal1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeByLiteral(Context context, ILiteralExpression literal): base(context)
		{
			this.parameters = new Literal1Parameters(literal);
			Init(parameters);
		}
		public override DateTime Calculate()
		{
			try
			{
				return DateTime.Parse(parameters.Literal1.Calculate());
			}
			catch
			{
				throw new Exceptions.ExpressionArgumentNotOfRequiredFormatException();
			}
		}
		public override ITimeExpression Simplify()
		{
			ILiteralExpression xl1 = parameters.Literal1.Simplify();
			if(xl1.IsConstant)
				return new TimeExpressionValue(context,Calculate());
			return new TimeByLiteral(context,xl1);
		}
	}
	/// <summary>
	/// Math.NET Operator: converts a literal to a time span expression
	/// </summary>
	[ParsingObject(ParsingObjectType.Function,250,Character="timespan")]
	public class TimeSpanByLiteral: TimeSpanOperator
	{
		protected Literal1Parameters parameters;
		public Literal1Parameters Parameters {get {return parameters;}}
		public TimeSpanByLiteral(Context context, Literal1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public TimeSpanByLiteral(Context context, ILiteralExpression literal): base(context)
		{
			this.parameters = new Literal1Parameters(literal);
			Init(parameters);
		}
		public override TimeSpan Calculate()
		{
			try
			{
				return TimeSpan.Parse(parameters.Literal1.Calculate());
			}
			catch
			{
				throw new Exceptions.ExpressionArgumentNotOfRequiredFormatException();
			}
		}
		public override ITimeSpanExpression Simplify()
		{
			ILiteralExpression xl1 = parameters.Literal1.Simplify();
			if(xl1.IsConstant)
				return new TimeSpanExpressionValue(context,Calculate());
			return new TimeSpanByLiteral(context,xl1);
		}
	}
	#endregion
}
