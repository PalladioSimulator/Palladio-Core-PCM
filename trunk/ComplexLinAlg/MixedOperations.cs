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
using System.Text;
using cdrnet.Lib.MathLib.Core;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Complex.Trigonometry;
using cdrnet.Lib.MathLib.Exceptions;

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	#region MatrixVector Operators
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexMatrixComplexVectorMultiplication: ComplexVectorOperator
	{
		protected ComplexVector1ComplexMatrix1Parameters parameters;
		public ComplexVector1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixComplexVectorMultiplication(Context context, ComplexVector1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters; Init(parameters);
		}
		public ComplexMatrixComplexVectorMultiplication(Context context, IComplexMatrixExpression matrix, IComplexVectorExpression vector): base(context)
		{
			this.parameters = new ComplexVector1ComplexMatrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexMatrix m = parameters.ComplexMatrix1.Expand();
			ComplexVector v = parameters.ComplexVector1.Expand();
			IComplexExpression[] se = new IComplexExpression[v.Length];
			for(int y=0;y<m.LengthY;y++)
				se[y] = new ComplexVectorComplexVectorDotMultiplication(context,m.GetRowVector(y),v);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
		public override string ToString()
		{
			return "("+parameters.ComplexMatrix1.ToString()+"*"+parameters.ComplexVector1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,50,Character="*")]
	public class ComplexVectorComplexMatrixMultiplication: ComplexVectorOperator
	{
		protected ComplexVector1ComplexMatrix1Parameters parameters;
		public ComplexVector1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexVectorComplexMatrixMultiplication(Context context, ComplexVector1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorComplexMatrixMultiplication(Context context, IComplexVectorExpression vector, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new ComplexVector1ComplexMatrix1Parameters(vector,matrix);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexMatrix m = parameters.ComplexMatrix1.Expand();
			ComplexVector v = parameters.ComplexVector1.Expand();
			IComplexExpression[] se = new IComplexExpression[v.Length];
			for(int y=0;y<m.LengthY;y++)
				se[y] = new ComplexVectorComplexVectorDotMultiplication(context,m.GetColumnVector(y),v);
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	#endregion
}