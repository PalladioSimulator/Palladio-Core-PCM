using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component is missing.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/06/04 01:54:01  sliver
	/// rework of composite component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.4  2004/05/23 19:00:07  sliver
	/// added comments
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
	public class ComponentNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component is missing.
		/// </summary>
		/// <param name="aComponent">The missing component.</param>
		public ComponentNotFoundException(Identifier.IIdentifier aComponentID) : 
			base( "Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ " could not be found!")
		{
		}
	}
}