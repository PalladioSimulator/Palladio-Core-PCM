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
	public class ComplexVectorExpressionVariable: Variable, IComplexVectorExpression
	{
		protected ComplexVector1Parameters parameters;
		public ComplexVectorExpressionVariable(Context context, string name, IComplexVectorExpression init): base(context,name)
		{
			parameters = new ComplexVector1Parameters(init);
			Init(parameters);
		}
		public IComplexVectorExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IComplexVectorExpression val = value.Simplify();
				ComplexVectorConversionMap.Convert(ref val, "simple");
				parameters.ComplexVector1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.ComplexVector1;}
		}
		public ValueComplexVector Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.ComplexVector1.Calculate();
		}
		public IComplexVectorExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.ComplexVector1.Simplify();
		}
		public ComplexVector Expand()
		{
			if(symbolicMode)
				throw new ExpressionNotExpandableException();
			else
				return parameters.ComplexVector1.Expand();
		}
		public IComplexVectorExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IComplexVectorExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IComplexVectorExpression) base.ExpressionSubstitute(original,replacement);
		}
		public int Length
		{
			get {return parameters.ComplexVector1.Length;}
		}
		public IComplexMatrixExpression ToMatrix()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			else
				return parameters.ComplexVector1.ToMatrix();
		}
	}

	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetComplexVectorExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected ComplexVector1Parameters parameters;
		public SetComplexVectorExpressionVariable(Context context, IComplexExpression name,IComplexVectorExpression val): base(context)
		{
			this.parameters = new ComplexVector1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetComplexVectorExpressionVariable(Context context, IScalarExpression name,IComplexVectorExpression val): base(context)
		{
			this.parameters = new ComplexVector1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			ComplexVectorExpressionVariable v1 = name as ComplexVectorExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.ComplexVector1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new ComplexVectorExpressionVariable(context,v2.VariableName,parameters.ComplexVector1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.ComplexVector1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.ComplexVector1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteComplexVectorExpressionVariable: StdProcedure, IProcExpression
	{
		protected ComplexVector1Parameters parameters;
		public DeleteComplexVectorExpressionVariable(Context context, ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteComplexVectorExpressionVariable(Context context, IComplexVectorExpression val): base(context)
		{
			this.parameters = new ComplexVector1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.ComplexVector1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockComplexVectorExpressionVariable: StdProcedure, IProcExpression
	{
		protected ComplexVector1Parameters parameters;
		public LockComplexVectorExpressionVariable(Context context, ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockComplexVectorExpressionVariable(Context context, IComplexVectorExpression val): base(context)
		{
			this.parameters = new ComplexVector1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.ComplexVector1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockComplexVectorExpressionVariable: StdProcedure, IProcExpression
	{
		protected ComplexVector1Parameters parameters;
		public UnlockComplexVectorExpressionVariable(Context context, ComplexVector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockComplexVectorExpressionVariable(Context context, IComplexVectorExpression val): base(context)
		{
			this.parameters = new ComplexVector1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.ComplexVector1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
