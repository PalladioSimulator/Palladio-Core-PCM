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
using cdrnet.Lib.MathLib.Scalar;
using cdrnet.Lib.MathLib.Complex;
using cdrnet.Lib.MathLib.Complex.LinearAlgebra;
using cdrnet.Lib.MathLib.Scalar.Geometry;

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class VectorMap: VectorOperator
	{
		protected Scalar2Vector1Parameters parameters;
		public Scalar2Vector1Parameters Parameters {get {return parameters;}}
		public VectorMap(Context context, Scalar2Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorMap(Context context, IScalarExpression lambda, IScalarExpression var, IVectorExpression vector): base(context)
		{
			this.parameters = new Scalar2Vector1Parameters(lambda,var,vector);
			Init(parameters);
		}
		public VectorMap(Context context, IScalarExpression lambda, IScalarExpression var, ITripleExpression vector): base(context)
		{
			this.parameters = new Scalar2Vector1Parameters(lambda,var,new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}));
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ScalarVector ve = parameters.Vector1.Expand();
			ScalarExpressionVariable var = parameters.Scalar2 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ve.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new vector
			IScalarExpression[] se = new IScalarExpression[ve.Length];
			for(int i=0;i<se.Length;i++)
			{
				var.Value = ve[i];
				se[i] = parameters.Scalar1.Simplify();
			}
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return parameters.Vector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class MatrixMap: MatrixOperator
	{
		protected Scalar2Matrix1Parameters parameters;
		public Scalar2Matrix1Parameters Parameters {get {return parameters;}}
		public MatrixMap(Context context, Scalar2Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public MatrixMap(Context context, IScalarExpression lambda, IScalarExpression var, IMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar2Matrix1Parameters(lambda,var,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ScalarMatrix ma = parameters.Matrix1.Expand();
			ScalarExpressionVariable var = parameters.Scalar2 as ScalarExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ma.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new matrix
			IScalarExpression[,] se = new IScalarExpression[ma.LengthX,ma.LengthY];
			for(int x=0;x<ma.LengthX;x++)
				for(int y=0;y<ma.LengthY;y++)
				{
					var.Value = ma[x,y];
					se[x,y] = parameters.Scalar1.Simplify();
				}
			return new ScalarMatrix(context,se);
		}
		public override int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public override int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class ComplexToScalarVectorMap: VectorOperator
	{
		protected Scalar1Complex1ComplexVector1Parameters parameters;
		public Scalar1Complex1ComplexVector1Parameters Parameters {get {return parameters;}}
		public ComplexToScalarVectorMap(Context context, Scalar1Complex1ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexToScalarVectorMap(Context context, IScalarExpression lambda, IComplexExpression var, IComplexVectorExpression vector): base(context)
		{
			this.parameters = new Scalar1Complex1ComplexVector1Parameters(lambda,var,vector);
			Init(parameters);
		}
		public override ScalarVector Expand()
		{
			ComplexVector ve = parameters.ComplexVector1.Expand();
			ComplexExpressionVariable var = parameters.Complex1 as ComplexExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ve.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new vector
			IScalarExpression[] se = new IScalarExpression[ve.Length];
			for(int i=0;i<se.Length;i++)
			{
				var.Value = ve[i];
				se[i] = parameters.Scalar1.Simplify();
			}
			return new ScalarVector(context,se);
		}
		public override int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="map")]
	public class ComplexToScalarMatrixMap: MatrixOperator
	{
		protected Scalar1Complex1ComplexMatrix1Parameters parameters;
		public Scalar1Complex1ComplexMatrix1Parameters Parameters {get {return parameters;}}
		public ComplexToScalarMatrixMap(Context context, Scalar1Complex1ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public ComplexToScalarMatrixMap(Context context, IScalarExpression lambda, IComplexExpression var, IComplexMatrixExpression matrix): base(context)
		{
			this.parameters = new Scalar1Complex1ComplexMatrix1Parameters(lambda,var,matrix);
			Init(parameters);
		}
		public override ScalarMatrix Expand()
		{
			ComplexMatrix ma = parameters.ComplexMatrix1.Expand();
			ComplexExpressionVariable var = parameters.Complex1 as ComplexExpressionVariable;
			if(var == null)
				throw new ExpressionVariableRequiredException();
			var.IsThreatenedAsVariable = false;
			//check whether recursive
			VariableManager m = new VariableManager(context);
			ma.CollectVariables(m,true);
			if(m.IsDefined(var.VariableName))
				throw new ExpressionInfiniteRecursiveException();
			//build new matrix
			IScalarExpression[,] se = new IScalarExpression[ma.LengthX,ma.LengthY];
			for(int x=0;x<ma.LengthX;x++)
				for(int y=0;y<ma.LengthY;y++)
				{
					var.Value = ma[x,y];
					se[x,y] = parameters.Scalar1.Simplify();
				}
			return new ScalarMatrix(context,se);
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
	[ParsingObject(ParsingObjectType.Function,250,Character="reduce")]
	public class VectorReduce: ScalarOperator
	{
		protected Scalar3Vector1Parameters parameters;
		public Scalar3Vector1Parameters Parameters {get {return parameters;}}
		public VectorReduce(Context context, Scalar3Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public VectorReduce(Context context, IScalarExpression lambda, IScalarExpression var1, IScalarExpression var2, IVectorExpression vector): base(context)
		{
			this.parameters = new Scalar3Vector1Parameters(lambda,var1,var2,vector);
			Init(parameters);
		}
		public VectorReduce(Context context, IScalarExpression lambda, IScalarExpression var1, IScalarExpression var2, ITripleExpression vector): base(context)
		{
			this.parameters = new Scalar3Vector1Parameters(lambda,var1,var2,new ScalarVector(context,new IScalarExpression[]{vector.ExpandX(),vector.ExpandY(),vector.ExpandZ()}));
			Init(parameters);
		} 
		public override IScalarExpression Expand()
		{
			ScalarVector ve = parameters.Vector1.Expand();
			ScalarExpressionVariable var1 = parameters.Scalar2 as ScalarExpressionVariable;
			ScalarExpressionVariable var2 = parameters.Scalar3 as ScalarExpressionVariable;
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
			IScalarExpression v = ve[ve.Length-1];
			for(int i=ve.Length-2;i>=0;i--)
			{
				var2.Value = v;
				var1.Value = ve[i];
				v = parameters.Scalar1.Simplify();
			}
			return v;
		}
	}
}
