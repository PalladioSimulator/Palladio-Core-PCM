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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentHasOutgoingConnectionsException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component cannot be deleted because it has outgoing connections.
		/// </summary>
		/// <param name="anID">Considered component.</param>
		public ComponentHasOutgoingConnectionsException(Identifier.IIdentifier anID) : base( "Component " + anID.ToString() + " has outgoing connections!")
		{
		}
	}
}