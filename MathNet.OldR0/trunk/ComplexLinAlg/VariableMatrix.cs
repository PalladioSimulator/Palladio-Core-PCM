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
using cdrnet.Lib.MathLib.Exceptions;
using cdrnet.Lib.MathLib.Scalar;

namespace cdrnet.Lib.MathLib.Complex.LinearAlgebra
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class ComplexMatrixExpressionVariable: Variable, IComplexMatrixExpression
	{
		protected ComplexMatrix1Parameters parameters;
		public ComplexMatrixExpressionVariable(Context context, string name, IComplexMatrixExpression init): base(context,name)
		{
			parameters = new ComplexMatrix1Parameters(init);
			Init(parameters);
		}
		public IComplexMatrixExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IComplexMatrixExpression val = value.Simplify();
				ComplexMatrixConversionMap.Convert(ref val, "simple");
				parameters.ComplexMatrix1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.ComplexMatrix1;}
		}
		public ValueComplexMatrix Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.ComplexMatrix1.Calculate();
		}
		public IComplexMatrixExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.ComplexMatrix1.Simplify();
		}
		public ComplexMatrix Expand()
		{
			if(symbolicMode)
				throw new ExpressionNotExpandableException();
			else
				return parameters.ComplexMatrix1.Expand();
		}
		public IComplexMatrixExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IComplexMatrixExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IComplexMatrixExpression) base.ExpressionSubstitute(original,replacement);
		}
		public int LengthX
		{
			get {return parameters.ComplexMatrix1.LengthX;}
		}
		public int LengthY
		{
			get {return parameters.ComplexMatrix1.LengthY;}
		}
		public IComplexVectorExpression GetRowVector(int y)
		{
			return parameters.ComplexMatrix1.GetRowVector(y);
		}
		public IComplexVectorExpression GetColumnVector(int x)
		{
			return parameters.ComplexMatrix1.GetColumnVector(x);
		}
	}

	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetComplexMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected ComplexMatrix1Parameters parameters;
		public SetComplexMatrixExpressionVariable(Context context, IComplexExpression name,IComplexMatrixExpression val): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetComplexMatrixExpressionVariable(Context context, IScalarExpression name,IComplexMatrixExpression val): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			ComplexMatrixExpressionVariable v1 = name as ComplexMatrixExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.ComplexMatrix1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new ComplexMatrixExpressionVariable(context,v2.VariableName,parameters.ComplexMatrix1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.ComplexMatrix1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.ComplexMatrix1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteComplexMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		protected ComplexMatrix1Parameters parameters;
		public DeleteComplexMatrixExpressionVariable(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteComplexMatrixExpressionVariable(Context context, IComplexMatrixExpression val): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.ComplexMatrix1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockComplexMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		protected ComplexMatrix1Parameters parameters;
		public LockComplexMatrixExpressionVariable(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockComplexMatrixExpressionVariable(Context context, IComplexMatrixExpression val): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.ComplexMatrix1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockComplexMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		protected ComplexMatrix1Parameters parameters;
		public UnlockComplexMatrixExpressionVariable(Context context, ComplexMatrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockComplexMatrixExpressionVariable(Context context, IComplexMatrixExpression val): base(context)
		{
			this.parameters = new ComplexMatrix1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.ComplexMatrix1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
