using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Attributes;
using Palladio.Performance.Math;
using Palladio.Utils.Collections;

namespace Palladio.Performance.FSMTransformer
{
	/// <summary>
	/// Transformer for FSMs. Introduces an intermediate sate a' for each state a that contains a
	/// RandomVariable. The transition a'->a gets the RandomVariable of a. The probability of
	/// the new transition is 1. After the transformation all RandomVariables are accessible over the
	/// transitions.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/10/11 22:05:14  helgeh
	/// - Added NUnit project and NDoc documentation.
	/// - fixed a bug in AdjustSamplingRate
	///
	/// Revision 1.1  2005/08/12 07:59:19  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class FSMTransformer
	{
		#region FSMWithIntermediateState

		/// <summary>
		/// Creates a new FSM where all Attributes holded by transitions.
		/// For each state s containing a QMLAttribute or RandomVariable a new intermediate state  s' is created.
		/// The new transition s->s' holds the time consumption. For each state m with transition m->s, the transition
		/// is replaced by a transition m->s'.
		/// </summary>
		/// <param name="fsm">FSM which states contain attributes.</param>
		/// <returns>New FSM with intermediate Sates.</returns>
		public static IFiniteStateMachine FSMWithIntermediateState(IFiniteStateMachine fsm)
		{
			IEditableFiniteStateMachine resultFSM = CreateCopyWithoutTrnasitions(fsm);

			foreach (IState state in fsm.States)
			{
				resultFSM.AddInputSymbols(FSMFactory.CreateDefaultInput(state.ID));

				IState intermediateState = AddIntermediateState(state, resultFSM);

				AddIntermediateTransition(state, intermediateState, resultFSM);

				RedirectTransitions(GetIncomingTransitions(state, fsm), intermediateState, resultFSM);
				if (fsm.StartState.Equals(state)) resultFSM.StartState = intermediateState;
			}
			return resultFSM;
		}

		/// <summary>
		/// Creates a copy of the FSM without transitions.
		/// </summary>
		/// <param name="fsm">FSM to copy.</param>
		/// <returns>Copy of the FSM without transitions.</returns>
		private static IEditableFiniteStateMachine CreateCopyWithoutTrnasitions(IFiniteStateMachine fsm)
		{
			IEditableFiniteStateMachine resultFSM = FSMFactory.CreateEmptyFSM();
			resultFSM.AddStates(fsm.States);
			resultFSM.StartState = fsm.StartState;
			resultFSM.FinalStates = fsm.FinalStates;
			resultFSM.AddInputSymbols(fsm.InputAlphabet);
			return resultFSM;
		}

		/// <summary>
		/// Adds an intermediate state for a state.
		/// </summary>
		/// <param name="state">State for which the intermediate shall be created.</param>
		/// <param name="resultFSM">FSM with intermediate state.</param>
		/// <returns>The intermediate state.</returns>
		private static IState AddIntermediateState(IState state, IEditableFiniteStateMachine resultFSM)
		{
			IState intermediateState = FSMFactory.CreateDefaultState(
				"intermediateState for state " + state.ID);
			resultFSM.AddStates(new IState[] {intermediateState});
			return intermediateState;
		}

		/// <summary>
		/// Adds a transition from <c>intermediateState</c> to <c>state</c>. The transition gets the <c>RandomVariable</c>
		/// from <c>state</c> and a <c>ProbabilityAttribute</c> with a probability of 1. The ID of the new transition is the
		/// ID of the state.
		/// </summary>
		/// <param name="state">State for which the intermediate state was created.</param>
		/// <param name="intermediateState">Intermediate state.</param>
		/// <param name="resultFSM">FSM with intermediate state.</param>
		private static void AddIntermediateTransition(IState state, IState intermediateState, IEditableFiniteStateMachine resultFSM)
		{
			IInput newInput = FSMFactory.CreateDefaultInput(state.ID);

			ITransition newTransition =
				FSMFactory.CreateDefaultTransition(intermediateState, newInput, state);
			newTransition.Attributes.Add(RandomVariable.AttributeType,
			                             RandomVariable.GetAttribute(state));

			ProbabilityAttribute prob = new ProbabilityAttribute(1);
			newTransition.Attributes.Add(ProbabilityAttribute.AttributeType, prob);

			resultFSM.AddTransitions(newTransition);
		}

		/// <summary>
		/// Each incoming transition is directed to the intermediate state.
		/// </summary>
		/// <param name="incomingTransitions">Transitions that have to be directed to the intermediate state.</param>
		/// <param name="intermediateState">The intermediate state.</param>
		/// <param name="resultFSM">FSM with intermediate state.</param>
		private static void RedirectTransitions(ITransition[] incomingTransitions, IState intermediateState, IEditableFiniteStateMachine resultFSM)
		{
			foreach (ITransition transition in incomingTransitions)
			{
				ITransition redirectedTransition =
					FSMFactory.CreateDefaultTransition
						(transition.SourceState, transition.InputSymbol, intermediateState);

				redirectedTransition.Attributes.Add(RandomVariable.AttributeType,
				                                    RandomVariable.GetAttribute(transition));

				redirectedTransition.Attributes.Add(ProbabilityAttribute.AttributeType,
				                                    ProbabilityAttribute.GetAttribute(transition));

				resultFSM.AddTransitions(redirectedTransition);
			}
		}

		/// <summary>
		/// Returns all incoming transitions of a state.
		/// </summary>
		/// <param name="state">State for which the incoming transitions are searched.</param>
		/// <param name="fsm">FSM of the state.</param>
		/// <returns>All incoming transitions of <c>state</c>.</returns>
		public static ITransition[] GetIncomingTransitions(IState state, IFiniteStateMachine fsm)
		{
			Vector vector = new Vector();
			foreach (ITransition transition in fsm.Transitions)
			{
				if (transition.DestinationState.Equals(state)) vector.Add(transition);
			}
			ITransition[] incomingTransitions = new ITransition[vector.Count];
			vector.CopyTo(incomingTransitions, 0);

			return incomingTransitions;
		}

		#endregion FSMWithIntermediateState

		#region SEFFValidity

		/// <summary>
		/// Check wheter all states and all transitions have a QMLAttribute or a RandomVariable and
		/// whether the sum of probabilities of all outgoing transitions is 1. If sum > 1 an exception 
		/// is thrown. If  sum is smaller than 1, the user gets a warning.
		/// The remaining probability is shared to  all transitions with no ProbabilityAttribute.
		/// All QMLAttributes are converted to RandomVariables.
		/// </summary>
		/// <param name="fsm"><c>IFiniteStateMachine</c> to be validated.</param>
		/// <returns>A new <c>IFiniteStateMachine</c> where all states, except start state and
		/// final states, contain a <c>RandomVariable</c> and all transitions contain a <c>RandomVariable</c> and a
		/// <c>ProbabilityAttribute</c>. </returns>
		public static IFiniteStateMachine SEFFValidity(IFiniteStateMachine fsm)
		{
			IFiniteStateMachine validitySeff = (IFiniteStateMachine) fsm.Clone();

			CheckForTimeAttributes(validitySeff);
			CheckForProbabilityAttributes(validitySeff);

			return validitySeff;
		}

		/// <summary>
		/// Checks whether the sum of probabilities for each state of all outgoing transitions is 1.
		/// If sum > 1 an exception is thrown. If  sum is smaller than 1, the user gets a warning.
		/// The remaining probability is shared to  all transitions with no ProbabilityAttribute.
		/// </summary>
		/// <param name="fsm"></param>
		private static void CheckForProbabilityAttributes(IFiniteStateMachine fsm)
		{
			foreach (IState state in fsm.States)
			{
				ArrayList withoutProbability = new ArrayList();
				double sum = 0;
				foreach (ITransition trans in fsm.GetOutgoingTransitions(state))
				{
					if (trans.Attributes.Contains(ProbabilityAttribute.AttributeType))
					{
						sum += ProbabilityAttribute.GetAttribute(trans).Probability;
					}
					else
					{
						withoutProbability.Add(trans);
					}
				}
				if (sum > 1)
				{
					throw new ApplicationException("For state " + state.ID +
						": The sum of probabilities for outgoing transitions is :" + sum +
						"\n Thats more than 1!");
				}

				sum = DistributeRemainingProbabilitiy(state, withoutProbability, sum);

				if (sum < 1 && !fsm.IsFinalState(state))
				{
					Console.WriteLine("Warning: The sum of probabilities for outgoing transitions of state " +
						state.ID + " is " + sum + " Thats smaller than 1.");
				}
			}
		}

		/// <summary>
		/// Distributes the remaining probability (<c>1-sum</c>) in equal shares on all outgoing transitions,
		/// that do not have  a ProbabilityAttribute.
		/// </summary>
		/// <param name="state">Source state of the transitions.</param>
		/// <param name="withoutProbability">A list of transitions without a ProbabilityAttribute.</param>
		/// <param name="sum">The total sum of probabilities of all outgoing transitions. The remaining
		/// probability is <c>1-sum</c>.</param>
		private static double DistributeRemainingProbabilitiy(IState state, ArrayList withoutProbability, double sum)
		{
			if (withoutProbability.Count > 0)
			{
				Console.WriteLine("For state " + state.ID + ": " +
					"There are " + withoutProbability.Count +
					" transitions without a ProbabilityAttribute. For each of these transition the probability is set to "
					+ ((1 - sum)/withoutProbability.Count)
					);

				foreach (ITransition trans in withoutProbability)
				{
					double val = ((1.0 - sum)/withoutProbability.Count);
					trans.Attributes.Add(ProbabilityAttribute.AttributeType,
					                     new ProbabilityAttribute(val));
					sum += val;
				}
			}
			return sum;
		}

		/// <summary>
		/// Checks all states and transitions on containing a <c>RandomVariable</c> or a <c>QMLAttribute</c>.
		/// <c>QMLAttribute</c>s are converted to <c>RandomVariable</c>s.
		/// </summary>
		/// <param name="fsm">IFiniteStateMachine to be checked.</param>
		private static void CheckForTimeAttributes(IFiniteStateMachine fsm)
		{
			CheckForTimeAttributeOnStates(fsm);
			CheckForTimeAttributesOnTransitions(fsm);
		}

		/// <summary>
		/// Checks whether all transitions have a <c>RandomVariable</c> or a <c>QMLAttribute</c>.
		/// If a transition does not contain either of both an exception is thrown.
		/// If the transition does not contain a <c>RandomVariable</c> but contain a <c>QMLAttribute</c>,
		/// a <c>RandomVariable</c> is created using the <c>QMLAttribute</c>.
		/// </summary>
		/// <param name="fsm">IFiniteStateMachine to be checked.</param>
		private static void CheckForTimeAttributesOnTransitions(IFiniteStateMachine fsm)
		{
			foreach (ITransition trans in fsm.Transitions)
			{
				try
				{
					CheckForTimeAttributeOnAttributable(trans);
				}
				catch (ApplicationException)
				{
					throw new ApplicationException("All transitions must have a time description." +
						" Time description for " + trans.InputSymbol.ID + " is missed.");
				}
			}
		}

		/// <summary>
		/// Checks whether all states have a <c>RandomVariable</c> or a <c>QMLAttribute</c>.
		/// If a state does not contain either of both an exception is thrown.
		/// If the state does not contain a <c>RandomVariable</c> but contain a <c>QMLAttribute</c>,
		/// a <c>RandomVariable</c> is creted using the <c>QMLAttribute</c>.
		/// </summary>
		/// <param name="fsm">IFiniteStateMachine to be checked.</param>
		private static void CheckForTimeAttributeOnStates(IFiniteStateMachine fsm)
		{
			foreach (IState state in fsm.States)
			{
				try
				{
					CheckForTimeAttributeOnAttributable(state);
				}
				catch (ApplicationException)
				{
					throw new ApplicationException("All transitions must have a time description." +
						" Time description for " + state.ID + " is missed.");
				}
			}
		}

		/// <summary>
		/// Checks whether the <c>IAttributable</c> has a <c>RandomVariable</c> or a <c>QMLAttribute</c>.
		/// If it does not contain either of both an exception is thrown.
		/// If the <c>IAttributable</c> does not contain a <c>RandomVariable</c> but contain a <c>QMLAttribute</c>,
		/// a <c>RandomVariable</c> is creted using the <c>QMLAttribute</c>.
		/// </summary>
		/// <param name="attributable"><c>IAttributable to check.</c></param>
		private static void CheckForTimeAttributeOnAttributable(IAttributable attributable)
		{
			if (!attributable.Attributes.Contains(RandomVariable.AttributeType))
			{
				if (attributable.Attributes.Contains(QMLAttribute.AttributeType))
				{
					attributable.Attributes.Add(RandomVariable.AttributeType,
					                            AttributeTransformer.Qml2RandomVariable(QMLAttribute.GetAttribute(attributable)));
				}
				else
				{
					throw new ApplicationException();
				}
			}
		}

		#endregion SEFFValidity

		#region ToString

		/// <summary>
		/// Creates a string representation of of the FSM including the time consumption.
		/// </summary>
		/// <param name="fsm">FSM with <c>RandomVariables</c>.</param>
		/// <returns>String representation of the FSM.</returns>
		public static string FSMTimeConsumptionToString(IFiniteStateMachine fsm)
		{
			string result = StatesTimeConsumptionToString(fsm);
			result = result + TransitionsTimeConsumptionToString(fsm);
			return result;
		}

		/// <summary>
		/// Creates a string representation of of the FSMs states including the time consumption.
		/// </summary>
		/// <param name="fsm">FSM with <c>RandomVariables</c>.</param>
		/// <returns>String representation of the states.</returns>
		private static string StatesTimeConsumptionToString(IFiniteStateMachine fsm)
		{
			string result = "\n Time Consumption for states: \n";
			for (int i = 0; i < fsm.States.Length; i++)
			{
				result += fsm.States[i].ID + ":\n";
				try
				{
					RandomVariable rand = RandomVariable.GetAttribute(fsm.States[i]);
					IDiscreteFunction dg = rand.ProbabilityDensityFunction;
					result += dg;
					result += "\n";
				}
				catch (Exception)
				{
					result += "rand=null\n";
				}
			}
			return result;
		}

		/// <summary>
		/// Creates a string representation of of the FSMs transitions including the time consumption.
		/// </summary>
		/// <param name="fsm">FSM with <c>RandomVariables</c>.</param>
		/// <returns>String representation of the transitions.</returns>
		private static string TransitionsTimeConsumptionToString(IFiniteStateMachine fsm)
		{
			string result = "\n Time Consumption for transitions: \n";
			for (int i = 0; i < fsm.Transitions.Length; i++)
			{
				result += fsm.Transitions[i] + ": \n";
				RandomVariable rand = RandomVariable.GetAttribute(fsm.Transitions[i]);
				IDiscreteFunction dg = rand.ProbabilityDensityFunction;
				result += dg;
				result += "\n";
			}
			return result;
		}

		#endregion ToString

		/// <summary>
		/// Creates a state with a unique id.
		/// </summary>
		/// <returns></returns>
		public static IState CreateUniqueState()
		{
			return FSMFactory.CreateDefaultState(Guid.NewGuid().ToString());
		}

//
	}
}