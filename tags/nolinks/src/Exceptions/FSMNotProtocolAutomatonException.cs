using System;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Basic exception type for all exceptions of Palladio.FiniteStateMachines.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.2  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.1  2004/05/19 07:48:39  sbecker
	/// Added more exceptions
	///
	///
	/// </pre>
	/// </remarks>
	public class FSMNotProtocolAutomatonException : ComponentModelException
	{
		/// <summary>
		/// Create a new FSMNotProtocolAutomatonException with a message.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		public FSMNotProtocolAutomatonException(string message) : base (message) {}

		/// <summary>
		/// Create a new FSMNotProtocolAutomatonException with a message and an innerException.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		/// <param name="innerException">Another exception.</param>
		public FSMNotProtocolAutomatonException(string message, Exception innerException) : base (message,innerException) {}
	}
}
