using System;
using System.Xml;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer.Interfaces
{
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/09/08 07:24:23  joemal
	/// to be continued ...
	///
	/// Revision 1.3  2005/08/24 09:25:40  kelsaka
	/// - created serializer for the default input
	/// - added methods for the IInputSerializerPlugin
	///
	/// Revision 1.2  2005/08/21 15:34:54  kelsaka
	/// - completed handling of attributes (deserialisation)
	///
	/// Revision 1.1  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// </code>
	/// </remarks>
	public interface IInputSerializerPlugin
	{
		#region public methods

		/// <summary>
		/// Serializes the given input and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="input">The input to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing the input.</param>
		/// <remarks>The output is automatically surrounded by the calling class by a
		/// <code>&lt;input inputType="abcde"&gt;&lt;/input&gt;</code> Tag.</remarks>
		void SerializeInput(IInput input, XmlWriter xmlWriter);		

		/// <summary>
		/// Deserializes the given xmlNode, that represents an <see cref="IInput"/>.
		/// </summary>
		/// <param name="xmlNode">The node to deserialize, that contains the input
		/// xml element.</param>
		/// <returns>The deserialized input information.</returns>
		IInput DeserializeInput(XmlNode xmlNode);

		/// <summary>
		/// The namespace of the IInput elements. (read)
		/// </summary>
		string XmlNamespace { get; }

		/// <summary>
		/// The URI of the XSD-File that describes the XML-Scheme of the Plugin output. This XSD is used
		/// for validation. (read)
		/// </summary>
		string XmlSchemaURI { get; }

		/// <summary>
		/// The prefix to identify XML elements written by the plugin.
		/// </summary>
		string XmlPrefix { get; }

		/// <summary>
		/// called to return a list of supported ids of input types
		/// </summary>
		Guid[] SupportedInputTypes { get;}

		#endregion
	}
}
