using Palladio.ComponentModel.ModelEntities;
using Palladio.FiniteStateMachines;

namespace Palladio.FSMWrapper
{
	/// <summary>
	/// The interface that represents a FSM as service effect specification.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/31 12:49:04  kelsaka
	/// - initial interface creation
	///
	/// </code>
	/// </remarks>
	public interface IFSMServiceEffectSpecification : IServiceEffectSpecification
	{
		/// <summary>
		/// called to return the fsm that is used to specify the interface protocol.
		/// </summary>
		IFiniteStateMachine FiniteStateMachine { get; }
	}
}