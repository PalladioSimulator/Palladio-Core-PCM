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

namespace cdrnet.Lib.MathLib.Complex
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class ComplexExpressionVariable: Variable, IComplexExpression
	{
		protected Complex1Parameters parameters;
		public ComplexExpressionVariable(Context context, string name, IComplexExpression init): base(context,name)
		{
			parameters = new Complex1Parameters(init);
			Init(parameters);
		}
		public IComplexExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IComplexExpression val = value.Simplify();
				ComplexConversionMap.Convert(ref val, "simple");
				parameters.Complex1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Complex1;}
		}
		public ValueComplex Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Complex1.Calculate();
		}
		public IComplexExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Complex1.Simplify();
		}
		public IScalarExpression ExpandReal()
		{
			if(symbolicMode)
				return new ComplexReal(context,this);
			return parameters.Complex1.ExpandReal();
		}
		public IScalarExpression ExpandImag()
		{
			if(symbolicMode)
				return new ComplexImag(context,this);
			return parameters.Complex1.ExpandImag();
		}
		public ScalarComplex Expand()
		{
			return new ScalarComplex(context,ExpandReal(),ExpandImag());
		}
		public IComplexExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IComplexExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IComplexExpression) base.ExpressionSubstitute(original,replacement);
		}
		public IComplexExpression Differentiate(ComplexExpressionVariable var)
		{
			if(var.VariableName == this.VariableName)
				return ScalarComplex.One(context);
			if(symbolicMode)
				return ScalarComplex.Zero(context);
			return parameters.Complex1.Differentiate(var);
		}
		public IComplexExpression Integrate(ComplexExpressionVariable var)
		{
			if(var.VariableName == this.VariableName)
				return new ComplexDivision(context,new ComplexRaiseToPower(context,var,ScalarComplex.Two(context)),ScalarComplex.Two(context));
			if(symbolicMode)
				return new ComplexMultiplication(context,this,var);
			return parameters.Complex1.Integrate(var);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetComplexExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Complex1Parameters parameters;
		public SetComplexExpressionVariable(Context context, IComplexExpression name,IComplexExpression val): base(context)
		{
			this.parameters = new Complex1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetComplexExpressionVariable(Context context, IScalarExpression name,IComplexExpression val): base(context)
		{
			this.parameters = new Complex1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			ComplexExpressionVariable v1 = name as ComplexExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Complex1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new ComplexExpressionVariable(context,v2.VariableName,parameters.Complex1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Complex1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Complex1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteComplexExpressionVariable: StdProcedure, IProcExpression
	{
		protected Complex1Parameters parameters;
		public DeleteComplexExpressionVariable(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteComplexExpressionVariable(Context context, IComplexExpression val): base(context)
		{
			this.parameters = new Complex1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Complex1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockComplexExpressionVariable: StdProcedure, IProcExpression
	{
		protected Complex1Parameters parameters;
		public LockComplexExpressionVariable(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockComplexExpressionVariable(Context context, IComplexExpression val): base(context)
		{
			this.parameters = new Complex1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Complex1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockComplexExpressionVariable: StdProcedure, IProcExpression
	{
		protected Complex1Parameters parameters;
		public UnlockComplexExpressionVariable(Context context, Complex1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockComplexExpressionVariable(Context context, IComplexExpression val): base(context)
		{
			this.parameters = new Complex1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Complex1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
