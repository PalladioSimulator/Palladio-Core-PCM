using System;

namespace Palladio.Serialization
{
	/// <summary>
	/// This exception is thrown by the serialization manager, when errors occur while opening a location to load or 
	/// store the model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/25 16:34:34  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class OpenLocationException : Exception
	{
		//holds the location
		private ISerializationLocation location;

		/// <summary>
		/// Create a new ModelSerializationException.
		/// </summary>
		/// <param name="location">the location that could not be opened</param>
		/// <param name="message">Message delivered by the exception.</param>
		/// <param name="cause">the exception that is the cause of this one</param>
		public OpenLocationException(ISerializationLocation location, string message, Exception cause) : base(message,cause)
		{
			this.location = location;
		}

		/// <summary>
		/// called to return the location that failed to be opened.
		/// </summary>
		public ISerializationLocation Location
		{
			get { return location; }
		}
	}
}
