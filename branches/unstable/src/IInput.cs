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
	/// Revision 1.3  2004/05/13 15:03:46  sliver
	/// IMatchable Interface added
	///
	/// Revision 1.2  2004/05/12 13:40:19  sbecker
	/// Added documentation and CVS log
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
