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

namespace cdrnet.Lib.MathLib.Scalar.LinearAlgebra
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class MatrixExpressionVariable: Variable, IMatrixExpression
	{
		protected Matrix1Parameters parameters;
		public MatrixExpressionVariable(Context context, string name, IMatrixExpression init): base(context,name)
		{
			parameters = new Matrix1Parameters(init);
			Init(parameters);
		}
		public IMatrixExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IMatrixExpression val = value.Simplify();
				MatrixConversionMap.Convert(ref val, "simple");
				parameters.Matrix1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Matrix1;}
		}
		public ValueMatrix Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Matrix1.Calculate();
		}
		public IMatrixExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Matrix1.Simplify();
		}
		public ScalarMatrix Expand()
		{
			if(symbolicMode)
				throw new ExpressionNotExpandableException();
			else
				return parameters.Matrix1.Expand();
		}
		public IMatrixExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IMatrixExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IMatrixExpression) base.ExpressionSubstitute(original,replacement);
		}
		public int LengthX
		{
			get {return parameters.Matrix1.LengthX;}
		}
		public int LengthY
		{
			get {return parameters.Matrix1.LengthY;}
		}
		public IVectorExpression GetRowVector(int y)
		{
			return parameters.Matrix1.GetRowVector(y);
		}
		public IVectorExpression GetColumnVector(int x)
		{
			return parameters.Matrix1.GetColumnVector(x);
		}
	}

	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Matrix1Parameters parameters;
		public SetMatrixExpressionVariable(Context context, IMatrixExpression name,IMatrixExpression val): base(context)
		{
			this.parameters = new Matrix1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetMatrixExpressionVariable(Context context, IScalarExpression name,IMatrixExpression val): base(context)
		{
			this.parameters = new Matrix1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			MatrixExpressionVariable v1 = name as MatrixExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Matrix1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new MatrixExpressionVariable(context,v2.VariableName,parameters.Matrix1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Matrix1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Matrix1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		protected Matrix1Parameters parameters;
		public DeleteMatrixExpressionVariable(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteMatrixExpressionVariable(Context context, IMatrixExpression val): base(context)
		{
			this.parameters = new Matrix1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Matrix1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		protected Matrix1Parameters parameters;
		public LockMatrixExpressionVariable(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockMatrixExpressionVariable(Context context, IMatrixExpression val): base(context)
		{
			this.parameters = new Matrix1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Matrix1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockMatrixExpressionVariable: StdProcedure, IProcExpression
	{
		protected Matrix1Parameters parameters;
		public UnlockMatrixExpressionVariable(Context context, Matrix1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockMatrixExpressionVariable(Context context, IMatrixExpression val): base(context)
		{
			this.parameters = new Matrix1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Matrix1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
