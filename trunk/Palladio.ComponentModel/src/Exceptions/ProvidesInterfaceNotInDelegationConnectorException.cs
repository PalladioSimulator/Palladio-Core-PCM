namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the provides interface is not a role of the IDelegationConnector.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class ProvidesInterfaceNotInDelegationConnectorException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the provides interface is not a role of the IDelegationConnector.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		/// <param name="aDelegationConnector">DelegationConnector with the missing role.</param>
		public ProvidesInterfaceNotInDelegationConnectorException(string aRoleID, IDelegationConnector aDelegationConnector) : base( "Role " + aRoleID + " not found in " + aDelegationConnector + "!")
		{
		}
	}
}