using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component cannot be deleted because it has incoming connections.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/06/04 01:54:00  sliver
	/// rework of composite component
	///
	/// Revision 1.1  2004/06/02 14:50:24  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentHasIncomingConnectionsException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component cannot be deleted because it has incoming connections.
		/// </summary>
		/// <param name="aComponent">Considered component.</param>
		public ComponentHasIncomingConnectionsException(Identifier.IIdentifier anID) : base( "Component " + anID.ToString() + " has incoming connections!")
		{
		}
	}
}