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

namespace cdrnet.Lib.MathLib.Time
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class TimeExpressionVariable: Variable, ITimeExpression
	{
		protected Time1Parameters parameters;
		public TimeExpressionVariable(Context context, string name, ITimeExpression init): base(context,name)
		{
			parameters = new Time1Parameters(init);
			Init(parameters);
		}
		public ITimeExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				ITimeExpression val = value.Simplify();
				TimeConversionMap.Convert(ref val, "simple");
				parameters.Time1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Time1;}
		}
		public DateTime Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Time1.Calculate();
		}
		public ITimeExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Time1.Simplify();
		}
		public ITimeExpression Expand()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Time1.Expand();
		}
		public ITimeExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public ITimeExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITimeExpression) base.ExpressionSubstitute(original,replacement);
		}
	}
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class TimeSpanExpressionVariable: Variable, ITimeSpanExpression
	{
		protected TimeSpan1Parameters parameters;
		public TimeSpanExpressionVariable(Context context, string name, ITimeSpanExpression init): base(context,name)
		{
			parameters = new TimeSpan1Parameters(init);
			Init(parameters);
		}
		public ITimeSpanExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				ITimeSpanExpression val = value.Simplify();
				TimeSpanConversionMap.Convert(ref val, "simple");
				parameters.TimeSpan1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.TimeSpan1;}
		}
		public TimeSpan Calculate()
		{
			return parameters.TimeSpan1.Calculate();
		}
		public ITimeSpanExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.TimeSpan1.Simplify();
		}
		public ITimeSpanExpression Expand()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.TimeSpan1.Expand();
		}
		public ITimeSpanExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public ITimeSpanExpression Substitute(IExpression original, IExpression replacement)
		{
			return (ITimeSpanExpression) base.ExpressionSubstitute(original,replacement);
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetTimeExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Time1Parameters parameters;
		public SetTimeExpressionVariable(Context context, ITimeExpression name,ITimeExpression val): base(context)
		{
			this.parameters = new Time1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetTimeExpressionVariable(Context context, IScalarExpression name,ITimeExpression val): base(context)
		{
			this.parameters = new Time1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			TimeExpressionVariable v1 = name as TimeExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Time1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new TimeExpressionVariable(context,v2.VariableName,parameters.Time1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Time1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Time1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetTimeSpanExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected TimeSpan1Parameters parameters;
		public SetTimeSpanExpressionVariable(Context context, ITimeSpanExpression name,ITimeSpanExpression val): base(context)
		{
			this.parameters = new TimeSpan1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetTimeSpanExpressionVariable(Context context, IScalarExpression name,ITimeSpanExpression val): base(context)
		{
			this.parameters = new TimeSpan1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			TimeSpanExpressionVariable v1 = name as TimeSpanExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.TimeSpan1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new TimeSpanExpressionVariable(context,v2.VariableName,parameters.TimeSpan1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.TimeSpan1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.TimeSpan1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteTimeExpressionVariable: StdProcedure, IProcExpression
	{
		protected Time1Parameters parameters;
		public DeleteTimeExpressionVariable(Context context, Time1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteTimeExpressionVariable(Context context, ITimeExpression val): base(context)
		{
			this.parameters = new Time1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Time1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteTimeSpanExpressionVariable: StdProcedure, IProcExpression
	{
		protected TimeSpan1Parameters parameters;
		public DeleteTimeSpanExpressionVariable(Context context, TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteTimeSpanExpressionVariable(Context context, ITimeSpanExpression val): base(context)
		{
			this.parameters = new TimeSpan1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.TimeSpan1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockTimeExpressionVariable: StdProcedure, IProcExpression
	{
		protected Time1Parameters parameters;
		public LockTimeExpressionVariable(Context context, Time1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockTimeExpressionVariable(Context context, ITimeExpression val): base(context)
		{
			this.parameters = new Time1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Time1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockTimeSpanExpressionVariable: StdProcedure, IProcExpression
	{
		protected TimeSpan1Parameters parameters;
		public LockTimeSpanExpressionVariable(Context context, TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockTimeSpanExpressionVariable(Context context, ITimeSpanExpression val): base(context)
		{
			this.parameters = new TimeSpan1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.TimeSpan1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockTimeExpressionVariable: StdProcedure, IProcExpression
	{
		protected Time1Parameters parameters;
		public UnlockTimeExpressionVariable(Context context, Time1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockTimeExpressionVariable(Context context, ITimeExpression val): base(context)
		{
			this.parameters = new Time1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Time1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockTimeSpanExpressionVariable: StdProcedure, IProcExpression
	{
		protected TimeSpan1Parameters parameters;
		public UnlockTimeSpanExpressionVariable(Context context, TimeSpan1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockTimeSpanExpressionVariable(Context context, ITimeSpanExpression val): base(context)
		{
			this.parameters = new TimeSpan1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.TimeSpan1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
