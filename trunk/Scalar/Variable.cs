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
using cdrnet.Lib.MathLib.Complex;

namespace cdrnet.Lib.MathLib.Scalar
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class ScalarExpressionVariable: Variable, IScalarExpression
	{
		protected Scalar1Parameters parameters;
		public ScalarExpressionVariable(Context context, string name, IScalarExpression init): base(context,name)
		{
			parameters = new Scalar1Parameters(init);
			Init(parameters);
		}
		public IScalarExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IScalarExpression val = value.Simplify();
				ScalarConversionMap.Convert(ref val, "simple");
				parameters.Scalar1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Scalar1;}
		}
		public double Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Scalar1.Calculate();
		}
		public IScalarExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Scalar1.Simplify();
		}
		public IScalarExpression Expand()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Scalar1.Expand();
		}
		public IScalarExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IScalarExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IScalarExpression) base.ExpressionSubstitute(original,replacement);
		}
		public IScalarExpression Differentiate(ScalarExpressionVariable var)
		{
			if(var.VariableName == this.VariableName)
				return ScalarExpressionValue.One(context);
			if(symbolicMode)
				return ScalarExpressionValue.Zero(context);
			return parameters.Scalar1.Differentiate(var);
		}
		public IScalarExpression Integrate(ScalarExpressionVariable var)
		{
			if(var.VariableName == this.VariableName)
				return new ScalarDivision(context,new ScalarSquare(context,var),ScalarExpressionValue.Two(context));
			if(symbolicMode)
				return new ScalarMultiplication(context,this,var);
			return parameters.Scalar1.Integrate(var);
		}
		public IComplexExpression ToComplex()
		{
			return new ScalarComplex(context,this,ScalarExpressionValue.Zero(context));
		}
	}

	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetScalarExpressionVariable: StdProcedure, IProcExpression
	{
		private IScalarExpression name;
		protected Scalar1Parameters parameters;
		public SetScalarExpressionVariable(Context context, IScalarExpression name,IScalarExpression val): base(context)
		{
			this.parameters = new Scalar1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			ScalarExpressionVariable v = name as ScalarExpressionVariable;
			if(v != null)
			{
				v.Value = parameters.Scalar1;
				context.ContextVariables.AddVariable(v);
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Scalar1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Scalar1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteScalarExpressionVariable: StdProcedure, IProcExpression
	{
		protected Scalar1Parameters parameters;
		public DeleteScalarExpressionVariable(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteScalarExpressionVariable(Context context, IScalarExpression val): base(context)
		{
			this.parameters = new Scalar1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Scalar1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockScalarExpressionVariable: StdProcedure, IProcExpression
	{
		protected Scalar1Parameters parameters;
		public LockScalarExpressionVariable(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockScalarExpressionVariable(Context context, IScalarExpression val): base(context)
		{
			this.parameters = new Scalar1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Scalar1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockScalarExpressionVariable: StdProcedure, IProcExpression
	{
		protected Scalar1Parameters parameters;
		public UnlockScalarExpressionVariable(Context context, Scalar1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockScalarExpressionVariable(Context context, IScalarExpression val): base(context)
		{
			this.parameters = new Scalar1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Scalar1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
