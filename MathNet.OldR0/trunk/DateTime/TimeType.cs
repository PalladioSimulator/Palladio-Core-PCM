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

namespace cdrnet.Lib.MathLib.Time
{
	/// <summary>
	/// Math.NET type: a date-time expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Scalar,1)]
	public interface ITimeExpression: IExpression
	{
		/// <summary>
		/// calculate the expression as a native DateTime instance
		/// </summary>
		/// <returns>result as System.DateTime instance</returns>
		DateTime Calculate();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		ITimeExpression Simplify();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ITimeExpression Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		ITimeExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		ITimeExpression Substitute(IExpression original, IExpression replacement);
	}
	/// <summary>
	/// Math.NET type: a time span (time difference) expression
	/// </summary>
	[ParsingType(ParsingExpressionType.Scalar,1)]
	public interface ITimeSpanExpression: IExpression
	{
		/// <summary>
		/// calculate the expression as a native TimeSpan instance
		/// </summary>
		/// <returns>result as a System.TimeSpan instance</returns>
		TimeSpan Calculate();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		ITimeSpanExpression Simplify();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		ITimeSpanExpression Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		ITimeSpanExpression SafeExpand();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		ITimeSpanExpression Substitute(IExpression original, IExpression replacement);
	}

	#region Specific Math Objects
	/// <summary>
	/// a specific time holder object (as a leaf in the operator tree)
	/// </summary>
	[ParsingObject(ParsingObjectType.Object,11)]
	public class TimeExpressionValue: LeafExpression, ITimeExpression
	{
		public TimeExpressionValue(Context context, DateTime init): base(context)
		{
			val = init;
		}
		#region Static TimeValue Templates
		public static TimeExpressionValue Now(Context context)
		{
			return new TimeExpressionValue(context,DateTime.Now);
		}
		public static TimeExpressionValue Today(Context context)
		{
			return new TimeExpressionValue(context,DateTime.Today);
		}
		#endregion
		private DateTime val;
		public DateTime Value
		{
			set {val = value;}
			get {return(val);}
		}
		public DateTime Calculate()
		{
			return val;
		}
		public override string ToString()
		{
			return "time(\"" + val.ToString() + "\")";
		}
		public ITimeExpression Simplify()
		{
			return this;
		}
		public ITimeExpression Expand()
		{
			return this;
		}
		public ITimeExpression SafeExpand()
		{
			return this;
		}
		public ITimeExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITimeExpression) base.ExpressionSubstitute(original, replacement);
		}
		public override bool Equals(object obj)
		{
			TimeExpressionValue x = obj as TimeExpressionValue;
			if(x != null && x.val == val)
				return true;
			return false;
		}
		public override int GetHashCode()
		{
			return val.GetHashCode();
		}
	}
	/// <summary>
	/// a specific time span holder object (as a leaf in the operator tree)
	/// </summary>
	[ParsingObject(ParsingObjectType.Object,11)]
	public class TimeSpanExpressionValue: LeafExpression, ITimeSpanExpression
	{
		public TimeSpanExpressionValue(Context context, TimeSpan init): base(context)
		{
			val = init;
		}
		#region Static TimeValue Templates
		public static TimeSpanExpressionValue Zero(Context context)
		{
			return new TimeSpanExpressionValue(context,TimeSpan.Zero);
		}
		public static TimeSpanExpressionValue Max(Context context)
		{
			return new TimeSpanExpressionValue(context,TimeSpan.MaxValue);
		}
		public static TimeSpanExpressionValue Min(Context context)
		{
			return new TimeSpanExpressionValue(context,TimeSpan.MinValue);
		}
		#endregion
		private TimeSpan val;
		public TimeSpan Value
		{
			set {val = value;}
			get {return(val);}
		}
		public TimeSpan Calculate()
		{
			return val;
		}
		public override string ToString()
		{
			return '"' + val.ToString() + '"';
		}
		public ITimeSpanExpression Simplify()
		{
			return this;
		}
		public ITimeSpanExpression Expand()
		{
			return this;
		}
		public ITimeSpanExpression SafeExpand()
		{
			return this;
		}
		public ITimeSpanExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITimeSpanExpression) base.ExpressionSubstitute(original, replacement);
		}
		public override bool Equals(object obj)
		{
			TimeSpanExpressionValue x = obj as TimeSpanExpressionValue;
			if(x != null && x.val == val)
				return true;
			return false;
		}
		public override int GetHashCode()
		{
			return val.GetHashCode();
		}
	}
	#endregion
}
