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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
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