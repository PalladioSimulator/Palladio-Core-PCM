using System;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// This exception is thrown if errors occur on loading or storing a FSM. 
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/18 09:30:47  kelsaka
	/// - extraced load and save into separate classes
	/// - started implementation of loading from xml
	///
	/// </code>
	/// </remarks>
	public class ModelSerializationException : ApplicationException
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
