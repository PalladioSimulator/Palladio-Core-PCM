using Palladio.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature has no service effect specification as required.
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
	public class ServiceHasNoServEffSpecException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a signature has no service effect specification as required.
		/// </summary>
		/// <param name="aService">Service without service effect specification.</param>
		public ServiceHasNoServEffSpecException(IService aService) : base( "Service " + aService + " has no service effect specification!")
		{
		}

		public ServiceHasNoServEffSpecException(IIdentifier aServiceID) : base( "Service " + aServiceID + " has no service effect specification!")
		{
		}
	}
}