using System;

namespace Palladio.FiniteStateMachines {
	/// <summary>
	/// Interface for states used by all FSMs.
	/// </summary>
	public interface IState {

		/// <summary>
		///		Denotes this state as a start state of the
		///		finite state machine it belongs to.
		/// </summary>
		bool IsStartState { get; }

		
		/// <summary>
		///		Denotes this state as a final state of the
		///		finite state machine it belongs to.
		/// </summary>
		bool IsFinalState { get; }

		
		/// <summary>
		///		The name of the state.
		/// </summary>
		string Name { get; }


	}
}
