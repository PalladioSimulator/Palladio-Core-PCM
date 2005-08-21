using System.Xml;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer.Interfaces
{
	/// <summary>
	/// The interface of plugins that serialize <see cref="IAttribute"/>s. Such a plugin can be registered
	/// for a attribute type and is called to serialize the attribute.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.8  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
	///
	/// Revision 1.7  2005/08/21 13:58:17  kelsaka
	/// - added use of plugins for deserialisation
	///
	/// Revision 1.6  2005/08/19 16:11:38  kelsaka
	/// - added further deserialisation
	///
	/// Revision 1.5  2005/08/18 09:30:47  kelsaka
	/// - extraced load and save into separate classes
	/// - started implementation of loading from xml
	///
	/// Revision 1.4  2005/08/15 09:51:50  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// Revision 1.3  2005/08/15 07:59:24  kelsaka
	/// - added futher tests (including test classes)
	///
	/// Revision 1.2  2005/08/15 06:44:39  kelsaka
	/// - added handling for attribute serializer plugins
	///
	/// Revision 1.1  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// </code>
	/// </remarks>
	public interface IAttributeSerializerPlugin
	{
		#region public methods

		/// <summary>
		/// Serializes the given attribute and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="attributeType">The attributes type to serialize. This information has be serialized
		/// as well.</param>
		/// <param name="attribute">The attribute to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing attributes.</param>
		/// <remarks>The output is automatically surrounded by a
		/// <code>&lt;attribut attributeType="abcde"&gt;&lt;/attribut&gt;</code> Tag.</remarks>
		void SerializeAttribute(IAttributeType attributeType, IAttribute attribute, XmlWriter xmlWriter);
		
		/// <summary>
		/// Deserializes the given xmlNode, that represents an <see cref="IAttribute"/>
		/// including an <see cref="IAttributeType"/>.
		/// </summary>
		/// <param name="xmlNode">The node to deserialize.</param>
		/// <returns>The deserialized attribute information.</returns>
		AttributeInfo DeserializeAttribute(XmlNode xmlNode);

		/// <summary>
		/// The namespace of the IAttribute elements. (read)
		/// </summary>
		string XmlNamespace { get; }

		/// <summary>
		/// The URI of the XSD-File that describes the XML-Scheme of the Plugin output. This XSD is used
		/// for validation. (read)
		/// </summary>
		string XmlSchemaURI { get; }

		#endregion
	}
}
