using System.Xml;
using Palladio.Attributes;

namespace Palladio.ComponentModel.Serialization.Xml
{
	/// <summary>
	/// this interface defines a plugin for the xml serializer that can be used to load or store attributes of
	/// the componentmodels entities.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/05/08 12:02:17  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public interface IXmlAttributePlugIn:IXmlPlugIn
	{
		/// <summary>
		/// called by the serializer, when an attribute has to be loaded from given xml node. The type of the attribute is
		/// one of the supported ones.
		/// </summary>
		/// <param name="attributeNode">the xml node</param>
		/// <returns>the attribute</returns>
		IAttribute LoadAttribute(XmlNode attributeNode);

		/// <summary>
		/// called by the serializer, when an attribute has to be saved to the given xml node. The type of the attribute is
		/// one of the supported ones.
		/// </summary>
		/// <param name="attributeNode">the xml node</param>
		/// <param name="attribute">the attribute</param>
		void SaveProtocol(XmlNode attributeNode, IAttribute attribute);

		/// <summary>
		/// returns an array of supported attribute types
		/// </summary>
		IAttributeType[] SupportedTypes
		{
			get;
		}
	}
}
