using Palladio.ComponentModel.ModelEntities;
using Palladio.FiniteStateMachines;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// The interface that represents a FSM as <see cref="IProtocol"/>.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/26 17:50:27  kelsaka
	/// - initial creation
	///
	/// </code>
	/// </remarks>
	public interface  IFSMProtocol : IProtocol
	{
		/// <summary>
		/// called to return the fsm that is used to specify the interface protocol.
		/// </summary>
		IFiniteStateMachine FiniteStateMachine { get; }
	}
}