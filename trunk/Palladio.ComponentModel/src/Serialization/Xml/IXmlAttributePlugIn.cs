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
	/// Revision 1.2  2005/05/19 18:07:19  joemal
	/// add parameter and attribute serialization
	///
	/// Revision 1.1  2005/05/08 12:02:17  joemal
	/// initial creation
	///
	/// </pre>
	/// </remarks>
	public interface IXmlAttributePlugIn:IXmlPlugIn
	{
		/// <summary>
		/// called by the serializer, when an attribute has to be loaded from given xml reader. The type of the attribute is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlReader">the xml reader</param>
		/// <returns>the attribute</returns>
		IAttribute LoadAttribute(XmlReader xmlReader);

		/// <summary>
		/// called by the serializer, when an attribute has to be saved to the given xmlwriter. The type of the attribute is
		/// one of the supported ones.
		/// </summary>
		/// <param name="xmlWriter">the xml writer</param>
		/// <param name="attribute">the attribute</param>
		void SaveAttribute(XmlWriter xmlWriter, IAttribute attribute);

		/// <summary>
		/// returns an array of supported attribute types
		/// </summary>
		IAttributeType[] SupportedTypes
		{
			get;
		}
	}
}
