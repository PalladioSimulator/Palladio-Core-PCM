using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component cannot be deleted because it has outgoing connections.
	/// </summary>
	public class ComponentHasOutgoingConnectionsException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that a component cannot be deleted because it has outgoing connections.
		/// </summary>
		/// <param name="aComponent">Considered component.</param>
		public ComponentHasOutgoingConnectionsException(IComponent aComponent) : base( "Component " + aComponent + " has outgoing connections!")
		{
		}
	}
}