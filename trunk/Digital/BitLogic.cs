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
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Digital
{
	#region Basic Modules
	[ParsingObject(ParsingObjectType.InnerOperator,100,Character="&")]
	public class BitAnd_Link: BitAnd
	{
		public BitAnd_Link(Context context, IBitExpression left, IBitExpression right): base(context,left,right) {}
		public BitAnd_Link(Context context, Bit2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="and")]
	public class BitAnd: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitAnd(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitAnd(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return parameters.Bit1.Calculate() && parameters.Bit2.Calculate();
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && !xFirst.Calculate() || xLast.IsConstant && !xLast.Calculate())
				return DigitalBit.Zero(context);
			if(xFirst.IsConstant && xFirst.Calculate())
				return xLast;
			if(xLast.IsConstant && xLast.Calculate())
				return xFirst;
			return new BitAnd(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,120,Character="|")]
	public class BitOr_Link: BitOr
	{
		public BitOr_Link(Context context, IBitExpression left, IBitExpression right): base(context,left,right) {}
		public BitOr_Link(Context context, Bit2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="or")]
	public class BitOr: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitOr(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitOr(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return parameters.Bit1.Calculate() || parameters.Bit2.Calculate();
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && xFirst.Calculate() || xLast.IsConstant && xLast.Calculate())
				return DigitalBit.One(context);
			if(xFirst.IsConstant && !xFirst.Calculate())
				return xLast;
			if(xLast.IsConstant && !xLast.Calculate())
				return xFirst;
			return new BitOr(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.PreOperator,20,Character="!")]
	public class BitNot_Link: BitNot
	{
		public BitNot_Link(Context context,IBitExpression sub): base(context,sub) {}
		public BitNot_Link(Context context,Bit1Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="not")]
	public class BitNot: BitOperator
	{
		protected Bit1Parameters parameters;
		public Bit1Parameters Parameters {get {return parameters;}}
		public BitNot(Context context, Bit1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitNot(Context context, IBitExpression sub): base(context)
		{
			this.parameters = new Bit1Parameters(sub);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return(!parameters.Bit1.Calculate());
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xSub = parameters.Bit1.Simplify();
			if(xSub.IsConstant && !xSub.Calculate())
				return DigitalBit.One(context);
			if(xSub.IsConstant && xSub.Calculate())
				return DigitalBit.Zero(context);
			return new BitNot(context,xSub);
		}
	}
	#endregion

	#region Primary Modules
	[ParsingObject(ParsingObjectType.Function,250,Character="nand")]
	public class BitNand: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitNand(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitNand(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return !(parameters.Bit1.Calculate() && parameters.Bit2.Calculate());
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && !xFirst.Calculate() || xLast.IsConstant && !xLast.Calculate())
				return DigitalBit.One(context);
			if(xFirst.IsConstant && xFirst.Calculate())
				return new BitNot(context,xLast);
			if(xLast.IsConstant && xLast.Calculate())
				return new BitNot(context,xFirst);
			return new BitNand(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="nor")]
	public class BitNor: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitNor(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitNor(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return !(parameters.Bit1.Calculate() || parameters.Bit2.Calculate());
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && xFirst.Calculate() || xLast.IsConstant && xLast.Calculate())
				return DigitalBit.Zero(context);
			if(xFirst.IsConstant && !xFirst.Calculate())
				return new BitNot(context,xLast);
			if(xLast.IsConstant && !xLast.Calculate())
				return new BitNot(context,xFirst);
			return new BitNor(context,xFirst,xLast);
		}
	}
	#endregion

	#region Secondary Modules
	[ParsingObject(ParsingObjectType.InnerOperator,110,Character="^")]
	public class BitXor_Link: BitXor
	{
		public BitXor_Link(Context context, IBitExpression left, IBitExpression right): base(context,left,right) {}
		public BitXor_Link(Context context, Bit2Parameters parameters): base(context,parameters) {}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="xor")]
	public class BitXor: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitXor(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitXor(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return parameters.Bit1.Calculate() ^ parameters.Bit2.Calculate();
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
				return new DigitalBit(context,this.Calculate());
			if(xFirst.IsConstant && xFirst.Calculate())
				return new BitNot(context,xLast);
			if(xFirst.IsConstant && !xFirst.Calculate())
				return xLast;
			if(xLast.IsConstant && xLast.Calculate())
				return new BitNot(context,xFirst);
			if(xLast.IsConstant && !xLast.Calculate())
				return xFirst;
			return new BitXor(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="xnor")]
	public class BitXnor: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitXnor(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitXnor(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return !(parameters.Bit1.Calculate() ^ parameters.Bit2.Calculate());
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
				return new DigitalBit(context,this.Calculate());
			if(xFirst.IsConstant && xFirst.Calculate())
				return xLast;
			if(xFirst.IsConstant && !xFirst.Calculate())
				return new BitNot(context,xLast);
			if(xLast.IsConstant && xLast.Calculate())
				return xFirst;
			if(xLast.IsConstant && !xLast.Calculate())
				return new BitNot(context,xFirst);
			return new BitXnor(context,xFirst,xLast);
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="imp")]
	public class BitImplication: BitOperator
	{
		protected Bit2Parameters parameters;
		public Bit2Parameters Parameters {get {return parameters;}}
		public BitImplication(Context context, Bit2Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public BitImplication(Context context, IBitExpression left, IBitExpression right): base(context)
		{
			this.parameters = new Bit2Parameters(left,right);
			Init(parameters);
		}
		public override bool Calculate()
		{
			return !parameters.Bit1.Calculate() || parameters.Bit2.Calculate();
		}
		public override IBitExpression Simplify()
		{
			IBitExpression xFirst = parameters.Bit1.Simplify();
			IBitExpression xLast = parameters.Bit2.Simplify();
			if(xFirst.IsConstant && xLast.IsConstant)
			{
				return new DigitalBit(context,this.Calculate());
			}
			return new BitImplication(context,xFirst,xLast);
		}
	}
	#endregion
}
