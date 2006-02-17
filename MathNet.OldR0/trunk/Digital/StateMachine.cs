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

namespace cdrnet.Lib.MathLib.Digital
{
	#region Specific Math Objects - State Machine
	[ParsingObject(ParsingObjectType.Function,250,Character="state")]
	public class FiniteStateMachine: StateMachineOperator
	{
		protected BusExpressionVariable inputbus, statebus;
		protected DigitalBus propagationbus, outputbus;
		public FiniteStateMachine(Context context, IBusExpression input, IBusExpression state, IBusExpression propagation, IBusExpression output): base(context)
		{
			this.propagationbus = propagation.Expand();
			this.outputbus = output.Expand();
			this.inputbus = input as BusExpressionVariable;
			this.statebus = state as BusExpressionVariable;
			if(inputbus == null || statebus == null)
				throw new ExpressionVariableRequiredException();
		}
		public override IBusExpression InputBus
		{
			get {return inputbus;}
		}
		public override IBusExpression OutputBus
		{
			get {return outputbus;}
		}
		public override IBusExpression InternalState
		{
			get {return statebus;}
		}
		public IBusExpression PropagationBus
		{
			get {return propagationbus;}
		}
		public override FiniteStateMachine Expand()
		{
			return this;
		}
		public override bool Propagate()
		{
			IBusExpression nb = propagationbus.Simplify();
			BusConversionMap.Convert(ref nb,"simple");
			statebus.Value = nb;
			return true;
		}
		public override bool IsConstant
		{
			get {return(outputbus.IsConstant);}
		}
		public override void ConvertChilds(string conversionType)
		{
			inputbus.IsThreatenedAsVariable = true;
			inputbus.ConvertChilds(conversionType);
			statebus.IsThreatenedAsVariable = true;
			statebus.ConvertChilds(conversionType);
			IBusExpression outputbe = outputbus;
			IBusExpression propagationbe = propagationbus;
			BusConversionMap.Convert(ref outputbe,conversionType);
			BusConversionMap.Convert(ref propagationbe,conversionType);
			outputbus = outputbe.Expand();
			propagationbus = propagationbe.Expand();
		}
		public override void CollectVariables(VariableManager vars, bool deep)
		{
			inputbus.CollectVariables(vars,deep);
			outputbus.CollectVariables(vars,deep);
			propagationbus.CollectVariables(vars,deep);
			statebus.CollectVariables(vars,deep);
		}
		public override string ToString()
		{
			return "state("+inputbus.ToString()+","+statebus.ToString()+","+propagationbus.ToString()+","+outputbus.ToString()+")";
		}
	}
	#endregion

	[ParsingObject(ParsingObjectType.Function,250,Character="propagate")]
	public class PropagateStateMachine: StdProcedure, IProcExpression
	{
		protected StateMachine1Parameters parameters;
		public StateMachine1Parameters Parameters {get {return parameters;}}
		public PropagateStateMachine(Context context, IStateMachineExpression machine): base(context)
		{
			this.parameters = new StateMachine1Parameters(machine);
			Init(parameters);
		}
		public override bool Execute()
		{
			return parameters.StateMachine1.Propagate();
		}
	}

	#region StateMachine Parameters
	public class StateMachine1Parameters: Parameters
	{
		private IStateMachineExpression statemachine1;
		public StateMachine1Parameters() : base(1) {}
		public StateMachine1Parameters(IStateMachineExpression m1) : base(1)
		{
			statemachine1 = m1;
		}
		public IStateMachineExpression StateMachine1
		{
			get {return statemachine1;}
			set {statemachine1 = value;}
		}
		public override void ConvertChilds(string conversionType)
		{
			//StateMachineConversionMap.Convert(ref statemachine1, conversionType);
		}
		public override Parameters Simplify()
		{
			return new StateMachine1Parameters(statemachine1.Simplify());
		}
		public override Parameters Expand()
		{
			return new StateMachine1Parameters(statemachine1.Expand());
		}
		public override Parameters Substitute(IExpression original, IExpression replacement)
		{
			return new StateMachine1Parameters(statemachine1.Substitute(original,replacement));
		}
		public override IExpression this[int index]
		{
			get
			{
				switch(index)
				{
					case 0:
						return statemachine1;
					default:
						throw new IndexOutOfRangeException();
				}
			}
		}
	}
	#endregion

	#region StateMachine Operator
	/// <summary>
	/// StateMachineOperator is a base operator for operators
	/// returning an <see cref="IStateMachineExpression"/>.
	/// </summary>
	/// <remarks>It's very important to implement Expand()!</remarks>
	public abstract class StateMachineOperator: MathExpression, IStateMachineExpression
	{
		public StateMachineOperator(Context context): base(context) {}
		public virtual bool Propagate()
		{
			return Expand().Propagate();
		}

		#region Basic Ops
		public override IExpression ExpressionExpand()
		{
			return Expand();
		}
		public abstract FiniteStateMachine Expand();
		public IStateMachineExpression SafeExpand()
		{
			return (IStateMachineExpression) ExpressionSafeExpand();
		}
		public override IExpression ExpressionSimplify()
		{
			return Simplify();
		}
		public virtual IStateMachineExpression Simplify()
		{
			return (IStateMachineExpression) InnerSimplify();
		}
		public override IExpression ExpressionSubstitute(IExpression original, IExpression replacement)
		{
			return Substitute(original, replacement);
		}
		public virtual IStateMachineExpression Substitute(IExpression original, IExpression replacement)
		{
			return (IStateMachineExpression) InnerSubstitute(original,replacement);
		}
		#endregion

		public virtual IBusExpression InternalState
		{
			get {return Expand().InternalState;}
		}
		public virtual IBusExpression OutputBus
		{
			get {return Expand().OutputBus;}
		}
		public virtual IBusExpression InputBus
		{
			get {return Expand().InputBus;}
		}
	}
	#endregion
}
