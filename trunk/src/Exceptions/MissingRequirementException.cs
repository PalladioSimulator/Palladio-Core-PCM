using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the requirements of a service effect
	/// specification cannot be fulfilled by the RequiresInterfaces of
	/// the component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.1  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class MissingRequirementException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the requirements of a service effect
		/// specification cannot be fulfilled by the RequiresInterfaces of
		/// the component.
		/// </summary>
		/// <param name="aSig">Signature whichs requirements are missing.</param>
		public MissingRequirementException(ISignature aSig) : base( "Signature \"" + aSig + "\" is not in the component requirements!" )
		{
		}
	}
}