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
	/// Revision 1.3  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.2  2004/06/04 01:54:02  sliver
	/// rework of composite component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
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
	public class HasOutgoingMappingException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component cannot be deleted because it has incoming connections.
		/// </summary>
		/// <param name="anID">An outgoing mapping of a component.</param>
		public HasOutgoingMappingException(Identifier.IIdentifier anID) : base(" ProvidesInterface '" + anID.ToString() + "' has still an outgoing mapping! \n")
		{
		}
	}
}