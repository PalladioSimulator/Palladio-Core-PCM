using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// The AttachedInterface is invalid. This is the case, if the component associated 
	/// with the AttachedInterface is not contained in the surrounding CompositeComponent or
	/// if it does not provide the required role.
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
	/// Revision 1.3  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class InvalidRoleException : ComponentModelException
	{
		/// <summary>
		/// The AttachedInterface is invalid. This is the case, if the component associated 
		/// with the AttachedInterface is not contained in the surrounding CompositeComponent or
		/// if it does not provide the required role.
		/// </summary>
		public InvalidRoleException(IRole anInterface) : base( "Role " + anInterface + "is invalid!")
		{
		}
	}
}