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

namespace cdrnet.Lib.MathLib.Tools
{
	public class ExpressionConverter
	{
		public static IExpression Convert(IExpression exp, string type)
		{
			IScalarExpression sexp = exp as IScalarExpression;
			if(sexp != null)
			{
				ScalarConversionMap.Convert(ref sexp,type);
				return sexp;
			}
			ITripleExpression texp = exp as ITripleExpression;
			if(texp != null)
			{
				TripleConversionMap.Convert(ref texp,type);
				return texp;
			}
			IVectorExpression vexp = exp as IVectorExpression;
			if(vexp != null)
			{
				VectorConversionMap.Convert(ref vexp,type);
				return vexp;
			}
			IMatrixExpression mexp = exp as IMatrixExpression;
			if(mexp != null)
			{
				MatrixConversionMap.Convert(ref mexp,type);
				return mexp;
			}
//			ITensorExpression teexp = exp as ITensorExpression;
//			if(teexp != null)
//			{
//				TensorConversionMap.Convert(ref teexp,type);
//				return teexp;
//			}
			IListExpression lexp = exp as IListExpression;
			if(lexp != null)
			{
				lexp = lexp.Simplify();
				return lexp;
			}
			IMatrixListExpression lmexp = exp as IMatrixListExpression;
			if(lmexp != null)
			{
				lmexp = lmexp.Simplify();
				return lmexp;
			}
			IComplexExpression cexp = exp as IComplexExpression;
			if(cexp != null)
			{
				ComplexConversionMap.Convert(ref cexp,type);
				return cexp;
			}
			IComplexVectorExpression vcexp = exp as IComplexVectorExpression;
			if(vcexp != null)
			{
				ComplexVectorConversionMap.Convert(ref vcexp,type);
				return vcexp;
			}
			IComplexMatrixExpression mcexp = exp as IComplexMatrixExpression;
			if(mcexp != null)
			{
				ComplexMatrixConversionMap.Convert(ref mcexp,type);
				return mcexp;
			}
			IBitExpression bexp = exp as IBitExpression;
			if(bexp != null)
			{
				BitConversionMap.Convert(ref bexp,type);
				return bexp;
			}
			IBusExpression bbexp = exp as IBusExpression;
			if(bbexp != null)
			{
				BusConversionMap.Convert(ref bbexp,type);
				return bbexp;
			}
			IStateMachineExpression smexp = exp as IStateMachineExpression;
			if(smexp != null)
			{
				return smexp;
			}
			IProcExpression pexp = exp as IProcExpression;
			if(pexp != null)
			{
				return pexp;
			}
			ILiteralExpression liexp = exp as ILiteralExpression;
			if(liexp != null)
			{
				LiteralConversionMap.Convert(ref liexp,type);
				return liexp;
			}
			return exp;
		}
	}
}
