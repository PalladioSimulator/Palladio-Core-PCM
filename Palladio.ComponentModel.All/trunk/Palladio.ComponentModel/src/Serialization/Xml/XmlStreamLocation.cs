using System.IO;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This location is used to load the componentmodel from or store it to a stream. The model is written 
	/// to or read from current position in the stream.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/25 16:44:38  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	public class XmlStreamLocation : ISerializationLocation
	{
		#region data
	
		//holds the stream
		private Stream stream;

		#endregion

		#region constructor

		/// <summary>
 		/// called to create a new xml stream location
		/// </summary>
		/// <param name="stream">the stream</param>
		public XmlStreamLocation(Stream stream)
		{
			this.stream = stream;
		}

		#endregion

		#region properties

		/// <summary>
		/// called to return  the stream
		/// </summary>
		public Stream Stream
		{
			get { return stream; }
		}

		#endregion
	}
}
