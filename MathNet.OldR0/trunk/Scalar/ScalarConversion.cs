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

namespace cdrnet.Lib.MathLib.Scalar
{
	public abstract class ScalarMapEntry: ConversionMapEntry
	{
		public abstract bool ConvertTo(ref IScalarExpression exp);
		public override bool ConvertTo(ref IExpression exp)
		{
			IScalarExpression se = exp as IScalarExpression;
			bool res = ConvertTo(ref se);
			if(res)
				exp = se;
			return(res);
		}
	}
	public class ScalarConversionMap
	{
		public static void Convert(ref IScalarExpression exp, string conversionType)
		{
			ArrayList al;
			bool changed = true;
			while(changed)
			{
				exp.ConvertChilds(conversionType);
				exp = exp.Simplify();
				changed = false;
				al = ConversionMap.GetMapEntryList(exp.GetType(),conversionType);
				foreach(ScalarMapEntry entry in al)
				{
					changed = entry.ConvertTo(ref exp);
					if(changed)
						break;
				}
			}
		}
	}

	[ConversionMapEntry(typeof(ScalarMultiplication),"simple")]
	public class ScalarMapMultiplicationDivision: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarMultiplication x = exp as ScalarMultiplication;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarDivision) && x.Parameters.Scalar2.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y1 = x.Parameters.Scalar1 as ScalarDivision;
				ScalarDivision y2 = x.Parameters.Scalar2 as ScalarDivision;
				exp = new ScalarDivision(context,new ScalarMultiplication(context,y1.Parameters.Scalar1,y2.Parameters.Scalar1),new ScalarMultiplication(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2)).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y = x.Parameters.Scalar2 as ScalarDivision;
				exp = new ScalarDivision(context,new ScalarMultiplication(context,x.Parameters.Scalar1,y.Parameters.Scalar1),y.Parameters.Scalar2).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y = x.Parameters.Scalar1 as ScalarDivision;
				exp = new ScalarDivision(context,new ScalarMultiplication(context,x.Parameters.Scalar2,y.Parameters.Scalar1),y.Parameters.Scalar2).Simplify();
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarMultiplication),"simple")]
	public class ScalarMapMultiplication: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarMultiplication x = exp as ScalarMultiplication;
			if(ScalarExtractor.ReorderFactors(ref exp))
				return true;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower) && x.Parameters.Scalar2.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y1 = x.Parameters.Scalar1 as ScalarRaiseToPower;
				ScalarRaiseToPower y2 = x.Parameters.Scalar2 as ScalarRaiseToPower;
				if(y1.Parameters.Scalar1.Equals(y2.Parameters.Scalar1))
				{
					exp = new ScalarRaiseToPower(context,y1.Parameters.Scalar1,new ScalarAddition(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2)).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative) && x.Parameters.Scalar2.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y1 = x.Parameters.Scalar1 as ScalarNegative;
				ScalarNegative y2 = x.Parameters.Scalar2 as ScalarNegative;
				exp = new ScalarMultiplication(context,y1.Parameters.Scalar1,y2.Parameters.Scalar1).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar1 as ScalarNegative;
				IScalarExpression z = new ScalarMultiplication(context,y.Parameters.Scalar1,x.Parameters.Scalar2).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarNegative(context,z).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar2 as ScalarNegative;
				IScalarExpression z = new ScalarMultiplication(context,x.Parameters.Scalar1,y.Parameters.Scalar1).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarNegative(context,z).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y = x.Parameters.Scalar1 as ScalarRaiseToPower;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarRaiseToPower(context,y.Parameters.Scalar1,new ScalarAddition(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y = x.Parameters.Scalar2 as ScalarRaiseToPower;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarRaiseToPower(context,y.Parameters.Scalar1,new ScalarAddition(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar1 as ScalarMultiplication;
				if(x.Parameters.Scalar2.IsConstant && y.Parameters.Scalar1.IsConstant && !y.Parameters.Scalar2.IsConstant)
				{
					exp = new ScalarMultiplication(context,new ScalarMultiplication(context,x.Parameters.Scalar2,y.Parameters.Scalar1),y.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(x.Parameters.Scalar2.IsConstant && !y.Parameters.Scalar1.IsConstant && y.Parameters.Scalar2.IsConstant)
				{
					exp = new ScalarMultiplication(context,new ScalarMultiplication(context,x.Parameters.Scalar2,y.Parameters.Scalar2),y.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarRaiseToPower(context,x.Parameters.Scalar2,ScalarExpressionValue.Two(context))).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarRaiseToPower(context,x.Parameters.Scalar2,ScalarExpressionValue.Two(context))).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar2 as ScalarMultiplication;
				if(x.Parameters.Scalar1.IsConstant && y.Parameters.Scalar1.IsConstant && !y.Parameters.Scalar2.IsConstant)
				{
					exp = new ScalarMultiplication(context,new ScalarMultiplication(context,x.Parameters.Scalar1,y.Parameters.Scalar1),y.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(x.Parameters.Scalar1.IsConstant && !y.Parameters.Scalar1.IsConstant && y.Parameters.Scalar2.IsConstant)
				{
					exp = new ScalarMultiplication(context,new ScalarMultiplication(context,x.Parameters.Scalar1,y.Parameters.Scalar2),y.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarRaiseToPower(context,x.Parameters.Scalar1,ScalarExpressionValue.Two(context))).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarRaiseToPower(context,x.Parameters.Scalar1,ScalarExpressionValue.Two(context))).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
			{
				exp = new ScalarRaiseToPower(context,x.Parameters.Scalar1,ScalarExpressionValue.Two(context));
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarDivision),"simple")]
	public class ScalarMapDivisionDivision: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarDivision x = exp as ScalarDivision;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarDivision) && x.Parameters.Scalar2.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y1 = x.Parameters.Scalar1 as ScalarDivision;
				ScalarDivision y2 = x.Parameters.Scalar2 as ScalarDivision;
				exp = new ScalarDivision(context,new ScalarMultiplication(context,y1.Parameters.Scalar1,y2.Parameters.Scalar2),new ScalarMultiplication(context,y1.Parameters.Scalar2,y2.Parameters.Scalar1)).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y = x.Parameters.Scalar2 as ScalarDivision;
				exp = new ScalarDivision(context,new ScalarMultiplication(context,x.Parameters.Scalar1,y.Parameters.Scalar2),y.Parameters.Scalar1).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y = x.Parameters.Scalar1 as ScalarDivision;
				exp = new ScalarDivision(context,y.Parameters.Scalar1,new ScalarMultiplication(context,x.Parameters.Scalar2,y.Parameters.Scalar2)).Simplify();
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarDivision),"simple")]
	public class ScalarMapDivision: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarDivision x = exp as ScalarDivision;
			if(ScalarExtractor.ReorderFactors(ref exp))
				return true;
			if(x.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
			{
				exp = ScalarExpressionValue.One(context);
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar1 as ScalarNegative;
				IScalarExpression z = new ScalarDivision(context,y.Parameters.Scalar1,x.Parameters.Scalar2).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarNegative(context,z).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar2 as ScalarNegative;
				IScalarExpression z = new ScalarDivision(context,x.Parameters.Scalar1,y.Parameters.Scalar1).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarNegative(context,z).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower) && x.Parameters.Scalar2.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y1 = x.Parameters.Scalar1 as ScalarRaiseToPower;
				ScalarRaiseToPower y2 = x.Parameters.Scalar2 as ScalarRaiseToPower;
				if(y1.Parameters.Scalar1.Equals(y2.Parameters.Scalar1))
				{
					exp = new ScalarRaiseToPower(context,y1.Parameters.Scalar1,new ScalarSubtraction(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2)).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y = x.Parameters.Scalar1 as ScalarRaiseToPower;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarRaiseToPower(context,y.Parameters.Scalar1,new ScalarSubtraction(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y = x.Parameters.Scalar2 as ScalarRaiseToPower;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarRaiseToPower(context,y.Parameters.Scalar1,new ScalarSubtraction(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context)))).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar1 as ScalarMultiplication;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
				{
					exp = y.Parameters.Scalar2;
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar2))
				{
					exp = y.Parameters.Scalar1;
					return(true);
				}
				if(y.Parameters.Scalar2.GetType() == typeof(ScalarRaiseToPower))
				{
					ScalarRaiseToPower z = y.Parameters.Scalar2 as ScalarRaiseToPower;
					if(z.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
					{
						exp = new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarRaiseToPower(context,z.Parameters.Scalar1,new ScalarSubtraction(context,z.Parameters.Scalar2,ScalarExpressionValue.One(context)))).Simplify();
						return(true);
					}
				}
				if(y.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower))
				{
					ScalarRaiseToPower z = y.Parameters.Scalar1 as ScalarRaiseToPower;
					if(z.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
					{
						exp = new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarRaiseToPower(context,z.Parameters.Scalar1,new ScalarSubtraction(context,z.Parameters.Scalar2,ScalarExpressionValue.One(context)))).Simplify();
						return(true);
					}
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar2 as ScalarMultiplication;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarDivision(context,ScalarExpressionValue.One(context),y.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarDivision(context,ScalarExpressionValue.One(context),y.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.GetType() == typeof(ScalarRaiseToPower))
				{
					ScalarRaiseToPower z = y.Parameters.Scalar2 as ScalarRaiseToPower;
					if(z.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
					{
						exp = new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarMultiplication(context,y.Parameters.Scalar1,new ScalarRaiseToPower(context,z.Parameters.Scalar1,new ScalarSubtraction(context,z.Parameters.Scalar2,ScalarExpressionValue.One(context))))).Simplify();
						return(true);
					}
				}
				if(y.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower))
				{
					ScalarRaiseToPower z = y.Parameters.Scalar1 as ScalarRaiseToPower;
					if(z.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
					{
						exp = new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarMultiplication(context,y.Parameters.Scalar2,new ScalarRaiseToPower(context,z.Parameters.Scalar1,new ScalarSubtraction(context,z.Parameters.Scalar2,ScalarExpressionValue.One(context))))).Simplify();
						return(true);
					}
				}
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarAddition),"simple")]
	public class ScalarMapAddition: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarAddition x = exp as ScalarAddition;
			if(ScalarExtractor.ReorderSummands(ref exp))
				return true;
			if(x.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
			{
				exp = new ScalarMultiplication(context,ScalarExpressionValue.Two(context),x.Parameters.Scalar1).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication) && x.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y1 = x.Parameters.Scalar1 as ScalarMultiplication;
				ScalarMultiplication y2 = x.Parameters.Scalar2 as ScalarMultiplication;
				if(y1.Parameters.Scalar1.Equals(y2.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2),y1.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y1.Parameters.Scalar1.Equals(y2.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y1.Parameters.Scalar2,y2.Parameters.Scalar1),y1.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y1.Parameters.Scalar2.Equals(y2.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y1.Parameters.Scalar1,y2.Parameters.Scalar2),y1.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(y1.Parameters.Scalar2.Equals(y2.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y1.Parameters.Scalar1,y2.Parameters.Scalar1),y1.Parameters.Scalar2).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarDivision) && x.Parameters.Scalar2.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y1 = x.Parameters.Scalar1 as ScalarDivision;
				ScalarDivision y2 = x.Parameters.Scalar2 as ScalarDivision;
				if(y1.Parameters.Scalar2.Equals(y2.Parameters.Scalar2))
				{
					exp = new ScalarDivision(context,new ScalarAddition(context,y1.Parameters.Scalar1,y2.Parameters.Scalar1),y1.Parameters.Scalar2).Simplify();
					return true;
				}
				if(!y1.IsConstant && !y2.IsConstant || y1.IsConstant && y2.IsConstant)
				{
					exp = new ScalarDivision(context,new ScalarAddition(context,new ScalarMultiplication(context,y1.Parameters.Scalar1,y2.Parameters.Scalar2),new ScalarMultiplication(context,y1.Parameters.Scalar2,y2.Parameters.Scalar1)),new ScalarMultiplication(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2));
					return true;
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar1 as ScalarMultiplication;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context)),x.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y.Parameters.Scalar1,ScalarExpressionValue.One(context)),x.Parameters.Scalar2).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar2 as ScalarMultiplication;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context)),x.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarAddition(context,y.Parameters.Scalar1,ScalarExpressionValue.One(context)),x.Parameters.Scalar1).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar2 as ScalarNegative;
				exp = new ScalarSubtraction(context,x.Parameters.Scalar1,y.Parameters.Scalar1).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar2.IsEntity && x.Parameters.Scalar2.Calculate() < 0)
			{
				exp = new ScalarSubtraction(context,x.Parameters.Scalar1,new ScalarNegative(context,x.Parameters.Scalar2)).Simplify();
				return(true);
			}
//			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative))
//			{
//				ScalarNegative y = x.Parameters.Scalar1 as ScalarNegative;
//				exp = new ScalarSubtraction(x.Parameters.Scalar2,y.Parameters.Scalar1).Simplify();
//				return(true);
//			}
			if(x.Parameters.Scalar1.IsEntity && x.Parameters.Scalar1.Calculate() < 0)
			{
				exp = new ScalarSubtraction(context,x.Parameters.Scalar2,new ScalarNegative(context,x.Parameters.Scalar1)).Simplify();
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarSubtraction),"simple")]
	public class ScalarMapSubtraction: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarSubtraction x = exp as ScalarSubtraction;
			if(ScalarExtractor.ReorderSummands(ref exp))
				return true;
//			IScalarExpression[] list = ScalarExtractor.SplitSummands(exp);
//			if(ScalarExtractor.SortExpressions(ref list))
//			{
//				exp = ScalarExtractor.CombineSortedSum(list);
//				return true;
//			}
//			exp = ScalarExtractor.CombineSortedSum(list);
//			if(!x.Equals(exp))
//				return true;
			if(x.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
			{
				exp = ScalarExpressionValue.Zero(context);
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication) && x.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y1 = x.Parameters.Scalar1 as ScalarMultiplication;
				ScalarMultiplication y2 = x.Parameters.Scalar2 as ScalarMultiplication;
				if(y1.Parameters.Scalar1.Equals(y2.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2),y1.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y1.Parameters.Scalar1.Equals(y2.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,y1.Parameters.Scalar2,y2.Parameters.Scalar1),y1.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y1.Parameters.Scalar2.Equals(y2.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,y1.Parameters.Scalar1,y2.Parameters.Scalar2),y1.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(y1.Parameters.Scalar2.Equals(y2.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,y1.Parameters.Scalar1,y2.Parameters.Scalar1),y1.Parameters.Scalar2).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar1 as ScalarMultiplication;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,y.Parameters.Scalar2,ScalarExpressionValue.One(context)),x.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar2))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,y.Parameters.Scalar1,ScalarExpressionValue.One(context)),x.Parameters.Scalar2).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarMultiplication))
			{
				ScalarMultiplication y = x.Parameters.Scalar2 as ScalarMultiplication;
				if(y.Parameters.Scalar1.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),y.Parameters.Scalar2),x.Parameters.Scalar1).Simplify();
					return(true);
				}
				if(y.Parameters.Scalar2.Equals(x.Parameters.Scalar1))
				{
					exp = new ScalarMultiplication(context,new ScalarSubtraction(context,ScalarExpressionValue.One(context),y.Parameters.Scalar1),x.Parameters.Scalar1).Simplify();
					return(true);
				}
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarDivision) && x.Parameters.Scalar2.GetType() == typeof(ScalarDivision))
			{
				ScalarDivision y1 = x.Parameters.Scalar1 as ScalarDivision;
				ScalarDivision y2 = x.Parameters.Scalar2 as ScalarDivision;
				if(y1.Parameters.Scalar2.Equals(y2.Parameters.Scalar2))
				{
					exp = new ScalarDivision(context,new ScalarSubtraction(context,y1.Parameters.Scalar1,y2.Parameters.Scalar1),y1.Parameters.Scalar2).Simplify();
					return(true);
				}
				if(!y1.IsConstant && !y2.IsConstant || y1.IsConstant && y2.IsConstant)
				{
					exp = new ScalarDivision(context,new ScalarSubtraction(context,new ScalarMultiplication(context,y1.Parameters.Scalar1,y2.Parameters.Scalar2),new ScalarMultiplication(context,y1.Parameters.Scalar2,y2.Parameters.Scalar1)),new ScalarMultiplication(context,y1.Parameters.Scalar2,y2.Parameters.Scalar2));
					return true;
				}
			}
			if(x.Parameters.Scalar2.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar2 as ScalarNegative;
				exp = new ScalarAddition(context,x.Parameters.Scalar1,y.Parameters.Scalar1).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar2.IsEntity && x.Parameters.Scalar2.Calculate() < 0)
			{
				exp = new ScalarAddition(context,x.Parameters.Scalar1,new ScalarNegative(context,x.Parameters.Scalar2)).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar1 as ScalarNegative;
				exp = new ScalarNegative(context,new ScalarAddition(context,x.Parameters.Scalar2,y.Parameters.Scalar1)).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.IsEntity && x.Parameters.Scalar1.Calculate() < 0)
			{
				exp = new ScalarNegative(context,new ScalarAddition(context,x.Parameters.Scalar2,new ScalarNegative(context,x.Parameters.Scalar1))).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarAddition))
			{
				ScalarAddition y = x.Parameters.Scalar1 as ScalarAddition;
				if(y.Parameters.Scalar1.IsEntity && x.Parameters.Scalar2.IsEntity)
				{
					exp = new ScalarAddition(context,new ScalarSubtraction(context,y.Parameters.Scalar1,x.Parameters.Scalar2),y.Parameters.Scalar2);
					return(true);
				}
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarNegative),"simple")]
	public class ScalarMapNegative: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarNegative x = exp as ScalarNegative;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar1 as ScalarNegative;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarAbsolute),"simple")]
	public class ScalarMapAbsolute: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarAbsolute x = exp as ScalarAbsolute;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNegative))
			{
				ScalarNegative y = x.Parameters.Scalar1 as ScalarNegative;
				exp = new ScalarAbsolute(context,y.Parameters.Scalar1);
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarRaiseToPower),"simple")]
	public class ScalarMapRaiseToPower: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarRaiseToPower x = exp as ScalarRaiseToPower;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarRaiseToPower))
			{
				ScalarRaiseToPower y = x.Parameters.Scalar1 as ScalarRaiseToPower;
				IScalarExpression z = new ScalarMultiplication(context,x.Parameters.Scalar2,y.Parameters.Scalar2).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarRaiseToPower(context,y.Parameters.Scalar1,z).Simplify();
				return(true);
			}
			//			if(x.Parameters.Scalar2.GetType() == typeof(ScalarNegative))
			//			{
			//				ScalarNegative y = x.Parameters.Scalar2 as ScalarNegative;
			//				IScalarExpression z = new ScalarRaiseToPower(x.Parameters.Scalar1,y.Parameters.Scalar1).Simplify();
			//				ScalarConversionMap.Convert(ref z,"simple");
			//				exp = new ScalarDivision(ScalarExpressionValue.One(context),z).Simplify();
			//				return(true);
			//			}
			//			if(x.Parameters.Scalar2.IsEntity && x.Parameters.Scalar2.Calculate() < 0)
			//			{
			//				ScalarNegative y = x.Parameters.Scalar2 as ScalarNegative;
			//				IScalarExpression z = new ScalarRaiseToPower(x.Parameters.Scalar1,new ScalarNegative(x.Parameters.Scalar2)).Simplify();
			//				ScalarConversionMap.Convert(ref z,"simple");
			//				exp = new ScalarDivision(ScalarExpressionValue.One(context),z).Simplify();
			//				return(true);
			//			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarExponential),"simple")]
	public class ScalarMapExponential: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarExponential x = exp as ScalarExponential;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarNaturalLogarithm))
			{
				ScalarNaturalLogarithm y = x.Parameters.Scalar1 as ScalarNaturalLogarithm;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarGeneralLogarithm))
			{
				ScalarGeneralLogarithm y = x.Parameters.Scalar1 as ScalarGeneralLogarithm;
				IScalarExpression z = new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarNaturalLogarithm(context,y.Parameters.Scalar2)).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarRaiseToPower(context,y.Parameters.Scalar1,z).Simplify();
				return(true);
			}
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarCommonLogarithm))
			{
				ScalarCommonLogarithm y = x.Parameters.Scalar1 as ScalarCommonLogarithm;
				IScalarExpression z = new ScalarDivision(context,ScalarExpressionValue.One(context),new ScalarNaturalLogarithm(context,new ScalarExpressionValue(context,10))).Simplify();
				ScalarConversionMap.Convert(ref z,"simple");
				exp = new ScalarRaiseToPower(context,y.Parameters.Scalar1,z).Simplify();
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(ScalarNaturalLogarithm),"simple")]
	public class ScalarMapNaturalLogarithm: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			ScalarNaturalLogarithm x = exp as ScalarNaturalLogarithm;
			if(x.Parameters.Scalar1.GetType() == typeof(ScalarExponential))
			{
				ScalarExponential y = x.Parameters.Scalar1 as ScalarExponential;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}

	#region Trigonometry
	[ConversionMapEntry(typeof(Trigonometry.ScalarTrigSinus),"simple")]
	public class ScalarMapTrigSinus: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Trigonometry.ScalarTrigSinus x = exp as Trigonometry.ScalarTrigSinus;
			if(x.Parameters.Scalar1.GetType() == typeof(Trigonometry.ScalarTrigArcSinus))
			{
				Trigonometry.ScalarTrigArcSinus y = x.Parameters.Scalar1 as Trigonometry.ScalarTrigArcSinus;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(Trigonometry.ScalarTrigCosinus),"simple")]
	public class ScalarMapTrigCosinus: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Trigonometry.ScalarTrigCosinus x = exp as Trigonometry.ScalarTrigCosinus;
			if(x.Parameters.Scalar1.GetType() == typeof(Trigonometry.ScalarTrigArcCosinus))
			{
				Trigonometry.ScalarTrigArcCosinus y = x.Parameters.Scalar1 as Trigonometry.ScalarTrigArcCosinus;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(Trigonometry.ScalarTrigTangens),"simple")]
	public class ScalarMapTrigTangens: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Trigonometry.ScalarTrigTangens x = exp as Trigonometry.ScalarTrigTangens;
			if(x.Parameters.Scalar1.GetType() == typeof(Trigonometry.ScalarTrigArcTangens))
			{
				Trigonometry.ScalarTrigArcTangens y = x.Parameters.Scalar1 as Trigonometry.ScalarTrigArcTangens;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(Trigonometry.ScalarTrigArcSinus),"simple")]
	public class ScalarMapTrigArcSinus: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Trigonometry.ScalarTrigArcSinus x = exp as Trigonometry.ScalarTrigArcSinus;
			if(x.Parameters.Scalar1.GetType() == typeof(Trigonometry.ScalarTrigSinus))
			{
				Trigonometry.ScalarTrigSinus y = x.Parameters.Scalar1 as Trigonometry.ScalarTrigSinus;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(Trigonometry.ScalarTrigArcCosinus),"simple")]
	public class ScalarMapTrigArcCosinus: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Trigonometry.ScalarTrigArcCosinus x = exp as Trigonometry.ScalarTrigArcCosinus;
			if(x.Parameters.Scalar1.GetType() == typeof(Trigonometry.ScalarTrigCosinus))
			{
				Trigonometry.ScalarTrigCosinus y = x.Parameters.Scalar1 as Trigonometry.ScalarTrigCosinus;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	[ConversionMapEntry(typeof(Trigonometry.ScalarTrigArcTangens),"simple")]
	public class ScalarMapTrigArcTangens: ScalarMapEntry
	{
		public override bool ConvertTo(ref IScalarExpression exp)
		{
			Trigonometry.ScalarTrigArcTangens x = exp as Trigonometry.ScalarTrigArcTangens;
			if(x.Parameters.Scalar1.GetType() == typeof(Trigonometry.ScalarTrigTangens))
			{
				Trigonometry.ScalarTrigTangens y = x.Parameters.Scalar1 as Trigonometry.ScalarTrigTangens;
				exp = y.Parameters.Scalar1;
				return(true);
			}
			return(false);
		}
	}
	#endregion
}
