using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the interface is not bound to the component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/19 18:35:20  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class InterfaceNotFromComponentException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the interface is not bound to the component.
		/// </summary>
		/// <param name="aComponentID">The component.</param>
		/// <param name="ifaceID">the interface</param>
		public InterfaceNotFromComponentException(IComponentIdentifier aComponentID, IInterfaceIdentifier ifaceID) : 
			base( "Interface "+ifaceID+" not bound with component "+aComponentID+".")
		{
		}
	}
}