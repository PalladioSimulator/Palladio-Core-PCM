using System;
using System.Collections;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// Zusammenfassung für IEditableFiniteStateMachine.
	/// </summary>
	public interface IEditableFiniteStateMachine : IFiniteStateMachine
	{
		/// <summary>
		///     If the automaton is used for accepting
		///     an input sequence, this is the state to
		///     start with.
		///     
		///     If no start state is defined an exception has to
		///     be thrown.
		/// </summary>
		IState StartState { set; get; }

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		///     
		///     If no finalstates are defined an exception has to
		///     be thrown. (type?)
		/// </summary>
		IState[] FinalStates { set; get; }

		/// <summary>
		///     Adds a single transition to the automaton.
		/// </summary>
		/// <param name="aTransitionArray">The list of transitions to be added to this FSM</param>
		void AddTransitions(params ITransition[] aTransitionArray);

		/// <summary>
		///     Adds a list of transitions to the automaton.
		/// </summary>
		/// <param name="aTransitionList">A list of transitions.</param>
		void AddTransitionList(IEnumerable aTransitionList);

		/// <summary>
		/// Delete a list of transitions from this FSM
		/// </summary>
		/// <param name="aTranstionArray">A list of transitions to be deleted from the FSM</param>
		void DeleteTransitions(params ITransition[] aTranstionArray);

		/// <summary>
		/// Add the given list of states to this FSM
		/// </summary>
		/// <param name="aStateArray">The list of states to be added to the FSM</param>
		void AddStates(params IState[] aStateArray);

		/// <summary>
		/// Add the given list of states to this FSM
		/// </summary>
		/// <param name="aStateList">The list of states to be added to the FSM</param>
		void AddStateList(IEnumerable aStateList);

		/// <summary>
		/// A state can only be deleted, if no transitions junked to this state.
		/// </summary>
		/// <param name="aStateArray"></param>
		void DeleteStates(params IState[] aStateArray);

		/// <summary>
		/// Add the given list of input symbols to this FSM
		/// </summary>
		/// <param name="anInputSymbolList">The list of input states to be added to the FSM</param>
		void AddInputSymbols(params IInput[] anInputSymbolList);

		/// <summary>
		/// Delete the given input symbol. An input symbol can only be deleted if there are
		/// no transitions using it.
		/// </summary>
		/// <param name="anInputSymbolList">The list of input states to be deleted to the FSM</param>
		void DeleteInputSymbols(params IInput[] anInputSymbolList);
	}
}
