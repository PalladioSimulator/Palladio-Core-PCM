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
using System.Text;
using System.Collections;
using System.Collections.Specialized;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Digital
{
	[ParsingType(ParsingExpressionType.Scalar,1)]
	public interface IBitExpression: IExpression
	{
		/// <summary>
		/// calculate the bit expressions as real boolean
		/// </summary>
		bool Calculate();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		IBitExpression Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IBitExpression SafeExpand();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IBitExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IBitExpression Substitute(IExpression original, IExpression replacement);
	}

	[ParsingType(ParsingExpressionType.List,0)]
	public interface IBusExpression: IExpression
	{
		/// <summary>
		/// calculate the bus expressions as real boolean
		/// </summary>
		BitArray Calculate();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		DigitalBus Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IBusExpression SafeExpand();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IBusExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IBusExpression Substitute(IExpression original, IExpression replacement);
	}

	[ParsingType(ParsingExpressionType.Object,0)]
	public interface IStateMachineExpression: IExpression
	{
		IBusExpression InternalState {get;}
		IBusExpression OutputBus {get;}
		IBusExpression InputBus {get;}
		/// <summary>
		/// propagates the state machine
		/// </summary>
		bool Propagate();
		/// <summary>
		/// expands the expression
		/// </summary>
		/// <returns>the expanded expression</returns>
		FiniteStateMachine Expand();
		/// <summary>
		/// expands the expression.
		/// </summary>
		/// <remarks>
		/// SafeExpand() is less powerfull than <see cref="Expand()"/> but never throws an ExpressionNotDeriveableException.
		/// </remarks>
		/// <returns>the expanded expression</returns>
		IStateMachineExpression SafeExpand();
		/// <summary>
		/// simplifies the expression
		/// </summary>
		/// <returns>the simplified expression</returns>
		IStateMachineExpression Simplify();
		/// <summary>
		/// substitutes the specified subterms with the given replacement
		/// </summary>
		/// <param name="original">the subterm to look for</param>
		/// <param name="replacement">the replacement of the subterms</param>
		/// <returns>the substituted expression</returns>
		IStateMachineExpression Substitute(IExpression original, IExpression replacement);
	}

	#region Specific Math Objects - Bit
	[ParsingObject(ParsingObjectType.Value,11)]
	public class DigitalBit: LeafExpression, IBitExpression
	{
		public DigitalBit(Context context, bool init): base(context)
		{
			val = init;
		}
		#region Static Bit Templates
		public static DigitalBit One(Context context)
		{
			return new DigitalBit(context,true);
		}
		public static DigitalBit Zero(Context context)
		{
			return new DigitalBit(context,false);
		}
		public static DigitalBit True(Context context)
		{
			return new DigitalBit(context,true);
		}
		public static DigitalBit False(Context context)
		{
			return new DigitalBit(context,false);
		}
		#endregion
		private bool val;
		public bool Value
		{
			set {val = value;}
			get {return val;}
		}
		public bool Calculate()
		{
			return val;
		}
		public override string ToString()
		{
			if(val)
				return "1";
			else
				return "0";
		}
		public IBitExpression Simplify()
		{
			return this;
		}
		public IBitExpression Expand()
		{
			return this;
		}
		public IBitExpression SafeExpand()
		{
			return this;
		}
		public IBitExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IBitExpression) base.ExpressionSubstitute(original, replacement);
		}
		public override bool Equals(object obj)
		{
			DigitalBit x = obj as DigitalBit;
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

	#region Specific Math Objects - Bus
	[ParsingObject(ParsingObjectType.List,11)]
	public class DigitalBus: MathExpression, IBusExpression 
	{
		protected IBitExpression[] data;
		public DigitalBus(Context context, IBitExpression[] subs): base(context)
		{
			data = new IBitExpression[subs.Length];
			for(int y=0;y<subs.Length;y++)
				data[y] = subs[y];
			Init(new EmptyParameters());
		}
		public BitArray Calculate()
		{
			bool[] rsp = new bool[data.Length];
			for(int i=0;i<data.Length;i++)
				rsp[i] = this[i].Calculate();
			return new BitArray(rsp);
		}
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public DigitalBus Expand()
		{
			IBitExpression[] tmp = new IBitExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = this[i].Expand();
			return new DigitalBus(context,tmp);
		}
		public IBusExpression SafeExpand()
		{
			IBitExpression[] tmp = new IBitExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = this[i].SafeExpand();
			return new DigitalBus(context,tmp);
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public IBusExpression Simplify()
		{
			IBitExpression[] tmp = new IBitExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = this[i].Simplify();
			return new DigitalBus(context,tmp);
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public IBusExpression Substitute(IExpression original, IExpression replacement)
		{
			IBitExpression[] tmp = new IBitExpression[data.Length];
			for(int i=0;i<data.Length;i++)
				tmp[i] = this[i].Substitute(original, replacement);
			return new DigitalBus(context,tmp);
		}
		public override bool IsEntity
		{
			get {return true;}
		}
		public override bool IsConstant
		{
			get
			{
				bool isc = true;
				for(int i=0;i<data.Length;i++)
					isc &= this[i].IsConstant;
				return isc;
			}
		}
		public int Length
		{
			get {return data.Length;}
		}
		public IBitExpression this[int index]
		{
			get {return data[index];}
			set	{data[index] = value;}
		}
		public IBitExpression GetLsbStarting(int index)
		{
			if(index < data.Length)
				return this[data.Length-1-index];
			else
				return DigitalBit.Zero(context);
		}
		public void SetLsbStarting(int index, IBitExpression val)
		{
			if(index < data.Length)
				this[data.Length-1-index] = val;
		}
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.Append('{');
			for(int i=0;i<data.Length;i++)
			{
				if(i>0)
					sb.Append(',');
				sb.Append(this[i].ToString());
			}
			sb.Append('}');
			return sb.ToString();
		}
		public override void ConvertChilds(string conversionType)
		{
			for(int y=0;y<data.Length;y++)
			{
				IBitExpression me = data[y];
				BitConversionMap.Convert(ref me,conversionType);
				data[y] = me;
			}
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			for(int i=0;i<data.Length;i++)
				this[i].CollectVariables(vars,deep);
		}
		public override bool Equals(object exp)
		{
			if(exp.GetType() == typeof(DigitalBus))
			{
				DigitalBus x = exp as DigitalBus;
				if(x.Length != data.Length)
					return(false);
				bool eq = true;
				for(int y=0;y<data.Length;y++)
				{
					eq &= this[y].Equals(x[y]);
				}
				if(eq)
					return true;
			}
			return false;
		}
	}
	#endregion

	#region Constants
	[ParsingObject(ParsingObjectType.Function,250,Character="btrue")]
	public class ConstantBitTrue: BitOperator
	{
		protected EmptyParameters parameters;
		public ConstantBitTrue(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ConstantBitTrue(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override bool Calculate()
		{
			return true;
		}
		public override string ToString()
		{
			return "1";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="bfalse")]
	public class ConstantBitFalse: BitOperator
	{
		protected EmptyParameters parameters;
		public ConstantBitFalse(Context context, EmptyParameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ConstantBitFalse(Context context): base(context)
		{
			this.parameters = new EmptyParameters();
			Init(parameters);
		}
		public override bool Calculate()
		{
			return false;
		}
		public override string ToString()
		{
			return "0";
		}
		public override bool IsConstant
		{
			get {return true;}
		}
	}
	#endregion
}
