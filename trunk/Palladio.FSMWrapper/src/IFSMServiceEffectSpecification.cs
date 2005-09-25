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
	/// $Log$
	/// Revision 1.2  2005/09/25 11:24:14  kelsaka
	/// - fixed bug: there was no public interface for IFSMProtocols
	///
	/// Revision 1.1  2005/08/31 12:49:04  kelsaka
	/// - initial interface creation
	///
	/// </code>
	/// </remarks>
	public interface IFSMServiceEffectSpecification : IServiceEffectSpecification
	{
		/// <summary>
		/// called to return the fsm that is used to specify the SEFF.
		/// </summary>
		IFiniteStateMachine FiniteStateMachine { get; }
	}
}