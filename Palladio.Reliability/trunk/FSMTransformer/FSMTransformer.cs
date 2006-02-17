using System;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;

namespace Palladio.Reliability.FSMTransformer
{
	/// <summary>
	/// Decorator for FSMs. Introduces an intermediate state
	/// for each transition. The intermediate state contains the
	/// time attributes of the transition. The transition probability
	/// is added to the ingoing transition of the state and the reliability
	/// to the outgoing transition.
	/// </summary>
	public class FSMTransformer
	{
		/// <summary>
		/// Inputsymbol from the return transition of the intermediate state.
		/// </summary>
		public static IInput RETURN_INPUT = FSMFactory.CreateDefaultInput("RETURN");


		/// <summary>
		/// Introduces an intermediate state
		/// for each transition. The intermediate state contains the
		/// time attributes of the transition. The transition probability
		/// is added to the ingoing transition of the state and the reliability
		/// to the outgoing transition.
		/// 
		/// TODO: implement as decorator.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IFiniteStateMachine FSMWithIntermediateState(IFiniteStateMachine fsm)
		{
			IEditableFiniteStateMachine resultFSM = FSMFactory.CreateEmptyFSM();
			resultFSM.AddStates(fsm.States);
			resultFSM.StartState = fsm.StartState;
			resultFSM.FinalStates = fsm.FinalStates;
			resultFSM.AddInputSymbols(fsm.InputAlphabet);
			resultFSM.AddInputSymbols(RETURN_INPUT);

			foreach (ITransition transition in fsm.Transitions)
			{
				// create a state with an unique id.
				IState intermediateState = CreateUniqueState();

				InputAttribute.SetAttribute(intermediateState, transition.InputSymbol);

				// TODO: make the seperation of attributes dynamic.

				// Only states consume time
				intermediateState.Attributes.Add(
					MeasuredTimeAttribute.AttributeType, MeasuredTimeAttribute.GetAttribute(transition));

				// ingoing transition with the transition probability of the original one.
				ITransition ingoingTransition = FSMFactory.CreateDefaultTransition(
					transition.SourceState, transition.InputSymbol, intermediateState);
				ingoingTransition.Attributes.Add(
					ProbabilityAttribute.AttributeType, ProbabilityAttribute.GetAttribute(transition));

				// outgoing transition with probability 1.0
				ITransition outgoingTransition = FSMFactory.CreateDefaultTransition(
					intermediateState, RETURN_INPUT, transition.DestinationState);
				outgoingTransition.Attributes.Add(
					ReliabilityAttribute.AttributeType, ReliabilityAttribute.Get(transition));
				ProbabilityAttribute.SetAttribute(outgoingTransition, 1.0);

				resultFSM.AddStates(intermediateState);
				resultFSM.AddTransitions(ingoingTransition, outgoingTransition);
			}
			return resultFSM;
		}

		/// <summary>
		/// Creates a finite state machine that accepts exactly the valid
		/// state sequences for <c>fsm</c>.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IFiniteStateMachine FSMAcceptingStateSequence(IFiniteStateMachine fsm)
		{
			IState newStartState = CreateUniqueState();
			ITransition newStartTransition = FSMFactory.CreateDefaultTransition(
				newStartState, new StateInput(fsm.StartState), fsm.StartState);
			ProbabilityAttribute.SetAttribute(newStartTransition, 1.0);

			IEditableFiniteStateMachine resultFSM = FSMFactory.CreateEmptyFSM();
			resultFSM.AddStates(fsm.States);
			resultFSM.AddStates(newStartState);
			resultFSM.AddInputSymbols(newStartTransition.InputSymbol);
			resultFSM.StartState = newStartState;
			resultFSM.FinalStates = fsm.FinalStates;
			resultFSM.AddTransitions(newStartTransition);

			foreach (ITransition transition in fsm.Transitions)
			{
				ITransition newTransition = FSMFactory.CreateDefaultTransition(
					transition.SourceState,
					new StateInput(transition.DestinationState),
					transition.DestinationState
					);
				ProbabilityAttribute prob = ProbabilityAttribute.GetAttribute(transition);
				if (prob != null)
				{
					ProbabilityAttribute.SetAttribute(newTransition, prob.Probability);
				}
				else
				{
					ProbabilityAttribute.SetAttribute(newTransition, 0);
				}
				resultFSM.AddInputSymbols(newTransition.InputSymbol);
				resultFSM.AddTransitions(newTransition);
			}

			// add the transitionprobabilities to the states.
			foreach (ITransition transition in resultFSM.Transitions)
			{
				ProbabilityAttribute prob = ProbabilityAttribute.GetAttribute(transition);
				ProbabilityAttribute.SetAttribute(((StateInput) transition.InputSymbol).State, prob.Probability);
			}

			return resultFSM;
		}

		/// <summary>
		/// Introduces a unique input symbol for each transition.
		/// </summary>
		/// <param name="fsm"></param>
		/// <returns></returns>
		public static IFiniteStateMachine UniqueInputSymbolForTransitions(IFiniteStateMachine fsm)
		{
			IEditableFiniteStateMachine resultFSM = FSMFactory.CreateEmptyFSM();
			resultFSM.AddStates(fsm.States);
			resultFSM.StartState = fsm.StartState;
			resultFSM.FinalStates = fsm.FinalStates;
			foreach (ITransition transition in fsm.Transitions)
			{
				ITransition newTransition = FSMFactory.CreateDefaultTransition(
					transition.SourceState,
					new UniqueInput(transition.InputSymbol),
					transition.DestinationState
					);
				ProbabilityAttribute prob = ProbabilityAttribute.GetAttribute(transition);
				if (prob != null)
				{
					ProbabilityAttribute.SetAttribute(newTransition, prob.Probability);

				}
				else
				{
					ProbabilityAttribute.SetAttribute(newTransition, 0);
				}
				resultFSM.AddInputSymbols(newTransition.InputSymbol);
				resultFSM.AddTransitions(newTransition);
			}
			return resultFSM;
		}


		/// <summary>
		/// Creates a state with a unique id.
		/// </summary>
		/// <returns></returns>
		public static IState CreateUniqueState()
		{
			return FSMFactory.CreateDefaultState(Guid.NewGuid().ToString());
		}

	}
}