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

namespace cdrnet.Lib.MathLib.Digital
{
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class BitExpressionVariable: Variable, IBitExpression
	{
		protected Bit1Parameters parameters;
		public BitExpressionVariable(Context context, string name, IBitExpression init): base(context,name)
		{
			parameters = new Bit1Parameters(init);
			Init(parameters);
		}
		public IBitExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IBitExpression val = value.Simplify();
				BitConversionMap.Convert(ref val, "simple");
				parameters.Bit1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Bit1;}
		}
		public bool Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Bit1.Calculate();
		}
		public IBitExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Bit1.Simplify();
		}
		public IBitExpression Expand()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Bit1.Expand();
		}
		public IBitExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IBitExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IBitExpression) base.ExpressionSubstitute(original,replacement);
		}
	}
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class BusExpressionVariable: Variable, IBusExpression
	{
		protected Bus1Parameters parameters;
		public BusExpressionVariable(Context context, string name, IBusExpression init): base(context,name)
		{
			parameters = new Bus1Parameters(init);
			Init(parameters);
		}
		public IBusExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IBusExpression val = value.Simplify();
				BusConversionMap.Convert(ref val, "simple");
				parameters.Bus1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.Bus1;}
		}
		public BitArray Calculate()
		{
			if(symbolicMode)
				throw new CalcNotConstantException();
			return parameters.Bus1.Calculate();
		}
		public IBusExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.Bus1.Simplify();
		}
		public DigitalBus Expand()
		{
			if(symbolicMode)
				throw new ExpressionNotExpandableException();
			else
				return parameters.Bus1.Expand();
		}
		public IBusExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IBusExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IBusExpression) base.ExpressionSubstitute(original,replacement);
		}
	}
	[ParsingObject(ParsingObjectType.Variable,15)]
	public class StateMachineExpressionVariable: Variable, IStateMachineExpression
	{
		protected StateMachine1Parameters parameters;
		public StateMachineExpressionVariable(Context context, string name, IStateMachineExpression init): base(context,name)
		{
			parameters = new StateMachine1Parameters(init);
			Init(parameters);
		}
		public IStateMachineExpression Value
		{
			set
			{
				bool wasSymbolic = symbolicMode;
				symbolicMode = false;
				IStateMachineExpression val = value.Simplify();
				parameters.StateMachine1 = val;
				symbolicMode = wasSymbolic;
			}
			get {return parameters.StateMachine1;}
		}
		public IBusExpression InputBus
		{
			get {return parameters.StateMachine1.InputBus;}
		}
		public IBusExpression OutputBus
		{
			get {return parameters.StateMachine1.OutputBus;}
		}
		public IBusExpression InternalState
		{
			get {return parameters.StateMachine1.InternalState;}
		}
		public bool Propagate()
		{
			return parameters.StateMachine1.Propagate();
		}
		public IStateMachineExpression Simplify()
		{
			if(symbolicMode)
				return(this);
			else
				return parameters.StateMachine1.Simplify();
		}
		public FiniteStateMachine Expand()
		{
			if(symbolicMode)
				throw new Exceptions.ExpressionNotExpandableException();
			else
				return parameters.StateMachine1.Expand();
		}
		public IStateMachineExpression SafeExpand()
		{
			try {return Expand();}
			catch(ExpressionNotExpandableException e) {return this;}
		}
		public IStateMachineExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IStateMachineExpression) base.ExpressionSubstitute(original,replacement);
		}
	}

	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetBitExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Bit1Parameters parameters;
		public SetBitExpressionVariable(Context context, IBitExpression name,IBitExpression val): base(context)
		{
			this.parameters = new Bit1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetBitExpressionVariable(Context context, IScalarExpression name,IBitExpression val): base(context)
		{
			this.parameters = new Bit1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			BitExpressionVariable v1 = name as BitExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Bit1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new BitExpressionVariable(context,v2.VariableName,parameters.Bit1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Bit1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Bit1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetBusExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected Bus1Parameters parameters;
		public SetBusExpressionVariable(Context context, IBusExpression name,IBusExpression val): base(context)
		{
			this.parameters = new Bus1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetBusExpressionVariable(Context context, IScalarExpression name,IBusExpression val): base(context)
		{
			this.parameters = new Bus1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			BusExpressionVariable v1 = name as BusExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.Bus1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new BusExpressionVariable(context,v2.VariableName,parameters.Bus1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.Bus1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.Bus1.ToString() +")");
		}
	}
	[ParsingObject(ParsingObjectType.InnerOperator,500,Character=":")]
	public class SetStateMachineExpressionVariable: StdProcedure, IProcExpression
	{
		private IExpression name;
		protected StateMachine1Parameters parameters;
		public SetStateMachineExpressionVariable(Context context, IStateMachineExpression name,IStateMachineExpression val): base(context)
		{
			this.parameters = new StateMachine1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public SetStateMachineExpressionVariable(Context context, IScalarExpression name,IStateMachineExpression val): base(context)
		{
			this.parameters = new StateMachine1Parameters(val);
			Init(parameters);
			this.name = name;
		}
		public override bool Execute()
		{
			StateMachineExpressionVariable v1 = name as StateMachineExpressionVariable;
			if(v1 != null)
			{
				v1.Value = parameters.StateMachine1;
				context.ContextVariables.AddVariable(v1);
				return true;
			}
			ScalarExpressionVariable v2 = name as ScalarExpressionVariable;
			if(v2 != null)
			{
				context.ContextVariables.AddVariable(new StateMachineExpressionVariable(context,v2.VariableName,parameters.StateMachine1));
				return true;
			}
			return false;
		}
		public override string ToString()
		{
			Variable v = name as Variable;
			if(v == null)
				return("("+ name.ToString() +":"+ parameters.StateMachine1.ToString() +")");
			else
				return("("+ v.VariableName +":"+ parameters.StateMachine1.ToString() +")");
		}
	}

	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteBitExpressionVariable: StdProcedure, IProcExpression
	{
		protected Bit1Parameters parameters;
		public DeleteBitExpressionVariable(Context context, Bit1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteBitExpressionVariable(Context context, IBitExpression val): base(context)
		{
			this.parameters = new Bit1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Bit1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteBusExpressionVariable: StdProcedure, IProcExpression
	{
		protected Bus1Parameters parameters;
		public DeleteBusExpressionVariable(Context context, Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteBusExpressionVariable(Context context, IBusExpression val): base(context)
		{
			this.parameters = new Bus1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Bus1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="del")]
	public class DeleteStateMachineExpressionVariable: StdProcedure, IProcExpression
	{
		protected StateMachine1Parameters parameters;
		public DeleteStateMachineExpressionVariable(Context context, StateMachine1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public DeleteStateMachineExpressionVariable(Context context, IStateMachineExpression val): base(context)
		{
			this.parameters = new StateMachine1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.StateMachine1 as Variable;
			if(v != null)
			{
				context.ContextVariables.RemoveVariable(v.VariableName);
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockBitExpressionVariable: StdProcedure, IProcExpression
	{
		protected Bit1Parameters parameters;
		public LockBitExpressionVariable(Context context, Bit1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockBitExpressionVariable(Context context, IBitExpression val): base(context)
		{
			this.parameters = new Bit1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Bit1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockBusExpressionVariable: StdProcedure, IProcExpression
	{
		protected Bus1Parameters parameters;
		public LockBusExpressionVariable(Context context, Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockBusExpressionVariable(Context context, IBusExpression val): base(context)
		{
			this.parameters = new Bus1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Bus1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="lock")]
	public class LockStateMachineExpressionVariable: StdProcedure, IProcExpression
	{
		protected StateMachine1Parameters parameters;
		public LockStateMachineExpressionVariable(Context context, StateMachine1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public LockStateMachineExpressionVariable(Context context, IStateMachineExpression val): base(context)
		{
			this.parameters = new StateMachine1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.StateMachine1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = true;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockBitExpressionVariable: StdProcedure, IProcExpression
	{
		protected Bit1Parameters parameters;
		public UnlockBitExpressionVariable(Context context, Bit1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockBitExpressionVariable(Context context, IBitExpression val): base(context)
		{
			this.parameters = new Bit1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Bit1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockBusExpressionVariable: StdProcedure, IProcExpression
	{
		protected Bus1Parameters parameters;
		public UnlockBusExpressionVariable(Context context, Bus1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockBusExpressionVariable(Context context, IBusExpression val): base(context)
		{
			this.parameters = new Bus1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.Bus1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
	[ParsingObject(ParsingObjectType.Function,250,Character="unlock")]
	public class UnlockStateMachineExpressionVariable: StdProcedure, IProcExpression
	{
		protected StateMachine1Parameters parameters;
		public UnlockStateMachineExpressionVariable(Context context, StateMachine1Parameters parameters): base(context)
		{
			this.parameters = parameters;
			Init(parameters);
		}
		public UnlockStateMachineExpressionVariable(Context context, IStateMachineExpression val): base(context)
		{
			this.parameters = new StateMachine1Parameters(val);
			Init(parameters);
		}
		public override bool Execute()
		{
			Variable v = parameters.StateMachine1 as Variable;
			if(v != null)
			{
				v.IsThreatenedAsVariable = false;
				return true;
			}
			return false;
		}
	}
}
