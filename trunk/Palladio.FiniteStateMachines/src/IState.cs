using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// Interface for states used by all FSMs.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:19:37  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IState : IVisitable, IAttributable
	{
		/// <summary>
		///		The unique ID of the state.
		/// </summary>
		string ID { get; }

		/// <summary>
		/// If true this state is an error state. An error state is reached when running
		/// along an invalid transition in a FSM.
		/// </summary>
		bool IsErrorState { get; set; }
	}
}
