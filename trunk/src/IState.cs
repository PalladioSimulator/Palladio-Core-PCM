using System;
using System.Collections;
using ReflectionBasedVisitor;

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
	/// Revision 1.3  2004/05/12 14:07:16  sbecker
	/// Changed the reflection based visitors namespace
	///
	/// Revision 1.2  2004/05/12 13:40:19  sbecker
	/// Added documentation and CVS log
	///
	///
	/// </pre>
	/// </remarks>
	public interface IState : IVisitable
	{
		/// <summary>
		///		The unique ID of the state.
		/// </summary>
		string ID { get; }

		/// <summary>
		/// A list of attributes attached to this state. The attributes are stored in a 
		/// hashmap hashing the ID of the attribute to the respective value.
		/// </summary>
		Hashtable AttributeTable { get; }

		/// <summary>
		/// If true this state is an error state. An error state is reached when running
		/// along an invalid transition in a FSM.
		/// </summary>
		bool IsErrorState { get; set; }
	}
}
