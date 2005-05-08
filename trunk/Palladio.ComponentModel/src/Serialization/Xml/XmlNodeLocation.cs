using System.Xml;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This location is used to load the componentmodel from a xml reader or store it to a xml writer 
	/// at there current position.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/05/08 12:02:16  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public class XmlNodeLocation : ISerializationLocation
	{
		#region data
	
		//holds the xml writer
		private XmlWriter xmlWriter;

		//holds the xml reader
		private XmlReader xmlReader;

		#endregion

		#region constructor

		/// <summary>
 		/// called to create a new xml location
		/// </summary>
		/// <param name="xmlWriter">the writer</param>
		/// <param name="xmlReader">the reader</param>
		public XmlNodeLocation(XmlWriter xmlWriter, XmlReader xmlReader)
		{
			this.xmlWriter = xmlWriter;
			this.xmlReader = xmlReader;
		}

		#endregion

		#region properties

		/// <summary>
		/// returns the xmlwriter
		/// </summary>
		public XmlWriter XmlWriter
		{
			get { return xmlWriter; }
		}

		/// <summary>
		/// returns the xmlreader
		/// </summary>
		public XmlReader XmlReader
		{
			get { return xmlReader; }
		}

		#endregion
	}
}
