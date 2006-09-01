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
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
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
