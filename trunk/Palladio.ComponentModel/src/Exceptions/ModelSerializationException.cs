using System;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// This exception is thrown by the serialization manager, when errors occur while store or load the model. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/24 19:15:26  joemal
	/// add serialization manager
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class ModelSerializationException : ComponentModelException
	{
		/// <summary>
		/// Create a new ModelSerializationException.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		/// <param name="cause">the exception that is the cause of this one</param>
		public ModelSerializationException(string message, Exception cause) : base(message,cause) {}
	}
}
