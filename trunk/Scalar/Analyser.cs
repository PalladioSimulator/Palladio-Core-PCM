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

namespace cdrnet.Lib.MathLib.Scalar
{
	public class ScalarExtractor
	{
		public static bool ReorderSummands(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			bool reorder = false;
			int mode = 0;
			IScalarExpression posentity = ScalarExpressionValue.Zero(context);
			IScalarExpression negentity = ScalarExpressionValue.Zero(context);
			IScalarExpression posconstant = ScalarExpressionValue.Zero(context);
			IScalarExpression negconstant = ScalarExpressionValue.Zero(context);
			ArrayList posvar = new ArrayList();
			ArrayList negvar = new ArrayList();
			//Split Summands
			ArrayList list = new ArrayList();
			RecursiveSplitSummand(list,exp,true);
			//Group Summands
			for(int i=0;i<list.Count;i++)
			{
				IScalarExpression e = list[i] as IScalarExpression;
				if(e.GetType() != typeof(ScalarNegative))
				{
					if(e.IsEntity)
					{
						if(mode > 1)
							reorder = true;
						mode = 1;
						posentity = new ScalarAddition(context,posentity,e);
						continue;
					}
					if(e.IsConstant)
					{
						if(mode > 2)
							reorder = true;
						mode = 2;
						posconstant = new ScalarAddition(context,posconstant,e);
						continue;
					}
					if(mode > 3)
						reorder = true;
					mode = 3;
					posvar.Add(e);
				}
				else
				{
					ScalarNegative n = e as ScalarNegative;
					e = n.Parameters.Scalar1;
					if(e.IsEntity)
					{
						if(mode > 4)
							reorder = true;
						mode = 4;
						negentity = new ScalarAddition(context,negentity,e);
						continue;
					}
					if(e.IsConstant)
					{
						if(mode > 5)
							reorder = true;
						mode = 5;
						negconstant = new ScalarAddition(context,negconstant,e);
						continue;
					}
					if(mode > 6)
						reorder = true;
					mode = 6;
					negvar.Add(e);
				}
			}
			//Combine and place constant summands
			IScalarExpression pos = new ScalarAddition(context,posentity,posconstant).Simplify();
			IScalarExpression neg = new ScalarAddition(context,negentity,negconstant).Simplify();
			if(pos.Calculate() != 0 && neg.Calculate() != 0 && (posvar.Count > 0 || negvar.Count > 0))
			{
				reorder = true;
				if(pos.Calculate() > neg.Calculate())
				{
					pos = new ScalarSubtraction(context,pos,neg);
					neg = ScalarExpressionValue.Zero(context);
				}
				else
				{
					neg = new ScalarSubtraction(context,neg,pos);
					pos = ScalarExpressionValue.Zero(context);
				}
			}
			//Eliminate x-x
			for(int i=0;i<posvar.Count;i++)
				for(int j=0;j<negvar.Count;j++)
					if((posvar[i] as IExpression).Equals(negvar[j] as IExpression))
					{
						reorder = true;
						posvar.RemoveAt(i--);
						negvar.RemoveAt(j);
						j=-1;
						if(i<0)
							break;
					}
			//Combine nonconstant parts
			IScalarExpression posx = ScalarExpressionValue.Zero(context);
			for(int i=0;i<posvar.Count;i++)
				posx = new ScalarAddition(context,posx,posvar[i] as IScalarExpression);
			IScalarExpression negx = ScalarExpressionValue.Zero(context);
			for(int i=0;i<negvar.Count;i++)
				negx = new ScalarAddition(context,negx,negvar[i] as IScalarExpression);
			//Combine constant and nonoconstant summands
			exp = new ScalarSubtraction(context,new ScalarAddition(context,pos,posx),new ScalarAddition(context,neg,negx)).Simplify();
			return reorder;
		}
		private static void RecursiveSplitSummand(ArrayList list,IScalarExpression sum,bool positive)
		{
			Context context = sum.Context;
			ScalarAddition m = sum as ScalarAddition;
			ScalarSubtraction n = sum as ScalarSubtraction;
			if(m != null)
			{
				RecursiveSplitSummand(list,m.Parameters.Scalar1,positive);
				RecursiveSplitSummand(list,m.Parameters.Scalar2,positive);
				return;
			}
			if(n != null)
			{
				RecursiveSplitSummand(list,n.Parameters.Scalar1,positive);
				RecursiveSplitSummand(list,n.Parameters.Scalar2,!positive);
				return;
			}
			list.Add(positive ? sum : new ScalarNegative(context,sum));
		}

		public static bool ReorderFactors(ref IScalarExpression exp)
		{
			Context context = exp.Context;
			bool reorder = false;
			int mode = 0;
			IScalarExpression posentity = ScalarExpressionValue.One(context);
			IScalarExpression negentity = ScalarExpressionValue.One(context);
			IScalarExpression posconstant = ScalarExpressionValue.One(context);
			IScalarExpression negconstant = ScalarExpressionValue.One(context);
			ArrayList posvar = new ArrayList();
			ArrayList negvar = new ArrayList();
			//Split Factors
			ArrayList list = new ArrayList();
			RecursiveSplitFactors(list,exp,true);
			//Group Factors
			for(int i=0;i<list.Count;i++)
			{
				IScalarExpression e = list[i] as IScalarExpression;
				if(e.GetType() != typeof(ScalarDivision))
				{
					if(e.IsEntity)
					{
						if(mode > 1)
							reorder = true;
						mode = 1;
						posentity = new ScalarMultiplication(context,posentity,e);
						continue;
					}
					if(e.IsConstant)
					{
						if(mode > 2)
							reorder = true;
						mode = 2;
						posconstant = new ScalarMultiplication(context,posconstant,e);
						continue;
					}
					if(mode > 3)
						reorder = true;
					mode = 3;
					posvar.Add(e);
				}
				else
				{
					ScalarDivision n = e as ScalarDivision;
					e = n.Parameters.Scalar2;
					if(e.IsEntity)
					{
						if(mode > 4)
							reorder = true;
						mode = 4;
						negentity = new ScalarMultiplication(context,negentity,e);
						continue;
					}
					if(e.IsConstant)
					{
						if(mode > 5)
							reorder = true;
						mode = 5;
						negconstant = new ScalarMultiplication(context,negconstant,e);
						continue;
					}
					if(mode > 6)
						reorder = true;
					mode = 6;
					negvar.Add(e);
				}
			}
			//Combine and place constant factors
			IScalarExpression pos = new ScalarMultiplication(context,posentity,posconstant).Simplify();
			IScalarExpression neg = new ScalarMultiplication(context,negentity,negconstant).Simplify();
			IScalarExpression div = new ScalarDivision(context,pos,neg).Simplify();
			ScalarDivision divd = div as ScalarDivision;
			if(divd == null)
			{
				if(neg.Calculate() != 1)
				{
					reorder = true;
					pos = div;
					neg = ScalarExpressionValue.One(context);
				}
			}
			else
			{
				if(!pos.Equals(divd.Parameters.Scalar1))
				{
					reorder = true;
					pos = divd.Parameters.Scalar1;
					neg = divd.Parameters.Scalar2;
				}
			}
			//Eliminate x/x
			for(int i=0;i<posvar.Count;i++)
				for(int j=0;j<negvar.Count;j++)
				{
					IScalarExpression pose = posvar[i] as IScalarExpression;
					IScalarExpression nege = negvar[j] as IScalarExpression;
					if(pose.Equals(nege))
					{
						reorder = true;
						posvar.RemoveAt(i--);
						negvar.RemoveAt(j);
						j=-1;
						if(i<0)
							break;
						continue;
					}
					ScalarRaiseToPower posr = pose as ScalarRaiseToPower;
					ScalarRaiseToPower negr = nege as ScalarRaiseToPower;
					if(posr != null && negr != null && posr.Parameters.Scalar1.Equals(negr.Parameters.Scalar1))
					{
						posvar[i--] = new ScalarRaiseToPower(context,posr.Parameters.Scalar1,new ScalarSubtraction(context,posr.Parameters.Scalar2,negr.Parameters.Scalar2)).Simplify();
						reorder = true;
						negvar.RemoveAt(j);
						j=-1;
						if(i<0)
							break;
						continue;
					}
					if(posr != null && posr.Parameters.Scalar1.Equals(nege))
					{
						posvar[i--] = new ScalarRaiseToPower(context,posr.Parameters.Scalar1,new ScalarSubtraction(context,posr.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
						reorder = true;
						negvar.RemoveAt(j);
						j=-1;
						if(i<0)
							break;
						continue;
					}
					if(negr != null && negr.Parameters.Scalar1.Equals(pose))
					{
						negvar[j] = new ScalarRaiseToPower(context,negr.Parameters.Scalar1,new ScalarSubtraction(context,negr.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
						reorder = true;
						posvar.RemoveAt(i--);
						j=-1;
						if(i<0)
							break;
						continue;
					}
				}
//			for(int i=0;i<posvar.Count;i++)
//				for(int j=0;j<negvar.Count&&i<posvar.Count;j++)
//				{
//					IScalarExpression pose = posvar[i] as IScalarExpression;
//					IScalarExpression nege = negvar[j] as IScalarExpression;
//					if(pose.Equals(nege))
//					{
//						reorder = true;
//						posvar.RemoveAt(i);
//						negvar.RemoveAt(j);
//						if(i>0 && i==posvar.Count)
//							i--;
//						j=0;
//						continue;
//					}
//					ScalarRaiseToPower posr = pose as ScalarRaiseToPower;
//					ScalarRaiseToPower negr = nege as ScalarRaiseToPower;
//					if(posr != null && negr != null && posr.Parameters.Scalar1.Equals(negr.Parameters.Scalar1))
//					{
//						posvar[i] = new ScalarRaiseToPower(posr.Parameters.Scalar1,new ScalarSubtraction(posr.Parameters.Scalar2,negr.Parameters.Scalar2)).Simplify();
//						reorder = true;
//						negvar.RemoveAt(j);
//						i=0;
//						j=0;
//						continue;
//					}
//					if(posr != null && posr.Parameters.Scalar1.Equals(nege))
//					{
//						posvar[i] = new ScalarRaiseToPower(posr.Parameters.Scalar1,new ScalarSubtraction(posr.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
//						reorder = true;
//						negvar.RemoveAt(j);
//						i=0;
//						j=0;
//						continue;
//					}
//					if(negr != null && negr.Parameters.Scalar1.Equals(pose))
//					{
//						negvar[j] = new ScalarRaiseToPower(negr.Parameters.Scalar1,new ScalarSubtraction(negr.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
//						reorder = true;
//						posvar.RemoveAt(i);
//						i=0;
//						j=0;
//						continue;
//					}
//				}
			//Simplify x^a*x^b
			for(int i=0;i<posvar.Count;i++)
				for(int j=i+1;j<posvar.Count;j++)
				{
					IScalarExpression posie = posvar[i] as IScalarExpression;
					IScalarExpression posje = posvar[j] as IScalarExpression;
					if(posie.Equals(posje))
					{
						reorder = true;
						posvar[i] = new ScalarRaiseToPower(context,posie,ScalarExpressionValue.Two(context));
						posvar.RemoveAt(j);
						j=i+1;
						continue;
					}
					ScalarRaiseToPower posir = posie as ScalarRaiseToPower;
					ScalarRaiseToPower posjr = posje as ScalarRaiseToPower;
					if(posir != null && posjr != null && posir.Parameters.Scalar1.Equals(posjr.Parameters.Scalar1))
					{
						posvar[i] = new ScalarRaiseToPower(context,posir.Parameters.Scalar1,new ScalarAddition(context,posir.Parameters.Scalar2,posjr.Parameters.Scalar2)).Simplify();
						reorder = true;
						posvar.RemoveAt(j);
						j=i+1;
						continue;
					}
					if(posir != null && posir.Parameters.Scalar1.Equals(posje))
					{
						posvar[i] = new ScalarRaiseToPower(context,posir.Parameters.Scalar1,new ScalarAddition(context,posir.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
						reorder = true;
						posvar.RemoveAt(j);
						j=i+1;
						continue;
					}
					if(posjr != null && posjr.Parameters.Scalar1.Equals(posie))
					{
						posvar[i] = new ScalarRaiseToPower(context,posjr.Parameters.Scalar1,new ScalarAddition(context,posjr.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
						reorder = true;
						posvar.RemoveAt(j);
						j=i+1;
						continue;
					}
				}
			//Simplify 1/(x^a*x^b)
			for(int i=0;i<negvar.Count;i++)
				for(int j=i+1;j<negvar.Count;j++)
				{
					IScalarExpression negie = negvar[i] as IScalarExpression;
					IScalarExpression negje = negvar[j] as IScalarExpression;
					if(negie.Equals(negje))
					{
						reorder = true;
						negvar[i] = new ScalarRaiseToPower(context,negie,ScalarExpressionValue.Two(context));
						negvar.RemoveAt(j);
						j=i+1;
						continue;
					}
					ScalarRaiseToPower negir = negie as ScalarRaiseToPower;
					ScalarRaiseToPower negjr = negje as ScalarRaiseToPower;
					if(negir != null && negjr != null && negir.Parameters.Scalar1.Equals(negjr.Parameters.Scalar1))
					{
						negvar[i] = new ScalarRaiseToPower(context,negir.Parameters.Scalar1,new ScalarAddition(context,negir.Parameters.Scalar2,negjr.Parameters.Scalar2)).Simplify();
						reorder = true;
						negvar.RemoveAt(j);
						j=i+1;
						continue;
					}
					if(negir != null && negir.Parameters.Scalar1.Equals(negje))
					{
						negvar[i] = new ScalarRaiseToPower(context,negir.Parameters.Scalar1,new ScalarAddition(context,negir.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
						reorder = true;
						negvar.RemoveAt(j);
						j=i+1;
						continue;
					}
					if(negjr != null && negjr.Parameters.Scalar1.Equals(negie))
					{
						negvar[i] = new ScalarRaiseToPower(context,negjr.Parameters.Scalar1,new ScalarAddition(context,negjr.Parameters.Scalar2,ScalarExpressionValue.One(context))).Simplify();
						reorder = true;
						negvar.RemoveAt(j);
						j=i+1;
						continue;
					}
				}
			//Combine nonconstant parts
			IScalarExpression posx = ScalarExpressionValue.One(context);
			for(int i=0;i<posvar.Count;i++)
				posx = new ScalarMultiplication(context,posx,posvar[i] as IScalarExpression);
			IScalarExpression negx = ScalarExpressionValue.One(context);
			for(int i=0;i<negvar.Count;i++)
				negx = new ScalarMultiplication(context,negx,negvar[i] as IScalarExpression);
			//Combine constant and nonoconstant summands
			exp = new ScalarDivision(context,new ScalarMultiplication(context,pos,posx),new ScalarMultiplication(context,neg,negx)).Simplify();
			return reorder;
		}
		private static void RecursiveSplitFactors(ArrayList list,IScalarExpression product,bool positive)
		{
			Context context = product.Context;
			ScalarMultiplication m = product as ScalarMultiplication;
			ScalarDivision n = product as ScalarDivision;
			if(m != null)
			{
				RecursiveSplitFactors(list,m.Parameters.Scalar1,positive);
				RecursiveSplitFactors(list,m.Parameters.Scalar2,positive);
				return;
			}
			if(n != null)
			{
				RecursiveSplitFactors(list,n.Parameters.Scalar1,positive);
				RecursiveSplitFactors(list,n.Parameters.Scalar2,!positive);
				return;
			}
			list.Add(positive ? product : new ScalarDivision(context,ScalarExpressionValue.One(context),product));
		}
	}
}
