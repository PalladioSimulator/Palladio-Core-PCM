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
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Scalar.LinearAlgebra;

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class ComplexVectorMap: ComplexVectorOperator
	{
		protected Complex2ComplexVector1Parameters parameters;
		public Complex2ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexVectorMap(Context context, Complex2ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorMap(Context context, IComplexExpression lambda, IComplexExpression var, IComplexVectorExpression vector) : base(context)
		{
			this.parameters = new Complex2ComplexVector1Parameters(lambda,var,vector);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ComplexVector ve = parameters.ComplexVector1.Expand();
			ComplexExpressionVariable var = parameters.Complex2 as ComplexExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ve.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new vector
			IComplexExpression[] se = new IComplexExpression[ve.Length];
			for(int i=0;i<se.Length;i++)
			{
				var.Value = ve[i];
				se[i] = parameters.Complex1.Simplify();
			}
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class ComplexMatrixMap: ComplexMatrixOperator
	{
		protected Complex2ComplexMatrix1Parameters parameters;
		public Complex2ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexMatrixMap(Context context, Complex2ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexMatrixMap(Context context, IComplexExpression lambda, IComplexExpression var, IComplexMatrixExpression matrix) : base(context)
		{
			this.parameters = new Complex2ComplexMatrix1Parameters(lambda,var,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ComplexMatrix ma = parameters.ComplexMatrix1.Expand();
			ComplexExpressionVariable var = parameters.Complex2 as ComplexExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ma.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new matrix
			IComplexExpression[,] se = new IComplexExpression[ma.LengthX,ma.LengthY];
			for(int x=0;x<ma.LengthX;x++)
				for(int y=0;y<ma.LengthY;y++)
				{
					var.Value = ma[x,y];
					se[x,y] = parameters.Complex1.Simplify();
				}
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class ScalarToComplexVectorMap: ComplexVectorOperator
	{
		protected Scalar1Complex1Vector1Parameters parameters;
		public Scalar1Complex1Vector1Parameters Parameters {get {return parameters;}}
		public ScalarToComplexVectorMap(Context context, Scalar1Complex1Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarToComplexVectorMap(Context context, IComplexExpression lambda, IScalarExpression var, IVectorExpression vector): base(context)
		{
			this.parameters = new Scalar1Complex1Vector1Parameters(var,lambda,vector);
			Init(parameters);
		}
		public override ComplexVector Expand()
		{
			ScalarVector ve = parameters.Vector1.Expand();
			ScalarExpressionVariable var = parameters.Scalar1 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ve.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new vector
			IComplexExpression[] se = new IComplexExpression[ve.Length];
			for(int i=0;i<se.Length;i++)
			{
				var.Value = ve[i];
				se[i] = parameters.Complex1.Simplify();
			}
			return new ComplexVector(context,se);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public override string ToString()
		{
			return "map("+parameters.Complex1.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Vector1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class ScalarToComplexMatrixMap: ComplexMatrixOperator
	{
		protected Scalar1Complex1Matrix1Parameters parameters;
		public Scalar1Complex1Matrix1Parameters Parameters {get {return parameters;}}
		public ScalarToComplexMatrixMap(Context context, Scalar1Complex1Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ScalarToComplexMatrixMap(Context context, IComplexExpression lambda, IScalarExpression var, IMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1Complex1Matrix1Parameters(var,lambda,matrix);
			Init(parameters);
		}
		public override ComplexMatrix Expand()
		{
			ScalarMatrix ma = parameters.Matrix1.Expand();
			ScalarExpressionVariable var = parameters.Scalar1 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ma.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new matrix
			IComplexExpression[,] se = new IComplexExpression[ma.LengthX,ma.LengthY];
			for(int x=0;x<ma.LengthX;x++)
				for(int y=0;y<ma.LengthY;y++)
				{
					var.Value = ma[x,y];
					se[x,y] = parameters.Complex1.Simplify();
				}
			return new ComplexMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1 .LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1 .LengthY;}
		}
		public override string ToString()
		{
			return "map("+parameters.Complex1.ToString()+","+parameters.Scalar1.ToString()+","+parameters.Matrix1.ToString()+")";
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="reduce")]
	public class ComplexVectorReduce: ComplexOperator
	{
		protected Complex3ComplexVector1Parameters parameters;
		public Complex3ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexVectorReduce(Context context, Complex3ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexVectorReduce(Context context, IComplexExpression lambda, IComplexExpression var1, IComplexExpression var2, IComplexVectorExpression vector): base(context)
		{
			this.parameters = new Complex3ComplexVector1Parameters(lambda,var1,var2,vector);
			Init(parameters);
		}
		public override ScalarComplex Expand()
		{
			ComplexVector ve = parameters.ComplexVector1.Expand();
			ComplexExpressionVariable var1 = parameters.Complex2 as ComplexExpressionVariable;
			ComplexExpressionVariable var2 = parameters.Complex3 as ComplexExpressionVariable;
			if(var1 == null || var2 == null)
				throw new ExpressionVariableRequiredException();
			var1.IsThreatenedAsVariable = false;
			var2.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ve.CollectVariables(m,true);
			if(m.IsDefined(var1.VariableName) || m.IsDefined(var2.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new vector
			IComplexExpression v = ve[ve.Length-1];
			for(int i=ve.Length-2;i>=0;i--)
			{
				var2.Value = v;
				var1.Value = ve[i];
				v = parameters.Complex1.Simplify();
			}
			return v.Expand();
		}
	}
}
