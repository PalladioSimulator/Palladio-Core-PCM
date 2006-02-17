using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Thrown, if a requested connection could not be found.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.2  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.1  2004/06/04 01:54:04  sliver
	/// rework of composite component
	///
	/// </pre>
	/// </remarks>
	public class ConnectionNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Thrown, if a requested connection could not be found.
		/// </summary>
		/// <param name="aRole">Considered role.</param>
		public ConnectionNotFoundException(IRole aRole) : base( "Connection for '" + aRole.ToString() + "' could not be found!")
		{
		}

		/// <summary>
		/// Thrown, if a requested connection could not be found.
		/// </summary>
		/// <param name="aComponentID">Considered component.</param>
		/// <param name="aRoleID">The attached role.</param>
		public ConnectionNotFoundException(Identifier.IIdentifier aComponentID, Identifier.IIdentifier aRoleID) : base( "Connection for '<" + aComponentID.ToString()+", "+ aRoleID.ToString() + ">' could not be found!")
		{
		}
	}
}