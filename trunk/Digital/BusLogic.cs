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
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Digital
{
	#region And, Or, Not
	[ParsingObject(ParsingObjectType.InnerOperator,100,Character="&")]
	public class BusAnd_Link: BusAnd
	{
		public BusAnd_Link(Context context, IBusExpression left, IBusExpression right): base(context,left,right) {}
		public BusAnd_Link(Context context, Bus2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="and")]
	public class BusAnd: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusAnd(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusAnd(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitAnd(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,120,Character="|")]
	public class BusOr_Link: BusOr
	{
		public BusOr_Link(Context context, IBusExpression left, IBusExpression right): base(context,left,right) {}
		public BusOr_Link(Context context, Bus2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="or")]
	public class BusOr: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusOr(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusOr(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitOr(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="!")]
	public class BusNot_Link: BusNot
	{
		public BusNot_Link(Context context, IBusExpression sub): base(context,sub) {}
		public BusNot_Link(Context context, Bus1Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="not")]
	public class BusNot: BusOperator
	{
		protected Bus1Parameters parameters;
		public Bus1Parameters Parameters {get {return parameters;}}
		public BusNot(Context context, Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusNot(Context context, IBusExpression sub): base(context)
		{
			this.parameters = new Bus1Parameters(sub);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			int len = da.Length;
			IBitExpression[] be = new IBitExpression[da.Length];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitNot(context,da.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	//TODO: 2er Komplement hier, überschrieben mit "~"
	#endregion

	#region Nand, Nor
	[ParsingObject(ParsingObjectType.Function,250,Character="nand")]
	public class BusNand: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusNand(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusNand(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitNand(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="nor")]
	public class BusNor: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusNor(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusNor(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitNor(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	#endregion

	#region Xor, Xnor
	[ParsingObject(ParsingObjectType.InnerOperator,110,Character="^")]
	public class BusXor_Link: BusXor
	{
		public BusXor_Link(Context context, IBusExpression left, IBusExpression right): base(context,left,right) {}
		public BusXor_Link(Context context, Bus2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="xor")]
	public class BusXor: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusXor(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusXor(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitXor(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="xnor")]
	public class BusXnor: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusXnor(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusXnor(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitXnor(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="imp")]
	public class BusImplication: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusImplication(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusImplication(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
				be[i] = new BitImplication(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
			return new DigitalBus(context,be);
		}
	}
	#endregion

	#region Get, Set
	[ParsingObject(ParsingObjectType.Function,250,Character="get")]
	public class BusGet: BitOperator
	{
		protected Bit1Bus1Parameters parameters;
		public Bit1Bus1Parameters Parameters {get {return parameters;}}
		public BusGet(Context context, Bit1Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusGet(Context context, IBusExpression bus, IBitExpression bit): base(context)
		{
			this.parameters = new Bit1Bus1Parameters(bit,bus);
			Init(parameters);
		}
		public override IBitExpression Expand()
		{
			int x = Convert.ToInt32(parameters.Bit1.Calculate());
			return parameters.Bus1.Expand().GetLsbStarting(x);
		}
		public override string ToString()
		{
			return "get("+parameters.Bus1.ToString()+","+parameters.Bit1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="set")]
	public class BusSet: StdProcedure, IProcExpression
	{
		protected Scalar1Bit1Bus1Parameters parameters;
		public Scalar1Bit1Bus1Parameters Parameters {get {return parameters;}}
		public BusSet(Context context, Scalar1Bit1Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusSet(Context context, IBusExpression bus, IScalarExpression bit, IBitExpression val): base(context)
		{
			this.parameters = new Scalar1Bit1Bus1Parameters(bit,val,bus);
			Init(parameters);
		}
		public override bool Execute()
		{
			int x = Convert.ToInt32(parameters.Scalar1.Calculate());
			BusExpressionVariable v1 = parameters.Bus1 as BusExpressionVariable;
			if(v1 != null)
			{
				DigitalBus m = v1.Value.Expand();
				m.SetLsbStarting(x,parameters.Bit1);
				v1.Value = m;
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = parameters.Bus1 as Variable;
			if(v == null)
				return("set(" + parameters.Bus1.ToString() + "," + parameters.Scalar1.ToString() + "," + parameters.Bit1.ToString() + ")");
			else
				return("set(" + v.VariableName + "," + parameters.Scalar1.ToString() + "," + parameters.Bit1.ToString() + ")");
		}
	}
	#endregion

	#region Shifting
	[ParsingObject(ParsingObjectType.Function,250,Character="left")]
	public class BusShiftLeft: BusOperator
	{
		protected Bus1Parameters parameters;
		public Bus1Parameters Parameters {get {return parameters;}}
		public BusShiftLeft(Context context, Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusShiftLeft(Context context, IBusExpression sub): base(context)
		{
			this.parameters = new Bus1Parameters(sub);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			int len = da.Length;
			IBitExpression[] be = new IBitExpression[da.Length];
			be[len-1] = DigitalBit.Zero(context);
			for(int i=0;i<len-1;i++)
				be[i] = da.GetLsbStarting(len-2-i);
			return new DigitalBus(context,be);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="right")]
	public class BusShiftRight: BusOperator
	{
		protected Bus1Parameters parameters;
		public Bus1Parameters Parameters {get {return parameters;}}
		public BusShiftRight(Context context, Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusShiftRight(Context context, IBusExpression sub): base(context)
		{
			this.parameters = new Bus1Parameters(sub);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			int len = da.Length;
			IBitExpression[] be = new IBitExpression[da.Length];
			be[0] = DigitalBit.Zero(context);
			for(int i=1;i<len;i++)
				be[i] = da.GetLsbStarting(len-i);
			return new DigitalBus(context,be);
		}
		public override string ToString()
		{
			return("right(" + parameters.Bus1.ToString() + ")");
		}
	}
	#endregion

	#region Arithmetic
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="+")]
	public class BusFullAdder_Link: BusFullAdder
	{
		public BusFullAdder_Link(Context context, IBusExpression left, IBusExpression right): base(context,left,right) {}
		public BusFullAdder_Link(Context context, Bit1Bus2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="add")]
	public class BusFullAdder: BusOperator
	{
		protected Bit1Bus2Parameters parameters;
		public Bit1Bus2Parameters Parameters {get {return parameters;}}
		public BusFullAdder(Context context, Bit1Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusFullAdder(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bit1Bus2Parameters(DigitalBit.Zero(context),left,right);
			Init(parameters);
		}
		public BusFullAdder(Context context, IBusExpression left, IBusExpression right, IBitExpression carryin): base(context)
		{
			this.parameters = new Bit1Bus2Parameters(carryin,left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression carry = parameters.Bit1;
			IBitExpression[] be = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
			{
				IBitExpression a = new BitXor(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i));
				be[i] = new BitXor(context,a,carry);
				carry = new BitOr(context,new BitAnd(context,da.GetLsbStarting(len-1-i),db.GetLsbStarting(len-1-i)),new BitAnd(context,a,carry));
			}
			return new DigitalBus(context,be);
		}
		public override string ToString()
		{
			return "add("+parameters.Bus1.ToString()+","+parameters.Bus2.ToString()+","+parameters.Bit1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,60,Character="-")]
	public class BusFullSubstracter_Link: BusFullSubstracter
	{
		public BusFullSubstracter_Link(Context context,IBusExpression left, IBusExpression right): base(context,left,right) {}
		public BusFullSubstracter_Link(Context context,Bus2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="substract")]
	public class BusFullSubstracter: BusOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusFullSubstracter(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusFullSubstracter(Context context, IBusExpression left, IBusExpression right): base(context)
		{
			this.parameters = new Bus2Parameters(left,right);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] bone = new IBitExpression[len];
			for(int i=0;i<len;i++)
				bone[i] = DigitalBit.One(context);
			DigitalBus done = new DigitalBus(context,bone);
			return new BusFullAdder(context,da,new BusXor(context,db,done),DigitalBit.One(context)).Expand();
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="arithmetic")]
	public class BusArithmetic: BusOperator
	{
		protected Bus3Parameters parameters;
		public Bus3Parameters Parameters {get {return parameters;}}
		public BusArithmetic(Context context, Bus3Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusArithmetic(Context context, IBusExpression left, IBusExpression middle, IBusExpression signal): base(context)
		{
			this.parameters = new Bus3Parameters(left,middle,signal);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus signal = parameters.Bus3.Expand();
			if(signal.Length < 5)
				throw new ExpressionRankMismatchException();
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			IBitExpression[] sgb1 = new IBitExpression[len];
			IBitExpression[] sgb2 = new IBitExpression[len];
			IBitExpression[] sgb3 = new IBitExpression[len];
			IBitExpression[] sgb4 = new IBitExpression[len];
			for(int i=0;i<len;i++)
			{
				sgb1[i] = signal.GetLsbStarting(1);
				sgb2[i] = signal.GetLsbStarting(2);
				sgb3[i] = signal.GetLsbStarting(3);
				sgb4[i] = signal.GetLsbStarting(4);
			}
			DigitalBus sgd1 = new DigitalBus(context,sgb1);
			DigitalBus sgd2 = new DigitalBus(context,sgb2);
			DigitalBus sgd3 = new DigitalBus(context,sgb3);
			DigitalBus sgd4 = new DigitalBus(context,sgb4);
			return new BusFullAdder(context,new BusXor(context,new BusAnd(context,da,sgd4),sgd2),new BusXor(context,new BusAnd(context,db,sgd3),sgd1),signal.GetLsbStarting(0)).Expand();
		}
	}
	#endregion

	#region Multiplexing
	[ParsingObject(ParsingObjectType.Function,250,Character="mux")]
	public class BusMultiplexer: BitOperator
	{
		protected Bus2Parameters parameters;
		public Bus2Parameters Parameters {get {return parameters;}}
		public BusMultiplexer(Context context, Bus2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusMultiplexer(Context context, IBusExpression left, IBusExpression signal): base(context)
		{
			this.parameters = new Bus2Parameters(left,signal);
			Init(parameters);
		}
		public override IBitExpression Expand()
		{
			DigitalBus signal = parameters.Bus2.Expand();
			DigitalBus da = parameters.Bus1.Expand();
			if(Math.Pow(2,signal.Length) < da.Length)
				throw new ExpressionRankMismatchException();
			int len = da.Length;
			IBitExpression[] bone = new IBitExpression[len];
			for(int i=len-1;i>=0;i--)
			{
				bone[i] = da.GetLsbStarting(len-1-i);
				for(int j=0;j<signal.Length;j++)
				{
					if((i&(1<<j))>0)
						bone[i] = new BitAnd(context,bone[i],signal[signal.Length-1-j]);
					else
						bone[i] = new BitAnd(context,bone[i],new BitNot(context,signal[signal.Length-1-j]));
				}

			}
			IBitExpression or = DigitalBit.Zero(context);
			for(int i=0;i<len;i++)
				or = new BitOr(context,or,bone[i]);
			return or;
		}
	}
	#endregion

	#region ALU - Arihtmetic Logic Unit
	[ParsingObject(ParsingObjectType.Function,250,Character="alu")]
	public class BusArithmeticLogicUnit: BusOperator
	{
		protected Bus3Parameters parameters;
		public Bus3Parameters Parameters {get {return parameters;}}
		public BusArithmeticLogicUnit(Context context, Bus3Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BusArithmeticLogicUnit(Context context, IBusExpression left, IBusExpression middle, IBusExpression signal): base(context)
		{
			this.parameters = new Bus3Parameters(left,middle,signal);
			Init(parameters);
		}
		public override DigitalBus Expand()
		{
			DigitalBus signal = parameters.Bus3.Expand();
			if(signal.Length < 7)
				throw new ExpressionRankMismatchException();
			DigitalBus da = parameters.Bus1.Expand();
			DigitalBus db = parameters.Bus2.Expand();
			int len = Math.Max(da.Length,db.Length);
			//prepare multiplexer signals
			IBitExpression[] muxsig = new IBitExpression[2];
			muxsig[1] = signal.GetLsbStarting(5);
			muxsig[0] = signal.GetLsbStarting(6);
			//prepare bitwise operators
			DigitalBus andbus = new BusAnd(context,da,db).Expand();
			DigitalBus orbus = new BusOr(context,da,db).Expand();
			DigitalBus xorbus = new BusXor(context,da,db).Expand();
			//prepare arithmetic operator
			IBitExpression[] arithsig = new IBitExpression[5];
			for(int i=4;i>=0;i--)
				arithsig[i] = signal.GetLsbStarting(4-i);
			DigitalBus arithbus = new BusArithmetic(context,da,db,new DigitalBus(context,arithsig)).Expand();
			//populate multiplexers
			IBitExpression[] output = new IBitExpression[len];
			for(int i=0;i<len;i++)
			{
				IBitExpression[] muxinput = new IBitExpression[4];
				muxinput[0] = andbus[i];
				muxinput[1] = orbus[i];
				muxinput[2] = xorbus[i];
				muxinput[3] = arithbus[i];
				output[i] = new BusMultiplexer(context,new DigitalBus(context,muxinput),new DigitalBus(context,muxsig));
			}
			return new DigitalBus(context,output);
		}
	}
	#endregion
}
