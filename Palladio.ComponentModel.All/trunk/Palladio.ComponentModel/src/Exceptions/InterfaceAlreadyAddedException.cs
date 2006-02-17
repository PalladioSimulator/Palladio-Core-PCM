using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the interface is already bound to the component and cannot be added twice.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/05/20 17:27:23  kelsaka
	/// - added further constraints
	/// - added new exception - for use in constraints
	///
	/// </pre>
	/// </remarks>
	public class InterfaceAlreadyAddedException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the interface is already bound to the component and cannot be added twice.
		/// </summary>
		/// <param name="aComponentID">The component.</param>
		/// <param name="ifaceID">the interface</param>
		public InterfaceAlreadyAddedException(IComponentIdentifier aComponentID, IInterfaceIdentifier ifaceID) : 
			base( "Interface "+ifaceID+" is already bound to component "+aComponentID+".")
		{
		}

		/// <summary>
		/// Error indicating, that the interface is already bound to the component and cannot be added twice.
		/// </summary>
		/// <param name="aComponentID">The component.</param>
		/// <param name="ifaceID">the interface</param>
		/// <param name="message">Error message.</param>
		public InterfaceAlreadyAddedException(IComponentIdentifier aComponentID, IInterfaceIdentifier ifaceID, string message) : 
			base( "Interface "+ifaceID+" is already bound to component "+aComponentID+". Error message: " + message)
		{
		}

	}
}