using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a signature has already a service effect specification and an other one is added.
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
	///
	/// </pre>
	/// </remarks>
	public class ServiceEffectAlreadySpecifiedException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a signature already has a service effect specification.
		/// </summary>
		/// <param name="aService">Signature with service effect specification.</param>
		public ServiceEffectAlreadySpecifiedException(IService aService) : base( "Service " + aService + " has already a service effect specification!")
		{
		}
	}
}