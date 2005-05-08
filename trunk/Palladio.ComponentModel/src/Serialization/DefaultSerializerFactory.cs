using System.IO;
using System.Xml;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Serialization.Xml;

namespace Palladio.ComponentModel.Serialization
{
	/// <summary>
	/// This factory can be used to create serializers that are implemented in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/05/08 12:02:33  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public class DefaultSerializerFactory
	{
		/// <summary>
		/// call to create a new xml serializer. This serializer can be plugged with several plugins to load and store
		/// protocols and service effect specifications. To use this serializer add it to the serialization manager of the
		/// componentmodel.
		/// </summary>
		/// <param name="query">the query interface of the componentmodel</param>
		/// <param name="builderManager">the buildermanager of the componentmodel</param>
		/// <returns>the serializer</returns>
		public static IXmlSerializer CreateXMLSerializer(IQuery query, IBuilderManager builderManager)
		{
			return new XmlSerializer(query, builderManager);
		}

		/// <summary>
		/// called to create a new location that can be used to load the componentmodel from a xml reader or store it to a 
		/// xml writer. If the reader is set to null, the model can't be loaded, if the writer is null, it can't be stored. 
		/// This location is supported by the xml serializer that can be created by this factory.
		/// </summary>
		/// <param name="xmlWriter">the writer. If null, the location can not be used to store the model</param>
		/// <param name="xmlReader">the reader. If null, the location can not be used to load the model</param>
		/// <returns>the location</returns>
		public static XmlNodeLocation CreateXmlLocation(XmlWriter xmlWriter, XmlReader xmlReader)
		{
			return new XmlNodeLocation(xmlWriter,xmlReader);
		}

		/// <summary>
		/// called to create a new location that can be used to load the componentmodel from or store it to a xml file.
		/// This location is supported by the xml serializer that can be created by this factory.
		/// </summary>
		/// <param name="file">the xml file</param>
		/// <returns>the location</returns>
		public static XmlFileLocation CreateXmlLocation(string file)
		{
			return new XmlFileLocation(file);
		}
	}
}
