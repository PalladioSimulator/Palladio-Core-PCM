using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component cannot be deleted because it has incoming connections.
	/// </summary>
	public class ComponentHasIncomingConnectionsException : ApplicationException
	{
		/// <summary>
		/// Error indicating, that a component cannot be deleted because it has incoming connections.
		/// </summary>
		/// <param name="aComponent">Considered component.</param>
		public ComponentHasIncomingConnectionsException(IComponent aComponent) : base( "Component " + aComponent + " has incoming connections!")
		{
		}
	}
}