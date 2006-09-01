using System;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Basic exception type for all exceptions of Palladio.ComponentModel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.1  2004/05/19 07:48:39  sbecker
	/// Added more exceptions
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentModelException : Exception
	{
		/// <summary>
		/// Create a new ComponentModelException with a message.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		public ComponentModelException(string message) : base(message) {}

		/// <summary>
		/// Create a new ComponentModelException with a message and an innerException.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		/// <param name="innerException">Another exception.</param>
		public ComponentModelException(string message, Exception innerException) : base(message,innerException) {}
	}
}
