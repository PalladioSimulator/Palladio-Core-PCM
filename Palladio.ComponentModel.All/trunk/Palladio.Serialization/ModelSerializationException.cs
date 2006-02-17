using System;

namespace Palladio.Serialization
{
	/// <summary>
	/// This exception is thrown by the serialization manager, when errors occur while store or load the model. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/24 16:51:49  joemal
	/// add second constructor
	///
	/// Revision 1.1  2005/04/25 16:34:34  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class ModelSerializationException : Exception
	{
		/// <summary>
		/// Create a new ModelSerializationException.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		/// <param name="cause">the exception that is the cause of this one</param>
		public ModelSerializationException(string message, Exception cause) : base(message,cause) {}

		/// <summary>
		/// Create a new ModelSerializationException.
		/// </summary>
		/// <param name="message">Message delivered by the exception.</param>
		public ModelSerializationException(string message) : base(message) {}
	}
}
