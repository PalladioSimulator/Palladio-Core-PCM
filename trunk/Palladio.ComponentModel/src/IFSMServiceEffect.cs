using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// This interface extends IAuxiliaryServiceEffectSpecification in order to provide a service
	/// effect specification describing the service using a finite state machine.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IFSMServiceEffect : IAttributable, IServiceInformation
	{
		/// <summary>
		/// the finite state machine of this specification
		/// </summary>
		IFiniteStateMachine FSM
		{
			get;
		}

		/// <summary>
		/// returns a reference to the editable finite state machine
		/// </summary>
		IEditableFiniteStateMachine EditFSM
		{
			get;
		}
		
		/// <summary>
		/// Return the external services, that are required by this service effect specification
		/// </summary>
		IService[] RequiredServices 
		{
			get;
		}
		
	}
}
