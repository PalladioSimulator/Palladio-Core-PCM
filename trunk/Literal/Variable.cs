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

namespace cdrnet.Lib.MathLib.Literal
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class LiteralExpressionVariable: Variable, ILiteralExpression
	{
		protected Literal1Parameters parameters;
		public LiteralExpressionVariable(Context context, string name, ILiteralExpression init): base(context,name)
		{
			parameters = new Literal1Parameters(init);
			Init(parameters);
		}
		public ILiteralExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				ILiteralExpression val = value.Simplify();
				LiteralConversionMap.Convert(ref val, "simple");
				parameters.Literal1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Literal1;}
		}
		public string Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Literal1.Calculate();
		}
		public ILiteralExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Literal1.Simplify();
		}
		public ILiteralExpression Expand()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Literal1.Expand();
		}
		public ILiteralExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public ILiteralExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ILiteralExpression) base.ExpressionSubstitute(original,replacement);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetLiteralExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Literal1Parameters parameters;
		public SetLiteralExpressionVariable(Context context, ILiteralExpression name,ILiteralExpression val): base(context)
		{
			this.parameters = new Literal1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetLiteralExpressionVariable(Context context, IScalarExpression name,ILiteralExpression val): base(context)
		{
			this.parameters = new Literal1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			LiteralExpressionVariable v1 = name as LiteralExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Literal1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new LiteralExpressionVariable(context,v2.VariableName,parameters.Literal1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Literal1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Literal1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteLiteralExpressionVariable: StdProcedure, IProcExpression
	{
		protected Literal1Parameters parameters;
		public DeleteLiteralExpressionVariable(Context context, Literal1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteLiteralExpressionVariable(Context context, ILiteralExpression val): base(context)
		{
			this.parameters = new Literal1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Literal1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockLiteralExpressionVariable: StdProcedure, IProcExpression
	{
		protected Literal1Parameters parameters;
		public LockLiteralExpressionVariable(Context context, Literal1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockLiteralExpressionVariable(Context context, ILiteralExpression val): base(context)
		{
			this.parameters = new Literal1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Literal1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockLiteralExpressionVariable: StdProcedure, IProcExpression
	{
		protected Literal1Parameters parameters;
		public UnlockLiteralExpressionVariable(Context context, Literal1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockLiteralExpressionVariable(Context context, ILiteralExpression val): base(context)
		{
			this.parameters = new Literal1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Literal1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
