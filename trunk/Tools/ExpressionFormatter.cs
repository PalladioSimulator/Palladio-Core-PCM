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
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.Geometry;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;
//using cdrnet.Lib.MathLib.Scalar.Tensor;
using cdrnet.Lib.MathLib.Scalar.List;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Complex.LinearAlgebra;
using cdrnet.Lib.MathLib.Digital;
using cdrnet.Lib.MathLib.Literal;
using cdrnet.Lib.MathLib.Time;

namespace cdrnet.Lib.MathLib.Tools
{
	public interface IExpressionStringFormatter
	{
		string Format(IExpression expression);
	}
	public class MultilineStringFormatter: IExpressionStringFormatter
	{
		public string Format(IExpression exp)
		{
			Context context = exp.Context;
			StringBuilder output = new StringBuilder();
			try
			{
				IScalarExpression sexp = exp as IScalarExpression;
				if(sexp != null)
				{
					output.Append("Scalar:\t"+sexp.ToString()+"\r\n");
					sexp = sexp.Simplify();
					ScalarConversionMap.Convert(ref sexp,"simple");
					output.Append("Simple:\t"+sexp.ToString()+"\r\n");
					output.Append("Expand:\t"+sexp.SafeExpand().Simplify().ToString()+"\r\n");
					ScalarExpressionVariable x = context.ContextVariables.GetCreateVariable("x") as ScalarExpressionVariable;
					if(x != null)
					{
						bool virt = x.IsThreatenedAsVariable;
						x.IsThreatenedAsVariable = true;
						//sexp = sexp.Simplify();
						//ScalarConversionMap.Convert(ref sexp,"simple");
						try
						{
							IScalarExpression sexp_td = sexp.Differentiate(x);
							x.IsThreatenedAsVariable = virt;
							sexp_td = sexp_td.Simplify();
							ScalarConversionMap.Convert(ref sexp_td, "simple");
							output.Append("diff x:\t"+sexp_td.ToString()+"\r\n");
							x.IsThreatenedAsVariable = true;
						}
						catch(ExpressionNotDeriveableException ee) {}
						try
						{
							IScalarExpression sexp_ti = sexp.Integrate(x);
							x.IsThreatenedAsVariable = virt;
							sexp_ti = sexp_ti.Simplify();
							ScalarConversionMap.Convert(ref sexp_ti, "simple");
							output.Append("int x:\t"+sexp_ti.ToString()+"\r\n");
							x.IsThreatenedAsVariable = true;
						}
						catch(ExpressionNotIntegratableException ee) {}
						x.IsThreatenedAsVariable = virt;
					}
					if(sexp.IsConstant)
					{
						output.Append("Calc:\t"+sexp.Calculate()+"\r\n");
					}
					return(output.ToString());
				}
				ITripleExpression texp = exp as ITripleExpression;
				if(texp != null)
				{
					output.Append("Triple:\t"+texp.ToString()+"\r\n");
					texp = texp.Simplify();
					TripleConversionMap.Convert(ref texp,"simple");
					output.Append("Simple:\t"+texp.ToString()+"\r\n");
					output.Append("Expand:\t"+texp.SafeExpand().Simplify().ToString()+"\r\n");
					if(texp.IsConstant)
					{
						ValueTriple vt = texp.Calculate();
						output.Append("Calc:\t"+vt.ToString()+"\r\n");
						output.Append("Abs:\t"+vt.ToAbsolute()+"\r\n");
					}
					return(output.ToString());
				}
				IVectorExpression vexp = exp as IVectorExpression;
				if(vexp != null)
				{
					output.Append("Vector:\t"+vexp.ToString()+"\r\n");
					vexp = vexp.Simplify();
					VectorConversionMap.Convert(ref vexp,"simple");
					output.Append("Simple:\t"+vexp.ToString()+"\r\n");
					output.Append("Expand:\t"+vexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(vexp.IsConstant)
					{
						ValueVector vv = vexp.Calculate();
						output.Append("Calc:\t"+vv.ToString()+"\r\n");
					}
					return(output.ToString());
				}
				IMatrixExpression mexp = exp as IMatrixExpression;
				if(mexp != null)
				{
					output.Append("Matrix:\t"+mexp.ToString()+"\r\n");
					mexp = mexp.Simplify();
					MatrixConversionMap.Convert(ref mexp,"simple");
					output.Append("Simple:\t"+mexp.ToString()+"\r\n");
					output.Append("Expand:\t"+mexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(mexp.IsConstant)
					{
						ValueMatrix vm = mexp.Calculate();
						output.Append("Calc:\t"+vm.ToString()+"\r\n");
					}
					return(output.ToString());
				}
//				ITensorExpression teexp = exp as ITensorExpression;
//				if(teexp != null)
//				{
//					output.Append("Tensor:\t"+teexp.ToString()+"\r\n");
//					teexp = teexp.ExpressionTensor;
//					TensorConversionMap.Convert(ref teexp,"simple");
//					output.Append("Trace:\t"+teexp.ToString()+"\r\n");
//					if(teexp.IsConstant)
//					{
//						ValueTensor vte = teexp.Calculate();
//						output.Append("Calc:\t"+vte.ToString()+"\r\n");
//					}
//					return(output.ToString());
//				}
				IListExpression lexp = exp as IListExpression;
				if(lexp != null)
				{
					output.Append("List:\t"+lexp.ToString()+"\r\n");
					lexp = lexp.Simplify();
					output.Append("Simple:\t"+lexp.ToString()+"\r\n");
					output.Append("Expand:\t"+lexp.SafeExpand().Simplify().ToString()+"\r\n");
						
					if(lexp.IsConstant)
					{
						ValueList vl = lexp.Calculate();
						output.Append("Calc:\t"+vl.ToString()+"\r\n");
						output.Append("Sum:\t"+vl.ToSum()+"\r\n");
					}
					return(output.ToString());
				}
				IMatrixListExpression lmexp = exp as IMatrixListExpression;
				if(lmexp != null)
				{
					output.Append("MList:\t"+lmexp.ToString()+"\r\n");
					lmexp = lmexp.Simplify();
					output.Append("Simple:\t"+lmexp.ToString()+"\r\n");
					output.Append("Expand:\t"+texp.SafeExpand().Simplify().ToString()+"\r\n");
					if(lmexp.IsConstant)
					{
						ValueMatrixList vml = lmexp.Calculate();
						output.Append("Calc:\t"+vml.ToString()+"\r\n");
					}
					return(output.ToString());
				}
				IComplexExpression cexp = exp as IComplexExpression;
				if(cexp != null)
				{
					output.Append("Cplex:\t"+cexp.ToString()+"\r\n");
					cexp = cexp.Simplify();
					ComplexConversionMap.Convert(ref cexp,"simple");
					output.Append("Simple:\t"+cexp.ToString()+"\r\n");
					output.Append("Expand:\t"+cexp.SafeExpand().Simplify().ToString()+"\r\n");
					output.Append("Real:\t"+cexp.ExpandReal().Simplify().ToString()+"\r\n");
					output.Append("Imag:\t"+cexp.ExpandImag().Simplify().ToString()+"\r\n");
					ComplexExpressionVariable y = context.ContextVariables.GetCreateVariable("x") as ComplexExpressionVariable;
					if(y != null)
					{
						bool virt = y.IsThreatenedAsVariable;
						y.IsThreatenedAsVariable = true;
						//cexp_t = cexp_t.Simplify();
						//ComplexConversionMap.Convert(ref cexp_t,"simple");
						try
						{
							IComplexExpression cexp_td = cexp.Differentiate(y);
							y.IsThreatenedAsVariable = virt;
							cexp_td = cexp_td.Simplify();
							ComplexConversionMap.Convert(ref cexp_td, "simple");
							output.Append("diff x:\t"+cexp_td.ToString()+"\r\n");
							y.IsThreatenedAsVariable = true;
						}
						catch(ExpressionNotDeriveableException ee) {}
						try
						{
							IComplexExpression cexp_ti = cexp.Integrate(y);
							y.IsThreatenedAsVariable = virt;
							cexp_ti = cexp_ti.Simplify();
							ComplexConversionMap.Convert(ref cexp_ti, "simple");
							output.Append("int x:\t"+cexp_ti.ToString()+"\r\n");
							y.IsThreatenedAsVariable = true;
						}
						catch(ExpressionNotIntegratableException ee) {}
						y.IsThreatenedAsVariable = virt;
					}
					if(cexp.IsConstant)
					{
						ValueComplex cl = cexp.Calculate();
						output.Append("Calc:\t"+cl.ToString()+"\r\n");
					}
					return(output.ToString());
				}
				IComplexVectorExpression vcexp = exp as IComplexVectorExpression;
				if(vcexp != null)
				{
					output.Append("Vector:\t"+vcexp.ToString()+"\r\n");
					vcexp = vcexp.Simplify();
					ComplexVectorConversionMap.Convert(ref vcexp,"simple");
					output.Append("Simple:\t"+vcexp.ToString()+"\r\n");
					output.Append("Expand:\t"+vcexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(vcexp.IsConstant)
					{
						ValueComplexVector vcv = vcexp.Calculate();
						output.Append("Calc:\t"+vcv.ToString()+"\r\n");
					}
					return(output.ToString());
				}
				IComplexMatrixExpression mcexp = exp as IComplexMatrixExpression;
				if(mcexp != null)
				{
					output.Append("Matrix:\t"+mcexp.ToString()+"\r\n");
					mcexp = mcexp.Simplify();
					ComplexMatrixConversionMap.Convert(ref mcexp,"simple");
					output.Append("Simple:\t"+mcexp.ToString()+"\r\n");
					output.Append("Expand:\t"+mcexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(mcexp.IsConstant)
					{
						ValueComplexMatrix vcm = mcexp.Calculate();
						output.Append("Calc:\t"+vcm.ToString()+"\r\n");
					}
					return(output.ToString());
				}
				IBitExpression bexp = exp as IBitExpression;
				if(bexp != null)
				{
					output.Append("Bit:\t"+bexp.ToString()+"\r\n");
					bexp = bexp.Simplify();
					BitConversionMap.Convert(ref bexp,"simple");
					output.Append("Simple:\t"+bexp.ToString()+"\r\n");
					output.Append("Expand:\t"+bexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(bexp.IsConstant)
					{
						output.Append("Calc:\t"+bexp.Calculate()+"\r\n");
					}
					return(output.ToString());
				}
				IBusExpression bbexp = exp as IBusExpression;
				if(bbexp != null)
				{
					output.Append("Bus:\t"+bbexp.ToString()+"\r\n");
					bbexp = bbexp.Simplify();
					BusConversionMap.Convert(ref bbexp,"simple");
					output.Append("Simple:\t"+bbexp.ToString()+"\r\n");	
					output.Append("Expand:\t"+bbexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(bbexp.IsConstant)
					{
						BitArray vml = bbexp.Calculate();
						output.Append("Calc:\t");
						for(int i=0;i<vml.Count;i++)
						{
							if(vml[i])
								output.Append('1');
							else
								output.Append('0');
						}
						output.Append("\r\n");
					}
					return(output.ToString());
				}
				IStateMachineExpression smexp = exp as IStateMachineExpression;
				if(smexp != null)
				{
					output.Append("State:\t"+smexp.ToString()+"\r\n");
					IBusExpression outbus = smexp.OutputBus;
					IBusExpression statebus = smexp.InternalState;
					output.Append("Output:\t"+outbus.ToString()+"\r\n");
					outbus = outbus.Simplify();
					BusConversionMap.Convert(ref outbus,"simple");
					output.Append("Simple:\t"+outbus.ToString()+"\r\n");
					output.Append("State:\t"+statebus.ToString()+"\r\n");
					statebus = statebus.Simplify();
					BusConversionMap.Convert(ref statebus,"simple");
					output.Append("Simple:\t"+statebus.ToString()+"\r\n");
					return(output.ToString());
				}
				IProcExpression pexp = exp as IProcExpression;
				if(pexp != null)
				{
					output.Append("Proc:\t"+pexp.ToString()+"\r\n");
					output.Append("Result:\t"+pexp.Execute()+"\r\n");
					return(output.ToString());
				}
				ILiteralExpression liexp = exp as ILiteralExpression;
				if(liexp != null)
				{
					output.Append("String:\t"+liexp.ToString()+"\r\n");
					liexp = liexp.Simplify();
					LiteralConversionMap.Convert(ref liexp,"simple");
					output.Append("Simple:\t"+liexp.ToString()+"\r\n");
					output.Append("Expand:\t"+liexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(liexp.IsConstant)
						output.Append("Calc:\t"+liexp.Calculate()+"\r\n");
					return(output.ToString());
				}
				ITimeExpression timeexp = exp as ITimeExpression;
				if(timeexp != null)
				{
					output.Append("Time:\t"+timeexp.ToString()+"\r\n");
					timeexp = timeexp.Simplify();
					TimeConversionMap.Convert(ref timeexp, "simple");
					output.Append("Simple:\t"+timeexp.ToString()+"\r\n");
					output.Append("Expand:\t"+timeexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(timeexp.IsConstant)
						output.Append("Calc:\t"+timeexp.Calculate()+"\r\n");
					return(output.ToString());
				}
				ITimeSpanExpression spanexp = exp as ITimeSpanExpression;
				if(spanexp != null)
				{
					output.Append("Span:\t"+spanexp.ToString()+"\r\n");
					spanexp = spanexp.Simplify();
					TimeSpanConversionMap.Convert(ref spanexp,"simple");
					output.Append("Simple:\t"+spanexp.ToString()+"\r\n");
					output.Append("Expand:\t"+spanexp.SafeExpand().Simplify().ToString()+"\r\n");
					if(spanexp.IsConstant)
						output.Append("Calc:\t"+spanexp.Calculate()+"\r\n");
					return(output.ToString());
				}
				return AutoFormat(exp);
			}
			catch(Exception e)
			{
				output.Append(e.ToString()+"\r\n");
			}
			return(output.ToString());
		}
		public string AutoFormat(IExpression exp)
		{
			Context context = exp.Context;
			StringBuilder output = new StringBuilder();
			output.Append("Auto:\t"+exp.ToString()+"\r\n");
			IExpression sexp = exp.ExpressionSimplify();
			ConversionMap.Convert(ref sexp,"simple");
			output.Append("Simple:\t"+sexp.ToString()+"\r\n");
			sexp = exp.ExpressionSafeExpand().ExpressionSimplify();
			output.Append("Expand:\t"+sexp.ToString()+"\r\n");
			return output.ToString();
		}
	}
}
