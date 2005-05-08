using System.IO;
using System.Xml;
using Palladio.Serialization;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// This location is used to load the componentmodel from or store it to a xml file. 
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
	public class XmlFileLocation : ISerializationLocation
	{
		#region data
	
		//holds the xml file
		private string file;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new xml location
		/// </summary>
		/// <param name="file">the xml file</param>
		public XmlFileLocation(string file)
		{
			this.file = file;
		}

		#endregion

		#region properties

		/// <summary>
		/// called to return the xml file
		/// </summary>
		public string XmlFile
		{
			get
			{
				return this.file;
			}
		}

		#endregion
	}
}
