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

namespace cdrnet.Lib.MathLib.Digital
{
	#region Digital Conversion Map Implementation
	public abstract class BitMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IBitExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IBitExpression se = exp as IBitExpression;
			bool res = ConvertTo(ref se);
			if(res)
				exp = se;
			return(res);
		}
	}
	public abstract class BusMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IBusExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IBusExpression se = exp as IBusExpression;
			bool res = ConvertTo(ref se);
			if(res)
				exp = se;
			return(res);
		}
	}
	public class BitConversionMap
	{
		public static void Convert(ref IBitExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(BitMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	public class BusConversionMap
	{
		public static void Convert(ref IBusExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(BusMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}
	#endregion

	#region Bit Conversion Maps
	[ConversionMapEntry(new Type[]{typeof(BitNot),typeof(BitNot_Link)},"simple")]
	public class BitMapNot: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitNot x = exp as BitNot;
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				exp = y.Parameters.Bit1;
				return true ;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitAnd)
				|| x.Parameters.Bit1.GetType() == typeof(BitAnd_Link))
			{
				BitAnd y = x.Parameters.Bit1 as BitAnd;
				exp = new BitNand(context,y.Parameters.Bit1,y.Parameters.Bit2);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNand))
			{
				BitNand y = x.Parameters.Bit1 as BitNand;
				exp = new BitAnd(context,y.Parameters.Bit1,y.Parameters.Bit2);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNor))
			{
				BitNor y = x.Parameters.Bit1 as BitNor;
				exp = new BitOr(context,y.Parameters.Bit1,y.Parameters.Bit2);
				return true;
			}
			return false;
		}
	}
	[ConversionMapEntry(new Type[]{typeof(BitAnd),typeof(BitAnd_Link)},"simple")]
	public class BitMapAnd: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitAnd x = exp as BitAnd;
			if(x.Parameters.Bit1.Equals(x.Parameters.Bit2))
			{
				exp = x.Parameters.Bit1;
				return true;
			}
			if((x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
				&& (x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link)))
			{
				BitNot y1 = x.Parameters.Bit1 as BitNot;
				BitNot y2 = x.Parameters.Bit1 as BitNot;
				exp = new BitNor(context,y1.Parameters.Bit1,y2.Parameters.Bit1);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				if(x.Parameters.Bit2.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.Zero(context);
					return true;
				}
			}
			if(x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit2 as BitNot;
				if(x.Parameters.Bit1.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.Zero(context);
					return true;
				}
			}
			return false;
		}
	}
	[ConversionMapEntry(new Type[]{typeof(BitOr),typeof(BitOr_Link)},"simple")]
	public class BitMapOr: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitOr x = exp as BitOr;
			if(x.Parameters.Bit1.Equals(x.Parameters.Bit2))
			{
				exp = x.Parameters.Bit1;
				return true;
			}
			if((x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
				&& (x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link)))
			{
				BitNot y1 = x.Parameters.Bit1 as BitNot;
				BitNot y2 = x.Parameters.Bit1 as BitNot;
				exp = new BitNand(context,y1.Parameters.Bit1,y2.Parameters.Bit1);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				if(x.Parameters.Bit2.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.One(context);
					return true;
				}
			}
			if(x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit2 as BitNot;
				if(x.Parameters.Bit1.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.One(context);
					return true;
				}
			}
			return false;
		}
	}
	[ConversionMapEntry(typeof(BitNand),"simple")]
	public class BitMapNand: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitNand x = exp as BitNand;
			if(x.Parameters.Bit1.Equals(x.Parameters.Bit2))
			{
				exp = new BitNot(context,x.Parameters.Bit1);
				return true;
			}
			if((x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
				&& (x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link)))
			{
				BitNot y1 = x.Parameters.Bit1 as BitNot;
				BitNot y2 = x.Parameters.Bit1 as BitNot;
				exp = new BitOr(context,y1.Parameters.Bit1,y2.Parameters.Bit1);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				if(x.Parameters.Bit2.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.One(context);
					return true;
				}
			}
			if(x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit2 as BitNot;
				if(x.Parameters.Bit1.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.One(context);
					return true;
				}
			}
			return false;
		}
	}
	[ConversionMapEntry(typeof(BitNor),"simple")]
	public class BitMapNor: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitNor x = exp as BitNor;
			if(x.Parameters.Bit1.Equals(x.Parameters.Bit2))
			{
				exp = new BitNot(context,x.Parameters.Bit1);
				return true;
			}
			if((x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
				&& (x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link)))
			{
				BitNot y1 = x.Parameters.Bit1 as BitNot;
				BitNot y2 = x.Parameters.Bit1 as BitNot;
				exp = new BitAnd(context,y1.Parameters.Bit1,y2.Parameters.Bit1);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				if(x.Parameters.Bit2.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.Zero(context);
					return true;
				}
			}
			if(x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit2 as BitNot;
				if(x.Parameters.Bit1.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.Zero(context);
					return true;
				}
			}
			return false;
		}
	}
	[ConversionMapEntry(new Type[]{typeof(BitXor),typeof(BitXor_Link)},"simple")]
	public class BitMapXor: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitXor x = exp as BitXor;
			if(x.Parameters.Bit1.Equals(x.Parameters.Bit2))
			{
				exp = DigitalBit.Zero(context);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				if(x.Parameters.Bit2.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.One(context);
					return true;
				}
			}
			if(x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit2 as BitNot;
				if(x.Parameters.Bit1.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.One(context);
					return true;
				}
			}
			return false;
		}
	}
	[ConversionMapEntry(typeof(BitXnor),"simple")]
	public class BitMapXnor: BitMapEntry
	{
		public override bool ConvertTo(ref IBitExpression exp)
		{
			Context context = exp.Context;
			BitXnor x = exp as BitXnor;
			if(x.Parameters.Bit1.Equals(x.Parameters.Bit2))
			{
				exp = DigitalBit.One(context);
				return true;
			}
			if(x.Parameters.Bit1.GetType() == typeof(BitNot)
				|| x.Parameters.Bit1.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit1 as BitNot;
				if(x.Parameters.Bit2.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.Zero(context);
					return true;
				}
			}
			if(x.Parameters.Bit2.GetType() == typeof(BitNot)
				|| x.Parameters.Bit2.GetType() == typeof(BitNot_Link))
			{
				BitNot y = x.Parameters.Bit2 as BitNot;
				if(x.Parameters.Bit1.Equals(y.Parameters.Bit1))
				{
					exp = DigitalBit.Zero(context);
					return true;
				}
			}
			return false;
		}
	}
	#endregion
}
