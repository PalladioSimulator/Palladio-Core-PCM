using System;
using System.Collections;

namespace Palladio.FiniteStateMachines
{
	/// <summary>
	/// An interface implemented by a FSM which can be edited programatically. Any FSM
	/// can be converted to an editable FSM by using the method <see cref="FSMFactory.GetEditableFSM"/>.
	/// Editable FSMs offer methods for manipulating states, transitions and input symbols.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2004/05/12 14:12:24  sliver
	/// Comments reviewed.
	///
	/// Revision 1.3  2004/05/12 12:56:08  sbecker
	/// Added documentation and CVS log
	///
	/// </pre>
	/// </remarks>
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
		new IState StartState { set; get; }

		/// <summary>
		///     If the automaton reaches one of this states
		///     during reading an input sequence, the
		///     sequence is accepted.
		/// </summary>
		new IState[] FinalStates { set; get; }

		/// <summary>
		///     Add an array of transitions to the FSM.
		/// </summary>
		/// <param name="aTransitionArray">An array of transitions.</param>
		void AddTransitions(params ITransition[] aTransitionArray);

		/// <summary>
		///     Add a transition from the state with the ID aSourceID to the state
		///     with the ID aDestinationID and the input symbol with the ID anInputID.
		/// </summary>
		/// <param name="aSourceID">ID of the SourceState.</param>
		/// <param name="anInputID">ID of the InputSymbol.</param>
		/// <param name="aDestinationID">ID of the DestinationState.</param>
		void AddTransition(string aSourceID, string anInputID, string aDestinationID);
		
		/// <summary>
		///     Add a list of transitions to the automaton.
		/// </summary>
		/// <param name="aTransitionList">A list of transitions.</param>
		void AddTransitionList(IEnumerable aTransitionList);

		/// <summary>
		/// Delete a list of transitions from this FSM.
		/// </summary>
		/// <param name="aTranstionArray">A list of transitions to be deleted from the FSM</param>
		void DeleteTransitions(params ITransition[] aTranstionArray);

		/// <summary>
		/// Add a list of states to this FSM
		/// </summary>
		/// <param name="aStateArray">The list of states to be added to the FSM</param>
		void AddStates(params IState[] aStateArray);

		/// <summary>
		/// Add a list of states to this FSM.
		/// </summary>
		/// <param name="aStateList">The list of states to be added to the FSM</param>
		void AddStateList(IEnumerable aStateList);

		/// <summary>
		/// Delete a list of states from this FSM.
		/// A state can only be deleted, if no transitions junked to this state.
		/// </summary>
		/// <param name="aStateArray"></param>
		void DeleteStates(params IState[] aStateArray);

		/// <summary>
		/// Add a list of input symbols to the FSM.
		/// </summary>
		/// <param name="anInputSymbolList">A list of input symbols.</param>
		void AddInputSymbols(params IInput[] anInputSymbolList);

		/// <summary>
		/// Delete an input symbol. An input symbol can only be 
		/// deleted if there are no transitions using it.
		/// </summary>
		/// <param name="anInputSymbolList">The list of input states to be deleted to the FSM</param>
		void DeleteInputSymbols(params IInput[] anInputSymbolList);

		/// <summary>
		/// Returns the state with the id anID. If no state is found
		/// a NoStateWithIDException is thrown.
		/// </summary>
		/// <param name="anID">ID of a state of the FSM.</param>
		/// <returns>The state with the ID anID.</returns>
		IState GetState(string anID);

		/// <summary>
		/// Returns the input symbol with the id anID. If no input
		/// is found a NoInputWithIDException is thrown.
		/// </summary>
		/// <param name="anID">ID of an input symbol of the FSM.</param>
		/// <returns>The input symbol with the ID anID.</returns>
		IInput GetInput(string anID);

		/// <summary>
		/// Removes all unreachable states and transitions from the FSM.
		/// </summary>
		void Clean();
	}
}
