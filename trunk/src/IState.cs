using System;
using System.Collections;
using ReflectionBasedVisitor.Interfaces;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// Interface for states used by all FSMs.
	/// </summary>
	public interface IState : IVisitable
	{
		/// <summary>
		///		The unique ID of the state.
		/// </summary>
		string ID { get; }

		/// <summary>
		/// Get or set the payload of this state. The payload is used to characterize 
		/// this state in a given client application.
		/// </summary>
		Hashtable AttributeTable { get; }

		/// <summary>
		/// If true this state is an error state. An error state is reached when running
		/// along an invalid transition in a FSM.
		/// </summary>
		bool IsErrorState { get; set; }
	}
}
