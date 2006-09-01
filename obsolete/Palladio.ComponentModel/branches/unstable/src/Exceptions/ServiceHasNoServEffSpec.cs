using System;
using System.Collections;
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
	/// Revision 1.1.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.3  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
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