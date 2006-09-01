using System;

namespace Palladio.Serialization
{
	/// <summary>
	/// Error indicating, that a location from unknown type was used to load or store the componentmodel
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
	public class UnknownTypeException : Exception
	{
		//holds the location
		private ISerializationLocation location;

		/// <summary>
		/// Error indicating, that a location from unknown type was used to load or store the componentmodel
		/// </summary>
		/// <param name="location">the location with from unknown type</param>
		public UnknownTypeException(ISerializationLocation location) : 
			base( "Unknown type the given of location.")
		{
			this.location = location;
		}

		/// <summary>
		/// called to return the location 
		/// </summary>
		public ISerializationLocation Location
		{
			get { return location; }
		}
	}
}