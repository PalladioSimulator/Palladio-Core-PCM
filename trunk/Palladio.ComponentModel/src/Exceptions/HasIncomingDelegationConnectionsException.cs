using System;
using System.Collections;
using Palladio.Utils.Collections;

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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class HasIncomingDelegationConnectorsException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component cannot be deleted because it has incoming connections.
		/// </summary>
		/// <param name="aReqRoleID">The role for which the DelegationConnector were queried.</param>
		public HasIncomingDelegationConnectorsException(Identifier.IIdentifier aReqRoleID) : base(" RequiresInterface '"+aReqRoleID+"' still has incoming DelegationConnectors!")
		{
		}
	}
}