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
	public class VectorExpressionVariable: Variable, IVectorExpression
	{
		protected Vector1Parameters parameters;
		public VectorExpressionVariable(Context context, string name, IVectorExpression init): base(context,name)
		{
			parameters = new Vector1Parameters(init);
			Init(parameters);
		}
		public IVectorExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IVectorExpression val = value.Simplify();
				VectorConversionMap.Convert(ref val, "simple");
				parameters.Vector1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Vector1;}
		}
		public ValueVector Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Vector1.Calculate();
		}
		public IVectorExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Vector1.Simplify();
		}
		public ScalarVector Expand()
		{
			if(symbolicMode)
				throw new ExpressionNotExpandableException();
			else
				return parameters.Vector1.Expand();
		}
		public IVectorExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IVectorExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IVectorExpression) base.ExpressionSubstitute(original,replacement);
		}
		public int Length
		{
			get {return parameters.Vector1.Length;}
		}
		public IMatrixExpression ToMatrix()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			else
				return parameters.Vector1.ToMatrix();
		}
	}

	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetVectorExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Vector1Parameters parameters;
		public SetVectorExpressionVariable(Context context, IVectorExpression name,IVectorExpression val): base(context)
		{
			this.parameters = new Vector1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetVectorExpressionVariable(Context context, IScalarExpression name,IVectorExpression val): base(context)
		{
			this.parameters = new Vector1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			VectorExpressionVariable v1 = name as VectorExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Vector1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new VectorExpressionVariable(context,v2.VariableName,parameters.Vector1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Vector1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Vector1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteVectorExpressionVariable: StdProcedure, IProcExpression
	{
		protected Vector1Parameters parameters;
		public DeleteVectorExpressionVariable(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteVectorExpressionVariable(Context context, IVectorExpression val): base(context)
		{
			this.parameters = new Vector1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Vector1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockVectorExpressionVariable: StdProcedure, IProcExpression
	{
		protected Vector1Parameters parameters;
		public LockVectorExpressionVariable(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockVectorExpressionVariable(Context context, IVectorExpression val): base(context)
		{
			this.parameters = new Vector1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Vector1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockVectorExpressionVariable: StdProcedure, IProcExpression
	{
		protected Vector1Parameters parameters;
		public UnlockVectorExpressionVariable(Context context, Vector1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockVectorExpressionVariable(Context context, IVectorExpression val): base(context)
		{
			this.parameters = new Vector1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Vector1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
