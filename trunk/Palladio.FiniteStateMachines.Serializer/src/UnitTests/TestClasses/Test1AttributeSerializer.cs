using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FiniteStateMachines.UnitTests.TestClasses
{
	/// <summary>
	/// Attribute serializer plugin for testing purposes
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2005/09/08 07:24:23  joemal
	/// to be continued ...
	///
	/// Revision 1.6  2005/09/01 09:02:52  kelsaka
	/// - fixed bug: validating reader was not closed
	/// - added nunit project
	///
	/// Revision 1.5  2005/08/26 12:33:50  kelsaka
	/// - workaround for validation error
	///
	/// Revision 1.4  2005/08/26 09:45:27  kelsaka
	/// - validation fails
	///
	/// Revision 1.3  2005/08/25 09:41:20  kelsaka
	/// - prepared support for "test1" input serialization test
	///
	/// Revision 1.2  2005/08/22 08:46:33  kelsaka
	/// - added use of prefixes and namespaces to loader and writer
	///
	/// Revision 1.1  2005/08/21 18:07:42  kelsaka
	/// - added further tests
	///
	/// Revision 1.2  2005/08/21 10:05:01  kelsaka
	/// - REadded test cases
	///
	/// Revision 1.1  2005/08/15 09:53:20  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// </code>
	/// </remarks>
	public class Test1AttributeSerializer : IAttributeSerializerPlugin
	{
		private static IAttributeType[] SUPPORTED_TYPES = new IAttributeType[]{new Test1AttributeType()};

		/// <summary>
		/// Default.
		/// </summary>
		public Test1AttributeSerializer()
		{
			
		}

		/// <summary>
		/// Serializes the given attribute and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="attributeType">The attributes type to serialize. This information has be serialized
		/// as well.</param>
		/// <param name="attribute">The attribute to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing attributes.</param>
		public void SerializeAttribute (IAttributeType attributeType, IAttribute attribute, XmlWriter xmlWriter)
		{
			xmlWriter.WriteStartElement(this.XmlPrefix,"Value",this.XmlNamespace);
			WriteElementString(xmlWriter, "val", "1.765");
			WriteElementString(xmlWriter, "unit", "cm");
			xmlWriter.WriteEndElement();
		}

		//writes a full qualified element containing a string value
		private void WriteElementString(XmlWriter xmlWriter, string attributeName, string val)
		{
			xmlWriter.WriteStartElement(this.XmlPrefix,attributeName, this.XmlNamespace);
			xmlWriter.WriteString(val);
			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Deserializes the given xmlNode, that represents an <see cref="IAttribute"/>
		/// including an <see cref="IAttributeType"/>.
		/// </summary>
		/// <param name="xmlNode">The node to deserialize.</param>
		/// <returns>The deserialized attribute information.</returns>
		public AttributeInfo DeserializeAttribute (XmlNode xmlNode)
		{
/*			Test1AttributeType at = new Test1AttributeType();
			if (!xmlNode.Attributes.GetNamedItem(this.XmlPrefix+":displayName").Value.Equals(at.DisplayName))
			{
				throw new ModelSerializationException("displayName was incorrect or not found");
			}

			return new AttributeInfo(new Test1Attribute(), at);*/
			return new AttributeInfo();
		}

		/// <summary>
		/// The namespace of the IAttribute elements. (read)
		/// </summary>
		public string XmlNamespace
		{
			get
			{
				return "http://Test1-Namespace.com/attribute";
			}
		}

		/// <summary>
		/// The URI of the XSD-File that describes the XML-Scheme of the Plugin output. This XSD is used
		/// for validation. (read)
		/// </summary>
		public string XmlSchemaURI
		{
			get { return "Test1-attribute.xsd"; }
		}

		/// <summary>
		/// The prefix to identify XML elements written by the plugin.
		/// </summary>
		public string XmlPrefix
		{
			get { return "t1pre-Attrib"; }
		}

		/// <summary>
		/// called to return an array of supported attribute types
		/// </summary>
		public IAttributeType[] SupportedTypes
		{
			get
			{
				return Test1AttributeSerializer.SUPPORTED_TYPES;
			}
		}
	}
}
