using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component cannot be deleted because it has outgoing connections.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentHasOutgoingConnectionsException : ComponentModelException
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