using System;

namespace Palladio.FiniteStateMachines 
{
	/// <summary>
	/// A common interface for all input symbols that can be used on a FSM transition
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
	public interface IInput 
	{
		/// <summary>
		/// The ID of the input symbol used for a certain transition
		/// </summary>
		IMatchable ID { get; }
	}
}
